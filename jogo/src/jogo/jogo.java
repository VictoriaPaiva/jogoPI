package jogo;

import java.util.Random;
import java.util.Scanner;


public class jogo  {  
    static Scanner sc = new Scanner (System.in);
    static Random rm = new Random();
    //variaveis para renomear
    static int x, vidaUsu, vidaBoss,menu;
    static int qntDicas = 0;
    static String perg, resp, GouP,rc, respDica, nivel, nome, sexo,perg1;
    static String recompensa = "nada";
    //vetor de perguntas
    static String [] vPerguntas = new String []{"1- Funções e sua definição é:(b)"
            + " \na) Um elemento de origem se relaciona livre."
            + "\nb) Um elemento de origem que se relaciona com um único elemento."
            + "\nc) Nem todos elementos de origem tem um valor correspondente"
            + "\nd)A origem com 1 valor encontra 2 valores distintos."
            + "\ne) Apenas um único elemento de origem pode se relacionar.",
        "2- É característica de uma função:(e) " 
            + "\nd) y = 𝑥2(𝑥.𝑥)"
            + "\ne) y = 𝑥3-𝑥3+x",
        "3- Qual e o numero em dicimal que corresponde o numero 1001111001B(c) "
            + "\na) 975"
            + "\nb) 874"
            + "\nc) 633"
            + "\nd) 634"
            + "\ne) 873",
        "4- Sendo uma função de 1º grau, 9 o coeficiente angular e 15 o coeficiente linear."
            + " Qual a alternativa correta?(a) "
            + "\na) f(x)9x+15"
            + "\nb) f(x)15𝑥2+9"
            + "\nc) f(x)15x+9"
            + "\nd) f(x)15𝑥2+9𝑥"
            + "\ne) f(x)9x+15-1",
        "5- Em uma equação do segundo grau encontramos quantas raízes?(d) "
            + "\na) Entre 1 e 2"
            + "\nb) Somente 3"
            + "\nc) Somente 2"
            + "\nd) ate duas raizes"
            + "\ne) Somente 1."
            ,"6- Identifique o falso método que encontra raízes na equação de 2º grau:(b)"
            + " \na) Soma e produto"
            + "\nb) Vai e vem"
            + "\nc) Fatorar"
            + "\nd) Báskara"
            + "\ne) Isolamento",
            "7- O gráfico da função de 2º grau tem como característica:(e) "
            + "\na) Ser crescente"
            + "\nb) Ser decrescente"
            + "\nc) Cresce e decresce após o eixo"
            + "\nd) Ser fundamental o cálculo das raízes para cruzar o eixo y"
            + "\ne) A parábola depender do coeficiente",
            "8- Em um gráfico na função de segundo grau pode-se afirmar que:(c) "
            + "\na)  Conte ponto de máximo e mínimo"
            + "\nb) Tem 3 raízes"
            + "\nc) Toda parábola tem um vértice."
            + "\nd) O coeficiente c representa o vértice"
            + "\ne) Sempre cruza o eixo x",
            "9- Se f(x) = 0,25x + 30 para x = 40, qual será o valor?(a) "
            + "\na) 40"
            + "\nb) 38"
            + "\nc) 37"
            + "\nd) 35"
            + "\ne) 30",
            "10- Sobre a conectividade lógica disjunção, qual das alternativas representa seu SÍMBOLO(d) "
            + "\na) ~"
            + "\nb) -->"
            + "\nc) <-->"
            + "\nd) v"
            + "\ne) ^"};
    //vetor de valor zerado para verificar se a questão já foi escolhida
    static int[] posPergunta = new int [] {0,0,0,0,0,0,0,0,0,0};
    static String []dicas = new String []{"A alternativa 'c' está errada ","A alternativa 'c' está errada ",
        "A alternativa 'e' está errada ","A alternativa 'c' está errada ","A alternativa 'a' está errada "
            ,"A alternativa 'c' está errada ","A alternativa 'd' está errada ","A alternativa 'b' está errada ",
            "A alternativa 'c' está errada ","A alternativa 'c' está errada "
    };
     static String perguntas()
    {
        x = rm.nextInt(10);
        if(posPergunta[x] == 0)
        {
            perg = vPerguntas[x];
            posPergunta[x] = 1;
        }
        else
        {
            while(posPergunta[x] == 1)
            {
                 x = rm.nextInt(10);  
            }
            posPergunta[x] = 1;
            perg = vPerguntas[x];
        }
       
        //System.out.println(perg);
        return perg;
    }
    static boolean vivacidade()
    {
        if(vidaUsu == 0)
        {
            System.out.println("Morreu! ");
            System.exit(0);
        }
        return true;
    }
    static void dica ()
    {
        if(qntDicas>0)
        {
            System.out.println("Gostaria de usar a sua dica agora? ");
            respDica = sc.next();
            switch(respDica)
            {
                case "sim":
           
                System.out.println(dicas[x]);
                qntDicas = qntDicas -1;
                break;
                case "nao":
                    System.out.println("ok, entao apenas responda a pergunta e podera usar a dica mais"
                            + "tarde");
                break;
                default:
                    System.out.println("Digite 'sim' ou 'nao'");
                    break;
            }
        }
    }
    static void combate(int qntPerg, int vidaBoss)
    {
        System.out.println(nome + " voce tem " + vidaUsu + " vidas e " + qntDicas + " dicas");
         rc = "re";
            for(int cont = 0; cont<qntPerg; cont++)
            {
           
            rc = "nada";
            perg = perguntas();
        while(vidaUsu>0 && !rc.equalsIgnoreCase("respostaCerta") && vidaBoss>0)
        {
            System.out.println(perg);
            dica();
        resp = sc.next();
        switch(x)
        {
           
            case 0:
                if(resp.equalsIgnoreCase("b"))
                {
                    System.out.println("Resposta Certa");
                     System.out.println("Parabens!\nEscolha uma recompensa, digite'v' para ganhar uma vida "
                            + "extra ou 'd'para ganhar uma dica:  ");
                    recompensa = sc.next();
                    vidaBoss = vidaBoss -1;
                    rc = "respostaCerta";
                }
                else
                {
                    System.out.println("resposta Errada  o(╥_╥)o");
                    vidaUsu = vidaUsu - 1;
                    vivacidade();
                    rc = "respostaErrada";
                }
                break;
            case 1:
                if(resp.equalsIgnoreCase("e"))
                {
                    System.out.println("Resposta Certa");
                    System.out.println("Parabens!\nEscolha uma recompensa, digite'v' para ganhar uma vida "
                            + "extra ou 'd'para ganhar uma dica:  ");
                    recompensa = sc.next();
                    vidaBoss = vidaBoss -1;
                    rc = "respostaCerta";
                }
                else
                {
                    System.out.println("resposta Errada  o(╥_╥)o");
                    vidaUsu = vidaUsu - 1;
                    vivacidade();
                    rc = "respostaErrada";
                }
                break;
            case 2:
                if(resp.equalsIgnoreCase("c"))
                {
                    System.out.println("Resposta Certa");
                     System.out.println("Parabens!\nEscolha uma recompensa, digite'v' para ganhar uma vida "
                            + "extra ou 'd'para ganhar uma dica:  ");
                    recompensa = sc.next();
                    vidaBoss = vidaBoss -1;
                    rc = "respostaCerta";
                }
                else
                {
                    System.out.println("resposta Errada  o(╥_╥)o");
                    vidaUsu = vidaUsu - 1;
                    vivacidade();
                    rc = "respostaErrada";
                }
                break;
            case 3:
                if(resp.equalsIgnoreCase("a"))
                {
                    System.out.println("Resposta Certa");
                     System.out.println("Parabens!\nEscolha uma recompensa, digite'v' para ganhar uma vida "
                            + "extra ou 'd'para ganhar uma dica:  ");
                    recompensa = sc.next();
                    vidaBoss = vidaBoss -1;
                    rc = "respostaCerta";
                }
                else
                {
                    System.out.println("resposta Errada  o(╥_╥)o");
                    vidaUsu = vidaUsu - 1;
                    vivacidade();
                    rc = "respostaErrada";
                }
                break;
            case 4:
                if(resp.equalsIgnoreCase("d"))
                {
                    System.out.println("Resposta Certa");
                     System.out.println("Parabens!\nEscolha uma recompensa, digite'v' para ganhar uma vida "
                            + "extra ou 'd'para ganhar uma dica:  ");
                    recompensa = sc.next();
                    vidaBoss = vidaBoss -1;
                    rc = "respostaCerta";
                }
                else
                {
                    System.out.println("resposta Errada  o(╥_╥)o");
                    vidaUsu = vidaUsu - 1;
                    vivacidade();
                    rc = "respostaErrada";
                }
                break;
            case 5:
                if(resp.equalsIgnoreCase("b"))
                {
                    System.out.println("Resposta Certa");
                     System.out.println("Parabens!\nEscolha uma recompensa, digite'v' para ganhar uma vida "
                            + "extra ou 'd'para ganhar uma dica:  ");
                    recompensa = sc.next();
                    vidaBoss = vidaBoss -1;
                    rc = "respostaCerta";
                }
                else
                {
                    System.out.println("resposta Errada  o(╥_╥)o");
                    vidaUsu = vidaUsu - 1;
                    vivacidade();
                    rc = "respostaErrada";
                }
                break;
            case 6:
                if(resp.equalsIgnoreCase("e"))
                {
                    System.out.println("Resposta Certa");
                     System.out.println("Parabens!\nEscolha uma recompensa, digite'v' para ganhar uma vida "
                            + "extra ou 'd'para ganhar uma dica:  ");
                    recompensa = sc.next();
                    vidaBoss = vidaBoss -1;
                    rc = "respostaCerta";
                }
                else
                {
                    System.out.println("resposta Errada  o(╥_╥)o");
                    vidaUsu = vidaUsu - 1;
                    vivacidade();
                    rc = "respostaErrada";
                }
                break;
            case 7:
                if(resp.equalsIgnoreCase("c"))
                {
                    System.out.println("Resposta Certa");
                     System.out.println("Parabens!\nEscolha uma recompensa, digite'v' para ganhar uma vida "
                            + "extra ou 'd'para ganhar uma dica:  ");
                    recompensa = sc.next();
                    vidaBoss = vidaBoss -1;
                    rc = "respostaCerta";
                }
                else
                {
                    System.out.println("resposta Errada  o(╥_╥)o");
                    vidaUsu = vidaUsu - 1;
                    vivacidade();
                    rc = "respostaErrada";
                }
                break;
            case 8:
                if(resp.equalsIgnoreCase("a"))
                {
                    System.out.println("Resposta Certa");
                     System.out.println("Parabens!\nEscolha uma recompensa, digite'v' para ganhar uma vida "
                            + "extra ou 'd'para ganhar uma dica:  ");
                    recompensa = sc.next();
                    vidaBoss = vidaBoss -1;
                    rc = "respostaCerta";
                }
                else
                {
                    System.out.println("resposta Errada  o(╥_╥)o");
                    vidaUsu = vidaUsu - 1;
                    vivacidade();
                    rc = "respostaErrada";
                }
                break;
            case 9:
                if(resp.equalsIgnoreCase("d"))
                {
                    System.out.println("Resposta Certa");
                     System.out.println("Parabens!\nEscolha uma recompensa, digite'v' para ganhar uma vida "
                            + "extra ou 'd'para ganhar uma dica:  ");
                    recompensa = sc.next();
                    vidaBoss = vidaBoss -1;
                    rc = "respostaCerta";
                }
                else
                {
                    System.out.println("resposta Errada  o(╥_╥)o");
                    vidaUsu = vidaUsu - 1;
                    vivacidade();
                    rc = "respostaErrada";
                }
                break;
        }
        //parei aqui vendo se o usuario escolheru a recompensa vida ou dia, falta colocar para ele escolher a dica qnd quise
        switch(recompensa)
        {
            case "v":
                vidaUsu = vidaUsu +1;
                break;
            case "d":
                qntDicas = qntDicas +1;
        }
           }
       
            }
    }
    static String GouP()
    {
        if(vidaBoss == 0)
        {
            GouP = "Vani: Você....... o derrotou....., você o derrotou..... VOCÊ O DERROTOU (◕ o ◕)/ !!\n" +
"Vani: Você conseguiu "+ nome +", VOCE CONSEGUIU (◕ o ◕)/ !!\n"
                    + "Vani: Vamos sair daqui herói, seu proposito foi alcançado, você salvou Targon o(╥‿‿╥)o!!\n" +
"Vani: OLHE HEROI, o exercito de Malakaf esta perecendo... GRAÇAS A VOCÊ\n" +
"Vani: Você será lembrado como o Heroi de Targon e sua historia heroica sera passada de geração em geração\n" +
"Vani: OBRIGADA HERÓI, MUITO OBRIGADA ❀◕‿‿◕❀!!";
            for(int i = 0 ; i<10;i++)
            {
                posPergunta[i]=0;
            }
        }
        else
        {
            GouP = "Voce morreu!";
        }
       
        return GouP;
    }
    static void abadon()
    {
        System.out.println("texto antes da batalha");
        combate(1,1);
    }
    static void leyak()
    {
        System.out.println("Vani: Foi uma batalha intensa mais sua jornada esta só começando, nosso proximo objetivo esta"
                + " localizado na Caverna de Gelo, lá esta situado um dos subordinados de Malakaf.\n" +
    "Leyak, o Orc Impiedoso esteja preparado (><)/\n" +
    "\n" +
    "**Na Caverna do Medo**"
                + "Vani: Que friiiiio {{(>_<)}}\n" +
    "Vani: Um cheiro de morte esta vindo do fundo da caverna.Esta sentindo " + nome + " ? Leyak deve estar lá, tome cuidado!\n" +
    "Leyak: TOLO INSOLENTE, ARRANCAREI SEUS OSSOS E USAREI PRA ME AQUECER!!");
        combate(2,2);
    }
    static void hegrid()
    {
        System.out.println("Vani: Leyak era o subordinado de Malakaf com mais baixo nivel, e ele era visivelmente mais forte que "
                + "Abadon, porém, você foi capaz de derrota-lo, PARABENS!!\n" +
"Vani: Mas sem enrolação "+ nome +" nosso proximo objetivo esta na floresta proibida, lá é onde vivem os gigantes e onde "
                + "esta o servo mais forte de Malakaf, Hegrid, o Gigante Profano.\n" +
"\n" +
"**Na Floresta Proibida**\n" +
"Vani: Esse lugar me da calafrios {{(>_<)}}\n" +
"Vani: Sinto uma presença devastadora vindo daquela direção... " + nome + " tenha cuidado acho que é la onde Hegrid está!!"
                + "\n" +
"Hegrid: INSETO INSOLENTE, PISAREI EM VOCÊ IGUAL UMA BARATA!!!");
        combate(3,3);
    }
    static void malakaf()
    {
        System.out.println("Vani: Você derrotou Hedrid... Estou realmente impressionada (◕ o ◕)\n" +
"Vani: Hegrid por ser o servo mais leal e mais forte servo de Malakaf, foi designado a proteger o portal usado para chegar na "
                + "Fortaleza onde Malakaf de encontra.\n" +
"Vani: E como ja sabemos lá esta seu objetivo final, vamos " + nome + " Targon esta em suas mãos...\n" +
"\n" +
"**Na Fortaleza de Malakaf**\n" +
"Malakaf: Quem ousa se aproximar de mim??\n" +
"Vani: Fim da linha Malakaf, sua hora chegou\n" +
"Malakaf: Minha Hora? HAHAHAHAHA!! Então esse é Humano que se diz ser o herói de Targon\n" +
"Malakaf: Prepare-se humano, te mostrarei o terror de enfrentar o Rei Demonio");
        combate(4,4);
        System.out.println(GouP());
    }
    static int nivel()
    {
        System.out.println("Escolha o nivel de dificildade do jogo...\nDigite 'f' para facil,"
                + "'m' para medio ou 'd' para dificil ");
        nivel = sc.next();
        switch(nivel)
        {
            case "f":
                vidaUsu = 5;
                break;
            case "m":
                vidaUsu = 3;
                break;
            case "d":
                vidaUsu = 1;
                break;
            default:
                System.out.println("Digite 'f', 'm' ou 'd'");
                break;
        }
        System.out.println("===INTRODUÇÃO===\n" +
"\n" +
"\"Você é um professor de matematica que foi invocado por uma fada ancestral chamada Vani, cujo o objetivo é salvar o mundo de Targon de uma terrivel ameaça.\n" +
"O exercito de Malakaf, O rei demônio tem o proposito de destruir Targon por inteiro, Targon é um planeta prospero e fertil e possui uma ligação espiritual meuito forte com o seu planeta natal,\n" +
"a Terra, onde os danos sofridos em Targon seram espelhados diretamente ao seu planeta. Você é o heroi escolhido para salvar Targon desse desestre iminente e consequentemente salvar seu \n" +
"planeta natal, você aceita fazer parte dessa jornada?\"");
        perg1 = sc.next();
        switch(perg1)
        {
            case "sim":
                System.out.println("\"Vani: Ei! Ei! estamos proximos de HellBouncing\n" +
"**Em HellBouncing**\n" +
"Vani: Nossa que desastre deve ser obra de Abadon, O Espectro Sanguinario, prepare-se ele sera seu primeiro desafio:\n" +
"Abadon: INSETO FUTIL, VOCÊ SERÁ DESTRUIDO!!");
                break;
            case "nao":
                System.out.println("Malakaf e seu exercito destruiram Targon e consequentemente a Terra tambem foi destruida, "
                        + "você falhou em sua missão.");
                System.exit(0);
                break;
            default:
                System.out.println("Digite 'sim' ou 'nao'");
        }
        return vidaUsu;
    }
    static String nome()
    {
        System.out.println("Digite o seu nome ou como vai querer ser chamado durante o jogo: ");
        nome = sc.next();
       
        return nome;
    }
   
