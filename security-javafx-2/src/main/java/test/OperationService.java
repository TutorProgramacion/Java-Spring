package test;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by Carmelo Marin Abrego on 04/03/2016.
 */
public interface OperationService {

    @Secured("ROLE_ADMIN")
    double sumar(double a, double b);

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_STANDAR')")
    double multiplicar(double a, double b);

    double dividir(double a, double b);
}
