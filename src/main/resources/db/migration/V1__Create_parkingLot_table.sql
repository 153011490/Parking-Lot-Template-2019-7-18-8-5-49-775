DROP TABLE IF EXISTS parkingLot ;
CREATE TABLE `parkingLot` (
  `name` varchar(10) NOT NULL UNIQUE,
  `capacity` INT(10) UNSIGNED NOT NULL,
  `location` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;