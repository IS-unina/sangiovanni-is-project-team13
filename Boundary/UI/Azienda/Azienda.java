package Boundary.UI.Azienda;

import Boundary.BoundaryAzienda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import Boundary.MainTest;
import Entity.EntityDipendente;
import Database.DipendenteDAO;
import Exception.*;

public class Azienda extends JFrame{
    public JFrame frame;
    private JPanel AziendaPanel;
    private JPanel DirettoreAziendaPanel;
    private JLabel Titolo;
    private JTextField NomeAzienda;
    private JTextField Nome;
    private JTextField Cognome;
    private JTextField NumeroPatente;
    private JLabel labelNomeAzienda;
    private JLabel labelNomeDipendente;
    private JLabel labelCognomeDipendente;
    private JLabel labelNumeroPetente;
    private JLabel labelEmail;
    private JButton Conferma;
    private JButton Indietro;
    private JTextField Email;
    private JLabel labelDataScadenza;
    private JTextField DataDiScadenza;
    private JTextPane Messaggio;

    public Azienda() {
    BoundaryAzienda boundaryAzienda = new BoundaryAzienda();
    setContentPane(DirettoreAziendaPanel);
    setTitle("Inserire Dipendente");
    setSize(1000, 550);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    Conferma.addActionListener(new ActionListener() {
        String user;
        EntityDipendente eD;
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if(Email.getText().contains("@") && Email.getText().contains("."))
                {
                    user = boundaryAzienda.InserisciDipendente(NumeroPatente.getText(), Nome.getText(), Cognome.getText(), Email.getText(), Date.valueOf(DataDiScadenza.getText()), NomeAzienda.getText());
                    eD = DipendenteDAO.readDipendente(user);
                    Messaggio.setText("Lo username del nuovo dipendente è: " + eD.getUsername() + " e la password è: " + eD.getPassword());
                }

                else
                {

                    Messaggio.setText("L'Email non è corretta. Reinseriscila");
                    Email.setText("");
                }


            } catch (OperationException ex) {
                Messaggio.setText("Errore inserimento dipendente");
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
