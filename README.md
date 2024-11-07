# Arquitetura Java - petShopJava

Este projeto faz do estudo de Arquitetura Java e será desenvolvido em quatro etapas. Esta é a primeira entrega, na qual implementei a funcionalidade de Cadastro de Clientes e Servicos, que permite registrar clientes com seus respectivos servicos (Veterinario e Exame) em um sistema básico utilizando Spring Boot.

## Funcionalidades Entregues

### Feature 1: Cadastro de Clientes e Servicos
Nesta primeira entrega, foram implementadas as seguintes funcionalidades:

- **Cadastro de Clientes**: Cada cliente possui nome, CPF, e-mail e um endereço associado.
- **Cadastro de Servicos**: Dois tipos de Servicos podem ser cadastrados:
  - **Veterinario**: Servicos com características como clínico veterinário.
  - **Exame**: Servicos com informações sobre Exame.
- **Leitura de Arquivo**: O sistema lê um arquivo de texto com informações de Clientes e Servicos e realiza o cadastro automático no sistema.
- **Listagem de Clientes e Servicos**: Exibe os Clientes cadastrados, bem como seus Servicos associados.

## Estrutura do Projeto

- `br.edu.infnet.sergioB.sergioBApplication`: Classe principal do projeto Spring Boot.
- `br.edu.infnet.sergioB.Loader`: Classe responsável por carregar dados iniciais a partir de um arquivo de texto.

### Domínio
- **cliente**: Representa o cliente e contém uma lista de Servicos.
- **Servico**: Classe abstrata para representar Servicos.
  - **Veterinario**: Subclasse de Servico que representa Servicos Veterinario.
  - **Exame**: Subclasse de Servico que representa Servicos Exame.
- **Endereco**: Representa o endereço do cliente.

### Serviço
- **clienteService**: Classe que gerencia a inclusão e recuperação dos Clientes cadastrados.

## Arquivo de Entrada

Os Clientes e Servicos são cadastrados automaticamente a partir do arquivo `files/Clientes.txt`. O arquivo deve seguir o seguinte formato:

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

1. **Clone este repositório**.
2. **Certifique-se de que o Java 11 e o Maven estão instalados** em sua máquina.
3. **Compile o projeto** executando:
```bash
   mvn clean install
```

## Autor
Sergio Bianchi

