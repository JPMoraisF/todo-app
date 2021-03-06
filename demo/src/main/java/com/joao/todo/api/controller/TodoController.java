package com.joao.todo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.todo.domain.model.TodoItem;
import com.joao.todo.domain.service.TodoService;

@RestController
@RequestMapping("/todos")
@CrossOrigin("http://localhost:3000")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping
	public ResponseEntity<?> listar() {
		List<TodoItem> todoItem = todoService.listar();
		return ResponseEntity.ok(todoItem);
	}

	@PostMapping
	public ResponseEntity<?> criar() {
		TodoItem todoCreated = todoService.criar();
		return ResponseEntity.ok(todoCreated);
	}

	@PutMapping("/{taskId}")
	public ResponseEntity<?> listar(@PathVariable Integer taskId, @RequestBody TodoItem todoItem) {
		TodoItem updatedItem = todoService.atualizar(taskId, todoItem);
		return ResponseEntity.ok(updatedItem);

	}

	@DeleteMapping("/{taskId}")
	public ResponseEntity<?> remover(@PathVariable Integer taskId) {
		todoService.remover(taskId);
		return ResponseEntity.ok().build();
	}

}
