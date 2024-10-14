package com.example.library.controller;


import com.example.library.db.model.Book;
import com.example.library.service.BooksService;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Api(tags = "Library API")
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;

    @ApiOperation(value = "Get all books", response = Book.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of books"),
            @ApiResponse(code = 403, message = "No permissions."),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping
    public List<Book> getBooks() {
        return booksService.getBooks();
    }

    @PostMapping
    @ApiOperation(value = "Create new book", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created book"),
            @ApiResponse(code = 400, message = "Invalid input")
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody @Valid @ApiParam(value = "Book to be created containing all necessary parameters", required = true) Book book) {
        return booksService.addBook(book);
    }
}
