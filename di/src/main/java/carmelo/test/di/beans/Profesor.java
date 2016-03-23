package carmelo.test.di.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Carmelo Marin Abrego on 23/03/2016.
 */
@Component
public class Profesor {

    @Autowired
    private Estudiante estudiante;

    public Profesor() {
    }

//    @Autowired // Constructor Injection
    public Profesor(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

//    @Autowired // Setter Injection
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Soy en profesor: Juan, imparto clases al " + estudiante;
    }
}
