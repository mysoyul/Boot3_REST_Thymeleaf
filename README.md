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