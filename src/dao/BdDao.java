/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Parametros;

/**
 *
 * @author
 */
public class BdDao {

    
    private Statement statement;
    
    private Connection conectarBanco() throws SQLException {
        
        Parametros parametros;
        parametros = dao.daoParametros.getParametros();
        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        
        // Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "VIDEOCLUB","video");
        
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@//" + parametros.getLOCALBANCO() + ":" + parametros.getPORTABANCO() + "/" + parametros.getNOMEBANCO(), parametros.getUSUARIO(), parametros.getSENHA());
        

        return c;
    }

    public void executarAtualizacao(String sql) throws SQLException {
        Statement st = conectarBanco().createStatement();
        st.executeUpdate(sql);
        st.close();

    }

    public ResultSet executaConsulta(String sql) throws SQLException {
        statement = conectarBanco().createStatement();
        ResultSet r = statement.executeQuery(sql);
        return r;
    }
    
    
    public void fecharBanco() {
        try {
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BdDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
