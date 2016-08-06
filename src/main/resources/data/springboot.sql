CREATE TABLE `permission` (
`ID` bigint NOT NULL AUTO_INCREMENT COMMENT '权限表自增ID',
`NAME` varchar(255) NOT NULL COMMENT '权限名称',
`ICON` varchar(255) NOT NULL COMMENT '图标',
`URL` varchar(4000) NULL COMMENT '链接地址',
`CTIME` date NOT NULL COMMENT '创建日期',
`CUSER` bigint NOT NULL COMMENT '创建人',
`CUSERNAME` varchar(255) NOT NULL COMMENT '创建人名称',
`ISOK` int(1) NOT NULL DEFAULT 0 COMMENT '是否启用',
PRIMARY KEY (`ID`) 
)
COMMENT = '权限表';

CREATE TABLE `permission_child` (
`ID` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
`PID` bigint NOT NULL COMMENT '主权限表ID',
`CTIME` date NOT NULL COMMENT '创建时间',
`CUSER` bigint NOT NULL COMMENT '创建人ID',
`PSORT` int NOT NULL COMMENT '排序',
PRIMARY KEY (`ID`, `PID`) 
)
COMMENT = '权限树关联';

CREATE TABLE `base_user` (
`ID` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
`NAME` varchar(255) NOT NULL COMMENT '名字',
`CODE` varchar(255) NOT NULL COMMENT '账号',
`PASSWORD` varchar(255) NOT NULL COMMENT '密码',
`CTIME` date NOT NULL COMMENT '创建时间',
`ISOK` int(1) NOT NULL DEFAULT 0 COMMENT '是否启用',
PRIMARY KEY (`ID`) 
)
COMMENT = '基础用户表';

CREATE TABLE `base_user_other` (
`ID` bigint NOT NULL COMMENT '主键',
`AGE` int NULL COMMENT '年龄',
`SEX` int NULL COMMENT '性别',
`PHOTO` longblob NULL COMMENT '头像，二进制流',
PRIMARY KEY (`ID`) 
)
COMMENT = '基本用户额外信息表';

CREATE TABLE `base_user_operator` (
`ID` bigint NOT NULL AUTO_INCREMENT,
`UID` bigint NOT NULL COMMENT '用户ID',
`UNAME` varchar(255) NOT NULL,
`URL` varchar(4000) NOT NULL COMMENT '操作URL',
`CTIME` date NOT NULL COMMENT '创建时间',
`MARK` varchar(4000) NULL COMMENT '备注',
PRIMARY KEY (`ID`) 
)
COMMENT = '基本用户操作记录表';

CREATE TABLE `base_role` (
`ID` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
`NAME` varchar(255) NOT NULL COMMENT '角色名称',
`CUSER` bigint NOT NULL COMMENT '创建用户',
`CUSERNAME` varchar(255) NOT NULL COMMENT '创建用户名称',
`CTIME` date NOT NULL COMMENT '创建时间',
`ISOK` int(1) NOT NULL DEFAULT 0 COMMENT '是否启用',
`PIDS` varchar(4000) NULL COMMENT '权限ids，目的是为了给角色一定的权限',
PRIMARY KEY (`ID`, `CUSER`) 
)
COMMENT = '基础角色表';

CREATE TABLE `base_role_user` (
`ID` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
`UID` bigint NOT NULL COMMENT '用户id',
`PIDS` varchar(4000) NULL COMMENT '用户权限，先从角色那里继承权限，然后增加自定义的',
`CTIME` date NOT NULL COMMENT '创建时间',
`UTIME` date NULL COMMENT '修改日期',
PRIMARY KEY (`ID`, `UID`) 
)
COMMENT = '角色用户关联表';

