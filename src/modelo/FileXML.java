/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author juan_felipe.pena
 */
public class FileXML {
    
    public static boolean creararchivoxml(Map<Integer, LinkedList<Persona>> m){
        boolean t=false;
        
        try{
            Element personas = new Element("personas");
            Document doc = new Document(personas);
            
            Iterator<Map.Entry<Integer, LinkedList<Persona>>> it =
                m.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<Integer,LinkedList<Persona>> pair = 
                it.next();
                Element key = new Element("key");
                key.setAttribute(
                new Attribute("id", String.valueOf(pair.getKey())));
                doc.getRootElement().addContent(key);
                
                for(int i = 0; i<pair.getValue().size(); i++){
                    Persona objp = pair.getValue().get(i);
                    Element per = new Element("personas");
                    
                    per.setAttribute(
                    new Attribute("nombre", objp.getNombre()));
                    per.setAttribute(
                    new Attribute("identificaión", objp.getId()));
                    per.setAttribute(
                    new Attribute("edad", String.valueOf(objp.getEdad())));
                    doc.getRootElement().addContent(per);
                }
            }
            
            XMLOutputter xmloutputter = new XMLOutputter();
            
            xmloutputter.setFormat(Format.getPrettyFormat());
            xmloutputter.output(doc, new FileWriter("fileP.xml"));
            t=true;
            
        }catch(IOException io){
            System.out.println(io.getMessage());
        }
        
        return t;
    }
}
