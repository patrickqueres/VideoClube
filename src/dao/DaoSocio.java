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
import model.Socio;

/**
 *
 * @author acg
 */
public class DaoSocio {

    private static List<Socio> socios = new ArrayList();

    public static void gravar(Socio socio) throws SQLException  {
        String sql = "Insert into VIDEOCLUB.SOCIO (CPF, NOME, ENDERECO, TELEFONE) values ('" 
                + socio.getCpf() + "', '" + socio.getNome() + "', '" + socio.getEndereco() + "', '" 
                + socio.getTelefone() + "')";
        new BdDao().executarAtualizacao(sql);
    }

    public static void alterar(Socio socio) throws SQLException {
        String sql = "update SOCIO set cpf='" + socio.getCpf() + "', nome='" + socio.getNome() + "', endereco= '" 
                +  socio.getEndereco() + "', telefone= '" + socio.getTelefone() + "' where MATRICULA= " 
                + socio.getMatricula().toString();
        
        new BdDao().executarAtualizacao(sql);
        
    }
    
    public static void excluir(Socio socio) throws SQLException {
        //String sql = "delete from SOCIO where id = " + socio.getMatricula() + ";";
        String sql = "delete from SOCIO where MATRICULA = " + socio.getMatricula().toString();
        new BdDao().executarAtualizacao(sql);
        
    }

    public static List<Socio> getSocios() throws Exception {
        String sql = "select CPF, NOME, ENDERECO, TELEFONE, MATRICULA from SOCIO";
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        
        socios = new ArrayList();
        while (rs.next()) {
            Socio s = new Socio();
            s.setCpf(rs.getString("cpf"));
            s.setNome(rs.getString("nome"));
            s.setEndereco(rs.getString("endereco"));
            s.setTelefone(rs.getString("telefone"));
            s.setMatricula(rs.getInt("matricula"));
            socios.add(s);
        }
        
        bd.fecharBanco();
        
        return socios;
    }

    public static Socio getSocio(Integer id) throws Exception {
        String sql = "select CPF, NOME, ENDERECO, TELEFONE, MATRICULA from SOCIO where MATRICULA = " + id;
        System.out.println(sql);
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        
        Socio s = null;
        while (rs.next()) {
            s = new Socio();

            s.setCpf(rs.getString("cpf"));
            s.setNome(rs.getString("nome"));
            s.setEndereco(rs.getString("endereco"));
            s.setTelefone(rs.getString("telefone"));
            s.setMatricula(rs.getInt("matricula"));
        }
        
        bd.fecharBanco();

        return s;
    }



}
