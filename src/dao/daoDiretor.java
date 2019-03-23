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
import model.Diretor;


/**
 *
 * @author patrick
 */
public class daoDiretor {

    private static List<Diretor> diretores = new ArrayList();

    public static void gravar(Diretor diretor) throws SQLException  {
        String sql = "Insert into VIDEOCLUB.Diretor (NOME, PAIS, DATA_NASCIMENTO) values ('" 
                + diretor.getNome() + "', '" + diretor.getPais() + "', '" 
                + diretor.getDataNascimento() + "')";
        new BdDao().executarAtualizacao(sql);
    }

    public static void alterar(Diretor diretor) throws SQLException {
        String sql = "update Diretor set nome='" + diretor.getNome() + "', pais='" + diretor.getPais() 
                + "', Data_Nascimento= '" +  diretor.getDataNascimento() 
                + "' where id= " + diretor.getMatricula().toString();
        new BdDao().executarAtualizacao(sql);
        
    }
    
    public static void excluir(Diretor diretor) throws SQLException {
        //String sql = "delete from SOCIO where id = " + socio.getMatricula() + ";";
        String sql = "delete from Diretor where id = " + diretor.getMatricula().toString();
        new BdDao().executarAtualizacao(sql);
        
    }

    public static List<Diretor> getDiretores() throws Exception {
        String sql = "select NOME, PAIS, DATA_NASCIMENTO, ID from diretor";
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        
        diretores = new ArrayList();
        while (rs.next()) {
            Diretor a = new Diretor();
            a.setNome(rs.getString("nome"));
            a.setPais(rs.getString("pais"));
            a.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
            a.setMatricula(rs.getInt("id"));
            diretores.add(a);
        }
        
        bd.fecharBanco();
        
        return diretores;
        
    }
        
        public static Diretor getDiretor(Integer matricula) throws Exception {
        String sql = "select NOME, PAIS, DATA_NASCIMENTO, ID from diretor where ID = " + matricula;

        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        
        Diretor a = null;
        while (rs.next()) {
            a = new Diretor();

            a.setNome(rs.getString("nome"));
            a.setPais(rs.getString("pais"));
            a.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
            a.setMatricula(rs.getInt("id"));
           
            
        }
        
        bd.fecharBanco();

        return a;
        
        
    }



}
