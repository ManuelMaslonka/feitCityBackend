create table slider_item
(
    id                  bigint generated by default as identity
        primary key,
    description         varchar(255),
    icons_style         varchar(255),
    image_url           varchar(255),
    info_description    varchar(255),
    label               varchar(255),
    title               varchar(255),
    video_url           varchar(255),
    slider_component_id bigint
        constraint fkmyo1el89d2quwqem9vimyajev
            references slider_component
);

alter table slider_item
    owner to postgres;

INSERT INTO public.slider_item (id, description, icons_style, image_url, info_description, label, title, video_url, slider_component_id) VALUES (3, 'Večierok pre študentov a učiteľov', 'line-icon-Dress text-white icon-extra-large', 'feitImages/ples.jpg', 'FEIT GROUP', 'Tanečky', 'Fakultný ples', 'https://www.youtube.com/watch?v=oaTHZJ61fOk?', 1);
INSERT INTO public.slider_item (id, description, icons_style, image_url, info_description, label, title, video_url, slider_component_id) VALUES (1, 'Sedem stravovacích zariadení', 'line-icon-Fish-Food text-white icon-extra-large', 'feitImages/jedlo.jpg', 'Raňajky, obedy, večere', 'Jedlo', 'Je niekto hladný?', 'https://www.youtube.com/watch?v=466ItS1f36o?', 1);
INSERT INTO public.slider_item (id, description, icons_style, image_url, info_description, label, title, video_url, slider_component_id) VALUES (2, 'Moderný atletický štadión', 'line-icon-Sports-Shirt text-white icon-extra-large', 'feitImages/sporty.jpg', 'A množsto iných športovísk', 'Šport', 'UNIZA ponúka široké možnosti pre šport', 'https://www.youtube.com/watch?v=Wf8ASopiKUo?', 1);
INSERT INTO public.slider_item (id, description, icons_style, image_url, info_description, label, title, video_url, slider_component_id) VALUES (6, 'E-sportový festival', 'line-icon-Gamepad-2 text-white icon-extra-large', 'feitImages/unizamasters.jpg', 'Finálové súboje na UNIZA', 'e-sport', 'UNIZA MASTERS', 'https://www.youtube.com/watch?v=P-hJ438W5SQ?', 1);
INSERT INTO public.slider_item (id, description, icons_style, image_url, info_description, label, title, video_url, slider_component_id) VALUES (7, '2396 ubytovacích miest', 'line-icon-Hotel text-white icon-extra-large', 'feitImages/intraky.jpg', '10 minút pešo do školy', 'Intraky', 'Univerzitné mestečko', 'https://www.youtube.com/watch?v=B1O_7Hk5JJ8', 1);
INSERT INTO public.slider_item (id, description, icons_style, image_url, info_description, label, title, video_url, slider_component_id) VALUES (5, 'Pre športovcov aj nešportovcov', 'line-icon-Sports-Clothings1 text-white icon-extra-large', 'feitImages/hry.jpg', 'Super akcia nie len o športe', 'Športový deň', 'Jarné hry', 'https://www.youtube.com/watch?v=xNRyRMxTpP8?', 1);
INSERT INTO public.slider_item (id, description, icons_style, image_url, info_description, label, title, video_url, slider_component_id) VALUES (4, 'Vianočný Najlepší punč od FEIT študentov', 'line-icon-Coffee text-white icon-extra-large', 'feitImages/punc.jpg', 'Každý rok pred fakultou', 'Voľná zábava', 'Vianočný punč', 'https://www.youtube.com/watch?v=LM2T3RYD9cE?', 1);
