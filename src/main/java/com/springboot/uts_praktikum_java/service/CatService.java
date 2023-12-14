package com.springboot.uts_praktikum_java.service;

import com.springboot.uts_praktikum_java.model.Cat;
import com.springboot.uts_praktikum_java.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    @Autowired
    private CatRepository CatRepository;

    public List<Cat> getAllCat() {
        return CatRepository.findAll();
    }

    public Cat getCatById(Long id) {
        return CatRepository.findById(id).orElse(null);
    }

    public Cat createCat(Cat Cat) {
        return CatRepository.save(Cat);
    }

    public Cat updateCat(Long id, Cat newCat) {
        Cat Cat = CatRepository.findById(id).orElse(null);
        if (Cat != null) {
            Cat.setKucing(newCat.getKucing());
            Cat.setGender(newCat.getGender());
            return CatRepository.save(Cat);
        } else {
            return null; // Cat not found
        }
    }

    public void deleteCat(Long id) {
        CatRepository.deleteById(id);
    }
}
