public class Main {
    public static void main(String[] args) {
        // ---------------- PROBLEMA 1 ----------------
        int[] a1 = {1, 2, 3, 5, 8};
        int[] a2 = {1, 4, 2, 8};

        System.out.println("PROBLEMA 1:");
        System.out.println("[1,2,3,5,8] -> " + Problema1ArregloOrdenado.estaOrdenado(a1)); // true
        System.out.println("[1,4,2,8]   -> " + Problema1ArregloOrdenado.estaOrdenado(a2)); // false
        System.out.println();

        // ---------------- PROBLEMA 2 ----------------
        int[] b1 = {8, 3, 10, 5, 7};

        System.out.println("PROBLEMA 2:");
        System.out.println("[8,3,10,5,7] -> segundo mayor = " + Problema2SegundoMayorDyV.segundoMayor(b1)); // 8
        System.out.println();

        // ---------------- PROBLEMA 3 ----------------
        int[] c1 = {3, 1, 2};

        System.out.println("PROBLEMA 3:");
        System.out.println("[3,1,2] -> inversiones = " + Problema3ConteoInversionesDyV.contarInversiones(c1)); // 2
    }
}
