package Entity;

import java.sql.Date;
import java.util.Collection;

public class EntityPrenotazione {

    private int NumPrenotazione;
    private String IdVeicolo;
    private Date DataDiRitiro;
    private Date DataDiConsegna;
    private String IdDipendente;
    public String getIdDipendente() {
        return IdDipendente;
    }

    public void setIdDipendente(String idDipendente) {
        IdDipendente = idDipendente;
    }



    public EntityPrenotazione(int Numero, String idVeicolo, Date dataDiRitiro, Date dataDiConsegna, String idDipendente) {
        super();
        NumPrenotazione = Numero;
        IdVeicolo = idVeicolo;
        DataDiRitiro = dataDiRitiro;
        DataDiConsegna = dataDiConsegna;
        IdDipendente = idDipendente;
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

    public int hashCode()
    {
        return 1;
    }
}
