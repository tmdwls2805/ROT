CREATE TABLE IF NOT EXISTS `bank` (
  `account` varchar(30) NOT NULL,
  `bank` varchar(10) NOT NULL,
  `name` varchar(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS `member` (
  `id` varchar(15) NOT NULL PRIMARY KEY,
  `password` varchar(30) NOT NULL,
  `name` varchar(14) NOT NULL,
  `email1` varchar(20) NOT NULL,
  `email2` varchar(20) NOT NULL,
  `sent` varchar(2048) NOT NULL,
  `ph1` int(6) NOT NULL,
  `ph2` int(6) NOT NULL,
  `ph3` int(6) NOT NULL,
  `gender` varchar(2048) NOT NULL,
  `birth1` int(6) NOT NULL,
  `birth2` int(6) NOT NULL,
  `birth3` int(6) NOT NULL,
  `smoking` varchar(2048) NOT NULL,
  `vehicle` varchar(2048) NOT NULL,
  `zipcode` int(11) NOT NULL,
  `addr1` varchar(2048) NOT NULL,
  `addr2` varchar(2048) DEFAULT NULL,
  `regdate` datetime,
  UNIQUE KEY `email1` (`email1`)
);

CREATE TABLE IF NOT EXISTS `cart` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  `buyer` varchar(50) NOT NULL,
  `carId` int(11) NOT NULL,
  `carTitle` varchar(100) NOT NULL,
  `buyPrice` int(11) NOT NULL,
  `buyCount` tinyint(4) NOT NULL,
  `carImage` varchar(16) DEFAULT 'nothing.jpg',
  PRIMARY KEY (`cartId`),
  UNIQUE `buyer` (`buyer`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`buyer`) REFERENCES `member` (`id`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `buy` (
  `buyId` bigint(20) NOT NULL,
  `buyer` varchar(50) PRIMARY KEY,
  `carId` varchar(12) NOT NULL,
  `carTitle` varchar(100) NOT NULL,
  `buyPrice` int(11) NOT NULL,
  `buyCount` tinyint(4) NOT NULL,
  `carImage` varchar(16) DEFAULT 'nothing.jpg',
  `buyDate` datetime NOT NULL,
  `deliveryName` varchar(10) NOT NULL,
  `deliveryTel` varchar(20) NOT NULL,
  `deliveryZipcode` int(11) NOT NULL,
  `deliveryAddr1` varchar(2048) NOT NULL,
  `deliveryAddr2` varchar(2048) NOT NULL,
  `sanction` varchar(50) DEFAULT '차량준비중',
  `hour` varchar(10) NOT NULL,
  `minute` varchar(10) NOT NULL,
  `amPm` varchar(10) NOT NULL,
  `year` varchar(10) NOT NULL,
  `month` varchar(10) NOT NULL,
  `day` varchar(10) NOT NULL,
  `payment` varchar(20) NOT NULL,
  CONSTRAINT `buy_ibfk_1` FOREIGN KEY (`buyer`) REFERENCES `member` (`id`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `freeBoard` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `writer` varchar(15) NOT NULL,
  `subject` varchar(2048) NOT NULL,
  `email` varchar(2047) DEFAULT NULL,
  `content` varchar(2048) NOT NULL,
  `passwd` varchar(30) NOT NULL,
  `regDate` datetime NOT NULL,
  `readCount` int(11) DEFAULT '0',
  `ref` int(11) NOT NULL,
  `reStep` smallint(6) NOT NULL,
  `reLevel` smallint(6) NOT NULL,
  `ip` varchar(20) NOT NULL,
  `file` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`num`),
  UNIQUE KEY `writer` (`writer`),
  CONSTRAINT `freeBoard_ibfk_1` FOREIGN KEY (`writer`) REFERENCES `member` (`id`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `rentals` (
  `carId` int(11) NOT NULL AUTO_INCREMENT,
  `carKind` varchar(50) NOT NULL,
  `carTitle` varchar(100) NOT NULL,
  `carOil` varchar(30) NOT NULL,
  `carPrice` int(11) NOT NULL,
  `carCount` smallint(6) NOT NULL,
  `carImage` varchar(16) DEFAULT NULL,
  `carContent` text NOT NULL,
  `discountRate1` tinyint(4) DEFAULT '10',
  `discountRate2` tinyint(4) DEFAULT '10',
  `regDate` datetime NOT NULL,
  PRIMARY KEY (`carId`)
);

CREATE TABLE IF NOT EXISTS `reBoard` (
  `reNum` int(11) NOT NULL AUTO_INCREMENT,
  `reName` varchar(20) NOT NULL,
  `reContent` varchar(4000) NOT NULL,
  `reDate` datetime DEFAULT NULL,
  `reIpAddr` varchar(50) DEFAULT NULL,
  `boardNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`reNum`),
  UNIQUE KEY `boardNum` (`boardNum`),
  UNIQUE KEY `reName` (`reName`),
  CONSTRAINT `reBoard_ibfk_1` FOREIGN KEY (`boardNum`) REFERENCES `freeBoard` (`num`) ON DELETE CASCADE,
  CONSTRAINT `reBoard_ibfk_2` FOREIGN KEY (`reName`) REFERENCES `member` (`id`) ON DELETE CASCADE
);