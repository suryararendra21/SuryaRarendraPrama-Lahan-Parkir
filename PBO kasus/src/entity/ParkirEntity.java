package entity;

public class ParkirEntity {
    private String platNomor;
    private String tanggalMasuk;

    public ParkirEntity(String platNomor, String tanggalMasuk) {
        this.platNomor = platNomor;
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }
}
