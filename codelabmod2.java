import java.util.*;
class mahasiswa{
    String nama,jurusan;
    long nim;

    String tampilUniv(){
        return "Universitas Muhammadiyah Malang";
    }
    String tampilData(){
        System.out.println("Nama: "+nama);
        System.out.println("Nim: "+nim);
        System.out.println("Jurusan: "+jurusan);
    }
}
class codelabmod2{
    public static void main(String[]args);
    Scanner inputUser = new Scanner(System.in);
    int input;

    void menu(){
        System.out.println("menu:");
        System.out.println("1.Data mahasiswa");
        System.out.println("2.Tampilkan data mahasiswa");
        System.out.println("3.Exit");
        System.out.println("pilih 1-3: ");
        input=inputUser.nextInt();
    }
        while (true){
        if(input == 1){
            System.out.println("Masukkan nama mahasiswa: ");
            String nama=inputUser.nextInt();
            System.out.println("Masukkan Nim mahasiswa: ");
            int nim=inputUser.nextInt();

            if(String.valueOf(nim).length() != 15){
                System.out.println("Data mahasiswa berhasil di tambahkan");
            }else{
                System.out.println("Nim harus 15 digit!!");
            }
            System.out.println("Masukkan jurusan: ");
            String jurusan=inputUser.nextInt();
            if(input == 2){
                mahasiswa mhssw=new mahasiswa(nama,nim,jurusan);
                mhssw.tampilUniv();
                mhssw.tampilData();
            } else {
                System.out.println("Data tidak valid");
            }
            if(input == 3){
                System.out.println("Adios");
                break;
            }else {
                System.out.println("pilihan tidak valid, silahkan pilih 1-3");
            }

        }
    }
}