/*
Navicat SQL Server Data Transfer

Source Server         : Local_SQLServer
Source Server Version : 160000
Source Host           : :1433
Source Database       : tabungin
Source Schema         : project

Target Server Type    : SQL Server
Target Server Version : 160000
File Encoding         : 65001

Date: 2025-08-13 05:49:29
*/


-- ----------------------------
-- Table structure for [project].[detail_target]
-- ----------------------------
DROP TABLE [project].[detail_target]
;
CREATE TABLE [project].[detail_target] (
[target_harian] int NULL ,
[target_mingguan] int NULL ,
[created_at] datetime2(6) NULL ,
[id] bigint NOT NULL IDENTITY(1,1) ,
[target_id] bigint NULL ,
[updated_at] datetime2(6) NULL ,
[catatan] varchar(255) NULL ,
[strategi_menabung] varchar(255) NULL 
)


;

-- ----------------------------
-- Records of detail_target
-- ----------------------------
SET IDENTITY_INSERT [project].[detail_target] ON
;
SET IDENTITY_INSERT [project].[detail_target] OFF
;

-- ----------------------------
-- Table structure for [project].[detailtarget]
-- ----------------------------
DROP TABLE [project].[detailtarget]
;
CREATE TABLE [project].[detailtarget] (
[detail_id] bigint NOT NULL ,
[target_id] bigint NOT NULL ,
[target_harian] bigint NULL ,
[target_mingguan] bigint NULL ,
[target_bulanan] bigint NULL ,
[strategi_menabung] varchar(255) NULL ,
[catatan] varchar(255) NULL ,
[created_at] datetime NOT NULL ,
[updated_at] datetime2(7) NOT NULL 
)


;

-- ----------------------------
-- Records of detailtarget
-- ----------------------------

-- ----------------------------
-- Table structure for [project].[GroupMenu]
-- ----------------------------
DROP TABLE [project].[GroupMenu]
;
CREATE TABLE [project].[GroupMenu] (
[CreatedBy] bigint NOT NULL ,
[CreatedDate] datetime2(6) NULL ,
[ID] bigint NOT NULL IDENTITY(1,1) ,
[ModifiedBy] bigint NULL ,
[ModifiedDate] datetime2(6) NULL ,
[Nama] varchar(50) NOT NULL ,
[Deskripsi] varchar(255) NOT NULL 
)


;

-- ----------------------------
-- Records of GroupMenu
-- ----------------------------
SET IDENTITY_INSERT [project].[GroupMenu] ON
;
SET IDENTITY_INSERT [project].[GroupMenu] OFF
;

-- ----------------------------
-- Table structure for [project].[log_aktifitas]
-- ----------------------------
DROP TABLE [project].[log_aktifitas]
;
CREATE TABLE [project].[log_aktifitas] (
[id] bigint NOT NULL IDENTITY(1,1) ,
[timestamp] datetime2(6) NULL ,
[user_id] bigint NULL ,
[data_tambahan] varchar(255) NULL ,
[detail_aktivitas] varchar(255) NULL ,
[ip_address] varchar(255) NULL ,
[jenis_aktivitas] varchar(255) NULL ,
[user_agent] varchar(255) NULL 
)


;

-- ----------------------------
-- Records of log_aktifitas
-- ----------------------------
SET IDENTITY_INSERT [project].[log_aktifitas] ON
;
SET IDENTITY_INSERT [project].[log_aktifitas] OFF
;

-- ----------------------------
-- Table structure for [project].[logaktivitas]
-- ----------------------------
DROP TABLE [project].[logaktivitas]
;
CREATE TABLE [project].[logaktivitas] (
[log_id] bigint NOT NULL ,
[user_id] bigint NOT NULL ,
[jenis_aktivitas] varchar(255) NOT NULL ,
[detail_aktivitas] varchar(255) NOT NULL ,
[ip_address] varchar(255) NOT NULL ,
[user_agent] varchar(255) NOT NULL ,
[timestamp] datetime NOT NULL ,
[data_tambahan] varchar(255) NULL 
)


