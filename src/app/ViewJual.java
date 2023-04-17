/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ViewJual extends javax.swing.JFrame {

    /**
     * Creates new form ViewJual
     */
    AksiBeli conn; AksiRekap nnoc;
    public ViewJual() {
        conn = new AksiBeli(this);
        nnoc = new AksiRekap(this);
        initComponents();
    }
    
    // fungsi untuk menyimpan ke tabel
    public void save() {
        String kdBeli = inputKdBeli.getText();
        String Pembeli = inputPembeli.getText();
        String jnsMartabak = inputMartabak.getSelectedItem().toString();
        String jmlBeli = inputJumlah.getText();
        String totBayar = sTotBayar.getText();
        
        if(kdBeli.trim().isEmpty() || Pembeli.trim().isEmpty() ||
           jnsMartabak.equals("--Pilih--")||jmlBeli.trim().isEmpty() ){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong!");
        }else if(inputBayar.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Data yang akan ditambahkan Kosong!");
        }else{
            DefaultTableModel model = (DefaultTableModel) tabelRekap.getModel();

            Object[] row = {kdBeli, Pembeli, jnsMartabak, jmlBeli, totBayar};
            model.addRow(row);
            reset();
        }
    }
    
    // fungsi untuk menghapus data di tabel
    public void delete() {
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabelRekap.getModel();
        
        if(tabelRekap.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan seleksi baris data yang akan dihapus");
            return;
        }
        
        int row = tabelRekap.getSelectedRow();
        if(row >= 0) {
            int ok = JOptionPane.showConfirmDialog(null, "Yakin Mau Hapus?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(ok == 0) {
                model.removeRow(row);
            }
        }
    }
    
    // fungsi untuk mengambil data yang akan diedit
    public void pilihData() {
        
        if(tabelRekap.getSelectedRowCount() > 0) {
            Integer index = tabelRekap.getSelectedRow();
            pilihKdBeli.setText(tabelRekap.getValueAt(index, 0).toString());
            pilihPembeli.setText(tabelRekap.getValueAt(index, 1).toString());
            pilihMartabak.setSelectedItem(tabelRekap.getValueAt(index, 2).toString());
            pilihJumlah.setText(tabelRekap.getValueAt(index, 3).toString());
            pilihTotBayar.setText(tabelRekap.getValueAt(index, 4).toString());
            
        }else{
            JOptionPane.showMessageDialog(null, "Silahkan seleksi baris data yang akan dihapus");
        }
    }
    
    public void reset() {
        inputKdBeli.setText(null);
        inputPembeli.setText(null);
        inputMartabak.setSelectedItem("--Pilih--");
        inputJumlah.setText(null);
        inputBayar.setText(null);
        sKembalian.setText(null);
    }
    
    public void nota() {
        CetakNota nota = new CetakNota();
        nota.setVisible(true);
        nota.pack();
        nota.setLocationRelativeTo(null);
        nota.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        String kdBeli = sKdBeli.getText();
        String Pembeli = sPembeli.getText();
        String jnsMartabak = sMartabak.getText();
        String jmlBeli = sJumlah.getText();
        String totBayar = sTotBayar.getText();
        String Bayar = inputBayar.getText();
        String Kembalian = sKembalian.getText();

        nota.getHslKdBeli().setText(kdBeli);
        nota.getHslPembeli().setText(Pembeli);
        nota.getHslMartabak().setText(jnsMartabak);
        nota.getHslJumlah().setText(jmlBeli);
        nota.getHslTotBayar().setText(totBayar);
        nota.getHslBayar().setText(Bayar);
        nota.getHslKembalian().setText(Kembalian);
        nota.setVisible(true);
    }
    
    // fungsi untuk mengupdate data di tabel rekap
    public void update() {
        nnoc.setUpdate();
        Integer index = tabelRekap.getSelectedRow();
        String kdBeli = pilihKdBeli.getText();
        String Pembeli = pilihPembeli.getText();
        String jnsMartabak = pilihMartabak.getSelectedItem().toString();
        String jmlBeli = pilihJumlah.getText();
        String totBayar = pilihTotBayar.getText();

        tabelRekap.setValueAt(kdBeli, index, 0);
        tabelRekap.setValueAt(Pembeli, index, 1);
        tabelRekap.setValueAt(jnsMartabak, index, 2);
        tabelRekap.setValueAt(jmlBeli, index, 3);
        tabelRekap.setValueAt(totBayar, index, 4);
    }
    
    // fungsi untuk melakukan pencarian di tabel rekap
    public void cari() {
        String cari = inputCari.getText();
        //ambil nilai jumlah baris yg ada pada tabel
        int jumlahBaris = tabelRekap.getRowCount();
        //lakukan perulangan untuk pencarian
        for(int i=0; i<jumlahBaris; i++){
            if(cari.equals(tabelRekap.getValueAt(i, 0)) || cari.equals(tabelRekap.getValueAt(i, 1)) ||
                cari.equals(tabelRekap.getValueAt(i, 2)) || cari.equals(tabelRekap.getValueAt(i, 3)) ||
                cari.equals(tabelRekap.getValueAt(i, 4))){
                JOptionPane.showMessageDialog(null,
                    "Data " + cari + " ditemukan di baris ke-"+(i+1));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        menuUtama = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        menuPembelian = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        inputKdBeli = new javax.swing.JTextField();
        inputPembeli = new javax.swing.JTextField();
        inputMartabak = new javax.swing.JComboBox<>();
        inputJumlah = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnBeli = new javax.swing.JButton();
        sKdBeli = new javax.swing.JTextField();
        sPembeli = new javax.swing.JTextField();
        sMartabak = new javax.swing.JTextField();
        sJumlah = new javax.swing.JTextField();
        sTotBayar = new javax.swing.JTextField();
        inputBayar = new javax.swing.JTextField();
        sKembalian = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();
        btnAddTabel = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        menuRekap = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelRekap = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        pilihKdBeli = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        pilihPembeli = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        pilihMartabak = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        pilihJumlah = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        pilihTotBayar = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        inputCari = new javax.swing.JTextField();
        btnPilih = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Menu.png"))); // NOI18N
        jLabel22.setText("jLabel22");

        javax.swing.GroupLayout menuUtamaLayout = new javax.swing.GroupLayout(menuUtama);
        menuUtama.setLayout(menuUtamaLayout);
        menuUtamaLayout.setHorizontalGroup(
            menuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuUtamaLayout.setVerticalGroup(
            menuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.addTab("Menu Utama", menuUtama);

        menuPembelian.setBackground(new java.awt.Color(0, 0, 0));

        btnLogout.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        inputKdBeli.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        inputPembeli.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        inputMartabak.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        inputMartabak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Martabak Coklat", "Martabak Keju", "Martabak Coklat Keju", "Martabak Coklat Pisang", "Martabak Telur Biasa", "Martabak Telur Spesial", "Martabak Telur Istimewa", "Martabak Telur Super" }));
        inputMartabak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMartabakActionPerformed(evt);
            }
        });

        inputJumlah.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        inputJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputJumlahActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnBeli.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnBeli.setText("Beli");
        btnBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeliActionPerformed(evt);
            }
        });

        sKdBeli.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        sPembeli.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        sMartabak.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        sJumlah.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        sTotBayar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        sTotBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sTotBayarActionPerformed(evt);
            }
        });

        inputBayar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        inputBayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputBayarMouseClicked(evt);
            }
        });

        sKembalian.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        sKembalian.setFocusCycleRoot(true);

        btnHitung.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        btnAddTabel.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnAddTabel.setText("Input Ke Rekap");
        btnAddTabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTabelActionPerformed(evt);
            }
        });

        btnCetak.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnCetak.setText("Cetak Nota");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Form Kasir Atas.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Form Kasir Bawah.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kode Beli");

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pembeli");

        jLabel7.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Jenis Martabak");

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Jumlah");

        jLabel9.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Kode Beli");

        jLabel10.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pembeli");

        jLabel11.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Martabak");

        jLabel12.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jumlah");

        jLabel13.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total Bayar");

        jLabel14.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Bayar");

        jLabel21.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Kembalian");

        javax.swing.GroupLayout menuPembelianLayout = new javax.swing.GroupLayout(menuPembelian);
        menuPembelian.setLayout(menuPembelianLayout);
        menuPembelianLayout.setHorizontalGroup(
            menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPembelianLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPembelianLayout.createSequentialGroup()
                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(90, 90, 90)
                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputKdBeli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(menuPembelianLayout.createSequentialGroup()
                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(menuPembelianLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(sKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(menuPembelianLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(menuPembelianLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(sTotBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(menuPembelianLayout.createSequentialGroup()
                                            .addComponent(btnBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(40, 40, 40)
                                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))))
                            .addGroup(menuPembelianLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputMartabak, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(123, 123, 123))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuPembelianLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPembelianLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPembelianLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(108, 108, 108)
                        .addComponent(inputBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13)
                    .addComponent(jLabel21)
                    .addGroup(menuPembelianLayout.createSequentialGroup()
                        .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnAddTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPembelianLayout.createSequentialGroup()
                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(73, 73, 73)
                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sKdBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sMartabak, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(70, 70, 70))
        );
        menuPembelianLayout.setVerticalGroup(
            menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPembelianLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPembelianLayout.createSequentialGroup()
                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuPembelianLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(26, 26, 26)
                                .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(inputBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(menuPembelianLayout.createSequentialGroup()
                                .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(menuPembelianLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(sKdBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addGap(25, 25, 25)
                                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(sPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21)
                                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(sMartabak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(sJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(menuPembelianLayout.createSequentialGroup()
                                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(menuPembelianLayout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(inputPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6)))
                                            .addGroup(menuPembelianLayout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(inputKdBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5))))
                                        .addGap(48, 48, 48)
                                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(inputMartabak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)))
                                .addComponent(sTotBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)))
                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHitung)
                            .addComponent(btnAddTabel)
                            .addComponent(btnCetak)
                            .addComponent(btnLogout)
                            .addComponent(btnReset)
                            .addComponent(btnBeli))
                        .addGap(3, 3, 3))
                    .addGroup(menuPembelianLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addGroup(menuPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jTabbedPane1.addTab("Menu Pembelian", menuPembelian);

        menuRekap.setBackground(new java.awt.Color(0, 0, 0));

        tabelRekap.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tabelRekap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Beli", "Pembeli", "Martabak", "Jumlah Beli", "Total Bayar"
            }
        ));
        jScrollPane2.setViewportView(tabelRekap);

        jLabel15.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Kode Beli");

        pilihKdBeli.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Pembeli");

        pilihPembeli.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Jenis Martabak");

        pilihMartabak.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        pilihMartabak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Martabak Coklat", "Martabak Keju", "Martabak Coklat Keju", "Martabak Coklat Pisang", "Martabak Telur Biasa", "Martabak Telur Spesial", "Martabak Telur Istimewa", "Martabak Telur Super" }));

        jLabel18.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Jumlah");

        pilihJumlah.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Total Bayar");

        pilihTotBayar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Cari Data");

        inputCari.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        btnPilih.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnPilih.setText("Pilih Data");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Form");

        jLabel3.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 136, 36));
        jLabel3.setText("Rekap Data");

        javax.swing.GroupLayout menuRekapLayout = new javax.swing.GroupLayout(menuRekap);
        menuRekap.setLayout(menuRekapLayout);
        menuRekapLayout.setHorizontalGroup(
            menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuRekapLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addGap(72, 72, 72)
                .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pilihTotBayar)
                    .addComponent(pilihPembeli)
                    .addComponent(pilihJumlah)
                    .addComponent(pilihMartabak, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pilihKdBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuRekapLayout.createSequentialGroup()
                        .addComponent(btnPilih, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuRekapLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuRekapLayout.createSequentialGroup()
                        .addComponent(btnCari)
                        .addGap(175, 175, 175))))
            .addGroup(menuRekapLayout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuRekapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inputCari, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        menuRekapLayout.setVerticalGroup(
            menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuRekapLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuRekapLayout.createSequentialGroup()
                        .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pilihKdBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(32, 32, 32)
                        .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pilihPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(35, 35, 35)
                        .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(pilihMartabak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(menuRekapLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(inputCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari)
                        .addGap(28, 28, 28)))
                .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pilihJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(31, 31, 31)
                .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(pilihTotBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPilih)
                        .addComponent(btnUpdate)
                        .addComponent(btnHapus)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Rekap Data Penjualan", menuRekap);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        setSize(new java.awt.Dimension(916, 640));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        pilihData();
    }//GEN-LAST:event_btnPilihActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeliActionPerformed
        if(inputKdBeli.getText().isEmpty() || inputPembeli.getText().isEmpty() ||
            inputMartabak.getSelectedItem().equals("--Pilih--") || inputJumlah.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error!", "Pastikan semua data telah diisi!", JOptionPane.ERROR_MESSAGE);
        }else if(inputBayar.getText().isEmpty()) {
            inputBayar.setText("Masukkan Uang yang dibayarkan!");
            sKembalian.setText("Isi pada Input Bayar!");
        }
        conn.setData();
    }//GEN-LAST:event_btnBeliActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        FormLogin login = new FormLogin();
        int jawab = JOptionPane.showOptionDialog(this,
            "Logout Akun?",
            "Logout",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, null, null);

        if(jawab == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Kembali ke Form Login!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddTabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTabelActionPerformed
        save();
    }//GEN-LAST:event_btnAddTabelActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        nota();
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        conn.hitung();
        if(inputBayar == null || sKembalian == null ) {
            JOptionPane.showMessageDialog(null, "Error!", "Masukkan uang yang dibayarkan!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHitungActionPerformed

    private void inputBayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputBayarMouseClicked
        inputBayar.setText(null);
        sKembalian.setText(null);
    }//GEN-LAST:event_inputBayarMouseClicked

    private void inputMartabakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMartabakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMartabakActionPerformed

    private void inputJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJumlahActionPerformed

    private void sTotBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sTotBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sTotBayarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewJual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewJual().setVisible(true);
            }
        });
    }

    public JTextField getInputBayar() {
        return inputBayar;
    }

    public JTextField getInputJumlah() {
        return inputJumlah;
    }

    public JTextField getInputKdBeli() {
        return inputKdBeli;
    }

    public JComboBox<String> getInputMartabak() {
        return inputMartabak;
    }

    public JTextField getInputPembeli() {
        return inputPembeli;
    }
    
    
    
    public JTextField getsJumlah() {
        return sJumlah;
    }

    public JTextField getsKdBeli() {
        return sKdBeli;
    }

    public JTextField getsKembalian() {
        return sKembalian;
    }

    public JTextField getsMartabak() {
        return sMartabak;
    }

    public JTextField getsPembeli() {
        return sPembeli;
    }

    public JTextField getsTotBayar() {
        return sTotBayar;
    }

    public JTextField getPilihJumlah() {
        return pilihJumlah;
    }

    public JTextField getPilihKdBeli() {
        return pilihKdBeli;
    }

    public JComboBox<String> getPilihMartabak() {
        return pilihMartabak;
    }

    public JTextField getPilihPembeli() {
        return pilihPembeli;
    }

    public JTextField getPilihTotBayar() {
        return pilihTotBayar;
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTabel;
    private javax.swing.JButton btnBeli;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPilih;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField inputBayar;
    private javax.swing.JTextField inputCari;
    private javax.swing.JTextField inputJumlah;
    private javax.swing.JTextField inputKdBeli;
    private javax.swing.JComboBox<String> inputMartabak;
    private javax.swing.JTextField inputPembeli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel menuPembelian;
    private javax.swing.JPanel menuRekap;
    private javax.swing.JPanel menuUtama;
    private javax.swing.JTextField pilihJumlah;
    private javax.swing.JTextField pilihKdBeli;
    private javax.swing.JComboBox<String> pilihMartabak;
    private javax.swing.JTextField pilihPembeli;
    private javax.swing.JTextField pilihTotBayar;
    private javax.swing.JTextField sJumlah;
    private javax.swing.JTextField sKdBeli;
    private javax.swing.JTextField sKembalian;
    private javax.swing.JTextField sMartabak;
    private javax.swing.JTextField sPembeli;
    private javax.swing.JTextField sTotBayar;
    private javax.swing.JTable tabelRekap;
    // End of variables declaration//GEN-END:variables
}
