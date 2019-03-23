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
import model.Emprestimo;
import model.Socio;


/**
 *
 * @author patrick
 */
public class daoEmprestimo {

    private static List<Emprestimo> emprestimos = new ArrayList();

    public static void gravar(Emprestimo emprestimo) throws SQLException  {
        String sql = "Insert into VIDEOCLUB.emprestimo (IDSOCIO, DATA_EMPRESTIMO, DATA_DEVOLUCAO, VALOR_PAGO, PAGAMENTO, DEVOLVIDO, VALOR_COBRADO, IDCOPIA) values ('" 
                + emprestimo.getSocio().getMatricula().toString() + "', '" 
                + emprestimo.getDataEmprestimo() + "', '" 
                + emprestimo.getDataDevolucao() + "', '" 
                + emprestimo.getValorPago() + "', '" 
                + emprestimo.getPago() + "', '" 
                + emprestimo.getDevolvido() + "', '" 
                + emprestimo.getValorCobrado() + "', '" 
                + emprestimo.getCopia().getIdcopia().toString() + "')";
        System.out.println(sql);
        new BdDao().executarAtualizacao(sql);
    }

    public static void alterar(Emprestimo emprestimo) throws SQLException {
        String sql = "update Emprestimo set IDSOCIO='" + emprestimo.getSocio().getMatricula().toString()  
                + "', DATA_EMPRESTIMO='" + emprestimo.getDataEmprestimo() 
                + "', DATA_DEVOLUCAO= '" + emprestimo.getDataDevolucao()
                + "', VALOR_PAGO= '" +  emprestimo.getValorPago() 
                + "', PAGAMENTO= '" +  emprestimo.getPago()
                + "', DEVOLVIDO= '" +  emprestimo.getDevolvido()
                + "', VALOR_COBRADO= '" +  emprestimo.getValorCobrado()
                + "', IDCOPIA= '" +  emprestimo.getCopia().getIdcopia().toString()
                + "' where IDEMPRESTIMO= " + emprestimo.getIdemprestimo().toString();
        //System.out.println(sql);
        new BdDao().executarAtualizacao(sql);
       
    }
    
    public static void excluir(Emprestimo emprestimo) throws SQLException {
        //String sql = "delete from SOCIO where id = " + socio.getMatricula() + ";";
        String sql = "delete from Emprestimo where IDEMPRESTIMO = " + emprestimo.getIdemprestimo().toString();
        new BdDao().executarAtualizacao(sql);
        
    }

    public static List<Emprestimo> getEmprestimos() throws Exception {
        String sql = "select IDEMPRESTIMO, IDSOCIO, DATA_EMPRESTIMO, DATA_DEVOLUCAO, VALOR_PAGO, PAGAMENTO, DEVOLVIDO, VALOR_COBRADO, IDCOPIA from emprestimo";
        BdDao bd = new BdDao();
        ResultSet rs = bd.executaConsulta(sql);
        
        emprestimos = new ArrayList();
        while (rs.next()) {
            Emprestimo a = new Emprestimo();
            a.setIdemprestimo(rs.getInt("IDEMPRESTIMO"));
            a.setDataEmprestimo(rs.getString("DATA_EMPRESTIMO"));
            a.setDataDevolucao(rs.getString("DATA_DEVOLUCAO"));
            a.setValorPago(rs.getInt("VALOR_PAGO"));
            a.setValorCobrado(rs.getInt("VALOR_COBRADO"));
            a.setPago(rs.getInt("PAGAMENTO"));
            a.setDevolvido(rs.getInt("DEVOLVIDO"));
            a.setSocio(DaoSocio.getSocio(rs.getInt("IDSOCIO")));
            a.setCopia(daoCopia.getCopia(rs.getInt("IDCOPIA")));
            
            
            emprestimos.add(a);
        }
        
        bd.fecharBanco();
        
        return emprestimos;
    }




}
