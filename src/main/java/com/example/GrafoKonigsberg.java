package com.example;

public class GrafoKonigsberg 
{
    private final String[] vertices = {"A", "B", "C", "D"};
    private int[][] matrizAdjacencia = new int[4][4];

    public GrafoKonigsberg()
    {

        configurarMatrizAdjacencia();
    }

    public void desenhaMatrizAdjacencia()
    {
        System.out.println("\nMATRIZ DE ADJACÊNCIA");
        System.out.println("   A B C D");
        System.out.println("  +-------");
        for (int linha = 0; linha < matrizAdjacencia.length; linha++)
        {
            System.out.print(String.format("%s |", vertices[linha]));
            for (int coluna = 0; coluna < matrizAdjacencia[linha].length; coluna++)
            {
                System.out.print(String.format("%s ", matrizAdjacencia[linha][coluna]));
            }

            System.out.println();
        }
    }

    public void mostrarLigacoes()
    {
        System.out.println("\nLIGAÇÕES");
        for (int linha = 0; linha < matrizAdjacencia.length; linha++)
        {
            for (int coluna = 0; coluna < matrizAdjacencia[linha].length; coluna++)
            {
                if (matrizAdjacencia[linha][coluna] != 0)
                {
                    System.out.println(String.format("Bairro %s => Bairro %s", vertices[linha], vertices[coluna]));
                }
            }
        }
    }

    public void percorrerCaminhos(int partida)
    {
        System.out.println("\nPERCORRENDO TODOS OS CAMINHOS");
        int[][] matrizAdjacenciaCopia = copiarMatrizAdjacencia();
        boolean sentinelaLinha = true;
        int linha = partida;
        int contagem = 0;
        String percurso = "";
        while(sentinelaLinha)
        {
            for(int coluna = 0; coluna < matrizAdjacenciaCopia[linha].length; coluna++)
            {
                sentinelaLinha = false;

                if (matrizAdjacenciaCopia[linha][coluna] == 1)
                {
                    System.out.println(String.format("Interação %d - Origem %s => Destino %s", contagem, vertices[linha], vertices[coluna]));
                    if (percurso.length() == 0)
                    {
                        percurso += String.format("%d=(%d,%d)", contagem, linha, coluna);
                    }
                    else
                    {
                        percurso += String.format(", %d=(%d,%d)", contagem, linha, coluna);
                    }
                    matrizAdjacenciaCopia[linha][coluna] = 0;
                    linha = coluna;
                    sentinelaLinha = true;
                    break;
                } 
            }

            contagem++;
        }

        System.out.println(String.format("\n{%s}", percurso));
    }

    private int[][] copiarMatrizAdjacencia()
    {
        int[][] matrizAdjacenciaCopia = new int[matrizAdjacencia.length][matrizAdjacencia.length];
        for (int linha = 0; linha < matrizAdjacencia.length; linha++)
        {
            for (int coluna = 0; coluna < matrizAdjacencia[linha].length; coluna++)
            {
                matrizAdjacenciaCopia[linha][coluna] = matrizAdjacencia[linha][coluna];
            }
        }

        return matrizAdjacenciaCopia;
    }

    private void configurarMatrizAdjacencia()
    {
        matrizAdjacencia[0][0] = 0;
        matrizAdjacencia[0][1] = 1;
        matrizAdjacencia[0][2] = 1;
        matrizAdjacencia[0][3] = 1;

        matrizAdjacencia[1][0] = 1;
        matrizAdjacencia[1][1] = 0;
        matrizAdjacencia[1][2] = 1;
        matrizAdjacencia[1][3] = 1;

        matrizAdjacencia[2][0] = 1;
        matrizAdjacencia[2][1] = 1;
        matrizAdjacencia[2][2] = 0;
        matrizAdjacencia[2][3] = 0;

        matrizAdjacencia[3][0] = 1;
        matrizAdjacencia[3][1] = 1;
        matrizAdjacencia[3][2] = 0;
        matrizAdjacencia[3][3] = 0;
    }
}
