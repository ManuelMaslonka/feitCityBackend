create table social_column
(
    id        bigint not null
        primary key,
    icon      varchar(255),
    text      varchar(255),
    url       varchar(255),
    footer_id bigint
        constraint fkjmonm0al4tmfsfil7ymcwmh6n
            references footer
);

alter table social_column
    owner to postgres;

INSERT INTO public.social_column (id, icon, text, url, footer_id) VALUES (1, 'fa-facebook-f', 'facebook', 'https://facebook.com/feit.uniza.sk', 1);
INSERT INTO public.social_column (id, icon, text, url, footer_id) VALUES (2, 'fa-instagram', 'instagram', 'https://instagram.com/feit_uniza', 1);
INSERT INTO public.social_column (id, icon, text, url, footer_id) VALUES (3, 'fa-tiktok', 'tiktok', 'https://tiktok.com/@feit_uniza', 1);
INSERT INTO public.social_column (id, icon, text, url, footer_id) VALUES (4, 'fa-discord', 'discord', 'https://discord.com/invite/akzn6tQ9tt', 1);
INSERT INTO public.social_column (id, icon, text, url, footer_id) VALUES (5, 'fa-youtube', 'youtube', 'https://www.youtube.com/@feitcityuniza3522/videos', 1);
