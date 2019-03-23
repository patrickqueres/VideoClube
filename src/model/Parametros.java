/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("parametros")
public class Parametros
{
    private String LOCALBANCO;
    private String USUARIO;
    private String SENHA;
    private String NOMEBANCO;
    private String PORTABANCO;

    public Parametros()
    {
    }
    
    public String getLOCALBANCO()
    {
        return LOCALBANCO;
    }

    public void setLOCALBANCO(String LOCALBANCO)
    {
        this.LOCALBANCO = LOCALBANCO;
    }

    public String getUSUARIO()
    {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO)
    {
        this.USUARIO = USUARIO;
    }

    public String getSENHA()
    {
        return SENHA;
    }

    public void setSENHA(String SENHA)
    {
        this.SENHA = SENHA;
    }

    public String getNOMEBANCO()
    {
        return NOMEBANCO;
    }

    public void setNOMEBANCO(String NOMEBANCO)
    {
        this.NOMEBANCO = NOMEBANCO;
    }

    public String getPORTABANCO()
    {
        return PORTABANCO;
    }

    public void setPORTABANCO(String PORTABANCO)
    {
        this.PORTABANCO = PORTABANCO;
    }
}
