package com.springboot.uts_praktikum_java.controller;

import com.springboot.uts_praktikum_java.model.Cat;
import com.springboot.uts_praktikum_java.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kucing")
public class CatatanController {
    @Autowired
    private CatRepository CatRepository;

    // Get all Cat
    @GetMapping("getAll")
    public List<Cat> getAllCat() {
        return CatRepository.findAll();
    }

    // Get Cat by id
    @GetMapping("/get/{id}")
    public Cat getCatById(@PathVariable Long id) {
        return CatRepository.findById(id).orElse(null);
    }

    // Create a new Cat
    @PostMapping("/post")
    public Cat createCat(@RequestBody Cat Cat) {
        return CatRepository.save(Cat);
    }

    // Update Cat
    @PutMapping("/put/{id}")
    public Cat updateCat(@PathVariable Long id, @RequestBody Cat newCat) {
        Cat Cat = CatRepository.findById(id).orElse(null);
        if (Cat != null) {
            Cat.setKucing(newCat.getKucing());
            Cat.setGender(newCat.getGender());
            // Set other properties as needed
            return CatRepository.save(Cat);
        } else {
            return null; // Cat not found
        }
    }

    // Delete Cat
    @DeleteMapping("/delete/{id}")
    public void deleteCat(@PathVariable Long id) {
        CatRepository.deleteById(id);
    }
}
