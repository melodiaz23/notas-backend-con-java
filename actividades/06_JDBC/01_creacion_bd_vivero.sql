CREATE DATABASE IF NOT EXISTS vivero;
USE vivero;

-- Tabla: oficina
CREATE TABLE IF NOT EXISTS oficina (
    id_oficina INT PRIMARY KEY AUTO_INCREMENT,
    codigo_oficina VARCHAR(10),
    ciudad VARCHAR(30),
    pais VARCHAR(50),
    region VARCHAR(50),
    codigo_postal VARCHAR(10),
    telefono VARCHAR(20)
);

-- Tabla: empleado
CREATE TABLE IF NOT EXISTS empleado (
    id_empleado INT PRIMARY KEY AUTO_INCREMENT,
    codigo_empleado INT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    extension VARCHAR(10),
    email VARCHAR(100),
    id_oficina INT,
    id_jefe INT,
    puesto VARCHAR(50),
    FOREIGN KEY (id_oficina) REFERENCES oficina(id_oficina),
    FOREIGN KEY (id_jefe) REFERENCES empleado(id_empleado)
);

-- Tabla: cliente
CREATE TABLE IF NOT EXISTS cliente (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    codigo_cliente INT,
    nombre_cliente VARCHAR(50),
    nombre_contacto VARCHAR(30),
    apellido_contacto VARCHAR(30),
    telefono VARCHAR(15),
    fax VARCHAR(15),
    ciudad VARCHAR(50),
    region VARCHAR(50),
    pais VARCHAR(50),
    codigo_postal VARCHAR(10),
    id_empleado INT,
    limite_credito DECIMAL(15,2),
    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
);

