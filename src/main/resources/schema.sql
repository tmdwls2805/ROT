CREATE TABLE IF NOT EXISTS `member` (
  `id` VARCHAR(2048) NOT NULL,
  `password` VARCHAR(2048) NOT NULL,
  `name` VARCHAR(2048) NOT NULL,
  `email` VARCHAR(2048) NOT NULL,
  `phone` VARCHAR(2048) NOT NULL,
  `zipcode` int NOT NULL,
  `addr1` VARCHAR(2048) NOT NULL,
  `addr2` VARCHAR(2048) NOT NULL,
  `point` VARCHAR(2048) NULL DEFAULT 0,
  `regdate` VARCHAR(2048) NOT NULL,
  UNIQUE KEY (`email`),
  PRIMARY KEY (`id`));

 CREATE TABLE IF NOT EXISTS `recipe` (
   `reciId` VARCHAR(2048) NOT NULL,
   `reciName` VARCHAR(2048) NOT NULL,
   `reciNum` INT AUTO_INCREMENT,
   `reciSub` VARCHAR(2048) NOT NULL,
   `reciIntro` VARCHAR(2048),
   `reciMainPic` VARCHAR(2048),
   `reciFInd` VARCHAR(2048),
   `reciSit` VARCHAR(2048) ,
   `reciWay` VARCHAR(2048),
  `reciMat` VARCHAR(2048),
   `reciPer` VARCHAR(2048),
  `reciTim` VARCHAR(2048),
  `reciLev` VARCHAR(2048),
   `reciTip` VARCHAR(2048),
   `reciComPic1` VARCHAR(2048) ,
   `reciComPic2` VARCHAR(2048),
   `reciComPic3` VARCHAR(2048),
  `reciComPic4` VARCHAR(2048),
   `reciRegdate` DATETIME NOT NULL,
  PRIMARY KEY (`reciNum`),
   FOREIGN KEY (`reciId`) REFERENCES member (`id`)
   );


CREATE TABLE IF NOT EXISTS `material` (
  `reciNum` INT,
  `matNum` INT AUTO_INCREMENT,
  `matName` VARCHAR(2048),
  PRIMARY KEY (`matNum`),
  FOREIGN KEY (`reciNum`) REFERENCES recipe (`reciNum`)
  );

CREATE TABLE IF NOT EXISTS `material2` (
  `reciNum` INT,
  `matNum` INT,
  `mat2Num` INT AUTO_INCREMENT,
  `mat2Find` VARCHAR(2048),
  `mat2Vol` VARCHAR(2048),
  PRIMARY KEY (`mat2Num`),
  FOREIGN KEY (`reciNum`) REFERENCES recipe (`reciNum`),
  FOREIGN KEY (`matNum`) REFERENCES material (`matNum`)
);

CREATE TABLE IF NOT EXISTS `recipeOrder` (
  `reciNum` INT NULL,
  `orderNum` int NULL AUTO_INCREMENT,
  `orderContent` VARCHAR(2048),
  `orderPic` VARCHAR(2048),
  PRIMARY KEY (`orderNum`),
  FOREIGN KEY (`reciNum`) REFERENCES recipe (`reciNum`)
  );