/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplomapa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import modelo.FileXML;
import modelo.Persona;

/**
 *
 * @author juan_felipe.pena
 */
public class Ejemplomapa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedList<Persona> listap = new LinkedList<>();
        LinkedList<Persona> listap2 = new LinkedList<>();
        
        HashMap<Integer,LinkedList<Persona>> map1 = new HashMap<>();
        LinkedHashMap<Integer,LinkedList<Persona>> map2 = new LinkedHashMap<>();
        TreeMap<Integer,LinkedList<Persona>> map3 = new TreeMap<>();
        
        listap.add(new Persona("Felipe", "123", 19));
        listap.add(new Persona("Manuel", "456", 21));
        listap.add(new Persona("Lipa", "789", 20));
        listap.add(new Persona("Lalo", "159", 30));
        map1.put(2, listap);
        
        listap2.add(new Persona("Alejandro", "123", 19));
        listap2.add(new Persona("Luz", "456", 21));
        listap2.add(new Persona("Gonzo", "789", 20));
        listap2.add(new Persona("Murillo", "159", 30));
        map1.put(3, listap2);
        
        /*map1.put(3, new Persona("Felipe", "123", 19));
        map1.put(2, new Persona("Manuel", "456", 21));
        map1.put(36, new Persona("Lipa", "789", 20));
        map1.put(6, new Persona("Lalo", "159", 30));
        
        map2.put(3, new Persona("Felipe", "123", 19));
        map2.put(2, new Persona("Manuel", "456", 21));
        map2.put(36, new Persona("Lipa", "789", 20));
        map2.put(6, new Persona("Lalo", "159", 30));
        
        map3.put(3, new Persona("Felipe", "123", 19));
        map3.put(2, new Persona("Manuel", "456", 21));
        map3.put(36, new Persona("Lipa", "789", 20));
        map3.put(6, new Persona("Lalo", "159", 30));*/
        
        String m1=mostrar(map1);
        //String m2=mostrar(map2);
        //String m3=mostrar(map3);
        
        System.out.println(m1);
        System.out.println("_______________");
        //System.out.println(m2);
        //System.out.println("____________");
        //System.out.println(m3);
        //System.out.println("____________");
        boolean t = FileXML.creararchivoxml(map1);
        if(t){
            JOptionPane.showMessageDialog(null, "Archivo guardado con éxito");
        }else{
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
        }
 
    }
    public static String mostrar(Map<Integer,LinkedList<Persona>> m){
        String mostrar="";
        Iterator<Map.Entry<Integer, LinkedList<Persona>>> it =
                m.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,LinkedList<Persona>> pair = 
            it.next();
            
            mostrar += pair.getKey();
            for(int i =0; i<pair.getValue().size(); i++){
                mostrar += " " + pair.getValue().get(i)+"\n";
            }
            
        }
        return mostrar;
    }
    
}
