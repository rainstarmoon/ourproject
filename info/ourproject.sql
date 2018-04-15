/*
Navicat MySQL Data Transfer

Source Server         : lc
Source Server Version : 50721
Source Host           : 192.168.1.111:3306
Source Database       : ourproject

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-15 11:30:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_cloud_disc`
-- ----------------------------
DROP TABLE IF EXISTS `t_cloud_disc`;
CREATE TABLE `t_cloud_disc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userno` int(11) DEFAULT NULL,
  `totalsize` decimal(30,2) DEFAULT NULL,
  `freesize` decimal(30,2) DEFAULT NULL,
  `imagesize` decimal(30,2) DEFAULT NULL,
  `documentsize` decimal(30,2) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_disc` (`userno`),
  CONSTRAINT `fk_user_disc` FOREIGN KEY (`userno`) REFERENCES `t_sys_user` (`no`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cloud_disc
-- ----------------------------

-- ----------------------------
-- Table structure for `t_file`
-- ----------------------------
DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `path` varchar(200) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `size` decimal(30,1) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `discid` int(11) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `createuserno` int(11) DEFAULT NULL,
  `updatedate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updateuserno` int(11) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_disc_file` (`discid`),
  KEY `fk_file_file` (`parentid`),
  KEY `fk_create_user_file` (`createuserno`),
  KEY `fk_update_user_file` (`updateuserno`),
  CONSTRAINT `fk__create_user_file` FOREIGN KEY (`createuserno`) REFERENCES `t_sys_user` (`no`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_disc_file` FOREIGN KEY (`discid`) REFERENCES `t_cloud_disc` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_file_file` FOREIGN KEY (`parentid`) REFERENCES `t_file` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_update_user_file` FOREIGN KEY (`updateuserno`) REFERENCES `t_sys_user` (`no`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_file
-- ----------------------------

-- ----------------------------
-- Table structure for `t_file_communicate`
-- ----------------------------
DROP TABLE IF EXISTS `t_file_communicate`;
CREATE TABLE `t_file_communicate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fileid` int(11) DEFAULT NULL,
  `ownerdiscid` int(11) DEFAULT NULL,
  `sharediscid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_disc_owner` (`ownerdiscid`),
  KEY `fk_disc_share` (`sharediscid`),
  KEY `fk_file_communnicate` (`fileid`),
  CONSTRAINT `fk_disc_owner` FOREIGN KEY (`ownerdiscid`) REFERENCES `t_cloud_disc` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_disc_share` FOREIGN KEY (`sharediscid`) REFERENCES `t_cloud_disc` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_file_communnicate` FOREIGN KEY (`fileid`) REFERENCES `t_file` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_file_communicate
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(200) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', '5a637545ec3cf1e7803882fc', 'xiazeyu', 'xiazeyu', null, null, '1');
