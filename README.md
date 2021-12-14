# CloudProject
Tạo Elastic IP (IP tĩnh cho các Instance) 
Tạo Security Network (Port kết nối cho các Instance) cả Inbound và Outbound

Host từng file theo thứ tự như sau: FrontEnd -> Database -> Backend

-- Frontend: Nginx – host HTML (latest)
+ Build: 
docker build -t my-fe .
docker run -d -p 8080:80 --name my-frontend my-fe

+ Dockerfile:
FROM nginx:alpine
COPY ./webapps/. /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/default.conf

+ Default.conf:
server {
  listen       80 default_server;
  listen       [::]:80 default_server;
  server_name  _;

  location / {
      root    /usr/share/nginx/html;
      index   AddUser.html;
    #   proxy_pass        http://localhost:5500;
    #   proxy_set_header  X-Real-IP $remote_addr;
    #   proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
    #   proxy_set_header  Host $http_host;
  }
}

Send API (by AJAX):

-- Database: MySQL (8.0.24)
+ Build: 
docker run -d -p 3307:3306 --name my-database --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=CloudProject" mysql:8.0.26

+ Connect - bash: 
docker exec -it my-database bash
mysql -u root -p (nhớ nhập pass word – root)
SHOW DATABASES;
USE CloudProject;
SHOW TABLES;
SELECT * FROM (tables)


-- Backend: SpringBoot
+ Build:
docker build -t my-be .
docker run -d -p 9000:80 --name my-backend -e MYSQL_HOST=52.45.238.90 -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_POST=3307 my-be
Lưu ý là port phải là HTTP

+ Dockerfile:
FROM openjdk:17
ADD target/spring-backend.jar spring-backend.jar 
ENTRYPOINT [ "java", "-jar", "/spring-backend.jar"]
