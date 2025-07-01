package jogo;

    //Instancia um novo objeto Partida — ou seja, cria uma nova sessão do jogo.

	//Chama o método iniciar() dessa partida — é aí que o jogo realmente começa.
public class JogoDaForca {

    public static void main(String[] args) {
        Partida partida = new Partida();
        partida.iniciar();
    }
}
