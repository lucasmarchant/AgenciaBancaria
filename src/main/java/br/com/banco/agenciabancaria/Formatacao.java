package br.com.banco.agenciabancaria;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Formatacao {

    static NumberFormat formatandoValores = new DecimalFormat(" R$#,##0.00");

    public static String conversaoDecimalPraTexto (Double valor ) {
        return formatandoValores.format(valor);
    }


}
