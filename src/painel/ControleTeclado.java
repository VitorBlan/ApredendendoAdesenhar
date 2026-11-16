package painel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import pacman.Direcao;
import pacman.PacMan;

// Traduz as teclas apertadas em movimentos do Pac-Man.
// KeyAdapter já traz keyTyped e keyReleased vazios, então só
// precisamos escrever o keyPressed.

public class ControleTeclado extends KeyAdapter {

    private final PacMan pacMan;

    public ControleTeclado(PacMan pacMan) {
        this.pacMan = pacMan;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Direcao direcao = direcaoDaTecla(e.getKeyCode());
        if (direcao != null) {
            pacMan.mover(direcao);
        }
    }

    // Setas ou W/A/S/D. Devolve null se a tecla não for de movimento.
    private Direcao direcaoDaTecla(int codigoTecla) {
        return switch (codigoTecla) {
            case KeyEvent.VK_UP, KeyEvent.VK_W    -> Direcao.CIMA;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S  -> Direcao.BAIXO;
            case KeyEvent.VK_LEFT, KeyEvent.VK_A  -> Direcao.ESQUERDA;
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> Direcao.DIREITA;
            default -> null;
        };
    }
}
