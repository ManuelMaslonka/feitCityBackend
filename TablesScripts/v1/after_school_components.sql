create table after_school_components
(
    id          bigint not null
        primary key,
    description text,
    image_url   varchar(255),
    image_url_1 varchar(255),
    label       varchar(255),
    title       varchar(255),
    visible     boolean
);

alter table after_school_components
    owner to postgres;

INSERT INTO public.after_school_components (id, description, image_url, image_url_1, label, title, visible) VALUES (1, 'Podľa aktuálneho rebríčka záujmu zamestnávateľov o absolventov vysokých škôl, je Fakulta elektrotechniky a informačných technológií dlhodobo na popredných pozíciách. Už popri štúdiu môžeš absolvovať aj platené stáže v TOP firmách v rámci regiónu, ale aj v zahraničí. Nižšie sú najväčší zamestnávatelia našich absolventov a zároveň partneri fakulty.', 'feitImages/kam1.jpg', 'feitImages/kam2.jpg', 'Zamestnanie', 'Kam po škole?', false);
