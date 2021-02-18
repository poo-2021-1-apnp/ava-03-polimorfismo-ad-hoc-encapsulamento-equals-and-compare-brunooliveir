package modelo;

public class Data {

  private int dia, mes, ano;
  private final int DIA_MAXIMO_31 = 31, DIA_MAXIMO_30 = 30, DIA_MAXIMO_28 = 28, MES_MAXIMO_12 = 12;

  public Data(int dia,int mes,int ano){ //utilizado o metodo setDia, Mes e Ano para validar as entradas
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
    setDia(this.dia);
    setMes(this.mes);
    setAno(this.ano);
  }

  public Data(String diaMesAno){ // nesse formato : "22/11/1999"
    String[] dataSeparada;
    dataSeparada = diaMesAno.split("/");
    this.dia = Integer.valueOf(dataSeparada[0]);
    this.mes = Integer.valueOf(dataSeparada[1]);
    this.ano = Integer.valueOf(dataSeparada[2]);
    setDia(this.dia);
    setMes(this.mes);
    setAno(this.ano);
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

  public boolean isMesDe31Dias(){ // retorna true caso seja mês de 31 dias
    return this.mes == 1 ||this.mes == 3 ||this.mes == 5 ||this.mes == 7 ||this.mes == 8 ||this.mes == 10|| this.mes == 12;
  }

  public boolean isMesDe30Dias() { // retorna true caso seja mês de 30 dias
    return this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11;
  }

  public boolean isMesDe28Dias() { // retorna true caso seja mês de 28 dias
    return this.mes == 2;
  }

  public void setInicioProximoMes(){ // aumenta 1 mes e dia = 1
    this.dia = 1;
    this.mes++;
  }

  public void setFimMesPassado(){ // diminui 1 mes e dia = limite de dias do novo mes
    int i = 0;
    this.dia = 2;
    this.mes--;
    while (this.dia != 1) {
      aumentaDia();
      i++;
    }
    this.mes--;
    this.dia = 1 + i;
  }

  public void setInicioProximoAno(){ // aumenta 1 ano, dia = 1 e mes = 1
    this.dia = 1;
    this.mes = 1;
    this.ano++;
  }

  public void setFimAnoPassado(){ // diminui 1 ano, mes = 12 e dia = 31
    this.ano--;
    this.mes = MES_MAXIMO_12;
    this.dia = DIA_MAXIMO_31;
  }

  public void aumentaDia(){
    // aumenta o dia em 1,
    // caso ultrapasse valor maximo para o mes, retorna a 1 e aumenta 1 mes,
    // caso mes ultrapasse 12,
    // o ano é acrescido em +1
    if (isMesDe31Dias()){
      if (this.dia == DIA_MAXIMO_31 && this.mes == MES_MAXIMO_12)
        setInicioProximoAno();
      else
        if (this.dia == DIA_MAXIMO_31)
          setInicioProximoMes();
        else
          this.dia++;
    }

    if (isMesDe30Dias()){
      if (this.dia == DIA_MAXIMO_30)
        setInicioProximoMes();
      else
        this.dia++;
    }

    if (isMesDe28Dias()) {
      if (this.dia == DIA_MAXIMO_28)
        setInicioProximoMes();
      else
        this.dia++;
    }
  }

  public void aumentaMes() {
    // aumenta o mes em +1
    // caso mes ultrapasse 12,
    // o ano é acrescido em +1
    if (this.mes == MES_MAXIMO_12) {
      this.ano++;
      this.mes = 1;
    } else
      this.mes++;
  }

  public void aumentaAno() {
    // o ano é acrescido em +1
    this.ano++;
  }

  public void diminuiDia(){
    // diminui o dia em 1, caso ultrapasse valor minimo (1),
    // o dia assume o valor maximo do (mes - 1)
    //e o valor do mes é reduzido em 1,
    // se o mes originario for 1,
    // entao mes assume valor 12
    //e ano assume valor de (ano -1).
    if (this.dia == 1){
      if (this.mes == 1)
        setFimAnoPassado();

      else
        setFimMesPassado();

    }else
      this.dia--;

  }

  public void diminuiMes(){
    // e o valor do mes é reduzido em 1,
    // se o mes originario for 1,
    // entao mes assume valor 12
    // e ano assume valor de (ano -1).
    if (this.mes == 1){
      this.ano--;
      this.mes = MES_MAXIMO_12;
    }else{
      this.mes--;
    }
  }

  public void diminuiAno(){
    // e ano assume valor de (ano -1).
    if (this.ano > 0)
      this.ano--;
  }

  public void setDia(int dia){  // define o dia com o valor inteiro informado
    if (dia < 1)
      throw new IllegalArgumentException("Dia invalido, menor que 1");

    if (isMesDe28Dias()){
      if (dia > DIA_MAXIMO_28)
        throw new IllegalArgumentException("Dia invalido, maior que 28 em fevereiro");
    }

    if (isMesDe31Dias()){
      if (dia > DIA_MAXIMO_31)
        throw new IllegalArgumentException("Dia invalido, maior que 31 no mes " + getMes());
    }

    if (isMesDe30Dias()){
      if (dia > DIA_MAXIMO_30)
        throw new IllegalArgumentException("Dia invalido, maior que 30 no mes " + getMes());
    }

    this.dia = dia;
  }


  public void setMes(int mes){  // define o mes com o valor inteiro informado
    if (mes < 1)
      throw new IllegalArgumentException("Mes invalido, menor que 1");

    if (mes > MES_MAXIMO_12)
      throw new IllegalArgumentException("Mes invalido, maior que 12");

    if (isMesDe28Dias()){
      if (dia > DIA_MAXIMO_28)
        throw new IllegalArgumentException("Mes incompativel com o dia maior que 28, altere o dia primeiro");
    }

    if (isMesDe30Dias()){
      if (dia > DIA_MAXIMO_30)
        throw new IllegalArgumentException("Mes incompativel com o dia maior que 30, altere o dia primeiro");
    }

    if (isMesDe31Dias()){
      if (dia > DIA_MAXIMO_31)
        throw new IllegalArgumentException("Mes incompativel com o dia maior que 31, altere o dia primeiro");
    }

    this.mes = mes;

  }




  public void setAno(int ano){  // define o ano com o valor inteiro informado
    if (ano < 0)
      throw new IllegalArgumentException("Ano invalido, menor que 0");

    this.ano = ano;
  }

}


