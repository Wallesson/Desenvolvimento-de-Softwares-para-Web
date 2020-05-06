package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.ufc.br.model.Pessoa;
import com.ufc.br.model.Pratos;
import com.ufc.br.repository.PessoaRepository;
import com.ufc.br.util.AulaFileUtils;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	public List<Pessoa> listarPessoa(){
		return pessoaRepository.findAll();
	}
	
	public void cadastrar(Pessoa pessoa) {
		
		pessoa.setSenha(new BCryptPasswordEncoder().encode(pessoa.getSenha()));
		pessoaRepository.save(pessoa);
	
	}
	public void excluirPessoa(Long codigo) {
		pessoaRepository.deleteById(codigo);
	}
}
