import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal extends JFrame{
    private JPanel panelMain;
    private JLabel labelProductos;
    private JComboBox comboBox1;
    private JLabel labelCantidad;
    private JTextField textFieldCantidad;
    private JList list1;
    private JButton buttonCalcular;
    private JButton buttonMostrar;

    private static Scanner sc;

    public Principal() {
        setContentPane(panelMain);

        List<Integer> precioFinal = new ArrayList<>();

        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    sumador();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        buttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader fr = null;
                    int nLineas = 0;
                    int i = 0;
                    Integer[] usuarios = null;
                    String linea;
                    String fichero = "resultados.txt";
                    sc = new Scanner(new File(fichero));
                    File f = new File(fichero);
                    fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);


                    while((linea = br.readLine()) != null) {
                        nLineas++;
                    }

                    usuarios = new Integer[nLineas];//Tamaño del arreglo

                    while(sc.hasNextLine()) {
                        usuarios[i++] = Integer.valueOf(sc.nextLine());//Almacenado cada linea en una posicion
                    }
                    fr.close();

                    int sumador = 0;
                    for (Integer usuario : usuarios) {
                        sumador += usuario;
                    }


                    JOptionPane.showMessageDialog(null,"Total: " + sumador);

                    BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
                    bw.write("");
                    bw.close();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(new JFrame(),"Error: " + ex.getMessage());
                }
            }
        });


    }

    public void sumador() throws IOException {


        List<Integer> precioFinal = new ArrayList<>();

        int total = 0;

        int contador = 0;

        File archivo;

        FileWriter escribir;

        PrintWriter linea;

        archivo = new File("resultados.txt");

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo,true);
                linea = new PrintWriter(escribir);
                linea.close();
                escribir.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(new JFrame(),"Error: " + ex.getMessage());
            }


        } else {
            escribir = new FileWriter(archivo,true);
            linea = new PrintWriter(escribir);



            if (Objects.equals(comboBox1.getSelectedItem(), "Pan")) {
                total = Integer.parseInt(textFieldCantidad.getText());

                total *= 1000;

                contador = total;

                linea.println(contador);
            }

            if (Objects.equals(comboBox1.getSelectedItem(), "Chicle")) {
                total = Integer.parseInt(textFieldCantidad.getText());

                total *= 600;

                contador = total;

                linea.println(contador);

            }

            if (Objects.equals(comboBox1.getSelectedItem(), "Leche")) {
                total = Integer.parseInt(textFieldCantidad.getText());

                total *= 2500;

                contador = total;

                linea.println(contador);

            }

            if (Objects.equals(comboBox1.getSelectedItem(), "Mantequilla")) {
                total = Integer.parseInt(textFieldCantidad.getText());

                total *= 1600;

                contador = total;

                linea.println(contador);

            }

            if (Objects.equals(comboBox1.getSelectedItem(), "Huevos")) {
                total = Integer.parseInt(textFieldCantidad.getText());

                total *= 550;

                contador = total;

                linea.println(contador);
            }
            linea.close();
            escribir.close();
        }


    }
}
