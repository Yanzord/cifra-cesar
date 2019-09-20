package com.yanzord.segurancainformacao.cifracesar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CifraCesar cifraCesar = new CifraCesar();
        boolean continua = true;

        while (continua) {
            System.out.println("*** Cifra de Cesar! ***");
            System.out.println("- Chave de rotacao atual: " + cifraCesar.getChaveDeRotacao());
            System.out.println("- Insira 1 para criptografar um texto;");
            System.out.println("- Insira 2 para descriptografar um texto;");
            System.out.println("- Insira 3 para alterar a chave de rotacao;");
            System.out.println("- Insira outro caractere qualquer para sair.");
            Scanner teclado = new Scanner(System.in);
            int opcao = teclado.nextInt();

            switch (opcao) {
                case 1: {
                    System.out.print("Informe o texto a ser criptografado:\n");
                    teclado.nextLine();
                    String texto = teclado.nextLine();
                    System.out.println("O texto criptografado eh:\n" + cifraCesar.criptografarTexto(texto));
                    break;
                }
                case 2: {
                    System.out.print("Informe o texto a ser descriptografado:\n");
                    teclado.nextLine();
                    String texto = teclado.nextLine();
                    System.out.println("O texto descriptografado eh:\n" + cifraCesar.descriptografarTexto(texto));
                    break;
                }
                case 3: {
                    System.out.println("Informe a nova chave de rotacao:");
                    int chaveDeRotacao = teclado.nextInt();
                    cifraCesar.setChaveDeRotacao(chaveDeRotacao);
                    break;
                }
                default: continua = false;
            }
        }
        System.exit(0);
    }
}