package com.collector.productservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/api")
public class ProductController {

    private static Long STU_ID = 0L;
    private static String PG_CODE = "";

    @Autowired
    private GameCollectorRepository repo;

    public ProductController() {
    }

    @GetMapping("/getall")
    public ResponseEntity<List<GameCollectorItem>> getAllTutorials() {
        try {
            List<GameCollectorItem> tutorials = new ArrayList<GameCollectorItem>();

//            if (title == null)
                repo.findAll().forEach(tutorials::add);
//            else
//                repo.findByTitleContainingIgnoreCase(title).forEach(tutorials::add);

//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/insert")
//    public ResponseEntity<GameCollectorItem> createTutorial(@RequestBody GameCollectorItem product) {
//        try {
//            GameCollectorItem _product = repo.save(new GameCollectorItem(
//
//                    product.getId(),
//
//                    product.getId(),
//
//                    product.getId(),
//
//                    product.getId(),
//
//                    product.getId(),
//
//                    product.get.getTitle(), product.getDescription(), false));
//            return new ResponseEntity<>(_product, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/profile")
    public void showProfile() {
        System.out.println(repo.findAll());

    }

//        @GetMapping("/profile")
//        public String showProfile(@RequestParam Long studentId, Model model) {
//            Student student = studentRepository.findById(studentId)
//                    .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));
//            model.addAttribute("student", student);
//            return "profile"; // Page to edit personal details
//        }
}
