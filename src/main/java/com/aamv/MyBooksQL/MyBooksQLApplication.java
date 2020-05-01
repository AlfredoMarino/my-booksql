package com.aamv.MyBooksQL;

import com.aamv.MyBooksQL.model.Author;
import com.aamv.MyBooksQL.service.AuthorService;
import com.google.cloud.firestore.Firestore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class MyBooksQLApplication {

//	@Autowired
	static Firestore firestore;

//	@Autowired
	static AuthorService authorService;

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(MyBooksQLApplication.class, args);

		firestore = (Firestore) context.getBean("firestore");
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));



		authorService = (AuthorService) context.getBean("authorServiceImpl");

//		DocumentReference docRef = firestore.collection("my-books").document(UUID.randomUUID().toString());
//		Map<String, Object> data = new HashMap<>();
//		data.put("first", "Manual");
//		data.put("last", "Manu");
//		data.put("born", 1815);
//		ApiFuture<WriteResult> result = docRef.set(data);
//		System.out.println("Update time : " + result.get().getUpdateTime());

		Author author = new Author();
		author.setId(UUID.randomUUID().toString());
		author.setName("Alfredo Mariño");

		authorService.createAuthor(author);
	}

}
