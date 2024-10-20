package com.devjulia.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.spi.ToolProvider.findFirst;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Livro adicionado: " + usuario.getNome());
    }

    public Optional<Livro> buscarLivro(String titulo) {
        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    public Optional<Usuario> buscarUsuario(String nome) {
        return usuarios.stream()
                .filter(usuario -> usuario.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public void exibirLivro(String titulo) {
        buscarLivro(titulo).ifPresentOrElse(
                livro -> System.out.println("Livro encontrado: " + livro.getTitulo()),
        () -> System.out.println("Livro não encontrado")
        );
    }

    public void exibirUsuario(String nome) {
        buscarUsuario(nome).ifPresentOrElse(
                usuario -> System.out.println("Usuario encontrado: " + usuario.getNome()),
                () -> System.out.println("Usuario não encontrado")
        );
    }

}
