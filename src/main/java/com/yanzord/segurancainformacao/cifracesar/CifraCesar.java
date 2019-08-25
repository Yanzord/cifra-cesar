package com.yanzord.segurancainformacao.cifracesar;

import java.text.Normalizer;

public class CifraCesar {

    private static final int VALOR_DE_Z_TABELA_ASCII = 90;
    private static final int TAMANHO_ALFABETO = 26;
    private static final int VALOR_DE_A_TABELA_ASCII = 65;
    private int chaveDeRotacao = 3;

    public String criptografarTexto(String texto) {
        String textoSemCaracteresEspeciais = retirarCaracteresEspeciais(texto);
        textoSemCaracteresEspeciais = textoSemCaracteresEspeciais.toUpperCase();
        StringBuilder textoCifrado = new StringBuilder();

        for (Character letra : textoSemCaracteresEspeciais.toCharArray()) {
            textoCifrado.append(criptografarLetra(letra));
        }
        return textoCifrado.toString();
    }

    public String descriptografarTexto(String textoCriptografado) {
        String textoSemCaracteresEspeciais = retirarCaracteresEspeciais(textoCriptografado);
        textoSemCaracteresEspeciais = textoSemCaracteresEspeciais.toUpperCase();
        StringBuilder textoDecifrado = new StringBuilder();

        for (Character letra : textoSemCaracteresEspeciais.toCharArray()) {
            textoDecifrado.append(descriptografarLetra(letra));
        }
        return textoDecifrado.toString();
    }

    public int getChaveDeRotacao() {
        return chaveDeRotacao;
    }

    public void setChaveDeRotacao(int chaveDeRotacao) {
        this.chaveDeRotacao = chaveDeRotacao;
    }

    private char criptografarLetra(Character letra) {
        int letraASCII = letra.hashCode();
        int letraCifradaASCII = letraASCII + chaveDeRotacao;

        return (char)verificarPosicaoLetraASCII(letraCifradaASCII);
    }

    private char descriptografarLetra(Character letra) {
        int letraASCII = letra.hashCode();
        int letraDecifradaASCII = letraASCII - chaveDeRotacao;

        return (char)verificarPosicaoLetraASCII(letraDecifradaASCII);
    }

    private String retirarCaracteresEspeciais(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[^a-zA-Z]+", "");
        return texto;
    }

    private int verificarPosicaoLetraASCII(int letraASCII) {
        if (letraASCII > VALOR_DE_Z_TABELA_ASCII) {
            letraASCII -= TAMANHO_ALFABETO;
        }
        if (letraASCII < VALOR_DE_A_TABELA_ASCII) {
            letraASCII += TAMANHO_ALFABETO;
        }
        return letraASCII;
    }
}