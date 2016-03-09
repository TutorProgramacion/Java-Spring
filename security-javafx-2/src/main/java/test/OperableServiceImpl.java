package test;

import org.springframework.stereotype.Component;

/**
 * Created by Carmelo Marin Abrego on 04/03/2016.
 */
@Component
public class OperableServiceImpl implements OperationService {

    @Override
    public double sumar(double a, double b) {
        return a + b;
    }

    @Override
    public double multiplicar(double a, double b) {
        return a * b;
    }

    @Override
    public double dividir(double a, double b) {
        return a / b;
    }
}
