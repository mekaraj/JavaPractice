import java.util.Arrays;

/**
 * Created by Prashant on 23/10/16.
 *
 * Bubble sort: "Push" the largest number to the end
 * Arrays: Declaration of an array and its initialization using {}
 * Arrays: Passed by reference, no need to return them from methods
 *
 */
public class Sorting {

    public static void main(String[] args) {
        int[] toSort = {4,3,5,2,6,1,7,9,8};
//        int[] toSort = {4,3,5,6,2};
        //bubbleSort(toSort);
        mergeSort(toSort);
        System.out.println(Arrays.toString(toSort));
    }

    private static void bubbleSort(int[] toSort) {
        for(int i = 0; i < toSort.length; i++) {
            for (int j = 0; j < toSort.length - i - 1; j++) {
                System.out.println(i + "," + j + "," + Arrays.toString(toSort));
                if(toSort[j] > toSort[j+1]) {
                    swap(toSort, j, j+1);
                }
            }
        }
    }

    private static void mergeSort(int[] toSort) {

    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
