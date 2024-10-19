package com.devjulia.model;

import java.util.Optional;

public class Usuario {

    private String nome;
    private Optional<Livro> livroAlugado;

    public Usuario(String nome) {
        this.nome = nome;
        this.livroAlugado = Optional.empty();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Optional<Livro> getLivroAlugado() {
        return livroAlugado;
    }

    public void setLivroAlugado(Livro livroAlugado) {
        this.livroAlugado = Optional.ofNullable(livroAlugado);
    }

    public void alugarLivro(Livro livro) {
        if (livro.isDisponivel()) {
            livroAlugado = Optional.of(livro);
            livro.setDisponivel(false);
            System.out.println(nome + " alugou o livro: " + livro.getTitulo());
        } else {
            System.out.println("O livro: " + livro.getTitulo() + " não está disponivel.");
        }
    }

    public void devolverLivro() {
        if (livroAlugado.isPresent()) {
        Livro livro = livroAlugado.get();
        livro.setDisponivel(true);
            System.out.println(nome + " devolveu o livro: " + livro.getTitulo());
        livroAlugado = Optional.empty();
        } else {
            System.out.println(nome + "não tem nenhum livro para devolver.");

        }
    }
}
