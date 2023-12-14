package com.springboot.uts_praktikum_java.service;

import com.springboot.uts_praktikum_java.model.Produk;
import com.springboot.uts_praktikum_java.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdukService {
    @Autowired
    private ProdukRepository jadwalRepository;

    public List<Produk> getAllJadwal() {
        return jadwalRepository.findAll();
    }

    public Produk getJadwalById(Long id) {
        return jadwalRepository.findById(id).orElse(null);
    }

    public Produk createJadwal(Produk jadwal) {
        return jadwalRepository.save(jadwal);
    }

    public Produk updateJadwal(Long id, Produk newProduk) {
        Produk jadwal = jadwalRepository.findById(id).orElse(null);
        if (jadwal != null) {
            jadwal.setBarang(newProduk.getBarang());
            jadwal.setHarga(newProduk.getHarga());
            return jadwalRepository.save(jadwal);
        } else {
            return null; // Jadwal not found
        }
    }

    public void deleteJadwal(Long id) {
        jadwalRepository.deleteById(id);
    }
}
