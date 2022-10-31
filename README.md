# README

[SQlite Java - How To Use JDBC To Interact with SQLite](https://www.sqlitetutorial.net/sqlite-java/)
個人的学習用リポジトリー。

## Requirements

WSL で学習をしている。

* JDK を必要ならインストールする。例：

  ```console
  bash$ sudo apt install openjdk-18-jdk-headless
  ```

* SQLite のサンプルデータベース `chinook.db` をディレクトリー `db` に置く。
* チュートリアルに述べられているように JDBC ドライバーを入手したら、このワークスペースの
  ディレクトリー `lib` に置く。

  ```console
  bash$ cd lib
  bash$ wget https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.39.3.0/sqlite-jdbc-3.39.3.0.jar
  ```

* BLOB の回で用いる画像は Google で検索したものを `A_laptop.jpg` としてワークスペース最上位（雑）に置く。
  ライセンスフリーオプションで検索するといい。
