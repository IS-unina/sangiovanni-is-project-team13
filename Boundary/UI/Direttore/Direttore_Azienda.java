package Boundary.UI.Direttore;

import Boundary.BoundaryDirettore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Exception.*;

public class Direttore_Azienda extends JFrame{
    public JFrame frame;
    private JPanel DirettoreAziendaPanel;
    private JLabel Titolo;
    private JTextField Nome;
    private JTextField Indirizzo;
    private JTextField Responsabile;
    private JTextField NumeroTelefono;
    private JLabel labelNome;
    private JLabel labelIndirizzo;
    private JLabel labelResponsabile;
    private JLabel labelNumero;
    private JLabel labelEmail;
    private JButton Conferma;
    private JButton Indietro;
    private JTextField Email;
    private JTextPane Messaggio;

    public Direttore_Azienda() {
    BoundaryDirettore boundaryDirettore = new BoundaryDirettore();
    setContentPane(DirettoreAziendaPanel);
    setTitle("Inserire Azienda");
    setSize(1000, 550);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    Conferma.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if(Email.getText().contains("@") && Email.getText().contains(".")) {
                    boundaryDirettore.InserisciAzienda(Nome.getText(), Indirizzo.getText(), Responsabile.getText(), NumeroTelefono.getText(), Email.getText());
                    Messaggio.setText("registrazione azienda avvenuta con successo");
                }
                else {
                    Messaggio.setText("Email non inserita correttamente. Reinseriscila");
                    Email.setText("");
                }

            } catch (OperationException var15){

            }

        }
    });
    Indietro.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Direttore_scelta direttore = new Direttore_scelta();
            dispose();
            direttore.frame.setVisible(true);

        }
    });
}
}
