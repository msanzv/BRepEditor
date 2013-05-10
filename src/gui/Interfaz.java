package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Action;
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

import brep.Arista;
import brep.Cara;
import brep.Color;
import brep.Restriccion;
import brep.Vertice;
import brepModels.Arbol;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JMenu;


public class Interfaz extends JFrame implements ChangeListener {

	private static final long serialVersionUID = -6699778043115911766L;
	
    private static final String FORMAT = "0";
    
	private JPanel contentPane;
	private JLabel txtFigura;
	
	private JLabel labelH1, labelH2, labelH3, labelH4, labelR1, labelR2, labelR3, labelR4;
	private MyJSlider sliderH1, sliderH2, sliderH3, sliderH4, sliderR1, sliderR2, sliderR3, sliderR4;
	
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
		
		//crearArbol();
		try {
			cargar();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
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
		
		// Panel de contenido
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 22);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent arg0) {
	             guardar();
	        }
	    });
		mnArchivo.add(mntmGuardar);
	    
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent arg0) {
	             System.exit(0);
	        }
	    });
		mnArchivo.add(mntmSalir);
		
		JMenu mnEdicion = new JMenu("Edicion");
		menuBar.add(mnEdicion);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenu mnAyuda = new JMenu("Acerca de");
		menuBar.add(mnAyuda);
		
		
		// Selector de figuras
		txtFigura = new JLabel();
		txtFigura.setText("Figura: ");
		txtFigura.setBounds(10, 34, 67, 28);
		contentPane.add(txtFigura);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(60, 36, 93, 27);
	    comboBox.addItem("Arbol");
	    comboBox.addItem("Espada");
		contentPane.add(comboBox);
		
		// Panel principal
		JPanel panel = new JPanel();
		panel.setBounds(6, 73, 588, 299);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// Subpanel de imagen
		JPanel panelImagen = new JPanel();
		panel.add(panelImagen, BorderLayout.WEST);
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File(arbol.IMG_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		panelImagen.add(picLabel);
		
		// Subpanel de controles
		JPanel panelControles = new JPanel();
		JScrollPane scroller = new JScrollPane(panelControles);
		panel.add(scroller, BorderLayout.CENTER);
		panelControles.setLayout(new MigLayout("", "[][]", "[][][][][][][]"));
		
		
		// CONTROLES
		
		// Bucle Restricciones
		//for(int i=0; i<arbol.getRestricciones().size(); i++){
			//Restriccion rest2 = arbol.getRestricciones().get(i);
		//}
		
		// Restriccion 1
		Restriccion rest = arbol.getRestById("h1");
		
		labelH1 = new JLabel(rest.getTag() + (rest.getValue()<10 ? "  " : "") + rest.getValue());
		panelControles.add(labelH1);

		sliderH1 = new MyJSlider(rest.getMin(), rest.getMax(), rest.getStep(), rest.getValue());
		sliderH1.addChangeListener(this);
		panelControles.add(sliderH1, "wrap");
		
		// Restriccion 2
		Restriccion rest2 = arbol.getRestById("h2");
		
		labelH2 = new JLabel(rest2.getTag() + (rest2.getValue()<10 ? "  " : "") + rest2.getValue());
		panelControles.add(labelH2);
		
		sliderH2 = new MyJSlider(rest2.getMin(), rest2.getMax(), rest2.getStep(), rest2.getValue());
        sliderH2.addChangeListener(this);
		panelControles.add(sliderH2, "wrap");
		
		// Restriccion 3
		Restriccion rest3 = arbol.getRestById("h3");
		
		labelH3 = new JLabel(rest3.getTag() + (rest3.getValue()<10 ? "  " : "") + rest3.getValue());
		panelControles.add(labelH3);
		
		sliderH3 = new MyJSlider(rest3.getMin(), rest3.getMax(), rest3.getStep(), rest3.getValue());
        sliderH3.addChangeListener(this);
		panelControles.add(sliderH3, "wrap");
		
		// Restriccion 4
		Restriccion rest4 = arbol.getRestById("h4");
		
		labelH4 = new JLabel(rest4.getTag() + (rest4.getValue()<10 ? "  " : "") + rest4.getValue());
		panelControles.add(labelH4);
		
		sliderH4 = new MyJSlider(rest4.getMin(), rest4.getMax(), rest4.getStep(), rest4.getValue());
        sliderH4.addChangeListener(this);
		panelControles.add(sliderH4, "wrap");
		
		// Restriccion 5
		Restriccion rest5 = arbol.getRestById("r1");
		
		labelR1 = new JLabel(rest5.getTag() + (rest5.getValue()<10 ? "  " : "") + rest5.getValue());
		panelControles.add(labelR1);
		
		sliderR1  = new MyJSlider(rest5.getMin(), rest5.getMax(), rest5.getStep(), rest5.getValue());
        sliderR1.addChangeListener(this);
		panelControles.add(sliderR1, "wrap");
		
		// Restriccion 6
		Restriccion rest6 = arbol.getRestById("r2");
		
		labelR2 = new JLabel(rest6.getTag() + (rest6.getValue()<10 ? "  " : "") + rest6.getValue());
		panelControles.add(labelR2);
		
		sliderR2 = new MyJSlider(rest6.getMin(), rest6.getMax(), rest6.getStep(), rest6.getValue());
        sliderR2.addChangeListener(this);
		panelControles.add(sliderR2, "wrap");
		
		// Restriccion 7
		Restriccion rest7 = arbol.getRestById("r3");
		
		labelR3 = new JLabel(rest7.getTag() + (rest7.getValue()<10 ? "  " : "") + rest7.getValue());
		panelControles.add(labelR3);
		
		sliderR3 = new MyJSlider(rest7.getMin(), rest7.getMax(), rest7.getStep(), rest7.getValue());
        sliderR3.addChangeListener(this);
		panelControles.add(sliderR3, "wrap");	
		
		// Restriccion 8
		Restriccion rest8 = arbol.getRestById("r4");
		
		labelR4 = new JLabel(rest8.getTag() + (rest8.getValue()<10 ? "  " : "") + rest8.getValue());
		panelControles.add(labelR4);
		
		sliderR4 = new MyJSlider(rest8.getMin(), rest8.getMax(), rest8.getStep(), rest8.getValue());
        sliderR4.addChangeListener(this);
		panelControles.add(sliderR4, "wrap");
		
		
		JLabel labelColor = new JLabel("- Color -");
		//panelControles.add(new JLabel(""));
		panelControles.add(labelColor, "span");
		
		JLabel labelR = new JLabel("R:");
		panelControles.add(labelR);
		
		JSlider sliderR = new JSlider(0, 255, 0);
		sliderR.setMinorTickSpacing(128);
		sliderR.setMajorTickSpacing(255);
		sliderR.setPaintLabels(true);
		sliderR.setPaintTicks(true);
		panelControles.add(sliderR);
		
		JSpinner spinnerR = new JSpinner();
		SpinnerModel model = new SpinnerNumberModel(0, 0, 255, 1);
		spinnerR.setModel(model);
		spinnerR.setEditor(new JSpinner.NumberEditor(spinnerR, FORMAT));
		panelControles.add(spinnerR, "wrap");
		
		
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
		 */
		
	}
  

	
	@Override
	public void stateChanged(ChangeEvent changeEvent) {
	    Object source = changeEvent.getSource();
	    if (source instanceof JSlider) {
	    	JSlider jslider = (JSlider) source;
	    	if(jslider == sliderH1){
	    		labelH1.setText(arbol.HTAG + (jslider.getValue()<10 ? "  " : "") + jslider.getValue());
	    		if(sliderH1.getValue() <= sliderH2.getValue())
	    			sliderH2.setValue(sliderH1.getValue() - 1);
	    	}
	    	else if(jslider == sliderH2){
	    		labelH2.setText(arbol.HTAG + (jslider.getValue()<10 ? "  " : "") + jslider.getValue());
	    		if(sliderH2.getValue() >= sliderH1.getValue())
	    			sliderH2.setValue(sliderH1.getValue() - 1);
	    	}
	    	else if(jslider == sliderH3){
	    		labelH3.setText(arbol.HTAG + (jslider.getValue()<10 ? "  " : "") + jslider.getValue());
	    		if(sliderH3.getValue() >= sliderH2.getValue()||sliderH3.getValue() >= sliderH1.getValue())
	    			sliderH3.setValue(sliderH2.getValue() - 1);
	    	}
	    	else if(jslider == sliderH4){
	    		labelH4.setText(arbol.HTAG + (jslider.getValue()<10 ? "  " : "") + jslider.getValue());
	    		if(sliderH4.getValue() >= sliderH3.getValue())
	    			sliderH4.setValue(sliderH3.getValue() - 1);
	    	}
	    	else if(jslider == sliderR1){
	    		labelR1.setText(arbol.RTAG + (jslider.getValue()<10 ? "  " : "") + jslider.getValue());

	    	}
	    	else if(jslider == sliderR2){
	    		labelR2.setText(arbol.RTAG + (jslider.getValue()<10 ? "  " : "") + jslider.getValue());

	    	}
	    	else if(jslider == sliderR3){
	    		labelR3.setText(arbol.RTAG + (jslider.getValue()<10 ? "  " : "") + jslider.getValue());

	    	}
	    	else if(jslider == sliderR4){
	    		labelR4.setText(arbol.RTAG + (jslider.getValue()<10 ? "  " : "") + jslider.getValue());

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
	
	
	public void guardar(){
		
		//Le pasamos el valor del spinner a los radios/alturas
		arbol.calcularVertices(sliderH1.getValue(), sliderH2.getValue(),
							   sliderH3.getValue(), sliderH4.getValue(),
							   sliderR1.getValue(), sliderR2.getValue(),
							   sliderR3.getValue(), sliderR4.getValue());

		//Escribimos en fichero de salida
		String ss = arbol.toString();
		try{
			FileWriter fichero = new FileWriter("gen/arbol.txt");
			fichero.write(ss);
			fichero.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void cargar() throws IOException {
		
		arbol = new Arbol();
		arbol.initRestricciones();
		
		BufferedReader br = new BufferedReader(new FileReader(arbol.TXT_PATH));
	    try {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	        	
	        	String s[] = line.split(" ");
	        	if(s.length > 1){
		        	ArrayList<String> ss = new ArrayList<String>();
		        	for(int i=0; i<s.length; i++) 
		        		if(s[i].length() > 0) 
		        			ss.add(s[i]);
		        	//System.out.println(ss.toString());
		        	
		        	if(ss.get(0).equalsIgnoreCase("v")){
		        		Vertice vertice = new Vertice(ss.get(1), 
		        									  Float.parseFloat(ss.get(2)),
		        									  Float.parseFloat(ss.get(3)), 
		        									  Float.parseFloat(ss.get(4)));
		        		arbol.getVertices().add(vertice);
		        	}
		        	else if(ss.get(0).equalsIgnoreCase("a")){
		        		Arista arista = new Arista(ss.get(1), 
		        								   ss.get(2), ss.get(3),
		        								   ss.get(4), ss.get(5));
		        		String aristasIzq[] = {ss.get(6), ss.get(7)};
		        		String aristasDer[] = {ss.get(8), ss.get(9)};
		        		arista.setAristasIzq(aristasIzq);
		        		arista.setAristasDer(aristasDer);
		        		arbol.getAristas().add(arista);
		        	}
		        	else if(ss.get(0).equalsIgnoreCase("c")){
		        		Cara cara = new Cara(ss.get(1));
		        		for(int i=2; i<ss.size(); i++){
		        			cara.getAristas().add(ss.get(i));
		        		}
		        		arbol.getCaras().add(cara);
		        	}
		        	else if(ss.get(0).equalsIgnoreCase("color")){
		        		Color color = new Color(ss.get(1),
		        								Float.parseFloat(ss.get(2)),
		        								Float.parseFloat(ss.get(3)),
		        								Float.parseFloat(ss.get(4)));
		        		for(int i=5; i<ss.size(); i++){
		        			color.getCaras().add(ss.get(i));
		        		}
		        		arbol.getColores().add(color);
		        	}
		        	else if(ss.get(0).equalsIgnoreCase("objeto")){
		        		arbol.setNombre(ss.get(1));
		        	}
	        	}
	        }
		} finally {
	        br.close();
	    }
	    
	    //System.out.println(arbol.toString());
	}
}


