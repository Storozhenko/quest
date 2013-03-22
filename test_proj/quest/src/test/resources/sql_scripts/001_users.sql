CREATE  TABLE IF NOT EXISTS `test_forms_db`.`users` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(25) NOT NULL ,
  `user_type` VARCHAR(10) NOT NULL ,
  `user_lang` VARCHAR(2) NULL ,
  PRIMARY KEY (`user_id`) ,
  UNIQUE INDEX `username_UNIQUE` (`username`) );
