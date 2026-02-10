INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (1, 'CTR-2024/001', '2024-01-15', true, 1);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (2, 'CTR-2024/045', '2024-03-01', true, 1);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (3, 'MP-SERV-010', '2023-11-20', true, 2);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (4, 'CTR-ARQUIVO-2015', '2015-06-10', false, 3);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (5, 'MP-SERV-011', '2024-02-15', true, 2);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (6, 'SEDUC-EDUC-2023', '2023-05-20', true, 3);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (7, 'SES-MED-001', '2024-01-01', true, 4);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (8, 'SES-HOSP-002', '2024-02-01', true, 4);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (9, 'PC-VTR-100', '2023-08-10', true, 5);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (10, 'PC-INTEL-101', '2023-09-15', true, 5);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (11, 'TRE-MESARIO-24', '2024-01-10', true, 6);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (12, 'TRE-LOGISTICA-24', '2024-03-10', true, 6);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (13, 'PM-ASFALTO-050', '2023-12-01', true, 7);

INSERT INTO tb_contrato (id, codigo_contrato, data_inicio, ativo, orgao_id)
VALUES (14, 'PM-ILUMINACAO-022', '2024-01-20', true, 7);

ALTER SEQUENCE tb_contrato_seq RESTART WITH 15;
