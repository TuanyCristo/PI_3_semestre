-- Active: 1715198451493@@127.0.0.1@3306
CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE Usuarios(
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(50) NOT NULL, 
    senha VARCHAR(8) NOT NULL,
    tipo ENUM('regular', 'admin')
);