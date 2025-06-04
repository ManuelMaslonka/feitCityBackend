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

INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (1, null, 'feitImages/loga/logo-goodrequest.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (2, null, 'feitImages/loga/logo-sse-180x92.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (3, null, 'feitImages/loga/SystemHouse_Solutions_logo_stående_PMS.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (4, null, 'feitImages/loga/Brainit-RGB-Black.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (5, null, 'feitImages/loga/logo-rtvs-140x87.jpg', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (6, null, 'feitImages/loga/logo-nxp-180x71.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (7, null, 'feitImages/loga/logo-GlobalLogic-210x53.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (8, null, 'feitImages/loga/ch-logo.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (9, null, 'feitImages/loga/logo-emtest-190x61.jpg', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (10, null, 'feitImages/loga/logo-evpu-210x91.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (11, null, 'feitImages/loga/logo-zaIT-170x85.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (12, null, 'feitImages/loga/logo-onsemi-255x90.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (13, null, 'feitImages/loga/logo-betamont-255x33.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (14, null, 'feitImages/loga/logo-seps-160x108.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (15, null, 'feitImages/loga/logo-orange-100x100.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (16, null, 'feitImages/loga/logo-bel-255x64.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (17, null, 'feitImages/loga/logo-tvRaj-115x115.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (18, null, 'feitImages/loga/logo-continental-255x46.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (19, null, 'feitImages/loga/logo-tes-200x39.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (20, null, 'feitImages/loga/logo-siemens.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (21, null, 'feitImages/loga/g832-280x60.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (22, null, 'feitImages/loga/deltech-1.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (23, null, 'feitImages/loga/logo_rgb-1.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (24, null, 'feitImages/loga/SSD_logo-198x98.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (25, null, 'feitImages/loga/Schaeffler_green_cmyk.png', 1);
INSERT INTO public.logo_item (id, alt, image_url, logo_component_id) VALUES (26, null, 'feitImages/loga/m2m.png', 1);
