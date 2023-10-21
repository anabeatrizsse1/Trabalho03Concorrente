package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.*;

/* ***************************************************************
* Autor:Ana Beatriz Silva e Silva 
* Matricula: 202110226
* Inicio: 11/04/2023
* Ultima alteracao: 22/04/2023
* Nome: Arvore genealogica com Threads
* Funcao:  Esse programa simula dois trens que devem compartilhar duas regioes aonde apenas um pode passar,
  eles devem parar assim que um outro entre nessa regiao para que nao batam. Para isso usaremos explicita alternancia.
*************************************************************** */

public class TelaController implements Initializable {

  @FXML
  private Label v1, v2;
  @FXML
  private ImageView tela;
  @FXML
  ImageView sinalVermelho1;
  @FXML
  ImageView sinalVermelho2;
  @FXML
  ImageView trem1;
  @FXML
  ImageView trem2;
  @FXML
  ImageView trem3;

  @FXML
  ImageView trem4;

  @FXML
  public void iniciar() {
    t1 = new Trem1(this, trem1);
    t2 = new Trem2(this, trem2);
    t1.start();
    t2.start();

  }

  @FXML
  public void reiniciar() {
    t1.pararThread();
    t2.pararThread();
    trem1.setVisible(true);
    trem2.setVisible(true);
    iniciar();
  }

  private Trem1 t1;
  private Trem2 t2;

  int tunel1 = 0;
  int tunel2 = 0;
  int velocidadeT1 = 1;
  int velocidadeT2 = 1;

  public int getLiberarTunel1() {
    return tunel1;
  }

  public void setLiberarTunel1(int tunel1) {
    this.tunel1 = tunel1;
  }

  public int getLiberarTunel2() {
    return tunel2;
  }

  public void setLiberarTunel2(int tunel2) {
    System.out.println(tunel2);
    this.tunel2 = tunel2;
  }

  public ImageView getTrem1() {
    return trem1;
  }

  public ImageView getTrem2() {
    return trem2;
  }

  public ImageView getTrem3() {
    return trem3;
  }

  public ImageView getTrem4() {
    return trem4;
  }

  /*
   * ***************************************************************
   * Metodo: aumentar1
   * Funcao: aumenta a velocidade da variavel velocidade para o trem 1.
   * isso ocorre ao diminuir o valor da variavel, diminuinido o
   * tempo que a thread dorme
   * Parametros: sem parametro
   * Retorno: void
   */
  @FXML
  public void aumentar1() {
    if (velocidadeT1 <= 10) {
      velocidadeT1++;

      t1.setVelocidade(110 - (velocidadeT1 * 10));

      v1.setText(velocidadeT1 + "");
    }
  }

  /*
   * ***************************************************************
   * Metodo: diminuir1
   * Funcao: dimui a velocidade da variavel velocidade para o trem 1.
   * isso ocorre ao aumentando o valor da variavel, aumentando o
   * tempo que a thread dorme
   * Parametros: sem parametro
   * Retorno: void
   */
  @FXML
  public void diminuir1() {
    if (velocidadeT1 >= 0) {
      velocidadeT1--;

      t1.setVelocidade(110 - (velocidadeT1 * 10));

      v1.setText(velocidadeT1 + "");
    }
  }

  /*
   * ***************************************************************
   * Metodo: aumentar2
   * Funcao: aumenta a velocidade da variavel velocidade para o trem 2.
   * isso ocorre ao diminuir o valor da variavel, diminuinido o
   * tempo que a thread dorme
   * Parametros: sem parametro
   * Retorno: void
   */
  @FXML
  public void aumentar2() {
    if (velocidadeT2 <= 10) {
      velocidadeT2++;

      t2.setVelocidade(110 - (velocidadeT2 * 10));

      v2.setText(velocidadeT2 + "");
    }
  }

  /*
   * ***************************************************************
   * Metodo: diminuir2
   * Funcao: dimui a velocidade da variavel velocidade para o trem 2.
   * isso ocorre ao aumentando o valor da variavel, aumentando o
   * tempo que a thread dorme
   * Parametros: sem parametro
   * Retorno: void
   */
  @FXML
  public void diminuir2() {
    if (velocidadeT2 >= 0) {
      velocidadeT2--;

      t2.setVelocidade(110 - (velocidadeT2 * 10));

      v2.setText(velocidadeT2 + "");
    }
  }

  public ImageView getSinalVermelho1() {
    return sinalVermelho1;
  }

  public ImageView getSinalVermelho2() {
    return sinalVermelho2;
  }

  @Override
  public void initialize(URL url, ResourceBundle resources) {

  }

}
