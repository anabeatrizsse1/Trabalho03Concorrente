package model;

import controller.*;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

/* ***************************************************************
* Autor:Ana Beatriz Silva e Silva 
* Matricula: 202110226
* Inicio: 11/04/2023
* Ultima alteracao: 22/04/2023
* Nome: Arvore genealogica com Threads
* Funcao:  Esse programa simula dois trens que devem compartilhar duas regioes aonde apenas um pode passar,
  eles devem parar assim que um outro entre nessa regiao para que nao batam. Para isso usaremos explicita alternancia.
*************************************************************** */

public class Trem1 extends Thread {
  TelaController controle = new TelaController();

  private int velocidade = 100;
  private double eixoX = 25;
  private double eixoY = 191;
  private ImageView imagem;
  private final double inicio1;
  private final double inicio2;
  private boolean start = true;

  public Trem1(TelaController controle, ImageView imagem) {
    this.inicio1 = eixoX;
    this.inicio2 = eixoY;
    this.imagem = imagem;
    this.controle = controle;
  }

  public void run() {
    while (start) {
      try {
        MoverEixoX(90);
        Verificar1();
        PassarTunel1(120, 243);
        Curva2(225, 191);
        MoverEixoX(361);
        Verificar2();
        PassarTunel2(392, 248);
        Curva2(480, 191);
        MoverEixoX(550);
        Inicio();
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

  public void pararThread() {
    start = false;
    imagem.setVisible(false);
    velocidade = 0;
  }

  public int getVelocidade() {
    return velocidade;
  }

  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  }

  public void Verificar1() throws InterruptedException {
    while (controle.getLiberarTunel1() != 0) {
      sleep(1);
    }
  }

  public void Verificar2() throws InterruptedException {
    while (controle.getLiberarTunel2() != 0) {
      sleep(1);
    }
  }

  /*
   * ***************************************************************
   * Metodo: MoverEixoX
   * Funcao: altera o valor do eixoX movimentando o trem horizontalmente
   * Parametros: double
   * Retorno: void
   */
  public void MoverEixoX(double x) throws InterruptedException {
    while (eixoX != x) {
      sleep(velocidade);
      Platform.runLater(() -> {
        imagem.setLayoutX(eixoX);
      });
      eixoX++;
    }

  }

  /*
   * ***************************************************************
   * Metodo: Curva
   * Funcao: altera o valor do eixoX e eixo Y movimentando o trem fazendo o trem
   * descer o trilho
   * Parametros: double, double
   * Retorno: void
   */
  public void Curva(double x, double y) throws InterruptedException {
    while (eixoX != x && eixoY != y) {
      sleep(velocidade);
      Platform.runLater(() -> {
        imagem.setLayoutX(eixoX);
        imagem.setLayoutY(eixoY);
      });
      eixoX++;

      if (y < eixoY) {
        eixoY -= 1.6;
      }
      eixoY += 1.6;
    }

  }

  /*
   * ***************************************************************
   * Metodo: Curva2
   * Funcao: altera o valor do eixoX e eixo Y movimentando o trem fazendo o trem
   * subir o trilho
   * Parametros: double, double
   * Retorno: void
   */
  public void Curva2(double x, double y) throws InterruptedException {
    while (eixoX != x && eixoY != y) {
      sleep(velocidade);
      Platform.runLater(() -> {
        imagem.setLayoutX(eixoX);
        imagem.setLayoutY(eixoY);
      });
      eixoX++;

      if (y == eixoY) {
        eixoY++;
      }
      eixoY--;
    }

  }

  /*
   * ***************************************************************
   * Metodo: passarTunel2
   * Funcao: essa funcao determina o percurso feito pelo trem durante sua entrada
   * na
   * regiao critica1.
   * Parametros: double, double
   * Retorno: void
   */
  public void PassarTunel2(double pare1, double pare2) throws InterruptedException {
    controle.getSinalVermelho2().setVisible(true);
    controle.setLiberarTunel2(1);

   controle.getSinalVermelho2().setVisible(true);
    Curva(pare1, pare2);
    pare1 = pare1 + 41;
    MoverEixoX(pare1);

    controle.getSinalVermelho2().setVisible(false);
    controle.setLiberarTunel2(0);


  }

  /*
   * ***************************************************************
   * Metodo: PassardoTunel1
   * Funcao: essa funcao determina o percurso feito pelo trem durante sua entrada
   * na
   * regiao critica1.
   * Parametros: double, double
   * Retorno: void
   */
  public void PassarTunel1(double pare1, double pare2) throws InterruptedException {
    controle.getSinalVermelho1().setVisible(true);
    Curva(pare1, pare2);

    controle.setLiberarTunel1(1);

    controle.getSinalVermelho1().setVisible(false);
    controle.getSinalVermelho1().isVisible();
    pare1 = pare1 + 60;
    MoverEixoX(pare1);
    controle.getSinalVermelho1().setVisible(false);
    controle.setLiberarTunel1(0);
  }

  /*
   * ***************************************************************
   * Metodo: Inicio
   * Funcao: o trem poder voltar para a posicao inicial dele apos percorrido oo
   * trilho
   * Parametros: sem parametro
   * Retorno: void
   */
  public void Inicio() throws InterruptedException {
    eixoX = inicio1;
    eixoY = inicio2;
    sleep(velocidade);
    Platform.runLater(() -> {
      imagem.setLayoutX(eixoX);
      imagem.setLayoutY(eixoY);
    });

  }

}
