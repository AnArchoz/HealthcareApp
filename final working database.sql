DROP TABLE IF EXISTS medical_record,appointment,patient,admin_table,doctor, doctor_logs, patient_logs;
DROP VIEW IF EXISTS appInfo;
DROP TRIGGER IF EXISTS delete_doctor, delete_patient;
DROP PROCEDURE IF EXISTS getPatients, getMedicalRecord, getAppointment, getDoctor, getPatientInfo
GO
CREATE TABLE doctor(
    id int PRIMARY KEY NOT NULL,
    first_name  VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    doc_spec VARCHAR(30) NOT NULL,
    spec_price INT,
    pw VARCHAR(8) NOT NULL
)
CREATE TABLE admin_table(
    id int PRIMARY KEY,
    pw VARCHAR(8)
)
CREATE TABLE patient(
    id INT PRIMARY KEY NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    gender VARCHAR(1)NOT NULL,
    address VARCHAR(40) NOT NULL,
    phone int NOT NULL,
    birth_date DATE NOT NULL, 
    reg_d DATETIME NOT NULL,
    pw VARCHAR(8) not null,
    total_cost int
    )
CREATE TABLE appointment(
    app_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
    patient_id INT,
    doctor_id INT NOT NULL, 
    app_date_ VARCHAR(12) NOT NULL,
    book_time DATETIME,
    FOREIGN KEY (doctor_id) REFERENCES doctor (id),
    FOREIGN KEY (patient_id) REFERENCES patient (id)
)
CREATE TABLE medical_record(
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    mr_app_id INT NOT NULL,
    app_date_ VARCHAR(12) NOT NULL,
    diagnosis VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    drugs VARCHAR(100),
    FOREIGN KEY (doctor_id) REFERENCES doctor (id),
    FOREIGN KEY (patient_id) REFERENCES patient (id),
    FOREIGN KEY (mr_app_id) REFERENCES appointment (app_id)
)
CREATE TABLE doctor_logs(
    logid INT, 
    last_name VARCHAR(10),
    text varchar(50)
)

CREATE TABLE patient_logs(
    pat_id INT,
    dob DATE,
    text varchar(50)
)

ALTER TABLE patient
ADD CONSTRAINT minlenghtPwPatients CHECK (DATALENGTH(pw) = 8)
ALTER TABLE doctor
ADD CONSTRAINT minlenghtPwDoctors CHECK (DATALENGTH(pw) = 8)
ALTER TABLE doctor
ADD CONSTRAINT minSpecPrices CHECK (spec_price > 0)
ALTER TABLE patient
ADD CONSTRAINT minIdLength CHECK (id > 100000000)
ALTER TABLE patient
ADD CONSTRAINT maxIdLength CHECK (id < 999999999)
GO

INSERT INTO doctor VALUES (1,'hoj','bjergi','surgeon',100,'12345678');
INSERT INTO doctor VALUES (2,'ddj','gi','surgeon',1000,'12345678');
INSERT INTO doctor VALUES (3,' h  ','ee','surgeon',1000,'12345678');
INSERT INTO admin_table VALUES (1,12345678);
INSERT INTO patient VALUES (111111111,'hhhh','bjergi','m','hejvägen 1',123334,'2020-10-10','2014-04-04 09:20', '12345678',0);
INSERT INTO patient VALUES (222222222,'eee','bbb','m','hejaa 1',123334,'2020-10-10','2014-04-04 09:20', '12345678',0);
INSERT INTO patient VALUES (333333333,'eee','bbb','m','hejaa 1',123334,'2020-10-10','2014-04-04 09:20', '12345678',0);
GO

CREATE VIEW appInfo
AS
SELECT d.first_name AS doctor_f_name, d.last_name AS doctor_l_name, appointment.app_date_ AS app_date, p.first_name AS p_first_name, p.last_name AS p_last_name 
FROM  appointment
JOIN doctor d ON appointment.doctor_id = d.id
JOIN patient p ON appointment.patient_id = p.id
GO
SELECT * FROM appInfo;
GO

CREATE TRIGGER delete_doctor
ON doctor
AFTER DELETE 
AS BEGIN
SET NOCOUNT ON;
DECLARE @doctorId INT, @doctorLastName VARCHAR (10)
SELECT @doctorId = DELETED.id, @doctorLastName = DELETED.last_name
FROM deleted 
INSERT INTO doctor_logs
VALUES (@doctorId,@doctorLastName, 'DELETED');
END
GO

CREATE TRIGGER delete_patient
ON patient
AFTER DELETE 
AS BEGIN
SET NOCOUNT ON;
DECLARE @pat_id INT, @dob DATE
SELECT @pat_id = DELETED.id, @dob = deleted.birth_date
FROM deleted 
INSERT INTO patient_logs	
VALUES (@pat_id,@dob, 'DELETED');
END
GO

CREATE PROCEDURE getDoctor
@firstName varchar (30), @lastName varchar(30), @doc_spec VARCHAR(30),@doc_price INT
AS 
SET NOCOUNT ON;
SELECT first_name,last_name, doc_spec, spec_price
FROM doctor 
WHERE first_name = @firstName AND last_name = @lastName AND doc_spec = @doc_spec AND spec_price = @doc_price 
GO

CREATE PROCEDURE getPatients 
AS 
SET NOCOUNT ON;
SELECT id, first_name, last_name, total_cost
FROM patient
GO

CREATE PROCEDURE getMedicalRecord
@mc_id INT,
@mc_app_date VARCHAR(12)
AS 
SET NOCOUNT ON;
SELECT patient_id, doctor_id,mr_app_id,app_date_, diagnosis, description, drugs
FROM medical_record
WHERE patient_id = @mc_id AND app_date_ = @mc_app_date;
GO

CREATE PROCEDURE getAppointment
@doctor_id INT
AS 
SET NOCOUNT ON;
SELECT patient_id,doctor_id,app_date_,book_time
FROM appointment
WHERE doctor_id = @doctor_id;
GO

CREATE PROCEDURE getPatientInfo 
@id INT
AS 
SET NOCOUNT ON;
SELECT first_name,last_name, birth_date, gender, address,phone, reg_d,total_cost
FROM patient
WHERE @id = patient.id;
GO
EXECUTE getPatientInfo @id = 222222222