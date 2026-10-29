[README (1).md](https://github.com/user-attachments/files/34152235/README.1.md)

# 📚 Estrutura de Dados I – Pilhas e Filas

Repositório com as **Tarefas de Implementação 2 (Pilhas)** e **3 (Filas)** da disciplina de Estrutura de Dados I.

| | |
|---|---|
| **Universidade** | Universidade Federal do Sul e Sudeste do Pará (UNIFESSPA) |
| **Faculdade** | Sistemas de Informação, Instituto de Geociências e Engenharias |
| **Disciplina** | Estrutura de Dados I, Turma SI-2026 |
| **Docente** | Prof. Adam D. F. dos Santos |
| **Linguagem** | Java |

## 👥 Autoria

- João Paulo Sousa Mesquita
- Karine Francisca Pardim Messias
- Maria Luiza O. Rodrigues

## 🗂️ Estrutura do projeto

```
src/
└── Pilhas_Filas/
    ├── Pilha.java            # Pilha genérica (usa LinkedList por dentro)
    ├── PrincipalPilha.java   # Tarefa 2: métodos de pilha + testes
    ├── Fila.java             # Fila genérica
    └── PrincipalFila.java    # Tarefa 3: métodos de fila + testes
```

## 🧱 Estruturas utilizadas

**Pilha** (LIFO: o último a entrar é o primeiro a sair)

| Método | O que faz |
|---|---|
| `push(elemento)` | empilha no topo |
| `pop()` | remove e devolve o elemento do topo |
| `peek()` | consulta o topo sem remover |
| `tamanho()` | quantidade de elementos |
| `vazia()` | `true` se não há elementos |
| `clear()` | esvazia a pilha |

**Fila** (FIFO: o primeiro a entrar é o primeiro a sair)

| Método | O que faz |
|---|---|
| `enqueue(elemento)` | entra no final da fila |
| `dequeue()` | remove e devolve o primeiro da fila |
| `tamanho()` | quantidade de elementos |
| `vazia()` | `true` se não há elementos |

---

## ✅ Tarefa de Implementação 2: Pilhas (10 pontos)

| # | Questão | Assinatura | Pontos | Status |
|---|---|---|:---:|:---:|
| 1 | Remover elementos maiores que um valor | `void removerMaioresQue(Pilha<Integer> pilha, int limite)` | 2,0 | ⬜ |
| 2 | Verificar palíndromo | `boolean ehPalindromo(String texto)` | 2,5 | ⬜ |
| 3 | Inverter a ordem dos elementos | `Pilha<Integer> inverterPilha(Pilha<Integer> original)` | 2,0 | ⬜ |
| 4 | Somar os elementos da pilha | `int somarElementos(Pilha<Integer> pilha)` | 2,0 | ✅ |
| 5 | Parênteses balanceados | `boolean verificarBalanceamento(String texto)` | 1,5 | ⬜ |

### Como funciona: `somarElementos`

Para somar sem perder os elementos, cada valor é retirado da pilha, somado e guardado numa **pilha auxiliar**. No final, tudo volta para a pilha original e a ordem é preservada (a ordem inverte duas vezes).

```java
public static int somarElementos(Pilha<Integer> pilha) {
    int soma = 0;
    Pilha<Integer> auxSoma = new Pilha<>();

    while (!pilha.vazia()) {
        int valor = pilha.pop();
        soma += valor;
        auxSoma.push(valor);
    }
    while (!auxSoma.vazia()) {
        pilha.push(auxSoma.pop());
    }
    return soma;
}
```

**Exemplo de saída**

```
Soma dos elementos: 10
Pilha: [3, 5, 2]
```

---

## ✅ Tarefa de Implementação 3: Filas (10 pontos)

| # | Questão | Assinatura | Pontos | Status |
|---|---|---|:---:|:---:|
| 1 | Mover o primeiro elemento para o final | `void moverPrimeiroParaFinal(Fila<Integer> fila)` | 1,0 | ⬜ |
| 2 | Combinar duas filas | `Fila<Integer> combinarFilas(Fila<Integer> f1, Fila<Integer> f2)` | 3,0 | ✅ |
| 3 | Inverter uma fila | `void inverterFila(Fila<Integer> fila)` | 3,0 | ✅ |
| 4 | Contar ocorrências de um elemento | `int contarOcorrencias(Fila<String> fila, String valor)` | 3,0 | ⬜ |

### Como funciona: `combinarFilas`

Cria uma fila nova e copia primeiro os elementos de `f1`, depois os de `f2`. Cada elemento retirado é devolvido ao final da fila de origem. Como isso é feito exatamente `tamanho()` vezes, as filas originais voltam na mesma ordem.

```java
public static Fila<Integer> combinarFilas(Fila<Integer> f1, Fila<Integer> f2) {
    Fila<Integer> resultado = new Fila<>();

    int tamanho1 = f1.tamanho();
    for (int i = 0; i < tamanho1; i++) {
        int valor = f1.dequeue();
        resultado.enqueue(valor);
        f1.enqueue(valor);
    }

    int tamanho2 = f2.tamanho();
    for (int i = 0; i < tamanho2; i++) {
        int valor = f2.dequeue();
        resultado.enqueue(valor);
        f2.enqueue(valor);
    }
    return resultado;
}
```

**Exemplo de saída**

```
f1: [1, 2]
f2: [3, 4]
Resultado: [1, 2, 3, 4]
```

### Como funciona: `inverterFila`

A fila só permite tirar o primeiro elemento. Por isso, passamos tudo para uma **pilha auxiliar** (que inverte a ordem por ser LIFO) e depois devolvemos tudo para a fila.

```java
public static void inverterFila(Fila<Integer> fila) {
    Pilha<Integer> auxiliar = new Pilha<>();

    while (!fila.vazia()) {
        auxiliar.push(fila.dequeue());
    }
    while (!auxiliar.vazia()) {
        fila.enqueue(auxiliar.pop());
    }
}
```

**Exemplo de saída**

```
Antes:  [1, 2, 3]
Depois: [3, 2, 1]
```

---

## ▶️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU-USUARIO/NOME-DO-REPOSITORIO.git
   ```
2. Abra a pasta no IntelliJ IDEA (ou outra IDE Java).
3. Execute a classe `PrincipalPilha` ou `PrincipalFila`.

## 📌 Observações

- Os métodos foram implementados usando apenas os métodos das classes `Pilha` e `Fila`, conforme as instruções do professor.
- Sempre que um método precisa preservar a estrutura original, os elementos são devolvidos na mesma ordem.
