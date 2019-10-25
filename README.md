# API Alelo


## Stacks utilizadas
* homebrew (mac)
* docker
* docker-compose
* Java 8
* Maven
* MySql

## Setup do projeto (execucao local)
```
# Dentro da pasta do projeto, basta digitar docker-compose up para subir as imagens da api e do banco. Depois, basta acessar os endpoints listados no swagger:

http://localhost:8080/swagger-ui.html#

# ver se os containers estão up, deve existir um container para api e um para o banco de dados:

docker ps
```

### Testar endpoints via curl:

```
### inserir Person
curl -X POST \
  http://localhost:8080/api/inserePerson \
  -H 'Content-Type: application/json' \
  -d '{
      "name":"teste"
}'

### retornar Person (all)
curl -X GET \
  http://localhost:8080/api/retornaPerson \
  -H 'Content-Type: application/json'


### retornar Person (by id)
curl -X GET \
  http://localhost:8080/api/retornaPerson/{id} \
  -H 'Content-Type: application/json'


### atualizar Person (by id)
curl -X PUT \
  http://localhost:8080/api/atualizaPerson \
  -H 'Content-Type: application/json' \
  -d '{
      "id":3, "name":"nome alterado"
}'

### deletar Person (by id)
curl -X DELETE \
  http://localhost:8080/api/deletePerson/{id} \
  -H 'Content-Type: application/json'
 
```

### Acesso ao banco de dados local
```
1 - docker ps
2 - docker exec -it <id do container do alelo_alelo-db> /bin/bash
3 - mysql -h 127.0.0.1 -P 3306 -u root -p
4 - senha: password
5 - use apiAlelo 
6 - fazer o select na tabela person

```
