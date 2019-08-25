package com.yanzord.segurancainformacao.cifracesar;

import java.text.Normalizer;

public class CifraCesar {

    private static final int CHAVE_DA_CRIPTOGRAFIA = 3;
    private static final int VALOR_DE_Z_TABELA_ASCII = 90;
    private static final int TAMANHO_ALFABETO = 26;
    private static final int VALOR_DE_A_TABELA_ASCII = 65;

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

    private char criptografarLetra(Character letra) {
        int letraASCII = letra.hashCode();
        int letraCifradaASCII = letraASCII + CHAVE_DA_CRIPTOGRAFIA;

        if (letraCifradaASCII > VALOR_DE_Z_TABELA_ASCII) {
            letraCifradaASCII -= TAMANHO_ALFABETO;
        }

        return (char)letraCifradaASCII;
    }

    private char descriptografarLetra(Character letra) {
        int letraASCII = letra.hashCode();
        int letraDecifradaASCII = letraASCII - CHAVE_DA_CRIPTOGRAFIA;

        if (letraDecifradaASCII < VALOR_DE_A_TABELA_ASCII) {
            letraDecifradaASCII += TAMANHO_ALFABETO;
        }

        return (char)letraDecifradaASCII;
    }

    private String retirarCaracteresEspeciais(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[^a-zA-Z]+", "");
        return texto;
    }
}
