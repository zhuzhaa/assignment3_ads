public class quick_sort {
    public void quick_sort(int[] x){
        quick_sort(x, 0, x.length-1);
    }
    private void quick_sort(int[] x, int start, int end){
        if (start<end){
            int pi = partition(x, start, end);
            quick_sort(x, start, pi-1);
            quick_sort(x, pi+1, end);
        }
    }
    private int partition(int[] x,  int start, int end){
        int pivot = x[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (x[j] <= pivot) {
                int swap = x[i];
                x[i] = x[j];
                x[j] = swap;
                i++;
            }
        }
        int swapTemp = x[i];
        x[i] = x[end];
        x[end] = swapTemp;
        return i;
    }
}

