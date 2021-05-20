public class merge_sort {
    public static void merge_sort(int[] x){
        merge_sort(x, 0, x.length-1);
    }
    private static void merge_sort(int [] x, int start, int end){
        if (start < end){
            int middle = start + (end-start)/2;
            merge_sort(x, start, middle);
            merge_sort(x, middle + 1, end);

            merge(x, start, end, middle);
        }
    }
    public static void merge(int [] x, int start, int end, int middle){
        int size = middle - start + 1;
        int[] a = new int[size];
        int[] b = x;
        for (int i = 0; i < size; ++i) {
            a[i] = x[i + start];
        }
        int i = 0, j = middle + 1, l = start;
        while (i < size && j < end + 1){
            if (a[i] <= x[j]) {
                b[l] = a[i];
                i++;
                l++;
            }
            else {
                b[l] = x[j];
                j++;
                l++;
            }
        }
        while (i < size) {
            b[l] = a[i];
            i++;
            l++;
        }
        while (j < end + 1) {
            b[l] = x[j];
            j++;
            l++;
        }
    }
}

