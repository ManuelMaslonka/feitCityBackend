create table dropdown_menu_item
(
    id                bigint not null
        primary key,
    text              varchar(255),
    url               varchar(255),
    menu_component_id bigint
        constraint fkd6v63l63a34efg4lfre9p6pig
            references menu_component
);

alter table dropdown_menu_item
    owner to postgres;

INSERT INTO public.dropdown_menu_item (id, text, url, menu_component_id) VALUES (1, 'Viac', '""', 1);
