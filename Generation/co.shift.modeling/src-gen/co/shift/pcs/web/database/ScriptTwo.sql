USE `pcs` ;

-- -----------------------------------------------------
-- Table `pcs`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pcs`.`Roles` ;

CREATE TABLE IF NOT EXISTS `pcs`.`Roles` (
  `name` VARCHAR(200) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pcs`.`Services`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pcs`.`Services` ;

CREATE TABLE IF NOT EXISTS `pcs`.`Services` (
  `name` VARCHAR(200) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pcs`.`Rights`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pcs`.`Rights` ;

CREATE TABLE IF NOT EXISTS `pcs`.`Rights` (
  `role` VARCHAR(200) NOT NULL,
  `service` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`role`, `service`),
  INDEX `fk_Roles_has_Services_Services1_idx` (`service` ASC),
  INDEX `fk_Roles_has_Services_Roles1_idx` (`role` ASC),
  CONSTRAINT `fk_Roles_has_Services_Roles1`
    FOREIGN KEY (`role`)
    REFERENCES `pcs`.`Roles` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Roles_has_Services_Services1`
    FOREIGN KEY (`service`)
    REFERENCES `pcs`.`Services` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `pcs`.`UserRole`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pcs`.`UserRole` ;
CREATE TABLE IF NOT EXISTS `pcs`.`UserRole` (
  `user` VARCHAR(200) NOT NULL,
  `role` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`user`, `role`),
  INDEX `fk_User_has_Role_Role_idx` (`role` ASC),
  INDEX `fk_UUser_has_Role_User_idx` (`user` ASC),
  CONSTRAINT `fk_User_has_Role_User`
    FOREIGN KEY (`user`)
    REFERENCES `pcs`.`User` (`cc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Role_Role`
    FOREIGN KEY (`role`)
    REFERENCES `pcs`.`Roles` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
