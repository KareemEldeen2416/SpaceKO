-- Astronauts
CREATE TABLE Astronaut(
	Astronaut_ID INT PRIMARY KEY AUTO_INCREMENT,
	Astronaut_Name VARCHAR(255) NOT NULL,
	Astro_Username VARCHAR(255) UNIQUE NOT NULL,
	Astro_Passwd VARCHAR(255) NOT NULL,
	-- Will be treated as a hash.
	Astro_Mission_Name VARCHAR(255) NOT NULL
);
-- FOREIGN KEYS:
-- ---------------------------------------------------------------------
-- Researchers
CREATE TABLE Researcher(
	Researcher_ID INT PRIMARY KEY AUTO_INCREMENT,
	Researcher_Name VARCHAR(255) NOT NULL,
	Researcher_Username VARCHAR(255) UNIQUE NOT NULL,
	Researcher_Passwd VARCHAR(255) NOT NULL,
	Researcher_Topic VARCHAR(255) NOT NULL,
	Researcher_Speciality VARCHAR(255) NOT NULL
);
CREATE TABLE Research(
	Research_ID INT PRIMARY KEY AUTO_INCREMENT,
	Research_Name VARCHAR(255) NOT NULL,
	Research_Dept VARCHAR(255) NOT NULL
);
CREATE TABLE Does(
	Researcher_ID INT,
	Research_ID INT,
	PRIMARY KEY(Research_ID, Researcher_ID),
	FOREIGN KEY(Researcher_ID) REFERENCES Researcher(Researcher_ID),
	FOREIGN KEY(Research_ID) REFERENCES Research(Research_ID)
);
-- ---------------------------------------------------------------------
CREATE TABLE Trainee(
	Trainee_ID INT PRIMARY KEY AUTO_INCREMENT,
	Trainee_Name VARCHAR(255) NOT NULL,
	Trainee_Status VARCHAR(255),
	Trainee_Passed BOOLEAN,
	Track_StudiedID_FK INT
);
CREATE TABLE Trainer(
	Trainer_ID INT PRIMARY KEY AUTO_INCREMENT,
	Trainer_Name VARCHAR(255) NOT NULL,
	Trainer_Username VARCHAR(255) UNIQUE NOT NULL,
	Trainer_Passwd VARCHAR(255) NOT NULL,
	No_Of_Trainees INT NOT NULL,
	Track_ID_FK INT
);
CREATE TABLE Track(
	Track_ID INT PRIMARY KEY AUTO_INCREMENT,
	Track_Name VARCHAR(255) NOT NULL,
	Track_Duration INT NOT NULL
);
CREATE TABLE Traines(
	Trainee_ID INT,
	Trainer_ID INT,
	PRIMARY KEY(Trainee_ID, Trainer_ID),
	FOREIGN KEY(Trainee_ID) REFERENCES Trainee(Trainee_ID),
	FOREIGN KEY(Trainer_ID) REFERENCES Trainer(Trainer_ID) -- Many to Many Relationship table
);
-- FOREIGN KEYS:
ALTER TABLE Trainee
ADD CONSTRAINT FK_TrackStudied FOREIGN KEY (Track_StudiedID_FK) REFERENCES Track(Track_ID);
ALTER TABLE Trainer
ADD CONSTRAINT FK_TrackTeach FOREIGN KEY (Track_ID_FK) REFERENCES Track(Track_ID);
-- ---------------------------------------------------------------------