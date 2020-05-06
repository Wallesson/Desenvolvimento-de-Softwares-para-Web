package com.ufc.br.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Pessoa;
import com.ufc.br.model.Pratos;
import com.ufc.br.service.PessoaService;
import com.ufc.br.service.PratosService;

@Controller
@RequestMapping("/pessoa")
public class Geral_Controller {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PratosService pratoService;
	

	//-----Geral-------------------------
	@RequestMapping("/principal")
	public ModelAndView Principal(){
		List<Pratos> prato = pratoService.listarPratos();
		ModelAndView mv = new ModelAndView("PaginaPrincipal");
		mv.addObject("listaPratos",prato );
		return mv;
	}
	
	//--------Cadastrar Pessoa----------
	@RequestMapping("/formulario")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("Formulario");
		return mv;
	}
	@RequestMapping("/salvar")
	public ModelAndView salvarPessoa(Pessoa pessoa){
		pessoaService.cadastrar(pessoa);	
		ModelAndView mv = new ModelAndView("redirect:/pessoa/principal");
		return mv;
	}
	//---------Gerente-----------

	@RequestMapping("/salvarp")
	public String salvarPrato(){	
		return "CadastrarPrato";
	}
	@RequestMapping("/salvarpt")
	public ModelAndView salvarPrato(Pratos prato, @RequestParam(value="imagem")MultipartFile imagem){	
		pratoService.cadastrarPrato(prato,imagem);
		ModelAndView mv = new ModelAndView("redirect:/pessoa/salvarp");
		return mv; 
	}
	@RequestMapping("/excluirPrato/{codigo}")
	public ModelAndView excluirPrato(@PathVariable Long codigo){	
		pratoService.excluirPrato(codigo);
		ModelAndView mv = new ModelAndView("redirect:/pessoa/principal");
		return mv;
	}
	//-------------Logar------------------
	@RequestMapping("/logar")
	public ModelAndView loga() {
		ModelAndView mv = new ModelAndView("Login");
		return mv;
	}
	/*@RequestMapping("/excluirPessoa/{codigo}")
	public ModelAndView excluirPessoa(@PathVariable Long codigo){	
		pessoaService.excluirPessoa(codigo);
		ModelAndView mv = new ModelAndView("redirect:/pessoa/principal");
		return mv;
	}*/
}
