drop table account;

CREATE TABLE `account` (
	`account_num`	int	NOT NULL auto_increment primary key,
	`id`	varchar(20)	NOT NULL,
	`pw`	varchar(30)	NOT NULL,
	`name`	varchar(10)	NOT NULL,
	`birth`	date	NULL,
	`tel`	varchar(13)	NULL,
	`email`	varchar(50)	NULL,
	`nickname`	varchar(10)	NULL,
	`joindate`	date	NOT NULL
);