;

-- ----------------------------
-- Records of logaktivitas
-- ----------------------------

-- ----------------------------
-- Table structure for [project].[MapAksesMenu]
-- ----------------------------
DROP TABLE [project].[MapAksesMenu]
;
CREATE TABLE [project].[MapAksesMenu] (
[IDAkses] bigint NOT NULL ,
[IDMenu] bigint NOT NULL 
)


;

-- ----------------------------
-- Records of MapAksesMenu
-- ----------------------------

-- ----------------------------
-- Table structure for [project].[Menu]
-- ----------------------------
DROP TABLE [project].[Menu]
;
CREATE TABLE [project].[Menu] (
[CreatedBy] bigint NOT NULL ,
[CreatedDate] datetime2(6) NULL ,
[ID] bigint NOT NULL IDENTITY(1,1) ,
[IDGroupMenu] bigint NULL ,
[ModifiedBy] bigint NULL ,
[ModifiedDate] datetime2(6) NULL ,
[Nama] varchar(50) NOT NULL ,
[Path] varchar(50) NOT NULL ,
[Deskripsi] varchar(255) NOT NULL 
)


;

-- ----------------------------
-- Records of Menu
-- ----------------------------
SET IDENTITY_INSERT [project].[Menu] ON
;
SET IDENTITY_INSERT [project].[Menu] OFF
;

-- ----------------------------
-- Table structure for [project].[MstAkses]
-- ----------------------------
DROP TABLE [project].[MstAkses]
;
CREATE TABLE [project].[MstAkses] (
[CreatedBy] bigint NOT NULL ,
[CreatedDate] datetime2(6) NULL ,
[ID] bigint NOT NULL IDENTITY(1,1) ,
[ModifiedBy] bigint NULL ,
[ModifiedDate] datetime2(6) NULL ,
[Nama] varchar(50) NOT NULL ,
[Deskripsi] varchar(255) NOT NULL 
)


;
DBCC CHECKIDENT(N'[project].[MstAkses]', RESEED, 2)
;

-- ----------------------------
-- Records of MstAkses
-- ----------------------------
SET IDENTITY_INSERT [project].[MstAkses] ON
;
INSERT INTO [project].[MstAkses] ([CreatedBy], [CreatedDate], [ID], [ModifiedBy], [ModifiedDate], [Nama], [Deskripsi]) VALUES (N'1', N'2025-08-13 05:39:13.489218', N'1', null, null, N'ADMIN', N'Role Administrator dengan akses penuh');
;
INSERT INTO [project].[MstAkses] ([CreatedBy], [CreatedDate], [ID], [ModifiedBy], [ModifiedDate], [Nama], [Deskripsi]) VALUES (N'1', N'2025-08-13 05:39:14.738216', N'2', null, null, N'USER', N'Role User biasa dengan akses terbatas');
;
SET IDENTITY_INSERT [project].[MstAkses] OFF
;

-- ----------------------------
-- Table structure for [project].[MstGroupMenu]
-- ----------------------------
DROP TABLE [project].[MstGroupMenu]
;
CREATE TABLE [project].[MstGroupMenu] (
[CreatedBy] bigint NOT NULL ,
[CreatedDate] datetime2(6) NULL ,
[ID] bigint NOT NULL IDENTITY(1,1) ,
[ModifiedBy] bigint NULL ,
[ModifiedDate] datetime2(6) NULL ,
[Nama] varchar(50) NOT NULL ,
[Deskripsi] varchar(255) NOT NULL 
)


;

-- ----------------------------
-- Records of MstGroupMenu
-- ----------------------------
SET IDENTITY_INSERT [project].[MstGroupMenu] ON
;
SET IDENTITY_INSERT [project].[MstGroupMenu] OFF
;

