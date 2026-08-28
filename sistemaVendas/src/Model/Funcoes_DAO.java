package Model;

import static View.Cadastro_GUI.*;
import static View.Produtos_GUI.*;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import View.Cadastro_GUI;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Funcoes_DAO {

    static int cod, qnt;
    static String nome, contato, cpf, nomeProdutos;
    static double valorUNI, valorFINAL;

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

            } catch (SQLException ex) {
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

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(null, "Algo deu errado!");
        }
    }

    public static void calcularPreco() {
        qnt = (int) qntdProduto.getValue();
        nomeProdutos = nomeProduto.getSelectedItem().toString();

        if (nomeProdutos.equals("Refrigerante")) {
            valorUNI = 15.0;
            valorUNI_txt.setText("15.00");
            valorFINAL = qnt * 15.0;
            String vFinal = String.valueOf(valorFINAL);
            valorFINAL_txt.setText(vFinal);
        }
    }

    public static void adicionarLista() {
        try {
            DefaultTableModel modeloTabela = (DefaultTableModel) listaCompras.getModel();
            modeloTabela.addRow(new Object[]{
                qnt,
                nomeProdutos,
                valorUNI,
                valorFINAL
            });
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

}
