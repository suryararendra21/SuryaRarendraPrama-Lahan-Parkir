package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import controller.ParkirController;
import entity.KeluarEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SemuaMobilGui extends Frame {
    private JTable dataParkirTable;
    private JScrollPane scrollPane;
    private JLabel adminLabel;
    private JButton keluarBtn;
    private JTextField selectedField = new JTextField();
    public SemuaMobilGui() {
        super("Page Admin", 600, 700);
        setLocation(40, 40);
    }
    @Override
    protected void component() {
        adminLabel = new JLabel("Daftar Semua Mobil");
        adminLabel.setFont(new Font("Arial", Font.BOLD, 20));
        adminLabel.setForeground(Color.GREEN);
        setBound(adminLabel, 200, 100, 200, 45);

        dataParkirTable = new JTable();
        dataParkirTable.setModel(createDataTable());
        dataParkirTable.setDefaultEditor(Object.class, null);
        dataParkirTable.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(dataParkirTable);
        setBound(scrollPane, 50, 190, 500, 200);

        keluarBtn = new JButton("Keluar");
        keluarBtn.setForeground(Color.white);
        keluarBtn.setBackground(Color.DARK_GRAY);
        keluarBtn.setFocusPainted(false);
        setBound(keluarBtn, 85, 565, 85, 30);

    }

    @Override
    protected void event() {
        ParkirController parkirController = new ParkirController();
        dataParkirTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = dataParkirTable.getSelectedRow();
                String selectedPlatNomor = dataParkirTable.getValueAt(i, 0).toString();
                selectedField.setText(selectedPlatNomor);
            }
        });
        keluarBtn.addActionListener((e) -> {
            dispose();
            new MenuGui().setVisible(true);
        });

    }

    private DefaultTableModel createDataTable() {
        DefaultTableModel dataTable = new DefaultTableModel();
        Object column[] = {
                "PLAT NOMOR",
                "TANGGAL MASUK",
                "TANGGAL KELUAR"
        };
        dataTable.setColumnIdentifiers(column);

        ParkirController parkirController = new ParkirController();

        ArrayList<KeluarEntity> arrayKeluar = parkirController.lihatSemuaMobil();
        for (KeluarEntity keluar : arrayKeluar) {
            Object[] data = new String[] {
                    keluar.getPlatNomor(),
                    keluar.getTanggalMasuk(),
                    keluar.getTanggalKeluar(),
            };
            dataTable.addRow(data);
        }
        return dataTable;
    }
    public static void main(String [] args){
        new SemuaMobilGui().setVisible(true);
    }
}
