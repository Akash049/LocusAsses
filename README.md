# Locus Assignment
UserRoleAccess(Spring)

## Project Description
- User Access and Authentication Project

| Software   |      Verison  | 
|----------  |:-------------:|
| Spring     |  1.5.8        |
| Tomcat     |  8.5          |
| Java       |  1.8.0_121    |
|  MySql     |  5.7.23       |

### Database name : ***users***
### Table definition
- ***user*** : To store the username and password
- ***user_role*** : To store a role (like admin, dev) corresponding to a username
- ***access*** : To store the relation between resoucre (like "PUBLIC_DB"), role (admin etc.) and Access_Type (READ, WRITE, DELETE).

### API Endpoints
- ***/resourceaccess/role*** 
    - To add value(resource,  role, access_type) to access table
    - Request-Type : JSON
    - ``` 
         {
                "resource" : "PUBLIC_DB_1",
                "accesstype" : "WRITE",
                "roles" : "Database_Handler"
          }
      ```
    - Respose :
    - ```
        { 
            "id": 7,
            "resource": "PUBLIC_DB_1",
            "accesstype": "WRITE",
            "roles": "Database_Handler"
        }
      ```
        
- ***/roles/adduserrole*** 
    - To add a new role to a user
    - Request-Type : JSON
    - ``` 
            { 
                "superuser" : "akash",
                "user_id" : "dev",
                "role" : "admin"
            }
      ```
    - Respose :
    - ```
        {
            "status": "User Role Created",
            "userRole": [
                {
                    "id": 13,
                    "user_id": "dev",
                    "roles": "admin"
                }
            ]
        }
      ```
    - Here *superuser* is to specify the user who executes this query as only *admin* has the right to add/delete roles
    
- ***/roles/deleterole*** 
    - To delete an existing role from a user
    - Request-Type : JSON
    - ``` 
            {
                "superuser" : "akash",
                "user_id" : "sample1",
                "role" : "dev"
            }
      ```
    - Respose :
    - ```{
            "status": "User Deleted",
         }
      ```
    - Here *superuser* is to specify the user who executes this query as only *admin* has the right to add/delete roles

- ***/resourceaccess/checkaccess*** 
    - To delete an existing role from a user
    - Request-Type : JSON
    - ``` 
            {
                "resource" : "PUBLIC_DB_1",
                "accesstype" : "DELETE",
                "user_id" : "akash1"
            }
      ```
    - Respose :
    - ```
        {
            "status": "ACCESS NOT ALLOWED"
        }
      ```

## Steps to Run
- Create a MySQL DB 'users'
- The Project will automatically create 3 tables - 'user', 'user_role' and 'access'
- Add Tomcat as the server
- In the Project Directory,  select UserApplication.java and execute "Run as Java Application"
