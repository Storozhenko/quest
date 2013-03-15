CREATE  TABLE IF NOT EXISTS `test_forms_db`.`answ_forms` (
  `answ_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `form_id` BIGINT NOT NULL ,
  `user_id` BIGINT NOT NULL ,
  `answ_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`answ_id`) ,
  INDEX `form_id_idx` (`form_id` ASC) ,
  INDEX `user_id_idx` (`user_id` ASC) ,
  UNIQUE INDEX `user_answ_UNIQUE` (`form_id`, `user_id`, `answ_datetime`) ,
  CONSTRAINT `answ_forms_form_id`
  FOREIGN KEY (`form_id` )
  REFERENCES `forms_db`.`forms` (`form_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `answ_forms_user_id`
  FOREIGN KEY (`user_id` )
  REFERENCES `forms_db`.`users` (`user_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE);

