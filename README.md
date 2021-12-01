# unifacef-product-apis

Aplicação para cadastro de produtos a ser utilizada na disciplina de Apis Rest com Java e Spring da UNIFACEF. 

## Exercício

Criar serviços que permitam o cadastro de Produto/Preço/Estoque em microsserviços apartados, cada qual com suas respectivas validações.
Também deverá ser criado um microsserviço de agregação onde os payloads oriundos dos microsserviços especialistas devem ser agregados.

## A solução

![image](https://user-images.githubusercontent.com/595044/144319403-2fe3b312-4a9d-4df8-9d21-e79558bb52f6.png)

**Product-Apis:** Microsserviço responsável pelo CRUD de produtos via HTTP, por persistir no mongo e enviar para o Store-Apis.
**Price-Apis:** Microsserviço responsável pelo CRUD de preços via HTTP, por persistir no mongo e enviar para o Store-Apis.
**Iventory-Apis:** Microsserviço responsável pelo CRUD de posições de estoque via HTTP, por persistir no mongo e enviar para o Store-Apis.
**Store-Apis:** Microsserviço responsável por agregar os dados oriundos dos microsserviços de entrada.

## Contratos da api de produto:

- POST /api/v1/products

```
{
  "code": "String",
  "name": "String",
  "description": "String",
  "brand": "String",
  "images": [
    "String"
  ],
  "attributes": [
    {
      "key": "String",
      "value": "String"
    }
  ]
}
```


- PUT /api/v1/products/{code}

```
{
  "name": "String",
  "description": "String",
  "brand": "String",
  "images": [
    "String"
  ],
  "attributes": [
    {
      "key": "String",
      "value": "String"
    }
  ]
}
```

- GET /api/v1/products/{code}

```
{
  "code": "String",
  "name": "String",
  "description": "String",
  "brand": "String",
  "images": [
    "String"
  ],
  "attributes": [
    {
      "key": "String",
      "value": "String"
    }
  ],
  "createdDate": "LocalDateTime",
  "lastModifiedDate": "LocalDateTime"
}
```

- GET /api/v1/products

```
{
  "items": [
    {
      "code": "String",
      "name": "String",
      "description": "String",
      "brand": "String",
      "images": [
        "String"
      ],
      "attributes": [
        {
          "key": "String",
          "value": "String"
        }
      ],
      "createdDate": "LocalDateTime",
      "lastModifiedDate": "LocalDateTime"
    }
  ],
  "page": "Integer",
  "size": "Integer",
  "totalElements": "Integer",
  "totalPages": "Integer"
}
```

## Tecnologias utilizadas

- Java 8
- MongoDB
- Lombok
- Spring Boot
- Spring Data
- Open Feign
- FF4J

### Para subir a APP

- Criar um banco de dados mongo local chamado *product-api*, ou alterar o arquivo application.yml atualizando-o para o endereço mongo correto.
- Após subir essa aplicação ficará disponível em http://localhost:8081
- Swagger disponível em: http://localhost:8081/swagger-ui.html
- FF4J disponível em: http://localhost:8081/ff4j-console/

## Contatos

prog.tiago@gmail.com

https://www.linkedin.com/in/tiago-silva-644b0533/



