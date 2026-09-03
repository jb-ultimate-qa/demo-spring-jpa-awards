CREATE TABLE precision_time_def
(
    id               BIGINT NOT NULL,
    sql_date         date,
    local_date       date,
    sql_time         time WITHOUT TIME ZONE,
    local_time       time(9) WITHOUT TIME ZONE,
    offset_time      time(9) WITHOUT TIME ZONE,
    java_date        TIMESTAMP(6) WITHOUT TIME ZONE,
    sql_timestamp    TIMESTAMP(9) WITHOUT TIME ZONE,
    dt_instant       TIMESTAMP(9) WITHOUT TIME ZONE,
    local_date_time  TIMESTAMP(9) WITHOUT TIME ZONE,
    offset_date_time TIMESTAMP(9) WITH TIME ZONE,
    zoned_date_time  TIMESTAMP(9) WITH TIME ZONE,
    CONSTRAINT pk_precision_time_def PRIMARY KEY (id)
);