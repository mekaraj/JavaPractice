/**
 * Created with IntelliJ IDEA.
 * User: Prashant
 * Date: 5/15/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */

import java.lang.*;

public class MinElementSortedArray {
    static int[] toFind = {4,5,6,7,8,9,1,2,3};
    static int[] toFind2 = {8,9,1,2,3,4,5,6,7};
    static int[] toFind3 = {8,9,1,2,3,4,5,6};
    static int[] toFind4 = {1,2,3,4};

    static int[] array = {5,2,8,6,8,9,3,4};
    private static int[] toSearch = {1,2,3,4,5,6,7,8,9,15};

    public static void main(String[] args) {
        System.out.println("min element is : " + minElement(toFind4));
        //System.out.println("Result of trying to find in array is : " + search(toSearch, 11));
    }

    private static int minElement(int[] toFind) {
        return findmin(toFind, 0, toFind.length-1);
    }

    private static int findmin(int[] toFind, int start, int end) {
        System.out.println(toFind[start] + " " + toFind[end]);
        if(start == end-1) return toFind[end];
        int mid = (start+end) / 2;
        if(toFind[start] > toFind[end]) {
            if(toFind[mid] > toFind[end]) {
                return findmin(toFind, mid, end);
            }
            else {
                return findmin(toFind, start, mid);
            }
        }
        return toFind[start];
    }
    private static boolean search(int[] searchArray, int searchElement) {
        return binarySearch(searchArray,searchElement,0,searchArray.length-1);
    }

    private static boolean binarySearch(int[] searchArray, int searchElement, int startIndex, int endIndex) {
        System.out.println(searchElement + " " + startIndex + " " + endIndex);
        if (startIndex > endIndex) return false;
        int mid = (startIndex + endIndex) / 2;
        if(searchArray[mid] == searchElement ) return true;
        else if(searchArray[mid] > searchElement) return binarySearch(searchArray, searchElement, startIndex, mid-1);
        else return binarySearch(searchArray, searchElement, mid+1, endIndex);
    }


}


/*
  Binary search: go to the middle of the array,
  - see if that is the element to find. if it is, done
  - if not, compare middle element with element.
    - If middle element is greater, binary search(0-(middleindex-1))
    - else binary search(middleindex+1), end)

*/