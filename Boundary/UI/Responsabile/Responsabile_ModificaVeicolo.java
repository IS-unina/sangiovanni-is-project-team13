package Boundary.UI.Responsabile;

import Boundary.BoundaryResponsabile;
import Boundary.MainTest;
import Database.PrenotazioneDAO;
import Database.VeicoloDAO;
import Entity.EntityVeicolo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Exception.*;
public class Responsabile_ModificaVeicolo extends JFrame{
    public JFrame frame;
    private JPanel ModificaPanel;
    private JLabel Titolo;
    private JLabel labelTarga;
    private JComboBox Targa;
    private JLabel labelStato;
    private JButton Indietro;
    private JButton Conferma;
    private JTextPane Messaggio;
    private JComboBox StatoVeicolo;
public Responsabile_ModificaVeicolo() {
    BoundaryResponsabile boundaryResponsabile = new BoundaryResponsabile();
    try {
        ArrayList<String> targhe = (ArrayList<String>) PrenotazioneDAO.readTutteLePrenotazioni().clone();
        for (String targa:targhe
             ) {
            Targa.addItem(targa);
        }
    } catch (DAOException e) {
        throw new RuntimeException(e);
    } catch (DatabaseConnectionException e) {
        throw new RuntimeException(e);
    }
    setContentPane(ModificaPanel);
    setTitle("Schermata Modifica Stato Veicolo");
    setSize(1000, 550);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    Conferma.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            EntityVeicolo eV;
            try {
                eV = VeicoloDAO.readVeicolo((String)Targa.getSelectedItem() );
                try {
                    boundaryResponsabile.ModificaStatoVeicolo(eV, (String )StatoVeicolo.getSelectedItem());
                }catch (OperationException ex)
                {
                    Messaggio.setText("L'operazione non è andata a buon fine");
                }
                Messaggio.setText("L'operazione è andata a buon fine!");

            } catch (DAOException ex) {
                throw new RuntimeException(ex);
            } catch (DatabaseConnectionException ex) {
                throw new RuntimeException(ex);
            }

        }
    });
    Indietro.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            MainTest.frame.setVisible(true);

        }
    });
}
}
