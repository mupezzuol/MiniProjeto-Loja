CREATE TABLE Cliente
(
	Id INT PRIMARY KEY,
	Endereco INT
);
CREATE TABLE Endereco
(
	Id INT PRIMARY KEY,
	Nome VARCHAR
);
ALTER TABLE Cliente ADD CONSTRAINT FK_Endereco FOREIGN KEY (Endereco) REFERENCES Endereco(Id);
INSERT INTO Endereco VALUES (1, 'Rua A');
SELECT * FROM Endereco;
INSERT INTO Cliente (Id, Endereco) VALUES (1, (SELECT Id FROM Endereco WHERE Nome = 'Rua A'));
SELECT * FROM Cliente;