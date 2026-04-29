/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.dao;

import com.mycompany.barbershopsystemrefatorado.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davi
 */
public class ClienteDAO {
    public boolean inserir(Cliente cliente) {

    String sql = "INSERT INTO cliente (nome, telefone, email, data_cadastro) VALUES (?, ?, ?, NOW())";

    try (
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql)
    ) {

        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getTelefone());
        stmt.setString(3, cliente.getEmail());

        stmt.executeUpdate();
        return true;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }}
    
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try (
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("data_cadastro")
                );
                clientes.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    } 
    
    
    
}
