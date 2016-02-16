USE `pcs` ;
-- -----------------------------------------------------
-- Table `pcs`.`Attempts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pcs`.`Attempts` ;

CREATE TABLE IF NOT EXISTS `pcs`.`Attempts` (
  `user` VARCHAR(100) NOT NULL,
  `attempts` INT NOT NULL,
  PRIMARY KEY (`user`),
  CONSTRAINT `fk_Attempts_User`
    FOREIGN KEY (`user`)
    REFERENCES `pcs`.`User` (`cc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
