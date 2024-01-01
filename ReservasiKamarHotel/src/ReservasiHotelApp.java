import java.util.Scanner;

class ReservasiHotelApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hotel hotel = new Hotel(5);

        int pilihan;
        Pembayaran pembayaran = null;

        do {
            System.out.println("\nMenu Reservasi Hotel:");
            System.out.println("1. Tampilkan Ketersediaan Kamar");
            System.out.println("2. Reservasi Kamar");
            System.out.println("3. Tampilkan Rincian Pesanan");
            System.out.println("4. Bayar");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1/2/3/4/5): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    hotel.tampilkanKetersediaanKamar();
                    break;
                case 2:
                    System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
                    int nomorKamar = scanner.nextInt();
                    if (hotel.reservasiKamar(nomorKamar)) {
                        int hargaKamar = 300000;
                        pembayaran = new Pembayaran( hotel.getJumlahKamarTerisi() * hargaKamar);
                    }
                    break;
                case 3:
                    if (pembayaran != null) {
                        System.out.println("\nRincian Pesanan:");
                        System.out.println("Jumlah Kamar Dipesan: " + hotel.getJumlahKamarTerisi());
                        System.out.println("Nomor Kamar yang Dipesan: ");
                        System.out.println("Total Harga: Rp " + pembayaran.getTotalHarga());
                        System.out.println("Metode Pembayaran: " + pembayaran.getMetodePembayaran());
                        System.out.println("Status Pembayaran: " + (pembayaran.getStatusPembayaran() ? "Sudah dibayar" : "Belum dibayar"));
                    } else {
                        System.out.println("Belum ada pesanan yang dibuat.");
                    }
                    break;
                case 4:
                    if (pembayaran != null && !pembayaran.getStatusPembayaran()) {
                        System.out.print("Pilih metode pembayaran (Cash/Card): ");
                        String metodePembayaran = scanner.next();
                        pembayaran.setMetodePembayaran(metodePembayaran);
                        pembayaran.bayar();
                    } else {
                        System.out.println("Tidak ada tagihan yang harus dibayar.");
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih atas reservasinya. Selamat tinggal!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}