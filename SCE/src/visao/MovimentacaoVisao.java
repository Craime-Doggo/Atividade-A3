package visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import produtos.Produto;
import dao.ProdutoDAO;
import java.util.List;
//import dao.MovimentacaoDAO;
import produtos.Movimentacao;


/**
 *
 * @author Allex
 */
public class MovimentacaoVisao extends javax.swing.JFrame {
    
    
    private String user;
    private String password;
    private int idProduto;
    private String tipo; // "entrada" ou "retirada"
    private int quantidade;
   


        private void limparCampos() {
        JTProduto.setText("");
        JTQuantidade.setText("");
        // Outros campos se existirem
    }

        private ProdutoDAO getProdutoDAO() {
    return new ProdutoDAO(user, password);
}


    public void atualizarTabelaEstoqueComMovimento (String nomeMovimentado, int quantidadeMovida) {
             ProdutoDAO dao = new ProdutoDAO(user, password);
        List<Produto> lista = dao.listarTodos();
        DefaultTableModel modelo = (DefaultTableModel) JTEstoque.getModel(); // aqui fora do loop
        modelo.setRowCount(0); // Limpa a tabela uma vez só

        
            for (Produto p : lista) {
        int movido = 0;
        if (p.getNome().equalsIgnoreCase(nomeMovimentado)) {
            movido = quantidadeMovida;
            System.out.println("Produto movimentado: " + p.getNome() + " - Qnt: " + movido);
        }
}
            
            for (Produto p : lista) {
            int movido = 0;
            if (p.getNome().equals(nomeMovimentado)) {
            movido = quantidadeMovida;
            if (movido != 0) {
                System.out.println("Produto movimentado: " + p.getNome() + " - Qnt: " + movido);
            }
            
            if (p.getNome().equals(nomeMovimentado)) {
            movido = quantidadeMovida;
        }

             modelo.addRow(new Object[] {
                p.getNome(),
                p.getQuantidade_estoque(),
                movido
        });
            }
            }
        
        }


        
  
        private void adicionarProdutosSelecionados() {
    for (int i = 0; i < modelo.getRowCount(); i++) {
        int quantidade = (int) modelo.getValueAt(i, 2);
        if (quantidade > 0) {
            modelo.setValueAt("entrada", i, 3);
        }
    }
}

        private void retirarProdutosSelecionados() {
    for (int i = 0; i < modelo.getRowCount(); i++) {
        int quantidade = (int) modelo.getValueAt(i, 2);
        if (quantidade > 0) {
            modelo.setValueAt("retirada", i, 3);
        }
    }
}


