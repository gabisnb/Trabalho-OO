package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import dcc025.trabalho.controller.Entrar;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaLogin extends Tela {

    private JComboBox<String> cbEscolha;
    private ArrayList<JTextField> tf;

    public TelaLogin() {
        super.botoes = new ArrayList<>();
        super.labels = new ArrayList<>();
        tf = new ArrayList<>();
    }

    public void desenha() {
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA);
        tela.setLocationRelativeTo(null);
        abrir();
        tela.setLayout(new BorderLayout());

        desenhaMenu();

        tela.pack();
    }

    private void desenhaMenu() {
        JPanel painel = configuraPainelMain("Login");
        painel.setBorder(new EmptyBorder(20, 0, 0, 0)); // Espaçamento no topo

        labels.add(new JLabel("Nome: "));
        labels.add(new JLabel("Email: "));
        labels.add(new JLabel("Senha: "));

        JPanel painelAux = new JPanel();
        painelAux.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        for (int i = 0; i < labels.size(); i++) {
            JLabel label = labels.get(i);
            gbc.gridx = 0;
            gbc.gridy = i;
            painelAux.add(label, gbc);

            JTextField textField = new JTextField(20);
            tf.add(textField);
            gbc.gridx = 1;
            gbc.gridy = i;
            painelAux.add(textField, gbc);
        }

        JLabel lblTipoUsuario = new JLabel("Tipo de Usuário: ");
        gbc.gridx = 0;
        gbc.gridy = labels.size();
        painelAux.add(lblTipoUsuario, gbc);

        cbEscolha = new JComboBox<>();
        cbEscolha.addItem("Comprador");
        cbEscolha.addItem("Vendedor");
        gbc.gridx = 1;
        gbc.gridy = labels.size();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Faz o JComboBox preencher o espaço horizontal
        painelAux.add(cbEscolha, gbc);

        painel.add(painelAux, BorderLayout.CENTER);

        JPanel bpainel = new JPanel();

        botoes.add(new JButton("Entrar"));
        JButton btnEntrar = botoes.get(0);

        btnEntrar.setBackground(Color.decode("#002847"));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setPreferredSize(new Dimension((int) (LARGURA * 0.8), btnEntrar.getPreferredSize().height));

        btnEntrar.addActionListener(new Entrar(this));

        bpainel.add(btnEntrar);
        painel.add(bpainel, BorderLayout.SOUTH);

        // Aumentar o tamanho da letra da palavra "Login"
        JLabel lblLogin = new JLabel("LOGIN");
        Font fonte = lblLogin.getFont();
        lblLogin.setFont(fonte.deriveFont(fonte.getSize() + 8f)); // Aumenta o tamanho da fonte em 8 pontos
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(lblLogin, BorderLayout.NORTH);

        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }

    public void entrarVendedor(Vendedor vendedor) {
        TelaVendedor telaVendedor = new TelaVendedor(this, vendedor);
        telaVendedor.desenha();
        tela.setVisible(false);
    }

    public void entrarComprador(Comprador comprador) {
        TelaComprador telaComprador = new TelaComprador(this, comprador);
        telaComprador.desenha();
        tela.setVisible(false);
    }

    public int getSelectedUsuario() {
        return cbEscolha.getSelectedIndex();
    }

    public String[] getInfo() {
        String[] info = new String[3];
        info[0] = tf.get(0).getText();
        info[1] = tf.get(1).getText();
        info[2] = tf.get(2).getText();

        return info;
    }

    protected void abrir() {
        tela.setVisible(true);
    }

}
