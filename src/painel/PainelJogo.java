package painel;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import mapa.Mapa;
import pacman.PacMan;

// A área de desenho do jogo: cria o Pac-Man, liga o teclado
// e redesenha a tela umas 60 vezes por segundo.
public class PainelJogo extends JPanel {

    private static final int INTERVALO_MS = 16; // ~60 quadros por segundo

    private final Mapa mapa = new Mapa();
    private final PacMan pacMan = new PacMan(375, 275);

    public PainelJogo() {
        setBackground(Color.BLACK);
        setDoubleBuffered(true); // Reduz flickering
        setPreferredSize(new java.awt.Dimension(800, 600));
        
        setFocusable(true); // Permite que o painel receba o teclado
        addKeyListener(new ControleTeclado(pacMan));

        // A cada quadro: anima a boca e pede para redesenhar
        Timer timer = new Timer(INTERVALO_MS, e -> {
            pacMan.animarBoca(INTERVALO_MS / 1000.0);
            repaint();
        });
        timer.start();
    }

    // O paintComponent é o ÚNICO lugar onde desenhamos na tela
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa a tela antes de desenhar de novo

        // Anti-aliasing deixa as bordas do desenho mais suaves
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        mapa.desenhar(g2d);   // Primeiro o mapa (fica no fundo)...
        pacMan.desenhar(g2d); // ...depois o Pac-Man por cima
    }
}
