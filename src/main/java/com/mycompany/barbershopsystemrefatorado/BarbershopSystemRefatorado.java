/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.barbershopsystemrefatorado;

/**
 *
 * @author Davi
 */


import com.mycompany.barbershopsystemrefatorado.controller.AgendamentoController;
import com.mycompany.barbershopsystemrefatorado.model.Agendamento;
import java.util.List;

public class BarbershopSystemRefatorado {

    public static void main(String[] args) {

        System.out.println("=== SISTEMA BARBERSHOP ===");

        AgendamentoController controller = new AgendamentoController();

        List<Agendamento> lista = controller.listar();

        for (Agendamento a : lista) {
            System.out.println(
                a.getId() + " - " +
                a.getCliente().getNome() + " - " +
                a.getServico().getNomeServico()
            );
        }
    }
}