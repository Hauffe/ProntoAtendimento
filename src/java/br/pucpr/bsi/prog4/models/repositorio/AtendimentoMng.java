/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.bsi.prog4.models.repositorio;


import br.pucpr.bsi.prog4.dao.IDaoManager;
import br.pucpr.bsi.prog4.models.Atendimento;
import br.pucpr.bsi.prog4.models.Medico;
import br.pucpr.bsi.prog4.dao.JdbcDaoManager;
import br.pucpr.bsi.prog4.dao.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexandre
 */
@Repository
public class AtendimentoMng implements IAtendimentoMng{

    IDaoManager maneger = new JdbcDaoManager();
    

    @Override
    public List<Atendimento> selecionarPorMedico(Medico medico) {
        List<Atendimento> atendimentos;
        
        try {
            maneger.iniciar();
            IAtendimentoDAO dao = maneger.getAtendimentoDao();
            atendimentos = dao.selecionarPorMedico(medico);
            maneger.confirmarTransacao();
            return atendimentos;
        } catch (Exception e) {
            maneger.abortarTransacao();
            throw e;
        }
    }

    @Override
    public Atendimento selecionarPorId(Medico medico, int id) {
        Atendimento atendimento;
        try {
            maneger.iniciar();
            IAtendimentoDAO dao = maneger.getAtendimentoDao();
            atendimento = dao.selecionarPorId(medico, id);
            maneger.confirmarTransacao();
            return atendimento;
        } catch (Exception e) {
            maneger.abortarTransacao();
            throw e;
        }
    }

    @Override
    public List<Medico> selecionarMedico() {
        List<Medico> medicos;
        try {
            maneger.iniciar();
            IMedicoDAO dao = maneger.getMedicoDao();
            medicos = dao.selecionarTodos();
            maneger.confirmarTransacao();
            return medicos;
        } catch (Exception e) {
            maneger.abortarTransacao();
            throw e;
        }
    }

    @Override
    public Medico selecionarMedicoPorId(int id) {
        Medico medico;
        try {
            maneger.iniciar();
            IMedicoDAO dao = maneger.getMedicoDao();
            medico = dao.selecionarPorId(id);
            maneger.confirmarTransacao();
            return medico;
        } catch (Exception e) {
            maneger.abortarTransacao();
            throw e;
        }
    }

    @Override
    public Atendimento alterarAtendimento(Atendimento atendimento) {
        try {
            maneger.iniciar();
            IAtendimentoDAO dao = maneger.getAtendimentoDao();
            dao.alterar(atendimento);
            maneger.confirmarTransacao();
            return atendimento;
        } catch (Exception e) {
            maneger.abortarTransacao();
            throw e;
        }
    }
}
