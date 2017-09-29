package com.tr.sigorta.web.controller.repository;

import com.tr.sigorta.domain.Todo;
import com.tr.sigorta.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mustafa Erbin on 06/03/2017.
 */
@RestController
@RequestMapping(value = "repository-todos")
public class RTodoController {
    @Autowired
    private TodoServices todoServices;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> findAll() {
        return todoServices.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Todo create(@RequestBody Todo todo) {
        return todoServices.create(todo);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public Todo delete(@PathVariable("oid") Long id) {
        return todoServices.delete(id);
    }
}
