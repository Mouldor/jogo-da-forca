package jogo;

import java.util.Arrays;

public class ForcaLetras {

    private final String palavraOriginal;
    private final char[] letrasDescobertas;

    public ForcaLetras(String palavra) {
        this.palavraOriginal = palavra;
        this.letrasDescobertas = new char[palavra.length()];
        Arrays.fill(this.letrasDescobertas, '_');
    }

    public String mostrarLetras() {
        StringBuilder sb = new StringBuilder();
        for (char c : letrasDescobertas) {
            sb.append(c).append(' ');
        }
        return sb.toString().trim();
    }

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

    public boolean estaCompleta() {
        for (char c : letrasDescobertas) {
            if (c == '_') return false;
        }
        return true;
    }
}
