package com.collector.productservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private GameCollectorRepository repo;

    public ProductController(GameCollectorRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public ResponseEntity<List<GameCollectorItem>> getAllGameCollectorItems() {
        try {
            List<GameCollectorItem> products = new ArrayList<GameCollectorItem>();
            // TODO
//            if (title == null)
                repo.findAll().forEach(products::add);
//            else
//                repo.findByTitleContainingIgnoreCase(title).forEach(products::add);
//
//            if (products.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }

            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<GameCollectorItem> getGameCollectorItemById(@PathVariable("id") long id) {
        Optional<GameCollectorItem> gameCollectorItemData = repo.findById(id);

        if (gameCollectorItemData.isPresent()) {
            return new ResponseEntity<>(gameCollectorItemData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<GameCollectorItem> createGameCollectorItem(@RequestBody GameCollectorItem item) {
        try {
            // TODO
            GameCollectorItem _gameCollectorItem = repo.save(
                    new GameCollectorItem(item.getName(),
                            item.getPrice()));
            return new ResponseEntity<>(_gameCollectorItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<GameCollectorItem> updateGameCollectorItem(@PathVariable("id") long id, @RequestBody GameCollectorItem gameCollectorItem) {
        Optional<GameCollectorItem> gameCollectorItemData = repo.findById(id);
        if (gameCollectorItemData.isPresent()) {
            GameCollectorItem _gameCollectorItem = gameCollectorItemData.get();
            // TODO
//            _gameCollectorItem.setTitle(gameCollectorItem.getTitle());
//            _gameCollectorItem.setDescription(gameCollectorItem.getDescription());
//            _gameCollectorItem.setPublished(gameCollectorItem.isPublished());
            return new ResponseEntity<>(repo.save(_gameCollectorItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteGameCollectorItem(@PathVariable("id") long id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/products")
    public ResponseEntity<HttpStatus> deleteAllGameCollectorItems() {
        try {
            repo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<GameCollectorItem> findByName(String name) {
        try {
            GameCollectorItem products = repo.findByName(name);
            // TODO
//            if (products.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
