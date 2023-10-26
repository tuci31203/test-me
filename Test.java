public class Test {
    public static void main(String[] args){
        int th=2;
        int nam=1700;
        System.out.println("Ngay lay ra la " + layngaytrongthang(th,nam));
    }
   
    static int layngaytrongthang(int th, int n){
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
            case 2: if(((n%4==0)&&(n%100==0))||(n%400==0))
                        return 29;
                    else return 28;
            default: return -1;
        }
   
    }
}