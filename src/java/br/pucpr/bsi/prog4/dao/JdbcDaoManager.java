package br.pucpr.bsi.prog4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDaoManager implements IDaoManager 
{
    Connection conexao;
    
    jdbcAtendimentoDAO atendimentoDao;
    jdbcMedicoDAO medicoDao;
    
    public JdbcDaoManager()
    {
        atendimentoDao = new jdbcAtendimentoDAO(conexao);
        medicoDao = new jdbcMedicoDAO(conexao);

    }
    
    
    @Override
    public void iniciar() throws DaoException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/atendimentodb";
            conexao = DriverManager.getConnection(url, "root", "root");
            conexao.setAutoCommit(false);
            atendimentoDao.setConexao(conexao);
            medicoDao.setConexao(conexao);

        }
        catch( Exception ex )
        {
            throw new DaoException("Ocorreu um erro ao conectar ao banco de dados:" + 
                    ex.getMessage());
        }
    }

    @Override
    public void encerrar() 
    {
        try {
            if(!conexao.isClosed())
                conexao.close();
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public void confirmarTransacao() {
        try{
            conexao.commit();            
        }catch(SQLException ex){
            throw new DaoException("Erro" + ex.toString());
        }
        
    }
    @Override
    public void abortarTransacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public IAtendimentoDAO getAtendimentoDao() {
        return atendimentoDao;
    }

    @Override
    public IMedicoDAO getMedicoDao() {
        return medicoDao;
    }


}
