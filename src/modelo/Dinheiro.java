package modelo;
import java.text.DecimalFormat;

public class Dinheiro implements Comparable<Dinheiro> {

  DecimalFormat dec = new DecimalFormat("0.000");
  private int centavos, centavosLimposInt;
  private String dinheiroDoubleStr = "";
  private String[] dinheiroSemTexto, dinheiroSemVirgula;


  public Dinheiro(int reais, int centavos) { // entrada de reais e centavos separados em dois valores inteiros
    this.centavos = reais * 100 + centavos;
  }

  public Dinheiro(String dinheiroStr){
    // entrada de dinheiro é uma string que contem texto separado por um espaço e reais separados dos centavos por uma ","
    this.somar(dinheiroStr);
  }

  public Dinheiro(Double dinheiroDouble) { // entrada do dinheiro é um valor em Double
    this.somar(dinheiroDouble);
  }

  public Dinheiro(int dinheiroInt) { // a entrada do dinheiro é em reais, apenas um numero inteiro
    this.somar(dinheiroInt);
  }

  public int getReais() { // retorna apenas os reais
    return this.centavos / 100;
  }

  public int getCentavos() { // retorna apenas os centavos
    return this.centavos % 100;
  }

  public void somar(Dinheiro d) { // soma o dinheiro de outro objeto dinheiro no objeto dinheiro
    this.centavos += d.centavos;
  }

  public void somar(String dinheiroStr){ // soma o dinheiro dado em String no objeto dinheiro
    this.dinheiroSemTexto = dinheiroStr.split(" ");
    this.dinheiroSemVirgula = dinheiroSemTexto[1].split(",");
    this.centavosLimposInt = Integer.valueOf(dinheiroSemVirgula[1]);
    while (centavosLimposInt > 100){
      this.centavosLimposInt = centavosLimposInt/10;
    }
    this.centavosLimposInt = (int)centavosLimposInt;
    this.centavos += (Integer.valueOf(this.dinheiroSemVirgula[0]) * 100) + centavosLimposInt;
  }

  public void somar(Double dinheiroDouble){ // soma o dinheiro dado em Double no objeto dinheiro
    this.dinheiroDoubleStr = dec.format(dinheiroDouble);
    this.dinheiroSemVirgula = dinheiroDoubleStr.split(",");
    this.centavosLimposInt = Integer.valueOf(dinheiroSemVirgula[1]);
    while (centavosLimposInt > 100) {
      this.centavosLimposInt = centavosLimposInt / 10;
    }
    this.centavosLimposInt = (int) centavosLimposInt;
    this.centavos += (Integer.valueOf(this.dinheiroSemVirgula[0]) * 100) + centavosLimposInt;
  }

  public void somar(int dinheiroInt){ // soma o dinheiro dado em int no objeto dinheiro
    this.centavos += dinheiroInt * 100;
  }


  public void imprimir() { // Não é ilegal imprimir Dinheiro? 😏
    System.out.println(
      String.format("R$ %d,%02d", this.getReais(), this.getCentavos())
    );
  }

  @Override // sobreescreve o equals, adicionando regras de igualdade de dinheiro e casos invalidos
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (null == obj) return false;
    if (obj instanceof Dinheiro){
      Dinheiro outroDinheiro = (Dinheiro) obj;
      if (this.centavos == outroDinheiro.centavos) return true;
    }
    return false;
  }

  @Override
  public int compareTo(Dinheiro outroDinheiro) {
    return this.centavos - outroDinheiro.centavos;



  }

}
