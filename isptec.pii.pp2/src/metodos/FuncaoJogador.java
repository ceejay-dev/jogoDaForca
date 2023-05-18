package metodos;
import entidade.*;

//Classe com todos métodos correspondentes à entidade jogador
public class FuncaoJogador {

    //Método para validar a data inserida pelo jogador
    public boolean validarData(int dia, int mes, int ano) {
        boolean anoBissexto = false;
        boolean diaValido = false;
        boolean mesValido = false;

        boolean validado = false;

            //Verficando se o ano é válido ou não
            if (ano >= 1) {    
                //Verficando se o ano é bissexto ou não
                if (((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0)) {
                    anoBissexto = true;
                }
            } else {
                return validado;
            }

            int numDias = 0;

            //Validação do mês inserido
            if ((mes >= 1) && (mes <= 12)) {
                mesValido = true;

                //Atribuição do número dias em função do ano(bissexto ou não) e o mês
                if (mes == 2) {
                    if (anoBissexto) {
                        numDias = 29;
                    } else {
                        numDias = 28;
                    }
                } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    numDias = 30;
                } else {
                    numDias = 31;
                }

                if ((dia >= 1) && (dia <= numDias)) {
                    diaValido = true;
                }
            }

        //Validação do ano inserido
        validado = (diaValido) && (mesValido);

        return validado;
    }

    //Função para validar o nome do jogador (protótipo - sujeito a alterações)
    public boolean validarNome(String nome) {
        int verif = 0;
        boolean validado = false;
        if (nome.length() > 0) {
            for (int i = 0; i < nome.length(); i++) {
                if ((nome.toLowerCase().charAt(i) >= 'a') && ((nome.toLowerCase().charAt(i) <= 'z'))) {
                    verif++;
                } else {
                    break;
                }
            }

            if (verif == nome.length()) {
                validado = true;
            }
        }
        return validado;
    }

    //Método para registrar jogador
    public void cadastrarJogador(Jogador player) {
        Jogo game = new Jogo();
        
        //validacao da data e do nome inserido
        if ((validarData(player.data.dia, player.data.mes, player.data.ano)) && (validarNome(player.nome))) {
            //Adição de jogadores na lista caso data seja válida
            game.jogadores.add(player);
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.out.println("Cadastro negado! Dados inseridos inválidos.");
        }
    }
}
