# Parallel Array Summary Java

## Especificações do projeto

1. Um array (ou lista) deve armazenar objetos com as seguintes informações:
    - **ID** – Identificador inteiro único do objeto
    - **Total** – Um valor decimal entre 0 e 10
    - **Grupo** – Um número inteiro entre 1 e 5
2. A implementação deve ser dividida em 2 etapas:
    - **Carregamento:** Recebe um número inteiro N, e produz uma sequência de inserções de 10ˆN objetos, onde o total e o grupo são escolhidos de forma randômica, enquanto o id é sequencial.
    - **Processamento:** Recebe um número inteiro T que representa a quantidade de threads a ser criada e que de forma colaborativa, executa as seguintes operações de forma paralela:
      - Somatório dos Totais
      - Somatório dos subtotais por grupo
      - O número de elementos cujo total seja menor que 5
      - O número de elementos cujo total seja maior ou igual a 5
3. Execute os testes, com as seguintes variações:
    - N = 5, 7, 9
    - T = 1, 4, 16, 64, 256
5. Para cada teste registre o tempo gasto na etapa de Processamento.

## Build do projeto
Antes de mais nada tenha o **Java** instalado na sua maquina Linux ou MacOS.

Compile o projeto:
```bash
  cd src
  javac Main.java
```

## Rodando o projeto

Para rodar o projeto basta digitar `java Main.java <N> <T>` onde: 
- **N**: significa 10ˆN objetos a serem criados
- **T**: significa q quantidade de threads a serem criadas na fase de processamento do projeto.

Ex:
```
  java Main.java 2 4
```
significa que vai criar `10ˆ2 = 100` objetos e processá-los em `4` threads 
