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
import model.Filme;
import model.Genero;


/**
 *
 * @author patrick
 */
public class daoFilme {

    private static List<Filme> filmes = new ArrayList();

    public static void gravar(Filme filme) throws SQLException  {
        String sql = "Insert into VIDEOCLUB.FILME (TITULO, DURACAO, ANO, GENERO, DIRETOR, ATOR1, ATOR2) values ('" 
                + filme.getTitulo() + "', '" + filme.getDuracao() + "', '" 
                + filme.getAno() + "', '" 
                + filme.getGenero().getId().toString() + "', '" 
                + filme.getDiretor().getMatricula().toString() + "', '" 
                + filme.getAtor1().getMatricula().toString() + "', '" 
                + filme.getAtor2().getMatricula().toString() + "')";
        new BdDao().executarAtualizacao(sql);
    }

    public static void alterar(Filme filme) throws SQLException {
        String sql = "update FILME set titulo='" + filme.getTitulo() 
                + "', duracao='" + filme.getDuracao() 
                + "', ano= '" +  filme.getAno() 
                + "', genero= '" +  filme.getGenero().getId().toString() 
                + "', diretor= '" +  filme.getDiretor().getMatricula().toString()
                + "', ator1= '" +  filme.getAtor1().getMatricula().toString()
                + "', ator2= '" +  filme.getAtor2().getMatricula().toString()
                + "' where id= " + filme.getId().toString();
        
        new BdDao().executarAtualizacao(sql);
        
    }
    
    public static void excluir(Filme filme) throws SQLException {
        //String sql = "delete from SOCIO where id = " + socio.getMatricula() + ";";
        String sql = "delete from Filme where id = " + filme.getId().toString();
        new BdDao().executarAtualizacao(sql);
        
    }

    public static List<Filme> getFilmes() throws Exception {
        String sql = "select ID, TITULO, DURACAO, ANO, GENERO, DIRETOR, ATOR1, ATOR2 from filme";
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        Genero genero = null;
        
        filmes = new ArrayList();
        while (rs.next()) {
            Filme a = new Filme();
            a.setId(rs.getInt("id"));
            a.setTitulo(rs.getString("titulo"));
            a.setDuracao(rs.getString("duracao"));
            a.setAno(rs.getString("ano"));
            a.setGenero(daoGenero.getGenero(rs.getInt("GENERO")));
            a.setDiretor(daoDiretor.getDiretor(rs.getInt("DIRETOR")));
            a.setAtor1(daoAtor.getAtor(rs.getInt("ATOR1")));
            a.setAtor2(daoAtor.getAtor(rs.getInt("ATOR2")));
                       
            filmes.add(a);
        }
        
        bd.fecharBanco();
        
        return filmes;
    }

    public static Filme getFilme(Integer id) throws Exception {
        String sql = "select ID, TITULO, DURACAO, ANO, GENERO, DIRETOR, ATOR1, ATOR2 from filme where ID = " + id;

        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        Genero genero = null;
        
        Filme a = null;
        while (rs.next()) {
            a = new Filme();

            a.setId(rs.getInt("id"));
            a.setTitulo(rs.getString("titulo"));
            a.setDuracao(rs.getString("duracao"));
            a.setAno(rs.getString("ano"));
 
           
            
        }
        
        
        
        bd.fecharBanco();

        return a;
    }




}
