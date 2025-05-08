# Banco Digital - Projeto DIO

Este é um projeto de simulação de um sistema bancário desenvolvido como parte de um desafio da plataforma DIO (Digital Innovation One). O sistema permite cadastrar clientes, gerenciar contas bancárias e realizar operações financeiras como saque, depósito, transferência e consulta de extrato.

## Funcionalidades

- **Cadastrar Cliente**: Permite cadastrar um cliente com o nome e o tipo de conta (Conta Corrente ou Conta Poupança).
- **Selecionar Cliente**: Após o cadastro, o cliente pode ser selecionado para realizar operações na conta.
- **Operações Bancárias**:
  - **Saque**: Permite ao cliente retirar um valor de sua conta.
  - **Depósito**: Permite ao cliente depositar um valor em sua conta.
  - **Transferência**: Permite ao cliente transferir um valor para a conta de outro cliente.
  - **Extrato**: Permite ao cliente visualizar todas as operações realizadas em sua conta.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para o desenvolvimento do sistema.
- **Stream API**: Usada para manipulação de coleções de clientes e operações bancárias.

## Como Executar

### Pré-requisitos

- **JDK 8 ou superior** instalado em seu computador.

### Passos para Execução

1. Clone este repositório ou baixe o código fonte para sua máquina local.
2. Abra o projeto em um editor de código (como IntelliJ IDEA, Eclipse, ou qualquer editor de sua preferência).
3. Compile e execute a classe `Banco.java` que contém o método `main()`.
4. O sistema irá iniciar no console, oferecendo um menu para interagir.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes principais:

- **Banco**: Contém o menu principal e lógica de interação com os clientes e contas bancárias.
- **Cliente**: Representa o cliente do banco, com atributos como nome e a conta associada.
- **Conta**: Representa a conta bancária, com métodos para sacar, depositar, transferir e consultar o extrato.
- **ContaCorrente** e **ContaPoupanca**: Implementações específicas de tipos de conta, ambas herdam de `Conta`.
- **Operacao**: Representa uma operação bancária realizada na conta (depósito, saque, transferência).

