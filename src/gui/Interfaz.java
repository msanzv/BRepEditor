package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import brep.Vertice;
import brepModels.Arbol;

import net.miginfocom.swing.MigLayout;


public class Interfaz extends JFrame implements ChangeListener {

	private static final long serialVersionUID = -6699778043115911766L;
	
    private static final String FORMAT = "0";
    
	private JPanel contentPane;
	private JLabel txtFigura;
	
	private JLabel lblNewLabel, lblNewLabel2;
	private MyJSlider sliderH1, sliderH2;
	
	private static Arbol arbol;
	
	
	/**
	 * Custom JSlider class
	 */
	private class MyJSlider extends JSlider {
		
		private static final long serialVersionUID = 3858526482302182373L;

		public MyJSlider(int min, int max, int step, int val){
			super(min, max, val);
			this.setMinorTickSpacing(step);
			this.setMajorTickSpacing(max-min);
			this.setPaintLabels(true);
			this.setPaintTicks(true);
			this.setSnapToTicks(true);
		}
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		crearArbol();
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 22);
		contentPane.add(menuBar);
		
		JMenuItem mntmArchivo = new JMenuItem("Archivo");
		menuBar.add(mntmArchivo);
		
		JMenuItem mntmEdicin = new JMenuItem("Edici\u00F3n");
		menuBar.add(mntmEdicin);
		
		JMenuItem mntmOpciones = new JMenuItem("Opciones");
		menuBar.add(mntmOpciones);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		menuBar.add(mntmAyuda);
		
