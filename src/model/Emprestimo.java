/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author patrick
 */
public class Emprestimo
{
    private Integer idemprestimo;
    private String dataEmprestimo;
    private String dataDevolucao;
    private Integer valorCobrado;
    private Integer valorPago;
    private Copia copia;
    private Socio socio;
    private Integer pago;
    private Integer devolvido;

    public Integer getIdemprestimo() {
        return idemprestimo;
    }

    public void setIdemprestimo(Integer idemprestimo) {
        this.idemprestimo = idemprestimo;
    }
    
    

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(Integer valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public Integer getValorPago() {
        return valorPago;
    }

    public void setValorPago(Integer valorPago) {
        this.valorPago = valorPago;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Integer getPago() {
        return pago;
    }

    public void setPago(Integer pago) {
        this.pago = pago;
    }

    public Integer getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(Integer devolvido) {
        this.devolvido = devolvido;
    }

    
    
    
    
    public String toString()
    {
        return idemprestimo.toString();
    }
}
