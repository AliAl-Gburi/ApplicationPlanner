CREATE SEQUENCE ap.user_userid_seq;

CREATE TABLE ap.user (
    userid integer not null default nextval('ap.user_userid_seq'::regclass),
    email character varying collate pg_catalog."default" not null,
    password character varying not null,
    username character varying not null,
    profile_pic_path CHARACTER VARYING COLLATE pg_catalog."default",
    constraint user_pkey primary key (userid)
);
