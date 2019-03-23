/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

//import static java.sql.JDBCType.NULL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Login;


public class daoLogin
{
    private static List<Login> logins;

    public static void gravar(Login login) throws SQLException  {
        String sql = "INSERT into VIDEOCLUB.USUARIOS (usuario, senha, id) values ("+login.getUsuario()+", '"+login.getSenha()+"', '"+login.getId()+ "')";
        new BdDao().executarAtualizacao(sql);
    }

    public static void alterar(Login login) throws SQLException {
        String sql = "update usuarios set usuario = '"+login.getUsuario()+"', senha = '"+login.getSenha()+"' where id = "+login.getId().toString();
        new BdDao().executarAtualizacao(sql);
        
    }
    
    public static void excluir(Login login) throws SQLException {
        String sql = "delete from usuarios where id = " +login.getId().toString();
        new BdDao().executarAtualizacao(sql);
        
    }

    public static List<Login> getLogins() throws SQLException
    {
        String sql = "select id, usuario from usuarios order by id";
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        System.out.println(sql);
        logins = new ArrayList();
        
        while (rs.next()) {
            Login c = new Login();
            c.setId(rs.getInt("id"));
            c.setUsuario(rs.getString("usuario"));
            logins.add(c);
        }
        bd.fecharBanco();
        
        return logins;
    }
    
    public static Login getLogin(Login login) throws SQLException
    {
        String sql = "select usuario, senha, id from usuarios where id = "+login.getId();
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
       
        Login c = new Login();
        if (rs.next())
        {
            
            c.setId(rs.getInt("id"));
            c.setUsuario(rs.getString("usuario"));
            c.setSenha(rs.getString("senha"));

            bd.fecharBanco();
            return c;
        }
        return c;
    }
    
    public static Integer getId() throws SQLException
    {
        String sql = "select max(matricula) matricula from usuarios";
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        Integer id;
        
        if (rs.next())
        {
            id = rs.getInt("id");
            bd.fecharBanco();
            return id;
        }
        return -1;
    }

}
