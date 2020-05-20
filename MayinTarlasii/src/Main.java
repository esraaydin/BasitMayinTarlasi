
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        int satir,sutun;
        
        System.out.println("Mayın tarlasına hoşgeldiniz...");
        System.out.println("Oyunun boyutlarını giriniz...");
        
        System.out.print("Satır sayısı:");
        satir = sc.nextInt();
        System.out.print("Sütun sayısı:");
        sutun = sc.nextInt();
        
        MayinTarlasi mayin= new MayinTarlasi(satir, sutun);
        mayin.calistir();
        
    }
    
}
