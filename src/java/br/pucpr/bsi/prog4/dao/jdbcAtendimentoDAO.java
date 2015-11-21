/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.bsi.prog4.dao;


import br.pucpr.bsi.prog4.models.Atendimento;
import br.pucpr.bsi.prog4.models.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class jdbcAtendimentoDAO implements IAtendimentoDAO{
    
    private Connection conexao;

    public jdbcAtendimentoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    


    @Override
    public List<Atendimento> selecionarPorMedico(Medico medico) {
        List<Atendimento> atendimentos = new ArrayList<Atendimento>();
        String sql = "SELECT * FROM Atendimento "
                + "WHERE "
                + "Medico_id = ? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, medico.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                atendimentos.add(populateObject(rs, medico));
            }
            return atendimentos;
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }    
    }

    @Override
    public Atendimento selecionarPorId(Medico medico, int id) {
        Atendimento atendimento = null;
        String sql = "SELECT * FROM Atendimento "
                + "WHERE "
                + "id = ? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                atendimento = populateObject(rs, medico);
            }
            return atendimento;
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }  
    }


    @Override
    public Atendimento alterar(Atendimento atendimento) {
        String sql = "UPDATE Atendimento "
                + "SET situacao = ? "
                + "WHERE id = ? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, atendimento.getSituacao());
            ps.setInt(2, atendimento.getId());
            rs = ps.executeQuery();
            return atendimento;
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }  
    }
        public Atendimento populateObject(ResultSet rs, Medico medico) throws SQLException{
            Atendimento atendimento = new Atendimento(medico);
            atendimento.setId(rs.getInt("id"));
            atendimento.setProcedimento(rs.getString("procedimento"));
            atendimento.setSituacao(rs.getString("situacao"));
            atendimento.setUrgencia(rs.getString("urgencia"));
            return atendimento;
        }
        
        
    }

