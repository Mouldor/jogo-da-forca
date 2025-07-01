package jogo;

import java.util.*;

public class Partida {

    private final Scanner scanner = new Scanner(System.in);
    private final GerenciadorDePalavras gerenciador = new GerenciadorDePalavras("C:\\Users\\Usuário\\eclipse-workspace\\jogo\\src\\jogo\\palavras_jogo_forca.txt");
    // metodo publico que permite que o jogo continue enquanto o jogador quiser
	// jogar novamente
    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            //sorteia uma palavra
            String palavra = gerenciador.sortearPalavra();

            if (palavra == null) {
                //tratamento caso o arquivo esteja vazio
                System.out.println("Erro ao carregar a palavra.");
                break;
            }
            // inicia o jogo com 6 tentativas, inicializa a lista de letras erradas e acertadas
            ForcaLetras jogo = new ForcaLetras(palavra);
            int tentativasRestantes = 6;
            List<Character> letrasErradas = new ArrayList<>();
            Set<Character> letrasTentadas = new HashSet<>();
            
            //Exibe a quantidade de letras da palavra e o estado inicial (só com _).
            System.out.println("\n Novo jogo iniciado!");
            System.out.println("A palavra tem " + palavra.length() + " letras.");
            System.out.println(jogo.mostrarLetras());

            // continua o jogo ate a palavra ser completamente adivinhada, ou as tentativas acabarem.
            while (!jogo.estaCompleta() && tentativasRestantes > 0) {
                System.out.print("\nDigite uma letra: ");
                String entrada = scanner.nextLine().toLowerCase();

                // tratamento caso o jogador digite mais de uma letra ou algo que nao seja letra
                if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                    System.out.println("Digite apenas uma letra.");
                    continue;
                }

                char letra = entrada.charAt(0);

                // caso o jogador ja tenha testado a letra
                if (letrasTentadas.contains(letra)) {
                    System.out.println("Letra já tentada.");
                    continue;
                }

                // caso o jogador tenha acertado a letra, adiciona a letra para o array letrasTentadas e printa Letra correta
                letrasTentadas.add(letra);
                boolean acertou = jogo.tentarLetra(letra);

                if (acertou) {
                    System.out.println(" Letra correta!");
                 // caso tenha errado adiciona ao array letrasErradas diminui o numero de tentativas restantes e printa o numero de tentativas e que a letra esta errada
                } else {
                    letrasErradas.add(letra);
                    tentativasRestantes--;
                    System.out.println(" Letra errada. Tentativas restantes: " + tentativasRestantes);
                }
                // printa a palavra com as letras faltando
                System.out.println("Palavra: " + jogo.mostrarLetras());

                if (!letrasErradas.isEmpty()) {
                    System.out.print("Letras erradas: ");
                    for (char errada : letrasErradas) {
                        System.out.print(errada + " ");
                    }
                    System.out.println();
                }
            }

            // caso a palavra esteja completa ou tenha acabado as tentativas ele printa uma das possibilidades
            if (jogo.estaCompleta()) {
                System.out.println("\n Vitoria! Palavra: " + palavra);
            } else {
                System.out.println("\n Derrota! A palavra era: " + palavra);
            }
            //Opcao caso o jogador queira jogar novamente!
            System.out.print("\nDeseja jogar novamente? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            continuar = resposta.equals("s") || resposta.equals("sim");
        }

        System.out.println(" Obrigado por jogar!");
        scanner.close();
    }
}
