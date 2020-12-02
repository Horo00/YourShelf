SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS lending_book;
DROP TABLE IF EXISTS book_info;
DROP TABLE IF EXISTS having_book;
DROP TABLE IF EXISTS user;




/* Create Tables */

CREATE TABLE book_info
(
	-- 本のタイトル
	title varchar(255) NOT NULL COMMENT '本のタイトル',
	-- 作者名。なければ不明
	authors varchar(255) DEFAULT '不明' COMMENT '作者名。なければ不明',
	publisher varchar(255) DEFAULT '不明',
	-- 画像URL
	image_url varchar(255) COMMENT '画像URL',
	PRIMARY KEY (title),
	UNIQUE (title)
);


CREATE TABLE having_book
(
	-- 所蔵本の主キーID
	books_id int unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '所蔵本の主キーID',
	title varchar(255) NOT NULL,
	boughtdate date NOT NULL,
	-- 貸出された回数
	count smallint unsigned DEFAULT 0 COMMENT '貸出された回数',
	-- 個人の貸出日
	checkedout_date date COMMENT '個人の貸出日',
	-- 0で貸し出し中でない
	-- 1で貸し出し中
	is_lending tinyint COMMENT '0で貸し出し中でない
1で貸し出し中',
	PRIMARY KEY (books_id),
	UNIQUE (books_id),
	UNIQUE (title)
);


CREATE TABLE lending_book
(
	-- オートインクリメントの主キーです
	lending_book_id int unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'オートインクリメントの主キーです',
	-- ユーザーテーブルの主キー
	id int unsigned zerofill NOT NULL COMMENT 'ユーザーテーブルの主キー',
	-- 本のタイトル
	title varchar(255) NOT NULL COMMENT '本のタイトル',
	-- 所蔵本の主キーID
	books_id int unsigned zerofill NOT NULL COMMENT '所蔵本の主キーID',
	-- 貸出日
	checkedout_date date NOT NULL COMMENT '貸出日',
	-- 返却された日にupdateされる日付
	return_date date COMMENT '返却された日にupdateされる日付',
	PRIMARY KEY (lending_book_id),
	UNIQUE (lending_book_id),
	UNIQUE (title),
	UNIQUE (books_id)
);


CREATE TABLE user
(
	-- オートインクリメントの主キーです
	id int unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'オートインクリメントの主キーです',
	-- ユーザーネーム（本名）
	name varchar(255) NOT NULL COMMENT 'ユーザーネーム（本名）',
	password varchar(255) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (name)
);



/* Create Foreign Keys */

ALTER TABLE lending_book
	ADD FOREIGN KEY (title)
	REFERENCES book_info (title)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lending_book
	ADD FOREIGN KEY (books_id)
	REFERENCES having_book (books_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lending_book
	ADD FOREIGN KEY (id)
	REFERENCES user (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



