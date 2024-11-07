# Arquitetura Java - Projeto PetShopJava

Este projeto faz parte do estudo de Arquitetura Java e será desenvolvido em quatro etapas. Nesta primeira entrega, implementei a funcionalidade de **Cadastro de Clientes e Serviços**, que permite registrar clientes com seus respectivos serviços (Veterinário e Exame) em um sistema básico utilizando Spring Boot.

## Funcionalidades Entregues

### Feature 1: Cadastro de Clientes e Serviços

Nesta primeira etapa, foram desenvolvidas as seguintes funcionalidades:

- **Cadastro de Clientes**: Cada cliente possui um nome, CPF, e-mail e endereço associado.
- **Cadastro de Serviços**: Dois tipos de serviços podem ser cadastrados:
  - **Veterinário**: Serviços relacionados a consultas clínicas veterinárias.
  - **Exame**: Serviços relacionados a exames específicos.
- **Leitura de Arquivo**: O sistema lê um arquivo de texto com informações de clientes e serviços e realiza o cadastro automático no sistema.
- **Listagem de Clientes e Serviços**: Exibe os clientes cadastrados juntamente com seus serviços associados.

## Estrutura do Projeto

- **`br.edu.infnet.sergioB.sergioBApplication`**: Classe principal do projeto Spring Boot.
- **`br.edu.infnet.sergioB.Loader`**: Classe responsável por carregar dados iniciais a partir de um arquivo de texto.

### Domínio

- **Cliente**: Representa o cliente e contém uma lista de serviços associados.
- **Serviço**: Classe abstrata que representa serviços gerais.
  - **Veterinário**: Subclasse de Serviço que representa serviços veterinários.
  - **Exame**: Subclasse de Serviço que representa serviços de exame.
- **Endereço**: Representa o endereço do cliente.

### Serviço

- **`ClienteService`**: Classe responsável pela inclusão e recuperação dos clientes cadastrados.

## Arquivo de Entrada

Os clientes e serviços são cadastrados automaticamente a partir do arquivo `files/Clientes.txt`. O arquivo deve seguir o seguinte formato:

```plaintext
c;sergio bianchi;42997325021;(21)97225-6577;sergio.bianchi@al.infnet.edu.br;22245-100
a;Nero;12340987;28/02/2010;10.7;vira lata;super docil;
c;lara bianchi;84424233030;(24)99138-7215;lara.bianchi@al.infnet.edu.br;22245-100
a;Pirata;23450986;02/09/2010;10.7;vira lata;Brabo;
c;gael bianchi;86640820064;(22)98451-5374;gael.bianchi@al.infnet.edu.br;22245-100
c;ana carolina bianchi;10682142018;(22)97557-1677;ana.bianchi@al.infnet.edu.br;22245-100
```


## Tecnologias Utilizadas

- Java 11
- Spring Boot 2.7.5
- Maven

## Como Executar

1. Clone este repositório.
2. Certifique-se de que o Java 11 e o Maven estão instalados em sua máquina.
3. Compile o projeto executando:
```bash
   mvn clean install
```
## Configurações Importantes
Para o funcionamento do projeto, configuramos algumas propriedades no arquivo application.properties:
spring.application.name=sergioB
spring.h2.console.enabled=true
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:petshopdb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop
server.port=8081
debug=true

### Detalhes das Configurações
Banco de Dados H2: Configurado como banco de dados em memória para facilitar o desenvolvimento.
Console H2: Ativado para acessar e visualizar o banco de dados em localhost:8081/h2-console.
Servidor na Porta 8081: A aplicação está configurada para iniciar na porta 8081.
Modo de Depuração: O modo de depuração está habilitado para facilitar o acompanhamento de logs e detalhes durante o desenvolvimento.

## Argumentos de Execução
Ao iniciar a aplicação, estamos passando o argumento --server.port=8082 para permitir que o servidor rode na porta 8082. Dessa forma, caso a porta 8081 já esteja em uso, a aplicação poderá utilizar a porta 8082.

## Autor
Sergio Bianchi

