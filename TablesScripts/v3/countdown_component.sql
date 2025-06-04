create table countdown_component
(
    id               bigint not null
        primary key,
    application_text varchar(255),
    end_date         timestamp(6),
    visible          boolean
);

alter table countdown_component
    owner to postgres;

INSERT INTO public.countdown_component (id, application_text, end_date, visible) VALUES (1, 'Zostavajúci čas pre podanie prihlášky', '2030-06-30 23:59:59.000000', true);
