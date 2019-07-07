# CompanyManagementSystem
基于Java Swing的员工管理系统，员工登陆后可进行打卡操作、查看管理员的评价；管理员登陆后可进行增删查改的操作、填写员工评价。
# 页面及其功能
* 员工页面：登陆注册、打卡、查看管理员的评价
* 管理元页面：添加删除查询修改员工的信息、对员工进行评价
* 其中图片存放至数据库/读取数据库中的图片，参考了[此处](https://www.cnblogs.com/warrior4236/p/5682830.html)
## sql源码
```
CREATE TABLE `admin` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
)
```
```
CREATE TABLE `staff` (
  `workid` int(11) NOT NULL,
  `staffpaw` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `idcard` bigint(100) NOT NULL,
  `birth` varchar(255) NOT NULL,
  `position` varchar(255) NOT NULL,
  `education` varchar(255) NOT NULL,
  `perphoto` longblob,
  PRIMARY KEY (`workid`)
)
```
```
CREATE TABLE `staffcond` (
  `workid` int(11) NOT NULL,
  `signcond` varchar(255) DEFAULT NULL,
  `evaluate` varchar(255) DEFAULT NULL,
  KEY `workid` (`workid`)
)
```
