package com.rudra.springwebapp.bootstrap;

import com.rudra.springwebapp.model.Author;
import com.rudra.springwebapp.model.Book;
import com.rudra.springwebapp.model.Publisher;
import com.rudra.springwebapp.repositories.AuthorRepository;
import com.rudra.springwebapp.repositories.BookRepository;
import com.rudra.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrap started...");

        Publisher p1 = new Publisher();
        p1.setName("name");
        p1.setCity("Kolkata");
        p1.setState("West Bengal");

        publisherRepository.save(p1);
        System.out.println("Publisher count = " + publisherRepository.count());

        Author a1 = new Author("JK", "Rowling");
        Book b1 = new Book("Harry Potter", "454154");

        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);

        b1.setPublisher(p1);
        p1.getBooks().add(b1);

        authorRepository.save(a1);
        bookRepository.save(b1);
        publisherRepository.save(p1);

        System.out.println("Number of books = " + bookRepository.count());
    }
}