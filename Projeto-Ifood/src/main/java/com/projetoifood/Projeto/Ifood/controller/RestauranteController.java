package com.projetoifood.Projeto.Ifood.controller;

import com.projetoifood.Projeto.Ifood.model.Cardapio;
import com.projetoifood.Projeto.Ifood.model.Restaurante;
import com.projetoifood.Projeto.Ifood.repository.CardapioRepository;
import com.projetoifood.Projeto.Ifood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    CardapioRepository cardapioRepository;

    @Autowired
    RestauranteRepository restauranteRepository;

    @GetMapping
    ResponseEntity<List<Restaurante>> getRestaurantes() {
        List<Restaurante> restaurantes = restauranteRepository.findAll();
        return ResponseEntity.ok(restaurantes);
    }

    @PostMapping
    ResponseEntity<Restaurante> cadastroRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante restauranteCadastrado = restauranteRepository.save(restaurante);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequestUri()
                        .path("/{id}")
                        .buildAndExpand(restauranteCadastrado.getId()).toUri())
            .body(restauranteCadastrado);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Restaurante> removerRestaurante(@PathVariable Integer id){
        restauranteRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Restaurante> editarRestaurante(@PathVariable Integer id, @RequestBody Restaurante restaurante) {
        Optional<Restaurante> restauranteQueJaExiste = restauranteRepository.findById(id);
        if (restauranteQueJaExiste.isPresent()) {
            restauranteQueJaExiste.get().setNome(restaurante.getNome());
            restauranteQueJaExiste.get().setEndereco(restaurante.getEndereco());
            restauranteRepository.save(restauranteQueJaExiste.get());

            return ResponseEntity.ok(restauranteQueJaExiste.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{restauranteId}/cardapio")
    ResponseEntity<List<Cardapio>> getByRestaurante(@PathVariable Integer restauranteId) {
        Restaurante restaurante = new Restaurante();
        restaurante.setId(restauranteId);
        return ResponseEntity.ok(cardapioRepository.findTodosByRestaurante(restaurante));
    }
}
