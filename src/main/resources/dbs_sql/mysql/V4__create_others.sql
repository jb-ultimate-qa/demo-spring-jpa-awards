CREATE TABLE award
(
    id        INT          NOT NULL,
    year_     SMALLINT     NOT NULL,
    title     VARCHAR(255) NOT NULL,
    winner_id INT NULL,
    CONSTRAINT pk_award PRIMARY KEY (id)
);

CREATE TABLE competition
(
    id                BIGINT NOT NULL,
    title             VARCHAR(255) NULL,
    competition_level SMALLINT NULL,
    referee_id        INT NULL,
    first_player_id   INT NULL,
    second_player_id  INT NULL,
    city              VARCHAR(255) NULL,
    stadium           VARCHAR(255) NULL,
    CONSTRAINT pk_competition PRIMARY KEY (id)
);

CREATE TABLE player
(
    id         INT NOT NULL,
    first_name VARCHAR(255) NULL,
    rating     INT NULL,
    CONSTRAINT pk_player PRIMARY KEY (id)
);

CREATE TABLE player_sport_school
(
    player_id       INT          NOT NULL,
    sport_school_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_player_sport_school PRIMARY KEY (player_id, sport_school_id)
);

CREATE TABLE referee
(
    id         INT NOT NULL,
    first_name VARCHAR(255) NULL,
    license_id BIGINT NULL,
    CONSTRAINT pk_referee PRIMARY KEY (id)
);

CREATE TABLE sport_school
(
    id    VARCHAR(255) NOT NULL,
    title VARCHAR(255) NULL,
    CONSTRAINT pk_sport_school PRIMARY KEY (id)
);

CREATE TABLE sport_school_rating
(
    school_id VARCHAR(255) NOT NULL,
    rating    INT          NOT NULL
);

ALTER TABLE referee
    ADD CONSTRAINT uc_referee_license UNIQUE (license_id);

ALTER TABLE award
    ADD CONSTRAINT FK_AWARD_ON_WINNER FOREIGN KEY (winner_id) REFERENCES player (id);

ALTER TABLE competition
    ADD CONSTRAINT FK_COMPETITION_ON_FIRST_PLAYER FOREIGN KEY (first_player_id) REFERENCES player (id);

ALTER TABLE competition
    ADD CONSTRAINT FK_COMPETITION_ON_REFEREE FOREIGN KEY (referee_id) REFERENCES referee (id);

ALTER TABLE competition
    ADD CONSTRAINT FK_COMPETITION_ON_SECOND_PLAYER FOREIGN KEY (second_player_id) REFERENCES player (id);

ALTER TABLE referee
    ADD CONSTRAINT FK_REFEREE_ON_LICENSE FOREIGN KEY (license_id) REFERENCES license (id);

ALTER TABLE player_sport_school
    ADD CONSTRAINT fk_plasposch_on_player FOREIGN KEY (player_id) REFERENCES player (id);

ALTER TABLE player_sport_school
    ADD CONSTRAINT fk_plasposch_on_sport_school FOREIGN KEY (sport_school_id) REFERENCES sport_school (id);

ALTER TABLE sport_school_rating
    ADD CONSTRAINT fk_sport_school_rating_on_sport_school FOREIGN KEY (school_id) REFERENCES sport_school (id);