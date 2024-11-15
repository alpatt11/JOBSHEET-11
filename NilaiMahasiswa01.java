import java.util.Scanner;

public class NilaiMahasiswa01 {
    private String[] namaMahasiswa;
    private int[][] nilaiMahasiswa;
    private int jumlahMahasiswa;
    private int jumlahMinggu;
    private Scanner scanner;

    public NilaiMahasiswa01() {
        scanner = new Scanner(System.in);
        setupProgram();
    }

    private void setupProgram() {
        System.out.println("=== Setup Program Nilai Mahasiswa ===");
        System.out.print("Masukkan jumlah mahasiswa: ");
        jumlahMahasiswa = inputAngka(1, 100);
        
        System.out.print("Masukkan jumlah minggu/tugas: ");
        jumlahMinggu = inputAngka(1, 16);

        namaMahasiswa = new String[jumlahMahasiswa];
        nilaiMahasiswa = new int[jumlahMahasiswa][jumlahMinggu];
        
        inputDataMahasiswa();
    }

    private void inputDataMahasiswa() {
        System.out.println("\n=== Input Data Mahasiswa ===");
        
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\nData mahasiswa ke-" + (i + 1));
            System.out.print("Masukkan nama mahasiswa: ");
            scanner.nextLine(); 
            namaMahasiswa[i] = scanner.nextLine();
            
            for (int minggu = 0; minggu < jumlahMinggu; minggu++) {
                System.out.print("Masukkan nilai minggu ke-" + (minggu + 1) + ": ");
                nilaiMahasiswa[i][minggu] = inputAngka(0, 100);
            }
        }
    }

    public void inputNilai() {
        System.out.print("Masukkan nama mahasiswa: ");
        scanner.nextLine(); 
        String nama = scanner.nextLine();
        
        int indexMahasiswa = cariIndexMahasiswa(nama);
        if (indexMahasiswa != -1) {
            System.out.print("Masukkan minggu (1-" + jumlahMinggu + "): ");
            int minggu = inputAngka(1, jumlahMinggu) - 1;
            
            System.out.print("Masukkan nilai baru: ");
            int nilai = inputAngka(0, 100);
            
            nilaiMahasiswa[indexMahasiswa][minggu] = nilai;
            System.out.println("Nilai berhasil diubah!");
        } else {
            System.out.println("Mahasiswa tidak ditemukan!");
        }
    }

    public void tampilkanNilai() {
        System.out.println("\n=== Data Nilai Mahasiswa ===");
        
        
        System.out.print("Nama\t");
        for (int i = 0; i < jumlahMinggu; i++) {
            System.out.print("M" + (i + 1) + "\t");
        }
        System.out.println();
        
        
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.print(namaMahasiswa[i] + "\t");
            for (int j = 0; j < jumlahMinggu; j++) {
                System.out.print(nilaiMahasiswa[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void tampilkanNilaiTertinggi() {
        int nilaiMax = 0;
        int mingguMax = 0;
        String namaMax = "";
        
        for (int i = 0; i < jumlahMahasiswa; i++) {
            for (int j = 0; j < jumlahMinggu; j++) {
                if (nilaiMahasiswa[i][j] > nilaiMax) {
                    nilaiMax = nilaiMahasiswa[i][j];
                    mingguMax = j;
                    namaMax = namaMahasiswa[i];
                }
            }
        }
        
        System.out.println("\n=== Nilai Tertinggi ===");
        System.out.println("Nama: " + namaMax);
        System.out.println("Pada minggu ke-" + (mingguMax + 1));
        System.out.println("Dengan nilai: " + nilaiMax);
    }

    private int cariIndexMahasiswa(String nama) {
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (namaMahasiswa[i].equalsIgnoreCase(nama)) {
                return i;
            }
        }
        return -1;
    }

    private int inputAngka(int min, int max) {
        while (true) {
            try {
                int nilai = scanner.nextInt();
                if (nilai >= min && nilai <= max) {
                    return nilai;
                } else {
                    System.out.print("Masukkan angka antara " + min + "-" + max + ": ");
                }
            } catch (Exception e) {
                System.out.print("Masukkan angka yang valid: ");
                scanner.next(); 
            }
        }
    }

    public static void main(String[] args) {
        NilaiMahasiswa01 program = new NilaiMahasiswa01();
        Scanner menuScanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Menu Program Nilai Mahasiswa ===");
            System.out.println("1. Tampilkan Nilai");
            System.out.println("2. Input/Ubah Nilai");
            System.out.println("3. Tampilkan Nilai Tertinggi");
            System.out.println("4. Keluar");
            
            System.out.print("\nPilih menu (1-4): ");
            String pilihan = menuScanner.nextLine();
            
            switch (pilihan) {
                case "1":
                    program.tampilkanNilai();
                    break;
                case "2":
                    program.inputNilai();
                    break;
                case "3":
                    program.tampilkanNilaiTertinggi();
                    break;
                case "4":
                    System.out.println("Terima kasih telah menggunakan program!");
                    menuScanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}