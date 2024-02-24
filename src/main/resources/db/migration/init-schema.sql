CREATE TABLE category
(
    id              BIGINT       NOT NULL,
    created_at      datetime     NULL,
    last_updated_at datetime     NULL,
    status          SMALLINT     NULL,
    name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jt_instructor
(
    user_id BIGINT       NOT NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_jt_instructor PRIMARY KEY (user_id)
);

CREATE TABLE jt_mentor
(
    user_id           BIGINT NOT NULL,
    number_of_classes INT    NOT NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (user_id)
);

CREATE TABLE jt_tpa
(
    user_id BIGINT NOT NULL,
    rating  FLOAT  NOT NULL,
    CONSTRAINT pk_jt_tpa PRIMARY KEY (user_id)
);

CREATE TABLE jt_user
(
    id    BIGINT       NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE msc_instructor
(
    id      BIGINT       NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_msc_instructor PRIMARY KEY (id)
);

CREATE TABLE msc_mentor
(
    id                BIGINT       NOT NULL,
    name              VARCHAR(255) NULL,
    email             VARCHAR(255) NULL,
    number_of_classes INT          NOT NULL,
    CONSTRAINT pk_msc_mentor PRIMARY KEY (id)
);

CREATE TABLE msc_tpa
(
    id     BIGINT       NOT NULL,
    name   VARCHAR(255) NULL,
    email  VARCHAR(255) NULL,
    rating FLOAT        NOT NULL,
    CONSTRAINT pk_msc_tpa PRIMARY KEY (id)
);

CREATE TABLE new_table
(
    id              BIGINT   NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    status          SMALLINT NULL,
    CONSTRAINT pk_newtable PRIMARY KEY (id)
);

CREATE TABLE product
(
    id              BIGINT       NOT NULL,
    created_at      datetime     NULL,
    last_updated_at datetime     NULL,
    status          SMALLINT     NULL,
    title           VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    image_url       VARCHAR(255) NULL,
    price           DOUBLE       NULL,
    category_id     BIGINT       NULL,
    is_special      BIT(1)       NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_user
(
    id                BIGINT       NOT NULL,
    user_type         INT          NULL,
    name              VARCHAR(255) NULL,
    email             VARCHAR(255) NULL,
    rating            FLOAT        NOT NULL,
    number_of_classes INT          NOT NULL,
    company           VARCHAR(255) NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id      BIGINT       NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id                BIGINT       NOT NULL,
    name              VARCHAR(255) NULL,
    email             VARCHAR(255) NULL,
    number_of_classes INT          NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_tpa
(
    id     BIGINT       NOT NULL,
    name   VARCHAR(255) NULL,
    email  VARCHAR(255) NULL,
    rating FLOAT        NOT NULL,
    CONSTRAINT pk_tpc_tpa PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id    BIGINT       NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE jt_instructor
    ADD CONSTRAINT FK_JT_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE jt_tpa
    ADD CONSTRAINT FK_JT_TPA_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);