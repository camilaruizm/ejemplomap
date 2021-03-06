/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplomap;

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
 * @author maria_cam.ruiz
 */
public class Ejemplomap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Persona> listap = new LinkedList<>();
        LinkedList<Persona> listap2 = new LinkedList<>();

        HashMap<Integer, LinkedList<Persona>> map1 = new HashMap<>();
        LinkedHashMap<Integer, LinkedList<Persona>> map2 = new LinkedHashMap<>();
        TreeMap<Integer, LinkedList<Persona>> map3 = new TreeMap<>();

        listap.add(new Persona("David", "1130", 31));
        listap.add(new Persona("Luis", "1131", 30));
        listap.add(new Persona("Camila", "1132", 25));
        listap.add(new Persona("Camilo", "1133", 37));
        map1.put(3, listap);

        listap2.add(new Persona("Camila", "1130", 31));
        listap2.add(new Persona("Sofia", "1131", 30));
        listap2.add(new Persona("Mario", "1132", 25));
        listap2.add(new Persona("Camilo", "1133", 37));
        map1.put(2, listap2);

        String m1 = mostrar(map1);
        String m2 = mostrar(map2);
        String m3 = mostrar(map3);

        System.out.println(m1);
        System.out.println("_______");
//        System.out.println(m2);
//        System.out.println("________");
//        System.out.println(m3);


        boolean t=FileXML.crearArchivoXML(map1);
        if(t){
        
        JOptionPane.showMessageDialog(null, "Archivo Guardado con Éxito");
        }else{
        
        
         JOptionPane.showMessageDialog(null, "Error al Guardar el Archivo");
         
        }
        }






    

    public static String mostrar(Map<Integer, LinkedList<Persona>> m) {
        String mostrar = "";
        Iterator<Map.Entry<Integer, LinkedList<Persona>>> it
                = m.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, LinkedList<Persona>> pair = it.next();

            mostrar += pair.getKey();

            for (int i = 0; i < pair.getValue().size(); i++) {

                mostrar += "   " + pair.getValue().get(i) + "\n";

            }

        }

        return mostrar;
    }

}
