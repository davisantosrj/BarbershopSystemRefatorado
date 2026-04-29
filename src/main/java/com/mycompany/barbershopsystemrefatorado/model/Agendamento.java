/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.model;

import java.time.LocalDateTime;

/**
 *
 * @author Davi
 */
public class Agendamento {

    private int idAgendamento;
    private LocalDateTime dataHoraAgendamento;
    private String status;

    private Cliente cliente;
    private Barbeiro barbeiro;
    private Servico servico;

    public Agendamento(int idAgendamento,
                       LocalDateTime dataHoraAgendamento,
                       Cliente cliente,
                       Barbeiro barbeiro,
                       Servico servico) {

        this.idAgendamento = idAgendamento;
        this.dataHoraAgendamento = dataHoraAgendamento;
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.servico = servico;
        this.status = "agendado";
    }

    public int getId() {
        return idAgendamento;
    }

    public LocalDateTime getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public String getStatus() {
        return status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public Servico getServico() {
        return servico;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}