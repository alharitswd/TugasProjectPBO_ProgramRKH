class Hotel {
    private boolean[] kamarTersedia;

    public Hotel(int jumlahKamar) {
        kamarTersedia = new boolean[jumlahKamar];
        for (int i = 0; i < jumlahKamar; i++) {
            kamarTersedia[i] = true;
        }
    }

    public void tampilkanKetersediaanKamar() {
        System.out.println("\nKetersediaan Kamar Hotel:");
        for (int i = 0; i < kamarTersedia.length; i++) {
            System.out.println("Kamar " + (i + 1) + ": " + (kamarTersedia[i] ? "Tersedia" : "Terisi"));
        }
    }

    public boolean reservasiKamar(int nomorKamar) {
        if (nomorKamar >= 1 && nomorKamar <= kamarTersedia.length) {
            if (kamarTersedia[nomorKamar - 1]) {
                kamarTersedia[nomorKamar - 1] = false;
                System.out.println("Reservasi berhasil. Kamar " + nomorKamar + " telah dipesan.");
                return true;
            } else {
                System.out.println("Maaf, kamar " + nomorKamar + " sudah terisi.");
                return false;
            }
        } else {
            System.out.println("Nomor kamar tidak valid.");
            return false;
        }
    }

    public int getJumlahKamar() {
        return kamarTersedia.length;
    }

    public int getJumlahKamarTerisi() {
        int jumlahKamarTerisi = 0;
        for (boolean tersedia : kamarTersedia) {
            if (!tersedia) {
                jumlahKamarTerisi++;
            }
        }
        return jumlahKamarTerisi;
    }
}