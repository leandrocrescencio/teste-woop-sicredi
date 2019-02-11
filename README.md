# Teste QA Wooop Sicredi #  
Automation Assessment 

## TestCases ##
- src/test/java/api/testcases/ - Automação TestNG + Rest Assured
- src/test/java/ui/testcases/ - Automação Selenium Webdriver + TestNG 

### História ###
**Com o propósito de** Simular um Investimento na Poupança 
**como um** Associado, 
**eu gostaria de** preencher o formulário de simulação 
**e ver** a tabela de resultado com Mês e Valor. 

**Critério de aceitação:**

1. O associado preencher todos os campos corretamente e visualizar o formulário de simulação
2. O associado preencher o Valor inferior a “20.00” e receber a mensagem de orientação “Valor mínimo de 20.00”.


* Analise a história e defina os testes de aceitação.
* Exponha o planejamento para execução dos testes.
* Informe e justifique as técnicas de testes escolhidas.

- Técnicas de bordas limites, e partição de equivalência utilizadas para verificar o fluxo feliz, onde é possível que o associado faça uma simulação corretamente, assim como a verificação das mensagens de erros de "Valor mínimo de 20.00". Foi utilizado dataprovider para a entrada de dados dessa maneira para as variadas execuções se utiliza o mesmo script. Apesar da não utilização de um framework BDD como o Cucumber a análise de negócio partiu do comportamento apresentado no sistema e na História de Usuário apresentada e suas variações de negócio.

- As escolhas para testes de API e UI foram feitas para garantir harmonia entre os scripts, ou seja, ambas coexistirem em um mesmo projeto, e com a possibilidade de serem integrados em possíveis pipelines. E também a possibilidade de juntar em mesmas suites de regressão tanto testes de API quanto de UI.
