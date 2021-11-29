package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import control.AlunoControle;
import control.TurmaControle;
import model.Aluno;
import model.Turma;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCRUDTurma extends JInternalFrame {
	private Turma objeto;
	private TurmaControle controle = new TurmaControle();
	private JTextField Codigo;
	private JTextField SiglaTurma;
	private JTextField Ano;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCRUDTurma frame = new TelaCRUDTurma();
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
	public TelaCRUDTurma() {
		setBounds(100, 100, 450, 300);

		JLabel lblTitulo = new JLabel(" Turma");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitulo, BorderLayout.NORTH);

		JPanel painelCampos = new JPanel();
		getContentPane().add(painelCampos, BorderLayout.CENTER);

		JLabel Iblcodigo = new JLabel("codigo:");
		Iblcodigo.setFont(new Font("Rockwell", Font.PLAIN, 14));

		Codigo = new JTextField();
		Codigo.setFont(new Font("Rockwell", Font.PLAIN, 14));
		Codigo.setColumns(10);

		JLabel Iblsigla = new JLabel("sigla:");
		Iblsigla.setFont(new Font("Rockwell", Font.PLAIN, 14));

		SiglaTurma = new JTextField();
		SiglaTurma.setColumns(10);

		JLabel IblAno = new JLabel("Ano :");
		IblAno.setFont(new Font("Rockwell", Font.PLAIN, 14));

		Ano = new JTextField();
		Ano.setColumns(10);

		JButton btnInserir = new JButton("inserir");
		btnInserir.addActionListener(new ActionListener() {
			private JLabel txtSiglaTurma;
			private JLabel txtAno;

			public void actionPerformed(ActionEvent e) {

				objeto = new Turma(null, txtSiglaTurma.getText(), txtAno.getText());

				controle.inserirTurma(objeto);

				JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");

				Codigo.setText(String.valueOf(objeto.getCodTurma()));
			}
		});
		btnInserir.setFont(new Font("Rockwell", Font.PLAIN, 12));

		JButton btnAlterar = new JButton("alterar");
		btnAlterar.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnAlterar.addActionListener(new ActionListener() {
			private JLabel txtSigla;
			private JLabel txtAno;
			private JLabel txtSiglaTurma;

			public void actionPerformed(ActionEvent e) {

				if (objeto != null) {
					objeto.setSiglaTurma(txtSiglaTurma.getText());
					objeto.setAno(txtAno.getText());
					controle.alterar(objeto);
					JOptionPane.showMessageDialog(null, "Turma alterada com sucesso.");
				} else {
					JOptionPane.showMessageDialog(null, "Não há objeto a ser modificado.");
				}
			}
		});

		JButton btnExcluir = new JButton("excluir");
		btnExcluir.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnExcluir.addActionListener(new ActionListener() {
			private JLabel txtSiglaTurma1;
			private JLabel txtCodTurma;
			private JLabel txtAno;
			private JLabel txtSiglaTurma;

			public void actionPerformed(ActionEvent e) {

				if (objeto != null) {
					controle.excluirTurma(objeto);
					objeto = null;
					txtCodTurma.setText("");
					txtSiglaTurma1.setText("");
					txtAno.setText("");
					JOptionPane.showMessageDialog(null, "Turma excluído com sucesso.");
				} else {
					JOptionPane.showMessageDialog(null, "Não há Turma a ser excluído.");
				}
			}
		});

		JButton btnConsultar = new JButton("consultar");
		btnConsultar.addActionListener(new ActionListener() {

			private JLabel txtCodTurma;
			private JLabel txtSiglaTurma;
			private JLabel txtAno;

			public void actionPerformed(ActionEvent e) {

				objeto = controle.buscarPorId();

				if (objeto != null) {
					Codigo.setText(String.valueOf(objeto.getCodTurma()));
					txtSiglaTurma.setText(objeto.getSiglaTurma());
					txtAno.setText(objeto.getAno());

				} else {
					JOptionPane.showMessageDialog(null, "Não há Turma com esse código");
					txtCodTurma.setText("");
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
		gl_painelCampos.setHorizontalGroup(
			gl_painelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCampos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
						.addComponent(Iblsigla)
						.addComponent(IblAno)
						.addComponent(Iblcodigo, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING, false)
							.addComponent(Codigo, 0, 0, Short.MAX_VALUE)
							.addComponent(SiglaTurma))
						.addComponent(Ano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(95)
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFechar)
						.addComponent(btnInserir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnConsultar))
					.addGap(68))
		);
		gl_painelCampos.setVerticalGroup(
			gl_painelCampos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCampos.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
						.addComponent(Codigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Iblcodigo)
						.addComponent(btnInserir))
					.addGap(18)
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
						.addComponent(Iblsigla)
						.addComponent(SiglaTurma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar))
					.addGap(18)
					.addGroup(gl_painelCampos.createParallelGroup(Alignment.TRAILING)
						.addComponent(IblAno)
						.addGroup(gl_painelCampos.createParallelGroup(Alignment.BASELINE)
							.addComponent(Ano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnExcluir)))
					.addGap(18)
					.addComponent(btnConsultar)
					.addGap(18)
					.addComponent(btnFechar)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		painelCampos.setLayout(gl_painelCampos);

	}
}
