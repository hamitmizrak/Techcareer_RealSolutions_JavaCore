-- Create Database
CREATE SCHEMA `ecommerse` DEFAULT CHARACTER SET utf8 ;

-- Select
use ecommerse;

-- Table
CREATE TABLE `ecommerse`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `email` VARCHAR(45) NULL,
  `created` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

