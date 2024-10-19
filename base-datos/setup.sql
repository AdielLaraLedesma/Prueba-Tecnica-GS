CREATE LOGIN creditUser WITH PASSWORD = 'seCret01*1';
GO

CREATE USER creditUser FOR LOGIN creditUser;
GO

ALTER SERVER ROLE sysadmin ADD MEMBER [creditUser];
GO

CREATE DATABASE creditDB
GO

USE creditDB;
GO

CREATE TABLE Branch (
    id INT IDENTITY(1,1),
    name NVARCHAR(100) NOT NULL,
    address NVARCHAR(255) NOT NULL
);
GO
ALTER TABLE Branch
ADD CONSTRAINT branch_pk PRIMARY KEY (id);
GO


CREATE TABLE Client (
    id INT IDENTITY(1,1),
    first_name NVARCHAR(100) NOT NULL,
    last_name NVARCHAR(100) NOT NULL,
    email NVARCHAR(100) NOT NULL,
    branch_id INT
);
GO
ALTER TABLE Client
ADD CONSTRAINT client_pk PRIMARY KEY (id);
GO
ALTER TABLE Client
ADD CONSTRAINT branch_id_fk FOREIGN KEY (branch_id) REFERENCES Branch(id);
GO


CREATE TABLE CreditRequest (
    id INT IDENTITY(1,1),
    client_id INT,
    amount DECIMAL(18, 2) NOT NULL,
    request_date DATETIME NOT NULL DEFAULT GETDATE(),
    status NVARCHAR(20) NOT NULL,
    branch_id INT
);
GO
ALTER TABLE CreditRequest
ADD CONSTRAINT credit_request_pk PRIMARY KEY (id);
GO
ALTER TABLE CreditRequest
ADD CONSTRAINT credit_request_status_chk CHECK (status IN ('APPROVED', 'REJECTED'));
GO
ALTER TABLE CreditRequest
ADD CONSTRAINT credit_request_branch_id_fk FOREIGN KEY (branch_id) REFERENCES Branch(id);
GO
ALTER TABLE CreditRequest
ADD CONSTRAINT credit_request_client_id_fk FOREIGN KEY (client_id) REFERENCES Branch(id);
GO
