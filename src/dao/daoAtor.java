/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Ator;


/**
 *
 * @author patrick
 */
public class daoAtor {

    private static List<Ator> atores = new ArrayList();

    public static void gravar(Ator ator) throws SQLException  {
        String sql = "Insert into VIDEOCLUB.ATOR (NOME, PAIS, DATA_NASCIMENTO) values ('" 
                + ator.getNome() + "', '" + ator.getPais() + "', '" 
                + ator.getDataNascimento() + "')";
        new BdDao().executarAtualizacao(sql);
    }

    public static void alterar(Ator ator) throws SQLException {
        String sql = "update ATOR set nome='" + ator.getNome() + "', pais='" + ator.getPais() 
                + "', Data_Nascimento= '" +  ator.getDataNascimento() 
                + "' where id= " + ator.getMatricula().toString();
        new BdDao().executarAtualizacao(sql);
        
    }
    
    public static void excluir(Ator ator) throws SQLException {
        String sql = "delete from Ator where id = " + ator.getMatricula().toString();
        new BdDao().executarAtualizacao(sql);
        
    }

    public static List<Ator> getAtores() throws Exception {
        String sql = "select NOME, PAIS, DATA_NASCIMENTO, ID from ator";
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        
        atores = new ArrayList();
        while (rs.next()) {
            Ator a = new Ator();
            a.setNome(rs.getString("nome"));
            a.setPais(rs.getString("pais"));
            a.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
            a.setMatricula(rs.getInt("id"));
            atores.add(a);
        }
        
        bd.fecharBanco();
        
        return atores;
    }
    
    public static Ator getAtor(Integer id) throws Exception {
        String sql = "select NOME, PAIS, DATA_NASCIMENTO, ID from ator where ID = " + id;

        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        
        Ator a = null;
        while (rs.next()) {
            a = new Ator();

            a.setNome(rs.getString("nome"));
            a.setPais(rs.getString("pais"));
            a.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
            a.setMatricula(rs.getInt("id"));
            
        }
        
        
        
        bd.fecharBanco();

        return a;
    }




}
