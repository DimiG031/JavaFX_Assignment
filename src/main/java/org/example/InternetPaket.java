package org.example;

public class InternetPaket {

    private String imeKorisnika;
    private String prezimeKorisnika;
    private String adresaKorisnika;
    private int brzina;
    private String protok;
    private int trajanjeUgovora;


    public InternetPaket( String imeKorisnika, String prezimeKorisnika, String adresaKorisnika,int brzina, String protok, int trajanjeUgovora) {

        this.imeKorisnika = imeKorisnika;
        this.prezimeKorisnika = prezimeKorisnika;
        this.adresaKorisnika = adresaKorisnika;
        this.brzina = brzina;
        this.protok = protok;
        this.trajanjeUgovora = trajanjeUgovora;
    }


    public String getImeKorisnika() {
        return imeKorisnika;
    }

    public void setImeKorisnika(String imeKorisnika) {
        this.imeKorisnika = imeKorisnika;
    }

    public String getPrezimeKorisnika() {
        return prezimeKorisnika;
    }

    public void setPrezimeKorisnika(String prezimeKorisnika) {
        this.prezimeKorisnika = prezimeKorisnika;
    }
       public String getAdresaKorisnika() {
        return adresaKorisnika;
    }

    public void setAdresaKorisnika(String adresaKorisnika) {
        this.adresaKorisnika = adresaKorisnika;
    }
    public int getBrzina() {
        return brzina;
    }

    public void setBrzina(int brzina) {
        this.brzina = brzina;
    }

    public String getProtok() {
        return protok;
    }

    public void setProtok(String protok) {
        this.protok = protok;
    }

    public int getTrajanjeUgovora() {
        return trajanjeUgovora;
    }

    public void setTrajanjeUgovora(int trajanjeUgovora) {
        this.trajanjeUgovora = trajanjeUgovora;
    }
}


