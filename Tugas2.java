import java.util.ArrayList;
import java.util.Scanner;

class Main {
        String[] idBuku = new String[] {"101", "102", "103"};
        String[] namaBuku = new String[] {"Harry Potter", "Percy Jackson", "Romeo and Juliet"};
        String[] author = new String[] {"J. K. Rowling", "Rick Riordan", "William Shakespeare"};
        String[] category = new String[] {"Novel Fantasy", "Novel Fantasy", "Novel Romance"};
        int[] stock = new int[] {8, 5, 1};
    
    void Menu(){
        System.out.println("\n==== Library System ====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Pilihan Anda: ");
    }

    void menuStudent(){
        System.out.println("\n==== Student Menu ====");
        System.out.println("1. Buku terpinjam");
        System.out.println("2. Pinjam buku");
        System.out.println("3. Logout");
        System.out.print("Pilihan Anda: ");
    }

    void menuAdmin(){
        System.out.println("\n==== Admin Menu ====");
        System.out.println("1. Add Student");
        System.out.println("2. Display Registered Student");
        System.out.println("3. Logout");
        System.out.print("Pilihan Anda: ");
    }

    void bookList(){
        System.out.println("===========================================================================================================================================");
        System.out.println("|| No. || Id Buku\t\t || Nama Buku\t\t\t || Author\t\t || Category\t\t || Stock\t || ");
        for (int i = 0; i < 3; i++){
            System.out.printf("|| %d   || %s\t\t || %s\t\t\t || %s\t\t || %s\t\t || %d\t\t || \n", i, idBuku[i], namaBuku[i], author[i], category[i], stock[i]);
        }
        System.out.println("===========================================================================================================================================");
    }

    public static void main(String[] args) {
        Student student = new Student();
        Admin admin = new Admin();
        Main main = new Main();
        mainMenu:
        while (true) {
            main.Menu();
            Scanner scanInt = new Scanner(System.in);
            int pilih = scanInt.nextInt();
            if (pilih == 1) {
                if (student.checkStudent() == 0) {
                    continue mainMenu;
                }
                int j = 0;
                while (true) {
                    main.menuStudent();
                    pilih = scanInt.nextInt();
                    if (pilih == 1){
                        student.bukuTerpinjam();
                    } else if (pilih == 2){
                        student.pinjamBuku(j);
                        j++;
                    } else {
                        break;
                    }
                }
            } else if (pilih == 2) {
                if (admin.checkAdmin() == 0) {
                    continue mainMenu;
                }
                while (true) {
                    main.menuAdmin();
                    pilih = scanInt.nextInt();
                    int i = 0;
                    if (pilih == 1) {
                        admin.addStudent(i);
                        i++;
                    } else if (pilih == 2) {
                        admin.displayStudent(i);
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }
}

class Student {
    public static String[] nama = new String[10];
    public static String[] fakultas = new String[10];
    public static String[] nim = new String[15];
    public static String[] prodi = new String[10];
    public static String[] bukuTerpinjam = new String[10];

    int checkStudent(){
        Scanner scanString = new Scanner (System.in);
        System.out.print("Masukkan nim anda: ");
        String input = scanString.nextLine();
        for (int i = 0; i < nim.length; i++) {
            if (input.equals(nim[i])) {
                System.out.println("Sukses login sebagai student\n");
                return 1;
            } else {
                System.out.println("Nim tidak ditemukan\n");
                break;
            }
        }
        return 0;
    }
    void displayBook(Buku[] bookList) {
        System.out.println("Daftar Buku:");
        for (Buku buku : bookList) {
            System.out.println("ID: " + buku.getId());
            System.out.println("Judul: " + buku.getJudul());
            System.out.println("Author: " + buku.getAuthor());
            System.out.println("Stok: " + buku.getStok());
            System.out.println();
        }
    }
    void pinjamBuku(int j){
        Main main = new Main();
        Scanner scanString = new Scanner (System.in);
        System.out.print("Masukkan id buku yang ingin anda pinjam: ");
        String idBuku = scanString.nextLine();
        for (int i = 0; i < main.idBuku.length; i++) {
            if (main.idBuku[i].equals(idBuku)) {
                System.out.println("Buku id " + idBuku + " berhasil dipinjam");
                main.stock[i] -= 1;
                break;
            }
        }
        bukuTerpinjam[j] = idBuku;
    }

    void bukuTerpinjam(){
        System.out.println("Buku terpinjam: ");
        for (int i = 0; i < bukuTerpinjam.length; i++) {
            if (bukuTerpinjam[i] == null) {
                break;
            } else {
                System.out.printf("%d. %s", i+1, bukuTerpinjam[i]);
            }
        }
    }
}

class Admin {
    Student student = new Student();
    public static String username = "adm1n";
    public static String password = "123";

    int checkAdmin(){
        Scanner scanString = new Scanner(System.in);
        System.out.print("Enter your username (admin): ");
        String user = scanString.nextLine();
        System.out.print("Enter your password (admin): ");
        String pass = scanString.nextLine();
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Sukses login sebagai admin\n");
            return 1;
        }
        else {
            System.out.println("Admin tidak ditemukan\n");
            return 0;
        }
    }

    void addStudent(int i){
        Scanner scanString = new Scanner(System.in);
        System.out.print("Masukkan nama mahasiswa: ");
        Student.nama[i] = scanString.nextLine();

        System.out.print("Masukkan fakultas mahasiswa: ");
        Student.fakultas[i] = scanString.nextLine();

        System.out.print("Masukkan NIM mahasiswa: ");
        Student.nim[i] = scanString.nextLine();
        while(true){
            if (String.valueOf(Student.nim[i]).length() != 15 ) {
                System.out.print("Nim Harus 15 Digit!!!\n");
                System.out.print("Masukkan NIM mahasiswa: ");
                student.nim[i] = scanString.nextLine();
            } else {
                break;
            }
        }

        System.out.print("Masukkan jurusan mahasiswa: ");
        Student.prodi[i] = scanString.nextLine();

        System.out.print("Data Mahasiswa berhasil ditambahkan.\n");
    }

    void displayStudent(int i){
        
        System.out.println("Data mahasiswa ke " + (i+1));
        System.out.println("Nama: " + Student.nama[i]);
        System.out.println("Fakultas: " + Student.fakultas[i]);
        System.out.println("nim: " + Student.nim[i]);
        System.out.println("prodi: " + Student.prodi[i]);
    }

}
