INSERT INTO modalidades(nome) VELUES
(nome 'Msculação'),
(nome 'Funcional'),
(nome 'Jiu-Jitsu'),
(nome 'Muay-Tay'),
(nome 'Pilates');

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 120.00 FROM modalidades WHERE nome = 'Msculação';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Trimestral', 330.00 FROM modalidades WHERE nome = 'Msculação';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 150.00 FROM modalidades WHERE nome = 'Funcional';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 180.00 FROM modalidades WHERE nome = 'Funcional';

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Azul' FROM modalidades WHERE nome = 'Jiu-Jits';

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Rosa' FROM modalidades WHERE nome = 'Jiu-Jits';