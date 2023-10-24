### MariaDB 설정
```
# root 계정으로 접속하여 사용자 계정과 DB 생성 ( root / maria )
mysql -u root –p
MariaDB [(none)]> show databases;
MariaDB [(none)]> use mysql;
MariaDB [mysql]> create database boot_db; 
MariaDB [mysql]> CREATE USER 'boot'@'%' IDENTIFIED BY 'boot';
MariaDB [mysql]> GRANT ALL PRIVILEGES ON boot_db.* TO 'boot'@'%';
MariaDB [mysql]> flush privileges; 
MariaDB [mysql]> select user, host from user;
MariaDB [mysql]> exit;

# boot 사용자 계정으로 접속한다. ( boot/boot )
mysql -u boot –p
MariaDB [(none)]>use boot_db;

```
### Users REST API
* 등록
```
  POST
  http://localhost:8080/api/users
  header
     content-type:application/json
  body
      {
      "name":"스프링",
      "email":"spring@a.com"
      }
```
* Id로 조회
```
    GET
    http://localhost:8080/api/users/{id}
```
* 목록조회
```
    GET
    http://localhost:8080/api/users
```
* 수정
```
    PATCH
    http://localhost:8080/api/users/1
    body
      {
        "name":"스프링"
      }
```
* 삭제
```
    DELETE
    http://localhost:8080/api/users/{id}
```
### UserInfo REST API
* 등록
```
  POST
  http://localhost:8080/api/userinfos/new  
  
  {
    "name":"adminboot",
    "password":"pwd1",
    "email":"admin@aa.com",
    "roles":"ROLE_ADMIN,ROLE_USER"
  }
  
  {
    "name":"userboot",
    "password":"pwd2",
    "email":"user@aa.com",
    "roles":"ROLE_USER"
 }
```