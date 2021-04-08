create sequence general_seq
    start with 100;

    CREATE TABLE public.itsm_new
(
    id bigint NOT NULL,
    autor_login character varying,
    autor_name character varying,
    PRIMARY KEY (id)
);

ALTER TABLE public.itsm_new
    OWNER to dn100395jsv1;