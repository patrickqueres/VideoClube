/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author patrick
 */
public class Filme
{
    
    private Integer id;
    private String titulo;
    private String duracao;
    private String ano;
    private Diretor diretor;
    private Ator ator1;
    private Ator ator2;
    private Genero genero;
    private Integer numeroCopias = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Ator getAtor1() {
        return ator1;
    }

    public void setAtor1(Ator ator1) {
        this.ator1 = ator1;
    }

    public Ator getAtor2() {
        return ator2;
    }

    public void setAtor2(Ator ator2) {
        this.ator2 = ator2;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getSequenciaCopia ()
    {
        numeroCopias++;
        return numeroCopias;
    }
    
    public String getSiglaGenero()
    {
        return genero.getSigla();
    }
    
    public String toString()
    {
        return this.id + " - " +this.titulo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Filme other = (Filme) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


    

}
