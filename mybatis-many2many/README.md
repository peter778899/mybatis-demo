###### 1.准备工作
****建表****

1、创建User表

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL DEFAULT '',
  `mobile` varchar(16) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO `user` VALUES ('1', 'yiibai', '13838009988');
INSERT INTO `user` VALUES ('2', 'User-name-1', '13838009988');

2、创建Group表

CREATE TABLE `group` (
  `group_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `group_name` varchar(254) NOT NULL DEFAULT '',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `group` VALUES ('1', 'Group-1');
INSERT INTO `group` VALUES ('2', 'Group-2');

3、创建用户组映射表user_group 

CREATE TABLE `user_group` (
  `user_id` int(10) unsigned NOT NULL DEFAULT '0',
  `group_id` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user_group` VALUES ('1', '1');
INSERT INTO `user_group` VALUES ('2', '1');
INSERT INTO `user_group` VALUES ('1', '2');