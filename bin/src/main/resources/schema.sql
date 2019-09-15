CREATE TABLE IF NOT EXISTS `member` (
  `id` varchar(2048) NOT NULL PRIMARY KEY,
  `password` varchar(2048) NOT NULL,
  `name` varchar(2048) NOT NULL,
  `email` varchar(2048) NOT NULL,
  `phone` varchar(2048) NOT NULL,
  `zipcode` int(11) NOT NULL,
  `addr1` varchar(2048) NOT NULL,
  `addr2` varchar(2048) DEFAULT NULL,
  `point` int(11) default 0,
  `regdate` datetime,
   UNIQUE KEY `email` (`email`)
);

