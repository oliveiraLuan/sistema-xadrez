import xadrez.Partida;

public class Program {
    public static void main(String[] args) {
        Partida partida = new Partida();
        Interface.imprimirTabuleiro(partida.getPecas());
    }
}