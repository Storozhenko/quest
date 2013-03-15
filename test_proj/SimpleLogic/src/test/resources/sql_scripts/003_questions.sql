CREATE  TABLE IF NOT EXISTS `test_forms_db`.`questions` (
  `question_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `form_id` BIGINT NOT NULL ,
  `question_name` VARCHAR(45) NOT NULL ,
  `question_type` INT NOT NULL ,
  `question_descr` VARCHAR(45) NULL ,
  PRIMARY KEY (`question_id`) ,
  INDEX `form_id_idx` (`form_id` ASC) ,
  CONSTRAINT `questions_form_id`
  FOREIGN KEY (`form_id` )
  REFERENCES `forms_db`.`forms` (`form_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE);