-- ----------------------------
-- Table structure for [project].[MstMenu]
-- ----------------------------
DROP TABLE [project].[MstMenu]
;
CREATE TABLE [project].[MstMenu] (
[CreatedBy] bigint NOT NULL ,
[CreatedDate] datetime2(6) NULL ,
[ID] bigint NOT NULL IDENTITY(1,1) ,
[IDGroupMenu] bigint NULL ,
[ModifiedBy] bigint NULL ,
[ModifiedDate] datetime2(6) NULL ,
[Nama] varchar(50) NOT NULL ,
[Path] varchar(50) NOT NULL ,
[Deskripsi] varchar(255) NOT NULL 
)


;

-- ----------------------------
-- Records of MstMenu
-- ----------------------------
SET IDENTITY_INSERT [project].[MstMenu] ON
;
SET IDENTITY_INSERT [project].[MstMenu] OFF
;

-- ----------------------------
-- Table structure for [project].[MstUser]
-- ----------------------------
DROP TABLE [project].[MstUser]
;
CREATE TABLE [project].[MstUser] (
[IsRegistered] bit NULL ,
[TanggalLahir] date NOT NULL ,
[CreatedBy] bigint NOT NULL ,
[CreatedDate] datetime2(6) NULL ,
[ID] bigint NOT NULL IDENTITY(1,1) ,
[IDAkses] bigint NULL ,
[ModifiedBy] bigint NULL ,
[ModifiedDate] datetime2(6) NULL ,
[Username] varchar(16) NOT NULL ,
[NoHp] varchar(18) NOT NULL ,
[OTP] varchar(64) NULL ,
[Password] varchar(64) NOT NULL ,
[TokenEstafet] varchar(64) NULL ,
[NamaLengkap] varchar(70) NOT NULL ,
[Email] varchar(256) NOT NULL ,
[LinkImage] varchar(256) NULL ,
[PathImage] varchar(256) NULL ,
[Alamat] varchar(255) NOT NULL 
)


;

-- ----------------------------
-- Records of MstUser
-- ----------------------------
SET IDENTITY_INSERT [project].[MstUser] ON
;
SET IDENTITY_INSERT [project].[MstUser] OFF
;

-- ----------------------------
-- Table structure for [project].[Role]
-- ----------------------------
DROP TABLE [project].[Role]
;
CREATE TABLE [project].[Role] (
[CreatedBy] bigint NOT NULL ,
[CreatedDate] datetime2(6) NULL ,
[ID] bigint NOT NULL IDENTITY(1,1) ,
[ModifiedBy] bigint NULL ,
[ModifiedDate] datetime2(6) NULL ,
[Nama] varchar(50) NOT NULL ,
[Deskripsi] varchar(255) NOT NULL 
)


;
DBCC CHECKIDENT(N'[project].[Role]', RESEED, 2)
;

-- ----------------------------
-- Records of Role
-- ----------------------------
SET IDENTITY_INSERT [project].[Role] ON
;
INSERT INTO [project].[Role] ([CreatedBy], [CreatedDate], [ID], [ModifiedBy], [ModifiedDate], [Nama], [Deskripsi]) VALUES (N'1', N'2025-08-13 05:28:38.414044', N'1', null, null, N'ADMIN', N'Role Administrator dengan akses penuh');
;
INSERT INTO [project].[Role] ([CreatedBy], [CreatedDate], [ID], [ModifiedBy], [ModifiedDate], [Nama], [Deskripsi]) VALUES (N'1', N'2025-08-13 05:28:38.672039', N'2', null, null, N'USER', N'Role User biasa dengan akses terbatas');
;
SET IDENTITY_INSERT [project].[Role] OFF
;

-- ----------------------------
-- Table structure for [project].[roles]
-- ----------------------------
DROP TABLE [project].[roles]
;
CREATE TABLE [project].[roles] (
[id] bigint NOT NULL IDENTITY(1,1) ,
[name] varchar(255) NULL 
)


;

