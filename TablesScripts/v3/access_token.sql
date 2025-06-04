create table access_token
(
    id         bigint not null
        primary key,
    expiration timestamp(6),
    token      text,
    user_id    bigint
);

alter table access_token
    owner to postgres;

INSERT INTO public.access_token (id, expiration, token, user_id) VALUES (33, '2025-05-21 20:19:05.832102', 'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIxMjNAMTIzLmNvbSIsImVtYWlsIjoiMTIzQDEyMy5jb20iLCJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwiaWF0IjoxNzQ3ODQyOTA1LCJleHAiOjE3NDc4NTE1NDV9.Dk2o6srYAXTWJYvvQWvWPclFRGxQEK2etJV_kNff7rFE-dHoBWDQJMCY_yjV-iXq', 2);
INSERT INTO public.access_token (id, expiration, token, user_id) VALUES (34, '2025-05-22 16:06:34.923636', 'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ0ZXN0QHRlc3QuY29tIiwiZW1haWwiOiJ0ZXN0QHRlc3QuY29tIiwicm9sZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlhdCI6MTc0NzkxNDE1NCwiZXhwIjoxNzQ3OTIyNzk0fQ.XOZ8LKG75ocr0Vc0jMPMEOhe60L54kPWOUuR5izKQpqQKp38y1dPyD664tPUpotQ', 1);
