package br.com.rflwgnr.rest_api_spring_boot.math;

import br.com.rflwgnr.rest_api_spring_boot.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtract(Double numberOne,
                           Double numberTwo){
        return numberOne - numberTwo;
    }

    public Double multiply(Double numberOne,
                           Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double divide(Double numberOne,
                         Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double average(Double numberOne,
                          Double numberTwo,
                          Double numberThree) {
        return (numberOne + numberTwo + numberThree) / 3;
    }

    public Double sqrt(Double number) {
        return Math.sqrt(number);
    }

}
