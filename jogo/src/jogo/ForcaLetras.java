package jogo;

import java.util.Arrays;

    
public class ForcaLetras {

    private final String palavraOriginal;
    private final char[] letrasDescobertas;
    // Inicializa o jogo com a palavra que o jogador deve adivinhar.
	// Cria um array com o mesmo número de posições que a palavra, preenchendo-o com
	// '_' para representar letras ainda não adivinhadas.
    public ForcaLetras(String palavra) {
        this.palavraOriginal = palavra;
        this.letrasDescobertas = new char[palavra.length()];
        Arrays.fill(this.letrasDescobertas, '_');
    }
    // Retorna uma representação visual da palavra atual, com as letras descobertas
	// no lugar correto e os caracteres não descobertos como '_'.
    public String mostrarLetras() {
        StringBuilder sb = new StringBuilder();
        for (char c : letrasDescobertas) {
            sb.append(c).append(' ');
        }
        return sb.toString().trim();
    }
    // Verifica se a letra digitada pelo jogador está presente na palavra.
	// Se estiver, ela é revelada na posição correspondente dentro de
	// letrasDescobertas.
	// Retorna true se houve pelo menos um acerto, senão false
    public boolean tentarLetra(char letra) {
        boolean acertou = false;
        for (int i = 0; i < palavraOriginal.length(); i++) {
            if (Character.toLowerCase(palavraOriginal.charAt(i)) == Character.toLowerCase(letra)) {
                letrasDescobertas[i] = palavraOriginal.charAt(i);
                acertou = true;
            }
        }
        return acertou;
    }
    // Verifica se o jogador já descobriu todas as letras da palavra.

	// Retorna true se sim, ou false se ainda existem letras ocultas.
    public boolean estaCompleta() {
        for (char c : letrasDescobertas) {
            if (c == '_') return false;
        }
        return true;
    }
}
