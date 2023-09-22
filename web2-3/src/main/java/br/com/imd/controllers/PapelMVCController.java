package br.com.imd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.imd.domain.Papel;
import br.com.imd.repositories.PapelRepository;

@Controller
public class PapelMVCController {

	@GetMapping("/novopapel")
	public String greetingForm(Model model) {
		model.addAttribute("papel", new Papel());
		return "form";
	}
	
	@PostMapping("/novopapel")
	  public String greetingSubmit(@ModelAttribute Papel papel, 
			  Model model) {
		PapelRepository.addPapel(papel);
	    model.addAttribute("papeis", PapelRepository.getPapeis());
	    return "result";
	  }
}
