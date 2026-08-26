package Model;

import static View.Cadastro_GUI.*;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import View.Cadastro_GUI;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Funcoes_DAO {

    static int cod;
    static String nome;
    static String contato;
    static String cpf;

    static String url = "jdbc:mysql://localhost:3307/mercadinho", username = "root", password = "";  // senha do BD

    public static void salvarInformacoes() {
        nome = nome_txt.getText();
        contato = contato_txt.getText();
        cpf = CPF_txt.getText();
        
        Controller.Testa_BD.carregaDriver();
        
        try {
            
            Connection con = null;
            
            try {
                
                con = (Connection) DriverManager.getConnection(url, username, password);
                
            } catch (SQLException ex){
                Logger.getLogger(Cadastro_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "INSERT INTO clientes(NOME, CONTATO, CPF) values('" + nome + "', '" + contato + "','" + cpf + "')";
            
            try {
                
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute();
                
                JOptionPane.showMessageDialog(null, "\nInserção realizada com Sucesso!!!\n", "", -1);
                
                nome_txt.setText("");
                contato_txt.setText("");
                CPF_txt.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "\nErro na Inserção!", "ERRO!", 0);
            } 
            
        } catch (NumberFormatException erro){
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
        }
    }

}
