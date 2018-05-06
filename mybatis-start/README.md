###### 1.准备工作
****1.1 建表****

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  `dept` varchar(254) NOT NULL DEFAULT '',
  `website` varchar(254) DEFAULT '',
  `phone` varchar(16) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

****1.2 插入数据****

INSERT INTO `user` VALUES ('1', 'testName', 'Tech', 'http://www.tx.com', '13800009988');