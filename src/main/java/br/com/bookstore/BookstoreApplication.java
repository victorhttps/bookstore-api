package br.com.bookstore;

import br.com.bookstore.entities.Categoria;
import br.com.bookstore.entities.Livro;
import br.com.bookstore.repositories.CategoriaRepository;
import br.com.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat2 = new Categoria("Teror", "Livro de Terror");
        Categoria cat1 = new Categoria("Ti", "Livro de Terror");

        Livro livro = new Livro();
        livro.setTitulo("O iluminado");
        livro.setCategoria(cat2);
        livro.setAutor("Stephen King");
        livro.setTexto("Sinopse");

        cat2.getLivros().addAll(Arrays.asList(livro));
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

        livroRepository.save(livro);
    }
}
