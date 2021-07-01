package com.mr.demo7.clr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mr.demo7.beans.Author;
import com.mr.demo7.beans.Book;
import com.mr.demo7.repos.AuthorRepository;
import com.mr.demo7.services.LibraryService;
import com.mr.demo7.utils.TestUtils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Order(2)
public class LibraryServiceTesting implements CommandLineRunner {
	private final LibraryService libraryService;
	private final AuthorRepository authorRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("LIBRARY SERVICE TESTING");
		TestUtils.testInfo("Add Author");
		Book b1 = Book.builder().name("Spring Core").year(2018).build();
		Book b2 = Book.builder().name("Spring Boot").year(2019).build();
		Author a1 = Author.builder().name("Kobi Shasha").book(b1).book(b2).build();
		libraryService.addAuthor(a1);
		Book b3 = Book.builder().name("React").year(2017).build();
		Book b4 = Book.builder().name("React here and now").year(2018).build();
		Author a2 = Author.builder().name("Shaked").book(b3).book(b4).build();
		libraryService.addAuthor(a2);

		authorRepository.findAll().forEach(System.out::println);
		TestUtils.testInfo("Delete Author By Id");
		libraryService.deleteAuthorById(1);
		authorRepository.findAll().forEach(System.out::println);
		TestUtils.testInfo("Get All Books");
		libraryService.getAllBooks().forEach(System.out::println);
		TestUtils.testInfo("Get All Between- BAD");
		try {
			libraryService.getAllBetween(2020, 2010).forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		TestUtils.testInfo("Get All Between- GOOD");
		libraryService.getAllBetween(2018, 2020).forEach(System.out::println);

	}

}
