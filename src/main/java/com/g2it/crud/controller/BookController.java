package com.g2it.crud.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2it.crud.model.manytoone.Author;
import com.g2it.crud.model.manytoone.Book;
import com.g2it.crud.repository.AuthorRepository;
import com.g2it.crud.repository.BookRepository;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping("/books")
	@Transactional
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PostMapping("/author")
	@Transactional
	public Author createAuthor(@RequestBody Author author) {
		return authorRepository.save(author);
	}
}
