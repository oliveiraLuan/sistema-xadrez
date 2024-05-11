package tabuleiro;

import tabuleiro.exceptions.TabuleiroException;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.exceptions.XadrezException;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas){
        if(linhas < 1 || colunas < 1){
            throw new TabuleiroException("O tamanho do tabuleiro deve ser no mínimo de 1 linha e 1 coluna.");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca getPeca(int linha, int coluna){
        if(!posicaoExistente(linha, coluna)){
            throw new TabuleiroException("Posição de peça inexistente.");
        }
        return pecas[linha][coluna];
    }
    public Peca getPeca(Posicao posicao){
        if(!posicaoExistente(posicao)){
            throw new TabuleiroException("Posição de peça inexistente.");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void atribuirPeca(Peca peca, Posicao posicao){
        if(!pecaExistente(peca)){
            throw new TabuleiroException("Não há uma peça nessa posição.");
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    public Peca removerPeca(Posicao posicao){
        if(!posicaoExistente(posicao)){
            throw new TabuleiroException("Posição de peça inexistente.");
        }
        if(posicao == null){
            return null;
        }
        Peca peca = getPeca(posicao);
        peca.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return peca;
    }

    public PecaXadrez moverPeca(PosicaoXadrez origem, PosicaoXadrez destino){
        Posicao posicaoOrigem = new Posicao(origem.getLinha(), origem.getColuna());
        Posicao posicaoDestino = new Posicao(origem.getLinha(), origem.getColuna());
        validarMovimento(posicaoOrigem);
        Peca pecaCapturada = realizarMovimento(posicaoOrigem, posicaoDestino);
        return (PecaXadrez) pecaCapturada;
    }

    public void validarMovimento(Posicao origem){
        if(!posicaoExistente(origem)){
            throw new XadrezException("Peça inexistente na posição informada.");
        }
    }

    public PecaXadrez realizarMovimento(Posicao origem, Posicao destino){
        Peca pecaMovida = removerPeca(origem)
        Peca pecaCapturada = removerPeca(destino);
        atribuirPeca(pecaMovida, destino);
        return (PecaXadrez) pecaCapturada;
    }

    private Boolean posicaoExistente(int linha, int coluna){
        return linha >= 0 && linha < linhas && coluna >=0 && coluna < colunas;
    }
    public Boolean posicaoExistente(Posicao posicao){
        return posicaoExistente(posicao.getLinha(), posicao.getColuna());
    }

    public Boolean pecaExistente(Peca peca){
        return null != peca;
    }
}
