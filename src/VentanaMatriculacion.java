import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMatriculacion {
    private JPanel VentanaMatriculacion;
    private JTextField textPropietario;
    private JComboBox comboBoxMarca;
    private JTextField textFieldAnio;
    private JButton agregarALaColaButton;
    private JButton matriculaButton;
    private JTextArea textArea1;
    private JButton BuscarButton;
    private JTextArea textArea2;

    private ColaMatricula matricula = new ColaMatricula();

    public VentanaMatriculacion(){


        agregarALaColaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matricula.encolar(textPropietario.getText(), comboBoxMarca.getSelectedItem().toString(), Integer.parseInt(textFieldAnio.getText()));
            textArea1.setText(matricula.listarVehiculos());
            limpiarCampos();
            limpiarArea();
            }
        });
        /*agregarALaColaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hola");
                Carro c = new Carro(textPropietario.getText(),comboBoxMarca.getSelectedItem().toString(),Integer.parseInt(textFieldAnio.getText()));
                System.out.println(c.toString());
                //matricula.encolar(textPropietario.getText(),comboBoxMarca.getSelectedItem().toString(),Integer.parseInt(textFieldAnio.getText()));

            }
        });*/
        matriculaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Carro c = matricula.desencolar();
                    JOptionPane.showMessageDialog(null,c.toString()+"\nValor de la mtricula"+c.calcularValorMatricula());
                    textArea1.setText(matricula.listarVehiculos());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
                limpiarArea();
            }
        });
        BuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensaje = matricula.listarVehiculoMarca(comboBoxMarca.getSelectedItem().toString());
                if(mensaje.equals("")) {
                    JOptionPane.showMessageDialog(null, "No hay vehiculos de la marca " + comboBoxMarca.getSelectedItem().toString());
                }else {
                    textArea2.setText(mensaje);
                }
                }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaMatriculacion");
        frame.setContentPane(new VentanaMatriculacion().VentanaMatriculacion);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public void limpiarCampos(){
        textPropietario.setText("");
        textFieldAnio.setText("");
        comboBoxMarca.setSelectedIndex(0);
    }
    public void limpiarArea(){
        textArea2.setText(" ");
    }
}
