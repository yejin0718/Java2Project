
CREATE TABLE todo (
    todo_id      NUMBER PRIMARY KEY,
    content        VARCHAR2(500) NOT NULL,
    create_at        DATE DEFAULT SYSDATE,
    complete        NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE seq_todo_id
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

CREATE OR REPLACE TRIGGER trg_todo_id
BEFORE INSERT ON todo
FOR EACH ROW
BEGIN
    IF :NEW.todo_id IS NULL THEN
        SELECT seq_todo_id.NEXTVAL INTO :NEW.todo_id FROM DUAL;
    END IF;
END;
/

INSERT INTO todo (content)
VALUES ('리액트 과제 하기');

INSERT INTO todo (content)
VALUES ('소공 과제 하기');

INSERT INTO todo (content)
VALUES ('전처리 과제 하기');








