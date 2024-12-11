package com.example.Server.Services;

import com.example.Server.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ServerApi {

    @Autowired
    private FileService fileService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return fileService.getAllBooks();
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return fileService.getAllEmployees();
    }

    @GetMapping("/readers")
    public List<Reader> getReaders() {
        return fileService.getAllReaders();
    }

    @PostMapping("/books")
    public void saveBooks(@RequestBody List<Book> books) {
        fileService.saveBooks(books);
    }

    @PostMapping("/employees")
    public void saveEmployees(@RequestBody List<Employee> employees) {
        fileService.saveEmployees(employees);
    }

    @PostMapping("/readers")
    public void saveReaders(@RequestBody List<Reader> readers) {
        fileService.saveReaders(readers);
    }
}
