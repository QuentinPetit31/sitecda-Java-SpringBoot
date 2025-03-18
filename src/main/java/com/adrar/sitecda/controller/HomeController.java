package com.adrar.sitecda.controller;

import com.adrar.sitecda.model.Produit;
import com.adrar.sitecda.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class HomeController {

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("firstname", "Mathieu");
        return "index";
    }

    @GetMapping("/produit")
    public String produit(Model model) {
        Produit produit = new Produit();
        model.addAttribute("produit", produit);
        return "produit";
    }

    @GetMapping("/helloworld/{firstname}")
    public String helloworldFirstname(Model model, @PathVariable String firstname) {
        model.addAttribute("prenom", firstname);
        return "hellofirstname";
    }

    @Autowired
    private ProduitService produitService;

    @GetMapping("/produit/{id}")
    public String getProduitById(@PathVariable Long id, Model model) {
        Optional<Produit> produit = produitService.getProduitById(id);
        if (produit.isPresent()) {
            model.addAttribute("produit", produit.get());
            return "produit";
        } else {
            return "error"; // permet de retourner une erreur si nécessaire
        }
    }
}
