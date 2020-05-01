package com.aamv.MyBooksQL;

import com.aamv.MyBooksQL.model.Author;
import com.aamv.MyBooksQL.model.Book;
import com.aamv.MyBooksQL.service.AuthorService;
import com.aamv.MyBooksQL.service.BookService;
import com.google.cloud.firestore.Firestore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class MyBooksQLApplication {

//	@Autowired
	static Firestore firestore;

//	@Autowired
	static AuthorService authorService;
	static BookService bookService;

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(MyBooksQLApplication.class, args);

		firestore = (Firestore) context.getBean("firestore");
		authorService = (AuthorService) context.getBean("authorServiceImpl");
		bookService = (BookService) context.getBean("bookServiceImpl");

		Author author = new Author();
		author.setId(UUID.randomUUID().toString());
		author.setName("Alfredo Mariño");

		Author newAuthor = authorService.createAuthor(author);


		Book book = new Book();
		book.setId(UUID.randomUUID().toString());
		book.setTitle("Libro 1");

		List<Author> authorList = new ArrayList<>();
		authorList.add(newAuthor);
		book.setAuthors(authorList);

		bookService.createBook(book);


	}

}
