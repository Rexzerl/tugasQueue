package tugasQueue;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan kapasitas antrian: ");
        int kapasitas = s.nextInt();
        antrian a = new antrian(kapasitas);
        int pilih = 0;
        
        do {
            System.out.println("\nSistem Antrian Rumah Sakit");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Panggil Pasien Berikutnya");
            System.out.println("3. Lihat Daftar Antrian");
            System.out.println("4. Keluar");
            System.out.print("Pilihan : ");
            pilih = s.nextInt();
            
            switch(pilih) {
                case 1: 
                    System.out.print("Masukkan nama pasien: ");
                    s.nextLine(); // Membersihkan buffer
                    String nama = s.nextLine();
                    System.out.print("Masukkan prioritas (1-10, 10 tertinggi): ");
                    int prioritas = s.nextInt();
                    a.enqueue(nama, prioritas); 
                    a.tampil();
                    break;
                case 2:
                    String nm = a.dequeue();
                    if(!nm.isEmpty())
                        System.out.println("Memanggil pasien: " + nm);
                    a.tampil();
                    break;
                case 3:
                    a.tampil();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem ini");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 4);
    }
}