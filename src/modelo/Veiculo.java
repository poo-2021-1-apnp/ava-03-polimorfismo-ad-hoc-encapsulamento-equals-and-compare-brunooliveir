package modelo;

public class Veiculo {
  final String placa, marca, modelo;
  final int    cilindrada;

  public Veiculo(String placa, String marca, String modelo, int cilindrada) {
    this.placa = placa; this.marca = marca; this.modelo = modelo;
    this.cilindrada = cilindrada;
  }

  public String getPlaca(){
    return this.placa;
  }

  public String getModelo() {
    return this.modelo;
  }

  public String getMarca() {
    return this.marca;
  }

  public int cilindrada() {
    return this.cilindrada;
  }

  @Override
  public boolean equals(Object obj) { //criterio sera ser da mesma marca, modelo e cilindrada, nao sendo interessante a comparacao de placa
    if (this == obj)
      return true;
    if (null == obj)
      return false;
    if (obj instanceof Veiculo) {
      Veiculo outroDinheiro = (Veiculo) obj;
      if (this.marca == outroDinheiro.marca && this.modelo == outroDinheiro.modelo && this.cilindrada == outroDinheiro.cilindrada)
        return true;
    }
    return false;
  }


}
