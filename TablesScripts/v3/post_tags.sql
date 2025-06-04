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

INSERT INTO public.post_tags (post_id, tag_id) VALUES (11, 9);
INSERT INTO public.post_tags (post_id, tag_id) VALUES (11, 10);
INSERT INTO public.post_tags (post_id, tag_id) VALUES (13, 11);
INSERT INTO public.post_tags (post_id, tag_id) VALUES (13, 12);
INSERT INTO public.post_tags (post_id, tag_id) VALUES (14, 13);
