class Ordenador {

    // Atributo privado (encapsulamiento)
    private int[] arreglo;

    // Método para cargar arreglo
    public void cargarArreglo(int[] datos) {
        arreglo = datos.clone();
    }

    // Método para mostrar arreglo
    public void mostrarArreglo() {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método para obtener copia del arreglo
    public int[] obtenerArreglo() {
        return arreglo.clone();
    }

    // QuickSort
    public void quickSort() {
        quickSortRecursivo(0, arreglo.length - 1);
    }

    private void quickSortRecursivo(int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particion(inicio, fin);
            quickSortRecursivo(inicio, pivote - 1);
            quickSortRecursivo(pivote + 1, fin);
        }
    }

    private int particion(int inicio, int fin) {
        int pivote = arreglo[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                intercambiar(i, j);
            }
        }

        intercambiar(i + 1, fin);
        return i + 1;
    }

    // MergeSort
    public void mergeSort() {
        mergeSortRecursivo(0, arreglo.length - 1);
    }

    private void mergeSortRecursivo(int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;

            mergeSortRecursivo(izquierda, medio);
            mergeSortRecursivo(medio + 1, derecha);

            mezclar(izquierda, medio, derecha);
        }
    }

    private void mezclar(int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        int[] izq = new int[n1];
        int[] der = new int[n2];

        for (int i = 0; i < n1; i++)
            izq[i] = arreglo[izquierda + i];

        for (int j = 0; j < n2; j++)
            der[j] = arreglo[medio + 1 + j];

        int i = 0, j = 0, k = izquierda;

        while (i < n1 && j < n2) {
            if (izq[i] <= der[j]) {
                arreglo[k] = izq[i];
                i++;
            } else {
                arreglo[k] = der[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arreglo[k] = izq[i];
            i++;
            k++;
        }

        while (j < n2) {
            arreglo[k] = der[j];
            j++;
            k++;
        }
    }

    // Método auxiliar
    private void intercambiar(int i, int j) {
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }
}