		txtFigura = new JLabel();
		txtFigura.setText("Figura: ");
		txtFigura.setBounds(10, 34, 67, 28);
		contentPane.add(txtFigura);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(60, 36, 93, 27);
	    comboBox.addItem("Arbol");
	    comboBox.addItem("Espada");
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 73, 588, 299);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelImagen = new JPanel();
		panel.add(panelImagen, BorderLayout.WEST);
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File(arbol.IMGROUTE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		panelImagen.add(picLabel);
		
		JPanel panelControles = new JPanel();
		JScrollPane scroller = new JScrollPane(panelControles);
		panel.add(scroller, BorderLayout.CENTER);
		panelControles.setLayout(new MigLayout("", "[][]", "[][][][][][][]"));
		
		
		lblNewLabel = new JLabel(arbol.HTAG + arbol.getH1());
		panelControles.add(lblNewLabel, "cell 0 0");

		sliderH1 = new MyJSlider(arbol.H1MIN, arbol.H1MAX, arbol.H1STEP, arbol.getH1());
		sliderH1.addChangeListener(this);
		panelControles.add(sliderH1, "cell 1 0");
		
		
		lblNewLabel2 = new JLabel(arbol.RTAG + arbol.getR1());
		panelControles.add(lblNewLabel2, "cell 0 1");
		
		sliderH2 = new MyJSlider(1, 10, 5, 1);
		sliderH2.setMinorTickSpacing(1);
		sliderH2.setMajorTickSpacing(9);
		sliderH2.setPaintLabels(true);
		sliderH2.setPaintTicks(true);
		sliderH2.setSnapToTicks(true);
        sliderH2.addChangeListener(this);
		panelControles.add(sliderH2, "cell 1 1");
		
		
		JLabel lblAltura = new JLabel("Altura");
		panelControles.add(lblAltura, "cell 0 3");
		
		JSlider slider_2 = new JSlider(1, 10, 5);
		slider_2.setMajorTickSpacing(9);
		slider_2.setMinorTickSpacing(1);
		slider_2.setPaintLabels(true);
		slider_2.setPaintTicks(true);
		slider_2.setSnapToTicks(true);
        slider_2.addChangeListener(this);
		panelControles.add(slider_2, "cell 1 3");
		
		
		JLabel lblNewLabel_2 = new JLabel("Radio");
		panelControles.add(lblNewLabel_2, "cell 0 4");
		
		JSlider slider_3 = new JSlider(1, 10, 5);
		slider_3.setMinorTickSpacing(1);
		slider_3.setMajorTickSpacing(9);
		slider_3.setPaintLabels(true);
		slider_3.setPaintTicks(true);
		slider_3.setSnapToTicks(true);
		slider_3.addChangeListener(this);
		panelControles.add(slider_3, "cell 1 4");
		
		
		JLabel lblNewLabel_3 = new JLabel("Altura");
		panelControles.add(lblNewLabel_3, "cell 0 6");
		
		JSlider slider_4 = new JSlider(1, 10, 5);
		slider_4.setMinorTickSpacing(1);
		slider_4.setMajorTickSpacing(9);
		slider_4.setPaintLabels(true);
		slider_4.setPaintTicks(true);
		slider_4.setSnapToTicks(true);
		slider_4.addChangeListener(this);
		panelControles.add(slider_4, "cell 1 6");
		
		
		JLabel labelColor = new JLabel("- Color -");
		panelControles.add(labelColor, "cell 1 7");
		
		JLabel labelR = new JLabel("R:");
		panelControles.add(labelR, "cell 0 8");
		
		JSlider sliderR = new JSlider(0, 255, 0);
		sliderR.setMinorTickSpacing(128);
		sliderR.setMajorTickSpacing(255);
		sliderR.setPaintLabels(true);
		sliderR.setPaintTicks(true);
		panelControles.add(sliderR, "cell 1 8");
		
		JSpinner spinnerR = new JSpinner();
		SpinnerModel model = new SpinnerNumberModel(0, 0, 255, 1);
		spinnerR.setModel(model);
		spinnerR.setEditor(new JSpinner.NumberEditor(spinnerR, FORMAT));
		panelControles.add(spinnerR, "cell 1 8");
		
		/*JLabel lblR = new JLabel("R:");
		panel_2.add(lblR, "flowx,cell 1 5");
		
		JSpinner spinner = new JSpinner();
		SpinnerModel model = new SpinnerNumberModel(0, 0, 255, 1);
		spinner.setModel(model);
		spinner.setEditor(new JSpinner.NumberEditor(spinner, FORMAT));
		panel_2.add(spinner, "cell 1 5");
		
		JLabel lblG = new JLabel("G:");
		panel_2.add(lblG, "cell 1 5");
		
		JSpinner spinner_1 = new JSpinner();
		SpinnerModel model2 = new SpinnerNumberModel(255, 0, 255, 1);
		spinner_1.setModel(model2);
		spinner_1.setEditor(new JSpinner.NumberEditor(spinner_1, FORMAT));
		panel_2.add(spinner_1, "cell 1 5");
		
		JLabel lblB = new JLabel("B:");
		panel_2.add(lblB, "cell 1 5");
		
		JSpinner spinner_2 = new JSpinner();
		SpinnerModel model3 = new SpinnerNumberModel(0, 0, 255, 1);
		spinner_2.setModel(model3);
		spinner_2.setEditor(new JSpinner.NumberEditor(spinner_2, FORMAT));
		panel_2.add(spinner_2, "cell 1 5");
		
		public class SliderChangeListener implements ChangeListener {
			public void stateChanged(ChangeEvent changeEvent) { 
				Object source = changeEvent.getSource();
				JSlider theJSlider = (JSlider)source;
				if (!theJSlider.getValueIsAdjusting()) { 
					System.out.println ("Slider changed: " + theJSlider.getValue());
				} 
			} 
		} */
		
	}

	@Override
	public void stateChanged(ChangeEvent changeEvent) {
	    Object source = changeEvent.getSource();
	    if (source instanceof JSlider) {
	    	JSlider jslider = (JSlider) source;
	    	if(jslider == sliderH1){
	    		lblNewLabel.setText(arbol.HTAG + jslider.getValue());
	    		if(sliderH1.getValue() < sliderH2.getValue())
	    			sliderH2.setValue(sliderH1.getValue());
	    		//sliderH2.setMajorTickSpacing(sliderH1.getValue() - sliderH2.getMinimum());
	    	}
	    	else if(jslider == sliderH2){
	    		lblNewLabel2.setText(arbol.RTAG + jslider.getValue());
	    	}
	    	
	    	System.out.println("Slider changed: " + jslider.getValue());
	    		
//	    } else if (source instanceof JProgressBar) {
//	    	JProgressBar theJProgressBar = (JProgressBar) source;
//	    	System.out.println("ProgressBar changed: "
//	    			+ theJProgressBar.getValue());
	    		
	    } else {
	    	System.out.println("Something changed: " + source);
	    }
	}
	
	public static void crearArbol(){
		
		arbol = new Arbol("Arbol1");
		
		arbol.setAllHR(2, 2, 2, 2,   // Alturas
					   2, 3, 4, 1);  // Radios
		
		arbol.getVertices().add(new Vertice("v0"  ,  0, 8,  0));
		
		arbol.getVertices().add(new Vertice("v1e0",  2, 6,  2));
		arbol.getVertices().add(new Vertice("v1e1",  2, 6, -2));
		arbol.getVertices().add(new Vertice("v1e2", -2, 6, -2));
		arbol.getVertices().add(new Vertice("v1e3", -2, 6,  2));
		arbol.getVertices().add(new Vertice("v1i0",  1, 6,  1));
		arbol.getVertices().add(new Vertice("v1i1",  1, 6, -1));
		arbol.getVertices().add(new Vertice("v1i2", -1, 6, -1));
		arbol.getVertices().add(new Vertice("v1i3", -1, 6,  1));

		arbol.getVertices().add(new Vertice("v2e0",  3, 4,  3));
		arbol.getVertices().add(new Vertice("v2e1",  3, 4, -3));
		arbol.getVertices().add(new Vertice("v2e2", -3, 4, -3));
		arbol.getVertices().add(new Vertice("v2e3", -3, 4,  3));
		arbol.getVertices().add(new Vertice("v2i0",  1.5f, 4f,  1.5f));
		arbol.getVertices().add(new Vertice("v2i1",  1.5f, 4f, -1.5f));
		arbol.getVertices().add(new Vertice("v2i2", -1.5f, 4f, -1.5f));
		arbol.getVertices().add(new Vertice("v2i3", -1.5f, 4f,  1.5f));

		arbol.getVertices().add(new Vertice("v3e0",  4, 2,  4));
		arbol.getVertices().add(new Vertice("v3e1",  4, 2, -4));
		arbol.getVertices().add(new Vertice("v3e2", -4, 2, -4));
		arbol.getVertices().add(new Vertice("v3e3", -4, 2,  4));
		arbol.getVertices().add(new Vertice("v3i0",  2, 2,  2));
		arbol.getVertices().add(new Vertice("v3i1",  2, 2, -2));
		arbol.getVertices().add(new Vertice("v3i2", -2, 2, -2));
		arbol.getVertices().add(new Vertice("v3i3", -2, 2,  2));

		arbol.getVertices().add(new Vertice("v4b0",  1, 0,  1));
		arbol.getVertices().add(new Vertice("v4b1",  1, 0, -1));
		arbol.getVertices().add(new Vertice("v4b2", -1, 0, -1));
		arbol.getVertices().add(new Vertice("v4b3", -1, 0,  1));
		

		System.out.println(arbol.toString());
	}
}


