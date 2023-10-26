import java.lang.StringBuffer;
public class stringTimeCompare {
    public static void main(String args[]){
        int i;
        long start, finish, t1, t2;
        start = System.currentTimeMillis();
        String s1 = "hi";
        for(i=0; i<10000; i++){
            s1 = s1 +"gh";
        }
        finish = System.currentTimeMillis();
        t1 = finish - start;
        start = System.currentTimeMillis();
        StringBuffer s2 = new StringBuffer("hi");
        for(i=0; i<10000; i++){
            s2.append("gh");
        }
        finish = System.currentTimeMillis();
        t2 = finish - start;
        System.out.println("Cong xau: " + t1 +"ms" + "\nStringBuffer: " + t2 +"ms");
    }
}
