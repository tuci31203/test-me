import java.util.Scanner;
public class starTriangle {
    public static void main(String args[]){
        //Input
        try (Scanner read = new Scanner(System.in)){
            System.out.print("Nhap h = ");
            int n = read.nextInt();
            while (!((2<=n)&&(n<=10))) {
                System.out.print("Vui long nhap lai h (2<=h<=10), h = ");
                n = read.nextInt();
            }
            //Triangle of asterisks
            int i,j,k;
            for(i=0; i<n; i++){
                k = 0;
                for(j=0; j<n-i-1;j++)
                    System.out.print(" ");
                while(k != 2*i+1){
                    System.out.print("*");
                    k++;
                }
                System.out.println();
            }
        }
    }
}
// tam giac vuong dang L thi bo phan them dau cach