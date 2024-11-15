public class TerimaKasih_01 {
    
    public static void UcapanTerimakasih() {
        System.out.println("Thank you for being the best teacher in the world.\n" +
                         "You inspired in me a love for learning and made me feel like I could ask you anything.");
    }
    
    
    public static void UcapanTambahan(String ucapan) {
        System.out.println(ucapan);
    }
    
    
    public static void main(String[] args) {
        UcapanTerimakasih();
        String ucapan = "Terima Kasih Pak.. Bu.. Semoga Sehat Selalu";
        UcapanTambahan(ucapan);
    }
}