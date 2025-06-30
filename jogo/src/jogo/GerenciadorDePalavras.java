package jogo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class GerenciadorDePalavras {

    private final String caminhoArquivo;
    private final Random random = new Random();

    public GerenciadorDePalavras(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public String sortearPalavra() {
        try {
            List<String> palavras = Files.readAllLines(Paths.get(caminhoArquivo));
            if (palavras.isEmpty()) return null;
            return palavras.get(random.nextInt(palavras.size())).trim();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }
}
