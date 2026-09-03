-- Hibernate 6.6 + Postgres

create table precision_numeric_def (big_decimal numeric(10,1), big_integer numeric(10,1), double_primitive float(34), double_wrap float(34), float_primitive float(34), float_wrap float(34), id bigint not null, primary key (id));
create table precision_numeric_set (big_decimal numeric(38,2), big_integer numeric(38,0), double_primitive float(53), double_wrap float(53), float_primitive float4, float_wrap float4, id bigint not null, primary key (id));
create table precision_time_def (local_date date, local_time time(6), offset_time time(6), sql_date date, sql_time time(6), dt_instant timestamp(6) with time zone, id bigint not null, java_date timestamp(6), local_date_time timestamp(6), offset_date_time timestamp(6) with time zone, sql_timestamp timestamp(6), zoned_date_time timestamp(6) with time zone, primary key (id));
create table precision_time_set (local_date date, local_time time(6), offset_time time(6), sql_date date, sql_time time(6), dt_instant timestamp(6) with time zone, id bigint not null, java_date timestamp(6), local_date_time timestamp(6), offset_date_time timestamp(6) with time zone, sql_timestamp timestamp(6), zoned_date_time timestamp(6) with time zone, primary key (id));

-- Hibernate 7.2 + Postgres
create table precision_numeric_def (big_decimal numeric(10,1), big_integer numeric(10,1), double_primitive float(34), double_wrap float(34), float_primitive float(34), float_wrap float(34), id bigint not null, primary key (id));
create table precision_numeric_set (big_decimal numeric(38,2), big_integer numeric(38,0), double_primitive float(53), double_wrap float(53), float_primitive float4, float_wrap float4, id bigint not null, primary key (id));
create table precision_time_def (local_date date, local_time time(0), offset_time time(0), sql_date date, sql_time time(0), dt_instant timestamp(6) with time zone, id bigint not null, java_date timestamp(6), local_date_time timestamp(6), offset_date_time timestamp(6) with time zone, sql_timestamp timestamp(6), zoned_date_time timestamp(6) with time zone, primary key (id));
create table precision_time_set (local_date date, local_time time(0), offset_time time(0), sql_date date, sql_time time(0), dt_instant timestamp(6) with time zone, id bigint not null, java_date timestamp(6), local_date_time timestamp(6), offset_date_time timestamp(6) with time zone, sql_timestamp timestamp(6), zoned_date_time timestamp(6) with time zone, primary key (id));

--compare

create table precision_time_def (local_date date, local_time time(6), offset_time time(6), sql_date date, sql_time time(6), dt_instant timestamp(6) with time zone, id bigint not null, java_date timestamp(6), local_date_time timestamp(6), offset_date_time timestamp(6) with time zone, sql_timestamp timestamp(6), zoned_date_time timestamp(6) with time zone, primary key (id));
create table precision_time_def (local_date date, local_time time(0), offset_time time(0), sql_date date, sql_time time(0), dt_instant timestamp(6) with time zone, id bigint not null, java_date timestamp(6), local_date_time timestamp(6), offset_date_time timestamp(6) with time zone, sql_timestamp timestamp(6), zoned_date_time timestamp(6) with time zone, primary key (id));
