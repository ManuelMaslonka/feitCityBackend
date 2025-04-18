create table footer
(
    id bigint not null
        primary key
);

alter table footer
    owner to postgres;

INSERT INTO public.footer (id) VALUES (1);
