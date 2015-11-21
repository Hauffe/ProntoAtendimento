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
public class jdbcMedicoDAO implements IMedicoDAO{

    private Connection conexao;

    public jdbcMedicoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public List<Medico> selecionarTodos() {
        List<Medico> medicos = new ArrayList<Medico>();
        String sql = "SELECT * FROM medico ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                medicos.add(populateObject(rs));
            }
            return medicos;
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }  
    }

    @Override
    public Medico selecionarPorId(int id) {
        Medico medico = null;
        String sql = "SELECT * FROM medico "
                + "WHERE "
                + "id = ? ";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                medico = populateObject(rs);
            }
            return medico;
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }  
    }
    
    
    public Medico populateObject(ResultSet rs) throws SQLException{
        Medico medico = new Medico();
        medico.setId(rs.getInt("id"));
        medico.setEspecialidade(rs.getString("especialidade"));
        medico.setNome(rs.getString("nome"));
        //Arrumar
        medico.setAtendimentos(null);
        return medico;
    }
        
}
