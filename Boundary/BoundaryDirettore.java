package Boundary;

import Control.GestioneNoleggio;
import Exception.*;

public class BoundaryDirettore {
        final GestioneNoleggio gestioneNoleggio = GestioneNoleggio.getInstance();

        public void InserisciVeicolo (String targa, String modello, int numPasseggeri, int tariffa, String alimentazione, String statoVeicolo) throws OperationException {
                gestioneNoleggio.inserisciVeicolo(targa, modello, numPasseggeri, tariffa, alimentazione, statoVeicolo);

        }
        public void InserisciAzienda(String nome, String indirizzo, String responsabile, String numero, String email) throws OperationException
        {
                gestioneNoleggio.inserisciAzienda(nome, indirizzo, responsabile, numero, email);
        }
}
