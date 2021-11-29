package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import control.AlunoControle;
import model.Aluno;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class TelaCRUDAluno extends JInternalFrame {
	protected static final JLabel txtSexo = null;
	private Aluno objeto;
	private AlunoControle controle = new AlunoControle();
	private JTextField txtAluno;
	private JTextField txt;
	private JTextField textField;
	private JTextField textField_1;
	protected JLabel txtCodAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCRUDAluno frame = new TelaCRUDAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCRUDAluno() {
		setBounds(100, 100, 450, 300);

		JLabel lblTitulo = new JLabel(" Aluno");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitulo, BorderLayout.NORTH);

		JPanel painelCampos = new JPanel();
		getContentPane().add(painelCampos, BorderLayout.CENTER);

		JLabel lblCod = new JLabel("cod :");
		lblCod.setFont(new Font("Rockwell", Font.PLAIN, 14));

		txtAluno = new JTextField();
		txtAluno.setFont(new Font("Rockwell", Font.PLAIN, 14));
		txtAluno.setColumns(10);

		JLabel lblNome = new JLabel("nome :");
		lblNome.setFont(new Font("Rockwell", Font.PLAIN, 14));

		txt = new JTextField();
		txt.setColumns(10);

		JLabel lblSigla = new JLabel("sigla :");
		lblSigla.setFont(new Font("Rockwell", Font.PLAIN, 14));

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblCargaHoraria = new JLabel("cargaHoraria :");
		lblCargaHoraria.setFont(new Font("Rockwell", Font.PLAIN, 14));

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton btnInserir = new JButton("inserir");
		btnInserir.addActionListener(new ActionListener() {
			private JLabel txtNomeAluno;
			private JLabel txtDataDeNascimento;

			public void actionPerformed(ActionEvent e) {

				objeto = new Aluno(null, txtNomeAluno.getText(), txtSexo.getText(), txtDataDeNascimento.getText());

				controle.inserir(objeto);

				JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");

				txtAluno.setText(String.valueOf(objeto.getCodAluno()));

			}
		});
		btnInserir.setFont(new Font("Rockwell", Font.PLAIN, 12));

		JButton btnAlterar = new JButton("alterar");
		btnAlterar.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnAlterar.addActionListener(new ActionListener() {
			private JLabel txtNomeAluno;
			private JLabel txtDataDescimento;

			public void actionPerformed(ActionEvent e) {

				if (objeto != null) {
					objeto.setNomeAluno(txtNomeAluno.getText());
					objeto.setSexo(txtSexo.getText());
					objeto.setDataDeNascimento(txtDataDescimento.getText());
					controle.alterar(objeto);
					JOptionPane.showMessageDialog(null, "Veterinário alterado com sucesso.");
				} else {
					JOptionPane.showMessageDialog(null, "Não há objeto a ser modificado.");
				}

			}
		});

		JButton btnExcluir = new JButton("excluir");
		btnExcluir.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnExcluir.addActionListener(new ActionListener() {
			private JLabel txtNomeAluno;

			public void actionPerformed(ActionEvent e) {

				if (objeto != null) {
					controle.excluir(objeto);
					objeto = null;
					txtNomeAluno.setText("");
					txtCodAluno.setText("");
					txtSexo.setText("");
					JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso.");
				} else {
					JOptionPane.showMessageDialog(null, "Não há objeto a ser excluído.");
				}

			}
		});

		JButton btnConsultar = new JButton("consultar");
		btnConsultar.addActionListener(new ActionListener() {
			private JLabel txtDataDeNascimento;
			private JLabel txtCodAluno;

			public void actionPerformed(ActionEvent e) {

				Integer valor = Integer.parseInt(txtCodAluno.getText());

				objeto = controle.buscarPorId(valor);

				if (objeto != null) {
					txtAluno.setText(String.valueOf(objeto.getCodAluno()));
					txtAluno.setText(objeto.getNomeAluno());
					txtSexo.setText(objeto.getSexo());
					txtDataDeNascimento.setText(objeto.getDataDeNascimento());
				} else {
					JOptionPane.showMessageDialog(null, "Não há Aluno com esse código");
					txtCodAluno.setText("");
				}

			}
		});
		btnConsultar.setFont(new Font("Rockwell", Font.PLAIN, 11));

		JButton btnFechar = new JButton("fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnFechar.setFont(new Font("Rockwell", Font.PLAIN, 11));
		GroupLayout gl_painelCampos = new GroupLayout(painelCampos);
		gl_painelCampos.setHorizontalGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCampos.createSequentialGroup().addContainerGap()
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING).addComponent(lblNome)
								.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSigla).addComponent(lblCargaHoraria))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtAluno, 0, 0, Short.MAX_VALUE).addComponent(txt))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING).addComponent(btnFechar)
								.addComponent(btnInserir).addComponent(btnAlterar).addComponent(btnExcluir)
								.addComponent(btnConsultar))
						.addContainerGap(63, Short.MAX_VALUE)));
		gl_painelCampos.setVerticalGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCampos.createSequentialGroup().addGap(29)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAluno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCod).addComponent(btnInserir))
						.addGap(18)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE).addComponent(lblNome)
								.addComponent(txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAlterar))
						.addGap(18)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.TRAILING).addComponent(lblSigla)
								.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnExcluir)))
						.addGap(18)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE).addComponent(lblCargaHoraria)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConsultar))
						.addGap(18).addComponent(btnFechar).addContainerGap(35, Short.MAX_VALUE)));
		painelCampos.setLayout(gl_painelCampos);

	}
}
