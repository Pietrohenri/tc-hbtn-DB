package entities;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "nome", nullable = false)
    String nome;
    @Column(name = "quantidade", nullable = false)
    Integer quantidade;
    @Column(name = "preco", nullable = false)
    double preco;
    @Column(name = "status", nullable = false)
    Boolean status;

    public Produto() {
    }


    public Produto(Integer id, String nome, Integer quantidade, double preco, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


}
