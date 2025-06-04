create table navigation_column
(
    id        bigint not null
        primary key,
    text      varchar(255),
    url       varchar(255),
    footer_id bigint
        constraint fka5789idt70a9dyx6025qmwp2m
            references footer
);

alter table navigation_column
    owner to postgres;

INSERT INTO public.navigation_column (id, text, url, footer_id) VALUES (1, 'Home', '#', 1);
INSERT INTO public.navigation_column (id, text, url, footer_id) VALUES (2, 'Čo študovať?', '#costudovat', 1);
INSERT INTO public.navigation_column (id, text, url, footer_id) VALUES (3, 'Prečo na FEIT?', '#preco', 1);
INSERT INTO public.navigation_column (id, text, url, footer_id) VALUES (4, 'Študentský život', '#zivot', 1);
