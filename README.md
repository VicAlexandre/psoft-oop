# PROJETO DE SOFTWARE - PROGRAMAÇÃO ORIENTADA A OBJETOS, CODE SMELLS E QUALIDADE DE CÓDIGO

## Projeto de um sistema para gerenciar projetos acadêmicos desenvolvido em Java para a disciplina Projeto de Software.

## CODE SMELLS:

### Long Method:

###### Muitas variáveis temporárias no método main localizado em Main.java.

### Lazy Class:

###### A subclasse Coordinator, que herda User, não faz o bastante para se pagar.

### Message Chains:

###### Alguns exemplos desse Code Smell estão localizados no método main, como por exemplo:

```java
!users.get(accountIndex).getName().equals(userName)
```

## DESIGN PATTERNS:

### Bridge:

###### Com o uso do padrão de projeto bridge, reduzimos bastante a lógica contida dentro do método main. As funcionalidades agora são implementadas pelas classes AddAction, RemoveAction e EditAction, que implementam a interface Action.

### Extract Class:

###### Com a criação de uma superclasse Workable, que contém atributos e métodos comuns às classes Projetos e Atividades, reduziu-se bastante a repetição de código presente em ambas.

### Replace Data Value with Object

###### Anteriormente, a lista de tarefas localizadas dentro de cada atividade era apenas uma simples lista de strings. Com a criação da classe Task, incluímos uma variável booleana que informa se a tarefa foi concluída. Junto a isso, mudou-se também a lógica de exibir atividades para incluir também o estado das tarefas contidas no projeto.

```java
//Anteriormente
ArrayList<String> tasks;

//Posteriormente
ArrayList<Task> tasks;

public class Task {
    private String name;
    private boolean done;

     /* MÉTODOS
     DA CLASSE */

}
```
