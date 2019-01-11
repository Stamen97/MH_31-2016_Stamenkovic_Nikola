package wb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DlgModRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUpperX;
	private JTextField txtUpperY;
	private JTextField txtHeight;
	private JTextField txtWidth;
	private int upperX;
	private int upperY;
	private int rectWidth;
	private int rectHeight;
	private boolean allowedToMod=false ;
	private Color frameColor;
	private JLabel lblUpperX;
	private JLabel lblUpperY;
	private JLabel Width;
	private JLabel lblHeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModRectangle dialog = new DlgModRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModRectangle() {
		setTitle("Modify Rectangle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			lblUpperX = new JLabel("Upper left X:");
		}
		{
			txtUpperX = new JTextField();
			txtUpperX.setColumns(10);
		}
		{
			lblUpperY = new JLabel("Upper left Y:");
		}
		{
			txtUpperY = new JTextField();
			txtUpperY.setColumns(10);
		}
		{
			Width = new JLabel("Width:");
		}
		{
			txtWidth = new JTextField();
			txtWidth.setColumns(10);
		}
		{
			lblHeight = new JLabel("Height:");
		}
		{
			txtHeight = new JTextField();
			txtHeight.setColumns(10);
		}
		JButton btnColor = new JButton("");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameColor=JColorChooser.showDialog(null, "Frame color", frameColor);
				if(frameColor != null) {
					btnColor.setBackground(frameColor);
				}
			}
		});
		JLabel label = new JLabel("Color:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblUpperX)
							.addGap(5)
							.addComponent(txtUpperX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblUpperY)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtUpperY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(Width)
							.addGap(5)
							.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblHeight)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGap(5)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(216, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblUpperX))
						.addComponent(txtUpperX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUpperY)
						.addComponent(txtUpperY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(Width))
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblHeight))
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						try {
							upperX=Integer.parseInt(txtUpperX.getText());
							upperY=Integer.parseInt(txtUpperY.getText());
							rectWidth=Integer.parseInt(txtWidth.getText());
							rectHeight=Integer.parseInt(txtHeight.getText());
							
							if(upperX < 0 || upperY < 0 || rectWidth < 0 || rectHeight < 0) {
								throw new Exception();
							}
							allowedToMod=true;
							setVisible(false);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Negative values are not allowed", "Input error!", JOptionPane.WARNING_MESSAGE);
							txtUpperX.setText("");
							txtUpperY.setText("");
							txtWidth.setText("");
							txtHeight.setText("");
							txtUpperX.requestFocus();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						allowedToMod=false;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTxtUpperX() {
		return txtUpperX;
	}

	public void setTxtUpperX(JTextField txtUpperX) {
		this.txtUpperX = txtUpperX;
	}

	public JTextField getTxtUpperY() {
		return txtUpperY;
	}

	public void setTxtUpperY(JTextField txtUpperY) {
		this.txtUpperY = txtUpperY;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public int getUpperX() {
		return upperX;
	}

	public void setUpperX(int upperX) {
		this.upperX = upperX;
	}

	public int getUpperY() {
		return upperY;
	}

	public void setUpperY(int upperY) {
		this.upperY = upperY;
	}

	public int getRectWidth() {
		return rectWidth;
	}

	public void setRectWidth(int rectWidth) {
		this.rectWidth = rectWidth;
	}

	public int getRectHeight() {
		return rectHeight;
	}

	public void setRectHeight(int rectHeight) {
		this.rectHeight = rectHeight;
	}

	public boolean isAllowedToMod() {
		return allowedToMod;
	}

	public void setAllowedToMod(boolean allowedToMod) {
		this.allowedToMod = allowedToMod;
	}

	public Color getFrameColor() {
		return frameColor;
	}

	public void setFrameColor(Color frameColor) {
		this.frameColor = frameColor;
	}

}
