package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@ComponentScan
@ImportResource("classpath:security.xml")
public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
        FXMLController hello = context.getBean(HelloController.class);

        initSecurity();

        stage.setTitle("JavaFX and Spring Security");
        stage.setScene(new Scene(hello.getRoot(), 800, 600));
        stage.show();
    }

    /***
     * Iniciar seguridad MODE_GLOBAL establece un unico contexto de seguridad.
     * usemos MODE_GLOBAL solo en apliaciones no web.
     */
    public static void initSecurity() {
        SecurityContextHolder.setStrategyName("MODE_GLOBAL");
        initAnonymous();
    }

    /***
     * Agregar un usuario anonimo
     */
    public static void initAnonymous() {
        AnonymousAuthenticationToken auth = new AnonymousAuthenticationToken(
                "anonymous", "anonymous",
                AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));

        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    /***
     * cerrar la session de usuario
     */
    public static void logout(){
        SecurityContextHolder.clearContext();
        initAnonymous();
    }
}
