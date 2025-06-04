create table shop_column
(
    id        bigint not null
        primary key,
    text      varchar(255),
    url       varchar(255),
    footer_id bigint
        constraint fkh4s59e5s4u03qpoi31xtu7q8q
            references footer
);

alter table shop_column
    owner to postgres;

INSERT INTO public.shop_column (id, text, url, footer_id) VALUES (1, 'https://eshop.feit.uniza.sk', 'https://eshop.feit.uniza.sk', 1);
