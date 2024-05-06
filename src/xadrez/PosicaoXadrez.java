package xadrez;

import tabuleiro.Posicao;
import xadrez.exceptions.XadrezException;

public class PosicaoXadrez {
    private int linha;
    private char coluna;

    public PosicaoXadrez(int linha, char coluna) {
        if(linha > 8 || linha < 1 || coluna < 'a'|| coluna > 'h')
            throw new XadrezException("O valor da linha deve ser entre 1 e 8 e o valor da coluna entre A e H");
        this.linha = linha;
        this.coluna = coluna;
    }
    public int getLinha() {
        return linha;
    }

    public char getColuna() {
        return coluna;
    }
    protected Posicao paraPosicao(){
        return new Posicao(8 - linha, coluna - 'a');
    }

    protected static PosicaoXadrez aPartirDaPosicao(Posicao posicao){
        return new PosicaoXadrez((8 - posicao.getLinha()), (char)('a' - posicao.getColuna()));
    }

    @Override
    public String toString(){
        return "" + coluna + linha;
    }
}
