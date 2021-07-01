package com.mr.demo7.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mr.demo7.beans.Author;
import com.mr.demo7.beans.Book;
import com.mr.demo7.exceptions.LibraryCustomException;
import com.mr.demo7.repos.AuthorRepository;
import com.mr.demo7.repos.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibraryService {// service= facade
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public void addAuthor(Author author) {
		authorRepository.save(author);
	}

	public void updateAuthor(Author author) {
		authorRepository.saveAndFlush(author);
	}

	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	public void deleteAuthorById(int id) {
		authorRepository.deleteById(id);
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public List<Book> getAllBetween(int start, int end) throws LibraryCustomException {
		if (start > end) {
			throw new LibraryCustomException("invalid Dates hahaha");
		}
		return bookRepository.findByYearBetween(start, end);
	}

}
