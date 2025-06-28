package org.example.vista;


import org.example.controlador.Coordinador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private Coordinador coordinador;
    private JButton btnGestionarPersonas;
    private JButton btnGestionarMascotas;
    private JButton btnSalir;

    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Clínica Veterinaria ABC - Sistema de Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(240, 248, 255));

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(70, 130, 180));
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("CLÍNICA VETERINARIA ABC");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitulo.add(lblTitulo);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        panelBotones.setBackground(new Color(240, 248, 255));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        btnGestionarPersonas = new JButton("GESTIONAR PERSONAS");
        btnGestionarPersonas.setFont(new Font("Arial", Font.BOLD, 16));
        btnGestionarPersonas.setPreferredSize(new Dimension(250, 50));
        btnGestionarPersonas.setBackground(new Color(60, 179, 113));
        btnGestionarPersonas.setForeground(Color.WHITE);
        btnGestionarPersonas.setFocusPainted(false);
        btnGestionarPersonas.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelBotones.add(btnGestionarPersonas, gbc);

        btnGestionarMascotas = new JButton("GESTIONAR MASCOTAS");
        btnGestionarMascotas.setFont(new Font("Arial", Font.BOLD, 16));
        btnGestionarMascotas.setPreferredSize(new Dimension(250, 50));
        btnGestionarMascotas.setBackground(new Color(255, 140, 0));
        btnGestionarMascotas.setForeground(Color.WHITE);
        btnGestionarMascotas.setFocusPainted(false);
        btnGestionarMascotas.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelBotones.add(btnGestionarMascotas, gbc);

        btnSalir = new JButton("SALIR");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 16));
        btnSalir.setPreferredSize(new Dimension(250, 50));
        btnSalir.setBackground(new Color(220, 20, 60));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFocusPainted(false);
        btnSalir.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelBotones.add(btnSalir, gbc);

        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(new Color(240, 248, 255));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        JLabel lblInfo = new JLabel("<html><center>Sistema de gestión para el registro y control<br>de personas y mascotas</center></html>");
        lblInfo.setFont(new Font("Arial", Font.ITALIC, 12));
        lblInfo.setForeground(new Color(105, 105, 105));
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        panelInfo.add(lblInfo);

        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        panelPrincipal.add(panelInfo, BorderLayout.SOUTH);

        add(panelPrincipal);
        pack();
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGestionarPersonas) {
            coordinador.mostrarVentanaPersona();
        } else if (e.getSource() == btnGestionarMascotas) {
            coordinador.mostrarVentanaMascota();
        } else if (e.getSource() == btnSalir) {
            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro que desea salir del sistema?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (opcion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
