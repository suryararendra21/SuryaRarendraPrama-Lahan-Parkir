package controller;

import entity.KeluarEntity;
import entity.ParkirEntity;
import model.AdminModel;
import model.KeluarModel;
import model.ParkirModel;

import java.util.ArrayList;

public class ParkirController {
    ArrayList <ParkirEntity> arrayParkir;
    ArrayList <KeluarEntity> arrayKeluar;
    ParkirModel parkirModel;
    KeluarModel keluarModel;
    public ParkirController(){
        parkirModel = new ParkirModel();
        parkirModel.loadParkir();
        keluarModel = new KeluarModel();
        keluarModel.loadKeluar();
    }
    public boolean login(String username, String password){
        return AdminModel.loginAdmin(username, password);
    }
    public void chekIn(String platNomor){
        parkirModel.chekin(platNomor);
        parkirModel.commit();
    }
    public int chekOut(String plaNomor){
        keluarModel.checkout(plaNomor);
        keluarModel.commit();
        return 0;
    }
    public ArrayList<ParkirEntity> daftarMobilParkir() {
        parkirModel.lihatMobilDiparkir();
        ArrayList<ParkirEntity> parkirList = parkirModel.allArrayParkir();
        return parkirList;
    }
    public void cetakStruk(String platNomor){
        keluarModel.cetakStruk(platNomor);
    }
    public ArrayList<KeluarEntity> lihatSemuaMobil(){
        keluarModel.lihatSemua();
        ArrayList<KeluarEntity> keluarList = keluarModel.allKeluarParkir();
        return keluarList;
    }
}
