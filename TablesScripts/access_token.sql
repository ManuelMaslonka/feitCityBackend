create table access_token
(
    id         bigint not null
        primary key,
    expiration timestamp(6),
    token      varchar(255),
    user_id    bigint
);

alter table access_token
    owner to postgres;

INSERT INTO public.access_token (id, expiration, token, user_id) VALUES (1, '2025-03-11 22:35:29.678633', 'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ0ZXN0QHRlc3QuY29tIiwiZW1haWwiOiJ0ZXN0QHRlc3QuY29tIiwicm9sZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9XSwiaWF0IjoxNzQxNzI4MDY1LCJleHAiOjE3NDE3Mjg5Mjl9.h2aAkftkBkH6ASDq3a42HCHO6wYe_kCBIR_liZHES_VIDDE2aej04qfnSJ_Xb_7P', null);
