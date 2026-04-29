/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.model;

/**
 *
 * @author Davi
 */

public class Servico {

    private int idServico;
    private String nomeServico;
    private String descricao;
    private double valor;
    private int duracaoEstimada;

    // 🔹 Construtor completo (Banco)
    public Servico(int idServico, String nomeServico, String descricao, double valor, int duracaoEstimada) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.descricao = descricao;
        this.valor = valor;
        this.duracaoEstimada = duracaoEstimada;
    }

    // 🔹 Construtor cadastro (View)
    public Servico(String nomeServico, String descricao, double valor, int duracaoEstimada) {
        this.nomeServico = nomeServico;
        this.descricao = descricao;
        this.valor = valor;
        this.duracaoEstimada = duracaoEstimada;
    }

   

   public int getId() {
    return idServico;
}

    public String getNomeServico() {
        return nomeServico;
    }

    public String getDescricao() {    
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public int getDuracaoEstimada() {
        return duracaoEstimada;
    }

    @Override
    public String toString() {
        return nomeServico;
    }

}