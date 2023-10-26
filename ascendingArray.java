import java.util.Scanner;
public class ascendingArray {
    //MERGE SORT
    public static void sort(int[] arr){
        if (arr == null || arr.length <= 1) return;
        sort(arr, 0, arr.length - 1);
    }
    
    private static void sort(int[] arr, int left, int right){
        if (left >= right) return;
        int mid = (left +right)/2;
        sort(arr,left,mid);
        sort(arr,mid+1,right);
        merge(arr, left, mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right){
        int[] helper = new int[arr.length];
        int first1 = left; int last1 = mid;
        int first2 = mid+1; int last2 = right;
        int index = first1;
        for(;(first1 <= last1)&&(first2 <= last2);++index){
            if (arr[first1]<arr[first2]) {helper[index]=arr[first1]; ++first1;}
            else {helper[index]=arr[first2]; ++first2;}
        }
        for(;(first1<=last1); ++first1, ++index) helper[index]= arr[first1];
        for(;(first2<=last2); ++first2, ++index) helper[index]= arr[first2];
        for (index = left; index <= right; ++index) arr[index] = helper[index];
    }   

    //MAIN
    public static void main(String args[]){
        //Input
        try (Scanner read = new Scanner(System.in)){
            System.out.print("So phan tu cua day la: ");
            int n = read.nextInt();
            System.out.println("Nhap day:");
            int[] arr = new int[n];
            int i;
            for (i=0; i<n; i++) arr[i] = read.nextInt();
            System.out.print("\nDay da nhap la: ");
            for (i=0; i<n; i++)
                if (i<n-1) System.out.print(arr[i]+", ");
                else System.out.print(arr[i] + ".");
        //Sorting
            sort(arr);
        //Output
        System.out.print("\nDay duoc sap xep theo thu tu tang dan: ");
        for (i=0; i<n; i++)
            if (i<n-1) System.out.print(arr[i]+", ");
            else System.out.print(arr[i] + ".");
        }
    }
    
}
