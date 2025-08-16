
package gui;

/**
 *
 * @author ESRG
 */
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import act.BinaryConverter;
import act.MainControlHandler;
import act.WindowLoader;
import att.AppearanceSettings;
import att.SystemInfo;

public class MainControlPanel extends JFrame implements ActionListener, ChangeListener{
    
    AppearanceSettings custom = new AppearanceSettings();
    SystemInfo info = new SystemInfo();
    BinaryConverter converter = new BinaryConverter();
    WindowLoader window = new WindowLoader();    
    
    public MainControlPanel(){
        
        setTitle("Bintary Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(custom.BackgroundColor());
        setIconImage(new ImageIcon(getClass().getResource("images/bintary_icon.png")).getImage());
        
        UIManager.put("Button.select", custom.SelectionColor());        
        
        UIManager.put("Menu.selectionForeground", custom.BackgroundColor());
        UIManager.put("Menu.selectionBackground", custom.SelectionColor());
        UIManager.put("MenuItem.selectionForeground", custom.BackgroundColor());
        UIManager.put("MenuItem.selectionBackground", custom.SelectionColor());
        
        setLayout(null);
            menuComponents();
            initComponents();
            inputComponents();
    }
    
    protected JMenuBar mnuBar;
    protected JMenuItem itmBinary, itmWhole;
    private void menuComponents(){
        mnuBar = new JMenuBar();
        mnuBar.setBackground(custom.color());
        mnuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, custom.color()));
        mnuBar.setCursor(Cursor.getPredefinedCursor(12));
        setJMenuBar(mnuBar);
        
        JMenu mnuOption = new JMenu("Opciones");
        mnuOption.setFont(new Font("Consolas", 0, 11));
        mnuOption.setForeground(custom.BackgroundColor());
        mnuBar.add(mnuOption);
        
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
                    dispose();
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
                    dispose();
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
                    dispose();
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
                    dispose();
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
                    dispose();
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
                mnuClear.add(itmClearTerminal);
                
