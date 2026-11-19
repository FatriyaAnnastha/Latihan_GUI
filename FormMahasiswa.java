import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormMahasiswa extends JFrame implements ActionListener {

    public JTextField txtNim, txtNama;
    public JComboBox<String> cbProdi;
    public JRadioButton rbLaki, rbPerempuan;
    public JCheckBox cbMembaca, cbOlahraga, cbMusik;
    public JButton btnSimpan, btnReset;
    public JTextArea txtHasil;

    public ButtonGroup grupGender;

    public FormMahasiswa() {

        setTitle("Form Data Mahasiswa");
        setSize(550, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel judul = new JLabel(
            "FORM DATA MAHASISWA",
            JLabel.CENTER
        );

        judul.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panelUtama = new JPanel();
        panelUtama.setLayout(new BorderLayout(10, 10));

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridBagLayout());

        txtNim = new JTextField(20);
        txtNama = new JTextField(20);

        String[] daftarProdi = {
            "Teknik Informatika",
            "Sistem Informasi",
            "Manajemen",
            "Akuntansi"
        };

        cbProdi = new JComboBox<>(daftarProdi);

        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");

        grupGender = new ButtonGroup();
        grupGender.add(rbLaki);
        grupGender.add(rbPerempuan);

        cbMembaca = new JCheckBox("Membaca");
        cbOlahraga = new JCheckBox("Olahraga");
        cbMusik = new JCheckBox("Musik");

        JPanel panelGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelGender.add(rbLaki);
        panelGender.add(rbPerempuan);

        JPanel panelHobi = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHobi.add(cbMembaca);
        panelHobi.add(cbOlahraga);
        panelHobi.add(cbMusik);

        tambahBaris(panelForm, "NIM :", txtNim, 0);
        tambahBaris(panelForm, "Nama :", txtNama, 1);
        tambahBaris(panelForm, "Program Studi :", cbProdi, 2);
        tambahBaris(panelForm, "Jenis Kelamin :", panelGender, 3);
        tambahBaris(panelForm, "Hobi :", panelHobi, 4);

        btnSimpan = new JButton("Simpan");
        btnReset = new JButton("Reset");

        JPanel panelTombol = new JPanel(new FlowLayout());
        panelTombol.add(btnSimpan);
        panelTombol.add(btnReset);

        btnSimpan.addActionListener(this);
        btnReset.addActionListener(this);

        txtHasil = new JTextArea(7, 35);
        txtHasil.setEditable(false);

        JScrollPane scroll = new JScrollPane(txtHasil);

        JPanel panelBawah = new JPanel(new BorderLayout());
        panelBawah.add(panelTombol, BorderLayout.NORTH);
        panelBawah.add(scroll, BorderLayout.CENTER);

        panelUtama.add(judul, BorderLayout.NORTH);
        panelUtama.add(panelForm, BorderLayout.CENTER);
        panelUtama.add(panelBawah, BorderLayout.SOUTH);

        add(panelUtama);

        setVisible(true);
    }

    private void tambahBaris(
        JPanel panel,
        String label,
        Component komponen,
        int baris
    ) {

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = baris;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        gbc.gridy = baris;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        panel.add(komponen, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSimpan) {

            String nim = txtNim.getText();
            String nama = txtNama.getText();
            String prodi = cbProdi.getSelectedItem().toString();

            String gender = "";

            if (rbLaki.isSelected()) {
                gender = "Laki-laki";
            } else if (rbPerempuan.isSelected()) {
                gender = "Perempuan";
            }

            String hobi = "";

            if (cbMembaca.isSelected()) {
                hobi += "Membaca ";
            }

            if (cbOlahraga.isSelected()) {
                hobi += "Olahraga ";
            }

            if (cbMusik.isSelected()) {
                hobi += "Musik ";
            }

            if (nim.isEmpty() || nama.isEmpty() || gender.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "NIM, Nama, dan Jenis Kelamin harus diisi!"
                );
                return;
            }

            txtHasil.setText(
                "DATA MAHASISWA\n" +
                "NIM : " + nim + "\n" +
                "Nama : " + nama + "\n" +
                "Program Studi : " + prodi + "\n" +
                "Jenis Kelamin : " + gender + "\n" +
                "Hobi : " + (hobi.isEmpty() ? "-" : hobi)
            );

        } else if (e.getSource() == btnReset) {

            txtNim.setText("");
            txtNama.setText("");

            cbProdi.setSelectedIndex(0);

            grupGender.clearSelection();

            cbMembaca.setSelected(false);
            cbOlahraga.setSelected(false);
            cbMusik.setSelected(false);

            txtHasil.setText("");
        }
    }

    // Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormMahasiswa());
    }
}
