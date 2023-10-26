import java.util.Scanner;

public class seriesMatrix {
    public static void main(String args[]){
        // INPUT
        try(Scanner read = new Scanner(System.in)){
            System.out.print("Nhap n = ");
            int n = read.nextInt();
            while(!((3<=n)&&(n<=8))){
                System.out.print("Vui long nhap lai n (3 <= n <= 8), n = ");
                n = read.nextInt();
            }
            //PRINT MATRIX
            int x,y;
            for(y=0; y<n; y++){
                for(x=0; x<n; x++)
                    System.out.print((x+1)+y*3 + "\t");
                System.out.println();
            }
        }
    }
}
