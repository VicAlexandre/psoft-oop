# psoft-oop
## Projeto de um sistema para gerenciar projetos acadêmicos desenvolvido em Java para a disciplina Projeto de Software.

=========================================================================================================================

# CODE SMELLS:

## Long Method:
###### Muitas variáveis temporárias no método main localizado em Main.java.

## Lazy Class:
###### A subclasse Coordinator, que herda User, não faz o bastante para se pagar.

## Message Chains:
###### Alguns exemplos desse Code Smell estão localizados no método main, como por exemplo:
```java
!users.get(accountIndex).getName().equals(userName)
```
