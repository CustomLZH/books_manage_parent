/*
 Navicat Premium Data Transfer

 Source Server         : localhost-books_manage
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : books_manage

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 22/04/2021 17:12:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `adminUsername` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员用户名',
  `adminPassword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员密码',
  `adminState` tinyint(1) NULL DEFAULT 0 COMMENT '管理员状态',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '$2a$10$Q7ggEjF/OoYYIZuTmOFdWeQ/wqQ.pnmwbAmxCkL2rbodu3QOQIZZu', 1, '2021-04-21 19:59:55', '2021-03-31 21:52:50');

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `admin_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`admin_id`, `role_id`) USING BTREE,
  INDEX `FK_Role_Admin`(`role_id`) USING BTREE,
  INDEX `admin_id`(`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES (1, 1, NULL, '2021-04-21 19:59:55');

-- ----------------------------
-- Table structure for book_type
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type`  (
  `typeId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类别编号',
  `typeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类别名称',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`typeId`) USING BTREE,
  INDEX `typeId`(`typeId`, `typeName`) USING BTREE,
  INDEX `typeName`(`typeName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES ('A', '马克思主义、列宁主义、毛泽东思想、邓小平理论', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('A1', '马克思主义', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('A4', '毛泽东著作', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('A8', '马克思主义、列宁主义、毛泽东思想的学习和', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('B', '哲学、宗教', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('B1', '世界哲学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('B2', '中国哲学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('B84', '心理学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('C', '社会科学总论', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('C91', '社会学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('D', '政治、法律', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('D03', '国家理论', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('D25', '党的领导', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('D92', '中国法律', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('E', '军事', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('E2', '中国军事', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('F', '经济', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('G', '文化、科学、教育、体育', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('G3', '科学、科学研究', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('G4', '教育', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('G412', '人生观、世界观与理想教育', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('H', '语言、文学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('H1', '汉语', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('H3', '常用外国语', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('I', '文学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('I1', '世界文学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('I2', '中国文学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('I24', '小说', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('J', '艺术', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('J6', '音乐', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('J7', '舞蹈', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('K', '历史、地理', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('K2', '中国史', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('N', '自然科学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('O', '数理科学和化学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('O1', '数学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('O3', '力学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('O4', '物理学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('O6', '化学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('O7', '晶体学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('P', '天文学、地球科学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('P1', '天文学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('P5', '地质学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Q', '生物科学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Q4', '生理学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Q5', '生物化学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Q93', '微生物学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('R', '医药、卫生', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('R2', '中国医学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('R5', '内科学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('R6', '外科学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('R71', '妇产科学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('R72', '儿科学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('S', '农业科学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('S1', '农业基础科学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('S5', '农作物', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('S8', '畜牧、兽医、狩猎、蚕、蜂', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('S9', '水产、渔业', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('T', '工业技术', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('TJ', '武器工业', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('TL', '原子能技术', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('TM', '电工技术', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('TN', '电子技术、通信技术', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('TQ', '化学工业', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('U', '交通运输', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('U2', '铁路运输', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('V', '航空、航天', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('X', '环境科学、安全科学', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('X2', '社会与环境', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Z', '综合性图书', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Z1', '丛书', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Z2', '百科全书、类书', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Z3', '辞典', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Z4', '论文集、全集、选集、杂著', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Z5', '年鉴、年刊', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Z6', '期刊、连续性出版物', NULL, '2021-03-31 21:58:04');
INSERT INTO `book_type` VALUES ('Z8', '图书目录、文摘索引', NULL, '2021-03-31 21:58:04');

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `bookId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `typeId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别编号',
  `bookName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '书名',
  `bookWriter` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作者',
  `bookCompany` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '出版社',
  `bookDate` date NULL DEFAULT NULL COMMENT '出版日期',
  `bookBrief` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '简介',
  `bookNum` int(11) NULL DEFAULT 0 COMMENT '拥有数量',
  `borrowNum` int(11) NULL DEFAULT 0 COMMENT '借阅数量',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`bookId`) USING BTREE,
  INDEX `book_type`(`typeId`) USING BTREE,
  CONSTRAINT `book_type` FOREIGN KEY (`typeId`) REFERENCES `book_type` (`typeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for borrow_info
-- ----------------------------
DROP TABLE IF EXISTS `borrow_info`;
CREATE TABLE `borrow_info`  (
  `borrowInfoId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bookId` bigint(20) NULL DEFAULT NULL COMMENT '图书编号',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '用户编号',
  `borrowDate` datetime(0) NULL DEFAULT NULL COMMENT '借阅日期',
  `returnDate` datetime(0) NULL DEFAULT NULL COMMENT '还书日期',
  `restore` tinyint(1) NULL DEFAULT 0 COMMENT '是否归还（0否，1是）',
  `renew` tinyint(1) NULL DEFAULT 0 COMMENT '是否续借（0否，1是）',
  `lose` tinyint(1) NULL DEFAULT 0 COMMENT '是否挂失（0否，1是）',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`borrowInfoId`) USING BTREE,
  INDEX `borrow_uId`(`userId`) USING BTREE,
  INDEX `borrow_bookId`(`bookId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `keyWord` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '登陆', 'LOGIN', NULL, '2021-04-20 09:19:30');
INSERT INTO `permission` VALUES (2, '删除书籍类型', 'BOOK_TYPE_DELETE', NULL, '2021-03-31 21:58:13');
INSERT INTO `permission` VALUES (3, '添加书籍类型', 'BOOK_TYPE_CREATE', NULL, '2021-03-31 21:58:13');
INSERT INTO `permission` VALUES (4, '更新书籍类型', 'BOOK_TYPE_UPDATE', NULL, '2021-03-31 21:58:13');
INSERT INTO `permission` VALUES (5, '创建用户', 'CREATE_USERS', NULL, '2021-04-20 09:46:30');
INSERT INTO `permission` VALUES (6, '删除用户', 'ADMIN_DELETE', NULL, '2021-04-17 12:48:17');
INSERT INTO `permission` VALUES (7, '更新用户', 'UPDATE_USERS', NULL, '2021-04-20 09:46:04');
INSERT INTO `permission` VALUES (8, '更新借阅信息', 'UPDATE_BORROW_INFO', NULL, '2021-04-20 09:49:19');
INSERT INTO `permission` VALUES (9, '创建借阅信息', 'CREATE_BORROW_INFO', NULL, '2021-04-20 09:48:31');
INSERT INTO `permission` VALUES (10, '删除借阅信息', 'DELETE_BORROW_INFO', NULL, '2021-04-20 09:49:07');
INSERT INTO `permission` VALUES (11, '创建书籍', 'CREATE_BOOKS', NULL, '2021-04-20 09:49:37');
INSERT INTO `permission` VALUES (12, '更新书籍', 'UPDATE_BOOKS', NULL, '2021-04-20 09:49:47');
INSERT INTO `permission` VALUES (13, '删除书籍', 'DELETE_BOOKS', NULL, '2021-04-20 09:49:59');
INSERT INTO `permission` VALUES (14, '添加管理员', 'ADMIN_CREATE', NULL, '2021-04-20 09:50:37');
INSERT INTO `permission` VALUES (15, '更新管理员', 'ADMIN_UPDATE', NULL, '2021-04-20 09:50:56');
INSERT INTO `permission` VALUES (16, '删除管理员', 'ADMIN_DELETE', NULL, '2021-04-19 17:16:21');
INSERT INTO `permission` VALUES (17, '更新角色', 'ROLE_UPDATE', NULL, '2021-04-21 10:25:08');
INSERT INTO `permission` VALUES (18, '创建角色', 'ROLE_CREATE', NULL, '2021-04-21 10:25:17');
INSERT INTO `permission` VALUES (19, '删除角色', 'DELETE_ROLE', NULL, '2021-04-21 10:25:24');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `keyWord` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色值',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '系统管理员', 'ROLE_ADMIN', '2021-04-21 10:32:14', '2021-03-31 21:58:14');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`role_id`, `permission_id`) USING BTREE,
  INDEX `FK_Permission_Role`(`permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 2, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 3, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 4, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 5, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 6, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 7, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 8, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 9, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 10, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 11, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 12, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 13, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 14, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 15, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 16, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 17, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 18, NULL, '2021-04-21 10:32:14');
INSERT INTO `role_permission` VALUES (1, 19, NULL, '2021-04-21 10:32:14');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `userName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `userPassword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `userSex` int(2) NULL DEFAULT NULL COMMENT '用户性别',
  `userPhone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `borrowNum` tinyint(4) NULL DEFAULT 0 COMMENT '借书数量',
  `user_state` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
