package Entity;

import java.util.Date;

public class EntityPrenotazione {

    private int NumPrenotazione;
    private String IdVeicolo;

    private Date DataDiRitiro;
    private Date DataDiConsegna;

    public EntityPrenotazione(int numPrenotazione, String idVeicolo, Date dataDiRitiro, Date dataDiConsegna) {
        NumPrenotazione = numPrenotazione;
        IdVeicolo = idVeicolo;
        DataDiRitiro = dataDiRitiro;
        DataDiConsegna = dataDiConsegna;
    }

    public int getNumPrenotazione() {
        return NumPrenotazione;
    }

    public void setNumPrenotazione(int numPrenotazione) {
        NumPrenotazione = numPrenotazione;
    }

    public String getIdVeicolo() {
        return IdVeicolo;
    }

    public void setIdVeicolo(String idVeicolo) {
        IdVeicolo = idVeicolo;
    }

    public Date getDataDiRitiro() {
        return DataDiRitiro;
    }

    public void setDataDiRitiro(Date dataDiRitiro) {
        DataDiRitiro = dataDiRitiro;
    }

    public Date getDataDiConsegna() {
        return DataDiConsegna;
    }

    public void setDataDiConsegna(Date dataDiConsegna) {
        DataDiConsegna = dataDiConsegna;
    }
}
