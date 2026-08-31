package Model;

import View.Cadastro_GUI;
import static View.Cadastro_GUI.*;
import static View.Produtos_GUI.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Funcoes_DAO {

    // Declaração das variáveis estáticas utilizadas pelos métodos da classe
    static int qnt;
    static String nomeProdutos, nome, contato, cpf;
    static double valorUNI, valorFINAL;

    // Configurações de conexão com o banco de dados
    public static String url = "jdbc:mysql://localhost:3306/mercadinho?useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", username = "root", password = "";

    public static void salvarInformacoes() {
        nome = nome_txt.getText();
        contato = contato_txt.getText();
        cpf = CPF_txt.getText();

        Controller.Testa_BD.carregaDriver();

        String sql = "INSERT INTO clientes(NOME, CONTATO, CPF) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement inserir = con.prepareStatement(sql)) {

            inserir.setString(1, nome);
            inserir.setString(2, contato);
            inserir.setString(3, cpf);

            inserir.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserção realizada com Sucesso!!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            nome_txt.setText("");
            contato_txt.setText("");
            CPF_txt.setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Inserção/Conexão: " + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void salvarPedido() {
        int qtdInteger = (Integer) qntdProduto.getValue();
        String qtd = String.valueOf(qtdInteger);
        String nomeP = (String) nomeProduto.getSelectedItem();
        String valorU = valorUNI_txt.getText();
        String valorF = valorFINAL_txt.getText();

        Controller.Testa_BD.carregaDriver();

        String sql = "INSERT INTO compras(nome_produto, qntd_produto, valor_uni, valor_final, forma_pagamento, cpf_cliente, nome_cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement inserir = con.prepareStatement(sql)) {

            inserir.setString(1, nomeP);
            inserir.setString(2, qtd);
            inserir.setString(3, valorU);
            inserir.setString(4, valorF);
            inserir.setString(5, "A definir");
            inserir.setString(6, cpf);
            inserir.setString(7, nome);

            inserir.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserção realizada com Sucesso!!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            valorUNI_txt.setText("");
            valorFINAL_txt.setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Inserção/Conexão: " + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void opcoesPagamentos() {
        String x = JOptionPane.showInputDialog(null, "OPÇÕES DE PAGAMENTO\n\n1 - C. Débito\n2 - C. Crédito\n3 - Pix\n\nDigite a opção que deseja\n(1, 2 ou 3)");
        int op = Integer.valueOf(x);

        JOptionPane.showMessageDialog(null, "Aguardando  pagamento...");
        JOptionPane.showMessageDialog(null, "Pagamento Efetuado!");
        JOptionPane.showMessageDialog(null, "Reiniciando sistema...");
        
        //colocar para excluir do BD
        
        new Cadastro_GUI().setVisible(true);
    }

    public static void calcularPreco() {
        if (nomeProduto.getSelectedItem() == null || qntdProduto.getValue() == null) {
            return;
        }

        qnt = (int) qntdProduto.getValue();
        nomeProdutos = nomeProduto.getSelectedItem().toString();

        if (nomeProdutos.equalsIgnoreCase("Refrigerante")) {
            valorUNI = 15.0;
            valorUNI_txt.setText(String.format("%.2f", valorUNI));
            valorFINAL = qnt * valorUNI;
            valorFINAL_txt.setText(String.format("%.2f", valorFINAL));
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar item à tabela: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
