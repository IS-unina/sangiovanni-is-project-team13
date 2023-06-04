package Boundary;

import Control.GestioneNoleggio;
import Entity.EntityVeicolo;
import Exception.*;

public class BoundaryResponsabile {
    final GestioneNoleggio gestioneNoleggio = GestioneNoleggio.getInstance();

    public void ModificaStatoVeicolo(EntityVeicolo veicolo, String stato) throws OperationException
    {
        try {
            gestioneNoleggio.modificaStatoVeicolo(veicolo, stato);
        } catch (DAOException e) {
            throw new OperationException("Errore Dao nel boundary");
        } catch (DatabaseConnectionException e) {
            throw new OperationException("Errore connessione al database nel boundary");
        }
    }
}
