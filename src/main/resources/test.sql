/*
数据库
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for balance
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance`  (
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `balance` decimal(18, 3) NULL DEFAULT NULL COMMENT '用户余额',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of balance
-- ----------------------------
INSERT INTO `balance` VALUES (1, 10100.010);

-- ----------------------------
-- Table structure for balance_log
-- ----------------------------
DROP TABLE IF EXISTS `balance_log`;
CREATE TABLE `balance_log`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `userid` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `money` decimal(18, 3) NULL DEFAULT NULL COMMENT '修改金额',
  `type` int(2) NULL DEFAULT NULL COMMENT '修改类型，1支付2收入',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userid_index`(`userid`) USING BTREE COMMENT '用户id索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of balance_log
-- ----------------------------
INSERT INTO `balance_log` VALUES (1, 1, 120.000, 1, '购买商品');
INSERT INTO `balance_log` VALUES (2, 1, 120.000, 2, '退款');
INSERT INTO `balance_log` VALUES (1589958987154657281, 1, 100.000, 1, '测试');
INSERT INTO `balance_log` VALUES (1589959309600157698, 1, 100.000, 1, '测试');
INSERT INTO `balance_log` VALUES (1589959409005162498, 1, 100.000, 2, '测试');
INSERT INTO `balance_log` VALUES (1589959415158206466, 1, 100.000, 2, '测试');
INSERT INTO `balance_log` VALUES (1589960142895132673, 1, 100.000, 1, '测试');
INSERT INTO `balance_log` VALUES (1589960166106411009, 1, 100.000, 2, '测试');
INSERT INTO `balance_log` VALUES (1589961526243700737, 1, 10000.000, 1, '测试');
INSERT INTO `balance_log` VALUES (1589961613422309377, 1, 10000.000, 2, '测试');
INSERT INTO `balance_log` VALUES (1589964509983522818, 1, 100.000, 1, '测试');
INSERT INTO `balance_log` VALUES (1589964548852137985, 1, 100.000, 2, '测试');
INSERT INTO `balance_log` VALUES (1589964778091753473, 1, 100.000, 2, '测试');
INSERT INTO `balance_log` VALUES (1589964872375513090, 1, 100.000, 1, '测试');
INSERT INTO `balance_log` VALUES (1589965000171835393, 1, 100.000, 2, '测试');
INSERT INTO `balance_log` VALUES (1589965071739244545, 1, 100.000, 2, '测试');
INSERT INTO `balance_log` VALUES (1589965237217120258, 1, 100.000, 1, '测试');
INSERT INTO `balance_log` VALUES (1589965516062838785, 1, 100.000, 2, '测试');
INSERT INTO `balance_log` VALUES (1589966052862447618, 1, 100.010, 2, '退款');

SET FOREIGN_KEY_CHECKS = 1;
