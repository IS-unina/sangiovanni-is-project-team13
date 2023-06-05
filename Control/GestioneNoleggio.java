package Control;

import java.util.ArrayList;
import java.sql.Date;

import Database.*;
import Entity.*;
import Exception.*;


public class GestioneNoleggio {

    private static GestioneNoleggio gN = null;
    public GestioneNoleggio(){}
    public static GestioneNoleggio getInstance() {
        if (gN == null) {
            gN = new GestioneNoleggio();
        }

        return gN;
    }

    public void inserisciVeicolo (String targa, String modello, int numPasseggeri, int tariffa, String alimentazione, String statoVeicolo) throws OperationException
    {
        EntityVeicolo eV;
        try
        {
            eV = new EntityVeicolo(targa, modello, numPasseggeri, tariffa, alimentazione, statoVeicolo);
            VeicoloDAO.createVeicolo(eV);
        } catch (DAOException var17){
            throw new OperationException("Errore DAO");
        } catch (DatabaseConnectionException var18)
        {
            throw new OperationException("Errore connessione Database");
        }
    }
    public ArrayList<EntityVeicolo> ricercaVeicoli(Date DataRitiro, Date DataConsegna) throws OperationException
    {
        ArrayList<EntityVeicolo> ListaDisponibilita = new ArrayList<>();
        EntityVeicolo eV = null;
        try
        {
            ListaDisponibilita = (ArrayList<EntityVeicolo>) VeicoloDAO.readVeicoliDisponibili().clone();
            for (EntityPrenotazione prenotazione: PrenotazioneDAO.readPrenotazione(DataRitiro, DataConsegna)
                 ) {
                eV = VeicoloDAO.readVeicolo(prenotazione.getIdVeicolo());
                if(eV.getStatoVeicolo().equals("In Servizio"))
                    ListaDisponibilita.add(eV);
            }

        }
        catch (DatabaseConnectionException var17) {
            throw new OperationException("\nErrore di connessione al database\n");
        } catch (DAOException var18) {
            throw new OperationException("Qualcosa è andato storto");
        }
        return ListaDisponibilita;
    }

    public int effettuaNoleggio(String IdVeicolo, Date DataRitiro, Date DataConsegna, String IdDipendente) throws OperationException{
        EntityPrenotazione eP = null;
        int Prezzo;
        int numeroPrenotazione;
        try{
            numeroPrenotazione =  PrenotazioneDAO.countPrenotazione();
            eP = new EntityPrenotazione(numeroPrenotazione, IdVeicolo, DataRitiro, DataConsegna, IdDipendente);
            PrenotazioneDAO.createPrenotazione(eP);
            Prezzo = calcolaPrezzo(IdVeicolo, DataRitiro, DataConsegna);

            return Prezzo;
        } catch (DAOException var12){
            throw new OperationException("Errore creazione Prenotazione!");

        } catch (DatabaseConnectionException var17)
        {
            throw new OperationException("Errore connessione al database");
        }

    }

    public int calcolaPrezzo (String IdVeicolo, Date DataRitiro, Date DataConsegna) throws OperationException{
        EntityVeicolo eV = null;
        int prezzo = 0;
        int giorni =1000*60*60*24;
        try {
            eV = VeicoloDAO.readVeicolo(IdVeicolo);
            prezzo =  (int) ((DataConsegna.getTime() - DataRitiro.getTime())/giorni)*eV.getTariffa();
            return prezzo;
        }catch (DAOException var17){
            throw new OperationException("Errore nel calcolo del prezzo");
        } catch (DatabaseConnectionException var15)
        {
            throw new OperationException("Errore connessione al database");
        }


    }

    public void inserisciAzienda (String nome, String indirizzo, String responsabile, String numero, String email) throws OperationException
    {
        EntityAzienda eA;
        try
        {
            eA = new EntityAzienda(nome, indirizzo, responsabile, numero, email);
            AziendaDAO.createAzienda(eA);
        } catch (DAOException var17){
            throw new OperationException("Errore DAO");
        } catch (DatabaseConnectionException var18)
        {
            throw new OperationException("Errore connessione Database");
        }
    }
    public String inserisciDipendente (String numPatente, String nome, String cognome, String email, Date dataScadenza, String idAzienda) throws OperationException
    {
        EntityDipendente eD;
        String user;
        try
        {
            eD = new EntityDipendente(numPatente, nome, cognome, email, dataScadenza, null, null, idAzienda);
            user = DipendenteDAO.createDipendente(eD);

        } catch (DAOException var17){
            throw new OperationException("Errore DAO");
        } catch (DatabaseConnectionException var18)
        {
            throw new OperationException("Errore connessione Database");
        }
        return user;
    }
    public boolean verificaDipendente(String user, String pass) throws OperationException
    {
        try {
            return DipendenteDAO.verifyDipendente(user, pass);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (DatabaseConnectionException e) {
            throw new RuntimeException(e);
        }
    }
    public void modificaStatoVeicolo (EntityVeicolo veicolo, String stato) throws OperationException, DAOException, DatabaseConnectionException {
        try {
            VeicoloDAO.modifyVeicolo(veicolo, stato);
        } catch (DAOException e) {
            throw new OperationException("Errore modifica nel control");
        } catch (DatabaseConnectionException e) {
            throw new RuntimeException("Errore connessione al database nel control");
        }
    }
}
