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
  `reciNum` INT NOT NULL AUTO_INCREMENT,
  `reciSub` VARCHAR(2048) NOT NULL,
  `reciIntro` VARCHAR(2048) NULL,
  `reciMainPic` VARCHAR(2048) NULL,
  `reciFInd` VARCHAR(2048) NULL,
  `reciSit` VARCHAR(2048) NULL,
  `reciWay` VARCHAR(2048) NULL,
  `reciMat` VARCHAR(2048) NULL,
  `reciPer` VARCHAR(2048) NULL,
  `reciTim` VARCHAR(2048) NULL,
  `reciLev` VARCHAR(2048) NULL,
  `reciTip` VARCHAR(2048) NULL,
  `reciComPic1` VARCHAR(2048) NULL,
  `reciComPic2` VARCHAR(2048) NULL,
  `reciComPic3` VARCHAR(2048) NULL,
  `reciComPic4` VARCHAR(2048) NULL,
  `reciRegdate` DATETIME NOT NULL,
  PRIMARY KEY (`reciNum`),
  FOREIGN KEY (`reciId`) REFERENCES member (`id`)
  );

CREATE TABLE IF NOT EXISTS `material` (
  `reciNum` INT NULL,
  `matNum` INT NULL AUTO_INCREMENT,
  `matName` VARCHAR(2048) NULL,
  PRIMARY KEY (`matNum`),
  FOREIGN KEY (`reciNum`) REFERENCES recipe (`reciNum`)
  );

CREATE TABLE IF NOT EXISTS `material2` (
  `reciNum` INT NULL,
  `matNum` INT NULL,
  `mat2Num` INT NULL,
  `mat2Find` VARCHAR(2048) NULL,
  `mat2Vol` VARCHAR(2048) NULL,
  PRIMARY KEY (`mat2Num`),
  FOREIGN KEY (`reciNum`) REFERENCES recipe (`reciNum`),
  FOREIGN KEY (`matNum`) REFERENCES material (`matNum`)
);

CREATE TABLE IF NOT EXISTS `recipeOrder` (
  `reciNum` INT NULL,
  `orderNum` int NULL AUTO_INCREMENT,
  `orderContent` VARCHAR(2048) NULL,
  `orderPic` VARCHAR(2048) NULL,
  PRIMARY KEY (`orderNum`),
  FOREIGN KEY (`reciNum`) REFERENCES recipe (`reciNum`)
  );
  
--   CREATE TABLE IF NOT EXISTS `recipe` (
--   `id` VARCHAR(2048) NOT NULL,
--   `name` VARCHAR(2048) NOT NULL,
--   `subject` VARCHAR(2048) NOT NULL,
--   `introduce` VARCHAR(2048) NOT NULL,
--   `cate` VARCHAR(2048) NOT NULL,
--   `infoPer` VARCHAR(2048) NOT NULL,
--   `infoTim` VARCHAR(2048) NOT NULL,
--   `infoLev` VARCHAR(2048) NOT NULL,
-- `mat` VARCHAR(2048) NOT NULL,
-- `matVol` VARCHAR(2048) NOT NULL,
-- 	`order` VARCHAR(2048) NOT NULL,
-- 	`orPic` VARCHAR(2048) NOT NULL,
-- 		`orComPic` VARCHAR(2048) NOT NULL,
--         		`orTip` VARCHAR(2048) NOT NULL,
--   `regdate` VARCHAR(2048) NOT NULL);