                JMenuItem itmClearComponents = new JMenuItem("Componentes de interacción    ");
                itmClearComponents.setForeground(custom.color());
                itmClearComponents.setBackground(custom.BackgroundColor());
                itmClearComponents.setFont(new Font("Consolas", 0, 11));
                itmClearComponents.setCursor(Cursor.getPredefinedCursor(12));
                itmClearComponents.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, custom.color()));
                //itmClearComponents.setEnabled(false);            
                mnuClear.add(itmClearComponents);
            
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
            itmWhole.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, custom.color()));
            itmWhole.addActionListener(this);
            //itmWhole.setEnabled(false);            
            mnuConverted.add(itmWhole);
        
        JMenu mnuAbout = new JMenu("Acerca de");
        mnuAbout.setFont(new Font("Consolas", 0, 11));
        mnuAbout.setForeground(custom.BackgroundColor());
        mnuBar.add(mnuAbout);
        
            JMenuItem itmInformation = new JMenuItem("Información                   ");
            itmInformation.setForeground(custom.color());
            itmInformation.setBackground(custom.BackgroundColor());
            itmInformation.setFont(new Font("Consolas", 0, 11));
            itmInformation.setCursor(Cursor.getPredefinedCursor(12));
            itmInformation.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, custom.color()));
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
    
    public static JButton bttnStart, bttnBinary, bttnWhole;
    protected JTextArea txtTerminal;
    public static JTextArea txtControl;
    private JScrollPane sclTerminal;
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
        
        txtControl = new JTextArea("\n════════════════════════════════════════════\n"
                + "\n"
                + "\n"
                + "════════════════════════════════════════════\n"
                + "\n"
                + " \n"
                + "   1. Seleccione un tipo de conversión,\n"
                + "      entre: binario o decimal.\n"
                + "   2. Ingrese el respectivo valor por\n"
                + "      convertir.\n"
                + "   3. Marca la casilla \"Generar resultado\n"
                + "      en ventana\" para crear el resultado \n"
                + "      en una nueva ventana.\n"
                + "\n"
                + "\n"
                + "════════════════════════════════════════════");        
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
        
        txtTerminal = new JTextArea("\n  Bintary Converter | Versión " + info.versionSystem() + "\n"
            + "\n\n\n\n\n\n\n\n\n\n\n\n\n"
            + "      © 2025 Development by: ESRG");
        sclTerminal = new JScrollPane(txtTerminal);
        sclTerminal.setBounds(306, 62, 280, 278);   
        sclTerminal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        sclTerminal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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
    
    public static JTextArea txtInputData;
    protected JTextField fldNameTable;
    protected JCheckBox chkCreateWindow;
    protected JRadioButton rdoBinary, rdoWhole;
    protected JButton bttnConverter, bttnClear;
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
        
        JLabel lblNameTable = new JLabel("Valor de conversión");
        lblNameTable.setBounds(35, 30, 200, 30);
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
        lblTypeCommand.setBounds(35, 120, 130, 30);
        lblTypeCommand.setFont(new java.awt.Font("Consolas", 1, 13));
        lblTypeCommand.setForeground(custom.HighlightColor());
        txtInputData.add(lblTypeCommand);

        ButtonGroup typeOfOConvertion = new ButtonGroup();
        rdoBinary = new JRadioButton("Binario");
        rdoBinary.setFont(new java.awt.Font("Consolas", 1, 13));
        rdoBinary.addChangeListener(this);
        rdoBinary.setBounds(170, 125, 80, 20);
        rdoBinary.setBackground(custom.BackgroundColor());
        rdoBinary.setCursor(Cursor.getPredefinedCursor(12));
        rdoBinary.setForeground(custom.HighlightColor());
        rdoBinary.setFocusable(false);
        typeOfOConvertion.add(rdoBinary);
        txtInputData.add(rdoBinary);

        rdoWhole = new JRadioButton("Decimal");
        rdoWhole.setFont(new java.awt.Font("Consolas", 1, 13));
        rdoWhole.setBounds(170, 145, 80, 20);
        rdoWhole.setBackground(custom.BackgroundColor());
        rdoWhole.setCursor(Cursor.getPredefinedCursor(12));
        rdoWhole.setForeground(custom.HighlightColor());
        rdoWhole.setFocusable(false);
        rdoWhole.addChangeListener(this);
        typeOfOConvertion.add(rdoWhole);
        txtInputData.add(rdoWhole);
        
        bttnClear = new JButton("Limpiar componentes");
        bttnClear.setBounds(35, 180, 233, 30);
        bttnClear.setFont(new java.awt.Font("Consolas", 1, 13));
        bttnClear.setBackground(custom.BackgroundColor());
        bttnClear.setCursor(Cursor.getPredefinedCursor(12));
        bttnClear.setFocusable(false);
        bttnClear.setForeground(custom.color());
        bttnClear.setBorder(javax.swing.BorderFactory.createLineBorder(custom.color(), 1));
        bttnClear.addActionListener((ActionEvent ev) -> {
            
        });
        txtInputData.add(bttnClear);
        
        bttnConverter = new JButton("Conversión");
        bttnConverter.setBounds(35, 215, 233, 30);
        bttnConverter.setFont(new java.awt.Font("Consolas", 1, 13));
        bttnConverter.setCursor(Cursor.getPredefinedCursor(12));
        bttnConverter.setFocusable(false);
        bttnConverter.setBackground(custom.color());
        bttnConverter.setForeground(custom.BackgroundColor());
        bttnConverter.setBorder(javax.swing.BorderFactory.createLineBorder(custom.color(), 1));
        bttnConverter.addActionListener((ActionEvent ev) -> {
            
        });
        txtInputData.add(bttnConverter);
    }
    
    @Override
    public void stateChanged(ChangeEvent ev){
        
        MainControlHandler event = new MainControlHandler();

        if (rdoBinary.isSelected() == true) {

            converter.modeConverter(1);

            event.modeComponentsButtonNULL();
            bttnBinary.setBackground(custom.BackgroundColor());
            bttnBinary.setForeground(custom.color());
        } else {

            converter.modeConverter(2);
            
            event.modeComponentsButtonNULL();
            bttnWhole.setBackground(custom.BackgroundColor());
            bttnWhole.setForeground(custom.color());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
        
        MainControlHandler event = new MainControlHandler();
        
        if(ev.getSource() == bttnStart){
            
            event.modeComponentsNULL(); // Restablecer componentes de interacción.
            event.modeComponentsButtonNULL(); // Restablecer botones de menú.
            txtControl.setLocation(1, 62);
            bttnStart.setBackground(custom.BackgroundColor());
            bttnStart.setForeground(custom.color());
        }
            
        if(ev.getSource() == bttnBinary || ev.getSource() == itmBinary){
            
            converter.modeConverter(1); // Tipo de conversión.
            event.modeComponentsNULL(); // Restablecer componentes de interacción.
            event.modeComponentsButtonNULL(); // Restablecer botones de menú.
            txtInputData.setLocation(1, 62);
            bttnBinary.setBackground(custom.BackgroundColor());
            bttnBinary.setForeground(custom.color());
            
            rdoBinary.setSelected(true);
        }
        
        if(ev.getSource() == bttnWhole || ev.getSource() == itmWhole){
            
            converter.modeConverter(2); // Tipo de conversión.
            event.modeComponentsNULL(); // Restablecer componentes de interacción.
            event.modeComponentsButtonNULL(); // Restablecer botones de menú.
            txtInputData.setLocation(1, 62);
            bttnWhole.setBackground(custom.BackgroundColor());
            bttnWhole.setForeground(custom.color());
            
            rdoWhole.setSelected(true);
        }
    }
}
