import java.util.Scanner;

public class App {
    public static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        char[][] arena = new char[3][3];
        while (true) {
            System.out.println("---Turno X---");
            imprimirMatriz(arena);
            popularMatrizX(arena);

            if (checarVitoriaX(arena)) {
                System.out.println("Vitória do Player X!");
                imprimirMatriz(arena);
                break;
            } else if (checarVitoriaO(arena)) {
                System.out.println("---Turno O---");
                imprimirMatriz(arena);
                break;
            } else if (checarEmpate(arena)) {
                System.out.println("Deu velha!");
                imprimirMatriz(arena);
                break;
            }
            System.out.println("Turno do O");
            imprimirMatriz(arena);
            popularMatrizO(arena);

            if (checarVitoriaX(arena)) {
                System.out.println("Vitória do Player X!");
                imprimirMatriz(arena);
                break;
            } else if (checarVitoriaO(arena)) {
                System.out.println("Vitória do Player O!");
                imprimirMatriz(arena);
                break;
            } else if (checarEmpate(arena)) {
                System.out.println("Deu velha!");
                imprimirMatriz(arena);
                break;
            }
        }
    }

    public static void popularMatrizX(char[][] arena) {
        int x, y;

        while (true) {
            System.out.println("Insira a coordenada que deseja jogar (linha x coluna)");
            x = sc.nextInt();
            y = sc.nextInt();

            if (arena[x][y] != 0) {
                System.out.println("Essa casa já foi escolhida!");
            } else {
                arena[x][y] = 'X';
                break;
            }
        }

    }

    public static void popularMatrizO(char[][] arena) {
        int x, y;

        while (true) {
            System.out.println("Insira a coordenada que deseja jogar (linha x coluna)");
            x = sc.nextInt();
            y = sc.nextInt();

            if (arena[x][y] != 0) {
                System.out.println("Essa casa já foi escolhida!\n");
            } else {
                arena[x][y] = 'O';
                break;
            }
        }
    }

    public static void imprimirMatriz(char[][] arena) {
        for (int i = 0; i < arena.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < arena[i].length; j++) {
                char elemento = arena[i][j];
                String display = (elemento == 0) ? " " : String.valueOf(elemento);
                System.out.print(display + " | ");
            }

            System.out.println();
            System.out.println("-------------");
        }
    }

    public static boolean checarEmpate(char arena[][]) {

        for (int i = 0; i < arena.length; i++) {
            for (int j = 0; j < arena.length; j++) {
                if (arena[i][j] == 0) {
                    return false;
                }
            }

        }

        return true;
    }

    public static boolean checarVitoriaX(char arena[][]) {
        boolean linhaVencedora;
        boolean colunaVencedora;
        for (int i = 0; i < arena.length; i++) {
            linhaVencedora = true;
            for (int j = 0; j < arena.length; j++) {
                if (arena[i][j] != 'X') {
                    linhaVencedora = false;
                    break;
                }
            }

            if (linhaVencedora) {
                return true;

            }
        }
        for (int j = 0; j < arena.length; j++) {
            colunaVencedora = true;
            for (int i = 0; i < arena.length; i++) {
                if (arena[i][j] != 'X') {
                    colunaVencedora = false;
                    break;
                }
            }
            if (colunaVencedora) {
                return true;

            }

        }
        boolean diagPrincipal = true;
        boolean diagSecundaria = true;

        for (int i = 0; i < arena.length; i++) {
            if (arena[i][i] != 'X') {
                diagPrincipal = false;
            }
            if (arena[i][arena.length - 1 - i] != 'X') {
                diagSecundaria = false;
            }
        }

        if (diagPrincipal || diagSecundaria) {
            return true;
        }
        return false;
    }

    public static boolean checarVitoriaO(char arena[][]) {
        boolean linhaVencedora;
        boolean colunaVencedora;
        for (int i = 0; i < arena.length; i++) {
            linhaVencedora = true;
            for (int j = 0; j < arena.length; j++) {
                if (arena[i][j] != 'O') {
                    linhaVencedora = false;
                    break;
                }
            }

            if (linhaVencedora) {
                return true;

            }
        }
        for (int j = 0; j < arena.length; j++) {
            colunaVencedora = true;
            for (int i = 0; i < arena.length; i++) {
                if (arena[i][j] != 'O') {
                    colunaVencedora = false;
                    break;
                }
            }
            if (colunaVencedora) {
                return true;

            }

        }
        boolean diagPrincipal = true;
        boolean diagSecundaria = true;

        for (int i = 0; i < arena.length; i++) {
            if (arena[i][i] != 'O') {
                diagPrincipal = false;
            }
            if (arena[i][arena.length - 1 - i] != 'O') {
                diagSecundaria = false;
            }
        }

        if (diagPrincipal || diagSecundaria) {
            return true;
        }
        return false;
    }

}