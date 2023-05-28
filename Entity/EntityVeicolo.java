package Entity;

public class EntityVeicolo {

    private String Targa;
    private String Modello;
    private int NumPasseggeri;
    private int Tariffa;
    private String Alimentazione;
    private String StatoVeicolo;

    public EntityVeicolo(String targa, String modello, int numPasseggeri, int tariffa, String alimentazione, String statoVeicolo) {
        Targa = targa;
        Modello = modello;
        NumPasseggeri = numPasseggeri;
        Tariffa = tariffa;
        Alimentazione = alimentazione;
        StatoVeicolo = statoVeicolo;
    }

    public String getTarga() {
        return Targa;
    }

    public void setTarga(String targa) {
        Targa = targa;
    }

    public String getModello() {
        return Modello;
    }

    public void setModello(String modello) {
        Modello = modello;
    }

    public int getNumPasseggeri() {
        return NumPasseggeri;
    }

    public void setNumPasseggeri(int numPasseggeri) {
        NumPasseggeri = numPasseggeri;
    }

    public int getTariffa() {
        return Tariffa;
    }

    public void setTariffa(int tariffa) {
        Tariffa = tariffa;
    }

    public String getAlimentazione() {
        return Alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        Alimentazione = alimentazione;
    }

    public String getStatoVeicolo() {
        return StatoVeicolo;
    }

    public void setStatoVeicolo(String statoVeicolo) {
        StatoVeicolo = statoVeicolo;
    }
}
