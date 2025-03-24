package com.adrar.sitecda.service;

import com.adrar.sitecda.model.Category;
import com.adrar.sitecda.model.Produit;
import com.adrar.sitecda.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public void saveProduit(Produit produit) {
        produitRepository.save(produit);
    }

}
