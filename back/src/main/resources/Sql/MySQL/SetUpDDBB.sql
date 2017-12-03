CREATE DATABASE Blog;

USE Blog;

CREATE TABLE Entries (
  id INT UNSIGNED AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  text MEDIUMTEXT NOT NULL,
  creation_date DATETIME NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Tags (
  id INT UNSIGNED AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  creation_date DATETIME NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Entries_Tags (
    entry_id INT UNSIGNED NOT NULL,
    tag_id INT UNSIGNED NOT NULL,
    CONSTRAINT fk_entry_tag_entry foreign key (entry_id) references Entries(id),
    CONSTRAINT fk_entry_tag_tag foreign key (tag_id) references Tags(id)
);

CREATE TABLE Comments (
	id INT UNSIGNED AUTO_INCREMENT,
	Entry_id INT UNSIGNED,
	text TEXT NOT NULL,
	creation_date DATETIME NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (Entry_id) REFERENCES Entries(id) ON DELETE CASCADE
);


