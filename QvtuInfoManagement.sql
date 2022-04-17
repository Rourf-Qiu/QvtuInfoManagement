/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : information

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-07-05 11:57:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_ID` bigint NOT NULL,
  `message_Title` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `message_Txt` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `message_Name` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`message_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1625418991899', '关于暑假的通知-8', '关于暑假的通知-8', '邱津芳');
INSERT INTO `message` VALUES ('1625457325704', '关于暑假的通知-1', '关于暑假的通知-1', '邱津芳');
INSERT INTO `message` VALUES ('1625457331491', '关于暑假的通知-2', '关于暑假的通知-2', '邱津芳');
INSERT INTO `message` VALUES ('1625457336323', '关于暑假的通知-3', '关于暑假的通知-3', '邱津芳');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` bigint NOT NULL,
  `userName` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `userSex` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `userClass` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `userType` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `userIdentity` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ID` bigint NOT NULL,
  `userPSW` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`userID`,`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('194031521', '罗章威', '男', '19计应1班', '管理员', '学生', '1624869532750', '123456');
INSERT INTO `user` VALUES ('194031523', '邱津芳', '女', '19计应1班', '管理员', '学生', '1624894394907', '123456');
INSERT INTO `user` VALUES ('194031525', '阮志鸿', '男', '19计应1班', '普通用户', '学生', '1624848674004', '123456');
INSERT INTO `user` VALUES ('2189371287', '阮志鸿', '男', '19计应3班	', '管理员', '学生', '1624890696041', '123456');
