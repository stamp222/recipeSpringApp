# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to my sql and run as a root user

## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE stamp_dev;
CREATE DATABASE stamp_prod;

#Create database service accounts
CREATE USER 'stamp_dev_user'@'localhost' IDENTIFIED BY 'stamp';
CREATE USER 'stamp_prod_user'@'localhost' IDENTIFIED BY 'stamp';
CREATE USER 'stamp_dev_user'@'%' IDENTIFIED BY 'stamp';
CREATE USER 'stamp_prod_user'@'%' IDENTIFIED BY 'stamp';

#Database grants
GRANT SELECT ON stamp_dev.* to 'stamp_dev_user'@'localhost';
GRANT INSERT ON stamp_dev.* to 'stamp_dev_user'@'localhost';
GRANT DELETE ON stamp_dev.* to 'stamp_dev_user'@'localhost';
GRANT UPDATE ON stamp_dev.* to 'stamp_dev_user'@'localhost';
GRANT SELECT ON stamp_prod.* to 'stamp_prod_user'@'localhost';
GRANT INSERT ON stamp_prod.* to 'stamp_prod_user'@'localhost';
GRANT DELETE ON stamp_prod.* to 'stamp_prod_user'@'localhost';
GRANT UPDATE ON stamp_prod.* to 'stamp_prod_user'@'localhost';
GRANT SELECT ON stamp_dev.* to 'stamp_dev_user'@'%';
GRANT INSERT ON stamp_dev.* to 'stamp_dev_user'@'%';
GRANT DELETE ON stamp_dev.* to 'stamp_dev_user'@'%';
GRANT UPDATE ON stamp_dev.* to 'stamp_dev_user'@'%';
GRANT SELECT ON stamp_prod.* to 'stamp_prod_user'@'%';
GRANT INSERT ON stamp_prod.* to 'stamp_prod_user'@'%';
GRANT DELETE ON stamp_prod.* to 'stamp_prod_user'@'%';
GRANT UPDATE ON stamp_prod.* to 'stamp_prod_user'@'%';