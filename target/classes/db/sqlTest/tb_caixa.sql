-- Caixas vinculadas ao Contrato 1 (TJ - CTR-2024/001)
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (1, 'CX-ADM-24-001', 1);
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (2, 'CX-ADM-24-002', 1);

-- Caixa vinculada ao Contrato 2 (TJ - CTR-2024/045)
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (3, 'CX-FIN-24-050', 2);

-- Caixa vinculada ao Contrato 3 (MP - MP-SERV-010)
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (4, 'CX-RH-23-010', 3);

-- Caixa vinculada ao Contrato 4 (SEDUC - Inativo)
INSERT INTO tb_caixa (id, codigo_etiqueta, contrato_id) VALUES (5, 'CX-ARQ-Legacy', 4);

-- Atualizar a sequência para que o próximo ID automático seja 6
ALTER SEQUENCE sisrest.tb_caixa_id_seq RESTART WITH 6;