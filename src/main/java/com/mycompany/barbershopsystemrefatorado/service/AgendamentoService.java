/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.service;

import com.mycompany.barbershopsystemrefatorado.dao.AgendamentoDAO;
import com.mycompany.barbershopsystemrefatorado.model.Agendamento;
import java.time.LocalDateTime;
import java.util.List;

public class AgendamentoService {

    private AgendamentoDAO dao;

    public AgendamentoService() {
        this.dao = new AgendamentoDAO();
    }

    public void salvar(Agendamento agendamento) {

        if (agendamento.getCliente() == null || agendamento.getCliente().getIdCliente() <= 0) {
            throw new RuntimeException("Cliente inválido");
        }

        if (agendamento.getBarbeiro() == null || agendamento.getBarbeiro().getIdBarbeiro() <= 0) {
            throw new RuntimeException("Barbeiro inválido");
        }

        if (agendamento.getServico() == null || agendamento.getServico().getId() <= 0) {
            throw new RuntimeException("Serviço inválido");
        }

        if (agendamento.getDataHoraAgendamento() == null) {
            throw new RuntimeException("Data e hora são obrigatórias");
        }

        if (agendamento.getDataHoraAgendamento().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Não é possível agendar para o passado");
        }

        dao.salvar(agendamento);
    }

    public List<Agendamento> listar() {
        return dao.listar();
    }

    public void excluir(int id) {
        dao.excluir(id);
    }
}