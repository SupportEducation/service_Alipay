/*
Navicat MySQL Data Transfer

Source Server         : zdc
Source Server Version : 50136
Source Host           : localhost:3306
Source Database       : teasupport

Target Server Type    : MYSQL
Target Server Version : 50136
File Encoding         : 65001

Date: 2018-05-13 22:30:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `aid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `password` varchar(45) NOT NULL,
  `aflat` int(10) unsigned NOT NULL COMMENT '0系统管理员1组织管理员2用户',
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO account VALUES ('2', '123', '1', 'zdc1');
INSERT INTO account VALUES ('3', '123', '2', 'openid');
INSERT INTO account VALUES ('6', '11', '1', 'adc');
INSERT INTO account VALUES ('7', '123', '0', 'admin');
INSERT INTO account VALUES ('8', '123', '2', 'undefined');
INSERT INTO account VALUES ('9', 'qwe', '1', 'qwe');
INSERT INTO account VALUES ('11', '123', '2', 'oONMi0TPY9kSThhlzPKE2eTmFBnc');

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `aid` int(10) unsigned NOT NULL COMMENT '用户ID',
  `s_id` int(10) unsigned NOT NULL COMMENT '故事ID',
  `c_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '收藏ID',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表就是点赞';

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for `eduexp`
-- ----------------------------
DROP TABLE IF EXISTS `eduexp`;
CREATE TABLE `eduexp` (
  `userid` int(10) unsigned NOT NULL COMMENT '用户的id',
  `schoolname` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '学校名',
  `degree` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '学位',
  `major` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '专业',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教育经历表';

-- ----------------------------
-- Records of eduexp
-- ----------------------------
INSERT INTO eduexp VALUES ('11', '未填写', '未填写', '未填写');

-- ----------------------------
-- Table structure for `follow`
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `f_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '关注ID',
  `aid` int(10) unsigned NOT NULL COMMENT '用户ID',
  `aaid` int(10) unsigned NOT NULL COMMENT '被关注人ID',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注表';

-- ----------------------------
-- Records of follow
-- ----------------------------

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `nid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `news_title` varchar(45) NOT NULL COMMENT '新闻标题',
  `news_time` date NOT NULL COMMENT '时间',
  `news_clickrate` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '点击量',
  `news_content` text NOT NULL COMMENT '内容',
  `news_img` varchar(200) NOT NULL COMMENT '图片',
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='新闻表';

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO news VALUES ('1', '嗨，我亲爱的孩子', '2018-04-08', '0', '寒假最后几天，接到阿伍的电话，用软软的声音说：“黄老师，我今天特别想你，就给你打电话了。”赤裸而坦诚。\r\n       上个学期，有一课学到“挂”字，我给他们组了一个词：牵挂。解释完这个词，我问他们，你们觉得你们是谁的牵挂，他们想了想，说：“不知道。”我又问了一句，你们是以前老师的牵挂吗，他们说：“不是。”那时我想，不该是这样的。\r\n       半年后，开学这天，我回到尔马千，第一节课再次说到了这个词，我问他们，你们是我的牵挂吗，这次，他们害羞而坚定的告诉我：“是！”然后，有个孩子轻轻说了一句：“你也是我们的牵挂。”', 'butterfly.jpg');

-- ----------------------------
-- Table structure for `organization`
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `oid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `or_name` varchar(45) NOT NULL COMMENT '名称',
  `fonudingtime` date NOT NULL COMMENT '建立时间',
  `or_place` varchar(45) NOT NULL COMMENT '地点',
  `information` text NOT NULL COMMENT '简介',
  `seatnumber` varchar(45) NOT NULL COMMENT '座机号',
  `or_email` varchar(45) NOT NULL COMMENT '邮箱',
  `or_blognumber` varchar(45) NOT NULL COMMENT '微博号',
  `or_wecharnumber` varchar(45) NOT NULL COMMENT '微信公众平台',
  `or_officialwebsite` varchar(45) NOT NULL COMMENT '官网',
  `or_flat` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0未审核1通过2不通过',
  `or_user` varchar(45) NOT NULL COMMENT '用户名',
  `or_pwd` varchar(45) NOT NULL COMMENT '密码',
  `or_logo` varchar(200) NOT NULL COMMENT 'logo',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='组织表';

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO organization VALUES ('2', '中华支教', '2018-06-13', '北京', '杉树支教是上海杉树公益基金会于2016年发起、上善益百公益交流协会提供技术支持的教育服务项目，目前主要在四川省凉山彝族自治州西昌市周边的山区民族学校进行支教服务。2016年至今在西昌周边6所彝族乡学校开展活动，先后共派遣50名支教老师，惠及5000多名当地学生，开展阅读推广、升旗仪式等10多个项目，开启支教本地化的进程。', '021-62193857', 'teaching@cedarcharity.org', 'cedarcharity', '321456987', 'http:www.cedarcharity.org/', '1', 'zdc1', '123', 'logo.jpg');

-- ----------------------------
-- Table structure for `recruit`
-- ----------------------------
DROP TABLE IF EXISTS `recruit`;
CREATE TABLE `recruit` (
  `rid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `oid` int(10) unsigned NOT NULL COMMENT '组织id',
  `re_title` varchar(45) NOT NULL COMMENT '标题',
  `re_deadline` date NOT NULL COMMENT '截至日期',
  `re_servicetime` varchar(45) NOT NULL COMMENT '服务时间',
  `re_serviceplace` varchar(45) NOT NULL COMMENT '服务地点',
  `re_jobcontent` text NOT NULL COMMENT '工作内容',
  `re_treatment` text NOT NULL COMMENT '收获',
  `re_condition` text NOT NULL COMMENT '条件',
  `re_peoplenumber` varchar(45) NOT NULL COMMENT '人数',
  `re_flat` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '审核标识0还没审核1通过2不通过',
  `re_type` varchar(45) NOT NULL COMMENT '支教类型长期短期其他',
  `re_img` varchar(200) NOT NULL COMMENT '图片',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='招募活动';

-- ----------------------------
-- Records of recruit
-- ----------------------------
INSERT INTO recruit VALUES ('1', '2', '西部阳光2018春季招募', '2018-03-25', '2018-03-26---2018-07-15', '甘肃省陇南市康县、白银市会宁县', '社工项目的定位主要从三个方面，即心理健康、行为养成、发展教育，引进社会志愿者，采用社工工作手法陪伴孩子成长。主要有四大工作服务内容：\r\n第一，社工室开放\r\n通过每日定时开放社工室、定期开展相应活动，丰富学生的课余生活，促进学生全面发展。包括但不限于阅读角、棋奕、手工制作、医疗角、艺术课等类型的活动。\r\n第二，社工课\r\n根据学校统一使用的课程表对社工课进行排课，负责备课、授课、课后管理等。\r\n第三，个案和家访\r\n驻校社工根据学生自身的需求、情绪情感、行为变化，从教师、家长、同学等各个层面对学生的已出现的或者潜在的问题进行综合了解，与学生共同制定计划，对学生进行个别化、针对性的个体辅导，陪伴学生成长。同时，驻校社工利用周末、假期时间前往学生家中进行走访，了解家庭情况以及家庭教养模式，了解学生在家的行为习惯和学习状况等。一方面完善学生的个案辅导计划，帮助解决学生成长中的困惑，另一方面可以链接学校、家庭、社区资源，帮助学生建立良好的社会支持网络。\r\n第四，成长教育\r\n利用课余时间，如放学后、睡前时间段等，根据自身兴趣、特长和专业等，结合学生需求，与校方进行沟通，在校内为学生开展成长教育小组（如社团活动），主要涵盖和推行四个方面的内容：兴趣小组、阅读提升力小组、课业辅导小组、艺术类／乡土特色课程等。', '1、可达2300元／月的志愿服务津贴。\r\n2、寒暑假往返工作地点与家乡的路费（硬卧标准）。\r\n3、人身意外伤害保险。\r\n4、入职培训：完整的课程培训、团队融入活动，并有充分发挥自主创新的空间。\r\n5、工作期间的督导、交流，专业技能的提升，自我成长和朋辈学习的机会。\r\n6、快乐体验：“和孩子们一起，共勉成长。”\r\n7、结交志同道合的朋友，收获友谊和信任。', '1、年满二十一周岁，具有完全的民事行为能力；\r\n2、本科或以上学历，有志愿服务精神，喜欢与孩子们相处（社工专业或心理学背景优先考虑）；\r\n3、认可西部阳光理念，有强烈的服务西部农村的决心；\r\n4、具有良好的观察、反思能力和较强的创新能力；\r\n5、心理健康，品行端正，无偏激情绪和不良嗜好；\r\n6、身体素质良好，能适应艰苦生活；\r\n7、乐观开朗、节俭朴素、适应集体生活，能较快融入山区学校生活；\r\n8、对农村学校、生活环境熟悉者优先；对社会工作、心理学或社会学有深入了解者优先。1、年满二十一周岁，具有完全的民事行为能力；\r\n2、本科或以上学历，有志愿服务精神，喜欢与孩子们相处（社工专业或心理学背景优先考虑）；\r\n3、认可西部阳光理念，有强烈的服务西部农村的决心；\r\n4、具有良好的观察、反思能力和较强的创新能力；\r\n5、心理健康，品行端正，无偏激情绪和不良嗜好；\r\n6、身体素质良好，能适应艰苦生活；\r\n7、乐观开朗、节俭朴素、适应集体生活，能较快融入山区学校生活；\r\n8、对农村学校、生活环境熟悉者优先；对社会工作、心理学或社会学有深入了解者优先。\r\n1、年满二十一周岁，具有完全的民事行为能力；\r\n2、本科或以上学历，有志愿服务精神，喜欢与孩子们相处（社工专业或心理学背景优先考虑）；\r\n3、认可西部阳光理念，有强烈的服务西部农村的决心；\r\n4、具有良好的观察、反思能力和较强的创新能力；\r\n5、心理健康，品行端正，无偏激情绪和不良嗜好；\r\n6、身体素质良好，能适应艰苦生活；\r\n7、乐观开朗、节俭朴素、适应集体生活，能较快融入山区学校生活；\r\n8、对农村学校、生活环境熟悉者优先；对社会工作、心理学或社会学有深入了解者优先。\r\n', '2人', '1', '长期支教', 'city.jpg');
INSERT INTO recruit VALUES ('3', '2', '123132', '2018-04-06', '2018-04-02--2018-04-10', '12312313', '1231', '23', '123', '123', '0', '短期支教', 'butterfly.jpg');

-- ----------------------------
-- Table structure for `story`
-- ----------------------------
DROP TABLE IF EXISTS `story`;
CREATE TABLE `story` (
  `s_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '故事ID',
  `aid` int(10) unsigned NOT NULL COMMENT '用户ID',
  `s_time` datetime NOT NULL COMMENT '发布时间',
  `s_img` varchar(200) NOT NULL COMMENT '图片',
  `s_title` varchar(45) NOT NULL COMMENT '标题',
  `s_content` text NOT NULL COMMENT '内容',
  `s_place` varchar(45) NOT NULL COMMENT '地点',
  `s_like` int(10) unsigned NOT NULL COMMENT '点赞数',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个人故事';

-- ----------------------------
-- Records of story
-- ----------------------------

-- ----------------------------
-- Table structure for `teaexprience`
-- ----------------------------
DROP TABLE IF EXISTS `teaexprience`;
CREATE TABLE `teaexprience` (
  `userid` int(10) unsigned NOT NULL COMMENT '用户ID',
  `organizationname` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '组织名',
  `activityname` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '未填写' COMMENT '活动名',
  `teaplace` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '教育地点',
  `teadescribe` text COMMENT '描述',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作经历';

-- ----------------------------
-- Records of teaexprience
-- ----------------------------
INSERT INTO teaexprience VALUES ('11', '未填写', '未填写', '未填写', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(10) unsigned NOT NULL COMMENT 'id',
  `name` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '姓名',
  `borndate` date NOT NULL DEFAULT '2018-04-15' COMMENT '出生日期',
  `area` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '地区',
  `nation` varchar(45) NOT NULL DEFAULT '0' COMMENT ' 民族 0是汉1是其他',
  `sex` varchar(45) NOT NULL DEFAULT '0' COMMENT '性别 0是男1是女',
  `phonenumber` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '手机号',
  `email` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '邮箱',
  `idnumber` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '身份证号',
  `lifephoto` varchar(200) NOT NULL DEFAULT 'logo.jpg' COMMENT '生活照',
  `workaddress` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '工作地址',
  `homeaddress` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '家庭地址',
  `emergencycontact` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '紧急联系人联系方式',
  `emergancyrelationship` varchar(45) NOT NULL DEFAULT '未填写' COMMENT '联系人关系',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('11', '郑', '2018-04-15', '北京', '0', '0', '11', '11', '11', 'wxcd5f9c6041421fd3.o6zAJs9R3kI2vK1fxTBwlv315CPA.d6c7ZQBaIg0Vcc3aaca288794812275d106e005fe0f1.jpg', '未填写', '未填写', '未填写', '未填写');

-- ----------------------------
-- Table structure for `vorecruit`
-- ----------------------------
DROP TABLE IF EXISTS `vorecruit`;
CREATE TABLE `vorecruit` (
  `vid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rid` varchar(45) NOT NULL COMMENT '活动ID',
  `aid` varchar(45) NOT NULL COMMENT '用户ID',
  `vflat` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '审核标记',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='志愿者报名表';

-- ----------------------------
-- Records of vorecruit
-- ----------------------------
INSERT INTO vorecruit VALUES ('4', '1', '11', '0');
