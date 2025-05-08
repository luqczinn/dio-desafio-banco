/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.dio.desafio.dio.interfaces;

import edu.dio.desafio.dio.banco.model.Operacao;
import edu.dio.desafio.dio.banco.model.Conta;
import java.util.List;

/**
 *
 * @author sufra
 */
public interface IConta {
    void sacar(double valor);
    
    void depositar(double valor);
    
    void transferir(Conta conta, double valor);
    
    List<Operacao> verExtrato();
}
