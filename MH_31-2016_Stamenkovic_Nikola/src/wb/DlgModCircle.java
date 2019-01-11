package wb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class DlgModCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCenterX;
	private JTextField txtCenterY;
	private JTextField txtRadius;
	private int centerX;
	private int centerY;
	private int circRadius;
	private boolean allowedToMod=false;
	private Color frameColor;
	private JLabel lblCenterX;
	private JLabel lblCenterY;
	private JLabel lblRadius;
	private JLabel lblColor;
	private JButton btnColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModCircle dialog = new DlgModCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModCircle() {
		setTitle("Modify Circle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblCenterX = new JLabel("Center X:");
		}
		{
			txtCenterX = new JTextField();
			txtCenterX.setColumns(10);
		}
		{
			lblCenterY = new JLabel("Center Y:");
		}
		{
			txtCenterY = new JTextField();
			txtCenterY.setColumns(10);
		}
		{
			lblRadius = new JLabel("Radius:");
		}
		{
			txtRadius = new JTextField();
			txtRadius.setColumns(10);
		}
		{
			lblColor = new JLabel("Color:");
		}
		{
			btnColor = new JButton("");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frameColor=JColorChooser.showDialog(null, "Frame color", frameColor);
					if(frameColor != null) {
						btnColor.setBackground(frameColor);
					}
				}
			});
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblCenterX)
							.addGap(5)
							.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblCenterY)
							.addGap(5)
							.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblRadius)
							.addGap(5)
							.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(20)
							.addComponent(lblColor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(234, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCenterX))
						.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCenterY))
						.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRadius))
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(68, Short.MAX_VALUE))
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
							centerX = Integer.parseInt(txtCenterX.getText());
							centerY = Integer.parseInt(txtCenterY.getText());
							circRadius = Integer.parseInt(txtRadius.getText());							
							if(centerX < 0 || centerY < 0 || circRadius < 0) {
								throw new Exception();
							}
							allowedToMod = true;
							setVisible(false);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Negative values are not allowed", "Input error!", JOptionPane.WARNING_MESSAGE);
							txtCenterX.setText("");
							txtCenterY.setText("");
							txtRadius.setText("");
							txtCenterX.requestFocus();
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

	public JTextField getTxtCenterX() {
		return txtCenterX;
	}

	public void setTxtCenterX(JTextField txtCenterX) {
		this.txtCenterX = txtCenterX;
	}

	public JTextField getTxtCenterY() {
		return txtCenterY;
	}

	public void setTxtCenterY(JTextField txtCenterY) {
		this.txtCenterY = txtCenterY;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public int getCircRadius() {
		return circRadius;
	}

	public void setCircRadius(int circRadius) {
		this.circRadius = circRadius;
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
