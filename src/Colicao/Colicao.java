package Colicao;


public class Colicao {

    public static boolean colidiu(String[] mapa, int x, int y) {
        if (mapa[y].charAt(x) == '#') { // String: usa charAt(x), não [x]
            // Colisão com a parede
            return true;
        } else {
            // Não há colisão
            return false;
        }
    }
}
