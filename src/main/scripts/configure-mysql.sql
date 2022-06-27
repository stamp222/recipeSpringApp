# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to my sql and run as a root user

CREATE DATABASE stamp_dev;
CREATE DATABASE stamp_prod;

CREATE USER 'stamp_dev_user'@'locahost' IDENTIFIED BY 'stamp';
CREATE USER 'stamp_prod_user'@'locahost' IDENTIFIED BY 'stamp';

GRANT SELECT ON stamp_dev.* to 'stamp_dev_user'@'locahost';
GRANT INSERT ON stamp_dev.* to 'stamp_dev_user'@'locahost';
GRANT DELETE ON stamp_dev.* to 'stamp_dev_user'@'locahost';
GRANT UPDATE ON stamp_dev.* to 'stamp_dev_user'@'locahost';
GRANT SELECT ON stamp_prod.* to 'stamp_prod_user'@'locahost';
GRANT INSERT ON stamp_prod.* to 'stamp_prod_user'@'locahost';
GRANT DELETE ON stamp_prod.* to 'stamp_prod_user'@'locahost';
GRANT UPDATE ON stamp_prod.* to 'stamp_prod_user'@'locahost';