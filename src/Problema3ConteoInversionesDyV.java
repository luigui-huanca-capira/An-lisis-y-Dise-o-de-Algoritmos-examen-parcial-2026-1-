public class Problema3ConteoInversionesDyV {

    /**
     * Cuenta inversiones en O(n log n) usando estrategia tipo Merge Sort.
     */
    public static long contarInversiones(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int[] copia = arr.clone();
        int[] temp = new int[arr.length];
        return contarRec(copia, temp, 0, copia.length - 1);
    }

    /**
     * Divide y vencerás:
     * T(n) = 2T(n/2) + O(n)
     */
    private static long contarRec(int[] arr, int[] temp, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        long invIzq = contarRec(arr, temp, l, mid);
        long invDer = contarRec(arr, temp, mid + 1, r);
        long invCruce = mergeYContar(arr, temp, l, mid, r);

        return invIzq + invDer + invCruce;
    }

    /**
     * Durante el merge:
     * Si arr[i] > arr[j], entonces hay (mid - i + 1) inversiones.
     */
    private static long mergeYContar(int[] arr, int[] temp, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = l;
        long inversiones = 0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversiones += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        for (int p = l; p <= r; p++) {
            arr[p] = temp[p];
        }

        return inversiones;
    }
}
