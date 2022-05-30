import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class TelaVetor extends JFrame {
    private JPanel mainPanel;
    private JSpinner txtNum;
    private JButton btnAdicionar;
    private JButton btnOrdenar;
    private JButton btnRemover;
    private JList lstVetor;
    private JLabel lblSelecionado;

    public static void main(String[] args) {
        JFrame frame = new TelaVetor();
        frame.setVisible(true);



    }

    public TelaVetor() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        int vetor[] = new int[5];
        DefaultListModel lista = new DefaultListModel();
        int selecionado = 0;
        lstVetor.setModel(lista);


        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vetor[selecionado] = Integer.parseInt(txtNum.getValue().toString());
                lista.removeAllElements();
                for(int c=0; c < vetor.length; c++) {
                    lista.addElement(vetor[c]);

                }
            }
        });
        lstVetor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
               int selecionado = lstVetor.getSelectedIndex();
                lblSelecionado.setText("[" + selecionado + "]");


            }
        });
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vetor[selecionado] = 0;
                lista.removeAllElements();
                for(int c=0; c < vetor.length; c++) {
                    lista.addElement(vetor[c]);
                }

            }
        });
        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(vetor);
                vetor[selecionado] = 0;
                lista.removeAllElements();
                for(int c=0; c < vetor.length; c++) {
                    lista.addElement(vetor[c]);
                }
            }
        });
    }
}
