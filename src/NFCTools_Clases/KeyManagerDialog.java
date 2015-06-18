package NFCTools_Clases;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import NFCTools_Utils.HexUtils;
import NFCTools_Utils.KeysUtils;
import java.awt.Dimension;
import java.awt.Toolkit;

public class KeyManagerDialog extends JDialog {

	private static final long serialVersionUID = -7442030881325140240L;

	private static final String UPDATE_KEYS = "update_keys";
	private static final String LOAD_FROM_FILE = "load_from_file";
	private static final String CLEAR_KEYS = "clear_keys";

	private JDialog dialog;
	private JEditorPane editorPane;

	private Set<String> keys;
        

	private ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			try {
				switch (actionCommand) {
				case UPDATE_KEYS:
					String[] keysString = editorPane.getText().split("\n");
					int count = 0;
					for (String key : keysString) {
						if (HexUtils.isHexadecimalAndNBytes(key, 6))
							if (!keys.contains(key)) {
								keys.add(key);
								count++;
							}

					}
					JOptionPane.showMessageDialog(dialog, count
							+ " nuevas llaves agregadas", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
					editorPane.setText("");
					putKeysOnEditorPane(keys);
					break;
				case LOAD_FROM_FILE:
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fileChooser.setMultiSelectionEnabled(true);
					fileChooser.setFileFilter(new FileNameExtensionFilter(
							"Archivo de llaves", "keys"));
					int result = fileChooser.showOpenDialog(dialog);
					if (result == JFileChooser.APPROVE_OPTION) {
						File[] files = fileChooser.getSelectedFiles();
						for (File file : files) {
							Set<String> keysFromFile = KeysUtils
									.getKeysFromFile(file);
							putKeysOnEditorPane(keysFromFile);
						}
					}
					break;
				case CLEAR_KEYS:
					keys.clear();
					editorPane.setText("");
					break;
				default:
					break;
				}
			} catch (IOException exception) {
				JOptionPane.showMessageDialog(dialog, exception.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
				exception.printStackTrace();
			}
		}
	};

	public KeyManagerDialog(Set<String> keys) throws IOException {
		this.dialog = this;
		this.keys = keys;
		initialize();
		initializeComponents();
	}

    KeyManagerDialog() throws IOException {
        initializeComponents();
        initialize();
        
    }

     public final void IniciarFrame () throws IOException
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);       
        //setIconImage(new ImageIcon (getClass().getResource("Licencias_Icon.png")).getImage());                                
    }
    

	private void initialize() throws IOException {
		setBounds(100, 100, 337, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Administrador de llaves");

                IniciarFrame ();
                        
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btnUpdateKeys = new JButton("Actualizar llaves");
		btnUpdateKeys.addActionListener(actionListener);
		btnUpdateKeys.setActionCommand(UPDATE_KEYS);
		panel.add(btnUpdateKeys);

		JButton btnClearKeys = new JButton("Borrar llaves");

		btnClearKeys.addActionListener(actionListener);
		btnClearKeys.setActionCommand(CLEAR_KEYS);
		panel.add(btnClearKeys);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);

		JButton btnLoadFromFile = new JButton("Cargar desde un archivo");
		panel_1.add(btnLoadFromFile);
		btnLoadFromFile.addActionListener(actionListener);
		btnLoadFromFile.setActionCommand(LOAD_FROM_FILE);
	}

	private void initializeComponents() {
		putKeysOnEditorPane(keys);
	}

	private void putKeysOnEditorPane(Set<String> keys) {
		for (String key : keys) {
			editorPane.setText(key + "\n" + editorPane.getText());
		}
	}
}
