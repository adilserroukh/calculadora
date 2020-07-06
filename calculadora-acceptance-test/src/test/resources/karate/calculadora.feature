Feature: Testing a REST API with Karate


  Scenario: Testing a POST endpoint with request body
    Given url 'http://localhost:8090/calcular'
    And request {operacion: 'SUMA', param1: '1' , param2: '2' }
    When method POST
    Then status 200
    And match $ contains 3


  Scenario: Testing a POST endpoint with request body
    Given url 'http://localhost:8090/calcular'
    And request {operacion: 'RESTA', param1: '1' , param2: '2' }
    When method POST
    Then status 200
    And match $ contains -1

  Scenario: Testing a POST endpoint with request body
    Given url 'http://localhost:8090/calcular'
    And request {operacion: 'TEST', param1: '1' , param2: '2' }
    When method POST
    Then status 400

