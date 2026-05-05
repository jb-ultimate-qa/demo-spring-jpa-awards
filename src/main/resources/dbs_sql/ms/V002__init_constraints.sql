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