create table feit_story_component
(
    id      bigint not null
        primary key,
    title   varchar(255),
    visible boolean
);

alter table feit_story_component
    owner to postgres;

INSERT INTO public.feit_story_component (id, title, visible) VALUES (1, 'Napíš aj ty svoju #FEITstory', true);
