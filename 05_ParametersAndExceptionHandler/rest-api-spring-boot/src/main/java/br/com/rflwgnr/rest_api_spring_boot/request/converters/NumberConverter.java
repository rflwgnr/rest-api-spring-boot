package br.com.rflwgnr.rest_api_spring_boot.request.converters;

import br.com.rflwgnr.rest_api_spring_boot.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) throws IllegalArgumentException {

        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", "."); // R$ 5,00 USD 5.00
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", "."); // R$ 5,00 USD 5.00
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}