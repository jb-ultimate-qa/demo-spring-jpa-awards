USE mssql_awards;
    GO

CREATE SEQUENCE competition_seq START WITH 1 INCREMENT BY 50
    GO

CREATE TABLE award
(
    id        int          NOT NULL,
    year_     smallint     NOT NULL,
    title     varchar(255) NOT NULL,
    winner_id int,
    CONSTRAINT pk_award PRIMARY KEY (id)
)
    GO

CREATE TABLE competition
(
    id                bigint NOT NULL,
    title             varchar(255),
    competition_level smallint,
    referee_id        int,
    first_player_id   int,
    second_player_id  int,
    city              varchar(255),
    stadium           varchar(255),
    CONSTRAINT pk_competition PRIMARY KEY (id)
)
    GO

CREATE TABLE license
(
    id             bigint IDENTITY (1, 1) NOT NULL,
    license_number varchar(255),
    sn             int,
    descr          varchar(255),
    CONSTRAINT pk_license PRIMARY KEY (id)
)
    GO

CREATE TABLE player
(
    id         int NOT NULL,
    first_name varchar(255),
    rating     int,
    CONSTRAINT pk_player PRIMARY KEY (id)
)
    GO

CREATE TABLE player_sport_school
(
    player_id       int          NOT NULL,
    sport_school_id varchar(255) NOT NULL,
    CONSTRAINT pk_player_sport_school PRIMARY KEY (player_id, sport_school_id)
)
    GO

CREATE TABLE referee
(
    id         int NOT NULL,
    first_name varchar(255),
    license_id bigint,
    CONSTRAINT pk_referee PRIMARY KEY (id)
)
    GO

CREATE TABLE sport_school
(
    id    varchar(255) NOT NULL,
    title varchar(255),
    CONSTRAINT pk_sport_school PRIMARY KEY (id)
)
    GO

CREATE TABLE sport_school_rating
(
    school_id varchar(255) NOT NULL,
    rating    int          NOT NULL
)
    GO

ALTER TABLE referee
    ADD CONSTRAINT uc_referee_license UNIQUE (license_id)
    GO

ALTER TABLE award
    ADD CONSTRAINT FK_AWARD_ON_WINNER FOREIGN KEY (winner_id) REFERENCES player (id)
    GO

ALTER TABLE competition
    ADD CONSTRAINT FK_COMPETITION_ON_FIRST_PLAYER FOREIGN KEY (first_player_id) REFERENCES player (id)
    GO

ALTER TABLE competition
    ADD CONSTRAINT FK_COMPETITION_ON_REFEREE FOREIGN KEY (referee_id) REFERENCES referee (id)
    GO

ALTER TABLE competition
    ADD CONSTRAINT FK_COMPETITION_ON_SECOND_PLAYER FOREIGN KEY (second_player_id) REFERENCES player (id)
    GO

ALTER TABLE referee
    ADD CONSTRAINT FK_REFEREE_ON_LICENSE FOREIGN KEY (license_id) REFERENCES license (id)
    GO

ALTER TABLE player_sport_school
    ADD CONSTRAINT fk_plasposch_on_player FOREIGN KEY (player_id) REFERENCES player (id)
    GO

ALTER TABLE player_sport_school
    ADD CONSTRAINT fk_plasposch_on_sport_school FOREIGN KEY (sport_school_id) REFERENCES sport_school (id)
    GO

ALTER TABLE sport_school_rating
    ADD CONSTRAINT fk_sport_school_rating_on_sport_school FOREIGN KEY (school_id) REFERENCES sport_school (id)
    GO