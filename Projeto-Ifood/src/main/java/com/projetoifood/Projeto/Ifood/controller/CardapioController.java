package com.projetoifood.Projeto.Ifood.controller;

import com.projetoifood.Projeto.Ifood.model.Cardapio;
import com.projetoifood.Projeto.Ifood.model.Restaurante;
import com.projetoifood.Projeto.Ifood.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/cardapios")
public class CardapioController {


    @Autowired
    CardapioRepository cardapioRepository;

    @PostMapping
    ResponseEntity<Cardapio> cadastroCardapio(@RequestBody Cardapio cardapio) {
        Cardapio cadastradoCardapio = cardapioRepository.save(cardapio);
        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequestUri()
                                .path("/{id}")
                                .buildAndExpand(cadastradoCardapio.getId()).toUri())
                .body(cadastradoCardapio);
    }
}
