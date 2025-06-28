package org.example.vista;


import org.example.controlador.Coordinador;
import org.example.modelo.vo.PersonaVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPersona extends JFrame implements ActionListener {

    private Coordinador coordinador;

    private JTextField txtDocumento;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JTextArea txtAreaInfo;

    private JButton btnRegistrar;
    private JButton btnConsultar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnConsultarLista;
    private JButton btnLimpiar;
    private JButton btnVolver;

    public VentanaPersona() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Gestión de Personas - Clínica Veterinaria ABC");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(240, 248, 255));

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(60, 179, 113));
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel("GESTIÓN DE PERSONAS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitulo.add(lblTitulo);

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridBagLayout());
        panelFormulario.setBackground(new Color(240, 248, 255));
        panelFormulario.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Datos de la Persona",
                0, 0, new Font("Arial", Font.BOLD, 14), new Color(70, 130, 180)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        panelFormulario.add(new JLabel("Documento:"), gbc);
        gbc.gridx = 1;
        txtDocumento = new JTextField(20);
        panelFormulario.add(txtDocumento, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelFormulario.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        txtNombre = new JTextField(20);
        panelFormulario.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panelFormulario.add(new JLabel("Apellido:"), gbc);
        gbc.gridx = 1;
        txtApellido = new JTextField(20);
        panelFormulario.add(txtApellido, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panelFormulario.add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1;
        txtTelefono = new JTextField(20);
        panelFormulario.add(txtTelefono, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        panelFormulario.add(new JLabel("Dirección:"), gbc);
        gbc.gridx = 1;
        txtDireccion = new JTextField(20);
        panelFormulario.add(txtDireccion, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        panelFormulario.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        txtEmail = new JTextField(20);
        panelFormulario.add(txtEmail, gbc);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 4, 10, 10));
        panelBotones.setBackground(new Color(240, 248, 255));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBackground(new Color(60, 179, 113));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(this);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBackground(new Color(70, 130, 180));
        btnConsultar.setForeground(Color.WHITE);
        btnConsultar.setFocusPainted(false);
        btnConsultar.addActionListener(this);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(new Color(255, 140, 0));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(this);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(220, 20, 60));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(this);

        btnConsultarLista = new JButton("Consultar Lista");
        btnConsultarLista.setBackground(new Color(128, 0, 128));
        btnConsultarLista.setForeground(Color.WHITE);
        btnConsultarLista.setFocusPainted(false);
        btnConsultarLista.addActionListener(this);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBackground(new Color(105, 105, 105));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.addActionListener(this);

        btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(139, 69, 19));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(this);

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnConsultarLista);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnVolver);
        panelBotones.add(new JLabel());

        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BorderLayout());
        panelInfo.setBackground(new Color(240, 248, 255));
        panelInfo.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Información",
                0, 0, new Font("Arial", Font.BOLD, 14), new Color(70, 130, 180)));

        txtAreaInfo = new JTextArea(12, 30);
        txtAreaInfo.setEditable(false);
        txtAreaInfo.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtAreaInfo.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(txtAreaInfo);
        panelInfo.add(scrollPane, BorderLayout.CENTER);

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BorderLayout());
        panelIzquierdo.setBackground(new Color(240, 248, 255));
        panelIzquierdo.add(panelFormulario, BorderLayout.CENTER);
        panelIzquierdo.add(panelBotones, BorderLayout.SOUTH);

        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
        panelPrincipal.add(panelIzquierdo, BorderLayout.WEST);
        panelPrincipal.add(panelInfo, BorderLayout.CENTER);

        add(panelPrincipal);
        pack();
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    private void limpiarCampos() {
        txtDocumento.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtAreaInfo.setText("");
    }

    private PersonaVO crearPersonaDesdeFormulario() {
        return new PersonaVO(
                txtDocumento.getText().trim(),
                txtNombre.getText().trim(),
                txtApellido.getText().trim(),
                txtTelefono.getText().trim(),
                txtDireccion.getText().trim(),
                txtEmail.getText().trim()
        );
    }

    private void cargarPersonaEnFormulario(PersonaVO persona) {
        if (persona != null) {
            txtDocumento.setText(persona.getDocumento());
            txtNombre.setText(persona.getNombre());
            txtApellido.setText(persona.getApellido());
            txtTelefono.setText(persona.getTelefono());
            txtDireccion.setText(persona.getDireccion());
            txtEmail.setText(persona.getEmail());
        }
    }

    private boolean validarCampos() {
        if (txtDocumento.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El documento es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtApellido.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El apellido es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            if (validarCampos()) {
                PersonaVO persona = crearPersonaDesdeFormulario();
                String resultado = coordinador.registrarPersona(persona);
                txtAreaInfo.setText(resultado);
            }
        } else if (e.getSource() == btnConsultar) {
            String documento = txtDocumento.getText().trim();
            if (documento.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el documento a consultar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PersonaVO persona = coordinador.obtenerPersona(documento);
            String resultado = coordinador.consultarPersona(documento);
            txtAreaInfo.setText(resultado);
            cargarPersonaEnFormulario(persona);

        } else if (e.getSource() == btnActualizar) {
            if (validarCampos()) {
                PersonaVO persona = crearPersonaDesdeFormulario();
                String resultado = coordinador.actualizarPersona(persona);
                txtAreaInfo.setText(resultado);
            }
        } else if (e.getSource() == btnEliminar) {
            String documento = txtDocumento.getText().trim();
            if (documento.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el documento a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro que desea eliminar la persona con documento " + documento + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (opcion == JOptionPane.YES_OPTION) {
                String resultado = coordinador.eliminarPersona(documento);
                txtAreaInfo.setText(resultado);
                limpiarCampos();
            }
        } else if (e.getSource() == btnConsultarLista) {
            String resultado = coordinador.consultarTodasLasPersonas();
            txtAreaInfo.setText(resultado);
        } else if (e.getSource() == btnLimpiar) {
            limpiarCampos();
        } else if (e.getSource() == btnVolver) {
            this.setVisible(false);
        }
    }
}
