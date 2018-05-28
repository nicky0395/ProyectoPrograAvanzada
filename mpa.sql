/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     26/5/2018 12:36:44                           */
/*==============================================================*/


drop table if exists ASIENTO;

drop table if exists AVIONES;

drop table if exists CLIENTE;

drop table if exists VUELO;

/*==============================================================*/
/* Table: ASIENTO                                               */
/*==============================================================*/
create table ASIENTO
(
   COD_ASIENTO          int not null,
   COD_AVION            int not null,
   NUMERO_ASIENTO       numeric(8,0),
   primary key (COD_ASIENTO)
);

/*==============================================================*/
/* Table: AVIONES                                               */
/*==============================================================*/
create table AVIONES
(
   COD_AVION            int not null,
   MODELO               varchar(30),
   AEROLINEA            varchar(50),
   primary key (COD_AVION)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   COD_CLIENTE          int not null,
   CEDULA_CLIENTE       varchar(10),
   NACIONALIDAD_CLIENTE varchar(50),
   NOMBRE_CLIENTE       varchar(50),
   APELLIDO_CLIENTE     varchar(50),
   FECHA_NAC            date,
   primary key (COD_CLIENTE)
);

/*==============================================================*/
/* Table: VUELO                                                 */
/*==============================================================*/
create table VUELO
(
   COD_VUELO            int not null,
   COD_AVION            int not null,
   COD_CLIENTE          int not null,
   FECHA_SALIDA         datetime,
   FECHA_LLEGADA        datetime,
   PRECIO               numeric(4,2),
   RESERVA              bool,
   ORIGEN               varchar(50),
   DESTINO              varchar(50),
   primary key (COD_VUELO, COD_AVION, COD_CLIENTE)
);

alter table ASIENTO add constraint FK_AVI_ASI foreign key (COD_AVION)
      references AVIONES (COD_AVION) on delete restrict on update restrict;

alter table VUELO add constraint FK_VUELO foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE) on delete restrict on update restrict;

alter table VUELO add constraint FK_VUELO2 foreign key (COD_AVION)
      references AVIONES (COD_AVION) on delete restrict on update restrict;

