package com.projetoifood.Projeto.Ifood.repository;

import com.projetoifood.Projeto.Ifood.model.Cardapio;
import com.projetoifood.Projeto.Ifood.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardapioRepository extends JpaRepository<Cardapio, Integer> {

    List<Cardapio> findTodosByRestaurante(Restaurante restaurante);
}
