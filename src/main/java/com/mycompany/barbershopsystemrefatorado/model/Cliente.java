/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.model;

/**
 *
 @author Davi
 */
public class Cliente {

    private int idCliente;
    private String nome;
    private String telefone;
    private String email;
    private String dataCadastro;

    // 🔹 Construtor completo (banco)
    public Cliente(int idCliente, String nome, String telefone, String email, String dataCadastro) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    // 🔹 Construtor basic (cadastro)
    public Cliente(String nomeCliente, String telefone, String email) {
        this.idCliente = 0;
        this.nome = nomeCliente;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = "";
    }

   
  

public int getIdCliente() {
    return idCliente;
}
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString() {
        return nome;
    }}