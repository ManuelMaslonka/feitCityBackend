create table drop_down_menu_items
(
    id                    bigint not null
        primary key,
    text                  varchar(255),
    url                   varchar(255),
    dropdown_menu_item_id bigint
        constraint fkkkucnrnu5svuwqyikkewp57wf
            references dropdown_menu_item
);

alter table drop_down_menu_items
    owner to postgres;

INSERT INTO public.drop_down_menu_items (id, text, url, dropdown_menu_item_id) VALUES (1, 'Študentský život', '#zivot', 1);
INSERT INTO public.drop_down_menu_items (id, text, url, dropdown_menu_item_id) VALUES (2, 'Kam po škole ?', '#poskole', 1);
INSERT INTO public.drop_down_menu_items (id, text, url, dropdown_menu_item_id) VALUES (3, 'Špeciálne cvičenia', 'https://www.feitcity.sk/specialne-cvicenia/', 1);
INSERT INTO public.drop_down_menu_items (id, text, url, dropdown_menu_item_id) VALUES (4, 'FEITstory', '#feitstory', 1);
INSERT INTO public.drop_down_menu_items (id, text, url, dropdown_menu_item_id) VALUES (5, 'Technická myšlienka roka', 'https://feit.uniza.sk/tmr/', 1);
INSERT INTO public.drop_down_menu_items (id, text, url, dropdown_menu_item_id) VALUES (6, 'Blog', 'https://www.feitcity.sk/blog/', 1);
INSERT INTO public.drop_down_menu_items (id, text, url, dropdown_menu_item_id) VALUES (7, 'Kontakt', '#kontakt', 1);
INSERT INTO public.drop_down_menu_items (id, text, url, dropdown_menu_item_id) VALUES (8, '123', '2132131312', null);
