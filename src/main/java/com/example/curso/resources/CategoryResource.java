package com.example.curso.resources;

import com.example.curso.entities.Category;
import com.example.curso.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private final CategoryService service;

    @Autowired
    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
