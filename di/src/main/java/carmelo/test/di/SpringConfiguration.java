package carmelo.test.di;


import carmelo.test.di.beans.Estudiante;
import carmelo.test.di.beans.Profesor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Carmelo Marin Abrego on 14/03/2016.
 */
@Configuration
@ComponentScan({"carmelo.test.di.beans"})
public class SpringConfiguration {

//    @Bean
//    public Profesor profesor(){
////      Constructor Injection
////      return new Profesor(estudiante());
//
////      Setter Injection
//        Profesor profesor = new Profesor();
//        profesor.setEstudiante(estudiante());
//        return profesor;
//    }
//
//    @Bean
//    public Estudiante estudiante(){
//        return new Estudiante();
//    }
}
