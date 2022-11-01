CREATE SEQUENCE ap.service_serviceid_seq;

CREATE TABLE ap.service (
    serviceid integer not null default nextval('ap.service_serviceid_seq'::regclass),
    name character varying collate pg_catalog."default" NOT NULL,
    workinghours character varying collate pg_catalog."default" NOT NULL,
    appointmentinterval integer not null,
    businessid integer,
    constraint fk_business FOREIGN KEY (businessid) references ap."business"(businessid),
    constraint pk_service PRIMARY KEY (serviceid)
);
