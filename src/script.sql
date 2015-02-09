
CREATE DATABASE empresa;

USE empresa;


CREATE TABLE Proveedores
(
	idProveedor	 char(5) NOT NULL,
	RazonSocial	 varchar(60) NOT NULL,
	Direccion	 varchar(60) NOT NULL,
	Ruc		 varchar(11) NOT NULL,
	Telefono	 varchar(15) NOT NULL,
 	PRIMARY KEY (idProveedor)
)  ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE Empleados
(
	idEmpleado	 char(5) NOT NULL,
	Apellido	 varchar(40) NOT NULL,
	Nombre	         varchar(30) NOT NULL,
        Email		 varchar(50) NOT NULL,
	Usuario		 varchar(20) NOT NULL,
	Clave	         varchar(20) NOT NULL,
 	PRIMARY KEY (idEmpleado)
)  ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE Categorias
(
	idCategoria   int(2) not null,
	Nombre	 varchar(20) NOT NULL,
	Descripcion varchar(60) null,
	PRIMARY KEY (idCategoria)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE Productos
(
	idProducto	 char(5),
	Descripcion	 varchar(50) NOT NULL,
	IdCategoria	 int(2) NOT NULL,	
	PrecioCompra     decimal(18,2) NOT NULL,
	PrecioVenta	 decimal(18,2) NOT NULL,
	Stock		 int(5) NOT NULL,
	PRIMARY KEY (idProducto)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE Clientes(
	idCliente	 char(5) NOT NULL,
	Nombre		 varchar(60) NOT NULL,
	Direccion	 varchar(60) NOT NULL,
	RucDNI		 varchar(11) NOT NULL,
	Telefono	 varchar(15) NOT NULL,
	PRIMARY KEY (idCliente)
	)  ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE Compras
(
	idCompra int(5) NOT NULL,
	idProveedor char(5) NOT NULL,
	idEmpleado  char(5) NOT NULL,
	TipoDoc varchar(20) NOT NULL,
	NroDoc varchar(7) NOT NULL,
	Fecha date NOT NULL,
	SubTotal decimal(18,2) NOT NULL,
	Igv decimal(18,2) NOT NULL,
	Total decimal(18,2) NOT NULL,
	PRIMARY KEY (idCompra),
	FOREIGN KEY (idproveedor) REFERENCES proveedores(idProveedor),
        Foreign Key (idEmpleado) References Empleados(idEmpleado)	
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 

CREATE TABLE Ventas
(
	idVenta	 int(5) NOT NULL,
	idCliente   char(5) NOT NULL,	
	idEmpleado  char(5) NOT NULL,
	TipoDoc  varchar(10) NOT NULL,
	NroDoc  varchar(7) NOT NULL,
	Fecha datetime NOT NULL,
	Total decimal(18,2) NOT NULL,
	PRIMARY KEY (idVenta),
	Foreign Key (idCliente) References Clientes(idCliente),
        Foreign Key (idEmpleado) References Empleados(idEmpleado)
) ENGINE=InnoDB DEFAULT CHARSET=latin1; 


CREATE TABLE DetalleVenta
(
	idVenta int(5) NOT NULL,
	idProducto char(5) NOT NULL,	
	PrecioVenta decimal(18,2) NOT NULL,
	Cantidad int(5) NOT NULL,
	Importe decimal(18,2) NOT NULL,
	Foreign Key (idVenta) references Ventas(idVenta),
	Foreign Key (idProducto) references Productos(idProducto)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




CREATE TABLE DetalleCompra
(
	idCompra int(5) NOT NULL,
	idProducto char(5) NOT NULL,
	Precio decimal(18,2) NOT NULL,
	Cantidad int(5) NOT NULL,
	Importe decimal(18,2) NOT NULL,
	Foreign Key (idCompra) References Compras(idCompra),
	Foreign Key (idProducto) References Productos(idProducto)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Control
(
	parametro varchar(20) NOT NULL,
	Valor int(4) not null,
	PRIMARY KEY (parametro)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-----------------------------INSERTAR DATOS ---------------------------------

--Categorias----------

insert into Categorias values((1,'Zandalias','Zandalias de todos las modelos y marcas');
insert into Categorias values(2,'Polos/camizas','polos y camizas de toas las ,marcas y modelos');
insert into Categorias values(3,'Zapatos','Zapatos de todas la marcas y tallas ');
insert into Categorias values(4,'Casacas','importados y nacional marcas y modelos');
insert into Categorias values(5,'Ternos','hecho a la medida de todos los tamaños');

-- Tabla: Clientes

insert into clientes values( 'C0001', 'CORONEL CASTILLO ERIC GUSTAVO', 'AV lAS PALEMERAS 234 LOS OLIVOS ', '10567892456', '987-6789' );
insert into clientes values( 'C0002', 'VALENCIA MORALES PEDRO HUGO', ' AV LA PAZ 567 MAGDALENA', '10567892456', '987-6789' );
insert into clientes values( 'C0003', 'MARCELO VILLALOBOS RICARDO', 'CALLE RISO PATRON 456 LINCE', '10567892456', '987-6789' );
insert into clientes values( 'C0004', 'ROMERO CASTILLO CARLOS', 'AV TACNA 234 LIMA LOS OLIVOS', '10567892456', '987-6789' );
insert into clientes values( 'C0005', 'ARANDA LUNA ALAN ALBERTO', 'AV AREQUIPA 678 SAN ISIDRO', '10567892456', '987-6789' );
insert into clientes values( 'C0006', 'AYALA PAZ JORGE LUIS', 'JR LAS ARTES 890 SAN BORJA', '11999966733', '987-6789' );
insert into clientes values( 'C0007', 'CHAVEZ CANALES EDGAR RAFAEL', 'AV PARADO 342 MIRAFLORES', '11999966733', '987-6789' );
insert into clientes values( 'C0008', 'FLORES CHAFLOQUE ROSA LIZET', 'AV JAVIER PRADO 456 LA MOLINA', '11999966733', '987-6789' );
insert into clientes values( 'C0009', 'FLORES SHUTE CRISTIAN RAFAEL', 'AV UNIVERSITARIA 234 LOS OLIVOS', '11999966733', '966-23854' );
insert into clientes values( 'C0010', 'GONZALES GARCIA GABRIEL ALEJANDRO', 'LA COSTANERA 231 SAN MIGUEL', '11999966733', '966-23854' );

-- Tabla: productos

Insert Into Productos Values ( 'A0001', 'Baby Class Calzado para bebe tallas 4 a 8',1, 35,45,200 );
Insert Into Productos Values ( 'A0002', 'Baby Line Calzado para bebe',1, 40,50, 170 );
Insert Into Productos Values ( 'A0003', 'Baby Magoo Calzado para bebe',1, 50,60, 567 );
Insert Into Productos Values ( 'A0004', 'Baby sandalia Sandalia',1, 35,45, 367 );
Insert Into Productos Values ( 'A0005', 'Balint Calzado para varon',3, 150,170, 876 );
Insert Into Productos Values ( 'A0006', 'Blucher Calzado para varon',3, 240,280, 267 );
Insert Into Productos Values ( 'A0007', 'Clucher 5 Calzado para varon',3, 180,200, 546 );
Insert Into Productos Values ( 'A0008', 'Ingland Calzado para varon',3, 230,260, 489 );
Insert Into Productos Values ( 'A0009', 'Steeper Clasico Calzado de montaña',3, 280,310, 678 );
Insert Into Productos Values ( 'A0010', 'Steeper Plus Calzado de montaña',3, 220,250, 3456 );
Insert Into Productos Values ( 'A0011', 'Steeper Light Calzado liviabno de montaña',3, 160,180, 765 );
Insert Into Productos Values ( 'A0012', 'Casaca Bomber para dama', 4,330,350, 398 );
Insert Into Productos Values ( 'A0013', 'Casaca Corta para dama', 4,260,280, 845 );
Insert Into Productos Values ( 'A0014', 'Casaca de gamuza para dama',4, 240,260, 967 );
Insert Into Productos Values ( 'A0015', 'Camisa Pierre cardin para Hombre', 2,190,210, 587 );
Insert Into Productos Values ( 'A0016', 'Casaca Sybilla para dama',4, 230,250, 845 );
Insert Into Productos Values ( 'A0017', 'Casaca cuero para varon',4, 180,200, 634 );
Insert Into Productos Values ( 'A0018', 'Casaca cuero de carnero para varon',4, 270,290, 867 );
Insert Into Productos Values ( 'A0019', 'Casaca cuero clasica para varon', 4,260,280, 934 );
Insert Into Productos Values ( 'A0020', 'Casaca corta para varon',4, 190,210, 345 );
Insert Into Productos Values ( 'A0021', 'Casaca larga para varon', 4,450, 480,786 );
Insert Into Productos Values ( 'A0022', 'Sacon para varon',5, 390,410, 956 );
Insert Into Productos Values ( 'A0023', 'Abrigo Split para varon',5, 190, 210,378 );
Insert Into Productos Values ( 'A0024', 'Saco larga para varon',5, 280, 300,888 );


-- Tabla: provedores

insert into Proveedores values( 'P0001', 'DISTRIBUIDORA IMPERIAL', 'AV lAS PALEMERAS 234 LOS OLIVOS ', '10567892456', '987-6789'  );
insert into Proveedores values( 'P0002', 'IMPORTACIONES NEPTUNO SAC', 'AV PERU 123 SMP ', '10566542456', '999-6789'  );
insert into Proveedores values( 'P0003', 'TIENDAS GAMARRA', 'AV GRAU 234 LIMA', '10567895554', '234-6789'  );
insert into Proveedores values( 'P0004', 'JOSE LUIS GALAN', 'AV PARDO 456 MIRAFLORES ', '10567892456', '453-6789'  );
insert into Proveedores values( 'P0005', 'DISTRIBUIDORA EL 9CITO', 'AV TUPAC AMARU 110 ', '10567895432', '234-6789'  );

--Tabla empleados 

insert into Empleados values('E0001','Luisa','Davolio','luisa@gmail.com','luisita','gatita');
insert into Empleados values('E0002','Manolo','Gonzales','manolo@hotmail.com','manolito','jugador');
insert into Empleados values('E0003','Fanny','Chaira','fanny@gmail.com','fannycita','caramelito');
insert into Empleados values('E0004','Roberto','Vidales','robert@hotmail.com','robertito','astuto');
insert into Empleados values('E0005','Michelle','Vargas','mishelle@hotmail.com','michelita','tigresa');


---tabla control
insert into Control values('Categorias',6);
insert into Control values('Clientes',11);
insert into Control values('Productos',25);
insert into Control values('Proveedores',6);
insert into Control values('Ventas',1);
insert into Control values('Compras',1);
insert into Control values('Empleados',6);




