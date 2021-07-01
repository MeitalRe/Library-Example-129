package com.mr.demo7.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mr.demo7.beans.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByYearBetween(int start, int end);

}
