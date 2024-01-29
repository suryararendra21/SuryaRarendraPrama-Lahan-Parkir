package model;

import com.google.gson.reflect.TypeToken;
import entity.KeluarEntity;
import entity.ParkirEntity;
import modelJSON.ModelJSON;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class KeluarModel {
    private ArrayList<KeluarEntity> keluarList;
    private ArrayList<ParkirEntity> parkirList;
    private ParkirModel parkirModel;
    private ModelJSON<KeluarEntity> keluarModelJSON;
    private ModelJSON<KeluarEntity> allMobil;

    public KeluarModel() {
        keluarList = new ArrayList<>();
        keluarModelJSON = new ModelJSON<>("src/Database/keluar.JSON");
        allMobil = new ModelJSON<>("src/Database/keluar.JSON");
        parkirModel = new ParkirModel();
        parkirModel.loadParkir();
        parkirList = parkirModel.getParkirList();
        loadKeluar();
    }
    public ArrayList<KeluarEntity> allKeluarParkir(){
        return keluarList;
    }

    public void loadKeluar() {
        keluarList = keluarModelJSON.readFromFile(new TypeToken<ArrayList<KeluarEntity>>() {}.getType());
        if (keluarList == null) {
            keluarList = new ArrayList<>();
        }
    }

    public void checkout(String platNomor) {
        parkirModel.loadParkir();
        parkirList = parkirModel.getParkirList();

        ParkirEntity kendaraanDiparkir = temukanKendaraanDiparkir(platNomor);

        if (kendaraanDiparkir != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String tanggalMasuk = kendaraanDiparkir.getTanggalMasuk();
            String tanggalKeluar = dateFormat.format(new Date());

            Date tglMasuk;
            try {
                tglMasuk = dateFormat.parse(tanggalMasuk);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            int harga = BiayaParkir(tglMasuk, new Date());

            KeluarEntity keluarEntity = new KeluarEntity(
                    tanggalMasuk,
                    tanggalKeluar,
                    platNomor,
                    harga
            );
            keluarList.add(keluarEntity);

            parkirList.remove(kendaraanDiparkir);

            keluarModelJSON.writeToFile(keluarList);
            allMobil.writeToFile(keluarList);
            parkirModel.commit();

            System.out.println("Kendaraan dengan nomor plat " + platNomor + " check-out pada " + tanggalKeluar);
            System.out.println("Tanggal Masuk: " + tanggalMasuk); // Added line to display tanggalMasuk
            System.out.println("Biaya parkir: Rp " + harga);
        } else {
            System.out.println("Kendaraan dengan nomor plat " + platNomor + " tidak ditemukan.");
        }
    }

    private ParkirEntity temukanKendaraanDiparkir(String platNomor) {
        if (parkirList == null) {
            return null;
        }

        for (ParkirEntity entitas : parkirList) {
            if (entitas.getPlatNomor().equals(platNomor)) {
                return entitas;
            }
        }
        return null;
    }

    public void cetakStruk(String platNomor) {
        KeluarEntity keluarEntity = temukanKeluarEntity(platNomor);

        if (keluarEntity != null) {
            System.out.println("Struk Pembayaran:");
            System.out.println("Nomor Plat: " + keluarEntity.getPlatNomor());
            System.out.println("Tanggal Masuk: " + keluarEntity.getTanggalMasuk());
            System.out.println("Tanggal Keluar: " + keluarEntity.getTanggalKeluar());
            System.out.println("Biaya Parkir: Rp " + keluarEntity.getHarga());
        } else {
            System.out.println("Struk pembayaran tidak ditemukan untuk kendaraan dengan nomor plat " + platNomor);
        }
    }

    private KeluarEntity temukanKeluarEntity(String platNomor) {
        for (KeluarEntity keluarEntity : keluarList) {
            if (keluarEntity.getPlatNomor().equals(platNomor)) {
                ParkirEntity parkirEntity = temukanKendaraanDiparkir(platNomor);
                if (parkirEntity != null) {
                    keluarEntity.setTanggalMasuk(parkirEntity.getTanggalMasuk());
                }
                return keluarEntity;
            }
        }
        return null;
    }

    public static int BiayaParkir(Date tglMasuk, Date tglKeluar) {
        int totalBiaya;
        long durasiParkir = (tglKeluar.getTime() - tglMasuk.getTime()) / (1000 * 60);
        if (durasiParkir <= 10) {
            totalBiaya = 0;
        } else {
            totalBiaya = 10000;
            int hari = (int) Math.ceil(durasiParkir / (24 * 60.0));
            totalBiaya += ((hari - 1) * 5000);
        }
        return totalBiaya;
    }
    public void lihatSemua(){
        if(keluarList.isEmpty()){
            System.out.println("Belum Ada Mobil");
        }else{
            System.out.println("Daftar Semua Mobil");

            for(KeluarEntity keluar : keluarList){
                System.out.println("Plat Nomor: " + keluar.getPlatNomor());
                System.out.println("Tanggal Masuk: " + keluar.getTanggalMasuk());
                System.out.println("Tanggal Keluar: " + keluar.getTanggalKeluar());
                System.out.println("------------------------------------------------");

            }
        }
    }

    public void commit() {
        keluarModelJSON.writeToFile(keluarList);
        allMobil.writeToFile(keluarList);
        parkirModel.commit();
    }
}