import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import painel.PainelJogo;

// Janela principal do jogo (é por aqui que o programa começa)
public class Jogo extends JFrame {

    private final PainelJogo painel = new PainelJogo();

    public Jogo() {
        setTitle("Pac-Man em Java");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        add(painel);
    }

    public static void main(String[] args) {
        // Garante que a interface gráfica rode na thread correta
        SwingUtilities.invokeLater(() -> {
            Jogo jogo = new Jogo();
            jogo.setVisible(true);
            jogo.painel.requestFocusInWindow(); // Dá o foco ao painel para ele receber o teclado
        });
    }
}
