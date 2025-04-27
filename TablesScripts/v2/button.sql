create table button
(
    id   bigint not null
        primary key,
    text varchar(255),
    url  varchar(255)
);

alter table button
    owner to postgres;

INSERT INTO public.button (id, text, url) VALUES (1, 'Podaj Prihlášku', 'prihlaska');
