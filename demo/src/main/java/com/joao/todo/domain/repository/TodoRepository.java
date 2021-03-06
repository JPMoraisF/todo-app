package com.joao.todo.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.joao.todo.domain.model.TodoItem;

@Repository
public class TodoRepository {

	private Integer idCounter = 0;
	private List<TodoItem> todoItems = new ArrayList<>();
	
	public List<TodoItem> listar() {
		return todoItems;
	}
	
	public TodoItem criar() {
		TodoItem todoItem = new TodoItem();
		todoItem.setId(++idCounter);
		todoItem.setDone(false);
		todoItem.setTask("Tarefa #"+todoItem.getId());
		todoItems.add(todoItem);
		return todoItem;
	}

	public void remover(Integer taskId) {
		todoItems = todoItems.stream()
								.filter(todoItem -> !todoItem.getId().equals(taskId))
								.collect(Collectors.toList());
		
	}
	
}
