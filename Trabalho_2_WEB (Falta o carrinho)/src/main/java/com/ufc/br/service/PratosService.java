package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.br.model.Pratos;
import com.ufc.br.repository.PratoRepository;
import com.ufc.br.util.AulaFileUtils;


@Service
public class PratosService {
	@Autowired
	private PratoRepository pratoRepository;
	
	public List<Pratos> listarPratos(){
		return pratoRepository.findAll();
	}

	
	public void cadastrarPrato(Pratos prato, MultipartFile imagem) {
		String caminho = "images/" + prato.getNomePrato() + ".png";
		AulaFileUtils.salvarImagem(caminho,imagem);
		pratoRepository.save(prato);
	}


	public void excluirPrato(Long codigo) {
		pratoRepository.deleteById(codigo);
	}
}
