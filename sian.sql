/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     13/04/2016 15:33:50                          */
/*==============================================================*/


drop index PRESENTA_FK;

drop index CALIFICACION_PK;

drop table CALIFICACION;

drop index ESTUDIANTE_PK;

drop table ESTUDIANTE;

drop index HORARIO_PK;

drop table HORARIO;

drop index RELATIONSHIP_9_FK;

drop index RELATIONSHIP_8_FK;

drop index RELATIONSHIP_8_PK;

drop table HORARIOMATERIA;

drop index RELATIONSHIP_10_FK;

drop index PUEDE_FK;

drop index INSCRIPCION_PK;

drop table INSCRIPCION;

drop index SE_FK;

drop index ESTACOMPUESTO_FK;

drop index MATERIA_PK;

drop table MATERIA;

drop index TIENE_FK;

drop index NIVEL_PK;

drop table NIVEL;

drop index PERIODO_ACTUAL_PK;

drop table PERIODO_ACTUAL;

drop index CONTESTA_FK;

drop index PREGUNTAS_PK;

drop table PREGUNTAS;

drop index USUARIO_PK;

drop table USUARIO;

/*==============================================================*/
/* Table: CALIFICACION                                          */
/*==============================================================*/
create table CALIFICACION (
   IDCALIFICACION       INT4                 not null,
   CEDULA               INT4                 not null,
   CALIFICACION         DECIMAL(2,2)         not null,
   constraint PK_CALIFICACION primary key (IDCALIFICACION)
);

/*==============================================================*/
/* Index: CALIFICACION_PK                                       */
/*==============================================================*/
create unique index CALIFICACION_PK on CALIFICACION (
IDCALIFICACION
);

/*==============================================================*/
/* Index: PRESENTA_FK                                           */
/*==============================================================*/
create  index PRESENTA_FK on CALIFICACION (
CEDULA
);

/*==============================================================*/
/* Table: ESTUDIANTE                                            */
/*==============================================================*/
create table ESTUDIANTE (
   CEDULA               INT4                 not null,
   NOMBRES              VARCHAR(20)          not null,
   APELLIDOS            VARCHAR(30)          not null,
   FECHANAC             DATE                 null,
   TELEFONO             INT4                 null,
   CELULAR              INT4                 null,
   CORREO               VARCHAR(40)          null,
   NIVELINST            VARCHAR(30)          null,
   PROFESION            VARCHAR(30)          null,
   SECTOR               VARCHAR(30)          null,
   ESTADOCIVIL          VARCHAR(15)          null,
   NOMBCONY             VARCHAR(20)          null,
   CREYCONY             INT4                 null,
   HIJOS                INT4                 null,
   NOMBEMERG            VARCHAR(20)          null,
   TELFEMERG            INT4                 null,
   constraint PK_ESTUDIANTE primary key (CEDULA)
);

/*==============================================================*/
/* Index: ESTUDIANTE_PK                                         */
/*==============================================================*/
create unique index ESTUDIANTE_PK on ESTUDIANTE (
CEDULA
);

/*==============================================================*/
/* Table: HORARIO                                               */
/*==============================================================*/
create table HORARIO (
   IDHORARIO            INT4                 not null,
   DIA                  CHAR(10)             not null,
   HORA                 CHAR(15)             null,
   constraint PK_HORARIO primary key (IDHORARIO)
);

/*==============================================================*/
/* Index: HORARIO_PK                                            */
/*==============================================================*/
create unique index HORARIO_PK on HORARIO (
IDHORARIO
);

