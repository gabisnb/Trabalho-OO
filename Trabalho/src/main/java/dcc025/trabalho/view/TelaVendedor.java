package dcc025.trabalho.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import dcc025.trabalho.Usuario.Vendedor;
import dcc025.trabalho.model.*;
import dcc025.trabalho.persistence.Persistence;
import dcc025.trabalho.persistence.ProdutoPersistence;
import javax.swing.border.EmptyBorder;

public class TelaVendedor extends Tela {

	private Vendedor usuario;
        
	private TelaLogin menu;

	private JList<Produto> jlistProdutos;

	protected TelaVendedor(TelaLogin login, Vendedor vend) {
		usuario = vend;
		menu = login;
		super.botoes = new ArrayList<>();
		super.labels = new ArrayList<>();

		DefaultListModel<Produto> model = new DefaultListModel<>();
		jlistProdutos = new JList<>(model);
	}

	public void desenha() {
		tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(LARGURA, ALTURA);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
		tela.setLayout(new BorderLayout());

		desenhaMenu();

		carregaProdutosBanco(Vendedor.getProdutosByVendedorID(usuario.getId()));
		tela.pack();
	}

	private void desenhaMenu() {
		JPanel painel = configuraPainelMain("Vendedor");
		painel.setBorder(new EmptyBorder(20, 0, 0, 0));

		labels.add(new JLabel("Nome: " + usuario.getNome()));
		labels.add(new JLabel("Email: " + usuario.getEmail()));

		UIManager.put("Button.background", Color.decode("#002847"));
		UIManager.put("Button.foreground", Color.WHITE);

		botoes.add(new JButton("Adicionar Produto"));
		botoes.get(0).setBackground(Color.decode("#002847"));
		botoes.get(0).setForeground(Color.WHITE);
		botoes.get(0).addActionListener((java.awt.event.ActionEvent e) -> {
			abrirAddProduto();
		});

		botoes.add(new JButton("Remover Produto"));
		botoes.get(1).setBackground(Color.decode("#002847"));
		botoes.get(1).setForeground(Color.WHITE);

		botoes.get(1).addActionListener((java.awt.event.ActionEvent e) -> {
			removeProduto(jlistProdutos.getSelectedValue());
		});

		JPanel painelAux = new JPanel();
		painelAux.add(desenhaLabel(labels));
		painelAux.add(desenhaLista("Produtos"));
		painelAux.add(desenhaBotoes(botoes));
		painel.add(painelAux, BorderLayout.CENTER);

		JPanel bpainel = new JPanel();
		bpainel.setLayout(new BorderLayout());

		botoes.add(new JButton("Sair"));
		botoes.get(2).addActionListener((java.awt.event.ActionEvent e) -> {
			fechar();
			menu.abrir();
		});

		int espacamentoHorizontal = (int) (tela.getWidth() * 0.1);
		bpainel.add(Box.createHorizontalStrut(espacamentoHorizontal), BorderLayout.WEST);
		bpainel.add(botoes.get(2), BorderLayout.CENTER);
		bpainel.add(Box.createHorizontalStrut(espacamentoHorizontal), BorderLayout.EAST);
		painel.add(bpainel, BorderLayout.SOUTH);

		tela.getContentPane().add(painel, BorderLayout.CENTER);
		// Aumentar o tamanho da letra da palavra "Login"
		JLabel lblVendedor = new JLabel("VENDEDOR");
		Font fonte = lblVendedor.getFont();
		lblVendedor.setFont(fonte.deriveFont(fonte.getSize() + 8f));
		lblVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		painel.add(lblVendedor, BorderLayout.NORTH);

		tela.getContentPane().add(painel, BorderLayout.CENTER);
	}

	@Override
	protected JPanel desenhaLista(String string) {
		JPanel painel = new JPanel();
		painel.setBorder(BorderFactory.createTitledBorder(string));
		painel.setPreferredSize(new Dimension(LARGURA, ALTURA / 3));
		painel.setLayout(new BorderLayout());

		painel.add(new JScrollPane(jlistProdutos), BorderLayout.CENTER);

		return painel;
	}

	public void carregaProdutosBanco(List<Produto> produtos) {
		DefaultListModel<Produto> model = (DefaultListModel<Produto>) jlistProdutos.getModel();
		model.clear();
		for (Produto c : produtos) {
			model.addElement(c);
		}
	}

	public void addProduto(Produto produto) {
		Persistence<Produto> persistence = new ProdutoPersistence();
		List<Produto> allProducts = persistence.findAll();

		allProducts.add(produto);

		persistence.save(allProducts);
		carregaProdutosBanco(Vendedor.getProdutosByVendedorID(usuario.getId()));
	}

	public void removeProduto(Produto produto) {
		ProdutoPersistence persistence = new ProdutoPersistence();
		java.util.List<Produto> allProducts = persistence.findAll();

		try {
			int index = 0;

			for (Produto product : allProducts)
				if (produto.compare(product))
					index = allProducts.indexOf(product);

			allProducts.remove(index);
			persistence.save(allProducts);
			carregaProdutosBanco(Vendedor.getProdutosByVendedorID(usuario.getId()));
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Selecione o produto que deseja remover!");
		}
	}

	public void abrirAddProduto() {
		TelaAddProduto telaAddProd = new TelaAddProduto(this, usuario.getId());

		telaAddProd.desenha();
		tela.setVisible(false);
	}

	public void abrir() {
		tela.setVisible(true);
	}

	public void fechar() {
		tela.dispose();
	}

}
