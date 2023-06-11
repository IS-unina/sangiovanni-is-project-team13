package Boundary.UI.Direttore;

import Boundary.MainTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Direttore_scelta extends JFrame{
    public static JFrame frame;
    private JLabel Titolo;
    private JButton Inserimento_Veicolo;
    private JButton Inserisci_Azienda;
    private JPanel Direttore_Scelta_Panel;
    private JButton Direttore_Indietro;

    public Direttore_scelta()
    {
        setContentPane(Direttore_Scelta_Panel);
        setTitle("Inserire Scelta");
        setSize(1000, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        Inserimento_Veicolo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Direttore_Veicolo direttoreVeicolo = new Direttore_Veicolo();
                Direttore_scelta.frame.setVisible(false);
                direttoreVeicolo.frame.setVisible(true);



            }
        });
        Inserisci_Azienda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Direttore_Azienda direttoreAzienda = new Direttore_Azienda();
                Direttore_scelta.frame.setVisible(false);
                direttoreAzienda.frame.setVisible(true);

            }
        });
        Direttore_Indietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainTest.frame.setVisible(true);
            }
        });
    }
}
