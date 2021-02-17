import modelo.Dinheiro;
import modelo.Veiculo;

import java.util.Arrays;
import modelo.Data;
import modelo.Veiculos;

class App {
  public static void main(String[] args) {
/*
    Dinheiro d1 = new Dinheiro(2, 30);
    Dinheiro d2 = new Dinheiro(5, 80);
    d1.somar(d2);
    System.out.println(d1.getReais() == 8);
    System.out.println(d1.getCentavos() == 10);

    Dinheiro bufunfa = new Dinheiro(1, 1);
    bufunfa.imprimir(); // R$ 1,01

    Dinheiro d3 = new Dinheiro(3, 45);
    System.out.println(d3.getReais() == 3);
    System.out.println(d3.getCentavos() == 45);

    Dinheiro d4 = new Dinheiro(200);
    System.out.println(d4.getReais() == 200);
    System.out.println(d4.getCentavos() == 0);


    Dinheiro d5 = new Dinheiro("R$ 345,75");
    System.out.println(d5.getReais() == 345);
    System.out.println(d5.getCentavos() == 75);

    Dinheiro d6 = new Dinheiro("R$ 1000000,11");
    System.out.println(d6.getReais() == 1000000);
    System.out.println(d6.getCentavos() == 11);

    Dinheiro d7 = new Dinheiro("R$ 2567,89");
    System.out.println(d7.getReais() == 2567);
    System.out.println(d7.getCentavos() == 89);


    Dinheiro d8 = new Dinheiro(9.75);
    System.out.println(d8.getReais() == 9);
    System.out.println(d8.getCentavos() == 75);

    Dinheiro d9 = new Dinheiro(17.569); // é truncado nas duas casas, não arredondado!
    System.out.println(d9.getReais() == 17);
    System.out.println(d9.getCentavos() == 56);

    d3.somar(d4);
    System.out.println(d3.getReais() == 203);
    System.out.println(d3.getCentavos() == 45);

    d5.somar(100);
    System.out.println(d5.getReais() == 445);
    System.out.println(d5.getCentavos() == 75);

    d6.somar(1.90);
    System.out.println(d6.getReais() == 1000002);
    System.out.println(d6.getCentavos() == 01);

    // d7.somar("R$ 998871,86986"); // PATCH
    d7.somar("R$ 998871,86986");
    System.out.println(d7.getReais() == 1001439);
    System.out.println(d7.getCentavos() == 75);
*/


    //novos testes ; equals


    /*

    Dinheiro d8 = new Dinheiro(8, 98);
    Dinheiro d9 = new Dinheiro(8, 99);
    Dinheiro d10 = null;
    Dinheiro d11 = new Dinheiro(8, 98);
    Dinheiro d12 = d8;

    System.out.println(d8.equals(d9) == false);
    System.out.println(d8.equals(d10) == false);
    System.out.println(d8.equals(d11) == true);
    System.out.println(d8.equals(d12) == true);

    System.out.println(new Dinheiro(3.43).equals(new Dinheiro(3, 43)));
    System.out.println(new Dinheiro("R$ 8,97").equals(new Dinheiro(8, 97)));
    System.out.println(!new Dinheiro("R$ 5,43").equals(null));

    */


    //outros testes ; comparaçao


    /*

    Dinheiro d12 = new Dinheiro(4, 30);
    Dinheiro d13 = new Dinheiro(987, 14);
    Dinheiro d14 = new Dinheiro(0, 1);
    Dinheiro d15 = new Dinheiro(17, 9);
    Dinheiro d16 = new Dinheiro(4, 30);

    // Todas estas assertivas devem imprimir true
    System.out.println(d12.compareTo(d13) < 0);
    System.out.println(d12.compareTo(d14) > 0);
    System.out.println(d12.compareTo(d15) < 0);
    System.out.println(d12.compareTo(d16) == 0);

    Dinheiro d17 = new Dinheiro(8);
    Dinheiro d18 = new Dinheiro(9);
    Dinheiro d19 = new Dinheiro(8);
    System.out.println(d17.compareTo(d18) < 0);
    System.out.println(d17.compareTo(d19) == 0);
    System.out.println(d18.compareTo(d17) > 0);

    Dinheiro[] dindin = { d12, d13, d14, d15, d16 };

    // Classifique em ordem crescente através de java.util.Arrays

    Arrays.sort(dindin);

    System.out.println(dindin[0].equals(d14));
    System.out.println(dindin[1].equals(d12));
    System.out.println(dindin[2].equals(d12));
    System.out.println(dindin[3].equals(d15));
    System.out.println(dindin[4].equals(d13));

    */





    // Testes da Data




    //testando datas invalidas

  /*

    try{
      Data d15 = new Data(0,12,2020);
      System.out.println(false);
    }catch (Exception e){
      System.out.println("true " + e.getMessage());
    }

    try {
      Data d16 = new Data("10/13/2020");
      System.out.println(false);
    } catch (Exception e) {
      System.out.println("true " + e.getMessage());
    }



    Data da1 = new Data(2, 11 , 28);
    Data da2 = new Data("20/5/2028");

    System.out.println(da1.getDia() == 2);  //true
    System.out.println(da1.getMes() == 11); //true
    System.out.println(da1.getAno() == 28); //true

    System.out.println(da2.getDia() == 20); //true
    System.out.println(da2.getMes() == 5); //true
    System.out.println(da2.getAno() == 2028); //true

    da1.aumentaDia(); // aumenta em 1 o dia
    System.out.println(da1.getDia() == 3); //3
    da1.aumentaDia();
    System.out.println(da1.getDia() == 4); // 4
    da1.diminuiDia(); // diminui em 1 o dia
    System.out.println(da1.getDia() == 3); // 3

    da1.aumentaMes(); // aumenta em 1 o mês
    System.out.println(da1.getMes() == 12); // 12
    da1.aumentaMes();
    System.out.println(da1.getMes() == 1); // 1
    da1.diminuiMes(); // diminui em 1 o mes
    System.out.println(da1.getMes() == 12); // 12

    da1.aumentaAno(); // aumenta em 1 o ano
    System.out.println(da1.getAno() == 29); // 29
    da1.aumentaAno();
    System.out.println(da1.getAno() == 30); // 30
    da1.diminuiAno(); // diminui em 1 o ano
    System.out.println(da1.getAno() == 29); // 29


    da2.setDia(1); // define o dia com o valor inteiro informado
    System.out.println(da2.getDia() == 1);
    da2.setMes(1); // define o mes com o valor inteiro informado
    System.out.println(da2.getMes() == 1);
    da2.setAno(1);// define o ano com o valor inteiro informado
    System.out.println(da2.getAno() == 1);



    try{
      da2.setDia(50); // valor fora da faixa, não deve passar, maior que 31
      System.out.println(false);
    }catch (Exception e){
      System.out.println("true " + e.getMessage());
    }

    da2.setMes(2); // definindo em fevereiro para testar o dia 29/2
    try {
      da2.setDia(29); // valor fora da faixa, não deve passar
      System.out.println(false);
    } catch (Exception e) {
      System.out.println("true " + e.getMessage());
    }


    da2.setMes(4); // valor maximo para abril é 30
    try {
      da2.setDia(31); // valor fora da faixa, não deve passar
      System.out.println(false);
    } catch (Exception e) {
      System.out.println("true " + e.getMessage());
    }



    // Teste de valores de travessia de mes

    da2.setMes(2);
    da2.setDia(28);
    System.out.println(da2.getDia() == 28); // 28
    da2.aumentaDia();
    System.out.println(da2.getDia() == 1); // 1
    System.out.println(da2.getMes() == 3); // 3
    da2.diminuiDia();
    System.out.println(da2.getDia() == 28); // 28
    System.out.println(da2.getMes() == 2); // 2

    //Teste de valores de travessia de ano

    da2.setMes(12);
    da2.setDia(31);
    da2.setAno(2020);
    System.out.println(da2.getDia() == 31); // 31
    System.out.println(da2.getMes() == 12); // 12
    System.out.println(da2.getAno() == 2020); // 2020


    da2.aumentaDia();
    System.out.println(da2.getDia() == 1); // 1
    System.out.println(da2.getMes() == 1); // 1
    System.out.println(da2.getAno() == 2021); // 2021

    da2.diminuiDia();
    System.out.println(da2.getDia() == 31); // 31
    System.out.println(da2.getMes() == 12); // 12
    System.out.println(da2.getAno() == 2020); // 2020

*/



    // Teste veiculo
/*


    Veiculo v1 = new Veiculo("zzzz", "LG" , "bicudo", 18);
    Veiculo v2 = new Veiculo("zzzz", "AOC", "bicudo", 18);
    Veiculo v3 = new Veiculo("zzzz", "LG" , "redondo", 18);
    Veiculo v4 = new Veiculo("zzzz", "LG", "bicudo", 15);
    Veiculo v5 = new Veiculo("gggg", "LG", "bicudo", 18);
    Veiculo v6 = new Veiculo("hhhh", "AOC" , "bicudo", 15);
    Veiculo v7 = new Veiculo("jjjj", "LG" , "redondo", 15);
    Veiculo v8 = new Veiculo("kkkk", "AOC", "redondo", 15);
    Veiculo v9 = new Veiculo("kkkk", "AOC", "redondo", 18);
    Veiculo v10 = new Veiculo("kkkk", "AOC", "redondo", 15);


    System.out.println(v1.equals(v5) == true);
    System.out.println(v2.equals(v6) == false);
    System.out.println(v3.equals(v7) == false);
    System.out.println(v8.equals(v4) == false);
    System.out.println(v8.equals(v9) == false);
    System.out.println(v8.equals(v10) == true);

    */

  }
}
