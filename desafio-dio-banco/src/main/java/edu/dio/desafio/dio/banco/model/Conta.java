/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.dio.desafio.dio.banco.model;

import edu.dio.desafio.dio.interfaces.IConta;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author sufra
 */
public class Conta implements IConta{
    private String num;
    private int agencia;
    private double saldo;
    private List<Operacao> listaOperacoes;
    public Conta() {
        listaOperacoes = new ArrayList<Operacao>();
        Random gerador = new Random();
        this.num = "";
        for (int i = 0; i < 6; i++) {
            this.num = this.num + gerador.nextInt();
        }
        this.agencia = 1;
        this.saldo = 0;
    }

    public String getNum() {
        return num;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
        Operacao op = new Operacao("Saque", this, valor);
        listaOperacoes.add(op);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        Operacao op = new Operacao("Depósito", this, valor);
        listaOperacoes.add(op);
    }

    @Override
    public void transferir(Conta conta, double valor) {
        this.sacar(valor);
        conta.depositar(valor);
        Operacao op = new Operacao("Transferencia", this, valor);
        listaOperacoes.add(op);
        System.out.println(op.getTipoOperacao());
    }

    @Override
    public List<Operacao> verExtrato() {
        return listaOperacoes;
    }
    
}
