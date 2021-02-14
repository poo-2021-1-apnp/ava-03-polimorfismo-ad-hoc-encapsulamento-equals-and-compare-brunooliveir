package modelo;

class Dinheiro {

  private int centavos;

  Dinheiro(int reais, int centavos) {
    this.centavos = reais * 100 + centavos;
  }

  int getReais() {
    return this.centavos / 100;
  }

  int getCentavos() {
    return this.centavos % 100;
  }

  void somar(Dinheiro d) {
    this.centavos += d.centavos;
  }

  void imprimir() { // Não é ilegal imprimir Dinheiro? 😏
    System.out.println(
      String.format("R$ %d,%02d", this.getReais(), this.getCentavos())
    );
  }

}
