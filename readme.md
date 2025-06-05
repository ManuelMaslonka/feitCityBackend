# FaithCity / Faculty Blog Backend

Tento projekt predstavuje backend aplikáciu postavenú na **Spring Boot (Java 21)**. Aplikácia poskytuje REST API pre:

- dynamickú verziu pôvodne statickej stránky [Feitcity.sk](https://feitcity.sk)
- blogový systém *Faculty* určený pre Fakulta elektrotechniky a informačných technológií (FEIT) na Žilinskej univerzite v Žiline (UNIZA)

## Funkcionalita

- Poskytovanie dát pre dynamický frontend (napr. články, kategórie, autori)
- CRUD operácie pre správu obsahu blogu
- Autentifikácia/autorizácia pomocou JWT tokenu
- Pripojenie k databáze PostgreSQL

## Požiadavky

- Java 21+
- PostgreSQL

## Konfigurácia

Všetky potrebné nastavenia (napr. databáza, port, autentifikácia) sa konfigurujú cez súbor `application.yml`, ktorý sa nachádza v adresári:


## 🖥️ Teoretické nasadenie na čistý Linuxový server (bez Docker/Kubernetes)

### ✅ Inštalácia Java 21

```bash
sudo apt update
sudo apt install openjdk-21-jdk -y
```

```bash
java -version
```

### ✅ Inštalácia PostgreSQL

```bash
sudo apt install postgresql postgresql-contrib -y
```

```bash
sudo systemctl enable postgresql
sudo systemctl start postgresql
```

```bash
sudo -u postgres psql
```

```sql
CREATE DATABASE faithcity;
CREATE USER faithuser WITH PASSWORD 'secret';
GRANT ALL PRIVILEGES ON DATABASE faithcity TO faithuser;
\q
```

### ✅ Príprava aplikácie

Build na lokálnom stroji:

```bash
./mvnw clean package -DskipTests
```

Kópia na server:

```bash
scp target/faithcity-backend-0.0.1-SNAPSHOT.jar user@your-server:/home/user/app/
```

Na serveri vytvor adresár (ak neexistuje):

```bash
mkdir -p /home/user/app
```

Pridaj konfiguračný súbor `application.yaml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgres # Pripojenie na PostgreSQL databázu (host, port, názov databázy)
    username: postgres                              # Meno databázového používateľa
    password: postgres                              # Heslo databázového používateľa
    driver-class-name: org.postgresql.Driver        # JDBC driver pre PostgreSQL

  jpa:
    hibernate:
      ddl-auto: update               # Automatické úpravy schémy databázy podľa entít (nevhodné pre produkciu – tam použi 'validate' alebo migračný nástroj)
    show-sql: true                   # Zobrazovanie SQL príkazov v konzole počas behu aplikácie
    properties:
      hibernate:
        format_sql: true            # Formátovanie SQL výstupu pre lepšiu čitateľnosť v logoch
    database: postgresql
    generate-ddl: true

  servlet:
    multipart:
      max-file-size: 10MB            # Maximálna veľkosť jedného nahrávaného súboru
      max-request-size: 10MB         # Maximálna veľkosť celej HTTP požiadavky (ak obsahuje viacero súborov)

application:
  name: FeitUniza                    # Názov aplikácie – môže byť využitý napr. v logovaní alebo ako profil v monitoring systémoch

  security:
    enable: true                     # Zapnutie bezpečnostných mechanizmov (napr. autentifikácia)
    jwt:
      secret-key: "f45666c0d61ee85f12c95767f3c27ae4c08711387ada21ab3ba6828a133dd278" # Tajný kľúč pre podpisovanie JWT tokenov (!!! nenechávať verejne !!!)
      expiration: "28800000"         # Expirácia JWT tokenu – v milisekundách (8 hodín)

  url:
    base-url: "http://localhost:8080/" # Základná URL adresa backendu
    api-url: "api/v1/"                 # Prefix pre REST API endpointy (napr. /api/v1/articles)

  image:
    base-url: "images/"               # Relatívna cesta pre obrázky – použité pri generovaní URL k uploadnutým obrázkom

```

### ✅ Vytvorenie systemd služby

```bash
sudo nano /etc/systemd/system/faithcity.service
```

```ini
[Unit]
Description=FaithCity Blog Backend
After=network.target

[Service]
User=your-linux-user
ExecStart=/usr/bin/java -jar /home/your-linux-user/app/faithcity-backend-0.0.1-SNAPSHOT.jar --spring.config.location=/home/your-linux-user/app/application.yaml
WorkingDirectory=/home/your-linux-user/app
Restart=always
Environment=SPRING_PROFILES_ACTIVE=prod

[Install]
WantedBy=multi-user.target
```

```bash
sudo systemctl daemon-reload
sudo systemctl enable faithcity
sudo systemctl start faithcity
```

```bash
sudo systemctl status faithcity
```

### ✅ Povolenie portu 8080 vo firewalle (ak beží UFW)

```bash
sudo ufw allow 8080
sudo ufw reload
```

Aplikácia bude dostupná na:

```
http://your-server-ip:8080/
```
