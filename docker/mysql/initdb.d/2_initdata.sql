use hackers_log_db;

INSERT INTO user (mail, name, nick_name, password)
VALUES
 ('hey@test-mail.com', 'hey', 'hey_nick_name', 'password');

INSERT INTO status (name,project_id)
VALUES
('waiting',1),
('working',1),
('completed',1);

INSERT INTO group_user (id, user_id)
VALUES
(1,1);

INSERT INTO project (group_user_id,name)
VALUES
(1,'Hackers Log Project');

INSERT INTO task (user_id,project_id,name,contents,status_id)
VALUES
(1,1,'task','',1);