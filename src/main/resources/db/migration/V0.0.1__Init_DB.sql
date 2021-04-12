create sequence general_news_seq;
create sequence general_news_comment_seq;
create sequence general_news_setting_seq;

CREATE TABLE "public"."itsm_news" (
	id bigint PRIMARY KEY NOT NULL,
	source              varchar(5),
	author_login        varchar(12),
	modifier_login      varchar(12),
	author_name         varchar(255),
	description         varchar(1500),
    information         varchar(4000),
    recommendation      varchar(1500),
    setting_id          bigint,
	date_create 	    timestamp,
	date_modification	timestamp,
	publication_date    timestamp,
	end_date            timestamp,
	status              boolean
);

CREATE TABLE "public"."news_work_groups" (
    news_id bigint NOT NULL,
    workgroup_oid bigint
);
ALTER TABLE "public"."news_work_groups"
ADD CONSTRAINT fkak5sl9rw5frjnbu8bou1ao9pt
FOREIGN KEY (news_id)
REFERENCES "public"."itsm_news"(id)
;

CREATE TABLE "public"."news_comment"(
    id bigint PRIMARY KEY NOT NULL,
    comment varchar (1000) NULL,
    news_id bigint,
    author_login varchar (12) NULL,
    author_name     varchar(255) NULL,
    date_create 	timestamp NULL
);
ALTER TABLE "public"."news_comment"
ADD CONSTRAINT fkqc4w9n3k7w7o0t53g4krl7idx
FOREIGN KEY (news_id)
REFERENCES "public"."itsm_news"(id)
;

CREATE TABLE "public"."news_setting"(
    id bigint PRIMARY KEY NOT NULL,
    name varchar (255),
    parent_login varchar (12),
    position varchar (10),
    status boolean
);
ALTER TABLE "public"."itsm_news"
ADD CONSTRAINT fk8gmamh51mhit8t8kachop2qx
FOREIGN KEY (setting_id)
REFERENCES "public"."news_setting"(id)
;

CREATE TABLE "public"."news_setting_roles"(
    setting_id bigint NOT NULL,
    roles varchar (5)
);
ALTER TABLE "public"."news_setting_roles"
ADD CONSTRAINT fk1v7vfi0gnhwxotsjyyqe6icvy
FOREIGN KEY (setting_id)
REFERENCES "public"."news_setting"(id)
;
