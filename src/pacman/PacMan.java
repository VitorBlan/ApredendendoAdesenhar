package pacman;

import java.awt.Graphics2D;

// O personagem: guarda onde ele está, para onde olha e o tempo da boca.
// Não sabe nada de teclado nem de janela, só se move, anima e se desenha.
public class PacMan {

    private static final int TAMANHO = 50;     // Largura e altura do Pac-Man
    private static final int VELOCIDADE = 15;  // Quantos pixels ele anda por passo

    private int x;
    private int y;
    private Direcao direcao = Direcao.DIREITA; // Para onde o Pac-Man está olhando
    private double tempoBoca = 0;              // Tempo acumulado para animar a boca

    public PacMan(int xInicial, int yInicial) {
        this.x = xInicial;
        this.y = yInicial;
    }

    // Vira para a direção pedida e anda um passo nela
    public void mover(Direcao novaDirecao) {
        direcao = novaDirecao;
        x += novaDirecao.getPassoX() * VELOCIDADE;
        y += novaDirecao.getPassoY() * VELOCIDADE;
    }

    // Avança a animação da boca
    public void animarBoca(double segundos) {
        tempoBoca += segundos;
    }

    // Desenha o Pac-Man virado para a direção atual
    public void desenhar(Graphics2D g) {
        switch (direcao) {
            case CIMA     -> PacManCima.desenhar(g, x, y, TAMANHO, tempoBoca);
            case BAIXO    -> PacManBaixo.desenhar(g, x, y, TAMANHO, tempoBoca);
            case ESQUERDA -> PacManEsquerda.desenhar(g, x, y, TAMANHO, tempoBoca);
            case DIREITA  -> PacManDireita.desenhar(g, x, y, TAMANHO, tempoBoca);
        }
    }
}
