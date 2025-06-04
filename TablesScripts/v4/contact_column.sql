create table contact_column
(
    id        bigint not null
        primary key,
    text      varchar(255),
    url       varchar(255),
    footer_id bigint
        constraint fkfb44po9q38n7dqkavcaumxn0x
            references footer
);

alter table contact_column
    owner to postgres;

INSERT INTO public.contact_column (id, text, url, footer_id) VALUES (1, 'studref@feit.uniza.sk', 'mailto:studref@feit.uniza.sk', 1);
INSERT INTO public.contact_column (id, text, url, footer_id) VALUES (2, '+421 41 5132064', 'tel:+421 41 5132064', 1);
