CREATE SEQUENCE ap.appointment_appointmentid_seq;

CREATE TABLE ap.appointment (
    appointmentid integer not null default nextval('ap.appointment_appointmentid_seq'::regclass),
    userid integer,
    serviceid integer,
    apdate timestamp not null,
    CONSTRAINT fk_user FOREIGN KEY (userid) references ap.user(userid),
    CONSTRAINT fk_service FOREIGN KEY (serviceid) references ap.service(serviceid),
    CONSTRAINT pk_appointment PRIMARY KEY (appointmentid)
);
