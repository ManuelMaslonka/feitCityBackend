create table logo_item
(
    id                bigint not null
        primary key,
    alt               varchar(255),
    image_url         varchar(255),
    logo_component_id bigint
        constraint fkqgb44t08bwhxj8p3qwby2sd8w
            references logo_component
);

alter table logo_item
    owner to postgres;

INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (1, 'GoodRequest', 'feitImages/loga/logo-goodrequest.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (2, 'SSE', 'feitImages/loga/logo-sse-180x92.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (3, 'SystemHouse Solutions', 'feitImages/loga/SystemHouse_Solutions_logo_stående_PMS.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (4, 'Brainit', 'feitImages/loga/Brainit-RGB-Black.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (5, 'RTVS', 'feitImages/loga/logo-rtvs-140x87.jpg', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (6, 'NXP', 'feitImages/loga/logo-nxp-180x71.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (7, 'GlobalLogic', 'feitImages/loga/logo-GlobalLogic-210x53.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (8, 'CH', 'feitImages/loga/ch-logo.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (9, 'Emtest', 'feitImages/loga/logo-emtest-190x61.jpg', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (10, 'EVPU', 'feitImages/loga/logo-evpu-210x91.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (11, 'ZaIT', 'feitImages/loga/logo-zaIT-170x85.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (12, 'Onsemi', 'feitImages/loga/logo-onsemi-255x90.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (13, 'Betamont', 'feitImages/loga/logo-betamont-255x33.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (14, 'SEPS', 'feitImages/loga/logo-seps-160x108.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (15, 'Orange', 'feitImages/loga/logo-orange-100x100.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (16, 'Bel', 'feitImages/loga/logo-bel-255x64.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (17, 'TV Raj', 'feitImages/loga/logo-tvRaj-115x115.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (18, 'Continental', 'feitImages/loga/logo-continental-255x46.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (19, 'TES', 'feitImages/loga/logo-tes-200x39.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (20, 'Siemens', 'feitImages/loga/logo-siemens.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (21, 'G832', 'feitImages/loga/g832-280x60.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (22, 'Deltech', 'feitImages/loga/deltech-1.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (23, 'RGB', 'feitImages/loga/logo_rgb-1.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (24, 'SSD', 'feitImages/loga/SSD_logo-198x98.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (25, 'Schaeffler', 'feitImages/loga/Schaeffler_green_cmyk.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (26, 'M2M', 'feitImages/loga/m2m.png', 1);
