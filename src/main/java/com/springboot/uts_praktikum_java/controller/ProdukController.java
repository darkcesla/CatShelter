package com.springboot.uts_praktikum_java.controller;

import com.springboot.uts_praktikum_java.model.Produk;
import com.springboot.uts_praktikum_java.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produk")
public class ProdukController {
    @Autowired
    private ProdukRepository ProdukRepository;

    // Get all Produk
    @GetMapping("/getAll")
    public List<Produk> getAllProduk() {
        return ProdukRepository.findAll();
    }

    // Get Produk by id
    @GetMapping("/get/{id}")
    public Produk getProdukById(@PathVariable Long id) {
        return ProdukRepository.findById(id).orElse(null);
    }

    // Create a new Produk
    @PostMapping("/post")
    public Produk createProduk(@RequestBody Produk Produk) {
        return ProdukRepository.save(Produk);
    }

    // Update Produk
    @PutMapping("/put/{id}")
    public Produk updateProduk(@PathVariable Long id, @RequestBody Produk newProduk) {
        Produk Produk = ProdukRepository.findById(id).orElse(null);
        if (Produk != null) {
            Produk.setBarang(newProduk.getBarang());
            Produk.setHarga(newProduk.getHarga());
            return ProdukRepository.save(Produk);
        } else {
            return null;
        }
    }

    // Delete Produk
    @DeleteMapping("/delete/{id}")
    public void deleteProduk(@PathVariable Long id) {
        ProdukRepository.deleteById(id);
    }
}
