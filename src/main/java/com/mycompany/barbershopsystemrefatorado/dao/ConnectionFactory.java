/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.barbershopsystemrefatorado.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Davi
 */
public class ConnectionFactory {
    
    private static final String URL =
            "jdbc:mysql://localhost:3306/barbershopdata?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root"; // ajuste se necessário
    private static final String PASSWORD = "Kalel2390"; // senha do MySQL

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco", e);
        }
    }   
    
    
    
}
