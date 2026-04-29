/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.model;

/**
 *
 * @author Davi
 */
public class Barbeiro {

      private int idBarbeiro;
    private String nome;
    private String telefone;
    private String especialidade;

    // 🔹 Construtor completo (banco)
    public Barbeiro(int idBarbeiro, String nome, String telefone, String especialidade) {
        this.idBarbeiro = idBarbeiro;
        this.nome = nome;
        this.telefone = telefone;
        this.especialidade = especialidade;
    }

    // 🔹 Construtor básico (cadastro) 
    public Barbeiro(String nome, String telefone, String especialidade) {
        this.idBarbeiro = 0;
        this.nome = nome;
        this.telefone = telefone;
        this.especialidade = especialidade;
    }

  

  public int getIdBarbeiro() {
    return idBarbeiro;
}
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
