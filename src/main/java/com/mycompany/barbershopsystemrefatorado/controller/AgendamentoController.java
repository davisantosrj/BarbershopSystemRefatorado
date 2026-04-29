/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.controller;

import com.mycompany.barbershopsystemrefatorado.model.Agendamento;
import com.mycompany.barbershopsystemrefatorado.service.AgendamentoService;
import java.util.List;

public class AgendamentoController {

    private AgendamentoService service;

    public AgendamentoController() {
        this.service = new AgendamentoService();
    }

    public void salvar(Agendamento agendamento) {
        service.salvar(agendamento);
    }

    public List<Agendamento> listar() {
        return service.listar();
    }

    public void excluir(int id) {
        service.excluir(id);
    }
}