package com.univille;

import java.util.ArrayList;

public class ListaAdjacencia {
    private final ArrayList<No> listaAdjacencia;

    public ListaAdjacencia() {
        listaAdjacencia = new ArrayList<>();
    }

    public void addNo(int id) {
        No no = new No();
        no.setId(id);
        listaAdjacencia.add(no);
    }

    public void addAresta(int id1, int id2) {
        if (getNo(id1) == null) { // Para construção mais fácil só usando arestas
            addNo(id1);
        }
        
        if (getNo(id2) == null) {
            addNo(id2);
        }
        
        No no1 = getNo(id1);
        No no2 = getNo(id2);
        no1.arestas.add(no2);
    }

    public No getNo(int id) {
        if (!noDentroDaOrdem(id)) {
            return null;
        }
        return listaAdjacencia.get(id);
    }

    public boolean temAutoLoop() {
        for (No no : listaAdjacencia) {
            if (no.ehAutoLoop()){
                System.out.println(no.getId() + " se referencia, suas arestas são: " + no.getArestas());
                return true;
            }
        }
        return false;
    }

    public void removerAresta(int id1, int id2) {
        No no1 = getNo(id1);
        No no2 = getNo(id2);
        if (no1 != null && no2 != null) {
            no1.arestas.remove(no2);
        }
    }

    public int getOrdem() {
        return listaAdjacencia.size();
    }

    public boolean noDentroDaOrdem (int id) {
        return id >= 0 && id < listaAdjacencia.size();
    }

    public boolean todosNosDentroDaOrdem() {
        for (int i = 0; i < listaAdjacencia.size(); i++) {
            if (!noDentroDaOrdem(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean ehGrafoValido() {
        if (!todosNosDentroDaOrdem()) {
            return false;
        }
        
        for (No no : listaAdjacencia) {
            if (no.temArestaParalela() || no.temArestaAssimetrica() || no.ehAutoLoop()) {
                return false;
            }
        }
        return true;
    }

    public void imprimirArestas() {
        for (No no : listaAdjacencia) {
            System.out.print(no + " | ");
            System.out.println(no.getArestas());
            System.out.println();
        }
    }
}
