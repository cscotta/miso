CREATE DATABASE IF NOT EXISTS miso;
USE miso;
CREATE TABLE IF NOT EXISTS `[[ModelNameLowercase]]` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  [[ColumnLinesForSQL]]
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;