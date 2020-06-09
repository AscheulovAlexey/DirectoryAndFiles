# DirectoryAndFiles

Simple Web-application that collects files from the specified directory.

### Technologies
- Spring Boot
- Hibernate
- PostrgreSQL
- Freemaker

### How to run
1. Create database "directory"
```
1a. Use Postgres on your localmachine and create database "directory"

or

1b. Create a Postgres in docker container:
docker run --name db1 -e POSTGRES_PASSWORD=password -d postgres

Connect and run some queries:
docker exec -it demo psql -U postgres

CREATE DATABASE directory
```
2. Build app 
Run "mvn package" from the command line.

3. Start app from the command line:
java -jar /{yourpath}/jar_name.jar

### Path page
1. You can add new path
2. You can view all path with common info about files
![alt text](https://i.ibb.co/N9rRHWf/2020-06-10-00-11-27.png)

### Files page
1. You can view detailed info about files (name and size)
2. You can back to the main page
![alt text](https://i.ibb.co/DfxVDTW/2020-06-10-00-18-12.png)

### Error page
If the path is entered with an error, the site will indicate it
![alt text](https://i.ibb.co/nBrJX1V/2020-06-10-00-17-58.png)
