import java.util.Scanner;

public class MainSPBU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianLinkedList antrian = new AntrianLinkedList();
        QueueTransaksi riwayat = new QueueTransaksi(100);

        int pilihan;
        do {
            System.out.println("\n--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor: ");
                    String platNomor = sc.nextLine();
                    System.out.print("Masukkan Jenis Kendaraan: ");
                    String tipe = sc.nextLine();
                    System.out.print("Masukkan Merk: ");
                    String merk = sc.nextLine();
                    Kendaraan k = new Kendaraan(platNomor, tipe, merk);
                    antrian.tambahAntrian(k);
                    break;
                case 2:
                    antrian.tampilkanAntrian();
                    break;
                case 3:
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + antrian.jumlahAntrian());
                    break;
                case 4:
                    Kendaraan dilayani = antrian.layaniKendaraan();
                    if (dilayani != null) {
                        System.out.println("Petugas melayani " + dilayani.platNomor);
                        System.out.print("Masukkan Jenis BBM: ");
                        String namaBBM = sc.nextLine();
                        System.out.print("Masukkan Harga per liter: ");
                        double harga = sc.nextDouble();
                        System.out.print("Masukkan Jumlah liter: ");
                        double liter = sc.nextDouble();
                        sc.nextLine(); 
                        BBM bbm = new BBM(namaBBM, harga);
                        TransaksiPengisian t = new TransaksiPengisian(dilayani, bbm, liter);
                        riwayat.enqueue(t);
                        System.out.println(">> Transaksi berhasil dicatat.");
                    }
                    break;
                case 5:
                    riwayat.tampilkanTransaksi();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0); 
    }
}
