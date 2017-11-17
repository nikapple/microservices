package org.readingmonitor.books.repository;

import java.util.ArrayList;

import org.readingmonitor.books.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner{

	private BooksRepository booksRepository;
	
	public DbSeeder(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}

	@Override
	public void run(String... arg0) throws Exception {
		this.booksRepository.deleteAll();
		
		Book math = new Book( "Vedic Maths", "Shakuntala", "Math");
		Book english = new Book( "Proper English", "Bala", "English");
		Book englishVinglish = new Book( "BS English", "Lala", "English");
		Book physics = new Book( "Astro Physics", "Shah", "Physics");
		Book chemistry = new Book( "Fing Chem", "Dev", "Chemistry");
		
		this.booksRepository.save(new ArrayList<Book>() {
			private static final long serialVersionUID = 1L;
		{
			add(math);
			add(english);
			add(englishVinglish);
			add(chemistry);
			add(physics);
		}});
	}

}
