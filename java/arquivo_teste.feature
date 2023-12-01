#Author: [211024] Luiz Fernando Meira Minozi
#Keywords Summary:
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition Step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then,Steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#|(Data Tables)
#@(Tags/Labels):To group Scenarios
#<>(placeholder)
#""
# (Comments)
#Feature para a realização de testes

@tag
Feature: Cliente faz saque de dinheiro como um cliente,
  				eu gostaria de sacar dinheiro em caixa eletrônico,
  				para que eu não tenha que esperar em uma fila do banco.

  @tag1
  Scenario: Cliente especial com saldo negativo
				    Given Um cliente especial com saldo atual de -300 reais
				    When for solicitado um saque no valor de 200 reais
				    Then deve efetuar o saque e atualizar o saldo da conta para -500 reais
				    And check more outcomes

  @tag2
  Scenario Outline: Cliente comum com saldo negativo
				    Given Um cliente comum com saldo atual de -200 reais
				    When solicitar um saque no valor de 200 reais
				    Then não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente

    Examples:
			      | name  | value | status  |
			      | name1 |     5 | sucess  |
			      | name2 |     7 | Fail    |