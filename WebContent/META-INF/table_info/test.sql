SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS lending_book;
DROP TABLE IF EXISTS admindata;
DROP TABLE IF EXISTS all_books;
DROP TABLE IF EXISTS user;




/* Create Tables */

CREATE TABLE admindata
(
	-- 所蔵本の主キーID
	books_id int unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '所蔵本の主キーID',
	-- bookshistoryのisbnと同じ
	-- 
	isbn varchar(13) NOT NULL COMMENT 'bookshistoryのisbnと同じ
',
	boughtdate date NOT NULL,
	-- 貸出された回数
	count smallint unsigned DEFAULT 0 COMMENT '貸出された回数',
	-- 個人の貸出日
	checkedout_date date COMMENT '個人の貸出日',
	PRIMARY KEY (books_id),
	UNIQUE (books_id)
);


CREATE TABLE all_books
(
	-- ISBNを主キーとした書籍テーブル。
	-- 購入書籍の情報を格納
	isbn varchar(13) NOT NULL COMMENT 'ISBNを主キーとした書籍テーブル。
購入書籍の情報を格納',
	-- 本のタイトル
	title varchar(255) NOT NULL COMMENT '本のタイトル',
	-- 作者名。なければ不明
	authors varchar(255) DEFAULT '不明' COMMENT '作者名。なければ不明',
	publisher varchar(255) DEFAULT '不明',
	-- 画像URL
	image_url varchar(255) COMMENT '画像URL',
	PRIMARY KEY (isbn),
	UNIQUE (isbn)
);


CREATE TABLE lending_book
(
	lending_book_id int unsigned zerofill NOT NULL AUTO_INCREMENT,
	-- 所蔵本の主キーID
	books_id int unsigned zerofill NOT NULL COMMENT '所蔵本の主キーID',
	-- オートインクリメントの主キーです
	id int unsigned zerofill NOT NULL COMMENT 'オートインクリメントの主キーです',
	isbn varchar(13) NOT NULL,
	-- 貸出中かどうかのチェック
	-- [0>貸出中でない]
	-- [1>貸出中]
	is_lending tinyint unsigned NOT NULL COMMENT '貸出中かどうかのチェック
[0>貸出中でない]
[1>貸出中]',
	-- 貸出日
	checkedout_date date NOT NULL COMMENT '貸出日',
	-- 返却された日にupdateされる日付
	return_date date COMMENT '返却された日にupdateされる日付',
	PRIMARY KEY (lending_book_id),
	UNIQUE (lending_book_id),
	UNIQUE (books_id),
	UNIQUE (id)
);


CREATE TABLE user
(
	-- オートインクリメントの主キーです
	id int unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'オートインクリメントの主キーです',
	password varchar(255) NOT NULL,
	-- ユーザーネーム（本名）
	name varchar(255) NOT NULL COMMENT 'ユーザーネーム（本名）',
	PRIMARY KEY (id),
	UNIQUE (id)
);



/* Create Foreign Keys */

ALTER TABLE lending_book
	ADD FOREIGN KEY (books_id)
	REFERENCES admindata (books_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lending_book
	ADD FOREIGN KEY (id)
	REFERENCES user (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



