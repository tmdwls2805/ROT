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
  `nickname` varchar(2048) NOT NULL,
  `profileImg` varchar(2048) DEFAULT 'profile.png',
  `profileImgOriName` VARCHAR(2048) DEFAULT 'profile.png',
  `profileImgUrl` VARCHAR(2048) DEFAULT 'D:\\upload\\profile\\', 
  `regdate` VARCHAR(2048) NOT NULL,
  UNIQUE KEY (`email`),
  PRIMARY KEY (`id`));
  
  CREATE TABLE IF NOT EXISTS `product` (
  `productNum` int  AUTO_INCREMENT,
  `productKind` VARCHAR(2048) not null,
  `productName` VARCHAR(2048) not null,
  `productOrigin` VARCHAR(2048) not null,
  `productPrice` int not null,
  `productVolume` VARCHAR(2048) not null,
  `productCount` int not null,
  `productImg` VARCHAR(2048),
  `productImgOriName` VARCHAR(2048),
  `productImgUrl` VARCHAR(2048),
  `productCom` int default 0, 
  PRIMARY KEY (`productName`)
  );	

 CREATE TABLE IF NOT EXISTS `recipe` (
   `reciId` VARCHAR(2048) NOT NULL,
   `reciName` VARCHAR(2048) NOT NULL,
   `reciNum` INT AUTO_INCREMENT,
   `reciSub` VARCHAR(2048) NOT NULL,
   `reciIntro` VARCHAR(2048),
   `reciMainPic` VARCHAR(2048),
  `reciMainPicOriName` VARCHAR(2048),
  `reciMainPicUrl` VARCHAR(2048),
   `reciFInd` VARCHAR(2048),
   `reciSit` VARCHAR(2048) ,
   `reciWay` VARCHAR(2048),
  `reciMat` VARCHAR(2048),
   `reciPer` VARCHAR(2048),
  `reciTim` VARCHAR(2048),
  `reciLev` VARCHAR(2048),
   `reciTip` VARCHAR(2048),
	`reciStatus` VARCHAR(2048),
    `reciLookUp` int default 0,
   `reciRegdate` DATETIME NOT NULL,
  PRIMARY KEY (`reciNum`),
   FOREIGN KEY (`reciId`) REFERENCES member (`id`) ON DELETE CASCADE 
   );


CREATE TABLE IF NOT EXISTS `material` (
  `reciInputNum` INT,
  `matNum` INT AUTO_INCREMENT,
  `matName` VARCHAR(2048),
  PRIMARY KEY (`matNum`),
  FOREIGN KEY (`reciInputNum`) REFERENCES recipe (`reciNum`) ON DELETE CASCADE 
  );

CREATE TABLE IF NOT EXISTS `material2` (
  `reciInputNum` INT,
  `matInputNum` INT,
  `mat2Num` INT AUTO_INCREMENT,
  `mat2Find` VARCHAR(2048),
  `mat2Vol` VARCHAR(2048),
  PRIMARY KEY (`mat2Num`),
  FOREIGN KEY (`reciInputNum`) REFERENCES recipe (`reciNum`) ON DELETE CASCADE ,
  FOREIGN KEY (`matInputNum`) REFERENCES material (`matNum`)
);

CREATE TABLE IF NOT EXISTS `recipeOrder` (
  `reciInputNum` INT NULL,
  `orderNum` int NULL AUTO_INCREMENT,
  `orderContent` VARCHAR(2048),
  `orderPic` VARCHAR(2048),
  `orderPicOriName` VARCHAR(2048),
  `orderPicUrl` VARCHAR(2048),  
  PRIMARY KEY (`orderNum`),
  FOREIGN KEY (`reciInputNum`) REFERENCES recipe (`reciNum`) ON DELETE CASCADE 
  );
  
CREATE TABLE IF NOT EXISTS `cart` (
	`cartNum` int AUTO_INCREMENT, 
    `productNum` int not null,
	`productName` varchar(2048) not null,    
	`productPrice` int not null,  
    `buyer` varchar(2048) not null,
    `buyCount` int not null,
    `buyAmount` int not null,
     PRIMARY KEY (`cartNum`),
     FOREIGN KEY (`productName`) REFERENCES product (`productName`) on update cascade,
     FOREIGN KEY (`buyer`) REFERENCES member (`id`)
);
