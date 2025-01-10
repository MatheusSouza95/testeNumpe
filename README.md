# testeNumpe
Teste abastecimento

Projeto para administrar o abastecimento de veiculos.

Configuração do backend:

Após clonar o repo é necessário utilizar os seguintes comandos

1 - mvn clean install

2 - mvn spring-boot:run


O banco de dados utilizado foi o H2 com isso não é necessário fazer alguma configuração prévia ao startar o projeto o mesmo é iniciado

# EXEMPLOS DE CHAMADAS: 

  #POST

url -> http://localhost:8080/abastecimentos

{
  "placa": "MMM-3461",
  "quilometragem": 20131,
  "vlTotal": 250.5,
  "dhAbastecimento": "2025-01-09T14:00:00"
}


#GET (ALL)
 url -> http://localhost:8080/abastecimentos

#GET (PLACA)
 url -> http://localhost:8080/abastecimentos?placa=MMM-3461

 #GET (ById)
 url -> http://localhost:8080/abastecimentos/1

  #DELETE
 url -> http://localhost:8080/abastecimentos/1
