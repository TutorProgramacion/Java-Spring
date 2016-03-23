package carmelo.test.di;

import carmelo.test.di.beans.Profesor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Carmelo Marin Abrego on 14/03/2016.
 */
public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SpringConfiguration.class);
        ctx.refresh();

        Profesor profesor = ctx.getBean(Profesor.class);
        System.out.println(profesor);
    }
}
