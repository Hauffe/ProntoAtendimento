/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.bsi.prog4.models;

/**
 *
 * @author Alexandre
 */
public class Atendimento {
    
    private int id;
    private String Procedimento;
    private String Urgencia;
    private String Situacao;
    private Medico medico;

    public Atendimento(Medico medico) {
        this.medico = medico;
    }

    public Atendimento() {
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcedimento() {
        return Procedimento;
    }

    public void setProcedimento(String Procedimento) {
        this.Procedimento = Procedimento;
    }

    public String getUrgencia() {
        return Urgencia;
    }

    public void setUrgencia(String Urgencia) {
        this.Urgencia = Urgencia;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
 
    
    
}