-- ----------------------------
-- Records of roles
-- ----------------------------
SET IDENTITY_INSERT [project].[roles] ON
;
SET IDENTITY_INSERT [project].[roles] OFF
;

-- ----------------------------
-- Table structure for [project].[setoran]
-- ----------------------------
DROP TABLE [project].[setoran]
;
CREATE TABLE [project].[setoran] (
[jumlah_setoran] float(53) NULL ,
[created_at] datetime2(6) NULL ,
[setoran_id] bigint NOT NULL IDENTITY(1,1) ,
[tanggal_setoran] datetime2(6) NULL ,
[targetId] bigint NULL ,
[target_id] bigint NOT NULL ,
[transaksi_id] bigint NOT NULL ,
[updated_at] datetime2(6) NULL ,
[user_id] bigint NOT NULL ,
[bukti_setoran] varchar(255) NULL ,
[catatan_setoran] varchar(255) NULL ,
[status_verifikasi] varchar(255) NULL ,
[sumber_dana] varchar(255) NULL 
)


;

-- ----------------------------
-- Records of setoran
-- ----------------------------
SET IDENTITY_INSERT [project].[setoran] ON
;
SET IDENTITY_INSERT [project].[setoran] OFF
;

-- ----------------------------
-- Table structure for [project].[target_tabungan]
-- ----------------------------
DROP TABLE [project].[target_tabungan]
;
CREATE TABLE [project].[target_tabungan] (
[tanggal_mulai_target] date NULL ,
[tanggal_selesai_target] date NULL ,
[created_at] datetime2(6) NULL ,
[jumlah_data_target] bigint NOT NULL ,
[saldo_terkumpul] bigint NULL ,
[target_id] bigint NOT NULL IDENTITY(1,1) ,
[updated_at] datetime2(6) NULL ,
[user_id] bigint NOT NULL ,
[deskripsi] varchar(255) NULL ,
[nama_target] varchar(255) NOT NULL ,
[periode] varchar(255) NULL ,
[status_target] varchar(255) NULL 
)


;

-- ----------------------------
-- Records of target_tabungan
-- ----------------------------
SET IDENTITY_INSERT [project].[target_tabungan] ON
;
SET IDENTITY_INSERT [project].[target_tabungan] OFF
;

-- ----------------------------
-- Table structure for [project].[transaksi_tabungan]
-- ----------------------------
DROP TABLE [project].[transaksi_tabungan]
;
CREATE TABLE [project].[transaksi_tabungan] (
[jumlah_transaksi] float(53) NULL ,
[created_at] datetime2(6) NULL ,
[target_id] bigint NOT NULL ,
[transaksi_id] bigint NOT NULL IDENTITY(1,1) ,
[updated_at] datetime2(6) NULL ,
[user_id] bigint NOT NULL ,
[jenis_transaksi] varchar(255) NULL ,
[keterangan] varchar(255) NULL ,
[metode_pembayaran] varchar(255) NULL ,
[referensi_pembayaran] varchar(255) NULL ,
[status_transaksi] varchar(255) NULL 
)


;

-- ----------------------------
-- Records of transaksi_tabungan
-- ----------------------------
SET IDENTITY_INSERT [project].[transaksi_tabungan] ON
;
SET IDENTITY_INSERT [project].[transaksi_tabungan] OFF
;

-- ----------------------------
-- Table structure for [project].[users]
-- ----------------------------
DROP TABLE [project].[users]
;
CREATE TABLE [project].[users] (
[IsRegistered] bit NULL ,
[TanggalLahir] date NOT NULL ,
[CreatedBy] bigint NOT NULL ,
[CreatedDate] datetime2(6) NULL ,
[ID] bigint NOT NULL IDENTITY(1,1) ,
[IDAkses] bigint NULL ,
[ModifiedBy] bigint NULL ,
[ModifiedDate] datetime2(6) NULL ,
[Username] varchar(16) NOT NULL ,
[NoHp] varchar(18) NOT NULL ,
[OTP] varchar(64) NULL ,
[Password] varchar(64) NOT NULL ,
[TokenEstafet] varchar(64) NULL ,
[NamaLengkap] varchar(70) NOT NULL ,
[Alamat] varchar(256) NOT NULL ,
[Email] varchar(256) NOT NULL ,
[LinkImage] varchar(256) NULL ,
[PathImage] varchar(256) NULL 
)


