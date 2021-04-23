ALTER TABLE "public"."itsm_news" ADD COLUMN modifier_name varchar(255) NULL;

ALTER TABLE "public"."news_setting" ADD COLUMN date_create timestamp NULL,
    ADD COLUMN author_login varchar(12) NULL,
    ADD COLUMN author_name varchar(255) NULL,
    ADD COLUMN date_modification timestamp NULL,
    ADD COLUMN modifier_login varchar(12) NULL,
    ADD COLUMN modifier_name varchar(255) NULL;