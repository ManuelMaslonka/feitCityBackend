create table posts
(
    id             bigint generated by default as identity
        primary key,
    author         varchar(255),
    content        varchar(20000) not null,
    created_at     timestamp,
    main_image_url varchar(255),
    title          varchar(255)   not null
);

alter table posts
    owner to postgres;

INSERT INTO public.posts (id, author, content, created_at, main_image_url, title) VALUES (11, 'admin', '<h2>H1test<br>h1<br><br></h2><img src="http://localhost:8080/api/v1/images/2025/04/609b34d8-800a-45c9-a2a1-d287d414fa52.jpg"><h2><br><br></h2><p></p><hr><p></p><p></p><p></p><p>asdda<br><br></p>', '2025-04-15 11:11:53.589265', 'http://localhost:8080/api/v1/images/2025/04/25a6dbea-fbf3-48d0-b3b1-3dc04cef6240.jpg', 'Hello ');
INSERT INTO public.posts (id, author, content, created_at, main_image_url, title) VALUES (12, 'admin', '<h1>Haloo? </h1><p></p><p></p><p><strong>dasdasdas</strong></p><ol><li><p>adsadasdasdsa dsadad<br><br></p><hr><p>dasdasdasd<br><br></p><img src="http://localhost:8080/api/v1/images/2025/05/cc0a7308-fd6b-4a28-b0aa-94b3e7a3a2c2.jpeg"></li></ol>', '2025-05-15 13:50:41.559959', null, 'To to je prvy nadpis');
INSERT INTO public.posts (id, author, content, created_at, main_image_url, title) VALUES (13, 'test@test.com', '<pre><code>asdasdadasdasdasdsa</code></pre><p></p><h2>asdasd</h2><h2></h2><h2></h2><h2></h2><h2>sa</h2>', '2025-05-22 13:47:37.268091', 'http://localhost:8080/api/v1/images/2025/05/e311171b-e8a6-4276-b89d-ded1f00aa3a0.jpg', '3122313123131');
INSERT INTO public.posts (id, author, content, created_at, main_image_url, title) VALUES (14, 'test@test.com', '<p>hgzszszaza</p><p>bthbhbhbh</p><img src="http://localhost:8080/api/v1/images/2025/05/d0824c84-0677-4261-bb72-86559a8da3e8.jpg">', '2025-05-22 13:48:10.243511', 'http://localhost:8080/api/v1/images/2025/05/74fc7995-c011-49a9-9beb-ccd4c68169a9.jpg', '123');
