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

INSERT INTO public.access_token (id, expiration, token, user_id) VALUES (46, '2025-06-04 19:16:57.884159', 'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ0ZXN3dEB0ZXN0LmNvbSIsImVtYWlsIjoidGVzd3RAdGVzdC5jb20iLCJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwibmFtZSI6InRlczIxM3QiLCJpYXQiOjE3NDkwMjg2MTcsImV4cCI6MTc0OTA1NzQxN30.TEoVc3kHvEkz55EPxuUU4oFmeZmGYeEm9T0FIdrZPFBtaCWw7yeb8PTUdy0yEUDw', 5);
