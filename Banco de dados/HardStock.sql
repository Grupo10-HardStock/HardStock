CREATE DATABASE HardStock;

USE HardStock;

CREATE TABLE Empresa(
idEmpresa INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45),
CNPJ CHAR(18)
);

CREATE TABLE Funcionario(
idFuncionario INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45),
email VARCHAR(256),
senha VARCHAR(45),
CPF Char(14),
fkEmpresa int,
CONSTRAINT fkFuncionarioEmpresa FOREIGN KEY(fkEmpresa)
	REFERENCES Empresa(idEmpresa)
);

CREATE TABLE Computador(
idComputador INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45),
fkEmpresa int,
CONSTRAINT fkComputadorEmpresa FOREIGN KEY(fkEmpresa)
	REFERENCES Empresa(idEmpresa)
);

CREATE TABLE Componente(
idComponente INT PRIMARY KEY AUTO_INCREMENT,
nomeComponente VARCHAR(45),
unidadeMedida VARCHAR(45)
);

CREATE TABLE ComponenteComputador (
fkComputador INT,
fkComponente INT,
CONSTRAINT fkComputadorComponente FOREIGN KEY (fkComputador)
	REFERENCES Computador (idComputador),
CONSTRAINT fkComponenteComputador FOREIGN KEY (fkComponente)
        REFERENCES Componente (idComponente),
PRIMARY KEY (fkComputador , fkComponente)
);

CREATE TABLE Dados (
idDados INT PRIMARY KEY AUTO_INCREMENT,
registro VARCHAR(45),
hora VARCHAR(45),
fkComponente INT,
fkComputador INT,
CONSTRAINT fkDadosComponente FOREIGN KEY (fkComponente)
	REFERENCES ComponenteComputador (fkComponente),
CONSTRAINT fkDadosComputador FOREIGN KEY (fkComputador)
	REFERENCES ComponenteComputador (fkComputador)
);

INSERT INTO Componente(nomeComponente, unidadeMedida)
VALUES("CPU", "Porcentagem");
INSERT INTO Componente(nomeComponente, unidadeMedida)
VALUES("Disco", "Porcentagem");
INSERT INTO Componente(nomeComponente, unidadeMedida)
VALUES("Rede", "KB/s");
INSERT INTO Componente(nomeComponente, unidadeMedida)
VALUES("Memória", "Porcentagem");
SELECT * FROM Componente;







