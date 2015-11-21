package br.pucpr.bsi.prog4.dao;

public interface IDaoManager 
{
    void iniciar();
    void encerrar();
    void confirmarTransacao();
    void abortarTransacao();
    
    IAtendimentoDAO getAtendimentoDao();
    IMedicoDAO getMedicoDao();

}
