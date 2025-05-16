package com.univille;

public class Main {
    public static void main(String[] args) {
        ListaAdjacencia listaAdjacencia = new ListaAdjacencia();

        //Check autoloop
        listaAdjacencia.addAresta(0, 1);
        listaAdjacencia.addAresta(1, 0);
        listaAdjacencia.addAresta(1, 1);

        listaAdjacencia.imprimirArestas();
        System.out.println(listaAdjacencia.temAutoLoop());
        listaAdjacencia.removerAresta(1, 1);

        //Check paralelismo
        listaAdjacencia.addAresta(2, 0);
        listaAdjacencia.addAresta(2, 0);
        listaAdjacencia.imprimirArestas();
        System.out.println(listaAdjacencia.getNo(2).temArestaParalela());
        listaAdjacencia.removerAresta(2, 0);

        //Check assimetria
        listaAdjacencia.addAresta(0, 3);
        listaAdjacencia.imprimirArestas();
        System.out.println(listaAdjacencia.getNo(0).temArestaAssimetrica());
        listaAdjacencia.removerAresta(0, 3);
        listaAdjacencia.removerAresta(2, 0);

        //Check nó entre 0 e V-1
        listaAdjacencia.imprimirArestas();
        System.out.println("Ordem: " + listaAdjacencia.getOrdem());
        System.out.println("Todos na ordem: " + listaAdjacencia.todosNosDentroDaOrdem());

        // Método q consolida todos
        listaAdjacencia.imprimirArestas();
        System.out.println("Grafo válido: " + listaAdjacencia.ehGrafoValido());

    }
}