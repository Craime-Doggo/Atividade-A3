package visao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import produtos.Produto;
import dao.ProdutoDAO;
import java.util.List;
import dao.MovimentacaoDAO;
import produtos.Movimentacao;


/**
 *
 * @author Allex
 */
public class MovimentacaoVisao extends javax.swing.JFrame {
    
     DefaultTableModel modelo = new DefaultTableModel(
        new Object[][]{},
        new String[]{"Produto", "Retirada", "Entrada", "QntAtual", "QntEditada"}
    ) {  @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 1 || columnIndex == 2) return Boolean.class;
            if (columnIndex == 3 || columnIndex == 4) return Integer.class;
            return String.class;
        }   @Override
        public boolean isCellEditable(int row, int column) {
            return column == 1 || column == 2 || column == 4;
        }
        
        @Override
        public void setValueAt(Object aValue, int row, int column) {
            super.setValueAt(aValue, row, column);
            if (column == 1 && (Boolean) aValue) super.setValueAt(false, row, 2);
            if (column == 2 && (Boolean) aValue) super.setValueAt(false, row, 1);
            fireTableCellUpdated(row, 1);
            fireTableCellUpdated(row, 2);
        }
    };
     
     public MovimentacaoVisao() {
        initComponents();
        JTEstoque.setModel(modelo);
        carregarProdutos();
    }
        

    
    private void carregarProdutos() {
    ProdutoDAO produtoDAO = new ProdutoDAO ("root", "admin"); 
    List <Produto> listaProdutos = produtoDAO.listarTodosProdutos(); // método que você cria para pegar todos os produtos

    modelo.setRowCount(0); // limpa tabela

    for (Produto p : listaProdutos) {
        // Produto, Retirada(false), Entrada(false), QntAtual, QntEditada(0)
        modelo.addRow(new Object[]{
            p.getNome(),
            false,
            false,
            p.getQuantidade_estoque(),
            0
        });
    }
}

    /**
     * Creates new form MovimentacaoVisao
     */
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTEstoque = new javax.swing.JTable();
        JTProduto = new javax.swing.JTextField();
        JBProcurar = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();
        JLQuantidade = new javax.swing.JLabel();
        JTQuantidade = new javax.swing.JTextField();
        JLEditar = new javax.swing.JLabel();
        JCRetiraAdicionar = new javax.swing.JComboBox<>();
        JBConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimento de Estoque");

        JTEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, "", null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Produto", "Retirada", "Entrada", "QntAtual", "QntEditada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTEstoque);

        JTProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTProdutoActionPerformed(evt);
            }
        });

        JBProcurar.setText("Procurar");

        JBVoltar.setText("Voltar");

        JLQuantidade.setText("Quantidade:");

        JTQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTQuantidadeActionPerformed(evt);
            }
        });

        JLEditar.setText("Retirar/Adicionar:");

        JCRetiraAdicionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Retirada", "Entrada", " " }));
        JCRetiraAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCRetiraAdicionarActionPerformed(evt);
            }
        });

        JBConfirmar.setText("Confirmar");
        JBConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(JTProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JBProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JBConfirmar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(JCRetiraAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JBVoltar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBProcurar)
                    .addComponent(JTProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLEditar)
                    .addComponent(JCRetiraAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBConfirmar)
                    .addComponent(JBVoltar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTProdutoActionPerformed

    private void JTQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTQuantidadeActionPerformed

    private void JCRetiraAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCRetiraAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCRetiraAdicionarActionPerformed

    private void JBConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfirmarActionPerformed
        
    ProdutoDAO produtoDAO = new ProdutoDAO("root", "admin"); // seu usuário e senha do banco
    MovimentacaoDAO movDAO = new MovimentacaoDAO("root", "admin");

    for (int i = 0; i < modelo.getRowCount(); i++) {
        String nomeProduto = (String) modelo.getValueAt(i, 0);
        Boolean retirada = (Boolean) modelo.getValueAt(i, 1);
        Boolean entrada = (Boolean) modelo.getValueAt(i, 2);
        int qntAtual = (int) modelo.getValueAt(i, 3);
        int qntEditada = (int) modelo.getValueAt(i, 4);

        if ((retirada || entrada) && qntEditada > 0) {
            // Buscar produto pelo nome para pegar ID
            Produto p = produtoDAO.buscarPorNome(nomeProduto);
            if (p == null) {
                System.out.println("Produto não encontrado: " + nomeProduto);
                continue;
            }

             String tipoMov = retirada ? "Saida" : "Entrada";
                Movimentacao mov = new Movimentacao();
                mov.setIdProduto(p.getId());
                mov.setTipo(tipoMov);
                mov.setQuantidade(qntEditada);

                boolean sucessoMov = movDAO.inserirMovimentacao(mov);
                if (sucessoMov) {
                    int novaQtd = retirada ? qntAtual - qntEditada : qntAtual + qntEditada;
                    boolean sucessoEstoque = produtoDAO.atualizarEstoque(p.getId(), novaQtd);
                    if (sucessoEstoque) {
                        modelo.setValueAt(novaQtd, i, 3);
                        modelo.setValueAt(false, i, 1);
                        modelo.setValueAt(false, i, 2);
                        modelo.setValueAt(0, i, 4);
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao atualizar estoque para " + nomeProduto);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar movimentação para " + nomeProduto);
                }
    }       }
    


    }//GEN-LAST:event_JBConfirmarActionPerformed

    /**
     * @param args the command line arguments
     * CODIGO SQL : SELECT p.*, c.nome_categoria 
FROM tb_produto p 
JOIN tb_categoria c ON p.id_categoria = c.id_categoria

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
            java.util.logging.Logger.getLogger(Movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovimentacaoVisao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBConfirmar;
    private javax.swing.JButton JBProcurar;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JComboBox<String> JCRetiraAdicionar;
    private javax.swing.JLabel JLEditar;
    private javax.swing.JLabel JLQuantidade;
    private javax.swing.JTable JTEstoque;
    private javax.swing.JTextField JTProduto;
    private javax.swing.JTextField JTQuantidade;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
} 