;
DBCC CHECKIDENT(N'[project].[users]', RESEED, 2)
;

-- ----------------------------
-- Records of users
-- ----------------------------
SET IDENTITY_INSERT [project].[users] ON
;
INSERT INTO [project].[users] ([IsRegistered], [TanggalLahir], [CreatedBy], [CreatedDate], [ID], [IDAkses], [ModifiedBy], [ModifiedDate], [Username], [NoHp], [OTP], [Password], [TokenEstafet], [NamaLengkap], [Alamat], [Email], [LinkImage], [PathImage]) VALUES (null, N'2000-12-12', N'1', N'2025-08-13 05:44:48.844079', N'1', N'2', null, null, N'penggunabaru1', N'081213431438', N'$2a$11$ywX16zhESDJwWJ0GzUxhk.kgyhOS6KiJpGTA/5eoCtHsWErJiLTRS', N'$2a$11$6pOS0.K1KMvPMAbMNwD3HeawZ;Lc9eRPmcm6RcJOJVexBG//oE8a', null, N'Syarif Al Faishal', N'Jl. Contoh No.1 RT 05 RW 02 Jakarta Barat', N'userbaru@example.com', null, null);
;
INSERT INTO [project].[users] ([IsRegistered], [TanggalLahir], [CreatedBy], [CreatedDate], [ID], [IDAkses], [ModifiedBy], [ModifiedDate], [Username], [NoHp], [OTP], [Password], [TokenEstafet], [NamaLengkap], [Alamat], [Email], [LinkImage], [PathImage]) VALUES (null, N'2000-12-12', N'1', N'2025-08-13 05:45:25.807017', N'2', N'1', null, null, N'administrator1', N'081234567890', N'$2a$11$tXYtckc1xvkw;7CSIJFfOhWVYzU7ChUZ18AZhoGCtXoi/OeWK4sa', N'$2a$11$4.ekdkj8sU8fJ5.QQaqjCOJu7WOzQ0G2RLDGXxnR3HxFdXo/UXLEu', null, N'Administrator baru', N'Jl. Contoh No.1 RT 05 RW 02 Jakarta Barat', N'admin@gmail.com', null, null);
;
SET IDENTITY_INSERT [project].[users] OFF
;

-- ----------------------------
-- Indexes structure for table detail_target
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[detail_target]
-- ----------------------------
ALTER TABLE [project].[detail_target] ADD PRIMARY KEY ([id])
;

-- ----------------------------
-- Indexes structure for table detailtarget
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[detailtarget]
-- ----------------------------
ALTER TABLE [project].[detailtarget] ADD PRIMARY KEY ([detail_id])
;

-- ----------------------------
-- Indexes structure for table GroupMenu
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[GroupMenu]
-- ----------------------------
ALTER TABLE [project].[GroupMenu] ADD PRIMARY KEY ([ID])
;

-- ----------------------------
-- Uniques structure for table [project].[GroupMenu]
-- ----------------------------
ALTER TABLE [project].[GroupMenu] ADD UNIQUE ([Nama] ASC)
;
ALTER TABLE [project].[GroupMenu] ADD UNIQUE ([Deskripsi] ASC)
;

-- ----------------------------
-- Indexes structure for table log_aktifitas
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[log_aktifitas]
-- ----------------------------
ALTER TABLE [project].[log_aktifitas] ADD PRIMARY KEY ([id])
;

-- ----------------------------
-- Indexes structure for table logaktivitas
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[logaktivitas]
-- ----------------------------
ALTER TABLE [project].[logaktivitas] ADD PRIMARY KEY ([log_id])
;

