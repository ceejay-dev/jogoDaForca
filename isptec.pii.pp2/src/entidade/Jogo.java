package entidades;

import java.util.Scanner;
import java.util.ArrayList;

class Pontuacao {

    Jogador jogador;
    int ponto;

}

public class Jogo {

    public int pontos = 0;

    Scanner leitura = new Scanner(System.in);

    //Função para selecionar a dificuldade do jogo
    private int selecionarDiificuldade() {

        System.out.println("Escolha a dificuldade/n1-Facil/n2-Dificil");
        int dificuldade = leitura.nextInt();

        //Verifica se é um valor válido
        while ((dificuldade != 1 || dificuldade != 2) && Character.isDigit((dificuldade))) {
            System.out.println("Dificuladade invalida");
            System.out.println("Escolha a dificuldade/n1-Facil/n2-Dificil");
            dificuldade = leitura.nextInt();
        }

        return dificuldade;
    }

    //Função para mandar o aaray de palavras para o jogo
    public void iniciarJogo(Jogador jogador, ArrayList<String> lpalavrasSimples, ArrayList<String> lpalavrasDificeis) {

        if (selecionarDiificuldade() == 1) {
            comecoJogo(jogador, lpalavrasSimples);
        } else {
            comecoJogo(jogador, lpalavrasDificeis);
        }
    }

    //O nosso jogo
    private void comecoJogo(Jogador jogador, ArrayList<String> palavras) {

        int ajuda = 0;
        Scanner leitura = new Scanner(System.in);
        pontos = 0;
        int tentativas = 0;

        //Percorrendo cada palavra do array
        for (String palavra : palavras) {

            //armazenando as palavras retiradas para controlar quando está certo ou errado
            char vetor[] = controlarLetras(palavra);

            //armazenado a String com as palavras retiradas
            String aux = controlarPalavra(palavra);

            boolean auxV = true;

            tentativas = palavra.length() + 5;

            while (auxV) {
                
                System.out.println("Preencha a palavra com uma letra por vez");
                System.out.println(aux);
                
                //Thread.sleep((30000));
                
                if (ajuda == 3) {
                    
                    System.out.println("Tem ajuda, deseja usar ?");
                    String resposta = leitura.next();
                    
                    if(resposta.equalsIgnoreCase("sim"))
                        aux = ajudaPalavra(palavra, aux);
                    
                }
                char letra = leitura.next().charAt(0);

                

                //Verifica se a letra pertence ao vetor que contém as letras em falta
                if (verificar(vetor, letra)) {
                    System.out.println("Letra certa");

                    //adiciona a letra a palavra apresentada na consola
                    aux = completaLetra(palavra, aux, letra);
                } else {
                    //Jesus matriz
                    System.out.println("Letra errada");
                    tentativas--;
                }

                //Verifica se ainda exxistem letras a ser adicionadas na palavra
                auxV = controlador(vetor);

                if (tentativas == 0) {
                    break;
                }
                System.out.println(aux);

            }
            if (tentativas == 0) {
                //Aqui é trabalho do Jesus chamar a matriz
                System.out.println("Infelizmente esgotou o numero de tentativas");
                break;
            } else {
                pontos++;
            }

        }

        //Armazenado os dados do jador e os pontos 
        Pontuacao guardarPontos = new Pontuacao();
        ArrayList<Pontuacao> pontuacoes = new ArrayList<>();
        guardarPontos.jogador.nomeUsuario = jogador.nomeUsuario;
        guardarPontos.jogador.dataAniversario = jogador.dataAniversario;
        guardarPontos.ponto = pontos;

        pontuacoes.add(guardarPontos);
    }

    //aramazena as letras retirads em um vetor de carateres
    private char[] controlarLetras(String palavra) {

        if (palavra.length() == 5 || palavra.length() == 6) {
            char[] vetor = {palavra.charAt(2), palavra.charAt(4)};
            return vetor;
        } else {
            char[] vetor = {palavra.charAt(0), palavra.charAt(3), palavra.charAt(6), palavra.charAt(palavra.length() - 1)};
            return vetor;
        }
    }

    //cria uma string com as letras do vetor retiradas da string
    private String controlarPalavra(String palavra) {

        if (palavra.length() == 5 || palavra.length() == 6) {
            char[] vetor = {palavra.charAt(2), palavra.charAt(4)};
            palavra = palavra.replace(palavra.charAt(2), '_');
            palavra = palavra.replace(palavra.charAt(4), '_');

        } else {
            char[] vetor = {palavra.charAt(0), palavra.charAt(3), palavra.charAt(6), palavra.charAt(palavra.length() - 1)};
            palavra = palavra.replace(palavra.charAt(0), '_');
            palavra = palavra.replace(palavra.charAt(3), '_');
            palavra = palavra.replace(palavra.charAt(6), '_');
            palavra = palavra.replace(palavra.charAt(palavra.length() - 1), '_');

        }

        return palavra;
    }

    //adiciona a letra a palavra a ser apresentada no ecrã
    private String completaLetra(String palavra, String incompleta, char letra) {
        String aux = "";
        int i;
        for (i = 0; i != palavra.length(); i++) {
            if ((palavra.charAt(i) == letra) && incompleta.charAt(i) != palavra.charAt(i)) {
                aux += letra;
            } else {
                aux += incompleta.charAt(i);
            }
        }
        return aux;
    }

    //Verifica se a letra está no vetor de char 
    private boolean verificar(char vetor[], char letra) {

        for (int i = 0; i != vetor.length; i++) {
            if (vetor[i] == letra) {
                vetor[i] = ' ';
                return true;
            }
        }
        return false;
    }

    //Verifica se o vetor de char está vazio
    private boolean controlador(char vetor[]) {

        boolean aux = false;
        for (int i = 0; i != vetor.length; i++) {
            if (vetor[i] != ' ') {
                return true;
            }
        }
        return aux;
    }

    //função para ajudar o jogador 
    private String ajudaPalavra(String palavra, String aux) {

        String ajuda = "";
        int controlador = 0;
        for (int i = 0; i < palavra.length(); i++) {
            if (aux.charAt(i) == '_' && controlador == 0) {
                ajuda += palavra.charAt(i);
                controlador = 1;
            } else {
                ajuda += aux.charAt(i);
            }

        }

        return ajuda;
    }

}
