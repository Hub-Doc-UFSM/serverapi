-- Caixas vinculadas ao Contrato 1 (TJ - CTR-2024/001)
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (1, 'CX-ADM-24-001', 1);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (2, 'CX-ADM-24-002', 1);

-- Caixa vinculada ao Contrato 2 (TJ - CTR-2024/045)
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (3, 'CX-FIN-24-050', 2);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (6, 'CX-FIN-24-055', 2);

-- Caixa vinculada ao Contrato 3 (MP - MP-SERV-010)
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (4, 'CX-RH-23-010', 3);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (7, 'CX-RH-23-015', 3);

-- Caixa vinculada ao Contrato 4 (SEDUC - Inativo)
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (5, 'CX-ARQ-Legacy', 4);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (8, 'CX-ARQ-Legacy-2', 4);

-- Contrato 5
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (9, 'CX-MP-011-A', 5);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (10, 'CX-MP-011-B', 5);

-- Contrato 6
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (11, 'CX-SEDUC-23-A', 6);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (12, 'CX-SEDUC-23-B', 6);

-- Contrato 7
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (13, 'CX-SES-001-A', 7);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (14, 'CX-SES-001-B', 7);

-- Contrato 8
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (15, 'CX-SES-002-A', 8);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (16, 'CX-SES-002-B', 8);

-- Contrato 9
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (17, 'CX-PC-100-A', 9);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (18, 'CX-PC-100-B', 9);

-- Contrato 10
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (19, 'CX-PC-101-A', 10);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (20, 'CX-PC-101-B', 10);

-- Contrato 11
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (21, 'CX-TRE-24-A', 11);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (22, 'CX-TRE-24-B', 11);

-- Contrato 12
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (23, 'CX-TRE-LOG-A', 12);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (24, 'CX-TRE-LOG-B', 12);

-- Contrato 13
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (25, 'CX-PM-050-A', 13);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (26, 'CX-PM-050-B', 13);

-- Contrato 14
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (27, 'CX-PM-022-A', 14);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (28, 'CX-PM-022-B', 14);

-- Atualizar a sequência para que o próximo ID automático seja 29
ALTER SEQUENCE tb_caixa_id_seq RESTART WITH 29;
