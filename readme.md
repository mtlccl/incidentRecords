
# Gestão de incidentes - BackEnd

## Resetar o application.properties para o Ambiente Local

1 - Abra o arquivo src/main/resources/application.properties.

2 - Defina no seu application.properties em qual porta ele irá rodar e em seguida, você precisara definir qual a porta, o back-end está rodando: 
***
    server.port=8081
    host.api.gestao.vagas=http://localhost:8081 
***

3- Salve o arquivo.

## Executando a aplicação no Ambiente Local

1 - Instale as dependências do projeto:
***
    mvn -U  clean install
***

2 - Inicie o projeto: 
***
    mvn spring-boot:run
***

A aplicação estará disponível em http://localhost:8081.
(Note que que, este 8081 deverá ser substituído pela porta que você configurou no seu application.properties.)
