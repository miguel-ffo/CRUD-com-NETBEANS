/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;



import java.util.ArrayList;
import modelo.produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author pc
 */
public class jdbc {
    
    Connection conexao;

    public jdbc(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void inserirProduto(produto p) {
        
        String sql = "insert into produto (nome,valor,quantidade) values (? ,?,?)";
        PreparedStatement ps;
        
        try {
           ps = this.conexao.prepareStatement(sql);    
           ps.setString(1,p.getNome());
           ps.setInt(2, p.getValor());
           ps.setInt(3,p.getQuantidade());
           ps.execute();
           
           
        } catch(SQLException e) {
             e.printStackTrace();
        }
    }

    
    
    public ArrayList<produto> listarProdutos() {
        ArrayList<produto> produtos = new ArrayList<produto>();
        
        String sql = "select * from produto";
        
        
        try {
            
            Statement declaracao = conexao.createStatement();
            ResultSet resposta = declaracao.executeQuery(sql);
            
            
            while(resposta.next()) {
                
                int id = resposta.getInt("id");
                String nome = resposta.getString("nome");
                int valor = resposta.getInt("valor");
                int quantidade = resposta.getInt("quantidade");
                
                produto p = new produto(id,nome,valor,quantidade);
                produtos.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return produtos;
    }

    
    public void apagarTudo() {
        String sql = "delete from produto";
        PreparedStatement ps;
        
        try{
            
            ps = this.conexao.prepareStatement(sql);
            ps.execute();
            
        }catch(SQLException e) {
            
            e.printStackTrace();
            
        }
        
    }
    
}
