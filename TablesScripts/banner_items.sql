create table banner_items
(
    id                  bigint not null
        primary key,
    description         varchar(255),
    icon                varchar(255),
    image_url           varchar(255),
    label               varchar(255),
    link                varchar(255),
    name_of_action      varchar(255),
    title               varchar(255),
    visible             boolean,
    other_activities_id bigint
        constraint fkgpsige1nqhannwai1k1dgrn3r
            references other_activities
);

alter table banner_items
    owner to postgres;

