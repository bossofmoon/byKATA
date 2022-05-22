import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean arab=false;
    static boolean rims=false;

    static boolean error=false;
    static String[] arr= {"I","II","III","IV","V","VI","VII","VIII", "IX", "X"};
    static String[] rim= {"0","1","2","3","4","5","6","7","8", "9", "10"};
    public static void main(String[] args) {
        try {
            start();
        }catch (Exception x){
            System.out.println("Упс.. ошибочка: "+x);
            start();
        }
    }
    public static void start(){
        arab=false;
        rims=false;
        error=false;
        Scanner sc = new Scanner(System.in);
        System.out.println("введите выражение:");
        String str = sc.nextLine();
        for(String s:arr){
            if(str.contains(s)){ arab=true; break;}
        }
        for(String s:rim){
            if(str.contains(s)){ rims=true; break;}
        }
        if(arab & rims){
            // Выводим ошибку
            // 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
            System.out.println("Error");
            start();
        }else{
            if (str.contains("+")) {
                p(str);
            }else{
            if (str.contains("-")) {
                m(str);
            }else{
                if (str.contains("*")) {
                    u(str);
                }else{
                    if (str.contains("/")) {
                        d(str);
                    }else{
                        System.out.println("Ошибка, такой опирации нет!)");
                        start();
                    }
                }
            }
            }

        }
    }
    static void p(String str){
        String[] x = str.replace(" ","").split("\\+");
        int a=a(x[0]);
        int b=b(x[1]);
        int o=a + b;
        otvet(o);

    }
    static void m(String str){
        String[] x = str.split("-");
        int a=a(x[0]);
        int b=b(x[1]);
        int o=a - b;
        otvet(o);
    }
    static void u(String str){
        String[] x = str.split("\\*");
        int a=a(x[0]);
        int b=b(x[1]);
        int o=a * b;
        otvet(o);
    }
    static void d(String str){
        String[] x = str.split("/");
        int a=a(x[0]);
        int b=b(x[1]);
        int o=a / b;
        otvet(o);
    }

    static int a(String x1){
        int x=0;
        if(arab){
            x= Arrays.asList(arr).indexOf(x1)+1;
        }else{
            if (rims) {
                x = Integer.parseInt(x1);
            }else{
                System.out.println("Ошибка ввода!");
                System.out.println("Используйте значения:");
                System.out.println("I,II,III,IV,V,VI,VII,VIII,IX,X");
                System.out.println("или");
                System.out.println("0,1,2,3,4,5,6,7,8,9,10");
                start();
            }
        }

        if(x>10 || (arab & x==0)){
            System.out.println("Ошибка! Значение больше 10");
            error=true;
            start();
        }

        return x;
    }
    static int b(String x2){
        int x=0;
        if(arab){
            x= Arrays.asList(arr).indexOf(x2)+1;
        }else{
            if (rims) {
                x = Integer.parseInt(x2);
            }else{
                System.out.println("Ошибка ввода!");
                System.out.println("Используйте значения:");
                System.out.println("I,II,III,IV,V,VI,VII,VIII,IX,X");
                System.out.println("или");
                System.out.println("0,1,2,3,4,5,6,7,8,9,10");
                start();
            }
        }
        if(x>10 || (arab & x==0)){
            System.out.println("Ошибка! Значение больше 10");
            error=true;
            start();
        }
        return x;
    }

    static void otvet(int o){
        if(error){
            System.out.println("Ошибка! Нельзя вводить значение больше 10");
            start();
        }else{
        if(arab){
            if(o==0){ System.out.println("nulla");}
            if(o<0){System.out.println("в римской системе нет отрицательных чисел");
            }else{
            System.out.println(integerToRoman(o));}
        }else{
            System.out.println(o);
        }
        start();
        }
    }
    public static String integerToRoman(int num) {
        int[] values = {100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }

}