package mapa;

import java.awt.Color;
import java.awt.Graphics2D;

// O labirinto: '#' é parede, 'o' é bolinha, '-' é a porta da casa dos fantasmas
// e espaço é corredor vazio. Mapa de 28 colunas x 28 linhas.
public class Mapa {

    // 28 blocos x 30 pixels = 840 pixels (cabe na janela de 900 de largura)
    private static final int TAMANHO_BLOCO = 30; // Tamanho de cada quadradinho em pixels

    public final String[] mapa = {
        "############################",
        "#oooooooooooo##oooooooooooo#",
        "#o#### o####o##o    o#### o#",
        "#o     o####o##o    o#### o#",
        "#oooooooooooooooooooooooooo#",
        "#o#### o##  ####### o#### o#",
        "#o     o##     #    o     o#",
        "#ooooooo##     #    ooooooo#",
        "###### o######      o#######",
        "###### o##          o#######",
        "###### o##          o#######",
        "###### o##  ###-### o#######",
        "###### o##  #     # o#######",
        "       o    #     # o       ",
        "       o    ####### o       ",
        "###### o##          o#######",
        "###### o##          o#######",
        "###### o##          o#######",
        "###### o##          o#######",
        "###### o##  ########o#######",
        "#oooooooooooooo#ooooooooooo#",
        "#o   ####o  o  #   ####o  o#",
        "#oooooo##oooooooooooooooooo#",
        "#o    o##o  o          o####",
        "####  o##o  o########  o  o#",
        "#o    o##o  o    #     o  o#",
        "#oooooooooooooooooooooooooo#",
        "############################"
    };

    // O for precisa ficar DENTRO de um método (não pode ficar solto na classe)
    public void desenhar(Graphics2D g) {
        for (int y = 0; y < mapa.length; y++) {           // array: length sem ()
            for (int x = 0; x < mapa[y].length(); x++) {  // String: length() com ()
                char c = mapa[y].charAt(x);
                if (c == '#') {
                    // Escolhe a cor ANTES de desenhar: parede é azul
                    g.setColor(Color.BLUE);

                    // Desenha a parede: a coluna/linha vira posição em pixels
                    g.fillRect(x * TAMANHO_BLOCO, y * TAMANHO_BLOCO, TAMANHO_BLOCO, TAMANHO_BLOCO);
                }
                if (c == 'o') {
                    // Escolhe a cor ANTES de desenhar: bolinha é branca
                    g.setColor(Color.WHITE);
                    // Bolinha pequena no meio do bloco (8 pixels de diâmetro)
                    int tamanho = 8;
                    int deslocamento = (TAMANHO_BLOCO - tamanho) / 2;
                    g.fillOval(x * TAMANHO_BLOCO + deslocamento, y * TAMANHO_BLOCO + deslocamento, tamanho, tamanho);
                }
                if (c == '-') {
                    // Porta da casa dos fantasmas: faixa rosa no topo do bloco
                    g.setColor(Color.MAGENTA);
                    g.fillRect(x * TAMANHO_BLOCO, y * TAMANHO_BLOCO, TAMANHO_BLOCO, TAMANHO_BLOCO / 3);
                }

                // Espaço vazio: não precisa desenhar nada, o fundo já é preto
            }
        }
    }
}
