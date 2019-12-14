package boot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Scene HOME;
    private static Scene LISTCARS;

    private static Stage currentScreen;

    @Override
    public void start(Stage primaryStage) throws Exception{
        currentScreen = primaryStage;
        primaryStage.setTitle("Simple Car Management");
        primaryStage.setResizable(false);

        Parent home = FXMLLoader.load(getClass().getResource("../views/home/home.fxml"));
        HOME = new Scene(home);

        Parent ListCars = FXMLLoader.load(getClass().getResource("../views/listCars/listCars.fxml"));
        LISTCARS = new Scene(ListCars);

        changeScreen("home");
    }

    public static void changeScreen(String viewName){
        currentScreen.close();
        switch (viewName.toLowerCase()){
            case "home":
                currentScreen.setScene(HOME);
                break;
            case "listcars":
                currentScreen.setScene(LISTCARS);
                break;
        }

        currentScreen.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
