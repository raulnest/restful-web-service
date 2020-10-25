package com.in28minutes.rest.webservices.restfulwebservice.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList();
	private static long idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "abc", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++idCounter, "abc1", "Learn to Code", new Date(), true));
		todos.add(new Todo(++idCounter, "abc2", "Learn to Sing", new Date(), false));
		todos.add(new Todo(++idCounter, "abc3", "Learn Angular", new Date(), true));
		todos.add(new Todo(++idCounter, "abc4", "Learn Springboot", new Date(), false));

	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo findById(long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);

		if (todo == null)
			return null;

		if (todos.remove(todo)) {
			return todo;
		}

		return null;
	}

	/**
	 * 
	 * @param todo
	 * @return
	 */
	public Todo save(Todo todo) {
		if (todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
}
