package Colicao;

public class Colicao {

    // O if precisa ficar DENTRO de um método (
    // não pode ficar solto na classe)
    // x = coluna e y = linha do mapa (não pixels!)

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
