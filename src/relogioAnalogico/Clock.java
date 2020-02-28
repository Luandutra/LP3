/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relogioAnalogico;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Clock extends Pane implements Runnable {
  private int hour;
  private int minute;
  private int second;
  // Largura e altura do painel do relógio
  private double w = 250, h = 250;
  /** Cria o relógio com a hora atual do sistema */
  public Clock() {
    setCurrentTime();
    Thread t = new Thread(this);
    t.setDaemon(true);
    t.start();
  }
  /** Cria o relógio com o horário especificado nos parâmetros */
  public Clock(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
    paintClock();
  }
  public int getHour() {
    return hour;
  }
  public void setHour(int hour) {
    this.hour = hour;
    paintClock();
  }
  public int getMinute() {
    return minute;
  }
  public void setMinute(int minute) {
    this.minute = minute;
    paintClock();
  }
  public int getSecond() {
    return second;
  }
  public void setSecond(int second) {
    this.second = second;
    paintClock();
  }
  public double getW() {
    return w;
  }
  public void setW(double w) {
    this.w = w;
    paintClock();
  }
  public double getH() {
    return h;
  }
  public void setH(double h) {
    this.h = h;
    paintClock();
  }
  /* Set the current time for the clock */
  public void setCurrentTime() {
    // Cria um calendar com a hora atual do sistema
    Calendar calendar = new GregorianCalendar();
    // Set current hour, minute and second
    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);
    paintClock(); // Atualiza o gráfico do relógio
    
      System.out.println(second);
  }
  /** Desenha o relógio */
  private void paintClock() {
    // Inicializa os parâmetros gráficos do relógio
    //proporção da dimensão do relógio
    double clockRadius = Math.min(w, h) * 0.8 * 0.5;//80% do painel e 20% afastado do relogio
    
    double centerX = w / 2;
    double centerY = h / 2;
    // Desenha o círculo
    Circle circle = new Circle(centerX, centerY, clockRadius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    
    //posicionamentos
    Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");//decrementando o tamanho do raio para ficar no centro
    
    //Text tx = new Text(centerX);
    
    Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
    Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
    Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
  
    // Desenha o ponteiro do segundo
    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength * 
    Math.sin(second * (2 * Math.PI / 60));
    double secondY = centerY - sLength * 
    Math.cos(second * (2 * Math.PI / 60));
    Line sLine = new Line(centerX, centerY, secondX, secondY);
    sLine.setStroke(Color.RED);
    /*
     * Outra possibilidade é utilizar a classe Rotate. Você set o ponteiro para o meio dia (12:00) e
     * rotaciona de acordo com a respectiva hora/minuto/segundo 
     * sLine.getTransforms().add(new Rotate(360/60 * second,centerX,centerY));
     */
    
    // Desenha o ponteiro do minuto
    double mLength = clockRadius * 0.65;
    double xMinute = centerX + mLength * 
    Math.sin(minute * (2 * Math.PI / 60));//comprimento do arco
    double minuteY = centerY - mLength * 
    Math.cos(minute * (2 * Math.PI / 60));
    Line mLine = new Line(centerX, centerY, xMinute, minuteY);
    mLine.setStroke(Color.BLUE);//linha do segundo
    
    // Desenha o ponteiro da hora
    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength * 
    Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength *
    Math.cos((hour % 12 + hour / 60.0) * (2 * Math.PI / 12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.GREEN);
    getChildren().clear();  
    getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
  }
  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      Platform.runLater(new Runnable() {//classe do FX//passando na classe para gerenciar
        @Override
        public void run() {
          setCurrentTime();  
        }
      });
    }    
  }
  
  
   
}