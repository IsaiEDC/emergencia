package screens;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import db.repositorys.EmpleadosRepository;
import db.repositorys.GenerosRepository;
import models.Empleado;



public class EmpleadosVentana extends JFrame implements ActionListener {

    GenerosRepository generosRepository = new GenerosRepository();
    EmpleadosRepository empleadosRepository = new EmpleadosRepository();
    JLabel textLabel;
    JLabel numeroempleadoJLabel;
    JLabel nombreJLabel;
    JLabel domicilioJLabel;
    JLabel telefonoJLabel;
    JLabel emaiJLabel;
    JLabel fechaJLabel;
    JLabel generoJLabel;
    JComboBox<Long> numeroEmpledoJComboBox;
    JTextField nombreJTextField;
    JTextField domicilioJTextField;
    JTextField telefonoJTextField;
    JTextField emailJTextField;
    JDateChooser fechaJDateChooser;
    JComboBox<String> generoJComboBox;
    JButton buscarJButton;
    JButton guardarJButton;
    JButton modificarJButton;
    JButton eliminarJButton;
    JButton limpiarJButton;

    public EmpleadosVentana() {
        super("Empleados CRUD");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        crearComponentes();
    }

    private void crearComponentes() {
        this.textLabel = new JLabel("Empleado");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numeroempleadoJLabel = new JLabel("#Empleado");
        nombreJLabel = new JLabel("Nombre");
        domicilioJLabel = new JLabel("Domicilio");
        telefonoJLabel = new JLabel("Telefono");
        emaiJLabel = new JLabel("Email");
        fechaJLabel = new JLabel("Fecha");
        generoJLabel = new JLabel("Genero");
        numeroEmpledoJComboBox = new JComboBox<Long>();
        nombreJTextField = new JTextField("Nombre");
        domicilioJTextField = new JTextField("domicilio");
        telefonoJTextField = new JTextField("telefono");
        emailJTextField = new JTextField("email");
        fechaJDateChooser = new JDateChooser();
        generoJComboBox = new JComboBox<>();
        buscarJButton = new JButton("buscar");
        guardarJButton = new JButton("guardar");
        modificarJButton = new JButton("modificar");
        eliminarJButton = new JButton("eliminar");
        limpiarJButton = new JButton("limpiar");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; /* comulnas */
        gbc.gridy = 0; /* filas */
        gbc.gridwidth = 4; /* Numero de columnas que ocupa */
        gbc.gridheight = 1; /* Numero de filas que ocupa */
        gbc.fill = GridBagConstraints.BOTH;
        add(textLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1; /* Numero de columnas que ocupa */
        add(numeroempleadoJLabel, gbc);

        gbc.gridx = 1; /* !Modifica columna */
        add(numeroEmpledoJComboBox, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2; /* numero de columnas que ocupa */
        add(buscarJButton, gbc);
        // hasta aqui todo bien

        gbc.gridx = 0; /* ? Modifica columnas */
        gbc.gridy = 2; /* !Modifica filas */
        add(nombreJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2; /* numero de columnas que ocupa */
        add(nombreJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1; /* numero de columnas que ocupa */
        add(domicilioJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(domicilioJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(telefonoJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(telefonoJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(emaiJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(emailJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        add(fechaJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        add(fechaJDateChooser, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        add(generoJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        add(generoJComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        guardarJButton.addActionListener(this);
        add(guardarJButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        modificarJButton.addActionListener(this);
        add(modificarJButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        eliminarJButton.addActionListener(this);
        add(eliminarJButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        limpiarJButton.addActionListener(this);
        add(limpiarJButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guardarJButton) {

            String nombre = nombreJTextField.getText();
            String domicilio = domicilioJTextField.getText();
            String telefono = telefonoJTextField.getText();
            String email = emailJTextField.getText();
            System.out.println("Guardando...");

        }
        if (e.getSource() == modificarJButton) {
            String nombre = nombreJTextField.getText();
            String domicilio = domicilioJTextField.getText();
            String telefono = telefonoJTextField.getText();
            String email = emailJTextField.getText();

            System.out.println("Modificando...");

        }
        if (e.getSource() == eliminarJButton) {
            String nombre = nombreJTextField.getText();
            String domicilio = domicilioJTextField.getText();
            String telefono = telefonoJTextField.getText();
            String email = emailJTextField.getText();

            System.out.println("Eliminando...");

        }
        if (e.getSource() == limpiarJButton) {
            String nombre = nombreJTextField.getText();
            String domicilio = domicilioJTextField.getText();
            String telefono = telefonoJTextField.getText();
            String email = emailJTextField.getText();

            System.out.println("Limpiando...");
        }
    }


}
