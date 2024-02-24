import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class codelabMod1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Jenis Kelamin (P/L): ");
        char jenisKelamin = scanner.next().charAt(0);
        String jeniskelaminstr = (jenisKelamin == 'P' || jenisKelamin == 'p') ? "Perempuan" : "Laki-laki";
        System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
        String tanggalLahirStr = scanner.next();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirStr);

        LocalDate now = LocalDate.now();
        Period umur = Period.between(tanggalLahir, now);

        System.out.println("\nNama: " + nama);
        System.out.println("Jenis Kelamin: " +  jeniskelaminstr);
        System.out.println("Umur Anda: " + umur.getYears() + " tahun " + umur.getMonths() + " bulan " + umur.getDays() + " hari");
    }
}
