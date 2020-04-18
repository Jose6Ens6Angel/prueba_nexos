CREATE DATABASE prueba_nexos;

SET FOREIGN_KEY_CHECKS=0

DROP TABLE IF EXISTS `Log_Auditoria` CASCADE
;

DROP TABLE IF EXISTS `Familiar` CASCADE
;

DROP TABLE IF EXISTS `Usuario` CASCADE
;

CREATE TABLE `Log_Auditoria`
(
	`id` INTEGER,
	`campos_in` TEXT,
	`campos_out` TEXT
)
;

CREATE TABLE `Familiar`
(
	`id` INTEGER NOT NULL AUTO_INCREMENT ,
	`id_familiar` INTEGER,
	`nombre` VARCHAR(50),
	`apellido` VARCHAR(50),
	`celular` VARCHAR(15),
	`direccion` VARCHAR(100),
	CONSTRAINT `PK_Familiar` PRIMARY KEY (`id`)
)
;

CREATE TABLE `Usuario`
(
	`id` INTEGER NOT NULL AUTO_INCREMENT ,
	`Nombre` VARCHAR(50) NOT NULL,
	`Apellido` VARCHAR(50) NOT NULL,
	`Documento` VARCHAR(20) NOT NULL,
	`Direccion` VARCHAR(100) NOT NULL,
	`Cantidad_Personas` INTEGER NOT NULL,
	`Tipo_Doc` INTEGER NOT NULL,
	`Fecha_Naci` DATE NOT NULL,
	`Ciudad` VARCHAR(50) NOT NULL,
	`Ocupacion` VARCHAR(50) NOT NULL,
	`celular` VARCHAR(15),
	CONSTRAINT `PK_Usuario` PRIMARY KEY (`id`)
)
;

ALTER TABLE `Familiar` 
 ADD INDEX `IXFK_Familiar_Usuario` (`id_familiar` ASC)
;

ALTER TABLE `Familiar` 
 ADD CONSTRAINT `FK_Familiar_Usuario`
	FOREIGN KEY (`id_familiar`) REFERENCES `Usuario` (`id`) ON DELETE Restrict ON UPDATE Restrict
;

SET FOREIGN_KEY_CHECKS=1
