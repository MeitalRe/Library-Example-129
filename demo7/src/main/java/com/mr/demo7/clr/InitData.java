package com.mr.demo7.clr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mr.demo7.beans.Author;
import com.mr.demo7.beans.Book;
import com.mr.demo7.repos.AuthorRepository;
import com.mr.demo7.repos.BookRepository;
import com.mr.demo7.utils.TestUtils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Order(1)
public class InitData implements CommandLineRunner {
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("INIT DATA");
		Book b1=  Book.builder().name("Galilo: And The Science Deniers").year(2020).build();
		Book b2=  Book.builder().name("Is God a mathematicain").year(2009).build();
		Author a1= Author.builder().name("Mario Livio").book(b1).book(b2).build();
		TestUtils.testInfo("add author within books");
		authorRepository.save(a1);
		
		authorRepository.findAll().forEach(System.out::println);
		
		
		

	}

}
