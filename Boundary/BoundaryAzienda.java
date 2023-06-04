package Boundary;

import Control.GestioneNoleggio;

import java.sql.Date;
import java.util.ArrayList;

import Exception.*;

public class BoundaryAzienda {
    final GestioneNoleggio gestioneNoleggio = GestioneNoleggio.getInstance();

    public String InserisciDipendente(String numPatente, String nome, String cognome, String email, Date dataScadenza, String idAzienda) throws OperationException, DAOException, DatabaseConnectionException
    {
        String user;
        user = gestioneNoleggio.inserisciDipendente(numPatente, nome, cognome, email, dataScadenza,idAzienda);
        return user;


    }
}
