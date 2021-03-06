package com.joao.todo.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.todo.domain.model.TodoItem;
import com.joao.todo.domain.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;

	public List<TodoItem> listar() {
		return todoRepository.listar();
	}

	public TodoItem criar() {
		return todoRepository.criar(); 
	}

	public TodoItem atualizar(Integer taskId, TodoItem todoItem) {
		Optional<TodoItem> todo = todoRepository.listar()
												.stream()
												.filter(item -> item.getId().equals(taskId))
												.findAny();
		if(todo.isPresent()) {
			TodoItem item = todo.get();
			item.setDone(todoItem.isDone());
			item.setTask(todoItem.getTask());
			return item;
		}
		return null;
	}

	public void remover(Integer taskId) {
		todoRepository.remover(taskId);
		
	}

}
