public class Problema1ArregloOrdenado {

    /**
     * Verifica recursivamente si el arreglo está ordenado de menor a mayor.
     */
    public static boolean estaOrdenado(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        return estaOrdenadoRec(arr, 0);
    }

    /**
     * Caso base: al llegar al último índice, no hay más pares por comparar.
     * Paso recursivo: compara arr[i] <= arr[i+1] y continúa.
     */
    private static boolean estaOrdenadoRec(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return estaOrdenadoRec(arr, i + 1);
    }
}
