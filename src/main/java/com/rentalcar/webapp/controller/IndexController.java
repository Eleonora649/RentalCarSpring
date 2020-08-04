package com.rentalcar.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController 
{
	@RequestMapping(value="index") //mappiamo la chiamata gestita dal controller
	public String getWelcome(Model model)
	{
		model.addAttribute("intestazione", "Benvenuti nel sito");
		model.addAttribute("saluti", "Seleziona");
		
		return "index"; //nome della pagina jsp che il nostro metodo adrà a restituire
	}
	
	@RequestMapping(value="/") 
	public String getWelcome2(Model model)
	{
		model.addAttribute("intestazione", "Benvenuti nel sito");
		model.addAttribute("saluti", "Seleziona");
		
		return "index"; //nome della pagina jsp che il nostro metodo adrà a restituire
	}
}
