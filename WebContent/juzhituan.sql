/*
Navicat MySQL Data Transfer

Source Server         : 聚职团
Source Server Version : 50623
Source Host           : 175.102.4.163:3306
Source Database       : juzhituan

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2015-03-20 23:50:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `activityId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `publicationId` int(32) unsigned zerofill NOT NULL,
  `recruitNumM` smallint(16) unsigned NOT NULL,
  `recruitNum` smallint(16) unsigned NOT NULL,
  `applyNumM` smallint(16) unsigned NOT NULL DEFAULT '0',
  `applyNum` smallint(16) unsigned NOT NULL DEFAULT '0',
  `salary` int(32) unsigned NOT NULL,
  `workAddress` varchar(200) NOT NULL,
  `workDate` date NOT NULL,
  `detail` varchar(200) NOT NULL,
  `isGenderRequired` tinyint(8) unsigned NOT NULL,
  `state` tinyint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`activityId`),
  KEY `publicationId` (`publicationId`),
  CONSTRAINT `t_activity_ibfk_1` FOREIGN KEY (`publicationId`) REFERENCES `t_publication` (`publicationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1145 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_activity
-- ----------------------------
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001079', '00000000000000000000000000000390', '0', '2', '0', '1', '80', '江苏南通崇川区小学、初中校门口', '2015-02-28', '9:00至17:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001080', '00000000000000000000000000000391', '0', '10', '0', '2', '100', '江苏南通崇川区南通开发区源兴花苑', '2015-02-27', '16:00至19:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001082', '00000000000000000000000000000393', '0', '20', '0', '0', '80', '江苏南通崇川区南通市各高校校园', '2015-03-02', '9:00至17:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001083', '00000000000000000000000000000393', '0', '20', '0', '0', '80', '江苏南通崇川区南通市各高校校园', '2015-03-03', '9:00至17:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001084', '00000000000000000000000000000393', '0', '20', '0', '0', '80', '江苏南通崇川区南通市各高校校园', '2015-03-04', '9:00至17:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001085', '00000000000000000000000000000393', '0', '20', '0', '0', '80', '江苏南通崇川区南通市各高校校园', '2015-03-05', '9:00至17:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001086', '00000000000000000000000000000393', '0', '20', '0', '0', '80', '江苏南通崇川区南通市各高校校园', '2015-03-06', '9:00至17:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001087', '00000000000000000000000000000394', '0', '3', '0', '2', '60', '江苏南通崇川区中南世纪城向西200米', '2015-02-28', '08:00至11:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001089', '00000000000000000000000000000396', '0', '20', '0', '5', '100', '江苏南通崇川区青年中路98号新天地', '2015-03-01', '17:00至21:30,包工作餐(一餐)', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001091', '00000000000000000000000000000398', '0', '3', '0', '0', '110', '上海上海青浦区盈港东路168号上海国家会展中心', '2015-03-18', '9:00至17:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001092', '00000000000000000000000000000398', '0', '3', '0', '0', '110', '上海上海青浦区盈港东路168号上海国家会展中心', '2015-03-19', '9:00至17:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001093', '00000000000000000000000000000398', '0', '3', '0', '0', '110', '上海上海青浦区盈港东路168号上海国家会展中心', '2015-03-20', '9:00至17:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001094', '00000000000000000000000000000399', '0', '2', '0', '0', '100', '上海上海徐汇区零陵路800号东亚馆', '2015-03-24', '10:00至04:00,包工作餐(一餐)', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001097', '00000000000000000000000000000402', '0', '2', '0', '0', '30', '江苏南通崇川区南大街', '2015-03-18', '14:30至16:30,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001098', '00000000000000000000000000000403', '0', '2', '0', '2', '120', '上海上海松江区新松江路3416号二楼', '2015-03-16', '10:00至17:00,不包工作餐', '3', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001099', '00000000000000000000000000000404', '0', '3', '0', '3', '20', '上海上海松江区文汇路三期四期', '2015-03-15', '11:30至12:30,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001100', '00000000000000000000000000000404', '0', '3', '0', '3', '20', '上海上海松江区文汇路三期四期', '2015-03-16', '11:30至12:30,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001101', '00000000000000000000000000000404', '0', '3', '0', '3', '20', '上海上海松江区文汇路三期四期', '2015-03-17', '11:30至12:30,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001102', '00000000000000000000000000000405', '0', '1', '0', '1', '1500', '上海上海松江区文城路500弄', '2015-03-18', '9:00至17:00,不包工作餐', '2', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001103', '00000000000000000000000000000406', '0', '3', '0', '3', '80', '上海上海松江区开元地中海', '2015-03-19', '11:00至18:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001104', '00000000000000000000000000000406', '0', '3', '0', '3', '80', '上海上海松江区开元地中海', '2015-03-20', '11:00至18:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001105', '00000000000000000000000000000407', '0', '1', '0', '1', '140', '江苏南通崇川区虹桥小区', '2015-03-21', '14:00至16:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001106', '00000000000000000000000000000408', '0', '1', '0', '1', '2500', '上海上海宝山区宝山月浦公园附近', '2015-03-16', '16:00至20:00,包工作餐(一餐)，包住宿', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001108', '00000000000000000000000000000410', '0', '2', '0', '2', '40', '上海上海松江区工技大教学楼', '2015-03-16', '11:30至13:30,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001109', '00000000000000000000000000000411', '0', '10', '0', '10', '160', '上海上海普陀区长风公园附近万豪酒店', '2015-03-17', '10:30至19:30,包工作餐(两餐)', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001110', '00000000000000000000000000000412', '0', '10', '0', '10', '170', '上海上海黄浦区人民广场', '2015-03-18', '10:30至20:00,包工作餐(两餐)', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001111', '00000000000000000000000000000412', '0', '5', '0', '5', '170', '上海上海黄浦区人民广场', '2015-03-19', '10:30至20:00,包工作餐(两餐)', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001112', '00000000000000000000000000000412', '0', '6', '0', '6', '170', '上海上海黄浦区人民广场', '2015-03-20', '10:30至20:00,包工作餐(两餐)', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001113', '00000000000000000000000000000413', '0', '4', '0', '4', '90', '上海上海青浦区盈港东路168号', '2015-03-18', '10:30至14:30,不包工作餐', '2', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001114', '00000000000000000000000000000414', '0', '1', '0', '0', '1800', '上海上海闵行区莘庄', '2015-03-16', '12:00至16:30,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001115', '00000000000000000000000000000415', '0', '1', '0', '0', '1800', '上海上海闵行区莘庄', '2015-03-16', '12:00至16:30,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001116', '00000000000000000000000000000416', '0', '1', '0', '0', '480', '江苏南通崇川区南大街有斐大酒店内', '2015-03-17', '07:30至15:30,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001117', '00000000000000000000000000000417', '0', '10', '0', '0', '100', '江苏南通崇川区南大街', '2015-03-17', '9:00至17:00,不包工作餐，电话0513-85291801', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001118', '00000000000000000000000000000418', '0', '1', '0', '0', '160', '江苏南通崇川区姜灶', '2015-03-17', '13:00至14:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001119', '00000000000000000000000000000419', '0', '1', '0', '1', '200', '上海上海闵行区浦江镇', '2015-03-17', '12:00至17:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001120', '00000000000000000000000000000420', '0', '2', '0', '2', '35', '江苏南通崇川区学田小区', '2015-03-18', '14:30至16:30,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001121', '00000000000000000000000000000421', '0', '1', '0', '0', '150', '江苏南通崇川区五一路龙王桥附近', '2015-03-19', '9:00至17:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001122', '00000000000000000000000000000422', '0', '2', '0', '2', '140', '上海上海南汇区华联宣春路72号', '2015-03-18', '9:00至18:30,包工作餐(一餐)', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001123', '00000000000000000000000000000423', '0', '4', '0', '4', '20', '上海上海松江区松江七校', '2015-03-18', '11:30至12:30,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001125', '00000000000000000000000000000425', '0', '1', '0', '0', '50', '上海上海浦东新区张江高科', '2015-03-19', '11:30至13:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001126', '00000000000000000000000000000426', '0', '1', '0', '0', '50', '上海上海徐汇区漕河泾', '2015-03-20', '12:30至13:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001128', '00000000000000000000000000000428', '0', '1', '0', '1', '20', '上海上海松江区东华食堂发单', '2015-03-18', '17:00至18:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001129', '00000000000000000000000000000429', '0', '1', '0', '1', '240', '上海上海松江区松江新城', '2015-03-21', '14:00至15:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001130', '00000000000000000000000000000430', '0', '4', '0', '4', '80', '上海上海松江区地点具体再定', '2015-03-19', '18:00至21:00,不包工作餐', '3', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001132', '00000000000000000000000000000432', '0', '4', '0', '0', '600', '上海上海崇明县具体地方待定', '2015-03-21', '08:00至17:00,不包工作餐，包住宿', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001133', '00000000000000000000000000000433', '0', '4', '0', '0', '600', '上海上海崇明县具体地点待定', '2015-03-21', '08:00至17:00,不包工作餐，包住宿', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001134', '00000000000000000000000000000434', '0', '4', '0', '0', '600', '上海上海崇明县具体地点再定', '2015-03-21', '08:00至17:00,不包工作餐，包住宿', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001136', '00000000000000000000000000000436', '0', '1', '0', '1', '110', '上海上海松江区松江老城', '2015-03-22', '13:00至15:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001137', '00000000000000000000000000000437', '0', '5', '0', '0', '30', '上海上海奉贤区南桥镇', '2015-03-19', '11:00至12:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001138', '00000000000000000000000000000437', '0', '5', '0', '1', '30', '上海上海奉贤区南桥镇', '2015-03-20', '11:00至12:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001139', '00000000000000000000000000000437', '0', '5', '0', '0', '30', '上海上海奉贤区南桥镇', '2015-03-21', '11:00至12:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001140', '00000000000000000000000000000437', '0', '5', '0', '0', '30', '上海上海奉贤区南桥镇', '2015-03-22', '11:00至12:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001141', '00000000000000000000000000000437', '0', '5', '0', '0', '30', '上海上海奉贤区南桥镇', '2015-03-23', '11:00至12:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001142', '00000000000000000000000000000438', '0', '1', '0', '1', '1500', '上海上海松江区泗泾', '2015-03-21', '17:00至20:00,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001143', '00000000000000000000000000000439', '0', '14', '0', '1', '20', '上海上海松江区松江7校', '2015-03-20', '11:20至12:20,不包工作餐', '0', '0');
INSERT INTO `t_activity` VALUES ('00000000000000000000000000001144', '00000000000000000000000000000440', '0', '1', '0', '0', '4000', '江苏南通通州市金沙', '2015-03-20', '08:30至18:00,不包工作餐', '0', '0');

-- ----------------------------
-- Table structure for t_cancellation
-- ----------------------------
DROP TABLE IF EXISTS `t_cancellation`;
CREATE TABLE `t_cancellation` (
  `cancellationId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `publicationId` int(32) unsigned zerofill DEFAULT NULL,
  `activityId` int(32) unsigned zerofill DEFAULT NULL,
  `reason` varchar(200) NOT NULL,
  `time` datetime NOT NULL,
  `isDone` tinyint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`cancellationId`),
  KEY `publicationId` (`publicationId`),
  KEY `activityId` (`activityId`),
  CONSTRAINT `t_cancellation_ibfk_1` FOREIGN KEY (`publicationId`) REFERENCES `t_publication` (`publicationId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_cancellation_ibfk_2` FOREIGN KEY (`activityId`) REFERENCES `t_activity` (`activityId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cancellation
-- ----------------------------
INSERT INTO `t_cancellation` VALUES ('00000000000000000000000000000011', '00000000000000000000000000000406', null, '活动取消', '2015-03-15 17:52:05', '0');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `commentId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `employeeId` int(32) unsigned zerofill DEFAULT NULL,
  `publicationId` int(10) unsigned zerofill DEFAULT NULL,
  `workPoint` tinyint(8) unsigned NOT NULL,
  `salaryPoint` tinyint(8) unsigned NOT NULL,
  `other` varchar(200) DEFAULT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`commentId`),
  KEY `employeeId` (`employeeId`),
  KEY `publicationId` (`publicationId`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `t_employee` (`employeeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_comment_ibfk_2` FOREIGN KEY (`publicationId`) REFERENCES `t_publication` (`publicationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `employeeId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `employeeName` varchar(50) NOT NULL,
  `cellphone` char(11) NOT NULL,
  `password` char(32) NOT NULL,
  `alipayNum` varchar(50) DEFAULT NULL,
  `gender` char(1) NOT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `registerTime` datetime NOT NULL,
  `isLocked` tinyint(8) unsigned NOT NULL DEFAULT '0',
  `lastLockedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000021', '王兴华', '15162786165', '5bf56e4eabb4fdb12981ba448725348d', null, 'M', null, '2015-02-19 18:38:32', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000022', '尤海珍', '15896262005', 'ba11f40b7a1f6495861ec524e0cc2eda', null, 'F', null, '2015-02-19 18:41:00', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000023', '尚玉荣', '18860976792', '4f1931ea66437d5801d564f91a9e8156', null, 'F', null, '2015-02-19 18:56:11', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000024', '葛娇', '15896272635', 'c9c05518228218c288694f7e6f7d4982', null, 'F', null, '2015-02-19 20:35:15', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000025', '管荣', '15962971630', '946a155b096c8862a8e3e274e927e5f8', null, 'F', null, '2015-02-24 18:49:08', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000026', '宋雅蓝', '18860973226', 'f652e952b45cf6591c1847b88bfd605f', null, 'F', null, '2015-02-24 20:24:33', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000027', '魏阿男', '18761721695', '5f2051cc7d99311f05802fc1e7f4194b', null, 'M', null, '2015-02-26 13:48:20', '0', '2015-03-09 19:30:10');
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000032', '沈露', '13814715627', 'de4bab8cf9b85a4900113a94eb35cd55', null, 'F', null, '2015-02-27 14:43:17', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000033', '孙硕磊', '15601863639', '0094ad3326e94f398a0ce2e5469ed1d1', null, 'M', null, '2015-02-27 15:31:49', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000034', '王碧颖', '13162625002', '0a2cb03c4dc29cfc0d56afa46ae8fd2e', null, 'F', null, '2015-02-27 16:26:18', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000037', '王盛', '18252501396', '2050417eb820acf66fb6a70cf0e795aa', null, 'F', null, '2015-03-01 19:34:33', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000039', '李倩', '18251378850', 'fde0a4484c11b61a63c59111a353aa7a', null, 'F', null, '2015-03-02 14:28:46', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000040', '崔洋', '18362156178', '1da659ad9ad803d2020fa3e3b7ce4fbd', null, 'M', null, '2015-03-02 16:50:24', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000041', '黄少凤', '18860971986', 'b07a375a2d584775a624fb6859303ef9', null, 'F', null, '2015-03-03 19:22:43', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000042', '龙杰杰', '15000955865', '00ae2397ff50becf33129ca5f132b250', null, 'F', null, '2015-03-04 11:46:43', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000043', '罗嘉全', '15000528781', '507f513353702b50c145d5b7d138095c', null, 'M', null, '2015-03-04 11:51:30', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000044', '小王', '15962959509', '08eecd831b647f3ae3c18688bcc5e1dd', null, 'F', null, '2015-03-04 18:27:35', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000045', '王榕', '18860976050', '81b782e183e18732bfd37561fec2932b', null, 'F', null, '2015-03-05 21:16:56', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000046', '任小云', '15962753805', 'e10adc3949ba59abbe56e057f20f883e', null, 'F', null, '2015-03-07 08:26:47', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000047', '踪泱', '18071606943', '644d1e26eb79ef15778e7b111a7a5c1b', null, 'F', null, '2015-03-08 13:26:52', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000048', '刘韵诗', '18721213852', '26731706415f69a0dce5de97b260f7cb', null, 'F', null, '2015-03-08 13:39:16', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000049', '冯一舧', '18015662012', '562d33ecb298525697f8f9a9c7413a14', null, 'M', null, '2015-03-09 15:45:33', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000050', '李航', '18817828511', '54efa97af04b36e3cbd27cf0031349bf', null, 'M', null, '2015-03-12 14:02:23', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000051', '王雨艾', '13003249125', '0c7fe47f37721dd98a720917edcc466d', null, 'F', null, '2015-03-12 16:14:43', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000052', '李文', '13262880981', '4297f44b13955235245b2497399d7a93', null, 'M', null, '2015-03-13 15:09:36', '0', '2015-03-16 10:15:36');
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000053', '金后秀', '15962957596', '2cf216011e782b644b39b39c0c616ac2', null, 'F', null, '2015-03-15 17:58:24', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000054', '姜倩', '18860970870', '4556e59fe20ddc11468f97c153e75260', null, 'F', null, '2015-03-16 09:41:41', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000055', '胡星', '18252433452', '1387de03ce45eac2a11596411abadec8', null, 'M', null, '2015-03-16 13:10:47', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000056', '杨茜淼', '15851309560', 'b2d03681a1494a82e1981f494b68e025', null, 'F', '', '2015-03-16 13:32:11', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000057', '邵申莹', '18817822654', '10cbfbfe556e1cd8015b405e2b9ff9ee', null, 'F', '', '2015-03-16 14:12:48', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000058', '马雪梅', '18860971070', 'c2e454df534180fe225c70bc72aad0af', null, 'F', null, '2015-03-16 15:37:01', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000059', '宋佳颖', '13636671655', '2c92470551a8eb8382626fcfd440da55', null, 'F', null, '2015-03-17 10:01:01', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000060', '王伦', '18317028775', '611d4c3e7fec2048673c4b5a7f9c2b69', null, 'M', null, '2015-03-17 12:32:44', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000061', '胡敏梅', '15962970139', '280cb8516a643f902480f19b622a799b', null, 'F', null, '2015-03-17 14:31:20', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000062', '黄勇', '13186525869', 'e191f77f19769c51865a7cb7e52f8d01', null, 'M', null, '2015-03-17 17:38:55', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000063', '赵文超', '15851205269', 'e015a407d2944cbbc95ab028e87374ea', null, 'M', null, '2015-03-17 17:52:02', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000064', '孙玮', '18321092982', '4932b9096b31ec5c95f75fadec6323be', null, 'F', null, '2015-03-17 18:58:51', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000065', '小李', '13166778899', '4297f44b13955235245b2497399d7a93', null, 'M', null, '2015-03-17 19:12:58', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000066', '汪群鸿', '15921971397', 'a735c368cd7dcf49f2f77924d3d82d5e', null, 'M', null, '2015-03-18 12:44:28', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000068', '李君', '18984180576', 'd8fdb5987ffb1c29216c0f1d8189e0e2', null, 'F', null, '2015-03-18 15:20:23', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000069', '闾斯瑶', '15000822276', 'c36b522dfed5c72ed97a7b249f147d9e', null, 'F', null, '2015-03-18 16:56:25', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000070', '李卓贤', '15800913905', 'c464982c02865bf462cb6413a5b7eb0c', null, 'F', null, '2015-03-18 19:23:20', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000071', '朱佳义', '15618972592', '023f27cf7ec0e2e352e38b7acf3dd41c', null, 'M', null, '2015-03-18 22:01:40', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000072', '杨瑒', '15618311101', '210a89701aa71f6876ad3a3cebd93c5d', null, 'F', null, '2015-03-19 14:44:10', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000073', '张明俊', '13585901571', '1414b88c1a4137bed38033354f8d2dfe', null, 'M', null, '2015-03-19 15:18:43', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000074', '蓝春江', '15202155973', '3daace01b3bd4a1c5104e66abf7e3bc2', null, 'F', null, '2015-03-19 20:04:34', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000075', 'tyl', '13262792556', '2ef60f09887b9bf66d3eedb99b0923d0', null, 'F', null, '2015-03-19 20:12:09', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000076', '杨秉悦', '18321099017', '0bbd7be59a623534e7bbd77e4189988d', null, 'F', null, '2015-03-19 20:13:15', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000077', '朱雅琴', '18321092776', '4f5bcd16df40965310552a8358697470', null, 'F', null, '2015-03-19 20:17:28', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000078', '徐芷惠', '18317192879', '2344f1489467fe19534fc3568dd7de42', null, 'F', null, '2015-03-19 20:25:06', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000079', '乔洁雅', '18317199071', '0a23a013c648e9a1c489d2a63c12b5a5', null, 'F', null, '2015-03-19 20:28:45', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000080', '魏煦航', '13262799576', '193a24ca42b3af8f1da61ef88a1b7588', null, 'M', null, '2015-03-20 12:27:27', '0', '2015-03-20 12:33:38');
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000081', '李蜜亚', '15021863302', '88d3b64db65c7641185a459d1690fcb4', null, 'F', null, '2015-03-20 12:53:24', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000082', '刘丹', '18116214469', '36307d6224abe7e5cc410a18e97292bd', null, 'F', null, '2015-03-20 13:16:52', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000083', '闫新强', '15001957556', 'e10adc3949ba59abbe56e057f20f883e', null, 'M', null, '2015-03-20 14:27:51', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000084', '杨涵杰', '18201721132', 'c058f03ee61294375f8c4f90f69de933', null, 'M', null, '2015-03-20 15:52:43', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000085', '文晓桐', '15052471825', '03daca8e530fe317c50ca841e48b072a', null, 'F', null, '2015-03-20 16:12:38', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000086', '孙波', '13122731286', 'f5a80032de016efd82b24b1f67907fa1', null, 'F', null, '2015-03-20 19:44:56', '0', null);
INSERT INTO `t_employee` VALUES ('00000000000000000000000000000087', '马滟清', '13262792318', '3fde6bb0541387e4ebdadf7c2ff31123', null, 'F', null, '2015-03-20 23:22:53', '0', null);

-- ----------------------------
-- Table structure for t_employeepaid
-- ----------------------------
DROP TABLE IF EXISTS `t_employeepaid`;
CREATE TABLE `t_employeepaid` (
  `employeePayedId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `employeeId` int(32) unsigned zerofill NOT NULL,
  `sAlipayNum` varchar(50) NOT NULL,
  `dAlipayNum` varchar(50) NOT NULL,
  `amount` int(32) unsigned NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`employeePayedId`),
  KEY `employeeId` (`employeeId`),
  CONSTRAINT `t_employeepaid_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `t_employee` (`employeeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employeepaid
-- ----------------------------

-- ----------------------------
-- Table structure for t_employer
-- ----------------------------
DROP TABLE IF EXISTS `t_employer`;
CREATE TABLE `t_employer` (
  `employerId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `companyName` char(50) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `companyPhone` char(13) DEFAULT NULL,
  `cellphone` char(11) NOT NULL,
  `contactName` varchar(20) NOT NULL,
  `companyAddress` varchar(100) NOT NULL,
  `companyInfo` varchar(200) NOT NULL,
  `balance` double unsigned DEFAULT '0',
  `remarkPoint` tinyint(8) unsigned DEFAULT NULL,
  `licenseNum` char(13) NOT NULL,
  `recruitmentTime` int(32) unsigned DEFAULT NULL,
  `registerTime` datetime NOT NULL,
  `employerName` varchar(50) NOT NULL,
  `password` char(32) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`employerId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employer
-- ----------------------------
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000015', '南通皇家花园酒店', '江苏南通海门市', '0513-82111977', '18068958815', '施志强', '秀山西路888号', '海门超豪华五星级酒店。', null, null, '1424652545466', '0', '2015-02-23 08:50:51', '皇家花园酒店', '9e40ef107bbaea1e453fe888d134c037', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000016', '南通盘古网络技术有限公司', '江苏南通崇川区', '021-37784226', '13122870781', '丁浩', '崇川路58号3#211室', '招聘程序员！', null, null, '1424682968338', '6', '2015-02-23 17:17:45', 'smouse', '96e79218965eb72c92a549dd5a330112', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000017', '1加1教育', '江苏南通崇川区', '0513-83593935', '13912257895', '毛先生', '南通开发区源兴花苑', '1加1教育致力于培养小孩的学习习惯，思考能力，课外阅读。主要开设晚托班，周末补习班，兴趣班等。', null, null, '1424395711415', '2', '2015-02-27 12:23:09', '1jia1', '96e79218965eb72c92a549dd5a330112', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000019', '创乐钢琴培训中心', '江苏南通崇川区', '021-37784226', '18761739882', '陈老师', '通师一附', '专业钢琴培训！', null, null, '1425015058185', '1', '2015-02-27 13:32:29', 'chuangyue', '96e79218965eb72c92a549dd5a330112', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000020', '南通启秀教育培训', '江苏南通崇川区', '021-37784226', '13814715627', '沈老师', '小海镇', '招聘晚托班大学生辅导老师！', null, null, '1425019940950', '1', '2015-02-27 14:52:58', 'qxpx', '96e79218965eb72c92a549dd5a330112', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000022', '龙卷风豆捞', '江苏南通崇川区', '0513-89111111', '13951303330', '吴燕云', '青年中路98号新天地', '南通龙卷风海鲜豆捞，位于南通市青年中路98号体育公园内，总营业面积达2100平米，设有VIP包厢、豪华卡座、圆桌、休闲等待区，另设儿童游乐园，供就餐儿童玩乐，并可同时容纳400多人就餐，是南通地区最大规模的时尚餐厅。本店选用新鲜优质海鲜、江鲜，专设海鲜池，供顾客挑选，特聘名厨主理，选用各类精品食材，主推豆捞、海鲜、牛肉、川菜，为南通市民带来精致美食体验。', null, null, '1425195934005', '1', '2015-03-01 15:46:21', 'ntljfdl', 'a18f115dc89a2dae471787b4d193c9ee', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000023', '兼职首发', '上海上海松江区', '021-37784226', '18252433452', '胡先生', '文诚路', '1', null, null, '1426334675410', '10', '2015-03-14 20:21:07', '1245445099', '1387de03ce45eac2a11596411abadec8', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000024', '图存创意有限公司', '浙江温州乐清市', '021-37784226', '15202125781', '李想', '龙马路321号', '誉为图存，首必创意！', null, null, '1426341823144', '5', '2015-03-14 22:25:17', '书中倦客', 'bfc1c1da4f1f7b42710b9fa97e91a7f3', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000025', '松江小城家教培训中心', '上海上海松江区', '021-35763346', '13262880981', '俞味', '文城路500弄', '一切为了孩子，为了孩子的一切', null, null, '1426411096369', '4', '2015-03-15 17:19:36', 'rainy', 'c871c7c2086ebfab778984f7a012b795', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000026', '中国源迪有限公司', '上海上海松江区', '0577-62032307', '15325071686', '李想', '中山中路1265号三楼', '欢迎有志人士来我公司。', null, null, '1426412415057', '6', '2015-03-15 17:42:58', '清水雅然', 'bfc1c1da4f1f7b42710b9fa97e91a7f3', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000027', '稻草人工作室-家教中心', '江苏南通崇川区', '021-37784226', '18306291703', '稻草人', '崇川路58号3#211室', '南通大学生的家教介绍平台！', null, null, '1426414715112', '1', '2015-03-15 18:19:18', 'dcr201010', 'e87cb5797a5b5ba4b3454a1b87123e46', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000028', '宝山月浦晚托班', '上海上海宝山区', '021-65437788', '15021387720', '李老师', '月浦公园', '晚托班有优秀的老师，教学经验丰富，为孩子为学生为家长负责。', null, null, '1426419812622', '3', '2015-03-15 19:45:12', 'abcd', 'c871c7c2086ebfab778984f7a012b795', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000029', '佳悦咨询有限公司', '上海上海普陀区', '021-88774632', '13262280918', '肖经理', '长风公园', '上海酒店连锁咨询公司，提供上海各酒店兼职···', null, null, '1426473830784', '7', '2015-03-16 10:45:14', 'abcde', 'c871c7c2086ebfab778984f7a012b795', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000030', '上海拓图文化传播有限公司', '上海上海杨浦区', '021-53435897', '13268822007', '周先生', '国顺东路800号西楼401d', '专业的广告摄影设计团队，多年来给国内许多知名企业拍摄过产品广告图片，为国内多个时尚杂志拍摄过大片，也同时和许多国内明星有过多次良好的合作。', null, null, '1426483682682', '0', '2015-03-16 13:29:08', 'abcdef', 'c871c7c2086ebfab778984f7a012b795', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000031', '南通品摄影工作室', '江苏南通崇川区', '0513-66688673', '13166884576', '刘先生', '南大街', '专业摄影，品牌摄影工作室', null, null, '1426495417913', '1', '2015-03-16 16:44:24', 'abcedfg', 'c871c7c2086ebfab778984f7a012b795', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000032', '五星大酒店', '上海上海杨浦区', '021-33555768', '18244556677', '刘先生', '杨浦路100号', '星级酒店，长期兼职', null, null, '1426590479489', '0', '2015-03-17 19:09:16', 'gfdsa', '4297f44b13955235245b2497399d7a93', null, null);
INSERT INTO `t_employer` VALUES ('00000000000000000000000000000033', '佐佑信息服务有限公司', '浙江衢州龙游县', '0577-7654321', '13867034388', '章先生', '太平路324号', '急您所急', null, null, '1426495478782', '3', '2015-03-19 10:42:12', '优雅之神', 'bfc1c1da4f1f7b42710b9fa97e91a7f3', null, null);

-- ----------------------------
-- Table structure for t_employerpayment
-- ----------------------------
DROP TABLE IF EXISTS `t_employerpayment`;
CREATE TABLE `t_employerpayment` (
  `paymentId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `employerId` int(32) unsigned zerofill NOT NULL,
  `sBankCardNum` char(19) NOT NULL,
  `sBankName` varchar(20) NOT NULL,
  `dBankCardNum` char(19) NOT NULL,
  `amount` int(32) unsigned NOT NULL,
  `paymentTime` datetime NOT NULL,
  PRIMARY KEY (`paymentId`),
  KEY `employerId` (`employerId`),
  CONSTRAINT `t_employerpayment_ibfk_1` FOREIGN KEY (`employerId`) REFERENCES `t_employer` (`employerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employerpayment
-- ----------------------------

-- ----------------------------
-- Table structure for t_license
-- ----------------------------
DROP TABLE IF EXISTS `t_license`;
CREATE TABLE `t_license` (
  `licenseId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `licenseNum` char(13) NOT NULL,
  `generateTime` datetime NOT NULL,
  `isActived` tinyint(8) unsigned NOT NULL DEFAULT '0',
  `companyName` varchar(100) NOT NULL,
  `contactName` varchar(20) NOT NULL,
  `cellphone` char(11) NOT NULL,
  `companyPhone` char(13) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `companyAddress` varchar(200) NOT NULL,
  `companyInfo` varchar(200) NOT NULL,
  PRIMARY KEY (`licenseId`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_license
-- ----------------------------
INSERT INTO `t_license` VALUES ('00000000000000000000000000000001', '1424395711415', '2015-02-20 09:28:31', '1', '1加1教育', '毛先生', '13912257895', '0513-83593935', '江苏南通崇川区', '南通开发区源兴花苑', '1加1教育致力于培养小孩的学习习惯，思考能力，课外阅读。主要开设晚托班，周末补习班，兴趣班等。');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000002', '1424652545466', '2015-02-23 08:49:05', '1', '南通皇家花园酒店', '施志强', '18068958815', '0513-82111977', '江苏南通海门市', '秀山西路888号', '海门超豪华五星级酒店。');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000030', '1424682968338', '2015-02-23 17:16:08', '1', '南通盘古网络技术有限公司', '丁浩', '13122870781', '021-37784226', '江苏南通崇川区', '崇川路58号3#211室', '招聘程序员！');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000033', '1425015058185', '2015-02-27 13:30:58', '1', '创乐钢琴培训中心', '陈老师', '18761739882', '021-37784226', '江苏南通崇川区', '通师一附', '专业钢琴培训！');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000034', '1425019940950', '2015-02-27 14:52:20', '1', '南通启秀教育培训', '沈老师', '13814715627', '021-37784226', '江苏南通崇川区', '小海镇', '招聘晚托班大学生辅导老师！');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000037', '1425195934005', '2015-03-01 15:45:34', '1', '龙卷风豆捞', '吴燕云', '13951303330', '0513-89111111', '江苏南通崇川区', '青年中路98号新天地', '南通龙卷风海鲜豆捞，位于南通市青年中路98号体育公园内，总营业面积达2100平米，设有VIP包厢、豪华卡座、圆桌、休闲等待区，另设儿童游乐园，供就餐儿童玩乐，并可同时容纳400多人就餐，是南通地区最大规模的时尚餐厅。本店选用新鲜优质海鲜、江鲜，专设海鲜池，供顾客挑选，特聘名厨主理，选用各类精品食材，主推豆捞、海鲜、牛肉、川菜，为南通市民带来精致美食体验。');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000039', '1426334675410', '2015-03-14 20:04:35', '1', '个人', '胡先生', '18252433452', '021-37784226', '上海上海松江区', '文诚路', '1');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000042', '1426341823144', '2015-03-14 22:03:43', '1', '图存创意有限公司', '方小虎', '15202125781', '021-37784226', '江苏南通崇川区', '崇川路58号3#211室', '你好啊小伙伴！');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000043', '1426411096369', '2015-03-15 17:18:16', '1', '松江小城家教培训中心', '俞味', '13262880981', '021-35763346', '上海上海松江区', '文城路500弄', '一切为了孩子，为了孩子的一切');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000044', '1426412415057', '2015-03-15 17:40:15', '1', '中国源迪有限公司', '李想', '15325071686', '0577-62032307', '上海上海松江区', '中山中路1265号三楼', '欢迎有志人士来我公司。');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000045', '1426414715112', '2015-03-15 18:18:35', '1', '稻草人工作室-家教中心', '稻草人', '18306291703', '021-37784226', '江苏南通崇川区', '崇川路58号3#211室', '南通大学生的家教介绍平台！');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000046', '1426419812622', '2015-03-15 19:43:32', '1', '宝山月浦晚托班', '李老师', '15021387720', '021-65437788', '上海上海宝山区', '月浦公园', '晚托班有优秀的老师，教学经验丰富，为孩子为学生为家长负责。');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000047', '1426473830784', '2015-03-16 10:43:50', '1', '佳悦咨询有限公司', '肖经理', '13262280918', '021-88774632', '上海上海普陀区', '长风公园', '上海酒店连锁咨询公司，提供上海各酒店兼职···');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000048', '1426483682682', '2015-03-16 13:28:02', '1', '上海拓图文化传播有限公司', '周先生', '13268822007', '021-53435897', '上海上海杨浦区', '国顺东路800号西楼401d', '专业的广告摄影设计团队，多年来给国内许多知名企业拍摄过产品广告图片，为国内多个时尚杂志拍摄过大片，也同时和许多国内明星有过多次良好的合作。');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000049', '1426495417913', '2015-03-16 16:43:37', '1', '南通品摄影工作室', '刘先生', '13166884576', '0513-66688673', '江苏南通崇川区', '南大街', '专业摄影，品牌摄影工作室');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000050', '1426590479489', '2015-03-17 19:07:59', '1', '五星大酒店', '王先生', '18244556677', '021-33555768', '上海上海杨浦区', '杨浦路100号', '星级酒店，长期兼职');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000051', '1426495478782', '2015-03-11 10:31:23', '1', '佐佑信息服务有限公司', '章先生', '13867034388', '0577-7654321', '浙江衢州龙游县', '太平路324号', '急您所急');
INSERT INTO `t_license` VALUES ('00000000000000000000000000000052', '1426857499956', '2015-03-20 21:18:19', '0', '新远教育', '彭先生', '18761721695', '021-12341234', '上海上海长宁区', '上海市长宁区', '招收暑期兼职辅导班老师');

-- ----------------------------
-- Table structure for t_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager` (
  `managerId` int(32) NOT NULL,
  `city` varchar(50) NOT NULL,
  `role` tinyint(3) unsigned NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` char(32) NOT NULL,
  `cellphone` char(11) NOT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manager
-- ----------------------------

-- ----------------------------
-- Table structure for t_participation
-- ----------------------------
DROP TABLE IF EXISTS `t_participation`;
CREATE TABLE `t_participation` (
  `participationId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `employeeId` int(32) unsigned zerofill NOT NULL,
  `activityId` int(32) unsigned zerofill NOT NULL,
  `isDone` tinyint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`participationId`),
  KEY `employeeId` (`employeeId`),
  KEY `activityId` (`activityId`),
  CONSTRAINT `t_participation_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `t_employee` (`employeeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_participation_ibfk_2` FOREIGN KEY (`activityId`) REFERENCES `t_activity` (`activityId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=547 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_participation
-- ----------------------------
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000522', '00000000000000000000000000000024', '00000000000000000000000000001087', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000524', '00000000000000000000000000000034', '00000000000000000000000000001087', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000526', '00000000000000000000000000000039', '00000000000000000000000000001089', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000527', '00000000000000000000000000000027', '00000000000000000000000000001079', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000528', '00000000000000000000000000000027', '00000000000000000000000000001089', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000529', '00000000000000000000000000000046', '00000000000000000000000000001089', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000530', '00000000000000000000000000000045', '00000000000000000000000000001089', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000534', '00000000000000000000000000000059', '00000000000000000000000000001113', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000535', '00000000000000000000000000000060', '00000000000000000000000000001119', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000536', '00000000000000000000000000000062', '00000000000000000000000000001120', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000537', '00000000000000000000000000000063', '00000000000000000000000000001120', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000539', '00000000000000000000000000000068', '00000000000000000000000000001128', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000540', '00000000000000000000000000000069', '00000000000000000000000000001106', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000541', '00000000000000000000000000000068', '00000000000000000000000000001136', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000543', '00000000000000000000000000000081', '00000000000000000000000000001142', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000544', '00000000000000000000000000000082', '00000000000000000000000000001143', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000545', '00000000000000000000000000000083', '00000000000000000000000000001138', '0');
INSERT INTO `t_participation` VALUES ('00000000000000000000000000000546', '00000000000000000000000000000085', '00000000000000000000000000001080', '0');

-- ----------------------------
-- Table structure for t_publication
-- ----------------------------
DROP TABLE IF EXISTS `t_publication`;
CREATE TABLE `t_publication` (
  `publicationId` int(32) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `employerId` int(32) unsigned zerofill DEFAULT NULL,
  `companyName` varchar(100) NOT NULL,
  `publicationNum` char(17) NOT NULL,
  `recruitmentTime` int(32) unsigned NOT NULL,
  `title` varchar(24) NOT NULL,
  `salary` int(32) unsigned NOT NULL,
  `detail` varchar(200) DEFAULT NULL,
  `requirement` varchar(200) DEFAULT NULL,
  `workTimeInfo` varchar(100) NOT NULL,
  `contactName` varchar(20) NOT NULL,
  `cellphone` char(11) NOT NULL,
  `startDate` date NOT NULL,
  `workDuration` tinyint(8) unsigned NOT NULL,
  `workAddress` varchar(200) NOT NULL,
  `publicationTime` datetime NOT NULL,
  `paymentWay` tinyint(8) unsigned NOT NULL DEFAULT '0',
  `settlementWay` tinyint(8) unsigned NOT NULL DEFAULT '0',
  `workType` tinyint(8) unsigned NOT NULL DEFAULT '0',
  `isLong` tinyint(8) unsigned NOT NULL DEFAULT '0',
  `isGenderRequired` tinyint(8) unsigned NOT NULL DEFAULT '0',
  `state` tinyint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`publicationId`),
  KEY `employerId` (`employerId`),
  CONSTRAINT `t_publication_ibfk_1` FOREIGN KEY (`employerId`) REFERENCES `t_employer` (`employerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=441 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_publication
-- ----------------------------
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000390', '00000000000000000000000000000017', '1加1教育', '14250111235607895', '1', '招聘传单派发人员', '80', '不包工作餐', '一加一教育辅导班招聘两名传单派发人员，工资日结。', '9:00至17:00', '毛先生', '13912257895', '2015-02-28', '1', '江苏南通崇川区小学、初中校门口', '2015-02-27 12:25:23', '0', '0', '1', '0', '0', '4');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000391', '00000000000000000000000000000017', '1加1教育', '14250112732067895', '2', '招聘晚托班辅导老师', '100', '不包工作餐', '辅导班招聘晚托班老师！男女不限（每天的工作时间下午的4点到晚上7点）40元/次。联系电话：13912257895。', '16:00至19:00', '毛先生', '13912257895', '2015-02-27', '0', '江苏南通崇川区南通开发区源兴花苑', '2015-02-27 12:27:53', '0', '0', '0', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000393', '00000000000000000000000000000016', '南通盘古网络技术有限公司', '14250135432531703', '2', '招聘校园宣传员', '80', '不包工作餐', '宣传外包的张贴，传单的派发。20元每小时。每次两个小时，时间在晚上。7点左右。男女不限，', '9:00至17:00', '魏经理', '18306291703', '2015-03-02', '5', '江苏南通崇川区南通市各高校校园', '2015-02-27 13:05:43', '0', '0', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000394', '00000000000000000000000000000019', '创乐钢琴培训中心', '14250152585759882', '1', '发传单3名', '60', '不包工作餐', '明天早上8点到11点发传单，20元每小时。需要3人，快来报名吧！', '08:00至11:00', '陈老师', '18761739882', '2015-02-28', '1', '江苏南通崇川区中南世纪城向西200米', '2015-02-27 13:34:18', '0', '0', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000396', '00000000000000000000000000000022', '龙卷风豆捞', '14251963055623330', '1', '服务员传菜员', '100', '包工作餐(一餐)', '全职，兼职都可以，工资面谈。', '17:00至21:30', '吴经理', '13951303330', '2015-03-01', '0', '江苏南通崇川区青年中路98号新天地', '2015-03-01 15:51:45', '0', '0', '2', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000398', '00000000000000000000000000000023', '个人', '14263364693413452', '1', '发单员3人', '110', '不包工作餐', '3月18、19、20日招收兼职发单员3人，工作地点在上海国家会展中心，薪资为110元/天，工资现结，工作轻松。', '9:00至17:00', '胡先生', '18252433452', '2015-03-18', '3', '上海上海青浦区盈港东路168号上海国家会展中心', '2015-03-14 20:34:29', '0', '0', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000399', '00000000000000000000000000000023', '个人', '14263373548013452', '2', '场务维持', '100', '包工作餐(一餐)', '负责讲解、传单派发、秩序维护等工作。中午加一顿饭。工作轻松，工资日结。', '10:00至04:00', '刘先生', '18252433452', '2015-03-24', '1', '上海上海徐汇区零陵路800号东亚馆', '2015-03-14 20:49:14', '0', '0', '0', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000402', '00000000000000000000000000000023', '个人', '14263872333243452', '3', '派单员2人', '30', '不包工作餐', '3月18日下午2点半到4点半，南大街发传单，需要2个人，工资待遇15元/小时，工资现结。', '14:30至16:30', '胡先生', '18252433452', '2015-03-18', '1', '江苏南通崇川区南大街', '2015-03-15 10:40:33', '0', '0', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000403', '00000000000000000000000000000024', '图存创意有限公司', '14263963057935781', '2', '图存创意临时库存盘点', '120', '不包工作餐', '如：男生要求170以上.强壮，这是有点累的活。', '10:00至17:00', '李先生', '15202125781', '2015-03-16', '1', '上海上海松江区新松江路3416号二楼', '2015-03-15 13:11:45', '0', '0', '0', '0', '3', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000404', '00000000000000000000000000000025', '松江小城家教培训中心', '14264116891900981', '1', '大学城发单', '20', '不包工作餐', '准时，工作认真负责', '11:30至12:30', '俞先生', '13262880981', '2015-03-15', '3', '上海上海松江区文汇路三期四期', '2015-03-15 17:28:09', '0', '0', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000405', '00000000000000000000000000000025', '松江小城家教培训中心', '14264126895500981', '2', '七年级英语家教', '1500', '不包工作餐', '有家教经验，有耐心，最好是英语专业', '18:00至20:00', '俞先生', '13262880981', '2015-03-18', '0', '上海上海松江区文城路500弄', '2015-03-15 17:44:49', '0', '0', '0', '1', '2', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000406', '00000000000000000000000000000025', '松江小城家教培训中心', '14264130354870981', '3', '开元地中海发单', '80', '不包工作餐', '应聘者可以无经验但工作必须认真、仔细、负责。', '11:00至18:00', '俞先生', '13262880981', '2015-03-19', '2', '上海上海松江区开元地中海', '2015-03-15 17:50:35', '0', '0', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000407', '00000000000000000000000000000027', '稻草人工作室-家教中心', '14264148972401703', '1', '虹桥初三家教', '140', '不包工作餐', '虹桥附近高一女生化学，70元每小时。每次两个小时，辅导时间：除了周六下午，周末其他时间都有空。小孩住校，每半个月回来一次，男女教师无所谓。以上信息来自稻草人工作室，【稻草人工作室】', '14:00至16:00', '稻草人', '18306291703', '2015-03-21', '0', '江苏南通崇川区虹桥小区', '2015-03-15 18:21:37', '0', '0', '0', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000408', '00000000000000000000000000000028', '宝山月浦晚托班', '14264201604780981', '1', '晚托班长期家教', '2500', '包工作餐(一餐)，包住宿', '本科毕业，有家教经验，有耐心，热爱教师职业', '16:00至20:00', '李老师', '13262880981', '2015-03-16', '0', '上海上海宝山区宝山月浦公园附近', '2015-03-15 19:49:20', '0', '0', '0', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000410', '00000000000000000000000000000026', '中国源迪有限公司', '14264695508541686', '2', '急聘中午工技大发单', '40', '不包工作餐', '男生要求170以上，认真负责，从A到F都要发，我们要检查的。', '11:30至13:30', '李先生', '15325071686', '2015-03-16', '1', '上海上海松江区工技大教学楼', '2015-03-16 09:32:30', '0', '0', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000411', '00000000000000000000000000000029', '佳悦咨询有限公司', '14264743380430918', '1', '酒店兼职服务员', '160', '包工作餐(两餐)', '如：五官端正，男生要求170以上，女生165以上。衣服颜色为深色。应聘者可以无经验但工作必须认真、仔细、负责。', '10:30至19:30', '肖经理', '13262280918', '2015-03-17', '1', '上海上海普陀区长风公园附近万豪酒店', '2015-03-16 10:52:18', '0', '0', '2', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000412', '00000000000000000000000000000029', '佳悦咨询有限公司', '14264824024350981', '2', '酒店兼职服务员', '170', '包工作餐(两餐)', '五官端正，自备黑皮鞋，酒店提供工作服，务必准时，鸽子勿扰！', '10:30至20:00', '肖经理', '13262280981', '2015-03-18', '3', '上海上海黄浦区人民广场', '2015-03-16 13:06:42', '0', '0', '2', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000413', '00000000000000000000000000000023', '兼职首发', '14264842671593452', '4', '发单员4名，女生', '90', '不包工作餐', '需要4名女生发单，工作4个小时，薪资90元，工资现结，工作轻松。', '10:30至14:30', '胡先生', '18252433452', '2015-03-18', '1', '上海上海青浦区盈港东路168号', '2015-03-16 13:37:47', '0', '0', '1', '0', '2', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000414', '00000000000000000000000000000024', '图存创意有限公司', '14264847020755781', '3', '闵行莘庄收营员', '1800', '不包工作餐', '13.5元一小时，周一到周四，要求兼做冲奶茶工作。', '12:00至16:30', '李先生', '15202125781', '2015-03-16', '0', '上海上海闵行区莘庄', '2015-03-16 13:45:02', '0', '0', '5', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000415', '00000000000000000000000000000024', '图存创意有限公司', '14264850248285781', '4', '闵行莘庄送外卖', '1800', '不包工作餐', '送外卖，有经验的来，13.5元一小时，周一到周四。', '12:00至16:30', '李先生', '15202125781', '2015-03-16', '0', '上海上海闵行区莘庄', '2015-03-16 13:50:24', '0', '0', '0', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000416', '00000000000000000000000000000023', '兼职首发', '14264955152703452', '5', '收银员1人', '480', '不包工作餐', '南大街有斐大酒店内招收收银员一名，每周周六周日上班，每天工作7个半小时，每日工资60元，工作时间分两班：7点半到下午三点，下午三点到晚上10点半。最好是女生', '07:30至15:30', '胡先生', '18252433452', '2015-03-17', '0', '江苏南通崇川区南大街有斐大酒店内', '2015-03-16 16:45:15', '0', '0', '1', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000417', '00000000000000000000000000000031', '南通品摄影工作室', '14264956633074576', '1', '招业务员', '100', '不包工作餐', '招业务员，提成百分之十，无底薪', '9:00至17:00', '刘先生', '13166884576', '2015-03-17', '0', '江苏南通崇川区南大街', '2015-03-16 16:47:43', '0', '0', '5', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000418', '00000000000000000000000000000023', '兼职首发', '14264958363313452', '6', '家教1名', '160', '不包工作餐', '南通姜灶小博士培训班，招聘吉他老师，工作时间每周日一次，下午上课，40元/小时。交通：汽车东站613、615公交车直达。工资日结。', '13:00至14:00', '胡先生', '18252433452', '2015-03-17', '0', '江苏南通崇川区姜灶', '2015-03-16 16:50:36', '0', '0', '0', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000419', '00000000000000000000000000000028', '宝山月浦晚托班', '14265542351465781', '2', '闵行浦江镇高二物理家教下午', '200', '不包工作餐', '擅长高中物理，教学态度诚恳，工作时间是周日下午，100元/小时。', '12:00至17:00', '李先生', '15202125781', '2015-03-22', '1', '上海上海闵行区浦江镇', '2015-03-17 09:03:55', '0', '0', '0', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000420', '00000000000000000000000000000016', '南通盘古网络技术有限公司', '14265584757150781', '5', '本周三学田发传单', '35', '不包工作餐', '发传单！男女不限！', '14:30至16:30', '王', '13122870781', '2015-03-18', '1', '江苏南通崇川区学田小区', '2015-03-17 10:14:35', '0', '0', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000421', '00000000000000000000000000000016', '南通盘古网络技术有限公司', '14265923334420781', '6', '五一路高三家教', '150', '不包工作餐', '高三男生家教，最好男教师，上午下午晚上都可以，辅导科目：简单的微积分和C++，该小孩不参加高考，想预习后面要学的内容，可想而知，学习成绩怎么样。60元/时以上。该小孩8月份去美国，辅导到7月底. ', '9:00至17:00', '周', '13122870781', '2015-03-19', '1', '江苏南通崇川区五一路龙王桥附近', '2015-03-17 19:38:53', '0', '0', '0', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000422', '00000000000000000000000000000024', '图存创意有限公司', '14265970511345781', '5', '南汇宣桥场促销', '140', '包工作餐(一餐)', '女生130-200之间看现场的积极主动性，净身高160以上，形象气质佳，身材匀称！（大光明最好淡妆、活动淡色鞋子不能是露脚趾的均可。不能涂指甲油不能戴眼镜） 男生：净身高172以上，五官端正，感觉阳光整洁，男生110-130之间看现场的积极主动性。需服从现场督导分配、管理等！\n活动方式是：试吃买赠方式促销。 工资以活动结束三周内打到本人提供的建行卡上！报名从速哦！', '9:00至18:30', '林先生', '15202125781', '2015-03-18', '1', '上海上海南汇区华联宣春路72号', '2015-03-17 15:57:31', '0', '1', '3', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000423', '00000000000000000000000000000026', '中国源迪有限公司', '14266436418245781', '3', '松江七校发单', '20', '不包工作餐', '要求准时，听从负责人安排', '11:30至12:30', '李先生', '15202125781', '2015-03-18', '1', '上海上海松江区松江七校', '2015-03-18 09:54:01', '0', '0', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000425', '00000000000000000000000000000026', '中国源迪有限公司', '14266579660525781', '5', '张江高科发单', '50', '不包工作餐', '1,6以上女，一天一个半小时，可以做两天，另一天在漕河泾', '11:30至13:00', '陆先生', '15202125781', '2015-03-19', '1', '上海上海浦东新区张江高科', '2015-03-18 13:52:46', '0', '1', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000426', '00000000000000000000000000000026', '中国源迪有限公司', '14266583162275781', '6', '漕河泾发单', '50', '不包工作餐', '女生1.6m以上，和在张江高科是同一单。', '12:30至13:00', '陆先生', '15202125781', '2015-03-20', '1', '上海上海徐汇区漕河泾', '2015-03-18 13:58:36', '0', '1', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000428', '00000000000000000000000000000023', '兼职首发', '14266604444475781', '8', '东华发单', '20', '不包工作餐', '男女不限，要求准时到达指定地点', '17:00至18:00', '王先生', '15202125781', '2015-03-18', '1', '上海上海松江区东华食堂发单', '2015-03-18 14:34:04', '0', '0', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000429', '00000000000000000000000000000025', '松江小城家教培训中心', '14267364234430981', '4', '高一化学家教', '240', '不包工作餐', '高一化学家教，每周周六周日下午上课，80元一小时，2-3小时，能力强的可以带小班700-800元一次，化学要好，有家教经验优先', '14:00至15:00', '俞老师', '13262880981', '2015-03-21', '0', '上海上海松江区松江新城', '2015-03-19 11:40:23', '0', '0', '0', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000430', '00000000000000000000000000000033', '佐佑信息服务有限公司', '14267500974444388', '1', '松江大学城贴海报', '80', '不包工作餐', '有相关经验者优先，必须贴的牢靠，我们抽查贴的质量。', '18:00至21:00', '吕先生', '13867034388', '2015-03-19', '1', '上海上海松江区地点具体再定', '2015-03-19 12:28:17', '0', '1', '0', '0', '3', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000432', '00000000000000000000000000000029', '佳悦咨询有限公司', '14267535350435781', '4', '崇明高中数学课业辅导', '600', '不包工作餐，包住宿', '崇明辅导班招周六周日高中辅导老师，每周六周日上课，暑假周一到周六上课也可以，一对一辅导，一天四节课，每节课两个小时，每小时75元，600元/天，提供住宿，由于地方远会有老师过来亲自面试，面试成功即可工作。第一轮4个人，留两个。面试方式：笔试+试讲。', '08:00至17:00', '吕先生', '15202125781', '2015-03-21', '1', '上海上海崇明县具体地方待定', '2015-03-19 16:25:35', '0', '1', '0', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000433', '00000000000000000000000000000029', '佳悦咨询有限公司', '14267536942115781', '5', '崇明高中英语课业辅导', '600', '不包工作餐，包住宿', '崇明辅导班招周六周日高中辅导老师，每周六周日上课，暑假周一到周六上课也可以，一对一辅导，一天四节课，每节课两个小时，每小时75元，600元/天，提供住宿，由于地方远会有老师过来亲自面试，面试成功即可工作。第一轮4个人，留两个。面试方式：笔试+试讲。', '08:00至17:00', '王先生', '15202125781', '2015-03-21', '1', '上海上海崇明县具体地点待定', '2015-03-19 16:28:14', '0', '1', '0', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000434', '00000000000000000000000000000029', '佳悦咨询有限公司', '14267540432875781', '6', '崇明高中数学课业辅导', '600', '不包工作餐，包住宿', '崇明辅导班招周六周日高中辅导老师，物理2人，每周六周日上课，暑假周一到周六也可以选择上课，一对一辅导，一天四节课，每节课两个小时，每小时75元，600元/天，提供住宿，由于地方远会有老师过来亲自面试，面试成功即可工作。第一轮4个人，留两个。面试方法：笔试+试讲', '08:00至17:00', '王先生', '15202125781', '2015-03-21', '1', '上海上海崇明县具体地点再定', '2015-03-19 16:34:03', '0', '1', '0', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000436', '00000000000000000000000000000033', '佐佑信息服务有限公司', '14267567570194388', '2', '初中化学家教', '110', '不包工作餐', '每周上一次课，一般在周日，50-60元/时，一次两小时。', '13:00至15:00', '陆先生', '13867034388', '2015-03-22', '1', '上海上海松江区松江老城', '2015-03-19 17:19:17', '0', '1', '0', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000437', '00000000000000000000000000000033', '佐佑信息服务有限公司', '14267570163055781', '3', '优贝教育发单', '30', '不包工作餐', '星期一到星期五每天一小时发单，30元/时', '11:00至12:00', '吕先生', '15202125781', '2015-03-19', '5', '上海上海奉贤区南桥镇', '2015-03-19 17:23:36', '0', '0', '1', '0', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000438', '00000000000000000000000000000028', '宝山月浦晚托班', '14267679206975781', '3', '泗泾晚托班一对一老师', '1500', '不包工作餐', '周末上课，主要解答课业问题，以及幼儿英语，一定要有耐心和亲和力，让学生家长喜欢。如果教的好，可以接受每天的晚托班，晚托班固定工资1500元。幼儿英语周六80元/课时，周日一对一100元。', '17:00至20:00', '刘老师', '15202125781', '2015-03-21', '0', '上海上海松江区泗泾', '2015-03-19 20:25:20', '0', '0', '1', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000439', '00000000000000000000000000000023', '兼职首发', '14268174336333452', '9', '松江7校发单', '20', '不包工作餐', '长期招收发单员，松江7校各要2人，每天中午11点20到12点20在学校食堂门口发单，20元/小时，工资现结。', '11:20至12:20', '胡先生', '18252433452', '2015-03-20', '0', '上海上海松江区松江7校', '2015-03-20 10:10:33', '0', '0', '1', '1', '0', '0');
INSERT INTO `t_publication` VALUES ('00000000000000000000000000000440', '00000000000000000000000000000023', '兼职首发', '14268407106183452', '10', '通州金沙招一名英语老师', '4000', '不包工作餐', '01：通州金沙一家辅导班招聘，初中的英语老师一名，男女不限，要求1、长相得体，做事认真负责，人品要好。2、做学知识扎实，能够熟悉自己所教授的科目的整个初中知识。3、长得成熟一点，不要站在讲台上还像个小学生。工作时间：每周六、日两天每天的工作时间：早上的8：30-下午6：00,50元/时，每天的收入不低于500元，明天即可安排面试。', '08:30至18:00', '胡先生', '18252433452', '2015-03-20', '0', '江苏南通通州市金沙', '2015-03-20 16:38:30', '0', '0', '0', '1', '0', '0');
