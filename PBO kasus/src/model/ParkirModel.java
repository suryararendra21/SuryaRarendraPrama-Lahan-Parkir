package model;

import com.google.gson.reflect.TypeToken;
import entity.ParkirEntity;
import modelJSON.ModelJSON;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ParkirModel {
    private ArrayList<ParkirEntity> parkirList;
    private ModelJSON<ParkirEntity> modelJSON;

    public ParkirModel(){
        parkirList = new ArrayList<>();
        modelJSON = new ModelJSON<>("src/Database/parkir.JSON");
        loadParkir();
    }
    public ArrayList<ParkirEntity> allArrayParkir(){
        return parkirList;
    }
    public void loadParkir(){
        parkirList = modelJSON.readFromFile(new TypeToken<ArrayList<ParkirEntity>>() {}.getType());
        if (parkirList == null) {
            parkirList = new ArrayList<>();
        }
    }
    public void chekin(String platNomor) {
        if (isVehicleParked(platNomor)) {
            System.out.println("Kendaraan dengan nomor plat " + platNomor + " sudah diparkir.");
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String tanggalMasuk = dateFormat.format(new Date());

            ParkirEntity entitasBaru = new ParkirEntity(platNomor, tanggalMasuk);
            parkirList.add(entitasBaru);

            modelJSON.writeToFile(parkirList);

            System.out.println("Kendaraan dengan nomor plat " + platNomor + " check-in pada " + tanggalMasuk);
        }
    }
    private boolean isVehicleParked(String platNomor) {
        for (ParkirEntity entitas : parkirList) {
            if (entitas.getPlatNomor().equals(platNomor)) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<ParkirEntity> getParkirList() {
        return parkirList;
    }

    public void lihatMobilDiparkir() {
        if (parkirList.isEmpty()) {
            System.out.println("Belum ada mobil yang diparkir.");
        } else {
            System.out.println("Daftar Mobil yang Sudah Diparkir:");

            for (ParkirEntity entitas : parkirList) {
                System.out.println("Nomor Plat: " + entitas.getPlatNomor());
                System.out.println("Tanggal Masuk: " + entitas.getTanggalMasuk());
                System.out.println("-----------------------------");
            }
        }
    }
    public void commit() {
        modelJSON.writeToFile(parkirList);
    }
}
