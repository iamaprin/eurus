/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : DB_VY_CORE

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-06-04 23:03:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `acc_username` varchar(32) NOT NULL COMMENT '用户名',
  `acc_password` varchar(64) NOT NULL COMMENT '密码',
  `token` varchar(128) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '记录创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `is_deleted` tinyint(3) unsigned zerofill NOT NULL COMMENT '记录是否被删除：0-否 1-是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for account_r_member
-- ----------------------------
DROP TABLE IF EXISTS `account_r_member`;
CREATE TABLE `account_r_member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` int(10) unsigned NOT NULL,
  `member_id` int(10) unsigned NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_r_member
-- ----------------------------

-- ----------------------------
-- Table structure for account_r_role
-- ----------------------------
DROP TABLE IF EXISTS `account_r_role`;
CREATE TABLE `account_r_role` (
  `id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_r_role
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mem_name` varchar(32) NOT NULL,
  `mem_sex` tinyint(255) NOT NULL,
  `mem_birth` date NOT NULL,
  `mem_mobile` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------

-- ----------------------------
-- Table structure for perm
-- ----------------------------
DROP TABLE IF EXISTS `perm`;
CREATE TABLE `perm` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `perm_name` varchar(32) NOT NULL,
  `perm_desc` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of perm
-- ----------------------------

-- ----------------------------
-- Table structure for perm_r_role
-- ----------------------------
DROP TABLE IF EXISTS `perm_r_role`;
CREATE TABLE `perm_r_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `perm_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of perm_r_role
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) NOT NULL,
  `role_desc` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
