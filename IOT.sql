create table communityPerson(
personID varchar(20) unique not null,
personName varchar(50) not null,
personPhone varchar(11) unique not null,
personType enum('1','2','3') not null comment'1业主 2员工 3管理员',
personFace varchar(200) unique not null comment'图片路径',
personCreateTime timestamp not null default current_timestamp,
primary key (personID)
);

create table communityCar(
carID varchar(7) unique not null,
carType enum('1','2') not null comment'1小车 2大车',
carIsRegistered boolean not null comment'1 T 0 F',
carOwnerID varchar(20) comment '外码需要判断 业主的（上面为T）外码不能为空 访客外码可以为空',
primary key (carID),
foreign key (carOwnerID) references communityPerson (personID) on delete cascade
);

create table parkingLot(
parkingLotID varchar(10) unique not null,
parkingLotCreateTime timestamp not null default current_timestamp,
primary key (parkingLotID)
);

create table parkingSpace(
parkingSpaceID varchar(10) unique not null,
parkingSpaceCreateTime timestamp not null default current_timestamp,
parkingSpaceParkingLotID varchar(10) not null,
parkingSpaceCarID varchar(7) not null,
primary key (parkingSpaceID),
foreign key (parkingSpaceParkingLotID) references parkingLot (parkingLotID) on delete cascade,
foreign key (parkingSpaceCarID) references communityCar (carID) on delete cascade
);

create table gatewayEquipment(
gatewayEquipmentID int unique not null auto_increment,
gatewayEquipmentName varchar(10) unique not null,
gatewayEquipmentIP varchar(30) unique not null,
gatewayEquipmentIPVersion enum ('4','6') not null,
gatewayEquipmentMacAddress varchar(30) not null,
gatewayEquipmentBrand varchar(100) default null,
primary key (gatewayEquipmentID)
);

create table gatewayOperate(
gatewayOperatePersonID varchar(20) not null,
gatewayOperateGatewayEquipmentID int not null,
gatewayOperateID int unique not null auto_increment,
gatewayOperateType enum ('开门','关门') not null,
gatewayOperateDescription varchar(100) default null,
gatewayOperateState varchar(10) not null comment '操作状态不知道取值是什么',
gatewayOperateCreateTime timestamp not null default current_timestamp,
primary key (gatewayOperatePersonID, gatewayOperateGatewayEquipmentID, gatewayOperateID),
foreign key (gatewayOperatePersonID) references communityPerson (personID) on delete cascade,
foreign key (gatewayOperateGatewayEquipmentID) references gatewayEquipment (gatewayEquipmentID) on delete cascade
);

create table gatewayBind(
gatewayBindPersonID varchar(20) not null,
gatewayBindGatewayEquipmentID int not null,
gatewayBindState enum('未上传','上传成功') not null, 
gatewayBindDescription enum('新增人脸待同步设备','上传设备成功') not null,
gatewayBindCreateTime timestamp not null default current_timestamp,
primary key (gatewayBindPersonID, gatewayBindGatewayEquipmentID),
foreign key (gatewayBindPersonID) references communityPerson (personID) on delete cascade,
foreign key (gatewayBindGatewayEquipmentID) references gatewayEquipment (gatewayEquipmentID) on delete cascade
);

create table gatewayOpenRecord(
gatewayOpenRecordPersonID varchar(20) not null,
gatewayOpenRecordGatewayEquipmentID int not null,
gatewayOpenRecordTime timestamp not null default current_timestamp,
gatewayOpenPhoto varchar(200) unique not null comment'图片路径',
gatewayOpenSimilarity tinyint not null,
primary key (gatewayOpenRecordPersonID, gatewayOpenRecordGatewayEquipmentID, gatewayOpenRecordTime),
foreign key (gatewayOpenRecordPersonID) references communityPerson (personID) on delete cascade,
foreign key (gatewayOpenRecordGatewayEquipmentID) references gatewayEquipment (gatewayEquipmentID) on delete cascade,
check (gatewayOpenSimilarity>=1 and gatewayOpenSimilarity<=100)
);

create table barrierProtocol(
barrierProtocolName varchar(20) unique not null,
barrierProtocolVersion varchar(10) not null,
barrierProtocolDeveloper varchar(10) not null,
barrierProtocolDeveloperPhone varchar(11) not null,
barrierProtocolProtocolLink varchar(100) unique not null,
barrierProtocolState enum('启用','禁用') not null,
primary key (barrierProtocolName)
);

