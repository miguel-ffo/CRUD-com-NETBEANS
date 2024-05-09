/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class conexao {
    private Connection conexao;
    
    public Connection abrirConexao() {
        String url ="jdbc:mysql://localhost:3306/crud?userTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";
        
        try {
            conexao = DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexao;
    }
    
    
    public void fecharConexao(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
