package guru.springframework.spring5Webapp.bootstrap;

import guru.springframework.spring5Webapp.model.Author;
import guru.springframework.spring5Webapp.model.Book;
import guru.springframework.spring5Webapp.model.Publisher;
import guru.springframework.spring5Webapp.repositories.AuthorRepository;
import guru.springframework.spring5Webapp.repositories.BookRepository;
import guru.springframework.spring5Webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component

public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher HaCo = new Publisher("Harper Collins", "London");
        Book ddd = new Book("Domain Driven Design", "1234", HaCo);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisherRepository.save(HaCo);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "New York");
        Book neEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(neEJB);
        publisherRepository.save(worx);
        authorRepository.save(rod);
        bookRepository.save(neEJB);
    }
}
