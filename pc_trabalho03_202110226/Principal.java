import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.TelaController;

/* ***************************************************************
* Autor:Ana Beatriz Silva e Silva 
* Matricula: 202110226
* Inicio: 11/04/2023
* Ultima alteracao: 22/04/2023
* Nome: Arvore genealogica com Threads
* Funcao:  Esse programa simula dois trens que devem compartilhar duas regioes aonde apenas um pode passar,
  eles devem parar assim que um outro entre nessa regiao para que nao batam. Para isso usaremos explicita alternancia.
*************************************************************** */

public class Principal extends Application {

  public static Parent root;
  public static Stage stage = new Stage();

  @Override
  public void start(Stage stage) throws Exception {
    root = FXMLLoader.load(getClass().getResource("/view/tela.fxml"));
    Scene scene = new Scene(root);
    Principal.stage.setTitle("Simulacao");
    Principal.stage.setScene(scene);
    Principal.stage.setResizable(false);
    Principal.stage.sizeToScene();
    Principal.stage.centerOnScreen();
    Principal.stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
