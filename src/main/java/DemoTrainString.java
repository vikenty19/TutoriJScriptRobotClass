public class DemoTrainString {
    public static void main(String[] args) {
        String s = "Fanny "+ "ttrip";
        System.out.println(s + (50+60) );
        System.out.println(50+60);
        System.out.println(50+60+s);
        System.out.println(s.substring(0,5));
       // System.out.println(s.indexOf("tt"));
        System.out.println(s.indexOf("Qa"));
        if(s.indexOf("Qa")==-1){
            System.out.println("no this word in this phrase");
        }
         String s2 =" My name-is ABCD-Efgh";
        String[]s3 = s2.split("-");
        for (String temp :s3){
            System.out.println(temp);

        }

        Integer obj = 3;
        System.out.println(obj.intValue());
        int x = obj;
        System.out.println(x);
    }
}
