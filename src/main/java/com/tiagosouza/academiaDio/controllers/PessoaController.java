package com.tiagosouza.academiaDio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagosouza.academiaDio.entites.Pessoa;
import com.tiagosouza.academiaDio.service.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

  @Autowired
  PessoaService pessoaService;

  @GetMapping
  public ResponseEntity<Page<Pessoa>> buscarTodos(Pageable pageable) {
    Page<Pessoa> lista = pessoaService.buscarTodos(pageable);
    return ResponseEntity.ok(lista);

  }

}
