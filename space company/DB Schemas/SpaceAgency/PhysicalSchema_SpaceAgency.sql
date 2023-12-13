CREATE TABLE Mission(
    Mission_ID INT PRIMARY KEY AUTO_INCREMENT,
    Mission_Name VARCHAR(255) NOT NULL,
    Mission_Progress INT NOT NULL,
    Mission_No_Workers INT NOT NULL,
    Mission_Leader VARCHAR(255) NOT NULL,
    Mission_Budget FLOAT NOT NULL,
    FK_Report_ID INT
);
CREATE TABLE Report(
    Report_ID INT PRIMARY KEY AUTO_INCREMENT,
    Report_Title VARCHAR(255) NOT NULL,
    Report_Author VARCHAR(255) NOT NULL,
    Report_String VARCHAR(255) NOT NULL
);
-- Foreign Key from Report to Mission
ALTER TABLE Mission
ADD CONSTRAINT FK_Report FOREIGN KEY(FK_Report_ID) REFERENCES Report(Report_ID);
-- ---------------------------------------------------------------------
CREATE TABLE Rocket(
    Rocket_ID INT PRIMARY KEY AUTO_INCREMENT,
    Rocket_PayloadSize INT NOT NULL,
    Rocket_Model VARCHAR(255) NOT NULL,
    Rocket_Cost FLOAT NOT NULL,
    Rocket_Availability BOOLEAN NOT NULL,
    Rocket_VisualComms BOOLEAN NOT NULL,
    Rocket_StageSeperation INT NOT NULL,
    FK_Mission_ID INT,
    FK_Shuttle_ID INT,
    FK_GPSRocket VARCHAR(255)
);
CREATE TABLE GPS_Data(
    GPSData_DestName VARCHAR(255) PRIMARY KEY,
    x FLOAT NOT NULL,
    y FLOAT NOT NULL
);
CREATE TABLE Satellite(
    Satellite_ID INT PRIMARY KEY AUTO_INCREMENT,
    Satellite_On_Mission BOOLEAN NOT NULL,
    Sat_Mission_Name VARCHAR(255) NOT NULL,
    Sat_Duration INT NOT NULL,
    FK_GPS_Sat VARCHAR(255)
);
CREATE TABLE SpaceShuttle(
    Shuttle_ID INT PRIMARY KEY AUTO_INCREMENT,
    Shuttle_Thrust INT NOT NULL,
    Shuttle_CrewCapacity INT NOT NULL,
    Shuttle_PayloadCapacity INT NOT NULL,
    Shuttle_OrbitVelocity INT NOT NULL,
    FK_GPS_Shuttle VARCHAR(255)
);
-- Foreign Keys
ALTER TABLE Rocket
ADD CONSTRAINT FK_Mission FOREIGN KEY(FK_Mission_ID) REFERENCES Mission(Mission_ID);
ALTER TABLE Rocket
ADD CONSTRAINT FK_Shuttle FOREIGN KEY(FK_Shuttle_ID) REFERENCES SpaceShuttle(Shuttle_ID);
ALTER TABLE Rocket
ADD CONSTRAINT FK_GPS_Rocket FOREIGN KEY(FK_GPSRocket) REFERENCES GPS_Data(GPSData_DestName);
ALTER TABLE Satellite
ADD CONSTRAINT FK_GPS_Satellite FOREIGN KEY(FK_GPS_Sat) REFERENCES GPS_Data(GPSData_DestName);
ALTER TABLE SpaceShuttle
ADD CONSTRAINT FK_GPS_SpaceShuttle FOREIGN KEY(FK_GPS_Shuttle) REFERENCES GPS_Data(GPSData_DestName);
-- ---------------------------------------------------------------------
CREATE TABLE Project(
    Project_ID INT PRIMARY KEY AUTO_INCREMENT,
    Project_Name VARCHAR(255) NOT NULL,
    No_Crew INT NOT NULL,
    Project_Leader VARCHAR(255) NOT NULL,
    Project_Target VARCHAR(255) NOT NULL,
    Project_Budget FLOAT NOT NULL
);