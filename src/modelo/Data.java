package modelo;

public class Data {

  private int dia, mes, ano, i = 0;
  private String[] dataSeparada;

  public Data(int dia,int mes,int ano){
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  public Data(String diaMesAno){ // nesse formato : "22/11/1999"
    dataSeparada = diaMesAno.split("/");
    this.dia = Integer.valueOf(dataSeparada[0]);
    this.mes = Integer.valueOf(dataSeparada[1]);
    this.ano = Integer.valueOf(dataSeparada[2]);
  }

  public int getDia(){ // pega o valor do dia
    return this.dia;
  }

  public int getMes() { // pega o valor do mes
    return this.mes;
  }

  public int getAno() { // pega o valor do ano
    return this.ano;
  }


  public void aumentaDia(){
    // aumenta o dia em 1,
    // caso ultrapasse valor maximo para o mes, retorna a 1 e aumenta 1 mes,
    // caso mes ultrapasse 12,
    // o ano é acrescido em +1
    if (this.mes == 1 ||this.mes == 3 ||this.mes == 5 ||this.mes == 7 ||this.mes == 8 ||this.mes == 10){
      if (this.dia == 31){
        if (this.mes == 12){
          this.mes = 1;
          this.dia = 1;
          this.ano += 1;
        }else
          this.mes += 1;
          this.dia = 1;
      }else
        this.dia +=1;
    }else{
      if (this.mes == 2) {
        if (this.dia == 28) {
          this.mes += 1;
          this.dia = 1;
        }else
          this.dia += 1;
      }else{
        if (this.dia == 30){
          this.mes += 1;
          this.dia = 1;
        }else
          this.dia += 1;
      }
    }
  }

  public void aumentaMes() {
    // aumenta o mes em +1
    // caso mes ultrapasse 12,
    // o ano é acrescido em +1
    if (this.mes == 12) {
      this.ano += 1;
      this.mes = 1;
    } else
      this.mes += 1;
  }

  public void aumentaAno() {
    // o ano é acrescido em +1
    this.ano += 1;
  }

  public void diminuiDia(){
    // diminui o dia em 1, caso ultrapasse valor minimo (1),
    // o dia assume o valor maximo do (mes - 1)
    //e o valor do mes é reduzido em 1,
    // se o mes originario for 1,
    // entao mes assume valor 12
    //e ano assume valor de (ano -1).
    if (this.dia == 1){
      if (this.mes == 1){
        this.ano += -1;
        this.mes = 12;
        this.dia = 31;
      }
      else{
        this.dia = 2;
        this.mes += -1;
        while (this.dia != 1){
          aumentaDia();
          i++;
        }
        this.mes += -1;
        this.dia = 1 + i;
        i = 0;
      }
    }else{
      this.dia += -1;
    }
  }

  public void diminuiMes(){
    // e o valor do mes é reduzido em 1,
    // se o mes originario for 1,
    // entao mes assume valor 12
    // e ano assume valor de (ano -1).
    if (this.mes == 1){
      this.ano += -1;
      this.mes = 12;
    }else{
      this.mes += -1;
    }
  }

  public void diminuiAno(){
    // e ano assume valor de (ano -1).
    this.ano += -1;
  }

  public void setDia(int dia){  // define o dia com o valor inteiro informado
    if (dia < 1)
      throw new IllegalArgumentException("Dia invalido, menor que 1");
    else{
      if (this.mes == 2){
        if (dia > 28){
          throw new IllegalArgumentException("Dia invalido, maior que 28 em fevereiro");
        }else{
          this.dia = dia;
        }
      }else{
        if (this.mes == 1 ||this.mes == 3 ||this.mes == 5 ||this.mes == 7 ||this.mes == 8 ||this.mes == 10){
          if (dia > 31){
            throw new IllegalArgumentException("Dia invalido, maior que 31 no mes " + getMes());
          }
          else{
            this.dia = dia;
          }
        }
        else{
          if (dia > 30){
            throw new IllegalArgumentException("Dia invalido, maior que 30 no mes " + getMes());
          }
          else
            this.dia = dia;
        }
      }
    }
  }


  public void setMes(int mes){  // define o mes com o valor inteiro informado
    if (mes < 1){
      throw new IllegalArgumentException("Mes invalido, menor que 1");
    }else{
      if (mes > 12){
        throw new IllegalArgumentException("Mes invalido, maior que 12");
      }
      else{
        if (mes == 2){
          if (dia >= 28){
            throw new IllegalArgumentException("Mes incompativel com o dia, altere o dia primeiro");
          }
          else{
            this.mes = mes;
          }
        }
        else{
          if (mes == 4 ||mes == 6 ||mes == 9 ||mes == 11){
            if (dia >= 30){
              throw new IllegalArgumentException("Mes incompativel com o dia, altere o dia primeiro");
            }
            else{
              this.mes = mes;
            }
          }
          else{
            this.mes = mes;
          }
        }
      }
    }
  }

  public void setAno(int ano){  // define o ano com o valor inteiro informado
    if (ano < 0)
      throw new IllegalArgumentException("Ano invalido, menor que 0");
    else
      this.ano = ano;
  }

}


