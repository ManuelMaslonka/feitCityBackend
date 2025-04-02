create table logo_component
(
    id      bigint not null
        primary key,
    visible boolean
);

alter table logo_component
    owner to postgres;

INSERT INTO public.logo_component (id, visible) VALUES (1, true);