    public MovimentacaoVisao (int idProduto, String tipo, int quantidade) {
        this.idProduto = idProduto;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "idProduto=" + idProduto +
                ", tipo='" + tipo + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
 
    
     DefaultTableModel modelo = new DefaultTableModel(
        new Object[][]{},
        new String[]{"Produto", "Quantiade-Estoque", "Adicionado ou Retirado"}
    ) {  
    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 2 || column == 3; // Só "Movimentado" e "Tipo" podem ser editados
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1 || columnIndex == 2) return Integer.class;
        return String.class;
    }
};
        
      
    
     private MovimentacaoVisao visaoMOV;
     
     public MovimentacaoVisao(String user, String password) {
        initComponents();
        this.user = user;
        this.password = password;
        JTEstoque.setModel(modelo);
        carregarProdutos();
    }
        

    
    private void carregarProdutos() {
    ProdutoDAO produtoDAO = new ProdutoDAO (user, password); 
    List <Produto> listaProdutos = produtoDAO.listarTodosProdutos(); // método que você cria para pegar todos os produtos

    modelo.setRowCount(0); // limpa tabela

    for (Produto p : listaProdutos) {
        // Produto, Quantidade, Adicionado ou Retirado(0)
        modelo.addRow(new Object[]{
            p.getNome(),
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
        JBConfirmar = new javax.swing.JButton();
        JBRetirar = new javax.swing.JButton();
        JBAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimento de Estoque");

        JTEstoque.setModel(modelo);
        jScrollPane1.setViewportView(JTEstoque);

        JTProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTProdutoActionPerformed(evt);
            }
        });

        JBProcurar.setText("Procurar");

        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        JLQuantidade.setText("Quantidade:");

        JTQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTQuantidadeActionPerformed(evt);
            }
        });

        JLEditar.setText("Retirar/Adicionar:");

        JBConfirmar.setText("Confirmar");
        JBConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfirmarActionPerformed(evt);
            }
        });

        JBRetirar.setText("Retirar");
        JBRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRetirarActionPerformed(evt);
            }
        });

        JBAdicionar.setText("Adicionar");
        JBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(JTProduto)
                .addGap(18, 18, 18)
                .addComponent(JBProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JBConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173)
                        .addComponent(JBAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JBVoltar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBRetirar)
                    .addComponent(JBAdicionar)
                    .addComponent(JLEditar))
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

    private void JBConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfirmarActionPerformed
        ProdutoDAO produtoDAO = new ProdutoDAO(user, password);
     String nomeProduto = JTProduto.getText().trim();
    String quantidadeStr = JTQuantidade.getText().trim();

    if (nomeProduto.isEmpty() || quantidadeStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha o nome do produto e a quantidade.");
        return;
    }

    int quantidade;
    try {
        quantidade = Integer.parseInt(quantidadeStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Quantidade inválida.");
        return;
    }

    //ProdutoDAO produtoDAO = new ProdutoDAO(user, password);
    Produto produto = produtoDAO.buscarPorNome(nomeProduto);
if (produto == null) {
    JOptionPane.showMessageDialog(this, "Produto não encontrado.");
    return;
}

int estoqueAtual = produto.getQuantidade_estoque();
int novaQuantidade = estoqueAtual;

if (tipo != null && tipo.equals("retirada")) {
    if (quantidade > estoqueAtual) {
        JOptionPane.showMessageDialog(this, "Estoque insuficiente.");
        return;
    }
    novaQuantidade -= quantidade;
    atualizarTabelaEstoqueComMovimento(nomeProduto, -quantidade); // negativo
} else if (tipo != null && tipo.equals("entrada")) {
    novaQuantidade += quantidade;
    atualizarTabelaEstoqueComMovimento(nomeProduto, quantidade); // positivo
} else {
    JOptionPane.showMessageDialog(this, "Selecione se é entrada ou retirada.");
    return;
}

produto.setQuantidade_estoque(novaQuantidade);
produtoDAO.atualizarEstoque(produto.getId(), novaQuantidade);


        // Atualizar tabela
        /*
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nomeNaTabela = modelo.getValueAt(i, 0).toString();
            if (nomeNaTabela.equalsIgnoreCase(nomeProduto)) {
                modelo.setValueAt(novaQuantidade, i, 1); // Atualiza Quantidade-Estoque
                modelo.setValueAt((foiAdicionado ? quantidade : -quantidade), i, 2); // Mostra quantidade adicionada ou retirada
                break;
             */
             for (int i = 0; i < modelo.getRowCount(); i++) {
    String nome = (String) modelo.getValueAt(i, 0);
    int qntEstoque = (Integer) modelo.getValueAt(i, 1);
    int movimentado = (Integer) modelo.getValueAt(i, 2);

    if (movimentado > 0 && tipo != null) {
        //Produto produto = produtoDAO.buscarPorNome(nome);
        if (produto != null) {
            produto.setQuantidade_estoque(qntEstoque + movimentado);
            produtoDAO.atualizarEstoque(produto.getId(), produto.getQuantidade_estoque());
        }
        
        modelo.setValueAt(0, i, 2); // limpar coluna "Adicionado ou Retirado"
    
        }

        if (movimentado > 0 && tipo != null) {
            ProdutoDAO dao = new ProdutoDAO(user, password);
            Produto p = dao.buscarPorNome(nome);
            int novoEstoque;

            if ("entrada".equalsIgnoreCase(tipo)) {
                novoEstoque = p.getQuantidade_estoque() + movimentado;
            } else if ("retirada".equalsIgnoreCase(tipo)) {
                novoEstoque = p.getQuantidade_estoque() - movimentado;
                if (novoEstoque < 0) novoEstoque = 0;
            } else {
                continue;
            }

            p.setQuantidade_estoque(novoEstoque);
            dao.atualizarEstoque(p.getId(), novoEstoque);
            
             modelo.setValueAt(novoEstoque, i, 1);
        modelo.setValueAt(0, i, 2);
        }
    }
       
        
        JOptionPane.showMessageDialog(this, "Movimentação realizada com sucesso!");
        carregarProdutos();
        limparCampos();
        
    }//GEN-LAST:event_JBConfirmarActionPerformed

    private void JBRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRetirarActionPerformed
        tipo = "retirada";
        retirarProdutosSelecionados();
        String nomeProduto = JTProduto.getText().trim();
       ProdutoDAO produtoDAO = new ProdutoDAO(user, password);
        Produto produto = produtoDAO.buscarPorNome(nomeProduto);

    if (produto != null) {
        try {
            int quantidade = Integer.parseInt(JTQuantidade.getText());

            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "Digite uma quantidade positiva.");
                return;
            }

            // Atualiza valor na tabela
                atualizarTabelaEstoqueComMovimento(nomeProduto, quantidade);

            for (int i = 0; i < JTEstoque.getRowCount(); i++) {
                String nomeTabela = JTEstoque.getValueAt(i, 0).toString();
                if (nomeTabela.equals(produto.getNome())) {
                    atualizarTabelaEstoqueComMovimento(nomeProduto, -quantidade);

                }  else {
                JOptionPane.showMessageDialog(this, "Estoque insuficiente para retirada.");
            }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite uma quantidade válida.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Produto não encontrado.");
    }
    int linha = JTEstoque.getSelectedRow();
    if (linha >= 0) {
    int atual = (Integer) modelo.getValueAt(linha, 2);
    if (atual > 0) modelo.setValueAt(atual - 1, linha, 2);
    }


    }//GEN-LAST:event_JBRetirarActionPerformed

    private void JBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAdicionarActionPerformed
         /*
        tipo = "entrada";
        adicionarProdutosSelecionados();
        String nomeProduto = JTProduto.getText().trim();
       //String quantidadeTexto = JTQuantidade.getText().trim();
        ProdutoDAO produtoDAO = new ProdutoDAO(user, password);
        Produto produto = produtoDAO.buscarPorNome(nomeProduto); // <-- IMPORTANTE

            if (produto != null) {
      int quantidadeTexto = Integer.parseInt(JTQuantidade.getText());
      
        if (produto.getQuantidade_estoque() >= quantidadeTexto) {
            produto.setQuantidade_estoque(produto.getQuantidade_estoque() + quantidadeTexto);
            produtoDAO.atualizarEstoque(idProduto, quantidade);
            atualizarTabelaEstoqueComMovimento(nomeProduto, quantidadeTexto);

        } else {
            JOptionPane.showMessageDialog(this, "Estoque insuficiente para retirada.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Produto não encontrado.");
    }
            int linha = JTEstoque.getSelectedRow();
    if (linha >= 0) {
    int atual = (Integer) modelo.getValueAt(linha, 2);
    modelo.setValueAt(atual + 1, linha, 2);
    }
        */
             tipo = "entrada";
        adicionarProdutosSelecionados();
        String nomeProduto = JTProduto.getText().trim();
       ProdutoDAO produtoDAO = new ProdutoDAO(user, password);
        Produto produto = produtoDAO.buscarPorNome(nomeProduto);

    if (produto != null) {
        try {
            int quantidade = Integer.parseInt(JTQuantidade.getText());

            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "Digite uma quantidade positiva.");
                return;
            }
                atualizarTabelaEstoqueComMovimento(nomeProduto, quantidade);

            for (int i = 0; i < JTEstoque.getRowCount(); i++) {
                String nomeTabela = JTEstoque.getValueAt(i, 0).toString();
                if (nomeTabela.equals(produto.getNome())) {
                    //atualizarTabelaEstoqueComMovimento(nomeProduto, + quantidade);

                }  else {
                JOptionPane.showMessageDialog(this, "Estoque insuficiente para retirada.");
            }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite uma quantidade válida.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Produto não encontrado.");
    }
    int linha = JTEstoque.getSelectedRow();
    if (linha >= 0) {
    int atual = (Integer) modelo.getValueAt(linha, 2);
    if (atual > 0) modelo.setValueAt(atual - 1, linha, 2);
    }

    }//GEN-LAST:event_JBAdicionarActionPerformed

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
       this.dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

  
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
                new MovimentacaoVisao("root", "admin").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAdicionar;
    private javax.swing.JButton JBConfirmar;
    private javax.swing.JButton JBProcurar;
    private javax.swing.JButton JBRetirar;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JLabel JLEditar;
    private javax.swing.JLabel JLQuantidade;
    private javax.swing.JTable JTEstoque;
    private javax.swing.JTextField JTProduto;
    private javax.swing.JTextField JTQuantidade;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
} 
