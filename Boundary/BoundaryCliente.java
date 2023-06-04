package Boundary;

import Control.GestioneNoleggio;
import Database.VeicoloDAO;
import Entity.EntityVeicolo;
import Exception.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashSet;

public class BoundaryCliente {
    final GestioneNoleggio gestioneNoleggio = GestioneNoleggio.getInstance();

    public ArrayList<EntityVeicolo> RicercaVeicoli (Date DataRitiro, Date DataConsegna) throws OperationException, DAOException, DatabaseConnectionException {
        ArrayList<EntityVeicolo> disponibili = new ArrayList<>();
        ArrayList<EntityVeicolo> lista = (ArrayList<EntityVeicolo>) gestioneNoleggio.ricercaVeicoli(DataRitiro, DataConsegna).clone();

            for ( EntityVeicolo veicolo : lista)
                disponibili.add(veicolo);

        return disponibili;
    }
    public int EffettuaNoleggio(String IdVeicolo, Date DataRitiro, Date DataConsegna, String IdDipendente) throws OperationException, DAOException, DatabaseConnectionException {
        int Prezzo;
        try {
            Prezzo = gestioneNoleggio.effettuaNoleggio(IdVeicolo, DataRitiro, DataConsegna, IdDipendente);

        }catch (OperationException var8)
        {
            throw new OperationException("Errore noleggio nel control");
        }
        return Prezzo;
    }

    public boolean VerificaDipendente (String user, String pass) throws OperationException {
        return gestioneNoleggio.verificaDipendente(user, pass);

    }
}
