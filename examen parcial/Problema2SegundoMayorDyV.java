public class Problema2SegundoMayorDyV {

    /**
     * Estructura para devolver máximo y segundo máximo de un subarreglo.
     */
    private static class Resultado {
        int mayor;
        Integer segundoMayor; // puede ser null si no existe segundo

        Resultado(int mayor, Integer segundoMayor) {
            this.mayor = mayor;
            this.segundoMayor = segundoMayor;
        }
    }

    /**
     * Retorna el segundo elemento más grande del arreglo.
     * Lanza excepción si no existe (tamaño menor a 2 o todos iguales con lógica estricta).
     */
    public static int segundoMayor(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Se requieren al menos 2 elementos.");
        }
        Resultado res = resolver(arr, 0, arr.length - 1);
        if (res.segundoMayor == null) {
            throw new IllegalArgumentException("No existe segundo mayor válido en el arreglo.");
        }
        return res.segundoMayor;
    }

    /**
     * Divide y vencerás:
     * - Divide el arreglo en dos mitades
     * - Resuelve cada mitad
     * - Combina los resultados para obtener mayor y segundo mayor globales
     */
    private static Resultado resolver(int[] arr, int l, int r) {
        if (l == r) {
            return new Resultado(arr[l], null);
        }

        int mid = l + (r - l) / 2;
        Resultado izq = resolver(arr, l, mid);
        Resultado der = resolver(arr, mid + 1, r);

        return combinar(izq, der);
    }

    /**
     * Combina dos resultados parciales.
     */
    private static Resultado combinar(Resultado a, Resultado b) {
        int mayorGlobal;
        Integer segundoGlobal;

        if (a.mayor >= b.mayor) {
            mayorGlobal = a.mayor;
            segundoGlobal = maxNoNulo(a.segundoMayor, b.mayor);
        } else {
            mayorGlobal = b.mayor;
            segundoGlobal = maxNoNulo(b.segundoMayor, a.mayor);
        }

        return new Resultado(mayorGlobal, segundoGlobal);
    }

    /**
     * Máximo entre dos Integer permitiendo null.
     */
    private static Integer maxNoNulo(Integer x, Integer y) {
        if (x == null) return y;
        if (y == null) return x;
        return Math.max(x, y);
    }
}
