package myClassPackage;

import java.io.*;
import java.util.*;
 
public class exception{
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            int count = 0;
            long tong = 0;
            int n;
            String s;
            
            while(true){
                s = sc.nextLine();
                try{
                    checkNullString(s);
                    if(s.trim().equals("ket thuc")) break;//ket thuc chuong trinh
                    n = Integer.parseInt(s);
                    System.out.println("n="+n);
                    count++;
                    tong+=n;
                    System.out.println("Trung binh cong="+(double)tong/count);
                }
                catch(NullStringException nse){
                    System.out.println("Yeu cau nhap lai do xau nhap vao bi null");
                }
                catch(NumberFormatException e){
                    System.out.println("Yeu cau nhap vao so nguyen 32-bit");
                }    
                
            } // end while
        }
    } // end main
    
    static void checkNullString(String s) throws NullStringException{
        if(s==null||s.equals("")) throw new NullStringException("NullString!");
    }
    
} //end test class

 

class NullStringException extends Exception {
    public NullStringException(String msg){
        super(msg);
    }
    
} 
