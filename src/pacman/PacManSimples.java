package pacman;

import java.awt.Color;
import java.awt.Graphics2D;

// Classe responsável por desenhar o Pac-Man (versão simples, sem animação)
public class PacManSimples {

    // Desenha um Pac-Man amarelo (círculo com um recorte simulando a boca)
    public static void pac(Graphics2D g2d, int x, int y, int largura, int altura) {
        g2d.setColor(Color.YELLOW);
        g2d.fillArc(x, y, largura, altura, 30, 300);
    }
}
