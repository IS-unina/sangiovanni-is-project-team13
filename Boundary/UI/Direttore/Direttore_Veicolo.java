package Boundary.UI.Direttore;
import Boundary.BoundaryDirettore;
import Boundary.MainTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Exception.*;

public class Direttore_Veicolo extends JFrame{
    public JFrame frame;
    private JTextField Targa;
    private JTextField Modello;
    private JTextField NumPasseggeri;
    private JTextField Tariffa;
    private JComboBox Alimentazione;
    private JComboBox StatoVeicolo;
    private JButton Conferma;
    private JPanel DirettorePanel;
    private JLabel labelTarga;
    private JLabel labelModello;
    private JLabel labelNumero;
    private JLabel labelTariffa;
    private JLabel labelAlimentazione;
    private JLabel labelStato;
    private JButton Indietro;
    private JLabel Titolo;

    public Direttore_Veicolo()
    {
        BoundaryDirettore boundaryDirettore = new BoundaryDirettore();
        setContentPane(DirettorePanel);
        setTitle("Inserire Veicolo");
        setSize(700, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        Conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boundaryDirettore.InserisciVeicolo(Targa.getText(), Modello.getText(), Integer.valueOf(NumPasseggeri.getText()), Integer.valueOf(Tariffa.getText()),Alimentazione.getSelectedItem().toString(), StatoVeicolo.getSelectedItem().toString());
                } catch (OperationException var15){

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
