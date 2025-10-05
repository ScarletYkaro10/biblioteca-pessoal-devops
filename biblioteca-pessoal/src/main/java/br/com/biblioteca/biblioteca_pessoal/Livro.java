package br.com.biblioteca.biblioteca_pessoal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // [cite: 19]

    private String titulo; // [cite: 20]
    private String autor; // [cite: 21]
    private int anoPublicacao; // [cite: 22]
    private boolean lido = false; // [cite: 23]

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public boolean isLido() { return lido; }
    public void setLido(boolean lido) { this.lido = lido; }
}