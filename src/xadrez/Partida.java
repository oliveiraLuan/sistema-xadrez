package xadrez;

import pieces.Rei;
import pieces.Torre;
import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.exceptions.XadrezException;

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

    public PecaXadrez moverPeca(PosicaoXadrez origem, PosicaoXadrez destino){
        Posicao posicaoOrigem = origem.paraPosicao();
        Posicao posicaoDestino = destino.paraPosicao();
        validarMovimento(posicaoOrigem);
        validarPosicaoDestino(posicaoOrigem, posicaoDestino);
        Peca pecaCapturada = realizarMovimento(posicaoOrigem, posicaoDestino);
        return (PecaXadrez) pecaCapturada;
    }

    private void validarPosicaoDestino(Posicao posicaoOrigem, Posicao posicaoDestino) {
        if(!tabuleiro.getPeca(posicaoOrigem).movimentoPossivel(posicaoDestino)){
            throw new XadrezException("A peça escolhida não pode ser movida para posição de destino");
        }
    }

    public void validarMovimento(Posicao origem){
        if(!tabuleiro.posicaoExistente(origem)){
            throw new XadrezException("Peça inexistente na posição informada.");
        }
        if(!tabuleiro.getPeca(origem).existeAlgumMovimentoPossivel()){
            throw new XadrezException("Não existe movimento possível para peça escolhida.");
        }
    }

    public PecaXadrez realizarMovimento(Posicao origem, Posicao destino){
        Peca pecaMovida = tabuleiro.removerPeca(origem);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);
        tabuleiro.atribuirPeca(pecaMovida, destino);
        return (PecaXadrez) pecaCapturada;
    }
}
