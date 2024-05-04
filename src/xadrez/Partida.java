package xadrez;

import pieces.Rei;
import pieces.Torre;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

import java.awt.*;

public class Partida {
    private Tabuleiro tabuleiro;

    public Partida(){
        tabuleiro = new Tabuleiro(8,8);
        inicioPartida();
    }

    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];

        for(int i = 0; i < tabuleiro.getLinhas(); i++){
            for(int j = 0; j < tabuleiro.getColunas(); j++){
                matriz[i][j] = (PecaXadrez) tabuleiro.getPeca(i,j);
            }
        }
        return matriz;
    }

    private void inicioPartida(){
        tabuleiro.atribuirPeca(new Torre(tabuleiro, Cor.BRANCA), new Posicao(0,4));
        tabuleiro.atribuirPeca(new Rei(tabuleiro, Cor.PRETA), new Posicao(3,3));
    }
}
