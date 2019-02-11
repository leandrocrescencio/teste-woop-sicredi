# Teste QA Wooop Sicredi #  
Automation Assessment 

## TestCases ##
- src/test/java/api/testcases/ - Automa��o TestNG + Rest Assured 
- src/test/java/ui/testcases/ - Automa��o Selenium Webdriver + TestNG

### Hist�ria
**Com o prop�sito de** Simular um Investimento na Poupan�a
**como um** Associado,
**eu gostaria de** preencher o formul�rio de simula��o
**e ver** a tabela de resultado com M�s e Valor.

**Crit�rio de aceita��o:**

1. O associado preencher todos os campos corretamente e visualizar o formul�rio de simula��o
2. O associado preencher o Valor inferior a �20.00� e receber a mensagem de orienta��o �Valor m�nimo de 20.00�.


* Analise a hist�ria e defina os testes de aceita��o.
* Exponha o planejamento para execu��o dos testes.
* Informe e justifique as t�cnicas de testes escolhidas.

- T�cnicas de bordas limites utilizadas para verificar o fluxo feliz, onde � poss�vel que o associado fa�a uma simula��o corretamente, assim como a verifica��o das mensagens de erros de "Valor m�nimo de 20.00". Foi utilizado dataprovider para a entrada de dados dessa maneira para as variadas execu��es. Apesar da n�o utiliza��o de um framework BDD como o Cucumber a an�lise de neg�cio partiu do comportamento apresentado no sistema e na Hist�ria de Usu�rio apresentada.

- As escolhas para testes de API e UI foram feitas para garantir harmonia entre os scripts, ou seja, ambas coexistirem em um mesmo projeto, e com a possibilidade de serem integrados em poss�veis pipelines. E tamb�m a possibilidade de juntar em mesmas suites de regress�o tanto testes de API quanto de UI.


