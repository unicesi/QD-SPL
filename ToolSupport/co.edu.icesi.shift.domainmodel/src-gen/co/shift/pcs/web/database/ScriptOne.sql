DROP SCHEMA IF EXISTS `pcs` ;
CREATE SCHEMA IF NOT EXISTS `pcs` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `pcs` ;

-- -----------------------------------------------------
-- Table `pcs`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pcs`.`User` ;

CREATE TABLE IF NOT EXISTS `pcs`.`User` (
`cc` VARCHAR(200) NOT NULL,
`name` VARCHAR(200) NOT NULL,
`cellphone` VARCHAR(200) NOT NULL,
`password` VARCHAR(200) NOT NULL,
PRIMARY KEY (`cc`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `pcs`.`Risk`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pcs`.`Risk` ;

CREATE TABLE IF NOT EXISTS `pcs`.`Risk` (
`id` INT NOT NULL,
`description` VARCHAR(200) NOT NULL,
`impact` DOUBLE NOT NULL,
`name` VARCHAR(200) NOT NULL,
`probability` DOUBLE NOT NULL,
`project` INT NOT NULL,
INDEX `fk_Risk_Project_Risks` (`project` ASC)		
,PRIMARY KEY (`id`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `pcs`.`Project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pcs`.`Project` ;

CREATE TABLE IF NOT EXISTS `pcs`.`Project` (
`id` INT NOT NULL,
`description` VARCHAR(200) NOT NULL,
`name` VARCHAR(200) NOT NULL,
`startdate` DATE NOT NULL,
`manager` VARCHAR(200) NULL,
INDEX `fk_Project_User_Manager` (`manager` ASC)		
,`priorityrisk` INT NULL,
INDEX `fk_Project_Risk_PriorityRisk` (`priorityrisk` ASC)		
,PRIMARY KEY (`id`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `pcs`.`ProjectUser`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pcs`.`ProjectUser` ;

CREATE TABLE IF NOT EXISTS `pcs`.`ProjectUser` (
`projectId` INT NOT NULL,
`userCc` VARCHAR(200) NOT NULL,
PRIMARY KEY (`projectId`, `userCc`),
  INDEX `fk_Project_has_User_User_idx` (`projectId` ASC),
  INDEX `fk_Project_has_User_Project_idx` (`userCc` ASC),
  CONSTRAINT `fk_Project_has_User_Project`
    FOREIGN KEY (`projectId`)
    REFERENCES `pcs`.`Project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Project_has_User_User`
    FOREIGN KEY (`userCc`)
    REFERENCES `pcs`.`User` (`cc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Foreign Keys
-- -----------------------------------------------------
ALTER TABLE Risk ADD CONSTRAINT `c_fk_Risk_Project` FOREIGN KEY (`project`) REFERENCES `pcs`.`Project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Project ADD CONSTRAINT `c_fk_Project_User` FOREIGN KEY (`manager`) REFERENCES `pcs`.`User` (`cc`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Project ADD CONSTRAINT `c_fk_Project_Risk` FOREIGN KEY (`priorityrisk`) REFERENCES `pcs`.`Risk` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
