CREATE TABLE license
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    license_number VARCHAR(255) NULL,
    sn             INT NULL,
    descr          VARCHAR(255) NULL,
    CONSTRAINT pk_license PRIMARY KEY (id)
);