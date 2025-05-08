/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.dio.desafio.dio.banco.model;

/**
 *
 * @author sufra
 */
public class Operacao {
    private String tipoOperacao;
    private Conta contaOperacao;
    private double valorOperacao;

    public Operacao(String tipoOperacao, Conta contaOperacao, double valorOperacao) {
        this.tipoOperacao = tipoOperacao;
        this.contaOperacao = contaOperacao;
        this.valorOperacao = valorOperacao;
    }
    
    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Conta getContaOperacao() {
        return contaOperacao;
    }

    public void setContaOperacao(Conta contaOperacao) {
        this.contaOperacao = contaOperacao;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }
    
}
