CREATE SEQUENCE ap.business_businessid_seq;

CREATE TABLE ap.business(
    businessid integer not null default nextval('ap.business_businessid_seq'::regclass),
    name character varying collate pg_catalog."default" NOT NULL,
    userid integer,
    CONSTRAINT fk_user FOREIGN KEY (userid) references ap."user"(userid),
    constraint business_pkey primary key (businessid)
);