-- ----------------------------
-- Indexes structure for table MapAksesMenu
-- ----------------------------

-- ----------------------------
-- Uniques structure for table [project].[MapAksesMenu]
-- ----------------------------
ALTER TABLE [project].[MapAksesMenu] ADD UNIQUE ([IDAkses] ASC, [IDMenu] ASC)
;

-- ----------------------------
-- Indexes structure for table Menu
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[Menu]
-- ----------------------------
ALTER TABLE [project].[Menu] ADD PRIMARY KEY ([ID])
;

-- ----------------------------
-- Uniques structure for table [project].[Menu]
-- ----------------------------
ALTER TABLE [project].[Menu] ADD UNIQUE ([Path] ASC)
;
ALTER TABLE [project].[Menu] ADD UNIQUE ([Nama] ASC)
;
ALTER TABLE [project].[Menu] ADD UNIQUE ([Deskripsi] ASC)
;

-- ----------------------------
-- Indexes structure for table MstAkses
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[MstAkses]
-- ----------------------------
ALTER TABLE [project].[MstAkses] ADD PRIMARY KEY ([ID])
;

-- ----------------------------
-- Uniques structure for table [project].[MstAkses]
-- ----------------------------
ALTER TABLE [project].[MstAkses] ADD UNIQUE ([Nama] ASC)
;
ALTER TABLE [project].[MstAkses] ADD UNIQUE ([Deskripsi] ASC)
;

-- ----------------------------
-- Indexes structure for table MstGroupMenu
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[MstGroupMenu]
-- ----------------------------
ALTER TABLE [project].[MstGroupMenu] ADD PRIMARY KEY ([ID])
;

-- ----------------------------
-- Uniques structure for table [project].[MstGroupMenu]
-- ----------------------------
ALTER TABLE [project].[MstGroupMenu] ADD UNIQUE ([Nama] ASC)
;
ALTER TABLE [project].[MstGroupMenu] ADD UNIQUE ([Deskripsi] ASC)
;

-- ----------------------------
-- Indexes structure for table MstMenu
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[MstMenu]
-- ----------------------------
ALTER TABLE [project].[MstMenu] ADD PRIMARY KEY ([ID])
;

-- ----------------------------
-- Uniques structure for table [project].[MstMenu]
-- ----------------------------
ALTER TABLE [project].[MstMenu] ADD UNIQUE ([Path] ASC)
;
ALTER TABLE [project].[MstMenu] ADD UNIQUE ([Deskripsi] ASC)
;
ALTER TABLE [project].[MstMenu] ADD UNIQUE ([Nama] ASC)
;

-- ----------------------------
-- Indexes structure for table MstUser
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[MstUser]
-- ----------------------------
ALTER TABLE [project].[MstUser] ADD PRIMARY KEY ([ID])
;

-- ----------------------------
-- Uniques structure for table [project].[MstUser]
-- ----------------------------
ALTER TABLE [project].[MstUser] ADD UNIQUE ([NoHp] ASC)
;
ALTER TABLE [project].[MstUser] ADD UNIQUE ([Email] ASC)
;
ALTER TABLE [project].[MstUser] ADD UNIQUE ([Username] ASC)
;

-- ----------------------------
-- Indexes structure for table Role
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[Role]
-- ----------------------------
ALTER TABLE [project].[Role] ADD PRIMARY KEY ([ID])
;

-- ----------------------------
-- Uniques structure for table [project].[Role]
-- ----------------------------
ALTER TABLE [project].[Role] ADD UNIQUE ([Nama] ASC)
;
ALTER TABLE [project].[Role] ADD UNIQUE ([Deskripsi] ASC)
;

-- ----------------------------
-- Indexes structure for table roles
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[roles]
-- ----------------------------
ALTER TABLE [project].[roles] ADD PRIMARY KEY ([id])
;

-- ----------------------------
-- Indexes structure for table setoran
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[setoran]
-- ----------------------------
ALTER TABLE [project].[setoran] ADD PRIMARY KEY ([setoran_id])
;

