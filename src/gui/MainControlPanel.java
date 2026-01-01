
package gui;

/**
 * Clase principal de la interfaz gráfica (JFrame) de Bintary Converter.
 * 
 * Actua como el panel de control de la aplicaicón, controlando todo lo ofrecido:
 * Personalización del tema de la aplicación, cierre e información de la aplicación,
 * tipos de conversión y manejo de limpieza de los componentes de interacción.
 * Los eventos son manipulados mediante ActionListener, ChangeListener.
 * 
 * La clase no requiere parámetro alguno para ser invocada.
 * 
 * @author ESRG
 */

// COMPONENTES DE INTERFAZ GRÁFICA (SWING)
import javax.swing.JFrame;       // Ventana principal del panel de control
import javax.swing.JMenu;        // Menús desplegables (Opciones, Temas, etc.)
import javax.swing.JMenuItem;    // Elementos individuales dentro de los menús
import javax.swing.JMenuBar;     // Barra superior que contiene los menús
import javax.swing.BorderFactory; // Para crear los bordes personalizados (MatteBorder)
import javax.swing.UIManager;     // Para gestionar el "Look and Feel" y colores globales
import javax.swing.JLabel;        // Etiquetas de texto (títulos y nombres de tabla)
import javax.swing.JTextArea;     // Áreas de texto (Terminal y panel de entrada)
import javax.swing.JCheckBox;     // Opción para crear ventana nueva de resultados
import javax.swing.JScrollPane;   // Contenedor con barras de desplazamiento para la terminal
import javax.swing.JButton;       // Botones de navegación y ejecución
import javax.swing.ButtonGroup;   // Agrupador para que solo un RadioButton esté activo
import javax.swing.JRadioButton;  // Botones de selección de modo (Binario/Decimal)
import javax.swing.JTextField;   // Campo de entrada de datos para el usuario
import javax.swing.ImageIcon;    // Para cargar el icono de la aplicación (bintary_icon)

// GESTIÓN DE EVENTOS Y ESCUCHADORES
import javax.swing.event.ChangeListener; // Detectar cambios en los RadioButtons
import javax.swing.event.ChangeEvent;    // Objeto del evento de cambio de estado
import java.awt.event.ActionListener;   // Detectar clics en botones y menús
import java.awt.event.ActionEvent;      // Objeto del evento de acción ejecutada

// DISEÑO, ESTILO Y PERSONALIZACIÓN (AWT & SWING PLAF)
import java.awt.Font;        // Definición de fuentes (Consolas, negritas, tamaños)
import java.awt.Color;       // Manejo de colores RGB para el tema
import java.awt.Cursor;      // Cambiar el puntero a tipo "Mano" (Hand Cursor)
import java.awt.Dimension;   // Definición de dimensiones de componentes
import javax.swing.plaf.basic.BasicScrollBarUI; // Para personalizar la estética de las barras de scroll

// LÓGICA PROPIA DEL PROYECTO (PAQUETES act Y att)
import act.BinaryConverter;    // Motor de conversión matemática
import act.MainControlHandler; // Manejador para limpiar y restablecer la UI
import act.WindowLoader;       // Cargador de ventanas y diálogos secundarios
import att.AppearanceSettings; // Configuración dinámica de colores y temas
import att.SystemInfo;         // Información de versión y sistema

public class MainControlPanel extends JFrame implements ActionListener, ChangeListener{
    
    // Instancia de configuración y personalización del tema.
    AppearanceSettings custom = new AppearanceSettings();

    // Instancia para la información del sistema completo.
    SystemInfo info = new SystemInfo();

    // Instancia para la conversión del sistema binario.
    BinaryConverter converter = new BinaryConverter();
    
    // Instancia para la invocación de nuevas ventanas de interacción.
    WindowLoader window = new WindowLoader();   
    
    // Instancia para la actividad de estado y apariencia del panel de control.
    MainControlHandler event = new MainControlHandler();
    
    /**
     * Constructor de la clase.
     * Configura la ventana principal, aplica el tema visual y 
     * construye los componentes de la interfaz.
     */
    public MainControlPanel(){
        
        setTitle("Bintary Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(custom.BackgroundColor());
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());
                            
        // Configuración del color de selección para los botones, menus y items del menú
        // de selección de interacción, asociado con el tema de personalización.
        UIManager.put("Button.select", custom.SelectionColor());   
        UIManager.put("Menu.selectionForeground", custom.BackgroundColor());
        UIManager.put("Menu.selectionBackground", custom.SelectionColor());
        UIManager.put("MenuItem.selectionForeground", custom.BackgroundColor());
        UIManager.put("MenuItem.selectionBackground", custom.SelectionColor());
        
        //UIManager.put("ScrollBar.track", custom.BackgroundColor());
        UIManager.put("ScrollPane.background", custom.BackgroundColor());

        setLayout(null);
            menuComponents();
            initComponents();
            inputComponents();
    }
    
