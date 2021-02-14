# Avaliação 03 Polimorfismo ad-hoc, Encapsulamento, Igualdade e Comparabilidade

Link do Classroom <https://classroom.github.com/a/cPN-sjYB>

## Implementar e testar segundo as especificações

- Esta atividade é avaliada com esforço estimado entre 4 e 8h.
- Copie os casos de teste para o método `main` em [App.java](src/App.java), conforme o exemplo que já está no arquivo. Comente com `//` ou `/*` e `*/` as linhas que ainda não foram implementadas.
- Os Casos de Teste podem ser corrigidos se estiverem mal escritos, mas **a especificação dos objetos não pode ser alterada**.
- Não esqueça de ajustar a visibilidade das classes [Dinheiro](src/modelo/Dinheiro.java) e [Veiculo](src/modelo/Veiculo.java), **elas não devem ser removidas da pasta `modelo`**.
- E, por fim, assegure-se de **assistir as videoaulas antes de começar**, pois lá estão explicados todos os conceitos e práticas.

### Tornar Dinheiro polimórfico

Sobrecarregue o método `somar` na classe [Dinheiro](src/Dinheiro.java) para aceitar parâmetros `int`, `double` e `String`. No caso de `double`, considerar apenas duas casas decimais.

Sobrecarregar o construtor de [Dinheiro](src/Dinheiro.java) para aceitar um `int` representando _Reais_ (não os centavos), `double` (com apenas duas casas decimais) e `String` no formato de `"R$ 12,34"` com centavos de duas casas e reais de até 7 casas, por exemplo `"R$ 1234567,89"`.

**Casos de Teste:**

```java
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

d3.soma(d4);
System.out.println(d3.getReais() == 203);
System.out.println(d3.getCentavos() == 45);

d5.soma(100);
System.out.println(d5.getReais() == 445);
System.out.println(d5.getCentavos() == 75);

d6.soma(1.90);
System.out.println(d6.getReais() == 1000002);
System.out.println(d6.getCentavos() == 01);

// d7.soma("R$ 998871,86986"); // PATCH
d7.soma("R$ 998817,86986");
System.out.println(d7.getReais() == 1001385);
System.out.println(d7.getCentavos() == 75);
```

### Avaliar a equivalência de Dinheiro com `equals`

Dadas instâncias de `Dinheiro` devem retornar verdadeiro se possuem o mesmo valor monetário.

**Casos de Teste:**

```java
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
```

### Tornar Dinheiro comparável

Tornar Dinheiro comparável através da implementação da interface `Comparable`.

**Casos de Teste:**

```java
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

Comparable d17 = new Dinheiro(8);
Comparable d18 = new Dinheiro(9);
Comparable d19 = new Dinheiro(8);
System.out.println(d17.compareTo(d18) < 0);
System.out.println(d17.compareTo(d19) == 0);
System.out.println(d18.compareTo(d17) > 0);

Dinheiro[] dindin = {d12, d13, d14, d15, d16};

// Classifique em ordem crescente através de java.util.Arrays

System.out.println(dindin[0].equals(d14));
System.out.println(dindin[1].equals(d12));
System.out.println(dindin[2].equals(d12));
System.out.println(dindin[3].equals(d15));
System.out.println(dindin[4].equals(d13));
```

### Implemente Data

Implemente `Data` (ex.: _28/01/2021_) de forma que possa ser instanciada de pelo menos duas maneiras (sobrecarga de construtor), com validação e totalmente encapsulada (atributos invisíveis) com acesso intermediado por acessores (getters), permitindo a verificação da equivalência (equals) e comparabilidade (compareTo).

**Importante**: a classe `Data` deve ser colocada no diretório [modelo](/src/modelo/) e ser declarada como `package modelo;` (ver `Dinheiro` e `Veiculo`).

Escreva os Casos de Teste, conforme aprendeu nas atividades anteriores, que devem cobrir o comportamento normal e os casos especiais.

### Implementar `equals` em Veiculo

A classe [Veiculo](src/modelo/Veiculo.java) precisa de um método _equals_. Decida qual será o critério de equivalência e escreva testes para apresentar o comportamento esperado.
