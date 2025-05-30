package visao;
import javax.swing.table.DefaultTableModel;

public class Relatorio extends javax.swing.JFrame {

    public Relatorio() {
        initComponents();
    }
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    //tipos de relatórios
    public void gerarPreco() {
        modelo.setRowCount(0);
        modelo.setColumnIdentifiers(new String[] {
            "Nome", "Preço", "Unidade", "Categoria"
        });
        modelo.setRowCount(4);
        tabelaRelatorio.setModel(modelo);
        
    }
    public void gerarBalanco() {
        modelo.setRowCount(0);
        modelo.setColumnIdentifiers(new String[] {
            "Nome", "Quant. Estoque", "Preço Unidade", "Preço Total"
        });
        modelo.setRowCount(4);
        tabelaRelatorio.setModel(modelo);
        
    }
    public void gerarMinimo() {
        modelo.setRowCount(0);
        modelo.setColumnIdentifiers(new String[] {
            "Nome", "Estoque Min.", "Quant. Estoque"
        });
        modelo.setRowCount(4);
        tabelaRelatorio.setModel(modelo);
        
    }
    public void gerarMaximo() {
        modelo.setRowCount(0);
        modelo.setColumnIdentifiers(new String[] {
            "Nome", "Estoque Max.", "Quant. Estoque"
        });
        modelo.setRowCount(4);
        tabelaRelatorio.setModel(modelo);
        
    }
    public void gerarCategoria() {
        modelo.setRowCount(0);
        modelo.setColumnIdentifiers(new String[] {
            "Categoria", "Quantidade de Produtos"
        });
        modelo.setRowCount(4);
        tabelaRelatorio.setModel(modelo);
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboRelatorio = new javax.swing.JComboBox<>();
        Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRelatorio = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios");

        comboRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lista de Preços", "Balanço Financeiro", "Abaixo da Quantidade Mínima", "Abaixo da Quantidade Máxima", "Quantidade de Produtos por Categoria" }));

        Buscar.setText("Gerar Relatório");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        tabelaRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaRelatorio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        String selecao = (String) comboRelatorio.getSelectedItem();

        switch (selecao) {
            case "Lista de Preços":
                gerarPreco();
                break;
            case "Balanço Financeiro":
                gerarBalanco();
                break;
            case "Abaixo da Quantidade Mínima":
                gerarMinimo();
                break;
            case "Abaixo da Quantidade Máxima":
                gerarMaximo();
                break;
            case "Quantidade de Produtos por Categoria":
                gerarCategoria();
                break;
        }
    }//GEN-LAST:event_BuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JComboBox<String> comboRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaRelatorio;
    // End of variables declaration//GEN-END:variables
}
