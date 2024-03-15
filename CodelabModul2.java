import java.util.Scanner;

class CodelabModul2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mahasiswa mahasiswa = new Mahasiswa("", 0, "");

        while (true) {
            System.out.println("\n1. Input Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Exit");
            System.out.print("Pilihan Anda: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                System.out.print("Masukkan nama mahasiswa: ");
                scanner.nextLine(); // membersihkan newline di buffer
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM mahasiswa (15 digit): ");
                long nim = scanner.nextLong(); // menggunakan long untuk NIM
                if (String.valueOf(nim).length() != 15) {
                    System.out.println("NIM harus memiliki 15 digit.");
                    continue;
                }
                System.out.print("Masukkan jurusan mahasiswa: ");
                scanner.nextLine(); // membersihkan newline di buffer
                String jurusan = scanner.nextLine();
                mahasiswa.setNama(nama);
                mahasiswa.setNim(nim);
                mahasiswa.setJurusan(jurusan);
                System.out.println("Data mahasiswa berhasil ditambahkan.");
            } else if (pilihan == 2) {
                if (mahasiswa.getNim() == 0) {
                    System.out.println("Belum ada data mahasiswa.");
                } else {
                    System.out.println("\nData Mahasiswa:");
                    System.out.println("Nama: " + mahasiswa.getNama());
                    System.out.println("NIM: " + mahasiswa.getNim());
                    System.out.println("Jurusan: " + mahasiswa.getJurusan());
                    System.out.println("Universitas: " + Mahasiswa.tampilUniversitas());
                }
            } else if (pilihan == 3) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}

class Mahasiswa {
    private String nama;
    private long nim; // Menggunakan long untuk NIM
    private String jurusan;

    public Mahasiswa(String nama, long nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public static String tampilUniversitas() {
        return "Universitas Muhammadiyah Malang";
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public long getNim() {
        return nim;
    }

    public void setNim(long nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}