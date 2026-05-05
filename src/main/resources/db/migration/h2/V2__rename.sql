ALTER TABLE competition
    RENAME COLUMN title TO new_title;

DROP SEQUENCE competition_seq CASCADE;