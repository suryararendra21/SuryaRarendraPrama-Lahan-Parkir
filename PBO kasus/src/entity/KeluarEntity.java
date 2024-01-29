package entity;

import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class KeluarEntity {
    private String tanggalMasuk;
    private String tanggalKeluar;
    private String platNomor;
    private int harga;

    public KeluarEntity(String tanggalMasuk, String tanggalKeluar, String platNomor, int harga) {
        this.tanggalMasuk = tanggalMasuk;
        this.tanggalKeluar = tanggalKeluar;
        this.platNomor = platNomor;
        this.harga = harga;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(String tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