    /**
     * Inicializa y configura la barra de menús (Opciones, Conversión, Acerca de).
     */
    protected JMenuBar mnuBar;
    protected JMenuItem itmBinary, itmWhole, itmSignedDecimal;
    private void menuComponents(){
        mnuBar = new JMenuBar();
        mnuBar.setBackground(custom.color());
        mnuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, custom.color()));
        mnuBar.setCursor(Cursor.getPredefinedCursor(12));
        setJMenuBar(mnuBar);
        
        // Menú de opciones (Temas, Limpiar, Salir)
        JMenu mnuOption = new JMenu("Opciones");
        mnuOption.setFont(new Font("Consolas", 0, 11));
        mnuOption.setForeground(custom.BackgroundColor());
        mnuBar.add(mnuOption);
        
            // Submenú de temas: Contiene todos lo temas disponibles y de personalización.
            JMenu mnuTheme = new JMenu("Tema                          ");
            mnuTheme.setForeground(custom.color());
            mnuTheme.setBackground(custom.BackgroundColor());
            mnuTheme.setFont(new Font("Consolas", 0, 11));
            mnuTheme.setCursor(Cursor.getPredefinedCursor(12));
            mnuTheme.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, custom.color()));
            //mnuTheme.setEnabled(false);            
            mnuOption.add(mnuTheme);
            
                JMenuItem itmCustom_pintary = new JMenuItem("Pintary                       ");
                itmCustom_pintary.setForeground(custom.color());
                itmCustom_pintary.setBackground(custom.BackgroundColor());
                itmCustom_pintary.setFont(new Font("Consolas", 0, 11));
                itmCustom_pintary.setCursor(Cursor.getPredefinedCursor(12));
                itmCustom_pintary.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, custom.color()));
                //itmCustom_pintary.setEnabled(false);
                itmCustom_pintary.addActionListener((ActionEvent ev) -> {
                    custom.customColor(28, 72, 67);
                    custom.customSelectionColor(13, 38, 36);
                    custom.customBackgroundColor(238, 238, 238);
                    custom.customHighlightColor(0,0,0);
                    event.closeAllWindows();
                    window.guiMainControlPanel();
                });
                mnuTheme.add(itmCustom_pintary);
                
                JMenuItem itmCustom_bintar = new JMenuItem("Bintar");
                itmCustom_bintar.setForeground(custom.color());
                itmCustom_bintar.setBackground(custom.BackgroundColor());
                itmCustom_bintar.setFont(new Font("Consolas", 0, 11));
                itmCustom_bintar.setCursor(Cursor.getPredefinedCursor(12));
                itmCustom_bintar.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, custom.color()));
                //itmCustom_bintar.setEnabled(false);
                itmCustom_bintar.addActionListener((ActionEvent ev) -> {
                    custom.customColor(13, 38, 36);
                    custom.customSelectionColor(28, 72, 67);
                    custom.customBackgroundColor(255, 255, 255);
                    custom.customHighlightColor(13,38,36);
                    event.closeAllWindows();
                    window.guiMainControlPanel();
                });
                mnuTheme.add(itmCustom_bintar);
            
                JMenuItem itmCustom_red = new JMenuItem("Red");
                itmCustom_red.setForeground(custom.color());
                itmCustom_red.setBackground(custom.BackgroundColor());
                itmCustom_red.setFont(new Font("Consolas", 0, 11));
                itmCustom_red.setCursor(Cursor.getPredefinedCursor(12));
                itmCustom_red.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, custom.color()));
                //itmCustom_red.setEnabled(false);
                itmCustom_red.addActionListener((ActionEvent ev) -> {
                    custom.customColor(137, 0, 0);
                    custom.customSelectionColor(53,0,0);
                    custom.customBackgroundColor(238, 238, 238);
                    custom.customHighlightColor(0,0,0);
                    event.closeAllWindows();
                    window.guiMainControlPanel();
                });
                mnuTheme.add(itmCustom_red);

                JMenuItem itmCustom_green = new JMenuItem("Green");
                itmCustom_green.setForeground(custom.color());
                itmCustom_green.setBackground(custom.BackgroundColor());
                itmCustom_green.setFont(new Font("Consolas", 0, 11));
                itmCustom_green.setCursor(Cursor.getPredefinedCursor(12));
                itmCustom_green.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, custom.color()));
                //itmCustom_green.setEnabled(false);
                itmCustom_green.addActionListener((ActionEvent ev) -> {
                    custom.customColor(0, 137, 0);
                    custom.customSelectionColor(0,53,0);
                    custom.customBackgroundColor(238, 238, 238);
                    custom.customHighlightColor(0,0,0);
                    event.closeAllWindows();
                    window.guiMainControlPanel();
                });
                mnuTheme.add(itmCustom_green);

                JMenuItem itmCustom_Blue = new JMenuItem("Blue");
                itmCustom_Blue.setForeground(custom.color());
                itmCustom_Blue.setBackground(custom.BackgroundColor());
                itmCustom_Blue.setFont(new Font("Consolas", 0, 11));
                itmCustom_Blue.setCursor(Cursor.getPredefinedCursor(12));
                itmCustom_Blue.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, custom.color()));
                //itmCustom_Blue.setEnabled(false);
                itmCustom_Blue.addActionListener((ActionEvent ev) -> {
                    custom.customColor(0, 0, 137);
                    custom.customSelectionColor(0,0,53);
                    custom.customBackgroundColor(238, 238, 238);
                    custom.customHighlightColor(0,0,0);
                    event.closeAllWindows();
                    window.guiMainControlPanel();
                });
                mnuTheme.add(itmCustom_Blue);
                
                JMenuItem itmCustom = new JMenuItem("Personalizar");
                itmCustom.setForeground(custom.color());
                itmCustom.setBackground(custom.BackgroundColor());
                itmCustom.setFont(new Font("Consolas", 0, 11));
                itmCustom.setCursor(Cursor.getPredefinedCursor(12));
                itmCustom.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, custom.color()));
                //itmCustom.setEnabled(false);
                itmCustom.addActionListener((ActionEvent ev) -> {
                    dispose();
                    window.guiAppearanceSettingsEditor();
                });
                mnuTheme.add(itmCustom);
            
            // Submenú de limpiar: Contiene las opciones de limpieza: Resultado y componentes de interacción.   
            JMenu mnuClear = new JMenu("Limpiar");
            mnuClear.setForeground(custom.color());
            mnuClear.setBackground(custom.BackgroundColor());
            mnuClear.setFont(new Font("Consolas", 0, 11));
            mnuClear.setCursor(Cursor.getPredefinedCursor(12));
            mnuClear.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, custom.color()));
            //mnuClear.setEnabled(false);            
            mnuOption.add(mnuClear);
            
                JMenuItem itmClearTerminal = new JMenuItem("Resultados");
                itmClearTerminal.setForeground(custom.color());
                itmClearTerminal.setBackground(custom.BackgroundColor());
                itmClearTerminal.setFont(new Font("Consolas", 0, 11));
                itmClearTerminal.setCursor(Cursor.getPredefinedCursor(12));
                itmClearTerminal.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, custom.color()));
                //itmClearTerminal.setEnabled(false); 
                itmClearTerminal.addActionListener((ActionEvent ev) -> {
                    history.setLength(0);                    
                    txtTerminal.setText("\n  Bintary Converter | Versión " + info.versionSystem() + "\n"
                            + "\n\n\n\n\n\n\n\n\n\n\n\n\n"
                            + "      © 2025 Development by: ESRG");
                });
                mnuClear.add(itmClearTerminal);
                
                JMenuItem itmClearComponents = new JMenuItem("Componentes de interacción    ");
                itmClearComponents.setForeground(custom.color());
                itmClearComponents.setBackground(custom.BackgroundColor());
                itmClearComponents.setFont(new Font("Consolas", 0, 11));
                itmClearComponents.setCursor(Cursor.getPredefinedCursor(12));
                itmClearComponents.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, custom.color()));
                //itmClearComponents.setEnabled(false);      
                itmClearComponents.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ev){
                        rdoBinary.setSelected(true);
                        chkCreateWindow.setSelected(false);
                        fldNameTable.setText("");
                        chkCreateWindow.setSelected(false);
                    }
                });
                mnuClear.add(itmClearComponents);
            
            // Opción de salida (Cierre del software en su totalidad) 
            JMenuItem itmExit = new JMenuItem("Salir");
            itmExit.setForeground(custom.color());
            itmExit.setBackground(custom.BackgroundColor());
            itmExit.setFont(new Font("Consolas", 0, 11));
            itmExit.setCursor(Cursor.getPredefinedCursor(12));
            itmExit.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, custom.color()));
            //itmExit.setEnabled(false);  
            itmExit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ev){
                    System.out.println("exit...\n");
                    System.exit(0);
                }
            });
            mnuOption.add(itmExit);
        
        // Menú de conversión (Binario, decimal, decimal negativo) 
        JMenu mnuConverted = new JMenu("Conversión");
        mnuConverted.setFont(new Font("Consolas", 0, 11));
        mnuConverted.setForeground(custom.BackgroundColor());
        mnuBar.add(mnuConverted);
        
            itmBinary = new JMenuItem("Binario                       ");
            itmBinary.setForeground(custom.color());
            itmBinary.setBackground(custom.BackgroundColor());
            itmBinary.setFont(new Font("Consolas", 0, 11));
            itmBinary.setCursor(Cursor.getPredefinedCursor(12));
            itmBinary.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, custom.color()));
            itmBinary.addActionListener(this);
            //itmBinary.setEnabled(false);            
            mnuConverted.add(itmBinary);
            
            itmWhole = new JMenuItem("Entero decimal");
            itmWhole.setForeground(custom.color());
            itmWhole.setBackground(custom.BackgroundColor());
            itmWhole.setFont(new Font("Consolas", 0, 11));
            itmWhole.setCursor(Cursor.getPredefinedCursor(12));
            itmWhole.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, custom.color()));
            itmWhole.addActionListener(this);
            //itmWhole.setEnabled(false);            
            mnuConverted.add(itmWhole);
            
            itmSignedDecimal = new JMenuItem("Decimal negativo");
            itmSignedDecimal.setForeground(custom.color());
            itmSignedDecimal.setBackground(custom.BackgroundColor());
            itmSignedDecimal.setFont(new Font("Consolas", 0, 11));
            itmSignedDecimal.setCursor(Cursor.getPredefinedCursor(12));
            itmSignedDecimal.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, custom.color()));
            itmSignedDecimal.addActionListener(this);
            //itmSignedDecimal.setEnabled(false);            
            mnuConverted.add(itmSignedDecimal);
        
        // Menú Acerca de (Sistema binario, información del software, licencia de uso, acerca del desarrollador)
        JMenu mnuAbout = new JMenu("Acerca de");
        mnuAbout.setFont(new Font("Consolas", 0, 11));
        mnuAbout.setForeground(custom.BackgroundColor());
        mnuBar.add(mnuAbout);
        
            JMenuItem itmBinaryInfo = new JMenuItem("Sistema binario");
            itmBinaryInfo.setForeground(custom.color());
            itmBinaryInfo.setBackground(custom.BackgroundColor());
            itmBinaryInfo.setFont(new Font("Consolas", 0, 11));
            itmBinaryInfo.setCursor(Cursor.getPredefinedCursor(12));
            itmBinaryInfo.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, custom.color()));
            //itmBinaryInfo.setEnabled(false);  
            itmBinaryInfo.addActionListener((ActionEvent ev) -> {
                window.guiBinarySystemInfoWindow();
            });
            mnuAbout.add(itmBinaryInfo);
        
            JMenuItem itmInformation = new JMenuItem("Información                   ");
            itmInformation.setForeground(custom.color());
            itmInformation.setBackground(custom.BackgroundColor());
            itmInformation.setFont(new Font("Consolas", 0, 11));
            itmInformation.setCursor(Cursor.getPredefinedCursor(12));
            itmInformation.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, custom.color()));
            //itmInformation.setEnabled(false);  
            itmInformation.addActionListener((ActionEvent ev) -> {
                window.guiAboutDialog();
            });
            mnuAbout.add(itmInformation);
            
            JMenuItem itmLicense = new JMenuItem("Términos y condiciones");
            itmLicense.setForeground(custom.color());
            itmLicense.setBackground(custom.BackgroundColor());
            itmLicense.setFont(new Font("Consolas", 0, 11));
            itmLicense.setCursor(Cursor.getPredefinedCursor(12));
            itmLicense.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, custom.color()));
            //itmLicense.setEnabled(false);     
            itmLicense.addActionListener((ActionEvent ev) -> {
                window.guiLicenseDialog();
            });
            mnuAbout.add(itmLicense);
            
            JMenuItem itmAbout = new JMenuItem("Acerca de");
            itmAbout.setForeground(custom.color());
            itmAbout.setBackground(custom.BackgroundColor());
            itmAbout.setFont(new Font("Consolas", 0, 11));
            itmAbout.setCursor(Cursor.getPredefinedCursor(12));
            itmAbout.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, custom.color()));
            //itmAbout.setEnabled(false);
            itmAbout.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ev){
                    window.guiMessagePopup("Soporte y ayuda", "Soporte y ayuda: esrg.es@gmail.com");
                }
            });
            mnuAbout.add(itmAbout);
    }
    
    /**
     * Construye los componentes visuales estáticos y la terminal de resultados.
     */
    public static JButton bttnStart, bttnBinary, bttnWhole;
    protected JTextArea txtTerminal;
    public static JTextArea txtControl;
    private JScrollPane sclTerminal;
    private StringBuilder history = new StringBuilder();
    private void initComponents(){
        
        JLabel lblTitle1 = new JLabel("Converter");
        lblTitle1.setBounds(20, 11, 130, 20);
        lblTitle1.setFont(new java.awt.Font("Consolas", 1, 14));
        lblTitle1.setForeground(custom.color());
        add(lblTitle1);
        JLabel lblTitle2 = new JLabel("Bintary");
        lblTitle2.setBounds(20, 28, 130, 35);
        lblTitle2.setFont(new java.awt.Font("Consolas", 1, 33));
        lblTitle2.setForeground(custom.color());
        add(lblTitle2);
        
        bttnStart = new JButton("Inicio");
        bttnStart.setBounds(166, 1, 140, 60);
        bttnStart.setBackground(custom.BackgroundColor());
        bttnStart.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, custom.color()));
        bttnStart.setFont(new java.awt.Font("Consolas", 1, 13));
        bttnStart.setFocusable(false);
        bttnStart.setForeground(custom.color());
        bttnStart.setCursor(Cursor.getPredefinedCursor(12));
        bttnStart.addActionListener(this);
        add(bttnStart);
        
        bttnBinary = new JButton("Binario");
        bttnBinary.setBounds(306, 1, 140, 60);
        bttnBinary.setBackground(custom.color());
        bttnBinary.setBorder(javax.swing.BorderFactory.createLineBorder(null, 0));
        bttnBinary.setFont(new java.awt.Font("Consolas", 1, 13));
        bttnBinary.setForeground(custom.BackgroundColor());
        bttnBinary.setFocusable(false);
        bttnBinary.setCursor(Cursor.getPredefinedCursor(12));
        bttnBinary.addActionListener(this);
        add(bttnBinary);

        bttnWhole = new JButton("Decimal");
        bttnWhole.setBounds(446, 1, 140, 60);
        bttnWhole.setBackground(custom.color());
        bttnWhole.setBorder(javax.swing.BorderFactory.createLineBorder(null, 0));
        bttnWhole.setFont(new java.awt.Font("Consolas", 1, 13));
        bttnWhole.setForeground(custom.BackgroundColor());
        bttnWhole.setCursor(Cursor.getPredefinedCursor(12));
        bttnWhole.setFocusable(false);
        bttnWhole.addActionListener(this);
        add(bttnWhole);
        
        txtControl = new JTextArea(att.BinaryInfo.definicion);
        txtControl.setSelectionColor(custom.BackgroundColor());
        txtControl.setSelectedTextColor(custom.color());
        txtControl.setCaretColor(custom.BackgroundColor());
        txtControl.setBounds(1, 62, 305, 276);
        txtControl.setEditable(false);
        txtControl.setFocusable(false);
        txtControl.setFont(new java.awt.Font("Consolas", 1, 12));
        txtControl.setForeground(custom.color());
        txtControl.setBackground(custom.BackgroundColor());
        add(txtControl);
        
        JLabel lblInfo1 = new JLabel("Convierte un valor decimal a su");
        lblInfo1.setBounds(30, 20, 500, 30);
        lblInfo1.setFont(new java.awt.Font("Consolas", 1, 13));
        lblInfo1.setForeground(custom.HighlightColor());
        txtControl.add(lblInfo1);        
        JLabel lblInfo1_1 = new JLabel("representación binaria y viceversa.");
        lblInfo1_1.setBounds(30, 35, 500, 30);
        lblInfo1_1.setFont(new java.awt.Font("Consolas", 1, 13));
        lblInfo1_1.setForeground(custom.HighlightColor());
        txtControl.add(lblInfo1_1);
        
        JButton bttnInfoBinarySystem = new JButton("Conoce más");
        bttnInfoBinarySystem.setBounds(110,238,80,20);
        bttnInfoBinarySystem.setBorder(BorderFactory.createLineBorder(null, 1));
        bttnInfoBinarySystem.setFont(new Font("Consolas", 3, 12));
        bttnInfoBinarySystem.setForeground(custom.color());
        bttnInfoBinarySystem.setBackground(custom.BackgroundColor());
        bttnInfoBinarySystem.setFocusable(false);
        bttnInfoBinarySystem.setCursor(Cursor.getPredefinedCursor(12));
        bttnInfoBinarySystem.addActionListener((ActionEvent ev) -> {
            window.guiBinarySystemInfoWindow();
        });           
        txtControl.add(bttnInfoBinarySystem);
        
        txtTerminal = new JTextArea("\n  Bintary Converter | Versión " + info.versionSystem() + "\n"
            + "\n\n\n\n\n\n\n\n\n\n\n\n\n"
            + "      © 2025 Development by: ESRG");
        sclTerminal = new JScrollPane(txtTerminal);
        sclTerminal.setBounds(306, 62, 280, 278);  

        // Determina la configuración de visualización de la barra de desplazamiento Horizontal del componente
        // de información de salida
        sclTerminal.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = custom.color();
            }
            
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0)); // Tamaño 0x0
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });

        // Determina la configuración de visualización de la barra de desplazamiento Vertical del componente
        // de información de salida
        sclTerminal.getVerticalScrollBar().setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = custom.color();
            }
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0)); // Tamaño 0x0
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });          
        sclTerminal.getHorizontalScrollBar().setForeground(custom.color());
        txtTerminal.setEditable(false);
        txtTerminal.setSelectionColor(custom.BackgroundColor());
        txtTerminal.setSelectedTextColor(custom.color());
        sclTerminal.setBorder(javax.swing.BorderFactory.createMatteBorder(4,1,4,1, custom.color()));        
        txtTerminal.setFont(new java.awt.Font("Consolas", 1, 13));
        txtTerminal.setForeground(custom.color());
        txtTerminal.setCaretColor(custom.BackgroundColor());
        txtTerminal.setBackground(custom.BackgroundColor());
        add(sclTerminal);
    }
    
    /**
     * Construye el panel dinámico de entrada de datos y los controles de conversión.
     */
    public static JTextArea txtInputData;
    protected JTextField fldNameTable;
    protected JCheckBox chkCreateWindow;
    protected JRadioButton rdoBinary, rdoWhole, rdoSignedDecimal;
    protected JButton bttnConverter, bttnClear;
    protected JLabel lblNameTable;
    private void inputComponents(){
        txtInputData = new JTextArea();
        txtInputData.setSize(305, 276);
        //txtInputData.setBounds(1,62,305,276);
        txtInputData.setLocation(-1000, -1000);
        txtInputData.setEditable(false);
        txtInputData.setBackground(custom.BackgroundColor());
        txtInputData.setCaretColor(custom.BackgroundColor());
        txtInputData.setBorder(BorderFactory.createMatteBorder(0,4,0,0, custom.color()));
        add(txtInputData);
        
        JLabel lblEnterData = new JLabel("INGRESE LOS SIGUIENTES DATOS");
        lblEnterData.setBounds(15, 5, 200, 30);
        lblEnterData.setFont(new java.awt.Font("Consolas", 1, 13));
        lblEnterData.setForeground(custom.color());
        txtInputData.add(lblEnterData);
        
        lblNameTable = new JLabel("Valor de conversión");
        lblNameTable.setBounds(35, 30, 250, 30);
        lblNameTable.setFont(new java.awt.Font("Consolas", 1, 13));
        lblNameTable.setForeground(custom.HighlightColor());
        txtInputData.add(lblNameTable);

        fldNameTable = new JTextField();
        fldNameTable.setBounds(35, 55, 233, 20);
        fldNameTable.setSelectedTextColor(custom.BackgroundColor());
        fldNameTable.setSelectionColor(custom.SelectionColor());
        fldNameTable.setCaretColor(custom.color());
        fldNameTable.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, custom.color()));
        fldNameTable.setFont(new java.awt.Font("Consolas", 0, 14));
        fldNameTable.setBackground(custom.BackgroundColor());
        txtInputData.add(fldNameTable);
        
        chkCreateWindow = new JCheckBox(" Ventana flotante");
        chkCreateWindow.setBounds(35, 80, 300, 30);
        chkCreateWindow.setFont(new java.awt.Font("Consolas", 0, 13));
        chkCreateWindow.setBackground(custom.BackgroundColor());
        chkCreateWindow.setCursor(Cursor.getPredefinedCursor(12));
        chkCreateWindow.setForeground(custom.HighlightColor());
        chkCreateWindow.setFocusable(false);
        txtInputData.add(chkCreateWindow);
        
        JLabel lblTypeCommand = new JLabel("Tipo de conversión");
        lblTypeCommand.setBounds(35, 110, 130, 30);
        lblTypeCommand.setFont(new java.awt.Font("Consolas", 1, 13));
        lblTypeCommand.setForeground(custom.HighlightColor());
        txtInputData.add(lblTypeCommand);

        ButtonGroup typeOfOConvertion = new ButtonGroup();
        rdoBinary = new JRadioButton("Binario");
        rdoBinary.setFont(new java.awt.Font("Consolas", 1, 13));
        rdoBinary.addChangeListener(this);
        rdoBinary.setBounds(170, 110, 80, 20);
        rdoBinary.setBackground(custom.BackgroundColor());
        rdoBinary.setCursor(Cursor.getPredefinedCursor(12));
        rdoBinary.setForeground(custom.HighlightColor());
        rdoBinary.setFocusable(false);
        typeOfOConvertion.add(rdoBinary);
        txtInputData.add(rdoBinary);

        rdoWhole = new JRadioButton("Decimal");
        rdoWhole.setFont(new java.awt.Font("Consolas", 1, 13));
        rdoWhole.setBounds(170, 130, 80, 20);
        rdoWhole.setBackground(custom.BackgroundColor());
        rdoWhole.setCursor(Cursor.getPredefinedCursor(12));
        rdoWhole.setForeground(custom.HighlightColor());
        rdoWhole.setFocusable(false);
        rdoWhole.addChangeListener(this);
        typeOfOConvertion.add(rdoWhole);
        txtInputData.add(rdoWhole);
        
        rdoSignedDecimal = new JRadioButton("Negativo");
        rdoSignedDecimal.setFont(new java.awt.Font("Consolas", 1, 13));
        rdoSignedDecimal.setBounds(170, 150, 85, 20);
        rdoSignedDecimal.setBackground(custom.BackgroundColor());
        rdoSignedDecimal.setCursor(Cursor.getPredefinedCursor(12));
        rdoSignedDecimal.setForeground(custom.HighlightColor());
        rdoSignedDecimal.setFocusable(false);
        rdoSignedDecimal.addChangeListener(this);
        typeOfOConvertion.add(rdoSignedDecimal);
        txtInputData.add(rdoSignedDecimal);
        
        bttnConverter = new JButton("Conversión");
        bttnConverter.setBounds(35, 180, 233, 30);
        bttnConverter.setFont(new java.awt.Font("Consolas", 1, 13));
        bttnConverter.setCursor(Cursor.getPredefinedCursor(12));
        bttnConverter.setFocusable(false);
        bttnConverter.setBackground(custom.color());
        bttnConverter.setForeground(custom.BackgroundColor());
        bttnConverter.setBorder(javax.swing.BorderFactory.createLineBorder(custom.color(), 1));
        bttnConverter.addActionListener((ActionEvent ev) -> {
        /**
         * Ejecuta la lógica de conversión basándose en el modo seleccionado.
         * Captura excepciones de formato numérico y actualiza el historial.
         * 
         * @throws NumberFormatException Al ingresar un valor que no sea numérico 
         */
            switch(converter.getModeConverter()){
                case 1: // Decimal -> Binario
                    try {
                        String whole = fldNameTable.getText().trim();
                        String result;
                        if(whole.substring(0,1).equals("-")){
                            result = converter.toSignedBinary(Long.parseLong(whole.substring(1,whole.length())));                                                       
                        } else {
                            result = converter.toBinary(Long.parseLong(whole));
                        }   
                        history.append("\n > " + whole + "\n"
                                + " = " + result + "\n   " + result.length() + " bits.\n");
                    } catch(NumberFormatException er){
                        window.guiMessagePopup("Valor no retornado", "Ingrese un valor numérico entero.");
                        System.out.println("Error " + er + "\n");
                    }
                    break;
                    
                case 2: // Binario -> Decimal     
                    try {
                        String binary = fldNameTable.getText().trim();
                        Long result;
                        if (binary.length() <= 32) {
                            for (int i = 1; i <= binary.length(); i++) {
                                if (binary.substring(i - 1, i).equals("1") || binary.substring(i - 1, i).equals("0")) {
                                    if (i == binary.length()) {
                                        result = converter.toDecimal(binary);
                                        history.append("\n > " + binary + "\n"
                                                + " = " + result + "\n   " + binary.toString().length() + " bits.\n");
                                        i = binary.length() * 10;
                                    }
                                } else {
                                    window.guiMessagePopup("Sin retornar datos", "Ingrese un valor binario.");
                                    i = binary.length() * 10;
                                }
                            }
                        } else {
                            window.guiMessagePopup("Sin retornar datos", "Máximo 32 digitos binarios.");
                        }
                    } catch (NumberFormatException er) {
                        window.guiMessagePopup("Sin retornar datos", "Ingrese un valor binario.");
                    }
                    break;    
                    
                case 3: // Binario -> Decimal negativo    
                    try {
                        String binary = fldNameTable.getText().trim();
                        String result;
                        if (binary.length() <= 32) {
                            for (int i = 1; i <= binary.length(); i++) {
                                if (binary.substring(i - 1, i).equals("1") || binary.substring(i - 1, i).equals("0")) {
                                    if (i == binary.length()) {
                                        result = converter.toSignedDecimal(binary);
                                        history.append("\n > " + binary + "\n"
                                                + " = " + result + "\n   " + binary.length() + " bits.\n");
                                        i = binary.length() * 10;
                                    }
                                } else {
                                    window.guiMessagePopup("Sin retornar datos", "Ingrese un valor binario.");
                                    i = binary.length() * 10;
                                }
                            }
                        } else {
                            window.guiMessagePopup("Sin retornar datos", "Máximo 32 digitos binarios.");
                        }
                    } catch (NumberFormatException er) {
                        window.guiMessagePopup("Sin retornar datos", "Ingrese un valor binario.");
                    }
                    break;

            }
            txtTerminal.setText(history.toString());
            if(chkCreateWindow.isSelected() == true){
                window.guiConversionResultWindow(history.toString());
            }
        });
        txtInputData.add(bttnConverter);
        
        bttnClear = new JButton("Limpiar");
        bttnClear.setBounds(35, 215, 233, 30);
        bttnClear.setFont(new java.awt.Font("Consolas", 1, 13));
        bttnClear.setBackground(custom.BackgroundColor());
        bttnClear.setCursor(Cursor.getPredefinedCursor(12));
        bttnClear.setFocusable(false);
        bttnClear.setForeground(custom.color());
        bttnClear.setBorder(javax.swing.BorderFactory.createLineBorder(custom.color(), 1));
        bttnClear.addActionListener((ActionEvent ev) -> {
            fldNameTable.setText("");
            chkCreateWindow.setSelected(false);
            rdoBinary.setSelected(true);
            history.setLength(0);
            txtTerminal.setText("\n  Bintary Converter | Versión " + info.versionSystem() + "\n"
                    + "\n\n\n\n\n\n\n\n\n\n\n\n\n"
                    + "      © 2025 Development by: ESRG");
        });
        txtInputData.add(bttnClear);
        

        
    }
    
    /**
     * Maneja las acciones de los RedioButtons principales
     * para cambiar la vista de la aplicación y el modo y tipo de conversión.
     */
    @Override
    public void stateChanged(ChangeEvent ev){
        
        MainControlHandler event = new MainControlHandler();

        if (rdoBinary.isSelected() == true) {

            converter.setModeConverter(1);

            event.modeComponentsButtonNULL();
            bttnBinary.setBackground(custom.BackgroundColor());
            bttnBinary.setForeground(custom.color());
            lblNameTable.setText("Valor de conversión - Decimal");
            
        } else if(rdoWhole.isSelected() == true) {

            converter.setModeConverter(2);
            
            event.modeComponentsButtonNULL();
            bttnWhole.setBackground(custom.BackgroundColor());
            bttnWhole.setForeground(custom.color());
            lblNameTable.setText("Valor de conversión - Binario");
            
        } else if(rdoSignedDecimal.isSelected() == true) {

            converter.setModeConverter(3);
            
            event.modeComponentsButtonNULL();
            bttnWhole.setBackground(custom.BackgroundColor());
            bttnWhole.setForeground(custom.color());
            lblNameTable.setText("Valor de conversión - Binario");
        }
    }
    
    /**
     * Maneja las acciones de los botones principales y elementos de menú
     * para cambiar la vista de la aplicación y el modo y tipo de conversión.
     */
    @Override
    public void actionPerformed(ActionEvent ev){
        
        
        
        if(ev.getSource() == bttnStart){
            
            event.modeComponentsNULL(); // Restablecer componentes de interacción.
            event.modeComponentsButtonNULL(); // Restablecer botones de menú.
            txtControl.setLocation(1, 62);
            bttnStart.setBackground(custom.BackgroundColor());
            bttnStart.setForeground(custom.color());
        }
            
        if(ev.getSource() == bttnBinary || ev.getSource() == itmBinary){
            
            converter.setModeConverter(1); // Tipo de conversión.
            lblNameTable.setText("Valor de conversión - Decimal"); // Solicitud de parametro
            event.modeComponentsNULL(); // Restablecer componentes de interacción.
            event.modeComponentsButtonNULL(); // Restablecer botones de menú.
            txtInputData.setLocation(1, 62);
            bttnBinary.setBackground(custom.BackgroundColor());
            bttnBinary.setForeground(custom.color());
            
            rdoBinary.setSelected(true);
        }
        
        if(ev.getSource() == bttnWhole || ev.getSource() == itmWhole){
            
            converter.setModeConverter(2); // Tipo de conversión.
            lblNameTable.setText("Valor de conversión - Binario"); // Solicitud de parametro
            event.modeComponentsNULL(); // Restablecer componentes de interacción.
            event.modeComponentsButtonNULL(); // Restablecer botones de menú.
            txtInputData.setLocation(1, 62);
            bttnWhole.setBackground(custom.BackgroundColor());
            bttnWhole.setForeground(custom.color());
            
            rdoWhole.setSelected(true);
        }
        
        if(ev.getSource() == itmSignedDecimal){
            
            converter.setModeConverter(3); // Tipo de conversión.
            lblNameTable.setText("Valor de conversión - Binario"); // Solicitud de parametro
            event.modeComponentsNULL(); // Restablecer componentes de interacción.
            event.modeComponentsButtonNULL(); // Restablecer botones de menú.
            txtInputData.setLocation(1, 62);
            bttnWhole.setBackground(custom.BackgroundColor());
            bttnWhole.setForeground(custom.color());
            
            rdoSignedDecimal.setSelected(true);
        }
    }
}
