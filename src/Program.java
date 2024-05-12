import xadrez.Partida;
import xadrez.PosicaoXadrez;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Partida partida = new Partida();
        Scanner scanner = new Scanner(System.in);

        while(true){
            Interface.imprimirTabuleiro(partida.getPecas());
            System.out.println();

            System.out.print("Origem: ");
            PosicaoXadrez origem = Interface.lerPosicaoXadrez(scanner);
            System.out.print("Destino: ");
            PosicaoXadrez destino = Interface.lerPosicaoXadrez(scanner);

            partida.moverPeca(origem, destino);
        }

    }
}