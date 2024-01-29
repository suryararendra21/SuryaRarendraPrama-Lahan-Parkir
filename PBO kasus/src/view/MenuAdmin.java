package view;

import controller.ParkirController;
import model.AdminModel;

import java.util.Scanner;

public class MenuAdmin {
    Scanner scanner = new Scanner(System.in);
    ParkirController parkirController;

    public MenuAdmin(ParkirController parkirController){
        this.parkirController = parkirController;
    }

    public void AdminLogin() {
        int pilih;
        do {
            System.out.println("""
                    1. Login
                    2. Exit
                    """);
            System.out.print("Masukkan Pilihan Anda = ");
            pilih = scanner.nextInt();
            switch (pilih) {
                case 1:
                    Login();
                    break;
                case 2:
                    System.out.println("Keluar");
                    break;
                default:
                    System.out.println("Inputan Salah");
                    break;
            }
        } while (pilih != 2);
    }
    public void Login() {
        try {
            boolean status = false;
            System.out.print("Masukkan Username = ");
            String username = scanner.next();
            System.out.print("Masukkan Password = ");
            String password = scanner.next();

            status = parkirController.login(username, password);
            if (status) {
                System.out.println("Berhasil Login");
                adminMenu();
            } else {
                System.out.println("Kartu Pegawai Atau Password Salah");
            }
        } catch (Exception e) {
            scanner.nextLine();
        }
    }
    public void adminMenu(){
        int pilihan;
        do {
            System.out.println("Lahan Parkir");
            System.out.println("1. Chekin");
            System.out.println("2. Chekout");
            System.out.println("3. Daftar Mobil Parkir");
            System.out.println("4. Cetak Struk");
            System.out.println("5. Lihat Semua Mobil");
            System.out.println("0. Keluar");
            System.out.println("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("Masukkan Plat Nomor: ");
                    String platNomor = scanner.nextLine();
                    parkirController.chekIn(platNomor);
                    break;
                case 2:
                    System.out.println("Masukkan plat Nomor: ");
                    String platNomor1 = scanner.nextLine();
                    parkirController.chekOut(platNomor1);
                    break;
                case 3:
                    parkirController.daftarMobilParkir();
                    break;
                case 4:
                    System.out.println("Masukkan Plat Nomor: ");
                    platNomor1 = scanner.next();
                    parkirController.cetakStruk(platNomor1);
                    break;
                case 5:
                    parkirController.lihatSemuaMobil();
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
            }
        }while(pilihan != 0);
    }
}
