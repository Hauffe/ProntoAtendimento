/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.bsi.prog4.controllers;

import br.pucpr.bsi.prog4.models.Atendimento;
import br.pucpr.bsi.prog4.models.Medico;
import br.pucpr.bsi.prog4.models.repositorio.AtendimentoMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alexandre
 */
@Controller
public class AtendimentoController {
    @Autowired
    AtendimentoMng repositorio;
    
    @RequestMapping("/")
    public ModelAndView Home(){
        ModelAndView mav;
        mav = new ModelAndView("index");
        return mav;
    }
    

    @RequestMapping("/atendimentos")
    public String obterAtendimentos(@RequestParam int medicoId, Model model){
      Medico medico = repositorio.selecionarMedicoPorId(medicoId);
      model.addAttribute("atendimentos", repositorio.selecionarPorMedico(medico));
      return "atendimentos-detalhe";
    }
    
    @RequestMapping(value = "/consulta",
                method = RequestMethod.GET)
    public String alterarAtendimento(@RequestParam int medicoId, @RequestParam int atendimentoId, Model model){
        Medico medico = repositorio.selecionarMedicoPorId(medicoId);
        model.addAttribute("alterarAtendimento", repositorio.selecionarPorId(medico, atendimentoId));
        return "atendimento-detalhe";
    }
    
    @RequestMapping(value = "/consulta",
            method = RequestMethod.POST)
    public String alterarAtendimento(@ModelAttribute("alterarAtendimento")Atendimento atendimento){
        repositorio.alterarAtendimento(atendimento);
        return "redirect:/consulta";
    }
}
