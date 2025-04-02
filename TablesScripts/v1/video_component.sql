create table video_component
(
    id          bigint not null
        primary key,
    description varchar(255),
    title       varchar(255),
    video_url   varchar(255),
    visible     boolean
);

alter table video_component
    owner to postgres;

INSERT INTO public.video_component (id, description, title, video_url, visible) VALUES (1, 'Sme moderná fakulta s viac než 70-ročnou históriou. Poskytujeme vzdelávanie v 22 akreditovaných študijných programoch v troch stupňoch štúdia.', e'Fakulta elektrotechniky
                                        a informačných technológií', 'https://www.youtube.com/watch?v=k8cmcQF-CNo', true);
