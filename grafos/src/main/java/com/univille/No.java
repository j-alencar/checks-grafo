package com.univille;

import java.util.ArrayList;

public class No {
    private int id;
    public ArrayList<No> arestas = new ArrayList<>();

    public No() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "No [id=" + id + "]";
    }

    public ArrayList<No> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<No> arestas) {
        this.arestas = arestas;
    }

    public boolean temArestaParalela(){
        ArrayList<Integer> idArestas = new ArrayList<>();
        
        for (No no : arestas) {
            int id = no.getId();
            if (idArestas.contains(id)) {
                System.out.println("Aresta paralela encontrada em " + this + " no: " + no);
                return true;
            }
            idArestas.add(id);
        }
        return false;
    }

    public boolean temArestaAssimetrica() {
        for (No no : arestas) {
            if (!no.arestas.contains(this)) {
                System.out.println("Aresta assimétrica encontrada em " + this + " no: " + no);
                return true;
            }
        }
        return false;
    }

    public boolean ehAutoLoop() {
        return arestas.contains(this);
    }
}
