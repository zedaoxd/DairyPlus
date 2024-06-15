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

![image.png](https://trello.com/1/cards/666cb824787d4e6ac189b54b/attachments/666cbbde2276f415d4031f25/download/image.png)
