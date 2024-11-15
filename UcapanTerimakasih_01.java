import java.util.Scanner;

public class UcapanTerimakasih_01 {
    public static String PenerimaUcapan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tuliskan NAMA orang yang ingin Anda beri ucapan:");
        String namaOrang = sc.nextLine();
        sc.close();
        return namaOrang;
    }
    
    public static void UcapanTerimakasih() {
        String nama = PenerimaUcapan();
        System.out.println("Thank you " + nama + " for being the best teacher in the world.\n" +
                         "You inspired in me a love for learning and made me feel like I could ask you anything.");
        
        UcapanTambahan(nama);
    }
    
    public static void UcapanTambahan(String nama) {
        System.out.println("\nDear " + nama + ",\n" +
                         "Semoga selalu diberi kesehatan dan kesuksesan dalam mengajar.\n" +
                         "May the force be with you!");
    }
    
    public static void main(String[] args) {
        UcapanTerimakasih();
    }
}