create table barrierEquipment(
barrierEquipmentID int unique not null auto_increment,
barrierEquipmentName varchar(10) unique not null,
barrierEquipmentDirection enum('进','出') not null,
barrierEquipmentIP varchar(30) unique not null,
barrierEquipmentIPVersion enum ('4','6') not null,
barrierEquipmentMacAddress varchar(30) not null,
barrierEquipmentProtocol varchar(20) not null,
primary key (barrierEquipmentID),
foreign key (barrierEquipmentProtocol) references barrierProtocol (barrierProtocolName) on delete set null
);

create table carIn(
carInID int unique not null auto_increment,
carInBarrierEquipmentID int not null,
carInCarID varchar(7) not null,
carInTime timestamp not null default current_timestamp,
carInDescription varchar(100) default null,
primary key (carInID, carInBarrierEquipmentID, carInCarID),
foreign key (carInBarrierEquipmentID) references barrierEquipment (barrierEquipmentID) on delete cascade,
foreign key (carInCarID) references communityCar (carID) on delete cascade
);

create table carOut(
carOutID int unique not null auto_increment,
carOutBarrierEquipmentID int not null,
carOutCarID varchar(7) not null,
carOutTime timestamp not null default current_timestamp,
carOutDescription varchar(100) default null,
carOutMoneyReceivable numeric(5,2) default 5.00,
carOutMoneyLast numeric(5,2) default 5.00,
primary key (carOutID, carOutBarrierEquipmentID, carOutCarID),
foreign key (carOutBarrierEquipmentID) references barrierEquipment (barrierEquipmentID) on delete cascade,
foreign key (carOutCarID) references communityCar (carID) on delete cascade
);

-- 对应车辆进场查询 
create view carInDisplay
as
select carInID, carInBarrierEquipmentID, carInCarID, carInTime, carInDescription, carType carInCarType
from communityCar, carIn
where communityCar.carID=carIn.carInCarID;

-- 对应车辆出场查询
create view carOutDisplay
as
select carOutID, carOutBarrierEquipmentID, carOutCarID, carOutTime, carOutDescription, carOutMoneyReceivable, carOutMoneyLast, carType carOutCarType
from communityCar, carOut
where communityCar.carID=carOut.carOutCarID;

INSERT INTO barrierProtocol VALUES ('云盟道闸(第三方平台)', 'v1.0', '吴学文', '17797173942', 'http://doc.szymzh.com/', '启用');
INSERT INTO barrierProtocol VALUES ('零壹道闸(第三方平台)', 'v1.0', '吴学文', '17797173942', 'http://www.0easy.com/', '启用');

INSERT INTO barrierEquipment VALUES ('1', '南门出', '出', '121.43.234.30', '4', '34-CF-F6-FE-05-C9','云盟道闸(第三方平台)');

create table user(
ID int unique not null auto_increment,
username char(10) unique not null,
userPassword char(10) not null,
primary key(ID)
);

INSERT INTO communityperson (personID, personName, personPhone, personType, personFace) VALUES ('320106200206110438', '张宸冉', '13951792418', '1', '1234');
INSERT INTO communityperson (personID, personName, personPhone, personType, personFace) VALUES ('511302200207306610', '曹智宇', '15680309798', '1', '124');

INSERT INTO communitycar VALUES ('苏A12312', '1', '1', '320106200206110438');

INSERT INTO gatewayEquipment (gatewayEquipmentName, gatewayEquipmentIP, gatewayEquipmentIPVersion, gatewayEquipmentMacAddress, gatewayEquipmentBrand) VALUES ('厦门集美2', '192.168.0.132', '4', '02:ab:cd:ef:12:34', '海康门禁协议');
INSERT INTO gatewayEquipment (gatewayEquipmentName, gatewayEquipmentIP, gatewayEquipmentIPVersion, gatewayEquipmentMacAddress, gatewayEquipmentBrand) VALUES ('厦门集美3', '192.168.1.144', '4', '41:ef:ac:11:32:a5', '海康');

INSERT INTO gatewayoperate (gatewayOperatePersonID, gatewayOperateGatewayEquipmentID, gatewayOperateType, gatewayOperateDescription, gatewayOperateState) VALUES ('511302200207306610', '1', '开门', '小区东门开门', '已完成');

INSERT INTO parkinglot (parkingLotID) VALUES ('12345');

INSERT INTO user (username, userPassword) VALUES ('admin', '111111');
