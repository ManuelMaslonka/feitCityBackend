create table post_tags
(
    post_id bigint not null
        constraint fkkifam22p4s1nm3bkmp1igcn5w
            references posts,
    tag_id  bigint not null
        constraint fkm6cfovkyqvu5rlm6ahdx3eavj
            references tags
);

alter table post_tags
    owner to postgres;

INSERT INTO public.post_tags (post_id, tag_id) VALUES (5, 1);
INSERT INTO public.post_tags (post_id, tag_id) VALUES (5, 2);
INSERT INTO public.post_tags (post_id, tag_id) VALUES (5, 3);
INSERT INTO public.post_tags (post_id, tag_id) VALUES (6, 2);
INSERT INTO public.post_tags (post_id, tag_id) VALUES (7, 7);
INSERT INTO public.post_tags (post_id, tag_id) VALUES (7, 8);
INSERT INTO public.post_tags (post_id, tag_id) VALUES (7, 9);
