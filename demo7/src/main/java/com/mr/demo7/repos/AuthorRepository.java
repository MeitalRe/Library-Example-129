package com.mr.demo7.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mr.demo7.beans.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
