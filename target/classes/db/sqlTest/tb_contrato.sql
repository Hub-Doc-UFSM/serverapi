INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (1, 'CTR-2024/001', '2024-01-15', true, 1);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (2, 'CTR-2024/045', '2024-03-01', true, 1);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (3, 'MP-SERV-010', '2023-11-20', true, 2);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (4, 'CTR-ARQUIVO-2015', '2015-06-10', false, 3);

ALTER SEQUENCE tb_contrato_seq RESTART WITH 5;