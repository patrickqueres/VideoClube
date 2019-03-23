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
import model.Genero;



/**
 *
 * @author patrick
 */
public class daoGenero {

    private static List<Genero> generos = new ArrayList();

    public static void gravar(Genero genero) throws SQLException  {
        String sql = "Insert into VIDEOCLUB.genero (NOME, SIGLA) values ('" 
                + genero.getNome() + "', '" + genero.getSigla() + "')";
        new BdDao().executarAtualizacao(sql);
    }

    public static void alterar(Genero genero) throws SQLException {
        String sql = "update GENERO set nome='" + genero.getNome() + "', sigla='" + genero.getSigla()
                + "' where id= " + genero.getId().toString();
        new BdDao().executarAtualizacao(sql);
        
    }
    
    public static void excluir(Genero genero) throws SQLException {
        //String sql = "delete from SOCIO where id = " + socio.getMatricula() + ";";
        String sql = "delete from Genero where id = " + genero.getId().toString();
        new BdDao().executarAtualizacao(sql);
        
    }

    public static List<Genero> getGeneros() throws Exception {
        String sql = "select NOME, SIGLA, ID from genero";
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        
        generos = new ArrayList();
        while (rs.next()) {
            Genero a = new Genero();
            a.setNome(rs.getString("nome"));
            a.setSigla(rs.getString("sigla"));
            a.setId(rs.getInt("id"));
            generos.add(a);
        }
        
        bd.fecharBanco();
        
        return generos;
    }

 public static Genero getGenero(Integer id) throws Exception {
        String sql = "select NOME, SIGLA, ID from genero where ID = " + id;
        //System.out.println(sql);
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        Genero genero = null;
        
        Genero a = null;
        while (rs.next()) {
            a = new Genero();

            a.setNome(rs.getString("nome"));
            a.setSigla(rs.getString("sigla"));
            a.setId(rs.getInt("id"));
        }
        
        bd.fecharBanco();

        return a;
    }


}
