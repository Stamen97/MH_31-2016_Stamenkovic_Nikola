package wb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.PnlDrawing;
import geometry.Point;
import geometry.Rectangle;

import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btngrpShapes = new ButtonGroup();
	private final ButtonGroup btngrpActions = new ButtonGroup();
	private static Color shapeColor = Color.BLACK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
					frame.setSize(800, 600);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		setTitle("Stamenkovic Nikola MH31/2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		PnlDrawing pnlWorkspace = new PnlDrawing();
		contentPane.add(pnlWorkspace, BorderLayout.CENTER);
		
		JPanel pnlShapeChoice = new JPanel();
		pnlShapeChoice.setForeground(new Color(0, 0, 0));
		pnlShapeChoice.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPane.add(pnlShapeChoice, BorderLayout.NORTH);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setMinimumSize(new Dimension(115, 45));
		//izabrana je tacka
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionShape.setChosenShape(OptionShape.getDrawPoint());
			}
		});
		btngrpShapes.add(tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setMinimumSize(new Dimension(115, 45));
		//izabrana linija
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionShape.setChosenShape(OptionShape.getDrawLine());
			}
		});
		btngrpShapes.add(tglbtnLine);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setMinimumSize(new Dimension(115, 45));
		//izabran pravougaonik
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionShape.setChosenShape(OptionShape.getDrawRect());
			}
		});
		btngrpShapes.add(tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setMinimumSize(new Dimension(115, 45));
		//izabran krug
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionShape.setChosenShape(OptionShape.getDrawCircle());
			}
		});
		btngrpShapes.add(tglbtnCircle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.setMinimumSize(new Dimension(115, 45));
		//izabran krug s rupom
		tglbtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionShape.setChosenShape(OptionShape.getDrawDonut());
			}
		});
		btngrpShapes.add(tglbtnDonut);
		GroupLayout gl_pnlShapeChoice = new GroupLayout(pnlShapeChoice);
		gl_pnlShapeChoice.setHorizontalGroup(
			gl_pnlShapeChoice.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlShapeChoice.createSequentialGroup()
					.addContainerGap()
					.addComponent(tglbtnPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tglbtnLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(tglbtnRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tglbtnCircle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tglbtnDonut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
		);
		gl_pnlShapeChoice.setVerticalGroup(
			gl_pnlShapeChoice.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlShapeChoice.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlShapeChoice.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnRectangle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnCircle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnDonut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnlShapeChoice.setLayout(gl_pnlShapeChoice);
		
		JPanel pnlActionChoice = new JPanel();
		pnlActionChoice.setBorder(BorderFactory.createMatteBorder(0, HEIGHT, WIDTH, HEIGHT, new Color(0, 0, 0)));
		contentPane.add(pnlActionChoice, BorderLayout.EAST);
		pnlActionChoice.setLayout(new MigLayout("", "[]", "[][][][][][][][]"));
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.setMinimumSize(new Dimension(115, 45));
		tglbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionAction.setChosenAction(OptionAction.getActionDelete());
				if(PnlDrawing.getLastIndex()>=0) {
					DlgDelete deletion = new DlgDelete();
					deletion.setVisible(true);
					if(deletion.isAllowedToDelete()) {
						pnlWorkspace.getShapes().remove(PnlDrawing.getLastIndex());
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Select an object first!", "No selection", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.setMinimumSize(new Dimension(115, 45));
		tglbtnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionAction.setChosenAction(OptionAction.getActionModify()); //ako je izabrana modifikacija
				btngrpShapes.clearSelection();
				if(PnlDrawing.getLastIndex()>-1) {
					if(pnlWorkspace.getShapes().get(PnlDrawing.getLastIndex()) instanceof Point) { //modif. tacke
						Point temp = (Point)pnlWorkspace.getShapes().get(PnlDrawing.getLastIndex());
						DlgModPoint pointMod = new DlgModPoint();
						pointMod.getTxtPosX().setText(""+temp.getX());
						pointMod.getTxtPosY().setText(""+temp.getY());
						pointMod.setVisible(true);
						
						if(pointMod.isAllowedToMod()) {
							temp.moveTo(pointMod.getPosX(), pointMod.getPosY());
							temp.setShpColor(pointMod.getFrameColor());
						}
						else {
							temp = null;
						}
					}
					
					else if(pnlWorkspace.getShapes().get(PnlDrawing.getLastIndex()) instanceof Line) { //modif. linije
						Line temp = (Line)pnlWorkspace.getShapes().get(PnlDrawing.getLastIndex());
						DlgModLine lineMod = new DlgModLine();
						lineMod.getTxtStartX().setText(""+temp.getStartPoint().getX());
						lineMod.getTxtStartY().setText(""+temp.getStartPoint().getY());
						lineMod.getTxtEndX().setText(""+temp.getEndPoint().getX());
						lineMod.getTxtEndY().setText(""+temp.getEndPoint().getY());
						lineMod.setVisible(true);
						
						if(lineMod.isAllowedToMod()) {
							temp.getStartPoint().moveTo(lineMod.getStartX(), lineMod.getStartY());
							temp.getEndPoint().moveTo(lineMod.getEndX(), lineMod.getEndY());
							temp.setShpColor(lineMod.getFrameColor());
						}
						else {
							temp = null;
						}
					}
					
					else if(pnlWorkspace.getShapes().get(PnlDrawing.getLastIndex()) instanceof Rectangle) { //modif. pravougaonika
						Rectangle temp = (Rectangle)pnlWorkspace.getShapes().get(PnlDrawing.getLastIndex());
						DlgModRectangle rectMod = new DlgModRectangle();
						rectMod.getTxtUpperX().setText(""+temp.getUpperLeft().getX());
						rectMod.getTxtUpperY().setText(""+temp.getUpperLeft().getY());
						rectMod.getTxtWidth().setText(""+temp.getWidth());
						rectMod.getTxtHeight().setText(""+temp.getHeight());
						rectMod.setVisible(true);
						
						if(rectMod.isAllowedToMod()) {
							temp.getUpperLeft().moveTo(rectMod.getUpperX(), rectMod.getUpperY());
							temp.setShpColor(rectMod.getFrameColor());
							temp.setWidth(rectMod.getRectWidth());
							temp.setHeight(rectMod.getRectHeight());
						}
						else {
							temp = null;
						}
					}
					
					else if(pnlWorkspace.getShapes().get(PnlDrawing.getLastIndex()) instanceof Donut) { //modif. kruga sa rupom, kad je vec else if, krofna ide pre kruga
						Donut temp = (Donut)pnlWorkspace.getShapes().get(PnlDrawing.getLastIndex());
						DlgModDonut donutMod = new DlgModDonut();
						donutMod.getBtnColor().setBackground(temp.getShpColor());
						donutMod.getTxtCenterX().setText(""+temp.getCenter().getX());
						donutMod.getTxtCenterY().setText(""+temp.getCenter().getY());
						donutMod.getTxtRadius().setText(""+temp.getR());
						donutMod.getTxtInnerR().setText(""+temp.getInnerR());
						donutMod.setVisible(true);
						
						
						if(donutMod.isAllowedToMod()) {
							temp.getCenter().moveTo(donutMod.getCenterX(), donutMod.getCenterY());
							temp.setShpColor(donutMod.getFrameColor());
							temp.setR(donutMod.getCircRadius());
							temp.setInnerR(donutMod.getCircInnerR());
						}
						else {
							temp = null;
						}
					}
					
					else if(pnlWorkspace.getShapes().get(PnlDrawing.getLastIndex()) instanceof Circle) { //modif. kruga
						Circle temp = (Circle)pnlWorkspace.getShapes().get(PnlDrawing.getLastIndex());
						DlgModCircle circMod = new DlgModCircle();
						circMod.getTxtCenterX().setText(""+temp.getCenter().getX());
						circMod.getTxtCenterY().setText(""+temp.getCenter().getY());
						circMod.getTxtRadius().setText(""+temp.getR());
						circMod.setVisible(true);
						
						if(circMod.isAllowedToMod()) {
							temp.getCenter().moveTo(circMod.getCenterX(), circMod.getCenterY());
							temp.setShpColor(circMod.getFrameColor());
							temp.setR(circMod.getCircRadius());
						}
						else {
							temp = null;
						}
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Select an object first!", "No selection", JOptionPane.WARNING_MESSAGE);
				}
				repaint();
			}
		});
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.setMinimumSize(new Dimension(115, 45));
		tglbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionAction.setChosenAction(OptionAction.getActionSelect());
				btngrpShapes.clearSelection();
			}
		});
		
		JLabel lblColor = new JLabel("Choose color");
		pnlActionChoice.add(lblColor, "cell 0 0,alignx center");
		
		JToggleButton tglbtnDraw = new JToggleButton("Draw");
		tglbtnDraw.setMinimumSize(new Dimension(115, 45));
		tglbtnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionAction.setChosenAction(OptionAction.getActionDraw());
			}
		});
		
		JButton btnColor = new JButton("");
		btnColor.setMinimumSize(new Dimension(115, 45));
		btnColor.setBackground(Color.black);
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shapeColor=JColorChooser.showDialog(null, "Shape color", shapeColor);
				if(shapeColor !=null) {
					btnColor.setBackground(shapeColor);
				}
			}
		});
		pnlActionChoice.add(btnColor, "cell 0 1,growx");
		btngrpActions.add(tglbtnDraw);
		pnlActionChoice.add(tglbtnDraw, "cell 0 3");
		btngrpActions.add(tglbtnSelect);
		pnlActionChoice.add(tglbtnSelect, "cell 0 5");
		btngrpActions.add(tglbtnModify);
		pnlActionChoice.add(tglbtnModify, "cell 0 6");
		btngrpActions.add(tglbtnDelete);
		pnlActionChoice.add(tglbtnDelete, "cell 0 7,alignx left,aligny top");
	}

	public static Color getShapeColor() {
		return shapeColor;
	}

	public static void setShapeColor(Color shapeColor) {
		FrmDrawing.shapeColor = shapeColor;
	}

}
