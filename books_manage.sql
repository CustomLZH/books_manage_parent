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

 Date: 21/04/2021 20:24:28
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
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
