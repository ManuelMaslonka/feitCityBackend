create table faq_component
(
    id      bigint not null
        primary key,
    visible boolean
);

alter table faq_component
    owner to postgres;

INSERT INTO public.faq_component (id, visible) VALUES (1, true);
