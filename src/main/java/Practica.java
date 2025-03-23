import java.util.HashMap;
import java.util.Map;

public class Practica {
    static final int wheels = 4;
     String color;
    int x = 5;
    public static void main(String[] args) {
        Map<String,String> body = new HashMap<>();
        body.put("person1","Petya");
        body.put("person2","vasya");
        body.put("person3","Dima");
        String a = "turandot ";
        String b = "princess";
        String c = "the ";
        String d = a.concat(c).concat(b);
        System.out.println(d);
        for(String temp:body.keySet()){
         System.out.println(body.get(temp));

     }
        Practica p = new Practica();
        p.color = "green";
        System.out.println(Practica.wheels);
}}