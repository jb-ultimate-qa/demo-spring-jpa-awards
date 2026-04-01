INSERT INTO sport_school (id, title) VALUES
     ('001_ss', 'The First Sport School'),
     ('002_ss', 'Just a Sport School'),
     ('003_ss', 'Training Center');

INSERT INTO license (sn, descr, license_number) VALUES
    (1001, 'National Referee License', 'L_1234_R1'),
    (1002, 'International Referee License', 'L_0002'),
    (1003, 'Regional Referee License', 'L_xxxx');

INSERT INTO player (id, rating, first_name) VALUES
    (1, 1200, 'Anna'),
    (2, 1100, 'Sara'),
    (3, 1250, 'Maria'),
    (4, 1300, 'Tom'),
    (5, 1150, 'Dany'),
    (6, 1400, 'John');

INSERT INTO referee (id, license_id, first_name) VALUES
     (1, 1, 'Peter'),
     (2, 2, 'Lora'),
     (3, 3, 'Helga');

INSERT INTO player_sport_school (player_id, sport_school_id) VALUES
     (1, '001_ss'),
     (2, '002_ss'),
     (3, '003_ss'),
     (4, '003_ss'),
     (5, '002_ss'),
     (6, '001_ss');

-- Insert data into competition table
INSERT INTO competition (competition_level, first_player_id, referee_id, second_player_id, id, city, stadium, title) VALUES
    (0, 1, 1, 2, 1001, 'Paris', 'Parc des Princes', 'City Championship'),
    (1, 3, 2, 4, 1002, 'Berlin', 'Olympiastadion', 'State Finals'),
    (2, 5, 3, 6, 1003, 'Madrid', 'Santiago Bernabeu Stadium', 'Regional Tournament'),
    (3, 4, 2, 2, 1004, 'Rome', 'Stadio Olimpico', 'National League'),
    (0, 6, 3, 4, 1005, 'London', 'Wembley Stadium', 'Local Showdown');

-- Insert data into award table
INSERT INTO award (id, winner_id, year_, title) VALUES
    (1, 1, 2025, 'Best Player of the Year'),
    (2, 2, 2024, 'Top Scorer Award'),
    (3, 3, 2026, 'Most Improved Player'),
    (4, 4, 2023, 'Best Newcomer'),
    (5, 5, 2022, 'Lifetime Achievement Award'),
    (6, 6, 2024, 'Best Team Player');

INSERT INTO sport_school_rating (school_id, rating) VALUES
     ('001_ss', 3),
     ('001_ss', 4),
     ('001_ss', 4),
     ('001_ss', 4),
     ('002_ss', 5),
     ('002_ss', 5),
     ('002_ss', 4),
     ('002_ss', 5),
     ('002_ss', 2),
     ('002_ss', 3),
     ('003_ss', 2),
     ('003_ss', 4),
     ('003_ss', 3),
     ('003_ss', 4),
     ('003_ss', 5);