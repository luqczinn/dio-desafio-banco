/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.dio.desafio.dio.banco.app;

import edu.dio.desafio.dio.banco.model.Cliente;
import edu.dio.desafio.dio.banco.model.ContaCorrente;
import edu.dio.desafio.dio.banco.model.ContaPoupanca;
import edu.dio.desafio.dio.banco.model.Operacao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author sufra
 */

public class Banco {
    private static List<Cliente> listClientes = new ArrayList<>();
    
    private static void cadastrarCliente(String nome, String tipo){
        Cliente cliente;
        if(tipo.equals("corrente")){
            cliente = new Cliente(nome, new ContaCorrente());
        }
        else{
            cliente = new Cliente(nome, new ContaPoupanca());
        }
        listClientes.add(cliente);
    }
    
    private static Cliente buscarCliente(String nome){
        return listClientes.stream()
        .filter(p -> p.getNome().equalsIgnoreCase(nome))
        .findFirst()
        .orElse(null);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        boolean executando = true;
        Cliente cliente;
        while (executando) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar um cliente");
            System.out.println("2 - Selecionar um cliente");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.println("Escolha o tipo de conta:");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupança");
                    System.out.print("Tipo: ");
                    int tipoConta = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoConta == 1) {
                        cadastrarCliente(nome, "corrente");
                    } else if (tipoConta == 2) {
                        cadastrarCliente(nome, "poupanca");
                    } else {
                        System.out.println("Tipo de conta inválido.");
                    }
                    break;

                case 2:
                    System.out.print("Nome do cliente: ");
                    String clienteNome = scanner.nextLine();
                    cliente = buscarCliente(clienteNome);
                    if (cliente != null) {
                        menuCliente(scanner, cliente, banco);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 3:
                    executando = false;
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    public static void menuCliente(Scanner scanner, Cliente cliente, Banco banco) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n=== MENU CLIENTE: " + cliente.getNome() + " ===");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Ver extrato");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Valor para saque: ");
                    double saque = scanner.nextDouble();
                    cliente.getConta().sacar(saque);
                    break;
                case 2:
                    System.out.print("Valor para depósito: ");
                    double deposito = scanner.nextDouble();
                    cliente.getConta().depositar(deposito);
                    break;
                case 3:
                    System.out.print("Nome do destinatário: ");
                    String destinatarioNome = scanner.nextLine();
                    Cliente destinatario = buscarCliente(destinatarioNome);
                    if (destinatario != null) {
                        System.out.print("Valor da transferência: ");
                        double valor = scanner.nextDouble();
                        cliente.getConta().transferir(destinatario.getConta(), valor);
                    } else {
                        System.out.println("Cliente destinatário não encontrado.");
                    }
                    break;
                case 4:
                    Consumer<Operacao> imprimirOp = o -> 
                        System.out.println(o.getTipoOperacao() +"Valor: " + o.getValorOperacao());
                    if (cliente.getConta().verExtrato() != null) {
                        cliente.getConta().verExtrato().forEach(imprimirOp);
                    } else {
                        System.out.println("Nenhuma operação foi realizada.");
                    }
                    break;
                case 5:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}