package com.example;

public class App 
{
    public static void main( String[] args )
    {
        GrafoKonigsberg grafo = new GrafoKonigsberg();
        grafo.desenhaMatrizAdjacencia();
        grafo.mostrarLigacoes();
        grafo.percorrerCaminhos(0);
    }
}
