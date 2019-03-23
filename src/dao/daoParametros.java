/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Parametros;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class daoParametros {

    private static Parametros parametros;
       
    public static void gravar(Parametros parametros) {
        daoParametros.parametros = parametros;
        persistir();
    }
    
    public static Parametros getParametros() {
        lerArquivo();
        return parametros;
    }

    private static void persistir() {
        File f = new File("BD/config.xml");
        f.delete();
        
        
        XStream xStream = new XStream();
       // xStream.alias("clientes", List.class);
        xStream.alias("parametros", Parametros.class);

        File arquivo = new File("BD/config.xml");
        FileOutputStream gravar;
        try {
            gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(parametros).getBytes());
            gravar.close();
        } catch (IOException ex) {
        }
    }

    public static void lerArquivo() {

        try {
            XStream xStream = new XStream(new Dom4JDriver());
            //xStream.alias("clientes", ArrayList.class);
            xStream.processAnnotations(Parametros.class);

            try (BufferedReader input = new BufferedReader(new FileReader("BD/config.xml")))
            {
                parametros = (Parametros) xStream.fromXML(input);
            }

        } catch (IOException ex) {
        }
    }
}
