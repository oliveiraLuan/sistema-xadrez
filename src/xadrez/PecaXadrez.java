package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class PecaXadrez extends Peca {
    private Cor cor;
    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }
    public Cor getCor(){
        return cor;
    }

    protected Boolean existePecaAdversaria(Posicao posicao){
        PecaXadrez outraPeca = (PecaXadrez) getTabuleiro().getPeca(posicao);
        return outraPeca != null && this.cor != outraPeca.getCor();
    }
}
