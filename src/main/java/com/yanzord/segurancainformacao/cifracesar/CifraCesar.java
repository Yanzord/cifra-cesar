package com.yanzord.segurancainformacao.cifracesar;

import java.text.Normalizer;

public class CifraCesar {


    public String criptografarTexto(String texto) {

        String textoSemCaracteresEspeciais = retirarCaracteresEspeciais(texto);
        textoSemCaracteresEspeciais = textoSemCaracteresEspeciais.toUpperCase();
        StringBuilder textoCesar = new StringBuilder();
        
        for(int letra=0; letra < textoSemCaracteresEspeciais.length(); letra++) {
            int letraCifradaASCII = ((int) textoSemCaracteresEspeciais.charAt(letra)) + 3;

            if (((int) textoSemCaracteresEspeciais.charAt(letra) + 3) > 90) {
                letraCifradaASCII -= 26;
            } else if (((int) textoSemCaracteresEspeciais.charAt(letra) + 3) < 65) {
                letraCifradaASCII += 26;
            }

            textoCesar.append((char) letraCifradaASCII);
        }        

        return textoCesar.toString();
    }

    private String retirarCaracteresEspeciais(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[^a-zA-Z]+", "");
        return texto;
    }
}
