/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.bsi.prog4.dao;

import br.pucpr.bsi.prog4.models.Atendimento;
import br.pucpr.bsi.prog4.models.Medico;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public interface IAtendimentoDAO {
    
    public List<Atendimento> selecionarPorMedico(Medico medico);
    public Atendimento selecionarPorId(Medico medico, int id);
    public Atendimento alterar(Atendimento atendimento);
 
}
