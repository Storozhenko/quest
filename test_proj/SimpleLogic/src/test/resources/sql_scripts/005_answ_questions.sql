CREATE  TABLE IF NOT EXISTS `test_forms_db`.`answ_questions` (
  `answ_question_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `answ_id` BIGINT NOT NULL ,
  `question_id` BIGINT NOT NULL ,
  `user_answer` VARCHAR(80) NULL ,
  INDEX `answ_id_idx` (`answ_id` ASC) ,
  INDEX `question_id_idx` (`question_id` ASC) ,
  PRIMARY KEY (`answ_question_id`) ,
  CONSTRAINT `answ_quest_answ_id`
  FOREIGN KEY (`answ_id` )
  REFERENCES `forms_db`.`answ_forms` (`answ_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `answ_quest_question_id`
  FOREIGN KEY (`question_id` )
  REFERENCES `forms_db`.`questions` (`question_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE);

