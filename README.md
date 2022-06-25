# Hackers Log
フラットなコミュニケーションを想定した、シンプルな機能とユーザーインターフェースで構築されたプロジェクト管理ツール

# Use Tech
* [コンテナ仮想化：Docker](https://www.docker.com/)
* [ビルドシステム：Gradle](https://docs.gradle.org)
* [バックエンド言語：Java](https://www.oracle.com/jp/java/)
* [バックエンドフレームワーク：Spring Boot](https://spring.io/projects/spring-boot)
* [フロントエンドテンプレート：Thymeleaf](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [CSSフレームワーク：Tailwind CSS](https://tailwindcss.jp)
* [DB：MySQL](https://www.mysql.com/jp/)
* [ORM：MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

# Environment Building
##リポジトリクローン
###remote url
```
// https
$ https://github.com/sanflat/hackers-log-portfolio.git

// ssh
$ git@github.com:sanflat/hackers-log-portfolio.git

// GitHub CLIの場合
$ gh repo clone sanflat/hackers-log-portfolio.git
```

##Dockerコンテナの起動
###ルートディレクトリから、docker-compose.ymlファイルのディレクトリに移動
```
$ cd docker/
```
###docker-composeの下記コマンドを実行し、ビルドが成功しDockerImageが作成される事を確認する
```
$ docker-compose build
```
###docker-composeの下記コマンドを実行し、コンテナの起動を確認する
```
$ docker-compose up
```

##TailwindCSSのビルドプロセスを開始する
###npxコマンドが使えない場合は、インストールする
```
// brew command
brew install nodebrew

// install時のログを参考にパスを通す
$ echo 'export PATH=$HOME/.nodebrew/current/bin:$PATH' >> ~/.bash_profile
$ source ~/.bash_profile

// nodebrewがインストールできたか確認する
$ nodebrew -v

// Node.jsをインストールする
$ nodebrew install-binary latest 
```
### npxを使用しTailwindCLIビルドプロセスを開始する
```
$ npx tailwindcss -i ./src/main/resources/static/css/tailwind/input.css -o ./src/main/resources/static/css/tailwind/output.css --watch
```
## ポート8080で画面を表示する
```
http://localhost:8080/
```

# command list
Docker コンテナのDBに入る
```
$ docker exec -it docker-db-1 bash
$ mysql -u user -ppassword hackers_log_db
```

# document list
* [仕様設計書：スプレットシート](https://docs.google.com/spreadsheets/d/1EPLaHuocs2ENrCoj_MbS3Vd7LAa4XyukF_YeJ40QmOA/edit#gid=0)
* [ワイヤーフレーム：Figma](https://www.figma.com/file/0JUejIQumD2tDZ35Ft38Ad/Hackers-Log-ph1?node-id=0%3A1)
* [DB設計：GitMind](https://gitmind.com/app/flowchart/cbb80eb5cc520a9e4209f0e816200b8f)
