package com.tr.sigorta.web.controller.dao;

import com.tr.sigorta.dao.TodoItemDao;
import com.tr.sigorta.domain.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@RestController
@RequestMapping(value = "dao-todo-items")
@Transactional
public class DTodoItemController {
    @Autowired
    private TodoItemDao todoItemDao;

    @RequestMapping(method = RequestMethod.POST)
    public TodoItem create(@RequestBody TodoItem todoItem) {
        return todoItemDao.create(todoItem);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public TodoItem delete(@PathVariable("oid") Long id) {
        return todoItemDao.delete(id);
    }
}
