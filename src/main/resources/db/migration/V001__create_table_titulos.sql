CREATE TABLE `titulo` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_vencimento` date NOT NULL,
  `descricao` varchar(60) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `valor` decimal(19,2) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `titulo` (`codigo`,`data_vencimento`,`descricao`,`status`,`valor`) VALUES (1,'2017-10-20','Suplementos - BCAA 1/3','RECEBIDO',90.00);
INSERT INTO `titulo` (`codigo`,`data_vencimento`,`descricao`,`status`,`valor`) VALUES (2,'2017-11-05','Suplementos - BCAA 2/3','PENDENTE',50.00);
INSERT INTO `titulo` (`codigo`,`data_vencimento`,`descricao`,`status`,`valor`) VALUES (3,'2017-11-20','Suplementos - BCAA 3/3','PENDENTE',50.00);