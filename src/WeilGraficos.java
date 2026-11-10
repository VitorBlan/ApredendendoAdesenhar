import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

// Classe base simples para desenhos animados: cuida da janela, do loop de
// repintura e do cálculo do deltaTime, deixando onDraw() para as subclasses.
public abstract class WeilGraficos extends JFrame {

    private final JPanel painel;
    private long ultimoTempo;

    public WeilGraficos(String titulo, int largura, int altura) {
        setTitle(titulo);
        setSize(largura, altura);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                long agora = System.nanoTime();
                double deltaTime = (agora - ultimoTempo) / 1_000_000_000.0;
                ultimoTempo = agora;

                onDraw(g2d, deltaTime);
            }
        };
        add(painel);
    }

    public abstract void onDraw(Graphics2D g, double deltaTime);

    @Override
    public int getWidth() {
        return painel.getWidth();
    }

    @Override
    public int getHeight() {
        return painel.getHeight();
    }

    public void iniciarGraficos() {
        ultimoTempo = System.nanoTime();
        setVisible(true);

        Timer timer = new Timer(16, e -> painel.repaint());
        timer.start();
    }
}