-- Tabla: pago
CREATE TABLE IF NOT EXISTS pago (
    id_pago INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    forma_pago VARCHAR(40),
    id_transaccion VARCHAR(50),
    fecha_pago DATE,
    total DECIMAL(15,2),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

-- Tabla: pedido
CREATE TABLE IF NOT EXISTS pedido (
    id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    codigo_pedido INT,
    fecha_pedido DATE,
    fecha_esperada DATE,
    fecha_entrega DATE,
    estado VARCHAR(15),
    comentarios TEXT,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

-- Tabla: gama_producto
CREATE TABLE IF NOT EXISTS gama_producto (
   id_gama INT PRIMARY KEY AUTO_INCREMENT,
    gama VARCHAR(50),
    descripcion_texto TEXT,
    descripcion_html TEXT,
    imagen VARCHAR(256)
);

-- Tabla: producto
CREATE TABLE IF NOT EXISTS producto (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    codigo_producto VARCHAR(15),
    nombre VARCHAR(70),
    id_gama INT,
    dimensiones VARCHAR(25),
    proveedor VARCHAR(50),
    descripcion TEXT,
    cantidad_en_stock SMALLINT,
    precio_venta DECIMAL(15,2),
    precio_proveedor DECIMAL(15,2),
    FOREIGN KEY (id_gama) REFERENCES gama_producto(id_gama)
);

-- Tabla: detalle_pedido
CREATE TABLE IF NOT EXISTS detalle_pedido (
    id_detalle_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT,
    id_producto INT,
    cantidad INT,
    precio_unidad DECIMAL(15,2),
    numero_linea SMALLINT,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Valores de las tablas

-- Valores de oficina
INSERT INTO oficina VALUES (1, 'BCN-ES','Barcelona','España','Barcelona','08019','+34 93 3561182');
INSERT INTO oficina VALUES (2, 'BOS-USA','Boston','EEUU','MA','02108','+1 215 837 0825');
INSERT INTO oficina VALUES (3, 'LON-UK','Londres','Inglaterra','EMEA','EC2N 1HN','+44 20 78772041');
INSERT INTO oficina VALUES (4, 'MAD-ES','Madrid','España','Madrid','28032','+34 91 7514487');
INSERT INTO oficina VALUES (5, 'PAR-FR','Paris','Francia','EMEA','75017','+33 14 723 4404');
INSERT INTO oficina VALUES (6, 'SFC-USA','San Francisco','EEUU','CA','94080','+1 650 219 4782');
INSERT INTO oficina VALUES (7, 'SYD-AU','Sydney','Australia','APAC','NSW 2010','+61 2 9264 2451');
INSERT INTO oficina VALUES (8, 'TAL-ES','Talavera de la Reina','España','Castilla-LaMancha','45632','+34 925 867231');
INSERT INTO oficina VALUES (9, 'TOK-JP','Tokyo','Japón','Chiyoda-Ku','102-8578','+81 33 224 5000');

-- Valores de empleado
INSERT INTO empleado VALUES (1,1,'Marcos','Magaña','3897','marcos@jardineria.es',1,NULL,'Director General');
INSERT INTO empleado VALUES (2,2,'Ruben','López','2899','rlopez@jardineria.es',1,1,'Subdirector Marketing');
INSERT INTO empleado VALUES (3,3,'Alberto','Soria','2837','asoria@jardineria.es',2,2,'Subdirector Ventas');
INSERT INTO empleado VALUES (4,4,'Maria','Solís','2847','msolis@jardineria.es',2,2,'Secretaria');
INSERT INTO empleado VALUES (5,5,'Felipe','Rosas','2844','frosas@jardineria.es',3,3,'Representante Ventas');
INSERT INTO empleado VALUES (6,6,'Juan Carlos','Ortiz','2845','cortiz@jardineria.es',3,3,'Representante Ventas');
INSERT INTO empleado VALUES (7,7,'Carlos','Soria','2444','csoria@jardineria.es',5,3,'Director Oficina');
INSERT INTO empleado VALUES (8,8,'Mariano','López','2442','mlopez@jardineria.es',4,7,'Representante Ventas');
INSERT INTO empleado VALUES (9,9,'Lucio','Campoamor','2442','lcampoamor@jardineria.es',5,7,'Representante Ventas');
INSERT INTO empleado VALUES (10,10,'Hilario','Rodriguez','2444','hrodriguez@jardineria.es',6,7,'Representante Ventas');
INSERT INTO empleado VALUES (11,11,'Emmanuel','Magaña','2518','manu@jardineria.es',6,3,'Director Oficina');
INSERT INTO empleado VALUES (12,12,'José Manuel','Martinez','2519','jmmart@hotmail.es',6,11,'Representante Ventas');
INSERT INTO empleado VALUES (13,13,'David','Palma','2519','dpalma@jardineria.es',5,11,'Representante Ventas');
INSERT INTO empleado VALUES (14,14,'Oscar','Palma','2519','opalma@jardineria.es',4,11,'Representante Ventas');
INSERT INTO empleado VALUES (15,15,'Francois','Fignon','9981','ffignon@gardening.com',8,3,'Director Oficina');
INSERT INTO empleado VALUES (16,16,'Lionel','Narvaez','9982','lnarvaez@gardening.com',9,15,'Representante Ventas');
INSERT INTO empleado VALUES (17,17,'Laurent','Serra','9982','lserra@gardening.com',7,15,'Representante Ventas');
INSERT INTO empleado VALUES (18,18,'Michael','Bolton','7454','mbolton@gardening.com',7,3,'Director Oficina');
INSERT INTO empleado VALUES (19,19,'Walter Santiago','Lopez','7454','wssanchez@gardening.com',8,1,'Representante Ventas');
INSERT INTO empleado VALUES (20,20,'Hilary','Washington','7565','hwashington@gardening.com',9,3,'Director Oficina');

-- Valores de gama_producto
INSERT INTO gama_producto VALUES (1,'Herbaceas','Plantas para jardin decorativas',NULL,NULL);
INSERT INTO gama_producto VALUES (2,'Herramientas','Herramientas para todo tipo de acción',NULL,NULL);
INSERT INTO gama_producto VALUES (3,'Aromáticas','Plantas aromáticas',NULL,NULL);
INSERT INTO gama_producto VALUES (4,'Frutales','Árboles pequeños de producción frutal',NULL,NULL);
INSERT INTO gama_producto VALUES (5,'Ornamentales','Plantas vistosas para la decoración del jardín',NULL,NULL);

-- Valores de cliente
INSERT INTO cliente VALUES (1,1,'GoldFish Garden','Daniel G','GoldFish','5556901745','5556901746','San Francisco',NULL,'USA','24006',5,3000);
INSERT INTO cliente VALUES (2,2,'Gardening Associates','Anne','Wright','5557410345','5557410346','Miami','Miami','USA','24010',7,6000);
INSERT INTO cliente VALUES (3,3,'Gerudo Valley','Link','Flaute','5552323129','5552323128','New York',NULL,'USA','85495',9,12000);
INSERT INTO cliente VALUES (4,4,'Tendo Garden','Akane','Tendo','55591233210','55591233211','Miami',NULL,'USA','696969',11,600000);
INSERT INTO cliente VALUES (5,5,'Lasas S.A.','Antonio','Lasas','34916540145','34914851312','Fuenlabrada','Madrid','Spain','28945',13,154310);
INSERT INTO cliente VALUES (6,6,'Beragua','Jose','Bermejo','654987321','916549872','Madrid','Madrid','Spain','28942',15,20000);
INSERT INTO cliente VALUES (7,7,'Club Golf Puerta del hierro','Paco','Lopez','62456810','919535678','Madrid','Madrid','Spain','28930',11,40000);
INSERT INTO cliente VALUES (8,8,'Naturagua','Guillermo','Rengifo','689234750','916428956','Madrid','Madrid','Spain','28947',11,32000);
INSERT INTO cliente VALUES (9,9,'DaraDistribuciones','David','Serrano','675598001','916421756','Madrid','Madrid','Spain','28946',11,50000);
INSERT INTO cliente VALUES (10,10,'Madrileña de riegos','Jose','Tacaño','655983045','916689215','Madrid','Madrid','Spain','28943',11,20000);
INSERT INTO cliente VALUES (11,11,'Lasas S.A.','Antonio','Lasas','34916540145','34914851312','Fuenlabrada','Madrid','Spain','28945',8,154310);
INSERT INTO cliente VALUES (12,12,'Camunas Jardines S.L.','Pedro','Camunas','34914873241','34914871541','San Lorenzo del Escorial','Madrid','Spain','28145',8,16481);
INSERT INTO cliente VALUES (13,13,'Dardena S.A.','Juan','Rodriguez','34912453217','34912484764','Madrid','Madrid','Spain','28003',8,321000);
INSERT INTO cliente VALUES (14,14,'Jardin de Flores','Javier','Villar','654865643','914538776','Madrid','Madrid','Spain','28950',13,40000);
INSERT INTO cliente VALUES (15,15,'Flores Marivi','Maria','Rodriguez','666555444','912458657','Fuenlabrada','Madrid','Spain','28945',5,1500);
INSERT INTO cliente VALUES (16,16,'Flowers, S.A','Beatriz','Fernandez','698754159','978453216','Montornes del valles','Barcelona','Spain','24586',5,3500);
INSERT INTO cliente VALUES (17,17,'Naturajardin','Victoria','Cruz','612343529','916548735','Madrid','Madrid','Spain','28011',16,5050);
INSERT INTO cliente VALUES (18,18,'Golf S.A.','Luis','Martinez','916458762','912354475','C/Estancado','Islas Canarias','Spain','38297',12,30000);
INSERT INTO cliente VALUES (19,19,'Americh Golf Management SL','Mario','Suarez','964493072','964493063','Barcelona','Cataluña','Spain','12320',12,20000);

-- Valores de pedido
INSERT INTO pedido VALUES (1,1,'2006-01-17','2006-01-19','2006-01-19','Entregado','Pagado a plazos',5);
INSERT INTO pedido VALUES (2,2,'2007-10-23','2007-10-28','2007-10-26','Entregado','La entrega llego antes de lo esperado',5);
INSERT INTO pedido VALUES (3,3,'2008-06-20','2008-06-25',NULL,'Rechazado','Limite de credito superado',5);
INSERT INTO pedido VALUES (4,4,'2009-01-20','2009-01-26',NULL,'Pendiente',NULL,5);
INSERT INTO pedido VALUES (5,5,'2008-11-09','2008-11-14','2008-11-14','Entregado','El cliente paga la mitad con tarjeta y la otra mitad con efectivo, se le realizan dos facturas',1);
INSERT INTO pedido VALUES (9,9,'2008-12-22','2008-12-27','2008-12-28','Entregado','El cliente comprueba la integridad del paquete, todo correcto',1);
INSERT INTO pedido VALUES (10,10,'2009-01-15','2009-01-20',NULL,'Pendiente','El cliente llama para confirmar la fecha - Esperando al proveedor',3);
INSERT INTO pedido VALUES (11,11,'2009-01-20','2009-01-27',NULL,'Pendiente','El cliente requiere que el pedido se le entregue de 16:00h a 22:00h',1);
INSERT INTO pedido VALUES (12,12,'2009-01-22','2009-01-27',NULL,'Pendiente','El cliente requiere que el pedido se le entregue de 9:00h a 13:00h',1);
INSERT INTO pedido VALUES (13,13,'2009-01-12','2009-01-14','2009-01-15','Entregado',NULL,7);
INSERT INTO pedido VALUES (14,14,'2009-01-02','2009-01-02',null,'Rechazado','mal pago',7);
INSERT INTO pedido VALUES (15,15,'2009-01-09','2009-01-12','2009-01-11','Entregado',NULL,7);
INSERT INTO pedido VALUES (16,16,'2009-01-06','2009-01-07','2009-01-15','Entregado',NULL,7);
INSERT INTO pedido VALUES (17,17,'2009-01-08','2009-01-09','2009-01-11','Entregado','mal estado',7);
INSERT INTO pedido VALUES (18,18,'2009-01-05','2009-01-06','2009-01-07','Entregado',NULL,9);
INSERT INTO pedido VALUES (19,19,'2009-01-18','2009-02-12',NULL,'Pendiente','entregar en murcia',9);
INSERT INTO pedido VALUES (20,20,'2009-01-20','2009-02-15',NULL,'Pendiente',NULL,9);
INSERT INTO pedido VALUES (21,21,'2009-01-09','2009-01-09','2009-01-09','Rechazado','mal pago',9);
INSERT INTO pedido VALUES (22,22,'2009-01-11','2009-01-11','2009-01-13','Entregado',NULL,9);
INSERT INTO pedido VALUES (23,23,'2008-12-30','2009-01-10',NULL,'Rechazado','El pedido fue anulado por el cliente',5);
INSERT INTO pedido VALUES (24,24,'2008-07-14','2008-07-31','2008-07-25','Entregado',NULL,14);
INSERT INTO pedido VALUES (25,25,'2009-02-02','2009-02-08',NULL,'Rechazado','El cliente carece de saldo en la cuenta asociada',1);
INSERT INTO pedido VALUES (26,26,'2009-02-06','2009-02-12',NULL,'Rechazado','El cliente anula la operacion para adquirir mas producto',3);
INSERT INTO pedido VALUES (27,27,'2009-02-07','2009-02-13',NULL,'Entregado','El pedido aparece como entregado pero no sabemos en que fecha',3);
INSERT INTO pedido VALUES (28,28,'2009-02-10','2009-02-17','2009-02-20','Entregado','El cliente se queja bastante de la espera asociada al producto',3);
INSERT INTO pedido VALUES (29,29,'2008-08-01','2008-09-01','2008-09-01','Rechazado','El cliente no está conforme con el pedido',14);
INSERT INTO pedido VALUES (30,30,'2008-08-03','2008-09-03','2008-08-31','Entregado',NULL,13);
INSERT INTO pedido VALUES (31,31,'2008-09-04','2008-09-30','2008-10-04','Rechazado','El cliente ha rechazado por llegar 5 dias tarde',13);
INSERT INTO pedido VALUES (32,32,'2007-01-07','2007-01-19','2007-01-27','Entregado','Entrega tardia, el cliente puso reclamacion',4);
INSERT INTO pedido VALUES (33,33,'2007-05-20','2007-05-28',NULL,'Rechazado','El pedido fue anulado por el cliente',4);
INSERT INTO pedido VALUES (34,34,'2007-06-20','2008-06-28','2008-06-28','Entregado','Pagado a plazos',4);
INSERT INTO pedido VALUES (35,35,'2008-03-10','2009-03-20',NULL,'Rechazado','Limite de credito superado',4);
INSERT INTO pedido VALUES (36,36,'2008-10-15','2008-12-15','2008-12-10','Entregado',NULL,14);
INSERT INTO pedido VALUES (37,37,'2008-11-03','2009-11-13',NULL,'Pendiente','El pedido nunca llego a su destino',4);
INSERT INTO pedido VALUES (38,38,'2009-03-05','2009-03-06','2009-03-07','Entregado',NULL,19);
INSERT INTO pedido VALUES (39,39,'2009-03-06','2009-03-07','2009-03-09','Pendiente',NULL,19);
INSERT INTO pedido VALUES (40,40,'2009-03-09','2009-03-10','2009-03-13','Rechazado',NULL,19);

-- Valores de producto
INSERT INTO producto VALUES (1,'11679','Sierra de Poda 400MM',2,'0,258','HiperGarden Tools','Gracias a la poda se consigue manipular un poco la naturaleza, dándole la forma que más nos guste. Este trabajo básico de jardinería también facilita que las plantas crezcan de un modo más equilibrado, y que las flores y los frutos vuelvan cada año con regularidad. Lo mejor es dar forma cuando los ejemplares son jóvenes, de modo que exijan pocos cuidados cuando sean adultos. Además de saber cuándo y cómo hay que podar, tener unas herramientas adecuadas para esta labor es también de vital importancia.',15,14,11);
INSERT INTO producto VALUES (2,'21636','Pala',2,'0,156','HiperGarden Tools','Palas de acero con cresta de corte en la punta para cortar bien el terreno. Buena penetración en tierras muy compactas.',15,14,13);
INSERT INTO producto VALUES (3,'22225','Rastrillo de Jardín',2,'1,064','HiperGarden Tools','Fabuloso rastillo que le ayudará a eliminar piedras, hojas, ramas y otros elementos incómodos en su jardín.',15,12,11);
INSERT INTO producto VALUES (4,'30310','Azadón',2,'0,168','HiperGarden Tools','Longitud:24cm. Herramienta fabricada en acero y pintura epoxi,alargando su durabilidad y preveniendo la corrosión.Diseño pensado para el ahorro de trabajo.',15,12,11);
INSERT INTO producto VALUES (5,'AR-001','Ajedrea',3,'15-20','Murcia Seasons','Planta aromática que fresca se utiliza para condimentar carnes y ensaladas, y seca, para pastas, sopas y guisantes',140,1,0);
INSERT INTO producto VALUES (6,'AR-002','Lavándula Dentata',3,'15-20','Murcia Seasons','Espliego de jardín, Alhucema rizada, Alhucema dentada, Cantueso rizado. Familia: Lamiaceae.Origen: España y Portugal. Mata de unos 60 cm de alto. Las hojas son aromáticas, dentadas y de color verde grisáceas.  Produce compactas espigas de flores pequeñas, ligeramente aromáticas, tubulares,de color azulado y con brácteas púrpuras.  Frutos: nuececillas alargadas encerradas en el tubo del cáliz.  Se utiliza en jardineria y no en perfumeria como otros cantuesos, espliegos y lavandas.  Tiene propiedades aromatizantes y calmantes. Adecuadas para la formación de setos bajos. Se dice que su aroma ahuyenta pulgones y otros insectos perjudiciales para las plantas vecinas.',140,1,0);
INSERT INTO producto VALUES (7,'AR-003','Mejorana',3,'15-20','Murcia Seasons','Origanum majorana. No hay que confundirlo con el orégano. Su sabor se parece más al tomillo, pero es más dulce y aromático.Se usan las hojas frescas o secas, picadas, machacadas o en polvo, en sopas, rellenos, quiches y tartas, tortillas, platos con papas y, como aderezo, en ramilletes de hierbas.El sabor delicado de la mejorana se elimina durante la cocción, de manera que es mejor agregarla cuando el plato esté en su punto o en aquéllos que apenas necesitan cocción.',140,1,0);
INSERT INTO producto VALUES (8,'AR-004','Melissa ',3,'15-20','Murcia Seasons','Es una planta perenne (dura varios años) conocida por el agradable y característico olor a limón que desprenden en verano. Nunca debe faltar en la huerta o jardín por su agradable aroma y por los variados usos que tiene: planta olorosa, condimentaria y medicinal. Su cultivo es muy fácil. Le va bien un suelo ligero, con buen drenaje y riego sin exceso. A pleno sol o por lo menos 5 horas de sol por día. Cada año, su abonado mineral correspondiente.En otoño, la melisa pierde el agradable olor a limón que desprende en verano sus flores azules y blancas. En este momento se debe cortar a unos 20 cm. del suelo. Brotará de forma densa en primavera.',140,1,0);
INSERT INTO producto VALUES (9,'AR-005','Mentha Sativa',3,'15-20','Murcia Seasons','¿Quién no conoce la Hierbabuena? Se trata de una plantita muy aromática, agradable y cultivada extensamente por toda España. Es hierba perenne (por tanto vive varios años, no es anual). Puedes cultivarla en maceta o plantarla en la tierra del jardín o en un rincón del huerto. Lo más importante es que cuente con bastante agua. En primavera debes aportar fertilizantes minerales. Vive mejor en semisombra que a pleno sol.Si ves orugas o los agujeros en hojas consecuencia de su ataque, retíralas una a una a mano; no uses insecticidas químicos.',140,1,0);
INSERT INTO producto VALUES (10,'AR-006','Petrosilium Hortense (Peregil)',3,'15-20','Murcia Seasons','Nombre científico o latino: Petroselinum hortense, Petroselinum crispum. Nombre común o vulgar: Perejil, Perejil rizado Familia: Umbelliferae (Umbelíferas). Origen: el origen del perejil se encuentra en el Mediterraneo. Esta naturalizada en casi toda Europa. Se utiliza como condimento y para adorno, pero también en ensaladas. Se suele regalar en las fruterías y verdulerías.El perejil lo hay de 2 tipos: de hojas planas y de hojas rizadas.',140,1,0);
INSERT INTO producto VALUES (11,'AR-007','Salvia Mix',3,'15-20','Murcia Seasons','La Salvia es un pequeño arbusto que llega hasta el metro de alto.Tiene una vida breve, de unos pocos años.En el jardín, como otras aromáticas, queda muy bien en una rocalla o para hacer una bordura perfumada a cada lado de un camino de Salvia. Abona después de cada corte y recorta el arbusto una vez pase la floración.',140,1,0);
INSERT INTO producto VALUES (12,'AR-008','Thymus Citriodra (Tomillo limón)',3,'15-20','Murcia Seasons','Nombre común o vulgar: Tomillo, Tremoncillo Familia: Labiatae (Labiadas).Origen: Región mediterránea.Arbustillo bajo, de 15 a 40 cm de altura. Las hojas son muy pequeñas, de unos 6 mm de longitud; según la variedad pueden ser verdes, verdes grisáceas, amarillas, o jaspeadas. Las flores aparecen de mediados de primavera hasta bien entrada la época estival y se presentan en racimos terminales que habitualmente son de color violeta o púrpura aunque también pueden ser blancas. Esta planta despide un intenso y típico aroma, que se incrementa con el roce. El tomillo resulta de gran belleza cuando está en flor. El tomillo atrae a avispas y abejas. En jardinería se usa como manchas, para hacer borduras, para aromatizar el ambiente, llenar huecos, cubrir rocas, para jardines en miniatura, etc. Arranque las flores y hojas secas del tallo y añadálos a un popurri, introdúzcalos en saquitos de hierbas o en la almohada.También puede usar las ramas secas con flores para añadir aroma y textura a cestos abiertos.',140,1,0);
INSERT INTO producto VALUES (13,'AR-009','Thymus Vulgaris',3,'15-20','Murcia Seasons','Nombre común o vulgar: Tomillo, Tremoncillo Familia: Labiatae (Labiadas). Origen: Región mediterránea. Arbustillo bajo, de 15 a 40 cm de altura. Las hojas son muy pequeñas, de unos 6 mm de longitud; según la variedad pueden ser verdes, verdes grisáceas, amarillas, o jaspeadas. Las flores aparecen de mediados de primavera hasta bien entrada la época estival y se presentan en racimos terminales que habitualmente son de color violeta o púrpura aunque también pueden ser blancas. Esta planta despide un intenso y típico aroma, que se incrementa con el roce. El tomillo resulta de gran belleza cuando está en flor. El tomillo atrae a avispas y abejas.\r\n En jardinería se usa como manchas, para hacer borduras, para aromatizar el ambiente, llenar huecos, cubrir rocas, para jardines en miniatura, etc. Arranque las flores y hojas secas del tallo y añadálos a un popurri, introdúzcalos en saquitos de hierbas o en la almohada. También puede usar las ramas secas con flores para añadir aroma y textura a cestos abiertos.',140,1,0);
INSERT INTO producto VALUES (14,'AR-010','Santolina Chamaecyparys',3,'15-20','Murcia Seasons','',140,1,0);
INSERT INTO producto VALUES (15,'FR-1','Expositor Cítricos Mix',4,'100-120','Frutales Talavera S.A','',15,7,5);
INSERT INTO producto VALUES (16,'FR-10','Limonero 2 años injerto',4,'','NaranjasValencianas.com','El limonero, pertenece al grupo de los cítricos, teniendo su origen hace unos 20 millones de años en el sudeste asiático. Fue introducido por los árabes en el área mediterránea entre los años 1.000 a 1.200, habiendo experimentando numerosas modificaciones debidas tanto a la selección natural mediante hibridaciones espontáneas como a las producidas por el hombre, en este caso buscando las necesidades del mercado.',15,7,5);
INSERT INTO producto VALUES (17,'FR-100','Nectarina',4,'8/10','Frutales Talavera S.A','Se trata de un árbol derivado por mutación de los melocotoneros comunes, y los únicos caracteres diferenciales son la ausencia de tomentosidad en la piel del fruto. La planta, si se deja crecer libremente, adopta un porte globoso con unas dimensiones medias de 4-6 metros',50,11,8);
INSERT INTO producto VALUES (18,'FR-101','Nogal',4,'8/10','Frutales Talavera S.A','',50,13,10);
INSERT INTO producto VALUES (19,'FR-102','Olea-Olivos',4,'8/10','Frutales Talavera S.A','Existen dos hipótesis sobre el origen del olivo, una que postula que proviene de las costas de Siria, Líbano e Israel y otra que considera que lo considera originario de Asia menor. La llegada a Europa probablemente tuvo lugar de mano de los Fenicios, en transito por Chipre, Creta, e Islas del Mar Egeo, pasando a Grecia y más tarde a Italia. Los primeros indicios de la presencia del olivo en las costas mediterráneas españolas coinciden con el dominio romano, aunque fueron posteriormente los árabes los que impulsaron su cultivo en Andalucía, convirtiendo a España en el primer país productor de aceite de oliva a nivel mundial.',50,18,14);
INSERT INTO producto VALUES (20,'FR-103','Olea-Olivos',4,'10/12','Frutales Talavera S.A','Existen dos hipótesis sobre el origen del olivo, una que postula que proviene de las costas de Siria, Líbano e Israel y otra que considera que lo considera originario de Asia menor. La llegada a Europa probablemente tuvo lugar de mano de los Fenicios, en transito por Chipre, Creta, e Islas del Mar Egeo, pasando a Grecia y más tarde a Italia. Los primeros indicios de la presencia del olivo en las costas mediterráneas españolas coinciden con el dominio romano, aunque fueron posteriormente los árabes los que impulsaron su cultivo en Andalucía, convirtiendo a España en el primer país productor de aceite de oliva a nivel mundial.',50,25,20);
INSERT INTO producto VALUES (21,'FR-104','Olea-Olivos',4,'12/4','Frutales Talavera S.A','Existen dos hipótesis sobre el origen del olivo, una que postula que proviene de las costas de Siria, Líbano e Israel y otra que considera que lo considera originario de Asia menor. La llegada a Europa probablemente tuvo lugar de mano de los Fenicios, en transito por Chipre, Creta, e Islas del Mar Egeo, pasando a Grecia y más tarde a Italia. Los primeros indicios de la presencia del olivo en las costas mediterráneas españolas coinciden con el dominio romano, aunque fueron posteriormente los árabes los que impulsaron su cultivo en Andalucía, convirtiendo a España en el primer país productor de aceite de oliva a nivel mundial.',50,49,39);
INSERT INTO producto VALUES (22,'FR-105','Olea-Olivos',4,'14/16','Frutales Talavera S.A','Existen dos hipótesis sobre el origen del olivo, una que postula que proviene de las costas de Siria, Líbano e Israel y otra que considera que lo considera originario de Asia menor. La llegada a Europa probablemente tuvo lugar de mano de los Fenicios, en transito por Chipre, Creta, e Islas del Mar Egeo, pasando a Grecia y más tarde a Italia. Los primeros indicios de la presencia del olivo en las costas mediterráneas españolas coinciden con el dominio romano, aunque fueron posteriormente los árabes los que impulsaron su cultivo en Andalucía, convirtiendo a España en el primer país productor de aceite de oliva a nivel mundial.',50,70,56);
INSERT INTO producto VALUES (23,'FR-106','Peral',4,'8/10','Frutales Talavera S.A','Árbol piramidal, redondeado en su juventud, luego oval, que llega hasta 20 metros de altura y por término medio vive 65 años.Tronco alto, grueso, de corteza agrietada, gris, de la cual se destacan con frecuencia placas lenticulares.Las ramas se insertan formando ángulo agudo con el tronco (45º), de corteza lisa, primero verde y luego gris-violácea, con numerosas lenticelas.',50,11,8);
INSERT INTO producto VALUES (24,'FR-107','Peral',4,'10/12','Frutales Talavera S.A','Árbol piramidal, redondeado en su juventud, luego oval, que llega hasta 20 metros de altura y por término medio vive 65 años.Tronco alto, grueso, de corteza agrietada, gris, de la cual se destacan con frecuencia placas lenticulares.Las ramas se insertan formando ángulo agudo con el tronco (45º), de corteza lisa, primero verde y luego gris-violácea, con numerosas lenticelas.',50,22,17);
INSERT INTO producto VALUES (25,'FR-108','Peral',4,'12/14','Frutales Talavera S.A','Árbol piramidal, redondeado en su juventud, luego oval, que llega hasta 20 metros de altura y por término medio vive 65 años.Tronco alto, grueso, de corteza agrietada, gris, de la cual se destacan con frecuencia placas lenticulares.Las ramas se insertan formando ángulo agudo con el tronco (45º), de corteza lisa, primero verde y luego gris-violácea, con numerosas lenticelas.',50,32,25);
INSERT INTO producto VALUES (26,'FR-11','Limonero 30/40',4,'','NaranjasValencianas.com','El limonero, pertenece al grupo de los cítricos, teniendo su origen hace unos 20 millones de años en el sudeste asiático. Fue introducido por los árabes en el área mediterránea entre los años 1.000 a 1.200, habiendo experimentando numerosas modificaciones debidas tanto a la selección natural mediante hibridaciones espontáneas como a las producidas por el',15,100,80);
INSERT INTO producto VALUES (27,'FR-12','Kunquat ',4,'','NaranjasValencianas.com','su nombre científico se origina en honor a un hoticultor escocés que recolectó especímenes en China, (\"Fortunella\"), Robert Fortune (1812-1880), y \"margarita\", del latín margaritus-a-um = perla, en alusión a sus pequeños y brillantes frutos. Se trata de un arbusto o árbol pequeño de 2-3 m de altura, inerme o con escasas espinas.Hojas lanceoladas de 4-8 (-15) cm de longitud, con el ápice redondeado y la base cuneada.Tienen el margen crenulado en su mitad superior, el haz verde brillante y el envés más pálido.Pecíolo ligeramente marginado.Flores perfumadas solitarias o agrupadas en inflorescencias axilares, blancas.El fruto es lo más característico, es el más pequeño de todos los cítricos y el único cuya cáscara se puede comer.Frutos pequeños, con semillas, de corteza fina, dulce, aromática y comestible, y de pulpa naranja amarillenta y ligeramente ácida.Sus frutos son muy pequeños y tienen un carácter principalmente ornamental.',15,21,16);
INSERT INTO producto VALUES (28,'FR-13','Kunquat  EXTRA con FRUTA',4,'150-170','NaranjasValencianas.com','su nombre científico se origina en honor a un hoticultor escocés que recolectó especímenes en China, (\"Fortunella\"), Robert Fortune (1812-1880), y \"margarita\", del latín margaritus-a-um = perla, en alusión a sus pequeños y brillantes frutos. Se trata de un arbusto o árbol pequeño de 2-3 m de altura, inerme o con escasas espinas.Hojas lanceoladas de 4-8 (-15) cm de longitud, con el ápice redondeado y la base cuneada.Tienen el margen crenulado en su mitad superior, el haz verde brillante y el envés más pálido.Pecíolo ligeramente marginado.Flores perfumadas solitarias o agrupadas en inflorescencias axilares, blancas.El fruto es lo más característico, es el más pequeño de todos los cítricos y el único cuya cáscara se puede comer.Frutos pequeños, con semillas, de corteza fina, dulce, aromática y comestible, y de pulpa naranja amarillenta y ligeramente ácida.Sus frutos son muy pequeños y tienen un carácter principalmente ornamental.',15,57,45);
INSERT INTO producto VALUES (29,'FR-14','Calamondin Mini',4,'','Frutales Talavera S.A','Se trata de un pequeño arbolito de copa densa, con tendencia a la verticalidad, inerme o con cortas espinas. Sus hojas son pequeñas, elípticas de 5-10 cm de longitud, con los pecíolos estrechamente alados.Posee 1 o 2 flores en situación axilar, al final de las ramillas.Sus frutos son muy pequeños (3-3,5 cm de diámetro), con pocas semillas, esféricos u ovales, con la zona apical aplanada; corteza de color naranja-rojizo, muy fina y fácilmente separable de la pulpa, que es dulce, ácida y comestible..',15,10,8);
INSERT INTO producto VALUES (30,'FR-15','Calamondin Copa ',4,'','Frutales Talavera S.A','Se trata de un pequeño arbolito de copa densa, con tendencia a la verticalidad, inerme o con cortas espinas. Sus hojas son pequeñas, elípticas de 5-10 cm de longitud, con los pecíolos estrechamente alados.Posee 1 o 2 flores en situación axilar, al final de las ramillas.Sus frutos son muy pequeños (3-3,5 cm de diámetro), con pocas semillas, esféricos u ovales, con la zona apical aplanada; corteza de color naranja-rojizo, muy fina y fácilmente separable de la pulpa, que es dulce, ácida y comestible..',15,25,20);
INSERT INTO producto VALUES (31,'FR-16','Calamondin Copa EXTRA Con FRUTA',4,'100-120','Frutales Talavera S.A','Se trata de un pequeño arbolito de copa densa, con tendencia a la verticalidad, inerme o con cortas espinas. Sus hojas son pequeñas, elípticas de 5-10 cm de longitud, con los pecíolos estrechamente alados.Posee 1 o 2 flores en situación axilar, al final de las ramillas.Sus frutos son muy pequeños (3-3,5 cm de diámetro), con pocas semillas, esféricos u ovales, con la zona apical aplanada; corteza de color naranja-rojizo, muy fina y fácilmente separable de la pulpa, que es dulce, ácida y comestible..',15,45,36);
INSERT INTO producto VALUES (32,'FR-17','Rosal bajo 1Âª -En maceta-inicio brotación',4,'','Frutales Talavera S.A','',15,2,1);
INSERT INTO producto VALUES (33,'FR-18','ROSAL TREPADOR',4,'','Frutales Talavera S.A','',350,4,3);
INSERT INTO producto VALUES (34,'FR-19','Camelia Blanco, Chrysler Rojo, Soraya Naranja, ',4,'','NaranjasValencianas.com','',350,4,3);
INSERT INTO producto VALUES (35,'FR-2','Naranjo -Plantón joven 1 año injerto',4,'','NaranjasValencianas.com','El naranjo es un árbol pequeño, que no supera los 3-5 metros de altura, con una copa compacta, cónica, transformada en esérica gracias a la poda. Su tronco es de color gris y liso, y las hojas son perennes, coriáceas, de un verde intenso y brillante, con forma oval o elíptico-lanceolada. Poseen, en el caso del naranjo amargo, un típico peciolo alado en forma de Â‘corazónÂ’, que en el naranjo dulce es más estrecho y menos patente.',15,6,4);
INSERT INTO producto VALUES (36,'FR-20','Landora Amarillo, Rose Gaujard bicolor blanco-rojo',4,'','Frutales Talavera S.A','',350,4,3);
INSERT INTO producto VALUES (37,'FR-21','Kordes Perfect bicolor rojo-amarillo, Roundelay rojo fuerte',4,'','Frutales Talavera S.A','',350,4,3);
INSERT INTO producto VALUES (38,'FR-22','Pitimini rojo',4,'','Frutales Talavera S.A','',350,4,3);
INSERT INTO producto VALUES (39,'FR-23','Rosal copa ',4,'','Frutales Talavera S.A','',400,8,6);
INSERT INTO producto VALUES (40,'FR-24','Albaricoquero Corbato',4,'','Melocotones de Cieza S.A.','árbol que puede pasar de los 6 m de altura, en la región mediterránea con ramas formando una copa redondeada. La corteza del tronco es pardo-violácea, agrietada; las ramas son rojizas y extendidas cuando jóvenes y las ramas secundarias son cortas, divergentes y escasas. Las yemas latentes son frecuentes especialmente sobre las ramas viejas.',400,8,6);
INSERT INTO producto VALUES (41,'FR-25','Albaricoquero Moniqui',4,'','Melocotones de Cieza S.A.','árbol que puede pasar de los 6 m de altura, en la región mediterránea con ramas formando una copa redondeada. La corteza del tronco es pardo-violácea, agrietada; las ramas son rojizas y extendidas cuando jóvenes y las ramas secundarias son cortas, divergentes y escasas. Las yemas latentes son frecuentes especialmente sobre las ramas viejas.',400,8,6);
INSERT INTO producto VALUES (42,'FR-26','Albaricoquero Kurrot',4,'','Melocotones de Cieza S.A.','árbol que puede pasar de los 6 m de altura, en la región mediterránea con ramas formando una copa redondeada. La corteza del tronco es pardo-violácea, agrietada; las ramas son rojizas y extendidas cuando jóvenes y las ramas secundarias son cortas, divergentes y escasas. Las yemas latentes son frecuentes especialmente sobre las ramas viejas.',400,8,6);
INSERT INTO producto VALUES (43,'FR-27','Cerezo Burlat',4,'','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", híbrido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundiéndose después hacia Europa y Asia, llevado por los pájaros y las migraciones humanas. Fue uno de los frutales más apreciados por los griegos y con el Imperio Romano se extendió a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y países del mundo con clima templado',400,8,6);
INSERT INTO producto VALUES (44,'FR-28','Cerezo Picota',4,'','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", híbrido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundiéndose después hacia Europa y Asia, llevado por los pájaros y las migraciones humanas. Fue uno de los frutales más apreciados por los griegos y con el Imperio Romano se extendió a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y países del mundo con clima templado',400,8,6);
INSERT INTO producto VALUES (45,'FR-29','Cerezo Napoleón',4,'','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", híbrido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundiéndose después hacia Europa y Asia, llevado por los pájaros y las migraciones humanas. Fue uno de los frutales más apreciados por los griegos y con el Imperio Romano se extendió a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y países del mundo con clima templado',400,8,6);
INSERT INTO producto VALUES (46,'FR-3','Naranjo 2 años injerto',4,'','NaranjasValencianas.com','El naranjo es un árbol pequeño, que no supera los 3-5 metros de altura, con una copa compacta, cónica, transformada en esérica gracias a la poda. Su tronco es de color gris y liso, y las hojas son perennes, coriáceas, de un verde intenso y brillante, con forma oval o elíptico-lanceolada. Poseen, en el caso del naranjo amargo, un típico peciolo alado en forma de Â‘corazónÂ’, que en el naranjo dulce es más estrecho y menos patente.',15,7,5);
INSERT INTO producto VALUES (47,'FR-30','Ciruelo R. Claudia Verde   ',4,'','Frutales Talavera S.A','árbol de tamaño mediano que alcanza una altura máxima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, pequeñas, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',400,8,6);
INSERT INTO producto VALUES (48,'FR-31','Ciruelo Santa Rosa',4,'','Frutales Talavera S.A','árbol de tamaño mediano que alcanza una altura máxima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, pequeñas, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',400,8,6);
INSERT INTO producto VALUES (49,'FR-32','Ciruelo Golden Japan',4,'','Frutales Talavera S.A','árbol de tamaño mediano que alcanza una altura máxima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, pequeñas, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',400,8,6);
INSERT INTO producto VALUES (50,'FR-33','Ciruelo Friar',4,'','Frutales Talavera S.A','árbol de tamaño mediano que alcanza una altura máxima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, pequeñas, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',400,8,6);

-- Valores de detalle_pedido  
INSERT INTO detalle_pedido VALUES (1,1,45,10,70,3);
INSERT INTO detalle_pedido VALUES (2,1,46,40,4,1);
INSERT INTO detalle_pedido VALUES (3,1,31,25,4,2);
INSERT INTO detalle_pedido VALUES (4,1,3,15,19,4);
INSERT INTO detalle_pedido VALUES (5,1,5,23,14,5);
INSERT INTO detalle_pedido VALUES (6,2,6,3,29,6);
INSERT INTO detalle_pedido VALUES (7,2,7,7,8,7);
INSERT INTO detalle_pedido VALUES (8,2,9,50,4,3);
INSERT INTO detalle_pedido VALUES (9,2,4,20,5,2);
INSERT INTO detalle_pedido VALUES (10,2,43,12,6,5);
INSERT INTO detalle_pedido VALUES (11,2,13,67,64,1);
INSERT INTO detalle_pedido VALUES (12,2,5,5,462,4);
INSERT INTO detalle_pedido VALUES (13,3,8,120,9,6);
INSERT INTO detalle_pedido VALUES (14,3,22,32,5,4);
INSERT INTO detalle_pedido VALUES (15,3,23,11,5,5);
INSERT INTO detalle_pedido VALUES (16,3,13,30,266,1);
INSERT INTO detalle_pedido VALUES (17,3,17,15,65,2);
INSERT INTO detalle_pedido VALUES (18,3,18,24,25,3);
INSERT INTO detalle_pedido VALUES (19,4,31,12,8,7);
INSERT INTO detalle_pedido VALUES (20,4,34,42,8,6);
INSERT INTO detalle_pedido VALUES (21,4,40,42,9,8);
INSERT INTO detalle_pedido VALUES (22,4,25,3,6,5);
INSERT INTO detalle_pedido VALUES (23,4,43,4,6,3);
INSERT INTO detalle_pedido VALUES (24,4,16,17,9,4);
INSERT INTO detalle_pedido VALUES (25,4,14,38,10,2);
INSERT INTO detalle_pedido VALUES (26,4,13,21,59,1);
INSERT INTO detalle_pedido VALUES (30,9,1,80,1,3);
INSERT INTO detalle_pedido VALUES (31,9,8,450,1,2);
INSERT INTO detalle_pedido VALUES (32,9,6,80,8,1);
INSERT INTO detalle_pedido VALUES (33,9,9,15,91,2);
INSERT INTO detalle_pedido VALUES (34,10,28,5,70,2);
INSERT INTO detalle_pedido VALUES (35,10,19,30,75,1);
INSERT INTO detalle_pedido VALUES (36,10,34,5,64,3);
INSERT INTO detalle_pedido VALUES (37,11,6,180,1,3);
INSERT INTO detalle_pedido VALUES (38,11,47,80,8,1);
INSERT INTO detalle_pedido VALUES (39,12,9,290,1,1);
INSERT INTO detalle_pedido VALUES (40,13,9,5,14,1);
INSERT INTO detalle_pedido VALUES (41,13,11,12,14,2);
INSERT INTO detalle_pedido VALUES (42,13,14,5,100,3);
INSERT INTO detalle_pedido VALUES (43,14,23,8,11,2);
INSERT INTO detalle_pedido VALUES (44,14,13,13,57,1);
INSERT INTO detalle_pedido VALUES (45,15,48,4,13,3);
INSERT INTO detalle_pedido VALUES (46,15,33,2,6,2);
INSERT INTO detalle_pedido VALUES (47,15,36,6,10,1);
INSERT INTO detalle_pedido VALUES (48,15,23,9,10,4);
INSERT INTO detalle_pedido VALUES (49,16,45,12,12,1);
INSERT INTO detalle_pedido VALUES (50,16,36,10,9,2);
INSERT INTO detalle_pedido VALUES (51,17,11,5,14,1);
INSERT INTO detalle_pedido VALUES (52,17,22,5,12,3);
INSERT INTO detalle_pedido VALUES (53,17,37,5,9,2);
INSERT INTO detalle_pedido VALUES (54,17,46,5,22,4);
INSERT INTO detalle_pedido VALUES (55,17,36,5,18,5);
INSERT INTO detalle_pedido VALUES (56,18,24,4,12,2);
INSERT INTO detalle_pedido VALUES (57,18,22,2,4,1);
INSERT INTO detalle_pedido VALUES (58,18,15,10,6,3);
INSERT INTO detalle_pedido VALUES (59,19,10,9,12,5);
INSERT INTO detalle_pedido VALUES (60,19,23,6,8,4);
INSERT INTO detalle_pedido VALUES (61,19,17,1,32,2);
INSERT INTO detalle_pedido VALUES (62,19,48,5,13,1);
INSERT INTO detalle_pedido VALUES (63,19,20,20,4,3);
INSERT INTO detalle_pedido VALUES (64,20,11,14,14,1);
INSERT INTO detalle_pedido VALUES (65,20,30,8,12,2);
INSERT INTO detalle_pedido VALUES (66,21,21,5,14,3);
INSERT INTO detalle_pedido VALUES (67,21,18,22,4,1);
INSERT INTO detalle_pedido VALUES (68,21,5,3,8,2);
INSERT INTO detalle_pedido VALUES (69,22,24,1,6,1);
INSERT INTO detalle_pedido VALUES (70,23,2,110,1,4);
INSERT INTO detalle_pedido VALUES (71,23,10,50,22,3);
INSERT INTO detalle_pedido VALUES (72,23,8,4,70,2);
INSERT INTO detalle_pedido VALUES (73,23,49,30,5,1);
INSERT INTO detalle_pedido VALUES (74,24,22,3,15,1);
INSERT INTO detalle_pedido VALUES (75,24,1,4,7,4);
INSERT INTO detalle_pedido VALUES (76,24,23,2,7,2);
INSERT INTO detalle_pedido VALUES (77,24,21,10,20,3);
INSERT INTO detalle_pedido VALUES (78,25,7,15,69,1);
INSERT INTO detalle_pedido VALUES (79,25,9,4,30,3);
INSERT INTO detalle_pedido VALUES (80,25,4,10,30,2);
INSERT INTO detalle_pedido VALUES (81,26,15,9,25,3);
INSERT INTO detalle_pedido VALUES (82,26,18,4,25,1);
INSERT INTO detalle_pedido VALUES (83,26,18,14,25,2);
INSERT INTO detalle_pedido VALUES (84,27,11,22,6,2);
INSERT INTO detalle_pedido VALUES (85,27,2,22,6,3);
INSERT INTO detalle_pedido VALUES (86,27,16,40,6,1);
INSERT INTO detalle_pedido VALUES (87,28,11,8,99,3);
INSERT INTO detalle_pedido VALUES (88,28,13,3,266,2);
INSERT INTO detalle_pedido VALUES (89,28,47,1,462,1);
INSERT INTO detalle_pedido VALUES (90,29,2,4,70,4);
INSERT INTO detalle_pedido VALUES (91,29,9,4,28,1);
INSERT INTO detalle_pedido VALUES (92,29,4,20,31,5);
INSERT INTO detalle_pedido VALUES (93,29,12,2,111,2);
INSERT INTO detalle_pedido VALUES (94,29,10,10,9,3);
INSERT INTO detalle_pedido VALUES (95,30,4,10,1,6);
INSERT INTO detalle_pedido VALUES (96,30,8,2,32,2);
INSERT INTO detalle_pedido VALUES (97,30,12,2,19,3);
INSERT INTO detalle_pedido VALUES (98,30,7,4,31,5);
INSERT INTO detalle_pedido VALUES (99,30,9,10,45,1);
INSERT INTO detalle_pedido VALUES (100,30,10,5,5,4);
INSERT INTO detalle_pedido VALUES (101,31,9,25,2,3);
INSERT INTO detalle_pedido VALUES (102,31,12,1,20,1);
INSERT INTO detalle_pedido VALUES (103,31,4,6,29,2);
INSERT INTO detalle_pedido VALUES (104,32,19,1,14,4);
INSERT INTO detalle_pedido VALUES (105,32,26,4,15,5);
INSERT INTO detalle_pedido VALUES (106,32,25,1,15,3);
INSERT INTO detalle_pedido VALUES (107,32,28,29,100,2);
INSERT INTO detalle_pedido VALUES (108,32,13,5,20,1);
INSERT INTO detalle_pedido VALUES (109,33,17,423,2,4);
INSERT INTO detalle_pedido VALUES (110,33,29,120,8,3);
INSERT INTO detalle_pedido VALUES (111,33,24,212,10,2);
INSERT INTO detalle_pedido VALUES (112,33,27,150,462,1);
INSERT INTO detalle_pedido VALUES (113,34,3,56,7,4);
INSERT INTO detalle_pedido VALUES (114,34,7,12,29,3);
INSERT INTO detalle_pedido VALUES (115,34,12,20,18,1);
INSERT INTO detalle_pedido VALUES (116,34,14,24,18,2);
INSERT INTO detalle_pedido VALUES (117,35,21,12,14,4);
INSERT INTO detalle_pedido VALUES (118,35,47,55,8,3);
INSERT INTO detalle_pedido VALUES (119,35,16,3,10,2);
INSERT INTO detalle_pedido VALUES (120,35,18,36,10,1);
INSERT INTO detalle_pedido VALUES (121,35,22,72,10,5);
INSERT INTO detalle_pedido VALUES (122,36,30,4,12,2);
INSERT INTO detalle_pedido VALUES (123,36,1,2,7,3);
INSERT INTO detalle_pedido VALUES (124,36,17,6,7,4);
INSERT INTO detalle_pedido VALUES (125,36,3,1,12,5);
INSERT INTO detalle_pedido VALUES (126,36,9,15,13,1);
INSERT INTO detalle_pedido VALUES (127,37,15,4,70,1);
INSERT INTO detalle_pedido VALUES (128,37,7,203,8,2);
INSERT INTO detalle_pedido VALUES (129,37,16,38,10,3);
INSERT INTO detalle_pedido VALUES (130,38,19,5,14,1);
INSERT INTO detalle_pedido VALUES (131,38,26,2,14,2);
INSERT INTO detalle_pedido VALUES (132,39,25,3,12,1);
INSERT INTO detalle_pedido VALUES (133,39,30,6,12,2);
INSERT INTO detalle_pedido VALUES (134,40,1,4,1,1);
INSERT INTO detalle_pedido VALUES (135,40,2,8,1,2);

-- Valores de pago  
INSERT INTO pago VALUES (1,1,'PayPal','ak-std-000001','2008-11-10',2000);
INSERT INTO pago VALUES (2,1,'PayPal','ak-std-000002','2008-12-10',2000);
INSERT INTO pago VALUES (3,3,'PayPal','ak-std-000003','2009-01-16',5000);
INSERT INTO pago VALUES (4,3,'PayPal','ak-std-000004','2009-02-16',5000);
INSERT INTO pago VALUES (5,3,'PayPal','ak-std-000005','2009-02-19',926);
INSERT INTO pago VALUES (6,4,'PayPal','ak-std-000006','2007-01-08',20000);
INSERT INTO pago VALUES (7,4,'PayPal','ak-std-000007','2007-01-08',20000);
INSERT INTO pago VALUES (8,4,'PayPal','ak-std-000008','2007-01-08',20000);
INSERT INTO pago VALUES (9,4,'PayPal','ak-std-000009','2007-01-08',20000);
INSERT INTO pago VALUES (10,4,'PayPal','ak-std-000010','2007-01-08',1849);
INSERT INTO pago VALUES (11,5,'Transferencia','ak-std-000011','2006-01-18',23794);
INSERT INTO pago VALUES (12,7,'Cheque','ak-std-000012','2009-01-13',2390);
INSERT INTO pago VALUES (13,9,'PayPal','ak-std-000013','2009-01-06',929);
INSERT INTO pago VALUES (14,13,'PayPal','ak-std-000014','2008-08-04',2246);
INSERT INTO pago VALUES (15,14,'PayPal','ak-std-000015','2008-07-15',4160);
INSERT INTO pago VALUES (16,15,'PayPal','ak-std-000016','2009-01-15',2081);
INSERT INTO pago VALUES (17,15,'PayPal','ak-std-000035','2009-02-15',10000);
INSERT INTO pago VALUES (18,16,'PayPal','ak-std-000017','2009-02-16',4399);
INSERT INTO pago VALUES (19,19,'PayPal','ak-std-000018','2009-03-06',232);


