# MovieFlix

O **MovieFlix** é um sistema no qual os usuários podem navegar em um catálogo de filmes e enviar avaliações sobre os filmes. Deverá ser implementado o modelo de domínio e o seed da base de dados, estruturar o projeto com camadas, validações, segurança e tratamento de exceções, e também recuperar os dados de perfil do usuário. 

## Casos de Uso

### 1. Listar Filmes

**Objetivo:** O sistema deve listar os filmes de maneira paginada e ordenada, permitindo ao usuário filtrar por gênero.

- **[OUT]** O sistema apresenta uma listagem dos **nomes de todos os gêneros**, bem como uma listagem paginada com **título, subtítulo, ano e imagem dos filmes**, ordenada alfabeticamente por título.
- **[IN]** O usuário visitante ou membro **seleciona, opcionalmente, um gênero**.
- **[OUT]** O sistema apresenta a **listagem atualizada**, restringindo-a somente ao gênero selecionado.

### 2. Visualizar Detalhes do Filme

**Objetivo:** O sistema deve fornecer informações detalhadas sobre um filme, incluindo avaliações dos usuários.

- **[IN]** O usuário visitante ou membro **seleciona um filme**.
- **[OUT]** O sistema informa **título, subtítulo, ano, imagem e sinopse do filme**, além de uma listagem dos textos das **avaliações daquele filme**, juntamente com o nome do usuário que fez cada avaliação.
- **[IN]** O usuário membro **informa, opcionalmente, um texto para avaliação do filme**.
- **[OUT]** O sistema apresenta os **dados atualizados**, incluindo a **avaliação feita pelo usuário**.

### Exceção 3.1 - Texto Vazio

- **[IN]** O usuário membro **informa um texto vazio** para avaliação.
- **[OUT]** O sistema **apresenta uma mensagem** de que não é permitido texto vazio na avaliação.

## Critérios de Avaliação

- **GET /genres deve retornar 401 para token inválido**

- **GET /genres deve retornar 200 com todos gêneros para VISITOR logado**

- **GET /genres deve retornar 200 com todos gêneros para MEMBER logado**

- **GET /movies/{id} deve retornar 401 para token inválido**

- **GET /movies/{id} deve retornar 200 com o filme para VISITOR logado**

- **GET /movies/{id} deve retornar 200 com o filme para MEMBER logado**

- **GET /movies/{id} deve retornar 404 para id inexistente**

- **GET /movies deve retornar 401 para token inválido**

- **GET /movies deve retornar 200 com página ordenada de filmes para VISITOR logado**

- **GET /movies deve retornar 200 com página ordenada de filmes para MEMBER logado**

- **GET /movies?genreId={id} deve retornar 200 com página ordenada de filmes filtrados por gênero**

- **POST /reviews deve retornar 401 para token inválido**

- **POST /reviews deve retornar 403 para VISITOR logado**

- **POST /reviews deve retornar 201 com objeto inserido para MEMBER logado e dados válidos**

- **POST /reviews deve retornar 422 para MEMBER logado e dados inválidos**

## Competências Avaliadas

- **Desenvolvimento TDD de API Rest com Java e Spring Boot**: Implementação de testes e desenvolvimento de APIs RESTful utilizando o framework Spring Boot.
  
- **Realização de Casos de Uso**: Desenvolvimento dos casos de uso descritos para listagem de filmes, visualização de detalhes, e avaliações.

- **Consultas a Banco de Dados Relacional com Spring Data JPA**: Implementação de consultas eficientes e seguras em banco de dados relacional utilizando o Spring Data JPA.

- **Tratamento de Erros com Respostas HTTP Customizadas**: Implementação de tratamento de erros e geração de respostas HTTP customizadas para diferentes cenários, como token inválido ou dados inválidos.

- **Controle de Acesso por Perfil de Usuário e Rotas**: Implementação de controle de acesso com base em perfis de usuário (VISITOR, MEMBER) e restrição de acesso às rotas e funcionalidades do sistema.

## Tecnologias Utilizadas

- Java 17 (Spring Boot)
- Spring Security
- Maven
