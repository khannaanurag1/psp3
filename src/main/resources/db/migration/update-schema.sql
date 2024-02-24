CREATE TABLE tab
(
    id              BIGINT   NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    status          SMALLINT NULL,
    CONSTRAINT pk_tab PRIMARY KEY (id)
);