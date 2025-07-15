package br.com.rflwgnr.rest_api_spring_boot.controllers;

import br.com.rflwgnr.rest_api_spring_boot.exception.UnsupportedMathOperationException;
import br.com.rflwgnr.rest_api_spring_boot.math.SimpleMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.rflwgnr.rest_api_spring_boot.request.converters.NumberConverter.convertToDouble;
import static br.com.rflwgnr.rest_api_spring_boot.request.converters.NumberConverter.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

    SimpleMath sm = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return sm.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/subtract/{numberOne}/{numberTwo}")
    public Double subtract(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return sm.subtract(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/multiply/{numberOne}/{numberTwo}")
    public Double multiply(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return sm.multiply(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/divide/{numberOne}/{numberTwo}")
    public Double divide(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return sm.divide(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}/{numberThree}")
    public Double average(@PathVariable("numberOne") String numberOne,
                          @PathVariable("numberTwo") String numberTwo,
                          @PathVariable("numberThree") String numberThree) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo) || !isNumeric(numberThree)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return sm.average(convertToDouble(numberOne), convertToDouble(numberTwo), convertToDouble(numberThree));
    }

    @RequestMapping("/sqrt/{number}")
    public Double sqrt(@PathVariable("number") String number) throws Exception {
        if(!isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return sm.sqrt(convertToDouble(number));
    }

}
