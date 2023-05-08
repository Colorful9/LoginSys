# LoginSys

使用方法：

本地新建数据库dbsys

使用以下sql语句新建表：

use dbsys
CREATE TABLE user (
  id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY unique_username (username)
);

在yml文件配置用户名和密码

使用idea打开项目，运行

打开localhost:81/login.html