-- ----------------------------
-- Indexes structure for table target_tabungan
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[target_tabungan]
-- ----------------------------
ALTER TABLE [project].[target_tabungan] ADD PRIMARY KEY ([target_id])
;

-- ----------------------------
-- Indexes structure for table transaksi_tabungan
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[transaksi_tabungan]
-- ----------------------------
ALTER TABLE [project].[transaksi_tabungan] ADD PRIMARY KEY ([transaksi_id])
;

-- ----------------------------
-- Indexes structure for table users
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [project].[users]
-- ----------------------------
ALTER TABLE [project].[users] ADD PRIMARY KEY ([ID])
;

-- ----------------------------
-- Uniques structure for table [project].[users]
-- ----------------------------
ALTER TABLE [project].[users] ADD UNIQUE ([Email] ASC)
;
ALTER TABLE [project].[users] ADD UNIQUE ([NoHp] ASC)
;
ALTER TABLE [project].[users] ADD UNIQUE ([Username] ASC)
;

-- ----------------------------
-- Foreign Key structure for table [project].[MapAksesMenu]
-- ----------------------------
ALTER TABLE [project].[MapAksesMenu] ADD FOREIGN KEY ([IDAkses]) REFERENCES [project].[MstAkses] ([ID]) ON DELETE NO ACTION ON UPDATE NO ACTION
;
ALTER TABLE [project].[MapAksesMenu] ADD FOREIGN KEY ([IDMenu]) REFERENCES [project].[MstMenu] ([ID]) ON DELETE NO ACTION ON UPDATE NO ACTION
;

-- ----------------------------
-- Foreign Key structure for table [project].[MstMenu]
-- ----------------------------
ALTER TABLE [project].[MstMenu] ADD FOREIGN KEY ([IDGroupMenu]) REFERENCES [project].[MstGroupMenu] ([ID]) ON DELETE NO ACTION ON UPDATE NO ACTION
;

-- ----------------------------
-- Foreign Key structure for table [project].[setoran]
-- ----------------------------
ALTER TABLE [project].[setoran] ADD FOREIGN KEY ([target_id]) REFERENCES [project].[target_tabungan] ([target_id]) ON DELETE NO ACTION ON UPDATE NO ACTION
;
ALTER TABLE [project].[setoran] ADD FOREIGN KEY ([transaksi_id]) REFERENCES [project].[transaksi_tabungan] ([transaksi_id]) ON DELETE NO ACTION ON UPDATE NO ACTION
;
ALTER TABLE [project].[setoran] ADD FOREIGN KEY ([user_id]) REFERENCES [project].[users] ([ID]) ON DELETE NO ACTION ON UPDATE NO ACTION
;

-- ----------------------------
-- Foreign Key structure for table [project].[target_tabungan]
-- ----------------------------
ALTER TABLE [project].[target_tabungan] ADD FOREIGN KEY ([user_id]) REFERENCES [project].[users] ([ID]) ON DELETE NO ACTION ON UPDATE NO ACTION
;

-- ----------------------------
-- Foreign Key structure for table [project].[transaksi_tabungan]
-- ----------------------------
ALTER TABLE [project].[transaksi_tabungan] ADD FOREIGN KEY ([user_id]) REFERENCES [project].[users] ([ID]) ON DELETE NO ACTION ON UPDATE NO ACTION
;
ALTER TABLE [project].[transaksi_tabungan] ADD FOREIGN KEY ([target_id]) REFERENCES [project].[target_tabungan] ([target_id]) ON DELETE NO ACTION ON UPDATE NO ACTION
;

-- ----------------------------
-- Foreign Key structure for table [project].[users]
-- ----------------------------
ALTER TABLE [project].[users] ADD FOREIGN KEY ([IDAkses]) REFERENCES [project].[MstAkses] ([ID]) ON DELETE NO ACTION ON UPDATE NO ACTION
;
