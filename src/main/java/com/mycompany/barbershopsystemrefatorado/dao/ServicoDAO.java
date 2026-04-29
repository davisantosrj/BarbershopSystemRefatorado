/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.dao;

import com.mycompany.barbershopsystem.model.Servico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Davi
 */
public class ServicoDAO {
    
    
    
    
    public void cadastrar(Servico servico) {

        String sql = "INSERT INTO servico (nome_servico, descricao, valor, duracao_estimada) "
                   + "VALUES (?, ?, ?, ?)";

        try (
            Connection con = com.mycompany.barbershopsystem.dao.ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)
        ) {

            stmt.setString(1, servico.getNomeServico());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getValor());
            stmt.setInt(4, servico.getDuracaoEstimada());

            stmt.executeUpdate();

        } catch (SQLException e) {
    JOptionPane.showMessageDialog(null,
        "Erro ao salvar serviço:\n" + e.getMessage(),
        "Erro SQL",
        JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
        }
    }
    
    
   public List<Servico> listarServicos() {
        List<Servico> lista = new ArrayList<>();

        String sql = "SELECT * FROM servico";

        try (Connection con = com.mycompany.barbershopsystem.dao.ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Servico s = new Servico(
                    rs.getInt("id_servico"),
                    rs.getString("nome_servico"),
                    rs.getString("descricao"),
                    rs.getDouble("valor"),
                    rs.getInt("duracao_estimada")
                );

                lista.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }  
    
    
    
}
