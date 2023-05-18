package jogo;

import entidade.*;
import java.util.Scanner;
import metodos.*;

public class Main {

    public static void main(String[] args) {
        //Instância dos objectos necessários para a função principal
        FuncaoJogador metodo1 = new FuncaoJogador();
        FuncaoJogo metodo2 = new FuncaoJogo();
        Jogador player = new Jogador();
        Jogo game = new Jogo();
        Scanner read = new Scanner(System.in);
        int controle = 0, controle1 = 0;

        do {
            //menu
            System.out.println("=====================================================================================================================\n");
            System.out.println("BEM VINDO AO JOGO DA FORCA - Jogo\n EScolha a sua opção: \n");
            System.out.println("[1] - Jogador\n[2] - Administrador\n[3] - Iniciar jogo\n[4] - Sair\n");
            System.out.println("=====================================================================================================================\n");
            controle = read.nextInt();

            switch (controle) {
                case 1: {
                    System.out.println("BEM VINDO JOGADOR!!\n Faça o seu cadastro.\n");
                    System.out.println("Digite o seu nome: ");
                    read.nextLine();
                    
                    //Limpando o buffer
                    player.nome = read.nextLine();
                    
                    System.out.println("Dia, Mês e Ano: ");
                    player.data.dia = read.nextInt();
                    player.data.mes = read.nextInt();
                    player.data.ano = read.nextInt();
                    
                    metodo1.cadastrarJogador(player);
                    break;
                }

                case 2: {
                OUTER:
                do {
                    System.out.println("[1] - Adicionar palavras \n[2] - Tempo de respota\n[3] - Sair\n");
                    controle1 = read.nextInt();
                    switch (controle1) {
                        case 1:
                            System.out.println("Escolha o nível de perguntas que pretende adicionar: ");
                            System.out.println("[1] - Fácil\n[2] - Difícil\n[3] - Sair");
                            int level = read.nextInt();
                            metodo2.adicionarPalavras(level);
                            break;
                    
                        case 2:
                            //Chamada da função que calcula o tempo de resposta
                            break;
                            
                        case 3:
                            System.out.println("Será redirecionado para o menu principal.");
                            break OUTER;
                            
                        default:
                            System.out.println("Opção inválida!!");
                            break;
                    }
                } while (controle1!=3);
                    break;
                }

                case 3: {

                    break;
                }

                case 4: {

                    break;
                }

                default: {
                    System.out.println("Opção Inválida!");
                    break;
                }
            }

        } while (controle != 4);

    }
}
