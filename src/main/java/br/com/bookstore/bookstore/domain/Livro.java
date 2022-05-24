package br.com.bookstore.bookstore.domain;

import lombok.Data;

@Data
public class Livro {

    private Integer id;
    private String titulo;
    private String autor;
    private String texto;

    private Categoria categoria;

}
