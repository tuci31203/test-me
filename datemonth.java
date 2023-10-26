import java.util.Scanner;
public class datemonth {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int year = read.nextInt();
        int month = read.nextInt();
        read.close();
        System.out.println("So ngay cua thang " + month + " nam " + "la: " + getDay(month,year));
    }
        static int getDay(int th, int n){
            switch(th){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: return 31;
                case 4:
                case 6:
                case 9: return 30;
                case 2: if(((n %4 == 0)&&(n %100 != 0))||(n %400==0))
                            return 29;
                        else return 28;
                default: return -1;
            }
    }
}