/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.senac.pifindajob.telas;


import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.classes.Usuario;
import br.com.senac.pifindajob.persistencia.CandidatoDao;
import br.com.senac.pifindajob.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Rosilane
 */
public class CadastroTrabalhador extends javax.swing.JFrame {
     //private Usuario usuario; // 
    /**
     * Creates new form CadastroTrabalhador
     */
    public static Usuario usuario = new Usuario();
       
    public CadastroTrabalhador(String email, int idUsuario,int tipoUser,String senha) {
        initComponents();
        preencherEmail(email); 
        usuario.setId_usuario(idUsuario);
        usuario.setTipo_usuario(tipoUser);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        System.out.println("ID USUARIO AQUI.."+usuario.getId_usuario());
    }
    
    private void preencherEmail(String email) {
        txtEmail.setText(email);
        txtEmail.setEditable(false);
    }
        
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        FotoTrabalhador = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblFale = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCarreira = new javax.swing.JTextArea();
        lblCurri = new javax.swing.JLabel();
        btnEscolherArquivo = new javax.swing.JButton();
        lblArquivoSelecionado = new javax.swing.JLabel();
        btnVoltarLogin = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(227, 242, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));

        FotoTrabalhador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout FotoTrabalhadorLayout = new javax.swing.GroupLayout(FotoTrabalhador);
        FotoTrabalhador.setLayout(FotoTrabalhadorLayout);
        FotoTrabalhadorLayout.setHorizontalGroup(
            FotoTrabalhadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );
        FotoTrabalhadorLayout.setVerticalGroup(
            FotoTrabalhadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNome.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblCpf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCpf.setText("CPF");

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setText("Email");

        lblFale.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFale.setText("Fale um pouco sobre sua carreira profissional");

        jTextAreaCarreira.setColumns(20);
        jTextAreaCarreira.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCarreira);

        lblCurri.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCurri.setText("Anexar Currículo");

        btnEscolherArquivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEscolherArquivo.setText("Escolher Arquivo");
        btnEscolherArquivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        btnEscolherArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherArquivoActionPerformed(evt);
            }
        });

        lblArquivoSelecionado.setBackground(new java.awt.Color(255, 255, 255));
        lblArquivoSelecionado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblArquivoSelecionado.setText("Nenhum arquivo selecionado");
        lblArquivoSelecionado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));

        btnVoltarLogin.setBackground(new java.awt.Color(153, 153, 255));
        btnVoltarLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltarLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltarLogin.setText("< Voltar Login");
        btnVoltarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarLoginActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(18, 201, 252));
        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnProximo.setBackground(new java.awt.Color(35, 207, 92));
        btnProximo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProximo.setForeground(new java.awt.Color(255, 255, 255));
        btnProximo.setText("Próximo >");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVoltarLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurri)
                            .addComponent(lblFale)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(FotoTrabalhador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblEmail)
                                        .addComponent(lblNome))
                                    .addComponent(lblCpf))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                                    .addComponent(txtNome)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEscolherArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblArquivoSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(17, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(FotoTrabalhador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCpf)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addComponent(lblFale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblCurri)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblArquivoSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEscolherArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnVoltarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarLoginActionPerformed
        TelaLogin login = new  TelaLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarLoginActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        
        if (validaCampos() == false) {
            JOptionPane.showMessageDialog(rootPane, "Por favor, preencha todos os campos obrigatórios!");
            System.out.println("ID USUARIO AQUI NO CADASTRO: " + (usuario != null ? usuario.getId_usuario() : "Usuário não definido"));
        } else {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Usuario usuarioGerenciado = em.merge(usuario);

            Candidato candidato = new Candidato();
            candidato.setId_usuario(usuarioGerenciado);
            candidato.setNome(txtNome.getText());
            candidato.setCpf(txtCpf.getText());
            candidato.setDescricaoCarreira(jTextAreaCarreira.getText());

            em.persist(candidato);
            em.getTransaction().commit();

            System.out.println("Candidato cadastrado com ID: " + candidato.getIdCandidato());

            limparCampos();
            TelaFormacaoAcademica formacaoAcademica = new TelaFormacaoAcademica(candidato.getIdCandidato());
            formacaoAcademica.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar candidato: " + e.getMessage());
        } finally {
            em.close();
        }
}
    
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEscolherArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolherArquivoActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione um arquivo");

        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos PDF e DOC", "pdf", "doc", "docx"));

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            lblArquivoSelecionado.setText(selectedFile.getName());

            String filePath = selectedFile.getAbsolutePath();
        }
    }//GEN-LAST:event_btnEscolherArquivoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroTrabalhador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTrabalhador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTrabalhador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTrabalhador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
               new CadastroTrabalhador(txtEmail.getText(),usuario.getId_usuario(),usuario.getTipo_usuario(),usuario.getSenha()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FotoTrabalhador;
    private javax.swing.JButton btnEscolherArquivo;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnVoltarLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCarreira;
    private javax.swing.JLabel lblArquivoSelecionado;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblCurri;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFale;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtCpf;
    private static javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private boolean verificaFormatoCPF(String cpf) {
        boolean cpfValido = cpf.matches("[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}");
        if (!cpfValido) {
            JOptionPane.showMessageDialog(this, "CPF inválido! O formato deve ser xxx.xxx.xxx-xx.");
        }
        return cpfValido;
    }

    private boolean validaCampos(){
        if(txtNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Campo nome não pode ser vazio");
            return false;
        }else if(txtCpf.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Campo CPF não pode ser vazio");
            return false;
        }else if(txtEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Campo email não pode ser vazio" );
            return false;
        }else if(jTextAreaCarreira.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Campo Carreira não pode ser vazio" );
            return false;
        }else if(btnEscolherArquivo.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Campo Arquivo não pode ser vazio" );
            return false;
        } else {
            return true;
        }
    }
    
    public void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        jTextAreaCarreira.setText("");
        btnEscolherArquivo.setText("Nenhum arquivo selecionado");
    }
}