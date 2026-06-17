drop schema if exists public cascade;
create schema public;

create sequence competition_seq start with 1 increment by 50;

create table award (
    id integer not null,
    winner_id integer,
    year_ smallint not null,
    title varchar(255) not null,
    primary key (id)
);

create table competition (
    competition_level smallint check (competition_level between 0 and 3),
    first_player_id integer,
    referee_id integer,
    second_player_id integer,
    id bigint not null,
    city varchar(255),
    stadium varchar(255),
    title varchar(255),
    primary key (id)
);

create table license (
    sn integer,
    id bigserial not null,
    descr varchar(255),
    license_number varchar(255),
    primary key (id)
);

create table player (
    id integer not null,
    rating integer,
    first_name varchar(255),
    primary key (id)
);

create table player_sport_school (
    player_id integer not null,
    sport_school_id varchar(255) not null,
    primary key (player_id, sport_school_id)
);

create table referee (
    id integer not null,
    license_id bigint unique,
    first_name varchar(255),
    primary key (id)
);

create table sport_school (
    id varchar(255) not null,
    title varchar(255),
    primary key (id)
);

CREATE TABLE sport_school_rating(
    school_id varchar(255) not null,
    rating integer not null
);

alter table if exists award
    add constraint fk_award_on_winner
    foreign key (winner_id)
    references player;

alter table if exists competition
    add constraint fk_competition_on_first_player
    foreign key (first_player_id)
    references player;

alter table if exists competition
    add constraint fk_competition_on_referee
    foreign key (referee_id)
    references referee;

alter table if exists competition
    add constraint fk_competition_on_second_player
    foreign key (second_player_id)
    references player;

alter table if exists player_sport_school
    add constraint fk_plasposch_on_sport_school
    foreign key (sport_school_id)
    references sport_school;

alter table if exists player_sport_school
    add constraint fk_plasposch_on_player
    foreign key (player_id)
    references player;

alter table if exists referee
    add constraint fk_referee_on_license
    foreign key (license_id)
    references license;

alter table if exists sport_school_rating
    add constraint fk_sport_school_rating_on_sport_school
    foreign key (school_id)
    references sport_school (id);