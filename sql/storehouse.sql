
drop database respository;
create database respository
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;
use respository;
drop table supplier;
#供应商
create table supplier(
id int auto_increment primary key ,
name varchar(20) not null ,
inchargeperson varchar(10) not null ,
tel varchar(11) not null,
address varchar(80) null
)engine=innodb;

#客户表
create table customer(
id int auto_increment primary key ,
name varchar(20) not null ,
inchargeperson varchar(10) not null,
tel varchar(11) not null,
address varchar(30) not null
)engine=innodb;

#仓库表
create table storehouse(
id int auto_increment primary key,
address varchar(20) not null,
size float not null
-- sh_freespace float not null,
-- sh_totalspace float not null
)engine=innodb;

drop table administrator;
#管理员表
create table administrator(
id int auto_increment primary key,
name varchar(10) not null unique,
sex varchar(10) not null,
tel varchar(20) not null,
address varchar(30) not null ,
birth date not null,
storehouseid int,
Foreign key(storehouseid) references storehouse(id)
)engine=innodb;




#货物表
create table goods(
id int auto_increment primary key ,
name varchar(10) not null unique ,
type varchar(10) ,
-- size float ,
origin varchar(20),
price float not null
)engine=innodb;


#库存表
create table stock(
storehouseid int,
goodsid int ,
amount int not null ,
-- price float not null ,
-- st_outprice float not null ,

-- st_volume float not null,
primary key(storehouseid,goodsid),
foreign key(storehouseid) references storehouse(id),
foreign key(goodsid) references goods(id)
)engine=innodb;



drop table record_in;
# 创建入库记录表
create table record_in
(
ID int not null auto_increment,
supplierid int not null,
goodsid int not null,
storehouseid int not null,
price float not null,
amount int not null,
time datetime not null,
-- volume float not null,
primary key(id),
foreign key(supplierid) references supplier(id),
foreign key(goodsid) references goods(id),
foreign key(storehouseid) references storehouse(id)
)engine=innodb;

drop table record_out;
# 创建出库记录表
create table record_out
(
	ID int not null auto_increment,
   customerid int not null,
goodsid int not null,
storehouseid int not null,
-- price float not null,
amount int not null,
time datetime not null,
--     ro_volume float not null,
    primary key(id),
    foreign key(customerid) references customer(id),
    foreign key(goodsid) references goods(id),
    foreign key(storehouseid) references storehouse(id)
)engine=innodb;

use respository;
#创建用户表
create table user_account(
name  varchar(20)  primary key,
password varchar(20) not null
)engine = innodb;


# 导入数据



# 导入供应商信息
INSERT INTO `supplier` VALUES 
(001,'苏州奇同电器有限公司','王泽将','13777771126','中国 浙江 温州市龙湾区 龙湾区永强大道1648号'),
(002,'醴陵春天陶瓷实业有限公司','温仙容','13974167256','中国 湖南 醴陵市 东正街15号'),
(003,'洛阳嘉吉利饮品有限公司','郑绮云','26391678','中国 广东 佛山市顺德区 北滘镇怡和路2号怡和中心14楼');

# 导入客户信息
INSERT INTO `customer` VALUES 
(001,'醴陵荣旗瓷业有限公司','陈娟','17716786888','中国 湖南 醴陵市 嘉树乡玉茶村柏树组'),
(002,'深圳市松林达电子有限公司','刘明','85263335','中国 广东 深圳市宝安区 深圳市宝安区福永社区桥头村桥塘路育'),
(003,'郑州绿之源饮品有限公司 ','赵志敬','87094196','中国 河南 郑州市 郑州市嘉亿东方大厦609');

# 导入货物信息
INSERT INTO `goods` VALUES 
(103,'五孔墙壁开关','电器','0.3','浙江'),
(104,'陶瓷马克杯','陶瓷','0.1','广东'),
(105,'精酿苹果醋','饮料','0.5','揭阳');

# 导入仓库信息
INSERT INTO `storehouse` VALUES 
(1003,'北京顺义南彩工业园区彩祥西路9号','5500','11000'),
(1004,'广州白云石井石潭路大基围工业区','30','1000'),
(1005,' 香港北区文锦渡路（红桥新村）','1200','5000.00');

# 导入仓库管理员信息
INSERT INTO `administrator` VALUES 
(1018,'王皓','女','12345874526','中国佛山','2016-12-09 00:00:00',1004),
(1019,'李富荣','男','1234','广州','2016-12-07 00:00:00',1003);

# 导入入库记录
INSERT INTO `record_in` VALUES 
(15,003,105,1003,'4',1000,'2016-12-31 00:00:00','500'),
(16,002,103,1004,'10','30','2017-01-02 00:00:00','10');

# 导入出库记录
INSERT INTO `record_out` VALUES
 (7,003,104,1005,'10','50','2016-12-31 00:00:00','6');



