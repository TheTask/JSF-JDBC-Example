Instructions:

Configure Glassfish:

Download link for Glassfish 5 :  http://download.oracle.com/glassfish/5.0.1/nightly/latest-glassfish.zip
Glassfish needs a mssql-jdbc-7.2.2.jre8.jar file ( JDBC Connector for SQL Server ) in its /glassfish/lib folder.

Set Up Connection pool at localhost:4848

Configure JDBC Connection pool as following ( here I am just modifying the existing Derby pool )

![alt text](https://i.imgur.com/mUEruXw.png)

![](https://i.imgur.com/vyvL0ag.png)

Provided there is a SQL Server database running locally with the specified properties. Here is my test database running on SQL Server 2016:

![](https://i.imgur.com/YrrXjlN.png)


Make sure there is an account named sysad with password adminadmin created that is using SQL authentication for the database that has rights to modify it.

Here is the application running:

![](https://i.imgur.com/Ms7tM8D.png)
