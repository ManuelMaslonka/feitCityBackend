create table menu_item
(
    id                bigint not null
        primary key,
    text              varchar(255),
    url               varchar(255),
    menu_component_id bigint
        constraint fkoi9iyn9tlfviox2tk80asjdlw
            references menu_component
);

alter table menu_item
    owner to postgres;

INSERT INTO public.menu_item (id, text, url, menu_component_id) VALUES (7, '12331', '21312312321321', null);
INSERT INTO public.menu_item (id, text, url, menu_component_id) VALUES (1, 'O fakulte', '#ofakulte', 1);
INSERT INTO public.menu_item (id, text, url, menu_component_id) VALUES (2, 'Prečo na FEIT?', '#preco', 1);
INSERT INTO public.menu_item (id, text, url, menu_component_id) VALUES (3, 'Čo študovať?', '#costudovat', 1);
INSERT INTO public.menu_item (id, text, url, menu_component_id) VALUES (4, 'DOD', 'dod', 1);
INSERT INTO public.menu_item (id, text, url, menu_component_id) VALUES (5, 'FAQ', '#faq', 1);
