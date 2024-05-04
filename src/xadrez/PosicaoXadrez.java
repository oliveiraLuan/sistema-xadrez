package xadrez;

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
}
