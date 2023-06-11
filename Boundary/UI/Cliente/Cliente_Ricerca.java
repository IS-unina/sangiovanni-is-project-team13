package Boundary.UI.Cliente;

import Boundary.BoundaryCliente;
import Boundary.MainTest;
import Database.PrenotazioneDAO;
import Entity.EntityVeicolo;

import javax.management.openmbean.OpenDataException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import Exception.*;

import java.util.Locale;

public class Cliente_Ricerca extends JFrame {
    public static JFrame frame;
    private JLabel Titolo;
    private JTextField DataRitiro;
    private JTextField DataConsegna;
    private JButton RicercaVeicoli;
    private JTextPane Messaggio;
    private JPanel Cliente_Panel;
    private JLabel labelRitiro;
    private JLabel labelConsegna;
    private JButton NoleggiaVeicolo;
    private JButton Cliente_Indietro;
    public JTable tabellaDisponibilità;
    private JScrollPane ScrollTabella;
    private JPanel Pannello_tabella;

    public Cliente_Ricerca(String user){
    BoundaryCliente boundaryCliente = new BoundaryCliente();
    DefaultTableModel model = new DefaultTableModel();

    model.addColumn("Targa");
        model.addColumn("Modello");
        model.addColumn("Numero Passeggeri");
        model.addColumn("Tariffa");
        model.addColumn("Alimentazione");
        model.addColumn("Stato Veicolo");
        tabellaDisponibilità.setModel(model);

    setContentPane(Cliente_Panel);

    setTitle("Schermata Noleggio");
    setSize(1000, 550);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    RicercaVeicoli.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e){
            ArrayList<EntityVeicolo> returnList;
            boolean control = false;
            model.setRowCount(0);
            try {

                    if (Date.valueOf(DataRitiro.getText()).after(Date.valueOf(DataConsegna.getText())))
                    {
                        control = false;
                        Messaggio.setText("La data di ritiro non può essere successiva a quella di consegna. Reinserire le date");
                        DataRitiro.setText("");
                        DataConsegna.setText("");
                    }
                    else if (Date.valueOf(DataRitiro.getText()).after(Date.valueOf("2030-01-01")) || Date.valueOf(DataConsegna.getText()).after(Date.valueOf("2030-01-01")))
                    {
                        control = false;
                        Messaggio.setText("Intervallo di tempo troppo futuro. Reinserire le date");
                        DataRitiro.setText("");
                        DataConsegna.setText("");
                    }
                    else
                    {
                        returnList = (ArrayList<EntityVeicolo>) boundaryCliente.RicercaVeicoli(Date.valueOf(DataRitiro.getText()), Date.valueOf(DataConsegna.getText())).clone();

                        if(returnList.size() != 0) {

                            for (EntityVeicolo veicolo : returnList) {

                                model.addRow(new Object[]{veicolo.getTarga(), veicolo.getModello(), veicolo.getNumPasseggeri(), veicolo.getTariffa(), veicolo.getAlimentazione(), veicolo.getStatoVeicolo()});
                                tabellaDisponibilità.setModel(model);

                            }

                            Messaggio.setText("Eccoti la lista dei veicoli disponibili!");

                        }
                        else
                            Messaggio.setText("Non ci sono veicoli");
                    }






            } catch (OperationException var10)
            {
                var10.printStackTrace();
            } catch (DAOException ex) {
                throw new RuntimeException(ex);
            } catch (DatabaseConnectionException var9) {

            }
            }

    });
    NoleggiaVeicolo.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int indice;

            indice = tabellaDisponibilità.getSelectedRow();
            int Prezzo;
            try {

                    if (Date.valueOf(DataRitiro.getText()).after(Date.valueOf(DataConsegna.getText())))
                    {

                        Messaggio.setText("La data di ritiro non può essere successiva a quella di consegna. Reinserire le date");
                    }
                    else if (Date.valueOf(DataRitiro.getText()).after(Date.valueOf("2030-01-01")) || Date.valueOf(DataConsegna.getText()).after(Date.valueOf("2030-01-01")))
                    {

                        Messaggio.setText("Intervallo di tempo troppo futuro. Reinserire le date");
                    }
                    else
                    {
                        Prezzo = boundaryCliente.EffettuaNoleggio((String) model.getValueAt(indice, 0), Date.valueOf(DataRitiro.getText()), Date.valueOf(DataConsegna.getText()), user);
                        Messaggio.setText("Veicolo Noleggiato! Dovrai pagare " + Prezzo + " euro");
                    }



            } catch (OperationException ex) {
                Messaggio.setText("Problema interno all'app : OP ");

            }catch (DAOException ex)
            {
                Messaggio.setText("Problema interno all'app: DAO");
            } catch ( DatabaseConnectionException ex)
            {
                Messaggio.setText("Problema interno all'app: DB");
            }

        }
    });
    Cliente_Indietro.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            MainTest.frame.setVisible(true);
        }
    });
    }
}
