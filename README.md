# LocusAsses
UserRoleAccess(Spring)

## Project Description
- User Access and Authentication Project

| Software   |      Verison  | 
|----------  |:-------------:|
| Spring     |  1.5.8        |
| Java       |  1.8.0_121    |
|  MySql     |  5.7.23       |

### Database name : ***users***
### Table definition
- user : To store the username and password
- user_role : To store a role (like admin, dev) corresponding to a username
- access : To store the relation between resoucre (like "PUBLIC_DB"), role (admin etc.) and Access_Type (READ, WRITE, DELETE).

## Steps to Run
- Create a MySQL DB 'users'
- The Project will automatically create 3 tables - 'user', 'user_role' and 'access'
