package pieces;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {
    public Torre(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString(){
        return "♖";
    }

    @Override
    public Boolean[][] movimentosPossiveis() {
        Boolean[][] matriz = new Boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao posicao = new Posicao(0, 0);

        percorrerPosicoesAcima(matriz);
        percorrerPosicoesEsquerda(matriz);
        percorrerPosicoesDireita(matriz);
        percorrerPosicoesAbaixo(matriz);

        return matriz;
    }

    private Boolean[][] percorrerPosicoesAcima(Boolean[][] matriz){
        posicao.definirValor(this.posicao.getLinha() - 1, this.posicao.getColuna());
        while(getTabuleiro().posicaoExistente(posicao) && !getTabuleiro().existeUmaPeca(posicao)){
            //Peça poderá ser movida para esta posição
            matriz[posicao.getLinha()][posicao.getColuna()] = true;
            posicao.setLinha(posicao.getLinha() - 1);
        }

        if(getTabuleiro().posicaoExistente(posicao) && existePecaAdversaria(posicao)){
            matriz[posicao.getLinha()][posicao.getColuna()] = true;
        }
        return matriz;
    }

    private Boolean[][] percorrerPosicoesEsquerda(Boolean[][] matriz){
        posicao.definirValor(this.posicao.getLinha(), this.posicao.getColuna() - 1);
        while(getTabuleiro().posicaoExistente(posicao) && !getTabuleiro().existeUmaPeca(posicao)){
            //Peça poderá ser movida para esta posição
            matriz[posicao.getLinha()][posicao.getColuna()] = true;
            posicao.setColuna(posicao.getColuna() - 1);
        }

        if(getTabuleiro().posicaoExistente(posicao) && existePecaAdversaria(posicao)){
            matriz[posicao.getLinha()][posicao.getColuna()] = true;
        }
        return matriz;
    }

    private Boolean[][] percorrerPosicoesDireita(Boolean[][] matriz){
        posicao.definirValor(this.posicao.getLinha(), this.posicao.getColuna() + 1);
        while(getTabuleiro().posicaoExistente(posicao) && !getTabuleiro().existeUmaPeca(posicao)){
            //Peça poderá ser movida para esta posição
            matriz[posicao.getLinha()][posicao.getColuna()] = true;
            posicao.setColuna(posicao.getColuna() + 1);
        }

        if(getTabuleiro().posicaoExistente(posicao) && existePecaAdversaria(posicao)){
            matriz[posicao.getLinha()][posicao.getColuna()] = true;
        }
        return matriz;
    }
    private Boolean[][] percorrerPosicoesAbaixo(Boolean[][] matriz){
        posicao.definirValor(this.posicao.getLinha() + 1, this.posicao.getColuna());
        while(getTabuleiro().posicaoExistente(posicao) && !getTabuleiro().existeUmaPeca(posicao)){
            //Peça poderá ser movida para esta posição
            matriz[posicao.getLinha()][posicao.getColuna()] = true;
            posicao.setLinha(posicao.getLinha() + 1);
        }

        if(getTabuleiro().posicaoExistente(posicao) && existePecaAdversaria(posicao)){
            matriz[posicao.getLinha()][posicao.getColuna()] = true;
        }
        return matriz;
    }
}
