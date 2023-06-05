package Database;

import Entity.EntityPrenotazione;
import Entity.EntityVeicolo;
import Exception.DAOException;
import Exception.DatabaseConnectionException;
import Exception.OperationException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class PrenotazioneDAO {
    public PrenotazioneDAO() {};
    public static int countPrenotazione() throws DatabaseConnectionException, DAOException
    {
        int numPrenotazioni = 0;
        try {
            Connection conn = DBManager.getConnection();
            String query = "SELECT * FROM PRENOTAZIONE;";
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet result = stmt.executeQuery();

                while (result.next())
                    numPrenotazioni++;
            } catch (SQLException var16) {
                throw new DAOException("Errore nel dao");
            }finally {
                DBManager.closeConnection();
            }

            return numPrenotazioni + 1;
        } catch (SQLException var10) {
            throw new DatabaseConnectionException("Errore connessione al database");
        }


    }

    public static void createPrenotazione (EntityPrenotazione prenotazione) throws DAOException, DatabaseConnectionException {
        try {
            Connection conn = DBManager.getConnection();
            String query = "INSERT INTO PRENOTAZIONE VALUES (?,?,?,?,?);";
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, prenotazione.getNumPrenotazione());
                stmt.setString(2, prenotazione.getIdVeicolo());
                stmt.setDate(3, (java.sql.Date) prenotazione.getDataDiRitiro());
                stmt.setDate(4, (java.sql.Date) prenotazione.getDataDiConsegna());
                stmt.setString(5, prenotazione.getIdDipendente());
                stmt.executeUpdate();
            } catch (SQLException var8) {
                throw new DAOException("Errore inserimento Prenotazione");
            } finally {
                DBManager.closeConnection();
            }

        } catch (SQLException | DAOException var10) {
            throw new DatabaseConnectionException("Errore connessione database");
        }
    }

    public static ArrayList<EntityPrenotazione> readPrenotazione(Date DataRitiro, Date DataConsegna) throws DAOException, DatabaseConnectionException, OperationException {
        EntityPrenotazione eP = null;
        EntityPrenotazione eP2 = null;
        EntityVeicolo eV = null;
        ArrayList<EntityPrenotazione> ListaPrenotazioni = new ArrayList<>();
        boolean inizio = true;
        boolean control = true;
        int count;


        try {
            Connection conn = DBManager.getConnection();
            String query = "SELECT * FROM PRENOTAZIONE WHERE (DATADICONSEGNA < ? AND DATADIRITIRO<?) OR (DATADIRITIRO>? AND DATADICONSEGNA>?) ;";
            String query2 = "SELECT * FROM PRENOTAZIONE WHERE (DATADICONSEGNA <= ? AND DATADIRITIRO>=?) OR (DATADIRITIRO<=? AND DATADICONSEGNA>=?) OR (DATADIRITIRO<=? AND DATADICONSEGNA>=?) ;";

            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                PreparedStatement stmt2 = conn.prepareStatement(query2);
                stmt.setDate(1, DataRitiro);
                stmt.setDate(2, DataRitiro);
                stmt.setDate(3, DataConsegna);
                stmt.setDate(4, DataConsegna);

                stmt2.setDate(1, DataConsegna);
                stmt2.setDate(2, DataRitiro);
                stmt2.setDate(3, DataRitiro);
                stmt2.setDate(4, DataRitiro);
                stmt2.setDate(5, DataConsegna);
                stmt2.setDate(6, DataConsegna);

                ResultSet result = stmt.executeQuery();
                ResultSet result2 = stmt2.executeQuery();

                while (result.next()) {
                    eP = new EntityPrenotazione(result.getInt(1), result.getString(2), result.getDate(3) , result.getDate(4), result.getString(5));
                    if(inizio == true)
                    {
                        control = false;
                        inizio = false;
                    }

                    else {
                            for (int i = 0; i < ListaPrenotazioni.size(); i++)
                            {

                                if(!ListaPrenotazioni.get(i).getIdVeicolo().equals(eP.getIdVeicolo()))
                                    control = false;

                                else
                                {
                                    control = true;
                                    break;
                                }

                            }
                        }

                    if(control == false)
                        ListaPrenotazioni.add(eP);
                    }

                ArrayList<EntityPrenotazione> lista = new ArrayList<>();
                while (result2.next())
                {

                    eP2 = new EntityPrenotazione(result2.getInt(1), result2.getString(2), result2.getDate(3) , result2.getDate(4), result2.getString(5));
                    for (EntityPrenotazione prenotazione:ListaPrenotazioni
                         ) {
                        if(prenotazione.getIdVeicolo().equals(eP2.getIdVeicolo()))
                            lista.add(prenotazione);
                    }


                }
                ListaPrenotazioni.removeAll(lista);


            } catch (SQLException var11){
                throw new DAOException("Errore nelle prenotazioni col dao");
            }
                finally {
                DBManager.closeConnection();
            }
            return ListaPrenotazioni;

        } catch (SQLException var12) {
            throw new DatabaseConnectionException("Errore connessione database");
        }

    }


}
