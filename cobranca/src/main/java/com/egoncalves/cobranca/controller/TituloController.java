/**
 * 
 */
package com.egoncalves.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.egoncalves.cobranca.model.StatusTitulo;
import com.egoncalves.cobranca.model.Titulo;
import com.egoncalves.cobranca.repository.TitulosRepository;
import com.egoncalves.cobranca.repository.filter.TituloFilter;
import com.egoncalves.cobranca.service.TituloService;

/**
 * @author Esmael
 *
 */
@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	private static final String CADASTRO_VIEW = "CadastroTitulo";
	@Autowired
	private TitulosRepository titulos;
	@Autowired
	private TituloService tituloService;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Titulo());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {		
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		try {
			tituloService.salvar(titulo);
			attributes.addFlashAttribute("mensagem", "Titulo salvo com sucesso!");
			return "redirect:/titulos/novo";
		} catch(IllegalArgumentException e) {
			errors.rejectValue("dataVencimento", null, e.getMessage());
			return CADASTRO_VIEW;
		}
	}
	
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") TituloFilter filtro){
		List<Titulo> todosTitulos = tituloService.filtrar(filtro);
		
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Titulo titulo) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		tituloService.excluir(codigo);
		
		attributes.addFlashAttribute("mensagem", "Titulo excluído com sucesso!");

		return "redirect:/titulos";
	}
	
	@RequestMapping(value = "/{codigo}/receber", method = RequestMethod.PUT)
	public @ResponseBody String receber(@PathVariable Long codigo) {
		return tituloService.receber(codigo);
	}
	
	
	@ModelAttribute(name = "todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
}
