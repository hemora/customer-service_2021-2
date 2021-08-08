# Creación de una base de datos con mariaDB y Docker

~~~bash
docker pull mariadb
docker run -d --name=api_customer_db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123 mariadb
docker cp /path/to/script api_customer_db:/ 
docker exec -it api_customer_db bash
mysql -uroot -p 
(mariadb)> source /script
~~~