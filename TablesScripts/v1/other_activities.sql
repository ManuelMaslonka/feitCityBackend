create table other_activities
(
    id      bigint not null
        primary key,
    label   varchar(255),
    title   varchar(255),
    visible boolean
);

alter table other_activities
    owner to postgres;

INSERT INTO public.other_activities (id, label, title, visible) VALUES (1, 'Ďalšie aktivity', 'Chceš vedieť viac?', true);
