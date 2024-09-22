CREATE DATABASE IF NOT EXISTS `bd_rest`;

USE `bd_rest`;

CREATE TABLE `Cliente`(
`Id_Cliente` varchar(6) primary key,
`Apellidos` varchar(50),
`Nombres` varchar(50),
`DNI` varchar(10),
`Direccion` varchar(100),
`Telefono` varchar(8),
`Movil` varchar(9)
);

CREATE TABLE `Producto`(
`Id_Prod` varchar(6) primary key,
`Descripcion` varchar(100),
`Cantidad` int(8),
`Costo` decimal(8,2),
`Precio` decimal(8,2),
`Stock` int(8)
);

CREATE TABLE `Pedido`(
`Id_Pedido` varchar(6) primary key,
`Id_Cliente` varchar(6),
`Fecha` date,
`SubTotal` decimal(8,2),
`TotalVenta` decimal(8,2),
CONSTRAINT `fk_id_cliente` FOREIGN KEY (`Id_Cliente`) REFERENCES `Cliente`(`Id_Cliente`)
);

CREATE TABLE `Detalle`(
`Id_Pedido` varchar(6),
`Id_Prod` varchar(6),
`Cantidad` int(8),
`Precio` decimal(8,2),
`TotalDeta` decimal(8,2),
CONSTRAINT `fk_id_pedido` FOREIGN KEY (`Id_Pedido`) REFERENCES `Pedido`(`Id_Pedido`),
CONSTRAINT `fk_id_prod` FOREIGN KEY (`Id_Prod`) REFERENCES `Producto`(`Id_Prod`)
);

DESCRIBE cliente;

INSERT INTO `Cliente`(`Id_Cliente`, `Apellidos`, `Nombres`, `DNI`, `Direccion`, `Telefono`, `Movil`) VALUES ('1','Lujan', 'Carrion', '123456789', 'Molina', '12345678', '123456789');