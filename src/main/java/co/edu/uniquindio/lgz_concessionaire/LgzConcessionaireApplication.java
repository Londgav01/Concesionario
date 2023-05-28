package co.edu.uniquindio.lgz_concessionaire;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LgzConcessionaireApplication extends Application {

    public static ConfigurableApplicationContext context;
    public static Parent rootNode;

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        context= SpringApplication.run(LgzConcessionaireApplication.class);
        FXMLLoader loader= new FXMLLoader(LgzConcessionaireApplication.class.getResource("/Login.fxml"));
        loader.setControllerFactory(context::getBean);
        Scene scene= new Scene(loader.load() ,507,523,false, SceneAntialiasing.BALANCED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
