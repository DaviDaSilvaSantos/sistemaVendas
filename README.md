# 🛒 Sistema de Vendas e Gerenciamento - Mercadinho

Este é um sistema desktop para gerenciamento de clientes e emissão de notas fiscais de compras para um **Mercadinho**, desenvolvido em **Java** utilizando a arquitetura **MVC (Model-View-Controller)** e integrado a um banco de dados relacional.

---

## 📋 Sumário

- [Sobre o Projeto](#-sobre-o-projeto)
- [🏛️ Arquitetura MVC](#️-arquitetura-mvc)
- [📌 Requisitos](#-requisitos)
  - [Requisitos Funcionais (RF)](#requisitos-funcionais-rf)
  - [Requisitos Não Funcionais (RNF)](#requisitos-não-funcionais-rnf)
- [🗄️ Banco de Dados](#️-banco-de-dados)
- [🛠️ Tecnologias Utilizadas](#️-tecnologias-utilizadas)
- [📂 Estrutura de Pastas Sugerida](#-estrutura-de-pastas-sugerida)
- [🚀 Como Executar o Projeto](#-como-executar-o-projeto)

---

## 📖 Sobre o Projeto

O projeto visa automatizar e simplificar o registro de clientes e o processamento de vendas de um mercadinho. A aplicação permite cadastrar dados dos clientes, registrar produtos e quantidades adquiridas, calcular valores finais e selecionar a forma de pagamento desejada.

---

## 🏛️ Arquitetura MVC

O projeto segue o padrão de arquitetura **MVC (Model-View-Controller)** para garantir a separação de responsabilidades, facilitando a manutenção e a escalabilidade do código:

* **Model (Modelo)**: Contém as classes que representam as entidades de dados (`Cliente`, `Compra`) e as classes DAO (*Data Access Object*) para comunicação com o banco de dados via JDBC.
* **View (Visão)**: Responsável pela interface gráfica interativa (GUI) com o usuário, exibindo campos para cadastro, seleção de pagamento e emissão da nota fiscal.
* **Controller (Controlador)**: Intermedia as ações realizadas pelo usuário na *View* e executa as regras de negócio e persistência no *Model*.

---

## 📌 Requisitos

### Requisitos Funcionais (RF)

- **RF01 - Dados do Cliente**: O sistema deve permitir o cadastro de clientes armazenando **Nome**, **Contato** e **CPF**.
- **RF02 - Nota Fiscal**: O sistema deve registrar e exibir na nota fiscal o **Nome dos Produtos**, **Quantidade**, **Valor Individual** e calcular o **Valor Final**[cite: 6].
- **RF03 - Formas de Pagamento**: O sistema deve permitir a escolha entre as formas de pagamento: **Cartão de Débito**, **Cartão de Crédito**, **Dinheiro** e **Pix**[cite: 6].

### Requisitos Não Funcionais (RNF)[cite: 6]

- **RNF01 - Interface Gráfica**: A interface deve ser **autoexplicativa**, intuitiva e amigável para os operadores do sistema[cite: 6].

---

## 🗄️ Banco de Dados[cite: 6]

O banco de dados relacional é nomeado `MERCADINHO` e conta com duas tabelas principais (`CLIENTES` e `COMPRAS`)[cite: 6]:

### Tabela `CLIENTES`[cite: 6]
* `NOME` (VARCHAR 255)[cite: 6]
* `CONTATO` (VARCHAR 25)[cite: 6]
* `CPF` (VARCHAR 14) — *Primary Key*[cite: 6]

### Tabela `COMPRAS`[cite: 6]
* `NOME_PRODUTO` (VARCHAR 255)[cite: 6]
* `QNTD_PRODUTO` (INTEGER)[cite: 6]
* `VALOR_UNI` (FLOAT)[cite: 6]
* `VALOR_FINAL` (FLOAT)[cite: 6]
* `FORMA_PAGAMENTO` (VARCHAR 25)[cite: 6]
* `CPF_CLIENTE` (VARCHAR 14) — *Foreign Key que referencia CLIENTES(CPF)*[cite: 6]
* `NOME_CLIENTE` (VARCHAR 255)[cite: 6]

### Script SQL para Criação do Banco[cite: 6]

```sql
CREATE DATABASE MERCADINHO;

USE MERCADINHO;

-- Tabela de Clientes
CREATE TABLE CLIENTES (
    NOME VARCHAR(255) NOT NULL,
    CONTATO VARCHAR(25) NOT NULL,
    CPF VARCHAR(14) NOT NULL,
    PRIMARY KEY(CPF)
);

-- Tabela de Compras / Vendas
CREATE TABLE COMPRAS (
    NOME_PRODUTO VARCHAR(255) NOT NULL,
    QNTD_PRODUTO INTEGER NOT NULL,
    VALOR_UNI FLOAT NOT NULL,
    VALOR_FINAL FLOAT NOT NULL,
    FORMA_PAGAMENTO VARCHAR(25) NOT NULL,
    CPF_CLIENTE VARCHAR(14) NOT NULL,
    NOME_CLIENTE VARCHAR(255) NOT NULL,
    FOREIGN KEY(CPF_CLIENTE) REFERENCES CLIENTES(CPF)
);
