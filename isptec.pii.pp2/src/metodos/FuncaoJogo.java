package metodos;

import java.util.Scanner;
import entidade.Jogo;

//Classe com os métodos correspondentes à entidade jogo
public class FuncaoJogo {
    
    //Método que permite administrador adicionar palavras fáceis ou difícies
    public void adicionarPalavras(int numero) {
        Jogo game = new Jogo();
        Scanner read = new Scanner(System.in);
        //Adicionando palavras fáceis
        if (numero == 1) {
            System.out.println("Insira a palavra: ");
            String facil = read.next();
            int verif = 0;
            String wordLower = facil.toLowerCase();
            //Validando se cada caracter da palavra é uma letra
            for (int i = 0; i < facil.length(); i++) {
                if ((wordLower.charAt(i) >= 'a') && (wordLower.charAt(i) <= 'z')) {
                    verif++;
                }
            }

            if (verif == facil.length()) {
                game.palavrasFaceis.add(wordLower);

                System.out.println("Palavra adicionada com sucesso!!");
            } else {
                System.out.println("ERRO! Adição de palavra inválida.");
            }
            
            //Adicionando palavras difícies
        } else if (numero == 2) {
            System.out.println("Insira a palavra: ");
            String dificil = read.next();
            int verif = 0;
            String wordLower = dificil.toLowerCase();
            
            //Validando se cada caracter da palavra é uma letra
            for (int i = 0; i < dificil.length(); i++) {
                if ((wordLower.charAt(i) >= 'a') && (wordLower.charAt(i) <= 'z')) {
                    verif++;
                }
            }

            if (verif == dificil.length()) {
                game.palavrasFaceis.add(wordLower);

                System.out.println("Palavra adicionada com sucesso!!");
            } else {
                System.out.println("ERRO! Adição de palavra inválida.");
            }
        } else {
            System.out.println("Opção inválida !");
        }
    }

}
