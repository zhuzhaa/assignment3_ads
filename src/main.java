import java.util.Scanner;

public class main {
    public static void main(String[] args){
        System.out.println("Hash table:\n");
        hash_table hash = new hash_table();
        hash.put(1, "yellow");
        hash.put(2, "black");
        hash.put(3, "red");
        hash.put(4, "brown");
        hash.put(5, "pink");
        System.out.println("The value of element with key = 3: " + hash.getV(3));
        System.out.println("The key of element with value = yellow: " + hash.getK("yellow"));
        System.out.println("The hash table contains element with key 2: " + hash.containsK(2));
        System.out.println("The hash table contains element with value orange: " + hash.containsV("orange"));
        System.out.println("The value of removed element at key = 4: " + hash.remove(4));

        System.out.println("\nBibary Search Tree:\n");
        binary_tree bst = new binary_tree();
        bst.put(1, "A");
        bst.put(1, "H");
        bst.put(2, "C");
        bst.put(3, "E");
        bst.put(4, "F");
        bst.put(5, "M");
        System.out.println("The value of element with key = 3: " + bst.get(3));
        bst.delete(4);

        System.out.println("\nMerge Sort:\n");
        merge_sort msort = new merge_sort();
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[size];
        String s = scanner.nextLine();
        scanner.close();
        String[] q = s.split("[\\s]+");
        while (i < size) {
            arr[i] = Integer.parseInt(q[i]);
            i ++;
        }
        int[] arr1 = arr; //Copy array for quick sort
        System.out.println("Array after merge sort");
        msort.merge_sort(arr);
        for (int j = 0; j < size; j++)
            System.out.print(arr[j] + " ");
        System.out.println();

        System.out.println("\nQuick Sort:\n");
        quick_sort qsort = new quick_sort();
        System.out.println("Array after quick sort");
        qsort.quick_sort(arr1);
        for (int j = 0; j < size; j++)
            System.out.print(arr1[j] + " ");
        System.out.println();

    }
}