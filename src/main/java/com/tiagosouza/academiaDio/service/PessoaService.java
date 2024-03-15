package com.tiagosouza.academiaDio.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tiagosouza.academiaDio.entites.Pessoa;
import com.tiagosouza.academiaDio.repositorys.PessoaRepository;
import com.tiagosouza.academiaDio.service.exceptions.PessoaNaoEcontrada;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {

  @Autowired
  PessoaRepository pessoaRepository;

  @Transactional
  public Page<Pessoa> buscarTodos(Pageable pageable) {
    return pessoaRepository.findAll(pageable);
  }

  @Transactional
  public Pessoa buscarPorId(Long id) {
    return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEcontrada("Pessoa não encontrada no sistema"));
  }

  public Pessoa cadastrar(Pessoa pessoa) {
    return pessoaRepository.save(pessoa);
  }

  public Pessoa atualizar(Long id, Pessoa pessoa) {
    Pessoa pessoaAtualizar = this.buscarPorId(id);
    BeanUtils.copyProperties(pessoa, pessoaAtualizar, "id");
    return pessoaRepository.save(pessoaAtualizar);
  }

  public void delete(Long id) {
    this.buscarPorId(id);
    pessoaRepository.deleteById(id);
  }

}
