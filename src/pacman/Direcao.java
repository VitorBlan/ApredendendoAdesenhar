package pacman;

// As quatro direções em que o Pac-Man pode andar.
// Cada direção sabe quanto soma em X e em Y a cada passo.
public enum Direcao {
    CIMA(0, -1),     // no Java, o Y diminui para cima
    BAIXO(0, 1),
    ESQUERDA(-1, 0),
    DIREITA(1, 0);

    private final int passoX;
    private final int passoY;

    Direcao(int passoX, int passoY) {
        this.passoX = passoX;
        this.passoY = passoY;
    }

    public int getPassoX() {
        return passoX;
    }

    public int getPassoY() {
        return passoY;
    }
}
