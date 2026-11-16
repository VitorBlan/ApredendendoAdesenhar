package pacman;

import java.awt.Color;
import java.awt.Graphics2D;

import graficos.WeilGraficos;

// Pac-Man animado olhando para baixo
public class PacManBaixo extends WeilGraficos {

	private double tempoBoca = 0; // acumula o tempo para animar a abertura da boca

	public PacManBaixo() {
		super("Pac man olhando para baixo", 800, 600);
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
		// boca centrada no ângulo 270 (parte de baixo), com abertura "abertura" graus para os dois lados
		g.fillArc(x, y, tamanho, tamanho, (int) (270 + abertura), 360 - (int) (abertura * 2));

		// olho (deslocado para a direita do centro, já que a boca agora abre para baixo)
		g.setColor(Color.BLACK);
		g.fillOval(x + tamanho * 7 / 10, y + tamanho * 45 / 100, tamanho / 10, tamanho / 10);
	}

	public static void main(String[] args) {
		new PacManBaixo().iniciarGraficos();
	}
}
