# DairyPlus
A DairyPlus é uma empresa brasileira que atua no ramo de venda de laticínios e distribui seus produtos no mercado internacional, tendo clientes na Europa, China e EUA.

A DairyPlus é uma empresa exportadora e, por isso, tem melhores resultados quando o dólar está mais valorizado.

Como parte do processo de modernização das aplicações web e ferramentas digitais da empresa, surgiu a necessidade do desenvolvimento de uma POC (Proof Of Concept) para uma API que permita receber propostas de compra de clientes, analisar o câmbio de moedas Real Brasileiro em comparação com o Dólar Americano e criar, a partir disso, Oportunidades de Venda dos laticínios.

Essas oportunidades de venda devem ser acessadas diretamente via API Rest e também devem gerar relatórios no formato CSV para análise de negócios.

O fluxo básico é:

1. **Acompanhamento da cotação do dólar americano.** Se o dólar estiver valorizado e houver sequências de valorização da moeda americana, envia esta informação atualizada para o banco de dados e considera esse valor atual do dólar na criação de uma nova proposta.
2. **Entrada de novas propostas de compra por parte dos clientes.** A proposta deve ter os seguintes dados: nome da empresa cliente, valor oferecido por galão de leite (ou equivalente em outros produtos lácteos), quantidade (em galões ou equivalente), país de origem, validade da proposta e data de criação da proposta.
   2\.1 **Regras sobre as propostas:**
   - Apenas usuários do tipo cliente podem inserir novas propostas no sistema.
   - Um operador pode consultar detalhes da proposta, mas não pode deletar propostas.
   - Um usuário Gerente pode consultar detalhes e também pode deletar propostas.
3. **Com as informações de novas propostas e do câmbio atual, são criadas oportunidades de venda que ficam acessíveis aos operadores da DairyPlus por formato JSON ou via CSV.**

‌

**O fluxo de funcionamento da Aplicação está melhor descrito na imagem da aplicação.**

![image](https://github.com/zedaoxd/DairyPlus/assets/55067151/ae457908-f238-41e7-9b89-e05c85adf603)

#### Cloud First:

A intenção da equipe de tecnologia da DairyPlus é migrar suas aplicações para a Cloud e criar as novas APIs e aplicações já preparadas para executar em ambientes de nuvem. Portanto, essa API de oportunidades de vendas deve ser planejada pensando em ser uma aplicação adequada para execução em Cloud.

#### Background das Equipes de Desenvolvimento:

A DairyPlus já possui uma equipe de engenheiros de software que deverá seguir com a manutenção e desenvolvimento. A empresa já tem boas e confiáveis aplicações desenvolvidas com Java EE. A prioridade é manter a linguagem Java como principal linguagem das novas aplicações.

#### Custos:

Os engenheiros sabem que o Java tende a consumir mais recursos de CPU e RAM do hardware e que em Cloud isso tende a aumentar os custos ($$$). Entretanto, os engenheiros sabem também que a plataforma Java evoluiu e continua sendo uma boa alternativa mesmo para Cloud. Um dos motivos para a escolha do Java é sua robustez e a vasta biblioteca de ferramentas e frameworks que facilitam o desenvolvimento e manutenção de aplicações. Além disso, o conhecimento consolidado da equipe em Java permitirá um desenvolvimento mais ágil e eficiente, reduzindo custos com treinamento e tempo de adaptação.

#### Resiliência da Aplicação:

Esta aplicação tende a ser usada em algum momento a médio e longo prazo, durante 24 horas por dia. É necessário que ela possa ter escalabilidade e alta disponibilidade.

## Proposta de Arquitetura
![image](https://github.com/zedaoxd/DairyPlus/assets/55067151/84dc00b2-5d4a-4b6b-b1c5-1daeddfe2708)
