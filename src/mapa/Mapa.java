package mapa;

import java.awt.Color;
import java.awt.Graphics2D;

// O labirinto: cada '#' é uma parede e cada espaço é um corredor.
public class Mapa {

    private static final int TAMANHO_BLOCO = 40; // Tamanho de cada quadradinho em pixels

    private final String[] mapa = {
        "####################",
        "#o o o o o o o o o  #",
        "# o #### o ## o #  o#",
        "# o #           #  o#",
        "# o #  ##  ##   #  o#",
        "# o o o o o o o    o#",
        "####################"
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
                    // Desenha a bolinha: a coluna/linha vira posição em pixels
                    g.fillOval(x * TAMANHO_BLOCO + 10, y * TAMANHO_BLOCO + 10, 20, 20);
                }

                // Espaço vazio: não precisa desenhar nada, o fundo já é preto
            }
        }
    }
}
