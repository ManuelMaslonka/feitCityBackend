create table post_tags
(
    post_id bigint not null
        constraint fkkifam22p4s1nm3bkmp1igcn5w
            references posts,
    tags    varchar(255)
);

alter table post_tags
    owner to postgres;

