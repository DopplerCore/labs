package com.example.Server.Services;

import com.example.Server.Models.Book;
import com.example.Server.Models.Employee;
import com.example.Server.Models.Reader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String booksFile = "src/main/resources/data/books.txt";
    private final String employeesFile = "src/main/resources/data/employees.txt";
    private final String readersFile = "src/main/resources/data/readers.txt";

    public List<Book> getAllBooks() {
        return readFile(booksFile,Book.class);
    }

    public List<Employee> getAllEmployees() {
        return readFile(employeesFile,Employee.class);
    }

    public List<Reader> getAllReaders() {
        return readFile(readersFile,Reader.class);
    }

    public void saveBooks(List<Book> books) {
        writeFile(booksFile, books);
    }

    public void saveEmployees(List<Employee> employees) {
        writeFile(employeesFile, employees);
    }

    public void saveReaders(List<Reader> readers) {
        writeFile(readersFile, readers);
    }

    private <T> List<T> readFile(String filePath, Class<T> tClass) {
        List<T> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                T item = tClass.getConstructor(String.class).newInstance(line);
                result.add(item);
            }
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    private <T> void writeFile(String filePath, List<T> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (T item : data) {
                String line = item.toString();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