    static void menu()
    {
       
        while(menu!=4)
        {
            System.out.println("***********menu***********");
        System.out.println("1-Instruçoes\n2-jogo\n3-creditos\n4-Sair");
        menu = sc.nextInt();
        switch(menu)
        {
            case 1:
                System.out.println("***Instruções***\n" +
"\n" +
"O jogo se consiste em uma série de perguntas e respostas, onde será apresentado a você uma pergunta, e na mesma sera apresentadas 5 alternativas\n" +
"e apenas 1 sera a correta, para escolher a alternativa desejada basta digitar a letra onde ela se encontra.\n" +
"\n" +
"O jogo é dividido em 3 dificuldades: Fácil, Médio e Difícil\n" +
"Fácil: Jogador começa com ♥♥♥♥♥ Vidas.\n" +
"Médio: Jogador começa com ♥♥♥ Vidas.\n" +
"Difícil: Jogador começa com ♥ Vida.\n" +
"\n" +
"Ao final de cada batalha o jogador poderá escolher uma entre duas recompensas disponíveis: ♥ Vida ou ★ Dica:\n" +
"♥ Vida: Pontos de vida é a quantidade de erros possíveis que o jogador pode cometer, a cada resposta errada o jogador perde 1 ♥ Vida,\n" +
"ao chegar 0 Vidas o jogo acaba.\n" +
"★ Dica: Pontos de dica auxilia o jogador a escolher a resposta correta, se o jogador possuir Pontos de Dica, ele poderá utiliza-la a\n" +
"cada turno de sua batalha\n" +
"\n" +
"\n" +
"░░░░░░░░░░░░▄▄\n" +
"░░░░░░░░░░░█░░█\n" +
"░░░░░░░░░░░█░░█\n" +
"░░░░░░░░░░█░░░█\n" +
"░░░░░░░░░█░░░░█\n" +
"███████▄▄█░░░░░██████▄         BOA SORTE!!\n" +
"▓▓▓▓▓▓█░░░░░░░░░░░░░░█\n" +
"▓▓▓▓▓▓█░░░░░░░░░░░░░░█\n" +
"▓▓▓▓▓▓█░░░░░░░░░░░░░░█\n" +
"▓▓▓▓▓▓█░░░░░░░░░░░░░░█\n" +
"▓▓▓▓▓▓█░░░░░░░░░░░░░░█\n" +
"▓▓▓▓▓▓█████░░░░░░░░░█\n" +
"██████▀░░░░▀▀██████▀");
                break;
            case 2:
               
                nome();
                nivel();
                abadon();
                leyak();
                hegrid();
                malakaf();
               
                break;
            case 3:
                System.out.println("Creditos , quem fez o jogo e blablabla");
                break;
            case 4:
                System.exit(0);
        }
        }
    }
    public static void main(String[] args) {
        menu();
       
        System.out.println("******Perguntas******");
        System.out.println("Combate contra Abadon" );
        abadon();
        if(vidaUsu>0)
        {
           
             System.out.println("Combate contra leyak" );
            leyak();
        }
        if(vidaUsu>0)
        {
            System.out.println("Combate contra Hegrid" );
        hegrid();
        }
        if(vidaUsu>0)
        {
            System.out.println("Combate contra Malakaf" );
        malakaf();
        }
        System.out.println(GouP());
    }
}
