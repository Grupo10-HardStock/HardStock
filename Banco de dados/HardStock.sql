CREATE DATABASE HardStock;
USE HardStock;

CREATE TABLE empresa(
idEmpresa INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45) not null,
email varchar(45) not null,
cnpj CHAR(18) not null
);

CREATE TABLE funcionario(
idFuncionario INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45) not null,
email VARCHAR(45) not null,
senha VARCHAR(255) not null,
cargo VARCHAR(45) not null,
fkEmpresa int,
CONSTRAINT fkFuncionarioEmpresa FOREIGN KEY(fkEmpresa)
	REFERENCES empresa(idEmpresa)
);

CREATE TABLE servidor(
idServidor INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45) not null,
fkEmpresa int,
CONSTRAINT fkComputadorEmpresa FOREIGN KEY(fkEmpresa) REFERENCES empresa(idEmpresa)
);

CREATE TABLE componente(
idComponente INT PRIMARY KEY AUTO_INCREMENT,
nomeComponente VARCHAR(45) not null,
unidadeMedida VARCHAR(45) not null
);

CREATE TABLE captura (
fkServidor INT,
fkComponente INT,
registro VARCHAR(255) not null,
dtHora DATETIME not null,
CONSTRAINT fkServidorComponente FOREIGN KEY (fkServidor) REFERENCES servidor (idServidor),
CONSTRAINT fkComponenteServidor FOREIGN KEY (fkComponente) REFERENCES componente (idComponente),
PRIMARY KEY (fkServidor, fkComponente)
);

CREATE TABLE alerta (
idAlerta INT,
fkComponente INT,
fkServidor INT,
CONSTRAINT fkServidorAlerta FOREIGN KEY (fkServidor) REFERENCES servidor (idServidor),
CONSTRAINT fkComponenteAlerta FOREIGN KEY (fkComponente) REFERENCES componente (idComponente),
PRIMARY KEY (idAlerta, fkComponente, fkServidor)
);

CREATE TABLE relatório (
idRelatorio INT PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(255) not null,
destinatario VARCHAR(45) not null,
fkCaptura INT,
fkComponente INT,
fkServidor INT,

CONSTRAINT fkCapturaRelatorio FOREIGN KEY (fkCaptura) REFERENCES captura (idCaptura),
CONSTRAINT fkComponenteRelatorio FOREIGN KEY (fkComponente) REFERENCES componente (idComponente),
CONSTRAINT fkServidorRelatorio FOREIGN KEY (fkServidor) REFERENCES servidor (idServidor),
PRIMARY KEY (idRelatorio, fkCaptura, fkComponente, fkServidor)
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







