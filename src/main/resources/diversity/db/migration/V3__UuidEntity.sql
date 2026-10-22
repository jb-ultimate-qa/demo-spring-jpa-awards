CREATE TABLE uuid_entity
(
    id   UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_uuid_entity PRIMARY KEY (id)
);

insert into uuid_entity values ('aaaabbbb-1111-2222-3333-4444ffffaaaa', 'aaaa'),
                               ('aaaabbbb-5555-2222-3333-4444ffffaaaa', '5555'),
                               ('aaaabbbb-8888-2222-3333-4444ffff8888', '8888');