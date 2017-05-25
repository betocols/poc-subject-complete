CREATE TABLE subject (
  subject_id    BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT 'PK for subject',
  name          varchar(32)  NOT NULL COMMENT 'Name of subject',
  PRIMARY KEY (subject_id)
);

CREATE TABLE subject_professor (
  id            BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT 'PK for subject_professors',
  subject_id    BIGINT(20)   NOT NULL COMMENT 'FK to subject table',
  professor_id    BIGINT(20)   NOT NULL COMMENT 'FK to professor table in Professor ms',
  PRIMARY KEY (id),
  UNIQUE KEY subjet_professors_udx1 (subject_id, professor_id)
);
