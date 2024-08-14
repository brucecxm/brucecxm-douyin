/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : douyintest

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2024-08-14 23:10:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `comment_video_id` int(11) DEFAULT NULL,
  `comment_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '11', '1', '102');
INSERT INTO `comment` VALUES ('2', '22', '1', '102');
INSERT INTO `comment` VALUES ('3', '33', '1', '103');
INSERT INTO `comment` VALUES ('4', '44', '1', '104');
INSERT INTO `comment` VALUES ('5', '55', '2', '101');
INSERT INTO `comment` VALUES ('6', '66', '2', '102');

-- ----------------------------
-- Table structure for likeone
-- ----------------------------
DROP TABLE IF EXISTS `likeone`;
CREATE TABLE `likeone` (
  `like_userid` int(11) DEFAULT NULL,
  `like_videoid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of likeone
-- ----------------------------

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
  `music_avatar` varchar(1000) DEFAULT NULL,
  `music_name` varchar(20) DEFAULT NULL,
  `music_video_id` int(11) NOT NULL,
  PRIMARY KEY (`music_video_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES ('https://p3-pc.douyinpic.com/img/aweme-avatar/mosaic-legacy_20b7700050147c01968f3~c5_168x168.jpeg?from=2956013662', '月牙湾', '1001');
INSERT INTO `music` VALUES ('https://p3-pc.douyinpic.com/img/aweme-avatar/mosaic-legacy_310e3000a130132511b54~c5_168x168.jpeg?from=2956013662', '嚣张', '1002');
INSERT INTO `music` VALUES ('https://p3-pc.douyinpic.com/img/aweme-avatar/tos-cn-avt-0015_c7784af3a0bd2e7c5fc92ece450f12e0~c5_168x168.jpeg?from=2956013662', '陷阱', '1003');
INSERT INTO `music` VALUES ('https://p3-pc.douyinpic.com/img/aweme-avatar/mosaic-legacy_310e3000a130132511b54~c5_168x168.jpeg?from=2956013662', '十年', '1004');

-- ----------------------------
-- Table structure for secruy
-- ----------------------------
DROP TABLE IF EXISTS `secruy`;
CREATE TABLE `secruy` (
  `id` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of secruy
-- ----------------------------
INSERT INTO `secruy` VALUES ('1', 'bruce', 'bruce');
INSERT INTO `secruy` VALUES ('2', 'zhangsan', '123456');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `user_pic` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('101', 'bruceccc', 'eee6ac52aa029bfba6f39e500a57f381', 'aaaaa', null, 'https://p3-pc.douyinpic.com/img/aweme-avatar/tos-cn-avt-0015_c7784af3a0bd2e7c5fc92ece450f12e0~c5_168x168.jpeg?from=2956013662', '2024-06-29 14:02:11', '2024-06-29 14:02:11');
INSERT INTO `user` VALUES ('102', 'brucebbb', 'eee6ac52aa029bfba6f39e500a57f381', 'aaaa', null, 'https://p3-pc.douyinpic.com/img/aweme-avatar/tos-cn-avt-0015_c7784af3a0bd2e7c5fc92ece450f12e0~c5_168x168.jpeg?from=2956013662', '2024-06-29 14:02:54', '2024-06-29 14:02:54');
INSERT INTO `user` VALUES ('103', 'bruceaaa', 'eee6ac52aa029bfba6f39e500a57f381', 'www', null, 'https://p3-pc.douyinpic.com/img/aweme-avatar/tos-cn-avt-0015_c7784af3a0bd2e7c5fc92ece450f12e0~c5_168x168.jpeg?from=2956013662', '2024-06-29 22:18:51', '2024-06-29 22:18:51');
INSERT INTO `user` VALUES ('104', 'bruceeee', 'eee6ac52aa029bfba6f39e500a57f381', 'sss', null, 'https://p3-pc.douyinpic.com/img/aweme-avatar/tos-cn-avt-0015_c7784af3a0bd2e7c5fc92ece450f12e0~c5_168x168.jpeg?from=2956013662', '2024-06-29 22:18:58', '2024-06-29 22:18:58');
INSERT INTO `user` VALUES ('105', 'chenxueming', '25f9e794323b453885f5181f1b624d0b', null, null, null, '2024-08-04 18:01:25', '2024-08-04 18:01:25');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `video_id` int(11) NOT NULL,
  `auth_id` int(11) DEFAULT NULL,
  `music_id` int(11) DEFAULT NULL,
  `video_url` varchar(2000) DEFAULT NULL,
  `video_comment` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '101', '1001', 'https://www.douyin.com/aweme/v1/play/?video_id=v0d00fg10000cj1lq4jc77u0ng6s1gt0&line=0&file_id=bed51c00899b458cbc5d8280147c22a1&sign=7749aec7bd62a3760065f60e40fc1867&is_play_url=1&source=PackSourceEnum_PUBLISH', '第一条内容');
INSERT INTO `video` VALUES ('2', '102', '1002', 'https://www.douyin.com/aweme/v1/play/?video_id=v0d00fg10000cj1lq4jc77u0ng6s1gt0&line=0&file_id=bed51c00899b458cbc5d8280147c22a1&sign=7749aec7bd62a3760065f60e40fc1867&is_play_url=1&source=PackSourceEnum_PUBLISH', '第2条内容');
INSERT INTO `video` VALUES ('3', '103', '1003', 'https://www.douyin.com/aweme/v1/play/?video_id=v0d00fg10000cj1lq4jc77u0ng6s1gt0&line=0&file_id=bed51c00899b458cbc5d8280147c22a1&sign=7749aec7bd62a3760065f60e40fc1867&is_play_url=1&source=PackSourceEnum_PUBLISH', '第3条内容');
INSERT INTO `video` VALUES ('4', '104', '1004', 'https://www.douyin.com/aweme/v1/play/?video_id=v0200f9e0000bldvt42gd9fqp49ecpag&line=0&file_id=f87d7ac5d5a24b19b3f33f1b31ba02e7&sign=c872722944d05b0ccd56ac9f5fb8a51b&is_play_url=1&source=PackSourceEnum_PUBLISH', '第4条内容');
INSERT INTO `video` VALUES ('5', '101', '1001', 'http://192.168.200.130:9000/douyin/test.mp4?Content-Disposition=attachment%3B%20filename%3D%22test.mp4%22&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minio%2F20240804%2F%2Fs3%2Faws4_request&X-Amz-Date=20240804T142413Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=fffac422c673dd8a8a46d8257e18a9031a916b9a1aea1f462a7c9133a44d792c', 'minio的内容');

-- ----------------------------
-- Table structure for xiaoxi
-- ----------------------------
DROP TABLE IF EXISTS `xiaoxi`;
CREATE TABLE `xiaoxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chat_user_id` int(11) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `text` varchar(500) DEFAULT NULL,
  `img` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of xiaoxi
-- ----------------------------
