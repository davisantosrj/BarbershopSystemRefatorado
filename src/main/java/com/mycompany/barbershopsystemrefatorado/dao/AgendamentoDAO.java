/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.dao;

import com.mycompany.barbershopsystemrefatorado.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    // SALVAR AGENDAMENTO
    public void salvar(Agendamento agendamento) {

        String sql = """
            INSERT INTO agendamentos 
            (id_cliente, id_barbeiro, id_servico, data_hora_agendamento)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, agendamento.getCliente().getIdCliente());
            stmt.setInt(2, agendamento.getBarbeiro().getIdBarbeiro());
            stmt.setInt(3, agendamento.getServico().getId());
            stmt.setTimestamp(4, Timestamp.valueOf(agendamento.getDataHoraAgendamento()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar agendamento", e);
        }
    }

    // LISTAR AGENDAMENTOS
    public List<Agendamento> listar() {

        List<Agendamento> lista = new ArrayList<>();

      String sql = """
    SELECT a.id_agendamento, a.data_hora_agendamento,
           c.id_cliente, c.nome AS cliente,
           b.id_barbeiro, b.nome AS barbeiro,
           s.id_servico, s.nome_servico
    FROM agendamentos a
    JOIN cliente c ON a.id_cliente = c.id_cliente
    JOIN barbeiro b ON a.id_barbeiro = b.id_barbeiro
    JOIN servico s ON a.id_servico = s.id_servico
    ORDER BY a.data_hora_agendamento
""";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("cliente"),
                        "", "", ""
                );

                Barbeiro barbeiro = new Barbeiro(
                        rs.getInt("id_barbeiro"),
                        rs.getString("barbeiro"),
                        "", ""
                );

                Servico servico = new Servico(
                        rs.getInt("id_servico"),
                        rs.getString("nome_servico"),
                        "", 0.0, 0
                );

                Agendamento agendamento = new Agendamento(
                        rs.getInt("id_agendamento"),
                        rs.getTimestamp("data_hora_agendamento").toLocalDateTime(),
                        cliente,
                        barbeiro,
                        servico
                );

                lista.add(agendamento);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar agendamentos", e);
        }

        return lista;
    }

    // EXCLUIR AGENDAMENTO
    public void excluir(int idAgendamento) {

        String sql = "DELETE FROM agendamentos WHERE id_agendamento = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idAgendamento);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir agendamento", e);
        }
    }
}