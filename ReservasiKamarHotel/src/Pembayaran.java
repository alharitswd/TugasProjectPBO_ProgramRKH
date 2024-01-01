import java.util.Random;

class Pembayaran {
    private int totalHarga;
    private String metodePembayaran;
    private boolean statusPembayaran;
    private String kodePembayaran;

    public Pembayaran(int totalHarga) {
        this.totalHarga = totalHarga;
        this.metodePembayaran = "";
        this.statusPembayaran = false;
        this.kodePembayaran = generateKodePembayaran();
    }

    private String generateKodePembayaran() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder kode = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            kode.append(chars.charAt(random.nextInt(chars.length())));
        }

        return kode.toString();
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public boolean getStatusPembayaran() {
        return statusPembayaran;
    }

    public String getKodePembayaran() {
        return kodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public void bayar() {
        System.out.println("\nRincian Pembayaran:");
        System.out.println("Kode Pembayaran: " + kodePembayaran);
        System.out.println("Total Harga: Rp " + totalHarga);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Status Pembayaran: Sudah dibayar");

        statusPembayaran = true;
        System.out.println("Pembayaran berhasil. Terima kasih!");
    }
}