import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Tabung tabung = new Tabung("tabung");
        Kubus kubus = new Kubus("kubus");
        Balok balok = new Balok("balok");

        balok.inputNilai();
        balok.luasPermukaan();
        balok.volume();

        kubus.inputNilai();
        kubus.luasPermukaan();
        kubus.volume();

        tabung.inputNilai();
        tabung.luasPermukaan();
        tabung.volume();
    }
}

class BangunRuang {
    private String name;

    BangunRuang(String name){
        this.name = name;
    }

    public void inputNilai(){
        System.out.println("Input nilai");
    }

    public void luasPermukaan(){
        System.out.println("Menghitung luas permukaan bangun " + name); //menambah tanda + untuk memanggil nilai
    }

    public void volume(){
        System.out.println("Menghitung volume bangun " + name);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class Kubus extends BangunRuang { //menghapus public
    Scanner scanner = new Scanner(System.in);
    private double tinggi; //mengganti sisi dengan tinggi sesuai spesifikasi di modul

    Kubus(String nameBangun) {
        super(nameBangun);
    }

    public void inputNilai(){ //ubah input dengan inputNilai sesuai spesifikasi atribut pada modul
        super.inputNilai();
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble(); //ubah nextnext menjadi nextDouble
    }

    public void luasPermukaan(){
        double hasil = 6 * tinggi * tinggi;
        super.luasPermukaan(); //ubah superluasaan menjadi super.luasPermukaan
        System.out.println("Hasil luas permukaan: " + hasil); //perbaiki penulisan System.out.println
    }

    public void volume(){
        double hasil = Math.pow(tinggi, 3); //tambah tipe data double
        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}

class Tabung extends BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double tinggi;
    private double jari_jari;

    Tabung(String nameBangun) {
        super(nameBangun);
    }

    public void inputNilai(){
        super.inputNilai();
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble(); //tambah scanner
        System.out.print("Input jari-jari: ");
        jari_jari = scanner.nextDouble();
    }

    public void luasPermukaan(){
        double hasil = 2 * Math.PI * jari_jari * (jari_jari);
        super.luasPermukaan();
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    public void volume(){
        double hasil = Math.PI * Math.pow(jari_jari, 2) * tinggi;
        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}

//penghitungan untuk luas permukaan dan volume balok
class Balok extends BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private double panjang;
    private double lebar;
    private double tinggi;

    Balok(String nameBangun) {
        super(nameBangun);
    }

    public void inputNilai(){
        super.inputNilai();
        System.out.print("Input panjang: ");
        panjang = scanner.nextDouble();
        System.out.print("Input lebar: ");
        lebar = scanner.nextDouble();
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble();
    }

    public void luasPermukaan(){
        double hasil = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
        super.luasPermukaan();
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    public void volume(){
        double hasil = panjang * lebar * tinggi;
        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}