/*==============================================================*/
/* Table: HORARIOMATERIA                                        */
/*==============================================================*/
create table HORARIOMATERIA (
   IDMATERIA            INT4                 not null,
   IDHORARIO            INT4                 not null,
   IDCALIFICACION       INT4                 null,
   constraint PK_HORARIOMATERIA primary key (IDMATERIA, IDHORARIO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_PK                                     */
/*==============================================================*/
create unique index RELATIONSHIP_8_PK on HORARIOMATERIA (
IDMATERIA,
IDHORARIO
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_8_FK on HORARIOMATERIA (
IDMATERIA
);

/*==============================================================*/
/* Index: RELATIONSHIP_9_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_9_FK on HORARIOMATERIA (
IDHORARIO
);

/*==============================================================*/
/* Table: INSCRIPCION                                           */
/*==============================================================*/
create table INSCRIPCION (
   IDINSCRIPCION        CHAR(10)             not null,
   IDPERIODO            INT4                 not null,
   CEDULA               INT4                 not null,
   constraint PK_INSCRIPCION primary key (IDINSCRIPCION)
);

/*==============================================================*/
/* Index: INSCRIPCION_PK                                        */
/*==============================================================*/
create unique index INSCRIPCION_PK on INSCRIPCION (
IDINSCRIPCION
);

/*==============================================================*/
/* Index: PUEDE_FK                                              */
/*==============================================================*/
create  index PUEDE_FK on INSCRIPCION (
CEDULA
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_10_FK on INSCRIPCION (
IDPERIODO
);

/*==============================================================*/
/* Table: MATERIA                                               */
/*==============================================================*/
create table MATERIA (
   IDMATERIA            INT4                 not null,
   IDNIVEL              INT4                 not null,
   IDINSCRIPCION        CHAR(10)             not null,
   MATERIA              VARCHAR(30)          not null,
   constraint PK_MATERIA primary key (IDMATERIA)
);

/*==============================================================*/
/* Index: MATERIA_PK                                            */
/*==============================================================*/
create unique index MATERIA_PK on MATERIA (
IDMATERIA
);

/*==============================================================*/
/* Index: ESTACOMPUESTO_FK                                      */
/*==============================================================*/
create  index ESTACOMPUESTO_FK on MATERIA (
IDNIVEL
);

/*==============================================================*/
/* Index: SE_FK                                                 */
/*==============================================================*/
create  index SE_FK on MATERIA (
IDINSCRIPCION
);

/*==============================================================*/
/* Table: NIVEL                                                 */
/*==============================================================*/
create table NIVEL (
   IDNIVEL              INT4                 not null,
   IDPERIODO            INT4                 not null,
   NIVEL                INT4                 not null,
   constraint PK_NIVEL primary key (IDNIVEL)
);

/*==============================================================*/
/* Index: NIVEL_PK                                              */
/*==============================================================*/
create unique index NIVEL_PK on NIVEL (
IDNIVEL
);

/*==============================================================*/
/* Index: TIENE_FK                                              */
/*==============================================================*/
create  index TIENE_FK on NIVEL (
IDPERIODO
);

/*==============================================================*/
/* Table: PERIODO_ACTUAL                                        */
/*==============================================================*/
create table PERIODO_ACTUAL (
   IDPERIODO            INT4                 not null,
   PERIODO              VARCHAR(15)          not null,
   FECHAINICIO          DATE                 null,
   FECHAFIN             DATE                 null,
   constraint PK_PERIODO_ACTUAL primary key (IDPERIODO)
);

/*==============================================================*/
/* Index: PERIODO_ACTUAL_PK                                     */
/*==============================================================*/
create unique index PERIODO_ACTUAL_PK on PERIODO_ACTUAL (
IDPERIODO
);

/*==============================================================*/
/* Table: PREGUNTAS                                             */
/*==============================================================*/
create table PREGUNTAS (
   IDPREGUNTAS          INT4                 not null,
   CEDULA               INT4                 not null,
   NUMPREGUNTA          INT4                 not null,
   OPCION               INT4                 not null,
   RESPUESTA            VARCHAR(50)          null,
   constraint PK_PREGUNTAS primary key (IDPREGUNTAS)
);

/*==============================================================*/
/* Index: PREGUNTAS_PK                                          */
/*==============================================================*/
create unique index PREGUNTAS_PK on PREGUNTAS (
IDPREGUNTAS
);

/*==============================================================*/
/* Index: CONTESTA_FK                                           */
/*==============================================================*/
create  index CONTESTA_FK on PREGUNTAS (
CEDULA
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   IDUSUARIO            INT4                 not null,
   USUARIO              VARCHAR(20)          not null,
   CONTRASENIA          VARCHAR(20)          null,
   constraint PK_USUARIO primary key (IDUSUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
IDUSUARIO
);

alter table CALIFICACION
   add constraint FK_CALIFICA_PRESENTA_ESTUDIAN foreign key (CEDULA)
      references ESTUDIANTE (CEDULA)
      on delete restrict on update restrict;

alter table HORARIOMATERIA
   add constraint FK_HORARIOM_REFERENCE_CALIFICA foreign key (IDCALIFICACION)
      references CALIFICACION (IDCALIFICACION)
      on delete restrict on update restrict;

alter table HORARIOMATERIA
   add constraint FK_HORARIOM_RELATIONS_MATERIA foreign key (IDMATERIA)
      references MATERIA (IDMATERIA)
      on delete restrict on update restrict;

alter table HORARIOMATERIA
   add constraint FK_HORARIOM_RELATIONS_HORARIO foreign key (IDHORARIO)
      references HORARIO (IDHORARIO)
      on delete restrict on update restrict;

alter table INSCRIPCION
   add constraint FK_INSCRIPC_PUEDE_ESTUDIAN foreign key (CEDULA)
      references ESTUDIANTE (CEDULA)
      on delete restrict on update restrict;

alter table INSCRIPCION
   add constraint FK_INSCRIPC_RELATIONS_PERIODO_ foreign key (IDPERIODO)
      references PERIODO_ACTUAL (IDPERIODO)
      on delete restrict on update restrict;

alter table MATERIA
   add constraint FK_MATERIA_ESTACOMPU_NIVEL foreign key (IDNIVEL)
      references NIVEL (IDNIVEL)
      on delete restrict on update restrict;

alter table MATERIA
   add constraint FK_MATERIA_SE_INSCRIPC foreign key (IDINSCRIPCION)
      references INSCRIPCION (IDINSCRIPCION)
      on delete restrict on update restrict;

alter table NIVEL
   add constraint FK_NIVEL_TIENE_PERIODO_ foreign key (IDPERIODO)
      references PERIODO_ACTUAL (IDPERIODO)
      on delete restrict on update restrict;

alter table PREGUNTAS
   add constraint FK_PREGUNTA_CONTESTA_ESTUDIAN foreign key (CEDULA)
      references ESTUDIANTE (CEDULA)
      on delete restrict on update restrict;

