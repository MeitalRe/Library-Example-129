package com.mr.demo7.conrollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mr.demo7.beans.Author;
import com.mr.demo7.exceptions.LibraryCustomException;
import com.mr.demo7.services.LibraryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("library") // http://localhost:8080/library
@RequiredArgsConstructor
public class LibraryConroller {
	private final LibraryService libraryService;

	@PostMapping("authors") // http://localhost:8080/library/authors
	public ResponseEntity<?> addAuthor(@RequestBody Author author) {
		libraryService.addAuthor(author);
		return new ResponseEntity<>(HttpStatus.CREATED);// 201
	}

	@PutMapping("authors")
	public ResponseEntity<?> updateAuthor(@RequestBody Author author) {
		libraryService.updateAuthor(author);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);// 204
	}

	@GetMapping("authors")
	public ResponseEntity<?> getAllAuthors() {
		return new ResponseEntity<>(libraryService.getAllAuthors(), HttpStatus.OK);
	}

	@GetMapping("books") // http://localhost:8080/library/books
	public ResponseEntity<?> getAllBooks() {
		return new ResponseEntity<>(libraryService.getAllBooks(), HttpStatus.OK);
	}

	@DeleteMapping("authors/{id}")
	public ResponseEntity<?> deleteAuthorById(@PathVariable int id) {
		libraryService.deleteAuthorById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);// 204
	}

	@GetMapping("books/date/between")
	public ResponseEntity<?> getBooksBetween(@RequestParam int start, @RequestParam int end) {
		try {
			return new ResponseEntity<>(libraryService.getAllBetween(start, end), HttpStatus.OK);
		} catch (LibraryCustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
