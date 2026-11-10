import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// 1. Criamos a janela principal do jogo
public class JogoMovimentacao extends JFrame {

    public JogoMovimentacao() {
        setTitle("Sistema de Movimentação em Java");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Adiciona o painel onde o desenho será renderizado
        PainelJogo painel = new PainelJogo();
        add(painel);
    }

    public static void main(String[] args) {
        // Garante que a interface gráfica rode na thread correta
        SwingUtilities.invokeLater(() -> {
            JogoMovimentacao jogo = new JogoMovimentacao();
            jogo.setVisible(true);
        });
    }
}

// 2. Criamos o painel que desenha e escuta o teclado
class PainelJogo extends JPanel implements KeyListener {

    // Posição inicial do nosso desenho (um quadrado)
    private int x = 375;
    private int y = 275;
    private final int LARGURA_BLOCO = 50;
    private final int ALTURA_BLOCO = 50;
    private final int VELOCIDADE = 15; // Quantos pixels ele anda por clique

    public PainelJogo() {
        setBackground(Color.BLACK); // Fundo preto
        setFocusable(true);         // Permite que o painel foque e capture o teclado
        addKeyListener(this);       // Adiciona o ouvinte de teclado ao painel
    }

    // 3. O método paintComponent é onde desenhamos na tela
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa a tela antes de desenhar novamente

        // Ativa o Anti-aliasing para deixar as bordas do desenho mais suaves
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenha o Pac-Man na posição atual
        PacMam1.pac(g2d, x, y, LARGURA_BLOCO, ALTURA_BLOCO);
    }

    // 4. Captura quando uma tecla é pressionada
    @Override
    public void keyPressed(KeyEvent e) {
        int codigoTecla = e.getKeyCode();

        // Altera as coordenadas baseando-se na tecla pressionada
        if (codigoTecla == KeyEvent.VK_UP || codigoTecla == KeyEvent.VK_W) {
            y -= VELOCIDADE; // Sobe (no Java, o Y diminui para cima)
        }
        if (codigoTecla == KeyEvent.VK_DOWN || codigoTecla == KeyEvent.VK_S) {
            y += VELOCIDADE; // Desce
        }
        if (codigoTecla == KeyEvent.VK_LEFT || codigoTecla == KeyEvent.VK_A) {
            x -= VELOCIDADE; // Esquerda
        }
        if (codigoTecla == KeyEvent.VK_RIGHT || codigoTecla == KeyEvent.VK_D) {
            x += VELOCIDADE; // Direita
        }

        // Força o Java a redesenhar a tela chamando o paintComponent novamente
        repaint();
    }

    // Métodos obrigatórios da interface KeyListener (podem ficar vazios)
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}