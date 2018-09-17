/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;
import java.util.PriorityQueue;
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

    static void showList() {
        for (Vertice v : grafo) {
            System.out.print(v.getDato() + "=> ");
            for (Integer x : v.getAdyacentes()) {
                System.out.print(x + " ");
            }
            System.out.println("");
        }
    }

    static boolean[] visitado = new boolean[M.length];

    public static void DFS(int u) {
        System.out.print(u + " ");
        visitado[u] = true;
        for (int v = 0; v < M.length; v++) {
            if (M[u][v] == 1) {
                if (!visitado[v]) {
                    DFS(v);
                }
            }
        }
    }

    public static void DFSList(int u) {
        Vertice a = grafo.get(u);
        System.out.print(a.getDato());
        visitado[u] = true;
        for (int i = 0; i < a.totalAdyacente(); i++) {
            if (!visitado[i]) {
                DFSList(i);
            }
        }
    }

    public static void BFSList(int u) {
        Queue<Integer> cola = new LinkedList<Integer>();
        visitado[u] = true;
        cola.add(u);
        while (!cola.isEmpty()) {
            u = cola.remove();
            System.out.print(u + " ");
            Vertice a = grafo.get(u);
            for (int i = 0; i < a.totalAdyacente(); i++) {
                if (!visitado[u]) {
                    visitado[i] = true;
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

    //Algoritmos de camino minimo 
    static int[][] C = {{0, 10, 99999, 99999, 6},
    {10, 0, 7, 11, 5},
    {99999, 7, 0, 12, 6},
    {99999, 11, 12, 0, 99999},
    {6, 5, 6, 99999, 0}};

    static boolean[] visto = new boolean[C.length];
    static int[] distancia = new int[C.length];
    static int[] padre = new int[C.length];

    public static void dijktra(int grafo[][], int pInicial) {
        PriorityQueue cola = new PriorityQueue();
        for (int i = 0; i < C.length; i++) {
            distancia[i] = 99999;
            visto[i] = false;
            padre[i] = -1;
        }
        distancia[pInicial] = 0;
        visto[pInicial] = true;
        cola.add(distancia[pInicial]);
        while (!cola.isEmpty()) {
            int u = (int) cola.poll();

        }
    }
    static int[][] distancias = {{0, 9, 3, 4, 99999, 99999},
    {99999, 0, 99999, 7, 99999, 99999},
    {99999, 99999, 0, 99999, 2, 99999},
    {99999, 99999, 4, 0, 99999, 99999},
    {5, 99999, 99999, 1, 0, 99999},
    {3, 8, 99999, 2, 99999, 0}};

    static int[][] camino = {{0, 1, 2, 3, 4, 5},
    {0, 1, 2, 3, 4, 5},
    {0, 1, 2, 3, 4, 5},
    {0, 1, 2, 3, 4, 5},
    {0, 1, 2, 3, 4, 5},
    {0, 1, 2, 3, 4, 5}};

    public static void floydMarshal(int distancias[][]) {

        for (int k = 0; k < distancias.length; k++) 
            for (int i = 0; i < distancias.length; i++) 
                for (int j = 0; j < distancias.length; j++) 
                    if (distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        camino[i][j] = k;
                    }
    }

    public static void mostrar(int matrizAdy[][]){
        for (int i = 0; i < matrizAdy.length; i++) {
            for (int j = 0; j < matrizAdy.length; j++) {
                if (matrizAdy[i][j]==99999) {
                    System.out.print("Inf");
                }else{
                System.out.print(matrizAdy[i][j]+" ");
                }
            }
            System.out.println("");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
//        System.out.println("DFS:");
//        DFS(0);
//
//        for (int i = 0; i < visitado.length; i++) {
//            visitado[i] = false;
//        }
//        System.out.println("\n\rBFS:");
//        BFS(0);
//
//        System.out.println("\n\rA partir  de aquí. Comienza lo de lista");
//        llenarLista();
//        showList();
//
//        for (int i = 0; i < visitado.length; i++) {
//            visitado[i] = false;
//        }
//        DFSList(0);
//
//        System.out.println("\n\rAhora viene el BFS de la lista");
//        for (int i = 0; i < visitado.length; i++) {
//            visitado[i] = false;
//        }
//        BFSList(0);
        floydMarshal(distancias);
        System.out.println("Distancias");
        mostrar(distancias);
        System.out.println("*****Caminos****");
        mostrar(camino);
    }

}
