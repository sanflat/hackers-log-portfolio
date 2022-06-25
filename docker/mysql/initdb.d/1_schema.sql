use hackers_log_db;
CREATE TABLE user (
    id int not null auto_increment primary key comment 'ユーザID',
    mail varchar(250) not null comment 'メールアドレス',
    name varchar(20) not null comment 'ユーザ名',
    nick_name varchar(20) comment 'ニックネーム',
    password varchar(250) not null comment 'パスワード',
    created_at timestamp default current_timestamp comment '登録日時',
    updated_at timestamp default current_timestamp on update current_timestamp comment '更新日時',
    UNIQUE user_index (id, mail, name, password)
) comment 'ユーザ';

CREATE TABLE status (
    id int not null auto_increment primary key comment 'ステータスID',
    project_id int not null comment 'プロジェクトID',
    name varchar(10) not null comment 'ステータス名'
) comment 'ステータス';

CREATE TABLE group_user (
    id int not null comment 'グループユーザID',
    user_id int not null comment 'ユーザーID',
    unique group_index (id, user_id)
) comment 'グループユーザ';

CREATE TABLE project (
    id int not null auto_increment primary key comment 'プロジェクトID',
    group_user_id int not null comment 'グループユーザID',
    name varchar(100) not null comment 'プロジェクト名',
    created_at timestamp default current_timestamp comment '登録日時',
    updated_at timestamp default current_timestamp on update current_timestamp comment '更新日時',
    FOREIGN KEY fk_group_user_id (group_user_id) REFERENCES group_user (id)
) comment 'プロジェクト';

CREATE TABLE task (
    id int not null auto_increment primary key comment 'タスクID',
    user_id int comment 'ユーザID',
    project_id int not null comment 'プロジェクトID',
    name varchar(100) not null comment 'タスク名',
    contents varchar(600) comment 'タスク内容',
    status_id int not null comment 'ステータスID',
    created_at timestamp default current_timestamp comment '登録日時',
    updated_at timestamp default current_timestamp on update current_timestamp comment '更新日時',
    FOREIGN KEY fk_user_id (user_id) REFERENCES user (id),
    FOREIGN KEY fk_project_id (project_id) REFERENCES project (id),
    FOREIGN KEY fk_status_id(status_id) REFERENCES status(id)
) comment 'タスク';