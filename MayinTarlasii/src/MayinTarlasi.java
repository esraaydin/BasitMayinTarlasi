
import java.util.Random;
import java.util.Scanner;
import jdk.nashorn.internal.ir.BreakNode;


public class MayinTarlasi {
    int satirSayisi, sutunSayisi, boyut;
    int[][] harita;
    int[][] oyuntablosu; 
    boolean oyun= true;
    
    Random rand= new Random();
    Scanner sc= new Scanner(System.in);

    public MayinTarlasi(int satirsayisi, int sutunsayisi) {
        this.satirSayisi=satirsayisi;
        this.sutunSayisi=sutunsayisi;
        
        this.harita= new int[satirsayisi][sutunsayisi];
        this.oyuntablosu= new int[satirsayisi][sutunsayisi];
        this.boyut = satirSayisi*sutunSayisi;
    }
    
    public void calistir(){
        int satir, sutun, puan = 0;
        oyunuOlustur();
        print(harita);
        System.out.println("Oyun Başlıyor ...");
        while(oyun){
            print(oyuntablosu);
            System.out.println("Satır :");
            satir = sc.nextInt();
            System.out.println("Sütun :");
            sutun = sc.nextInt();
            if(harita[satir][sutun] != -1){
                kontrol(satir,sutun);
                puan++;
                if(puan == (boyut - (boyut/4))){
                    System.out.println("Tebrikler başardın ...");
                    break;
                }
            }
            else{
                oyun = false;
                System.out.println("Oyun Bitti ... ");
            }
                    
        }
    }
    public void kontrol(int str , int stn){
        if(harita[str][stn] == 0){
           if((stn<sutunSayisi -1 )&&harita[str][stn+1] == -1){
            oyuntablosu[str][stn]++;
        }
        if((str < satirSayisi -1)&&harita[str+1][stn] == -1){
            oyuntablosu[str][stn]++;
        }
        if((str > 0)&&harita[str-1][stn] == -1){
            oyuntablosu[str][stn]++;
        }
        if((stn > 0)&&harita[str][stn-1] == -1){
            oyuntablosu[str][stn]++;
        }
        if(oyuntablosu[str][stn]==0){
            oyuntablosu[str][stn] = -2;
        }
        
    }
    }
    public void oyunuOlustur(){
       int randSatir, randSutun, sayac=0;
       while(sayac !=(boyut/4)){
           randSatir = rand.nextInt(satirSayisi);
           randSutun = rand.nextInt(sutunSayisi);
           
           if(harita[randSatir][randSutun] != -1){
              harita[randSatir][randSutun] = -1;
              sayac++;
           }
       }
           
    }
    
    public void print(int[][] dizi){
        for(int i=0; i< dizi.length; i++ ){
            for(int j=0; j< dizi[0].length; j++){
                if(dizi[i][j] >=0 )
                    System.out.print(" ");
                System.out.print(dizi[i][j]+" ");
            }
            System.out.println("");
        }
        
    }
    
}
