package screens;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginVentana extends JFrame implements ActionListener {

    JLabel tituloJLabel;
    JLabel usuarioJLabel;
    JTextField usuarioJTextField;
    JLabel contraseniaJLabel;
    JPasswordField contraseniaJPasswordField;
    JButton iniciarButton;
    JButton registrarButton;

    public LoginVentana(String titulo) {
        super(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 200);
        setLayout(new GridBagLayout());
        crearComponentes();

    }

    private void crearComponentes() {
        tituloJLabel = new JLabel("Iniciar sesión");
        tituloJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usuarioJLabel = new JLabel("Usuario: ");
        usuarioJTextField = new JTextField(100);
        contraseniaJLabel = new JLabel("Contraseña: ");
        contraseniaJPasswordField = new JPasswordField();
        iniciarButton = new JButton("Iniciar");
        registrarButton = new JButton("Registrar");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(tituloJLabel, gbc);

        // gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(usuarioJLabel, gbc);

        gbc.gridwidth = 3;
        gbc.gridx = 1;
        add(usuarioJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(contraseniaJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        add(contraseniaJPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        // ! agregar la acción al componente
        iniciarButton.addActionListener(this);
        add(iniciarButton, gbc);

        gbc.gridx = 2;
        // ! agregar la acción al componente
        registrarButton.addActionListener(this);
        add(registrarButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == iniciarButton) {
            System.out.println("Inciar...");
            String usuario = usuarioJTextField.getText();
            char pwd[] = contraseniaJPasswordField.getPassword();
            System.out.println("User: "+usuario);
            System.out.println("pwd: "+Arrays.toString(pwd));
            // TODO: Validar usuario y contraseña si esta chido lanzas empleados ventana
            EmpleadosVentana empleadosVentana = new EmpleadosVentana();
            empleadosVentana.setVisible(true);
            dispose();
        }
        if (e.getSource() == registrarButton) {
            System.out.println("Registrar...");
            RegistroVentana registroVentana = new RegistroVentana();
            registroVentana.setVisible(rootPaneCheckingEnabled);
        }
    }
}
