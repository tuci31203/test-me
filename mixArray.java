import java.util.Scanner;
import java.util.Random;
public class mixArray {
    public static void main(String args[]){
        Random rand = new Random();
        try (//Input
        Scanner read = new Scanner(System.in)) {
            System.out.println("Nhap so phan tu cua day: ");
            int n = read.nextInt();
            System.out.println("Nhap cac phan tu cua day");
            int[] arr = new int [n];
            int i;
            for (i = 0; i<n ;i++)
                arr[i] = read.nextInt();
            read.close();
            System.out.println("Day da nhap la: ");
            for (i = 0; i<n; i++) if (i<n-1)System.out.print(arr[i] + ", "); else System.out.print(arr[i] +".");
            //Shuffle
            int temp;
            for (int j=0; j<n; j++){
                int a = rand.nextInt(n);
                temp = arr[j];
                arr[j] = arr[a];
                arr[a] = temp;
            }
            //Output
            System.out.println("\nDay da tron la: ");
            for (i = 0; i<n; i++) if (i<n-1)System.out.print(arr[i] + ", "); else System.out.print(arr[i] +".");
        }
}
}