package modelo;

public class Veiculo {
  final String PLACA, MARCA, MODELO;
  final int    CILINDRADA;

  public Veiculo(String PLACA, String MARCA, String MODELO, int CILINDRADA) {
    this.PLACA = PLACA; this.MARCA = MARCA; this.MODELO = MODELO;
    this.CILINDRADA = CILINDRADA;
  }

  public String getPlaca(){
    return this.PLACA;
  }

  public String getModelo() {
    return this.MODELO;
  }

  public String getMarca() {
    return this.MARCA;
  }

  public int cilindrada() {
    return this.CILINDRADA;
  }

  @Override
  public boolean equals(Object obj) { //criterio sera ser da mesma MARCA, MODELO e CILINDRADA, nao sendo interessante a comparacao de PLACA
    if (this == obj)
      return true;
    if (null == obj)
      return false;
    if (obj instanceof Veiculo) {
      Veiculo outroDinheiro = (Veiculo) obj;
      if (this.MARCA == outroDinheiro.MARCA && this.MODELO == outroDinheiro.MODELO && this.CILINDRADA == outroDinheiro.CILINDRADA)
        return true;
    }
    return false;
  }


}
