package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import dcc025.trabalho.persistence.CompradorPersistence;
import dcc025.trabalho.persistence.Persistence;
import dcc025.trabalho.persistence.VendedorPersistence;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;

public class TelaComprador extends Tela {

	private TelaLogin menu;

	private Comprador usuario;

	private JList<Vendedor> jlistVendedores;

	protected TelaComprador(TelaLogin login, Comprador comp) {
		usuario = comp;
		menu = login;
		super.botoes = new ArrayList();
		super.labels = new ArrayList();
	}

	public void desenha() {
		tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(LARGURA, ALTURA);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
		tela.setLayout(new BorderLayout());

		desenhaMenu();

		tela.pack();
	}

	private void desenhaMenu() {
		JPanel painel = configuraPainelMain("Comprador");

		labels.add(new JLabel("Nome: " + usuario.getNome()));
		labels.add(new JLabel("Email: " + usuario.getEmail()));
		labels.add(new JLabel("Saldo: " + df.format(usuario.getSaldo())));

		// Botão Adicionar Saldo
		JButton botaoAdicionarSaldo = new JButton("Aumentar Saldo");
		botaoAdicionarSaldo.setBackground(Color.decode("#002847"));
		botaoAdicionarSaldo.setForeground(Color.WHITE);
		botoes.add(botaoAdicionarSaldo);
		// Configuração
		botoes.get(0).addActionListener((ActionEvent e) -> {
			adicionarSaldo();
		});

		// Botão Carrinho de Compras
		JButton botaoCarrinhoCompras = new JButton("Carrinho de Compras");
		botaoCarrinhoCompras.setBackground(Color.decode("#002847"));
		botaoCarrinhoCompras.setForeground(Color.WHITE);
		botoes.add(botaoCarrinhoCompras);
		// Configuração
		botoes.get(1).addActionListener((ActionEvent e) -> {
			abrirCarrinho();
		});

		JPanel painelAux = new JPanel();
		painelAux.add(desenhaLabel(labels));
		painelAux.add(desenhaLista("Vendedores Disponíveis"));
		painelAux.add(desenhaBotoes(botoes));
		painel.add(painelAux, BorderLayout.CENTER);

		// Botao de Acesso a Loja do Vendedor
		JButton botaoAcessarLoja = new JButton("Acessar Loja");
		botaoAcessarLoja.setBackground(Color.decode("#002847"));
		botaoAcessarLoja.setForeground(Color.WHITE);
		try {
			botaoAcessarLoja.addActionListener((ActionEvent e) -> {
				abrirLoja();
			});
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Selecione uma loja");
		}
		botoes.add(botaoAcessarLoja);

		JPanel bpainel = new JPanel();

		// Botão Sair
		JButton botaoSair = new JButton("Sair");
		botaoSair.setBackground(Color.decode("#002847"));
		botaoSair.setForeground(Color.WHITE);
		botoes.add(botaoSair);
		// Configuração
		botoes.get(3).addActionListener((ActionEvent e) -> {
			salvar();

			fechar();
			menu.abrir();
		});

		// Adicionando os botões no bpainel
		bpainel.add(botaoSair, BorderLayout.PAGE_END);
		bpainel.add(botaoAcessarLoja, BorderLayout.SOUTH);

		painel.add(bpainel, BorderLayout.SOUTH);

		tela.getContentPane().add(painel, BorderLayout.CENTER);
	}

	@Override
	protected JPanel desenhaLista(String string) {

		JPanel painel = new JPanel();
		painel.setBorder(BorderFactory.createTitledBorder(string));
		painel.setPreferredSize(new Dimension(LARGURA, ALTURA / 3));
		painel.setLayout(new BorderLayout());

		DefaultListModel<Vendedor> model = new DefaultListModel<>();

		jlistVendedores = new JList<>(model);

		painel.add(new JScrollPane(jlistVendedores), BorderLayout.CENTER);

		Persistence<Vendedor> persistence = new VendedorPersistence();
		carregaVendedores(persistence.findAll());
		return painel;
	}

	public void adicionarSaldo() {
		TelaAdicionaSaldo addSaldo = new TelaAdicionaSaldo(this, usuario);
		addSaldo.desenha();
		tela.setVisible(false);
	}

	public void carrega() {
		salvar();

		labels.get(0).setText("Nome: " + usuario.getNome());
		labels.get(1).setText("Email: " + usuario.getEmail());
		labels.get(2).setText("Saldo: " + df.format(usuario.getSaldo()));
	}

	protected void abrir() {
		tela.setVisible(true);
	}

	public void fechar() {
		tela.dispose();
	}

	public void salvar() {
		CompradorPersistence persistence = new CompradorPersistence();
		java.util.List<Comprador> compradores = persistence.findAll();
		int index = 0;

		for (Comprador aux : compradores) {
			if (usuario.compare(aux)) {
				index = compradores.indexOf(aux);
			}
		}

		compradores.remove(index);

		compradores.add(this.usuario);
		persistence.save(compradores);
	}

	public void abrirCarrinho() {
		TelaCarrinho carrinho = new TelaCarrinho(usuario, this);
		carrinho.desenha();
		tela.setVisible(false);
	}

	public void carregaVendedores(java.util.List<Vendedor> vendedores) {
		DefaultListModel<Vendedor> model = (DefaultListModel<Vendedor>) jlistVendedores.getModel();

		for (Vendedor v : vendedores) {
			model.addElement(v);
		}
	}

	public void abrirLoja() {
		try {
			Vendedor vendedor = jlistVendedores.getSelectedValue();
			vendedorNull(vendedor);
			TelaLojaVendedor telaLoja = new TelaLojaVendedor(this, vendedor, this.usuario);
			telaLoja.desenha();
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Selecione uma loja");
		}
	}

	public void vendedorNull(Vendedor vendedor) throws NullPointerException {
		if (vendedor == null)
			throw new NullPointerException();
	}

}
