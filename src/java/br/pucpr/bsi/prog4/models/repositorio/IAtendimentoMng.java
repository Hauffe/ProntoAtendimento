/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.bsi.prog4.models.repositorio;

import br.pucpr.bsi.prog4.models.Atendimento;
import br.pucpr.bsi.prog4.models.Medico;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public interface IAtendimentoMng {
    
    List<Atendimento> selecionarPorMedico(Medico medico);
    Atendimento selecionarPorId(Medico medico, int id);
    List<Medico> selecionarMedico();
    Medico selecionarMedicoPorId(int id);
    Atendimento alterarAtendimento(Atendimento atendimento);
}
