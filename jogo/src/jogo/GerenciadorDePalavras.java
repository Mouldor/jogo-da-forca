package jogo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class GerenciadorDePalavras {

    private final String caminhoArquivo;
    private final Random random = new Random();

    //Recebe o caminho do arquivo contendo as palavras e o armazena no atributo caminhoArquivo.
    public GerenciadorDePalavras(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    //Lê todas as linhas do arquivo especificado pelo caminho.

    //Cada linha é uma palavra.

    //Se o arquivo estiver vazio, retorna null.

    //Se houver conteúdo, sorteia aleatoriamente uma palavra da lista e retorna.

    //Se ocorrer algum erro (por exemplo, o arquivo não existe), imprime a mensagem de erro e retorna null.
    
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
