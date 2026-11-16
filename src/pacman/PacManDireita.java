package pacman;

import java.awt.Color;
import java.awt.Graphics2D;

import graficos.WeilGraficos;

// Pac-Man animado olhando para a direita
public class PacManDireita extends WeilGraficos {

	private double tempoBoca = 0; // acumula o tempo para animar a abertura da boca

	public PacManDireita() {
		super("Pac man olhando para a direita", 800, 600);
	}

	@Override
	public void onDraw(Graphics2D g, double deltaTime) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight()); // pinta o fundo de preto

		tempoBoca += deltaTime;

		desenhar(g, 100, 100, 200, tempoBoca);
	}

	/**
	 * Desenha o "pacman" (arco amarelo com boca animada + olho) dentro do quadrado
	 * x, y, tamanho x tamanho. tempoBoca é o tempo acumulado usado para animar a abertura.
	 */
	public static void desenhar(Graphics2D g, int x, int y, int tamanho, double tempoBoca) {
		// oscila entre 5 e 35 graus de abertura, de forma suave (abre e fecha)
		double abertura = 5 + 30 * Math.abs(Math.sin(tempoBoca * 4));

		g.setColor(Color.YELLOW);
		// boca centrada no ângulo 0 (lado direito), com abertura "abertura" graus para cima e para baixo
		g.fillArc(x, y, tamanho, tamanho, (int) abertura, 360 - (int) (abertura * 2));

		// olho (um pouco deslocado para a direita, para onde ele está olhando)
		g.setColor(Color.BLACK);
		g.fillOval(x + tamanho * 55 / 100, y + tamanho / 5, tamanho / 10, tamanho / 10);
	}

	public static void main(String[] args) {
		new PacManDireita().iniciarGraficos();
	}
}
