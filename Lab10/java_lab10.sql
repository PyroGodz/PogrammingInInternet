create database pyrogdb
use pyrogdb

create database lab10
use lab10

drop table test
create table test (
	id int,
    title varchar(255)
)

insert into test values (1,'fox')
insert into test values (2, 'dog')
insert into test values (3, 'cat')
insert into test values (4, 'dog')


drop function filter_by_title

DELIMITER $$
CREATE FUNCTION filter_by_title(venname VARCHAR(255)) 
RETURNS INT DETERMINISTIC
BEGIN
    DECLARE a INT;
    SELECT count(*) INTO a FROM test WHERE title LIKE venname;
    RETURN a;
END$$
DELIMITER ;