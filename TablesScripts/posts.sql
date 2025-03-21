create table posts
(
    id         bigint       not null
        primary key,
    content    varchar(255) not null,
    title      varchar(255) not null,
    author     varchar(255),
    created_at bigint,
    main_image bytea
);

alter table posts
    owner to postgres;

