# Priority-Project

## Write an application in Spring Boot called "Priority"

**Description:** 

There are 4 areas that a user can allot different priorities to. 

1. Connection
2. Relationships
3. Career
4. Wealth

Along with priority, he/she needs to rate the satisfaction for all the above areas on a scale of 1 to 5.

Company admin/creator should have the ability to add more areas in the backend later if needed. 

**Task:**

Create REST APIs that 

- Returns a list of all the priority areas from the database
- Accepts the order of priority along with the satisfaction rating for each area for a user and stores it in the database

Instructions:

- Use standard architecture for code
- Write clean code with appropriate naming conventions.
- Add comments where necessary.

Submission:

- Please upload the codebase to a git host (ex: Github, Bitbucket, etc.) and share the repository url.

###########################################################################################################

**Following are the REST APIs implemented for above Project.**

API for adding new life_area by admin into the DB.
API Endpoint : localhost:8080/api/priority/lifearea/add
Method Type : POST
Request Payload : 
{
    "areaName" : "Health"
    "createdBy" : "1"
}

API for getting list of all priority areas from DB.
API Endpoint : localhost:8080/api/priority/lifearea/list
Method Type : GET
Request Payload : 
-

API for insertion of ratings for Priority along with Satisfaction for respective area and user.
API Endpoint : localhost:8080/api/priority/rating/add
Method Type : POST
Request Payload : 
{
    "userId" : "3",
    "areaId" : "102",
    "priorityRating" : "5",
    "satisfactionRating" : "2"
}

###########################################################################################################

**Steps to run the project**
1. Import Project as Gradle Project in Eclipse
2. Right Click on AssessmentApplication.java class and Run as 'Java Application'
3. Test out APIs locally on Postman.
4. Database Configurations are already done as it is hosted on Amazon RDS Server
