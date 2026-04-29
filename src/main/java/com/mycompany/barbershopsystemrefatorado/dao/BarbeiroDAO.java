/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.dao;

import com.mycompany.barbershopsystem.model.Barbeiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BarbeiroDAO {

    // 🔹 CADASTRAR
    public void cadastrar(Barbeiro b) {

        String sql = "INSERT INTO barbeiro (nome, telefone, especialidade) VALUES (?, ?, ?)";

        try (
            Connection con = com.mycompany.barbershopsystem.dao.ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)
        ) {

            stmt.setString(1, b.getNome());
            stmt.setString(2, b.getTelefone());
            stmt.setString(3, b.getEspecialidade());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 LISTAR (usado depois em ComboBox)
    public List<Barbeiro> listarTodos() {
        List<Barbeiro> barbeiros = new ArrayList<>();

        String sql = "SELECT * FROM barbeiro";

        try (
            Connection con = com.mycompany.barbershopsystem.dao.ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {
                Barbeiro b = new Barbeiro(
                    rs.getInt("id_barbeiro"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("especialidade")
                );
                barbeiros.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return barbeiros;
    }
    
    
}
