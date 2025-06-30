package jogo;

import java.util.*;

public class Partida {

    private final Scanner scanner = new Scanner(System.in);
    private final GerenciadorDePalavras gerenciador = new GerenciadorDePalavras("C:\\Users\\Usuário\\eclipse-workspace\\jogo\\src\\jogo\\palavras_jogo_forca.txt");

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            String palavra = gerenciador.sortearPalavra();

            if (palavra == null) {
                System.out.println("Erro ao carregar a palavra.");
                break;
            }

            ForcaLetras jogo = new ForcaLetras(palavra);
            int tentativasRestantes = 6;
            List<Character> letrasErradas = new ArrayList<>();
            Set<Character> letrasTentadas = new HashSet<>();

            System.out.println("\n Novo jogo iniciado!");
            System.out.println("A palavra tem " + palavra.length() + " letras.");
            System.out.println(jogo.mostrarLetras());

            while (!jogo.estaCompleta() && tentativasRestantes > 0) {
                System.out.print("\nDigite uma letra: ");
                String entrada = scanner.nextLine().toLowerCase();

                if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                    System.out.println("Digite apenas uma letra.");
                    continue;
                }

                char letra = entrada.charAt(0);

                if (letrasTentadas.contains(letra)) {
                    System.out.println("Letra já tentada.");
                    continue;
                }

                letrasTentadas.add(letra);
                boolean acertou = jogo.tentarLetra(letra);

                if (acertou) {
                    System.out.println(" Letra correta!");
                } else {
                    letrasErradas.add(letra);
                    tentativasRestantes--;
                    System.out.println(" Letra errada. Tentativas restantes: " + tentativasRestantes);
                }

                System.out.println("Palavra: " + jogo.mostrarLetras());

                if (!letrasErradas.isEmpty()) {
                    System.out.print("Letras erradas: ");
                    for (char errada : letrasErradas) {
                        System.out.print(errada + " ");
                    }
                    System.out.println();
                }
            }

            if (jogo.estaCompleta()) {
                System.out.println("\n Vitoria! Palavra: " + palavra);
            } else {
                System.out.println("\n Derrota! A palavra era: " + palavra);
            }

            System.out.print("\nDeseja jogar novamente? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            continuar = resposta.equals("s") || resposta.equals("sim");
        }

        System.out.println(" Obrigado por jogar!");
        scanner.close();
    }
}
