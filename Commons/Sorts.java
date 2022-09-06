package Commons;


public class Sorts {
    public static <E extends Comparable<E>> void MergeSort(E[] arr) {
        MergeSort(arr, 0, arr.length);
    }

    public static <E extends Comparable<E>> void MergeSort(E[] arr, int first, int last) {
        if (last == arr.length) {
            last--;
        }

        if (first < last) {
            int middle = (first + last) / 2;

            MergeSort(arr, first, middle);
            MergeSort(arr, middle + 1, last);

            Merge(arr, first, middle, last);
        }
    }

    public static <E extends Comparable<E>> void Merge(E[] arr, int first, int middle, int last) {
        int n1 = middle - first + 1;
        int n2 = last - middle;

        Object[] L = new Object[n1];
        Object[] R = new Object[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[first + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;

        int k = first;

        while (i < n1 && j < n2) {
            if (((E)L[i]).compareTo((E)R[j]) <= 0) {
                arr[k] = (E)L[i];
                i++;
            }
            else {
                arr[k] = (E)R[j];
                j++;
            }
            k++;
        }
        
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = (E)L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] =(E)R[j];
            j++;
            k++;
        }
    }

    public static void MergeSort(char[] arr) {
        MergeSort(arr, 0, arr.length);
    }

    public static void MergeSort(char[] arr, int first, int last) {
        if (last == arr.length) {
            last--;
        }

        if (first < last) {
            int middle = (first + last) / 2;

            MergeSort(arr, first, middle);
            MergeSort(arr, middle + 1, last);

            Merge(arr, first, middle, last);
        }
    }

    public static void Merge(char[] arr, int first, int middle, int last) {
        int n1 = middle - first + 1;
        int n2 = last - middle;

        char[] L = new char[n1];
        char[] R = new char[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[first + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;

        int k = first;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    public static void MergeSort(int[] arr) {
        MergeSort(arr, 0, arr.length);
    }

    public static void MergeSort(int[] arr, int first, int last) {
        if (last == arr.length) {
            last--;
        }

        if (first < last) {
            int middle = (first + last) / 2;

            MergeSort(arr, first, middle);
            MergeSort(arr, middle + 1, last);

            Merge(arr, first, middle, last);
        }
    }

    public static void Merge(int[] arr, int first, int middle, int last) {
        int n1 = middle - first + 1;
        int n2 = last - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[first + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;

        int k = first;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }

    public static int Partition(int[] arr, int low, int high) {
        int pivot = low++;

        while (low <= high) {
            while (arr[pivot] >= arr[low]) {
                low++;

                if (low > high){
                    break;
                }
            }
            while (arr[pivot] < arr[high]) {
                high--;

                if (high < low) {
                    break;
                }
            }

            if (low < high) {
                Swap(arr, low, high);
            }
        }
        Swap(arr, pivot, high);

        return high;
    }

    public static void QuickSort(int[] arr) {
        QuickSort(arr, 0, arr.length);
    }

    public static void QuickSort(int[] arr, int low, int high) {
        if (arr.length == high) {
            high--;
        }

        if (low < high) {
            int partitionIndex = Partition(arr, low, high);

            QuickSort(arr, low, partitionIndex - 1);
            QuickSort(arr, partitionIndex + 1, high);
        }
    }

    public static void BubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void BubbleSortRecur(int[] arr) {
        if (arr.length <= 0) {
            return;
        }
        BubbleSortRecur(arr, arr.length - 1);
    }

    public static void BubbleSortRecur(int[] arr, int high) {
        if (high == 0) {
            return;
        }
        else {
            BubbleSorting(arr, 0, high);
            BubbleSortRecur(arr, --high);
        }
    }

    private static void BubbleSorting(int[] arr, int low, int high) {
        if (high == low) {
            return;
        }
        else {
            if (arr[low] > arr[low + 1]) {
                int temp = arr[low];
                arr[low] = arr[low + 1];
                arr[low + 1] = temp;
            }
            BubbleSorting(arr, ++low, high);
        }
    }

    public static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                else {
                    break;
                }
            }
            
        }
    }

    public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            swap(arr, i, idx);
        }
    }
    public static void SelectionSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            swap(arr, i, idx);
        }
    }

    public static void SelectionSortRecur(int[] arr) {
        int startIdx = 0;
        if (arr.length <= 0) {
            return;
        }
        SelectionSortRecur(arr, startIdx);
    }

    public static void SelectionSortRecur(int[] arr, int stIdx) {
        if (stIdx == arr.length - 1) {
            return;
        }
        else {
            SelectionSorting(arr, stIdx, stIdx, stIdx);
            SelectionSortRecur(arr, ++stIdx);
        }
    }

    private static void SelectionSorting(int[] arr, int stIdx, int mIdx, int increment) {
        if (arr.length - 1 == increment) {
            swap(arr, stIdx, mIdx);
        }
        else {
            if (arr[mIdx] > arr[increment]) {
                mIdx = increment;
            }
            SelectionSorting(arr, stIdx, mIdx, ++increment);
        }
    }

    private static void swap(int[] arr, int sIdx, int lIdx) {
        int temp = arr[sIdx];
        arr[sIdx] = arr[lIdx];
        arr[lIdx] = temp;
    }

    private static void swap(double[] arr, int sIdx, int lIdx) {
        double temp = arr[sIdx];
        arr[sIdx] = arr[lIdx];
        arr[lIdx] = temp;
    }
}
