# Pac-Man em Java 🟡

Um projeto de estudo para aprender a **desenhar e animar com Java**, usando apenas o
que já vem com a linguagem (Swing e Java 2D), sem bibliotecas externas.

O Pac-Man é desenhado do zero com formas geométricas: a boca abre e fecha sozinha
e ele vira para o lado em que você manda andar.

## ✨ O que já funciona

- Janela de 800x600 com fundo preto
- Pac-Man desenhado com `fillArc` (corpo) e `fillOval` (olho)
- Boca animada que abre e fecha de forma suave (usando `Math.sin`)
- Movimento pelo teclado nas quatro direções
- O Pac-Man vira para a direção em que está andando
- Tela redesenhada a ~60 quadros por segundo

## 🎮 Controles

| Tecla           | Ação                 |
| --------------- | -------------------- |
| `↑` ou `W`      | Andar para cima      |
| `↓` ou `S`      | Andar para baixo     |
| `←` ou `A`      | Andar para esquerda  |
| `→` ou `D`      | Andar para direita   |

## 🚀 Como rodar

### Pré-requisitos

- **Java 14 ou mais novo** (o código usa `switch` com `->`). Testado com Java 21.

### Pelo VS Code

1. Instale o pacote de extensões **Extension Pack for Java**.
2. Abra a pasta do projeto.
3. Abra [src/Jogo.java](src/Jogo.java) e clique em **Run** em cima do método `main`.

### Pelo terminal

Na pasta do projeto:

```bash
javac -d bin -sourcepath src src/Jogo.java
java -cp bin Jogo
```

### Ver só a animação de uma direção

Cada classe de desenho também roda sozinha e mostra o Pac-Man grande, parado,
mexendo a boca. É útil para testar o desenho sem o resto do jogo:

```bash
java -cp bin pacman.PacManCima
java -cp bin pacman.PacManBaixo
java -cp bin pacman.PacManEsquerda
java -cp bin pacman.PacManDireita
```

## 📁 Estrutura do projeto

```
src/
├── Jogo.java                  # Ponto de entrada: cria a janela do jogo
├── painel/
│   ├── PainelJogo.java        # Área de desenho e loop de ~60 FPS
│   └── ControleTeclado.java   # Transforma teclas em movimentos
├── pacman/
│   ├── PacMan.java            # Posição, direção e animação do personagem
│   ├── Direcao.java           # Enum com CIMA, BAIXO, ESQUERDA, DIREITA
│   ├── PacManCima.java        # Desenho do Pac-Man olhando para cima
│   ├── PacManBaixo.java       # ... para baixo
│   ├── PacManEsquerda.java    # ... para a esquerda
│   └── PacManDireita.java     # ... para a direita
└── graficos/
    └── WeilGraficos.java      # Classe base para janelas com animação
```

## 🧠 Como funciona (resumo)

1. **`Jogo`** abre a janela e coloca nela um **`PainelJogo`**.
2. O **`PainelJogo`** tem um `Timer` que, a cada 16 ms, avança a animação da boca
   e chama `repaint()`.
3. O Swing então chama o `paintComponent`, que manda o **`PacMan`** se desenhar.
4. Quando você aperta uma tecla, o **`ControleTeclado`** descobre a **`Direcao`**
   e chama `pacMan.mover(...)`.
5. O **`PacMan`** escolhe qual classe de desenho usar (`PacManCima`, `PacManBaixo`...)
   de acordo com a direção atual.

A boca usa o tempo acumulado para calcular a abertura:

```java
double abertura = 5 + 30 * Math.abs(Math.sin(tempoBoca * 4)); // entre 5° e 35°
```

## 🗺️ Próximos passos

Ideias para continuar o projeto:

- [ ] Impedir que o Pac-Man saia da tela
- [ ] Movimento contínuo (continuar andando sem segurar a tecla)
- [ ] Desenhar um labirinto com paredes
- [ ] Bolinhas para comer e placar de pontos
- [ ] Fantasmas
- [ ] Telas de início e de fim de jogo

## 📚 O que estou aprendendo

- Desenho 2D com `Graphics2D` (`fillArc`, `fillOval`, `fillRect`, anti-aliasing)
- Animação com `javax.swing.Timer` e `deltaTime`
- Eventos de teclado com `KeyAdapter`
- Organização em pacotes e separação de responsabilidades
- `enum`, `switch` com `->` e herança com classes abstratas
