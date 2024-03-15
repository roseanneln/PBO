import java.util.Scanner;
import java.util.ArrayList;

public class Tugas2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("==== Library System ====:");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Admin admin = new Admin(scanner);
                    admin.menuAdmin();
                    break;
                case 2:
                    Student student = new Student(scanner);
                    student.menuStudent();
                    break;
                case 3:
                    System.out.println("Thank you. Exiting Program");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }
}

class Buku {
    private String id_buku;
    private String judul;
    private String author;
    private int stok;

    public Buku(String id_buku, String judul, String author, int stok) {
        this.id_buku = id_buku;
        this.judul = judul;
        this.author = author;
        this.stok = stok;
    }

    public String getId() {
        return id_buku;
    }

    public String getJudul() {
        return judul;
    }

    public String getAuthor() {
        return author;
    }

    public int getStok() {
        return stok;
    }

    // Method untuk mengurangi stok buku
    public void setStok(int stok) {
        this.stok = stok;
    }
}

class Student {
    private Scanner scanner;

    private String nama;
    private String fakultas;
    private String programStudi;
    private String nim;  // Tambahkan atribut nim

    // Menambahkan beberapa contoh buku
    private ArrayList<Buku> daftarBuku = new ArrayList<>();

    public Student(Scanner scanner) {
        this.scanner = scanner;

        // Menambahkan beberapa contoh buku
        Buku buku1 = new Buku("001", "Kancil Mencuri Timun", "Kim Jennie", 10);
        Buku buku2 = new Buku("002", "Timun Mas", "Park Chaeyoung", 5);
        Buku buku3 = new Buku("003", "Malin Kundang", "Lisa", 8);

        daftarBuku.add(buku1);
        daftarBuku.add(buku2);
        daftarBuku.add(buku3);
    }

    // Tambahkan metode getNim
    public String getNim() {
        return nim;
    }
    // Metode untuk menampilkan daftar buku
    public void tampilkanDaftarBuku() {
        System.out.println("Daftar Buku:");
        for (Buku buku : daftarBuku) {
            System.out.println("ID: " + buku.getId());
            System.out.println("Judul: " + buku.getJudul());
            System.out.println("Author: " + buku.getAuthor());
            System.out.println("Stok: " + buku.getStok());
            System.out.println();
        }
    }

    // Method untuk meminjam buku
    public void pinjamBuku() {
        System.out.println("Masukkan ID Buku yang ingin dipinjam: ");
        String idBuku = scanner.nextLine();

        // Cari buku berdasarkan ID
        Buku bukuDipinjam = null;
        for (Buku buku : daftarBuku) {
            if (buku.getId().equals(idBuku)) {
                bukuDipinjam = buku;
                break;
            }
        }

        if (bukuDipinjam != null) {
            if (bukuDipinjam.getStok() > 0) {
                // Kurangi stok buku
                bukuDipinjam.setStok(bukuDipinjam.getStok() - 1);
                System.out.println("Buku berhasil dipinjam.");
            } else {
                System.out.println("Maaf, stok buku tidak mencukupi.");
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public void logout() {
        System.out.println("Logout berhasil.");
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getFakultas() {
        return fakultas;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public void menuStudent() {
        int pilihanMahasiswa;
        do {
            System.out.println("==== Student Menu ====:");
            System.out.println("1. Lihat Daftar Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Logout");
            System.out.print("Pilihan Anda: ");
            pilihanMahasiswa = scanner.nextInt();
            scanner.nextLine();

            switch (pilihanMahasiswa) {
                case 1:
                    tampilkanDaftarBuku();
                    break;
                case 2:
                    pinjamBuku();
                    break;
                case 3:
                    logout();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihanMahasiswa != 3);
    }
}

class Admin {
    private Scanner scanner;
    private ArrayList<Student> daftarMahasiswa = new ArrayList<>();

    public Admin(Scanner scanner) {
        this.scanner = scanner;
    }

    public void menuAdmin() {
        int pilihanAdmin;
        do {
            System.out.println("==== Admin Menu ====:");
            System.out.println("1. Add  Student");
            System.out.println("2. Display Registered Student");
            System.out.println("3. Logout");
            System.out.print("Pilihan Anda: ");
            pilihanAdmin = scanner.nextInt();
            scanner.nextLine();

            switch (pilihanAdmin) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tampilkanMahasiswa();
                    break;
                case 3:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihanAdmin != 3);
    }

    private void tambahMahasiswa() {
        System.out.println("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.println("Masukkan NIM Mahasiswa (harus 15 karakter): ");
        String nim = scanner.nextLine();
        System.out.println("Masukkan Fakultas Mahasiswa: ");
        String fakultas = scanner.nextLine();
        System.out.println("Masukkan Program Studi Mahasiswa: ");
        String programStudi = scanner.nextLine();

        if (nim.length() == 15) {
            Student mahasiswa = new Student(scanner);
            mahasiswa.setNama(nama);
            mahasiswa.setNim(nim);
            mahasiswa.setFakultas(fakultas);
            mahasiswa.setProgramStudi(programStudi);
            daftarMahasiswa.add(mahasiswa);

            System.out.println("Mahasiswa berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan mahasiswa. Panjang NIM harus 15 karakter.");
        }
    }

    private void tampilkanMahasiswa() {
        System.out.println("Daftar Mahasiswa:");
        for (Student mahasiswa : daftarMahasiswa) {
            System.out.println("Nama: " + mahasiswa.getNama());
            System.out.println("NIM: " + mahasiswa.getNim());
            System.out.println("Fakultas: " + mahasiswa.getFakultas());
            System.out.println("Program Studi: " + mahasiswa.getProgramStudi());
            System.out.println();
        }
    }
}