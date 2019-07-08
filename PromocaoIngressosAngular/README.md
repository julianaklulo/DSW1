# Site de Promoções de Ingressos - Versão Grails + Angular
Este site foi desenvolvido para a disciplina de **Desenvolvimento de Software para Web 1**, ministrada pelo **Prof. Dr. Delano Beder**, da Universidade Federal de São Carlos.

## Objetivos
O sistema possui cadastro de sites de venda de ingressos, com os seguinte dados: e-mail, senha, endereço/URL, nome e telefone.

O sistema possui um cadastro de salas de teatro, com os seguintes dados: e-mail, senha, CNPJ, nome e cidade.

O sistema possui um cadastro de promoções, com os seguintes dados: endereço/URL do site de venda de ingressos, CNPJ do teatro, nome da peça, preço e dia/horário.

## Requisitos

- R1: Operações CRUD de sites de venda de ingressos - requer login de admin.
- R2: Operações CRUD para teatros - requer login de admin.
- R3: Listagem de todos os teatros - disponível sem login.
- R5: Operações CRUD para promoções - requer login de teatro.
- R7: Listagem de todas as promoções - requer login de site.

## Roteiro

### Login:

POST em localhost:8080/PromocaoIngressos/api/login

Para logar como Admin, enviar via json:

```
{
    "username": "admin",
    "password": "admin"
}
```

Para logar como Teatro, enviar via json:

```
{
    "username": "teatro@sc.com",
    "password": "admin"
}
```

Para logar como Site, enviar via json:

```
{
    "username": "admin",
    "password": "cambista@email.com"
}
```

### Site:

Endpoint: ```localhost:8080/PromocaoIngressos/sites```

CRUD necessita login de Admin

### Teatro:

Endpoint: ```localhost:8080/PromocaoIngressos/teatros```

CRUD necessita login de Admin

Listagem de teatros não necessita login

### Promoção

Endpoint: ```localhost:8080/PromocaoIngressos/promocoes```

CRUD necessita login de Teatro

Listagem de promoções necessita login de Site
