class bien{
    int value;
    public bien(int a){
        value = a;
    }
}

public class swaptest {
    public static void swap(bien a, bien b){
        int tmp = a.value;
            a.value = b.value;
            b.value = tmp;
    }
    public static void main(String args[]){
        bien a = new bien(1);
        bien b = new bien(2);
        System.out.println(a.value + "," + b.value);
        swap(a,b);
        System.out.println(a.value + "," + b.value);
    }
    
}
