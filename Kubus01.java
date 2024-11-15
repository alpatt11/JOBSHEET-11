import java.util.Scanner;

public class Kubus01{
    
    static int hitungVolume(int sisi) {
        return sisi * sisi * sisi;
    }
    
    
    static int hitungLuasPermukaan(int sisi) {
        return 6 * sisi * sisi;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Masukkan panjang sisi kubus: ");
        int sisi = input.nextInt();
        
        System.out.println("Volume kubus adalah: " + hitungVolume(sisi));
        System.out.println("Luas permukaan kubus adalah: " + hitungLuasPermukaan(sisi));
        
        input.close();
    }
}