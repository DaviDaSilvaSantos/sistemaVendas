/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author davis
 */
@Entity
@Table(name = "compras", catalog = "mercadinho", schema = "")
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByNomeProduto", query = "SELECT c FROM Compras c WHERE c.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Compras.findByQntdProduto", query = "SELECT c FROM Compras c WHERE c.qntdProduto = :qntdProduto"),
    @NamedQuery(name = "Compras.findByValorUni", query = "SELECT c FROM Compras c WHERE c.valorUni = :valorUni"),
    @NamedQuery(name = "Compras.findByValorFinal", query = "SELECT c FROM Compras c WHERE c.valorFinal = :valorFinal"),
    @NamedQuery(name = "Compras.findByFormaPagamento", query = "SELECT c FROM Compras c WHERE c.formaPagamento = :formaPagamento"),
    @NamedQuery(name = "Compras.findByCpfCliente", query = "SELECT c FROM Compras c WHERE c.cpfCliente = :cpfCliente"),
    @NamedQuery(name = "Compras.findByNomeCliente", query = "SELECT c FROM Compras c WHERE c.nomeCliente = :nomeCliente"),
    @NamedQuery(name = "Compras.findById", query = "SELECT c FROM Compras c WHERE c.id = :id")})
public class Compras implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    @Basic(optional = false)
    @Column(name = "QNTD_PRODUTO")
    private int qntdProduto;
    @Basic(optional = false)
    @Column(name = "VALOR_UNI")
    private float valorUni;
    @Basic(optional = false)
    @Column(name = "VALOR_FINAL")
    private float valorFinal;
    @Basic(optional = false)
    @Column(name = "FORMA_PAGAMENTO")
    private String formaPagamento;
    @Basic(optional = false)
    @Column(name = "CPF_CLIENTE")
    private String cpfCliente;
    @Basic(optional = false)
    @Column(name = "NOME_CLIENTE")
    private String nomeCliente;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public Compras() {
    }

    public Compras(Integer id) {
        this.id = id;
    }

    public Compras(Integer id, String nomeProduto, int qntdProduto, float valorUni, float valorFinal, String formaPagamento, String cpfCliente, String nomeCliente) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.qntdProduto = qntdProduto;
        this.valorUni = valorUni;
        this.valorFinal = valorFinal;
        this.formaPagamento = formaPagamento;
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        String oldNomeProduto = this.nomeProduto;
        this.nomeProduto = nomeProduto;
        changeSupport.firePropertyChange("nomeProduto", oldNomeProduto, nomeProduto);
    }

    public int getQntdProduto() {
        return qntdProduto;
    }

    public void setQntdProduto(int qntdProduto) {
        int oldQntdProduto = this.qntdProduto;
        this.qntdProduto = qntdProduto;
        changeSupport.firePropertyChange("qntdProduto", oldQntdProduto, qntdProduto);
    }

    public float getValorUni() {
        return valorUni;
    }

    public void setValorUni(float valorUni) {
        float oldValorUni = this.valorUni;
        this.valorUni = valorUni;
        changeSupport.firePropertyChange("valorUni", oldValorUni, valorUni);
    }

    public float getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(float valorFinal) {
        float oldValorFinal = this.valorFinal;
        this.valorFinal = valorFinal;
        changeSupport.firePropertyChange("valorFinal", oldValorFinal, valorFinal);
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        String oldFormaPagamento = this.formaPagamento;
        this.formaPagamento = formaPagamento;
        changeSupport.firePropertyChange("formaPagamento", oldFormaPagamento, formaPagamento);
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        String oldCpfCliente = this.cpfCliente;
        this.cpfCliente = cpfCliente;
        changeSupport.firePropertyChange("cpfCliente", oldCpfCliente, cpfCliente);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        String oldNomeCliente = this.nomeCliente;
        this.nomeCliente = nomeCliente;
        changeSupport.firePropertyChange("nomeCliente", oldNomeCliente, nomeCliente);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Compras[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
