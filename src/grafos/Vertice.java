/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;

/**
 *
 * @author rdcamero
 */
public class Vertice {
    final int dato;
    LinkedList<Integer> adyacentes;
    
    public Vertice(int dato) {
        this.dato = dato;
        adyacentes = new LinkedList<>();
    }

    public int getDato() {
        return dato;
    }

    public LinkedList<Integer> getAdyacentes() {
        return adyacentes;
    }
    public int totalAdyacente(){
        return adyacentes.size();
    }
    
    
}
