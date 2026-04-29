/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.main;

import com.mycompany.barbershopsystemrefatorado.controller.AgendamentoController;
import com.mycompany.barbershopsystemrefatorado.model.Agendamento;
import java.util.List;

public class MainTeste {

    public static void main(String[] args) {

        System.out.println("=== LISTANDO AGENDAMENTOS ===");

        AgendamentoController controller = new AgendamentoController(); // ✅ cria objeto

        List<Agendamento> lista = controller.listar(); // ✅ usa o objeto
for (Agendamento a : lista) {
    System.out.println(
        a.getId() + " - " +
        a.getCliente().getNome() + " - " +
        a.getServico().getNomeServico()
    );
        }
    }
}