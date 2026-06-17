USE master;
GO

IF NOT EXISTS (SELECT 1 FROM sys.sql_logins WHERE name = 'demo_user')
BEGIN
    CREATE LOGIN demo_user WITH PASSWORD = 'My@Super@Secret';
END
GO

IF DB_ID('mssql_awards') IS NULL
BEGIN
    CREATE DATABASE mssqlawards;
END
GO

USE mssql_awards;
GO

IF NOT EXISTS (SELECT 1 FROM sys.database_principals WHERE name = 'demo_user')
BEGIN
    CREATE USER demo_user FOR LOGIN demo_user;
END
GO

ALTER ROLE db_owner ADD MEMBER demo_user;
GO