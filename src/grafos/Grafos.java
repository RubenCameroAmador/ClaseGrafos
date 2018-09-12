/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author rdcamero
 */
public class Grafos {

    static LinkedList<Vertice> grafo = new LinkedList<Vertice>();

    static int[][] M = {{0, 1, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 0, 1, 1},
                        {0, 1, 1, 0, 0},
                        {1, 1, 1, 0, 0}};
    //DFS: 01234
    //BFS: 01243

    static void llenarLista() {
        int n = M.length;
        for (int i = 0; i < n; i++) {
            Vertice temp = new Vertice(i);
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    temp.adyacentes.add(j);
                }
            }
            grafo.add(temp);
        }
    }
    static void showList(){
        for (Vertice v : grafo) {
            System.out.print(v.getDato()+"=> ");
            for (Integer x : v.getAdyacentes()) {
                System.out.print(x+" ");
            }
            System.out.println("");
        }
    }

    static boolean[] visitado = new boolean[M.length];

   public static void DFS(int u){
        System.out.print(u+" ");
        visitado[u]=true;
        for (int v = 0; v < M.length; v++) 
            if (M[u][v]==1) 
                if (!visitado[v]) 
                    DFS(v);
    }
   
   public static void DFSList(int u){
       Vertice a = grafo.get(u);
       System.out.print(a.getDato());
       visitado[u]=true;
       for (int i = 0; i < a.totalAdyacente(); i++) 
           if(!visitado[i])
               DFSList(i);
   }
   public static void BFSList(int u){
       Queue<Integer> cola = new LinkedList<Integer>();
       visitado[u]=true;
       cola.add(u);
       while(!cola.isEmpty()){
           u = cola.remove();
           System.out.print(u+" ");
           Vertice a = grafo.get(u);
           for (int i = 0; i < a.totalAdyacente(); i++) {
               if(!visitado[u]){
                   visitado[i]=true;
                   cola.add(i);
               }
           }
       }
   }

   
   
    public static void BFS(int u) {
        Queue<Integer> cola = new LinkedList<Integer>(); //FIFO
        visitado[u] = true;
        cola.add(u);
        while (!cola.isEmpty()) {
            u = cola.remove();
            System.out.print(u + " ");
            for (int v = 0; v < M.length; v++) {
                if (M[u][v] == 1) {
                    if (!visitado[v]) {
                        visitado[v] = true;
                        cola.add(v);
                    }
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("DFS:");
        DFS(0);
        
        for (int i = 0; i < visitado.length; i++) 
            visitado[i]=false;
        System.out.println("\n\rBFS:");
        BFS(0);
        
        System.out.println("\n\rA partir  de aquí. Comienza lo de lista");
        llenarLista();
        showList();
        
        for (int i = 0; i < visitado.length; i++) 
            visitado[i]=false;
        DFSList(0);
        
        System.out.println("\n\rAhora viene el BFS de la lista");
        for (int i = 0; i < visitado.length; i++) 
            visitado[i]=false;
        BFSList(0);
        
    }

}
