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
import model.Copia;


/**
 *
 * @author patrick
 */
public class daoCopia {

    private static List<Copia> copias = new ArrayList();

    public static void gravar(Copia copia) throws SQLException  {
        String sql = "Insert into VIDEOCLUB.COPIAs (IDFILME, DATA_AQUISICAO, ESTADO, ETIQUETA) values ('" 
                + copia.getFilme().getId().toString() + "', '" 
                + copia.getDataAquisicao() + "', '" 
                + copia.getEstadoFita() + "', '" 
                + copia.getCodigoCopia() + "')";
        new BdDao().executarAtualizacao(sql);
        
    }

    public static void alterar(Copia copia) throws SQLException {
        String sql = "update COPIAs set IDFILME='" + copia.getFilme().getId().toString()
                + "', DATA_AQUISICAO='" + copia.getDataAquisicao()
                + "', ESTADO= '" +  copia.getEstadoFita()
                + "', ETIQUETA= '" +  copia.getCodigoCopia()
                + "' where id= " + copia.getIdcopia().toString();
        //System.out.println(sql);
        new BdDao().executarAtualizacao(sql);
        
    }
    
    public static void excluir(Copia copia) throws SQLException {
        //String sql = "delete from SOCIO where id = " + socio.getMatricula() + ";";
        String sql = "delete from Copias where id = " + copia.getIdcopia().toString();
        new BdDao().executarAtualizacao(sql);
        
    }

    public static List<Copia> getCopias() throws Exception {
        String sql = "select ID, IDFILME, DATA_AQUISICAO, ESTADO, ETIQUETA from copias";
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        
        copias = new ArrayList();
        while (rs.next()) {
            Copia a = new Copia();
            a.setIdcopia(rs.getInt("id"));
            a.setDataAquisicao(rs.getString("DATA_AQUISICAO"));
            a.setCodigoCopia(rs.getString("etiqueta"));
            a.setEstadoFita(rs.getString("ESTADO"));
            a.setFilme(daoFilme.getFilme(rs.getInt("IDFILME")));
            copias.add(a);
            //System.out.println(sql);
        }
        
        bd.fecharBanco();
        
        return copias;
    }

    public static Copia getCopia(Integer id) throws Exception {
        String sql = "select ID, IDFILME, DATA_AQUISICAO, ESTADO, ETIQUETA from copias where ID = " + id;
        
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        
        Copia a = null;
        while (rs.next()) {
            a = new Copia();

            a.setIdcopia(rs.getInt("id"));
            a.setDataAquisicao(rs.getString("DATA_AQUISICAO"));
            a.setCodigoCopia(rs.getString("etiqueta"));
            a.setEstadoFita(rs.getString("ESTADO"));
            a.setFilme(daoFilme.getFilme(rs.getInt("IDFILME")));
        }
        
        bd.fecharBanco();

        return a;
    }



}
