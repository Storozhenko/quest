CREATE  TABLE IF NOT EXISTS `test_forms_db`.`forms` (
  `form_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `form_name` VARCHAR(45) NOT NULL ,
  `user_id` BIGINT NOT NULL ,
  `form_date` DATE NOT NULL ,
  `form_descr` VARCHAR(45) NULL ,
  PRIMARY KEY (`form_id`) ,
  INDEX `user_id_idx` (`user_id` ASC) ,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name`) ,
  CONSTRAINT `form_user_id`
  FOREIGN KEY (`user_id` )
  REFERENCES `forms_db`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
