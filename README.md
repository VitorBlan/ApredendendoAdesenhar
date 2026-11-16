# Pac-Man em Java 🟡

<img width="4530" height="1184" alt="image" src="https://github.com/user-attachments/assets/a005d845-b68f-4cfd-bdc7-2204adb427be" />


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

