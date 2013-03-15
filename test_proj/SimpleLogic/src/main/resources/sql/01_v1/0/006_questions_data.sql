CREATE  TABLE IF NOT EXISTS `test_forms_db`.`questions_data` (
  `question_data_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `question_id` BIGINT NOT NULL ,
  `question_option` INT NOT NULL ,
  `option_data` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`question_data_id`) ,
  INDEX `question_id_idx` (`question_id` ASC) ,
  UNIQUE INDEX `question_id_UNIQUE` (`question_id`,`question_option`) ,
  CONSTRAINT `questions_data_question_id`
  FOREIGN KEY (`question_id` )
  REFERENCES `forms_db`.`questions` (`question_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE);
