create table menu_component
(
    id                bigint not null
        primary key,
    visible           boolean,
    menu_component_id bigint
        constraint uk4itig31ugtgs2mdenp1y5aovv
            unique
        constraint fkjkclin9x8onq8439c9rqlx3i2
            references button
);

alter table menu_component
    owner to postgres;

INSERT INTO public.menu_component (id, visible, menu_component_id) VALUES (1, true, 1);
