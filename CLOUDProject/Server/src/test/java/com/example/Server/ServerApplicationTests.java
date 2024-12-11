package com.example.Server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.Server.Services.FileService;

@SpringBootTest
class ServerApplicationTests {
	private FileService fileService = new FileService();
	@Test
	void fileRead() {
		System.out.println(fileService.getAllBooks());
		System.out.println(fileService.getAllEmployees());
		System.out.println(fileService.getAllReaders());
	}

}
