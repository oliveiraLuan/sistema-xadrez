import xadrez.Partida;
import xadrez.PosicaoXadrez;
import xadrez.exceptions.XadrezException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Partida partida = new Partida();
        Scanner scanner = new Scanner(System.in);

        while(true){
            try{
                Interface.limparTela();
                Interface.imprimirTabuleiro(partida.getPecas());
                System.out.println();

                System.out.print("Origem: ");
                PosicaoXadrez origem = Interface.lerPosicaoXadrez(scanner);
                System.out.print("Destino: ");
                PosicaoXadrez destino = Interface.lerPosicaoXadrez(scanner);

                partida.moverPeca(origem, destino);
            } catch (XadrezException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

    }
}