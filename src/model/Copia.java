/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author patrick
 */
public class Copia
{
    private Integer idcopia;
    private String codigoCopia;
    private String dataAquisicao;
    private String estadoFita;
    private Filme filme;

    public Integer getIdcopia() {
        return idcopia;
    }

    public void setIdcopia(Integer idcopia) {
        this.idcopia = idcopia;
    }

    public String getCodigoCopia() {
        return codigoCopia;
        
    }

    public void setCodigoCopia(String codigoCopia) {
        this.codigoCopia = codigoCopia;
        // this.codigoCopia = filme.getSiglaGenero()+ filme.getId() + "-" + filme.getSequenciaCopia();
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getEstadoFita() {
        return estadoFita;
    }

    public void setEstadoFita(String estadoFita) {
        this.estadoFita = estadoFita;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    
        

       
    public String toString()
    {
        // return this.codigoCopia + " - " +filme.getTitulo();
        return this.codigoCopia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idcopia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Copia other = (Copia) obj;
        if (!Objects.equals(this.idcopia, other.idcopia)) {
            return false;
        }
        return true;
    }
    
    
    
}
   