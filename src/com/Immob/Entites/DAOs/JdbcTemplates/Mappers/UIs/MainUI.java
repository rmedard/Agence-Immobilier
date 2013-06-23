package com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.Immob.Entites.Immobilier;
import com.Immob.Entites.Offre;
import com.Immob.Entites.DAOs.JdbcTemplates.ImmobilierJdbcTemplate;
import com.Immob.Entites.DAOs.JdbcTemplates.OffreJdbcTemplate;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.EtatImmobilier;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.EtatOffre;
import com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools.TypeImmobilier;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import org.apache.commons.validator.routines.BigDecimalValidator;
import org.apache.commons.validator.routines.CurrencyValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainUI extends JFrame {

    /**
	 * 
	 */

    // {{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtReference;
    private JTextField txtPrixImmob;
    private JTextField txtImmobRef;
    private JTextField txtMontant;
    private JTextField txtNomAcheteur;
    private JTextField txtReferenceClient;
    private JTextField txtPrixImmobClient;
    private JTextField txtOffreImmobRef;
    private JTextField txtNomAcheteurClient;
    private JTextField txtMontantClient;
    private JTextField txtPrixMinSearch;
    private JTextField txtPrixMaxSearch;
    private JTextField txtReferenceSearch;
    private JTabbedPane tabbedPane;
    private JPanel panelAdmin;
    private JPanel panelImmobilier;
    private JList<String> jListImmobs;
    private JComboBox<String> cbxEtatImmob;
    private JComboBox<String> cbxTypeImmob;
    private JTextArea txtAreaDesc;
    private JComboBox<String> cbxVisible;
    private JButton btnAjouterImmob;
    private JButton btnSaveImmob;
    private JButton btnDeleteImmob;
    private JPanel PanelOffre;
    private JList<String> jListOffre;
    private JDateChooser dateValidite;
    private JComboBox<String> cbxEtatOffre;
    private JButton btnSaveOffre;
    private JButton btnDeleteOffre;
    private JPanel panelClient;
    private JPanel panelImmobClient;
    private JList<String> jListImmobsClient;
    private JComboBox<String> cbxEtatImmobClient;
    private JComboBox<String> cbxTypeImmobClient;
    private JTextArea txtAreaDescClient;
    private JButton btnPlacerOffre;
    private JPanel panelSearch;
    private JLabel lblNewLabel;
    private JComboBox<String> cbxTypeImmobSearch;
    private JLabel lblPrixMaximum;
    private JLabel lblPrixMinimum;
    private JButton btnSearch;
    private JLabel lblRf;
    private JPanel panel;
    private JLabel lblRfrenceImmobilier;
    private JLabel lblVotreNomEt;
    private JLabel lblVotreMontant;
    private JLabel lblDateUltimeDe;
    private JDateChooser dateValiditeClient;
    private JList<String> jListOffreClient;
    private JButton btnEnvoyerOffre;
    private JButton btnAnnulerOffre;
    private JLabel lblEtatDeVotre;
    private JLabel lblEtat;
    private JPanel panelRendezVous;
    private JLabel lblRfrenceImmobilier_1;
    private JLabel lblImmobRefForContact;
    private JLabel lblTlphone;
    private JLabel lblEmail;
    private JLabel lblExampledomaincom;
    private JLabel label;
    private JLabel lblNumro;
    private JLabel lblOffreNum;
    private JLabel lblRfrence_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNomDuClient;
    private JLabel lblDateUltimeDe_1;
    private JLabel lblEtatDeLoffre;

    private DefaultListModel<String> immobListModel;
    private DefaultListModel<String> offreListModel;
    private DefaultListModel<String> immobClientListModel;
    private DefaultListModel<String> offreClientListModel;
    // }}

    // Implementors
    private ImmobilierJdbcTemplate immobImpl;
    private OffreJdbcTemplate offerImpl;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    MainUI frame = new MainUI();
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
    public MainUI() {
	initializeComponents();

	// Get the bean
	ApplicationContext context = new ClassPathXmlApplicationContext(
		"/com/Immob/Entites/DAOs/JdbcTemplates/Mappers/UIs/Tools/Beans.xml");
	immobImpl = (ImmobilierJdbcTemplate) context
		.getBean("immobilierJdbcTemplate");
	offerImpl = (OffreJdbcTemplate) context.getBean("offreJdbcTemplate");

	immobListModel = new DefaultListModel<>();
	offreListModel = new DefaultListModel<>();
	immobClientListModel = new DefaultListModel<>();
	offreClientListModel = new DefaultListModel<>();

	// Initially locked controls
	// For the admin
	txtImmobRef.setEnabled(false);
	txtMontant.setEnabled(false);
	txtNomAcheteur.setEnabled(false);
	dateValidite.setEnabled(false);
	// For the client
	txtReferenceClient.setEnabled(false);
	cbxEtatImmobClient.setEnabled(false);
	cbxTypeImmobClient.setEnabled(false);
	txtPrixImmobClient.setEnabled(false);
	txtAreaDescClient.setEnabled(false);

	addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowOpened(WindowEvent arg0) {
		// Display for admin
		List<Immobilier> allImmobs = new ArrayList<>();
		allImmobs = immobImpl.getAllImmobilier();
		listImmobPopulator(allImmobs, jListImmobs);

		List<Offre> allOffres = new ArrayList<>();
		allOffres = offerImpl.getAllOffre();
		listOffrePopulator(allOffres, jListOffre);

		// Display for client
		List<Immobilier> visibleImmobs = new ArrayList<>();
		visibleImmobs = immobImpl.getImmobilierParVisibilite(true);
		listImmobPopulator(visibleImmobs, jListImmobsClient);
		listOffrePopulator(allOffres, jListOffreClient);

		// Populate comboBoxes
		cbxEtatImmob.addItem("---");
		cbxEtatImmobClient.addItem("---");
		cbxEtatOffre.addItem("---");
		cbxTypeImmob.addItem("---");
		cbxTypeImmobClient.addItem("---");
		cbxTypeImmobSearch.addItem("---");
		for (EtatImmobilier.Etat etat : EtatImmobilier.Etat.values()) {
		    cbxEtatImmob.addItem(etat.toString().toLowerCase());
		    cbxEtatImmobClient.addItem(etat.toString().toLowerCase());
		}
		for (EtatOffre.Etat etat : EtatOffre.Etat.values()) {
		    cbxEtatOffre.addItem(etat.toString().toLowerCase());
		}
		for (TypeImmobilier.Type type : TypeImmobilier.Type.values()) {
		    cbxTypeImmob.addItem(type.toString().toLowerCase());
		    cbxTypeImmobClient.addItem(type.toString().toLowerCase());
		    cbxTypeImmobSearch.addItem(type.toString().toLowerCase());
		}
		cbxVisible.addItem("Non");
		cbxVisible.addItem("Oui");
	    }
	});

    }

    private void initializeComponents() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(
		MainUI.class.getResource("/icons/world.png")));
	ImageIcon addIcon = new ImageIcon(
		MainUI.class.getResource("/icons/add.png"));
	ImageIcon deleteIcon = new ImageIcon(
		MainUI.class.getResource("/icons/delete.png"));

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 748, 494);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(0, 0, 733, 455);
	contentPane.add(tabbedPane);

	panelAdmin = new JPanel();
	tabbedPane.addTab("Admin", null, panelAdmin, null);
	panelAdmin.setLayout(null);

	panelImmobilier = new JPanel();
	panelImmobilier.setBounds(10, 11, 322, 405);
	panelAdmin.add(panelImmobilier);
	panelImmobilier.setBorder(new TitledBorder(UIManager
		.getBorder("TitledBorder.border"), "Immobiliers",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelImmobilier.setLayout(null);

	jListImmobs = new JList<String>();
	jListImmobs.addListSelectionListener(new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent arg0) {
		if (jListImmobs.isSelectionEmpty()) {
		    txtReference.setText("");
		    cbxEtatImmob.setSelectedIndex(0);
		    cbxTypeImmob.setSelectedIndex(0);
		    txtPrixImmob.setText("");
		    txtAreaDesc.setText("");
		    cbxVisible.setSelectedIndex(0);
		    listOffrePopulator(offerImpl.getAllOffre(), jListOffre);
		} else {
		    // Populate corresponding offers
		    List<Offre> correspondingOffers = new ArrayList<>();
		    for (int i = 0; i < jListImmobs.getSelectedIndices().length; i++) {
			// i will always be 0 because jListImmobs's selectionMode is "one"
			if (i == 0) {
			    // Populates the first selected immob details in the
			    // fields.
			    Immobilier immob = immobImpl.getImmobilierParRef(jListImmobs
				    .getModel()
				    .getElementAt(
					    jListImmobs.getSelectedIndices()[i]));
			    txtReference.setText(immob.getReference());
			    for (int j = 0; j < cbxEtatImmob.getItemCount(); j++) {
				if (cbxEtatImmob
					.getItemAt(j)
					.toString()
					.toLowerCase()
					.equals(immob.getEtat().toString()
						.toLowerCase())) {
				    cbxEtatImmob.setSelectedIndex(j);
				}
			    }
			    for (int j = 0; j < cbxTypeImmob.getItemCount(); j++) {
				if (cbxTypeImmob
					.getItemAt(j)
					.toString()
					.toLowerCase()
					.equals(immob.getType().toString()
						.toLowerCase())) {
				    cbxTypeImmob.setSelectedIndex(j);
				}
			    }
			    txtPrixImmob.setText(immob.getPrix().toString());
			    txtAreaDesc.setText(immob.getDescription());
			    if (immob.isVisible()) {
				cbxVisible.setSelectedIndex(1);
			    }
			}
			
			//Add corresponding offres to jList
			correspondingOffers.add(offerImpl.getOffreParImmobRef(
				jListImmobs.getModel().getElementAt(
					jListImmobs.getSelectedIndices()[i]))
				.get(0));
		    }
		    listOffrePopulator(correspondingOffers, jListOffre);
		}
	    }
	});
	jListImmobs.setBounds(10, 23, 138, 269);
	panelImmobilier.add(jListImmobs);

	txtReference = new JTextField();
	txtReference.setBounds(154, 39, 152, 20);
	panelImmobilier.add(txtReference);
	txtReference.setColumns(10);
	txtReference.getDocument().addDocumentListener(new DocumentListener() {

	    @Override
	    public void changedUpdate(DocumentEvent arg0) {
		textChanged();
	    }

	    @Override
	    public void insertUpdate(DocumentEvent arg0) {
		textChanged();
	    }

	    @Override
	    public void removeUpdate(DocumentEvent arg0) {
		textChanged();
	    }

	});

	txtPrixImmob = new JTextField();
	txtPrixImmob.setBounds(154, 159, 152, 20);
	panelImmobilier.add(txtPrixImmob);
	txtPrixImmob.setColumns(10);

	cbxEtatImmob = new JComboBox<String>();
	cbxEtatImmob.setBounds(154, 78, 152, 20);
	panelImmobilier.add(cbxEtatImmob);

	cbxTypeImmob = new JComboBox<String>();
	cbxTypeImmob.setBounds(154, 119, 152, 20);
	panelImmobilier.add(cbxTypeImmob);

	txtAreaDesc = new JTextArea();
	txtAreaDesc.setBounds(154, 201, 152, 68);
	panelImmobilier.add(txtAreaDesc);

	cbxVisible = new JComboBox<String>();
	cbxVisible.setBounds(154, 296, 152, 20);
	panelImmobilier.add(cbxVisible);

	btnAjouterImmob = new JButton("Ajouter");
	btnAjouterImmob.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		jListImmobs.clearSelection();
	    }
	});
	btnAjouterImmob.setHorizontalAlignment(SwingConstants.LEFT);
	btnAjouterImmob.setIcon(addIcon);
	btnAjouterImmob.setBounds(10, 303, 138, 23);
	panelImmobilier.add(btnAjouterImmob);

	btnSaveImmob = new JButton("Enreg.");
	btnSaveImmob.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		if (jListImmobs.isSelectionEmpty()
			&& isImmobFormValidForUpload(true)) {
		    Immobilier immob = new Immobilier();
		    immob.setReference(txtReference.getText());
		    immob.setEtat(new EtatImmobilier()
			    .toEtatImmbilier(cbxEtatImmob.getSelectedItem()
				    .toString()));
		    immob.setType(new TypeImmobilier()
			    .toTypeImmobilier(cbxTypeImmob.getSelectedItem()
				    .toString()));
		    immob.setPrix(new BigDecimal(txtPrixImmob.getText()));
		    immob.setDescription(txtAreaDesc.getText());
		    immob.setVisible(cbxVisible.getSelectedIndex() == 1 ? true
			    : false);
		    immobImpl.create(immob);
		} else {
		    if (!jListImmobs.isSelectionEmpty()
			    && isImmobFormValidForUpload(false)) {
			Immobilier immob = immobImpl.getImmobilierParRef(jListImmobs
				.getModel().getElementAt(
					jListImmobs.getSelectedIndices()[0]));
			immob.setReference(txtReference.getText());
			immob.setEtat(new EtatImmobilier()
				.toEtatImmbilier(cbxEtatImmob.getSelectedItem()
					.toString()));
			immob.setType(new TypeImmobilier()
				.toTypeImmobilier(cbxTypeImmob
					.getSelectedItem().toString()));
			immob.setPrix(new BigDecimal(txtPrixImmob.getText()));
			immob.setDescription(txtAreaDesc.getText());
			immob.setVisible(cbxVisible.getSelectedIndex() == 1 ? true
				: false);
			immobImpl.updateImmobilier(immob);
		    }
		}
		listImmobPopulator(immobImpl.getAllImmobilier(), jListImmobs);
	    }
	});
	btnSaveImmob.setHorizontalAlignment(SwingConstants.LEFT);
	btnSaveImmob.setIcon(new ImageIcon(MainUI.class
		.getResource("/icons/save.png")));
	btnSaveImmob.setBounds(10, 337, 138, 23);
	panelImmobilier.add(btnSaveImmob);

	btnDeleteImmob = new JButton("Supprimer");
	btnDeleteImmob.setHorizontalAlignment(SwingConstants.LEFT);
	btnDeleteImmob.setIcon(deleteIcon);
	btnDeleteImmob.setBounds(10, 371, 138, 23);
	panelImmobilier.add(btnDeleteImmob);

	JLabel lblRfrence = new JLabel("R\u00E9f\u00E9rence:");
	lblRfrence.setBounds(154, 24, 124, 14);
	panelImmobilier.add(lblRfrence);

	JLabel lblNewLabel_1 = new JLabel("Etat:");
	lblNewLabel_1.setBounds(154, 62, 124, 14);
	panelImmobilier.add(lblNewLabel_1);

	JLabel lblType = new JLabel("Type:");
	lblType.setBounds(154, 103, 99, 14);
	panelImmobilier.add(lblType);

	JLabel lblPrix = new JLabel("Prix:");
	lblPrix.setBounds(154, 145, 99, 14);
	panelImmobilier.add(lblPrix);

	JLabel lblDescription = new JLabel("Description:");
	lblDescription.setBounds(158, 186, 124, 14);
	panelImmobilier.add(lblDescription);

	JLabel lblVisibleAuxClients = new JLabel("Visible aux clients:");
	lblVisibleAuxClients.setBounds(154, 280, 152, 14);
	panelImmobilier.add(lblVisibleAuxClients);

	PanelOffre = new JPanel();
	PanelOffre.setBounds(342, 11, 334, 405);
	panelAdmin.add(PanelOffre);
	PanelOffre.setBorder(new TitledBorder(null, "Offres",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	PanelOffre.setLayout(null);

	jListOffre = new JList<String>();
	jListOffre.addListSelectionListener(new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent arg0) {
		if (jListOffre.isSelectionEmpty()) {
		    lblOffreNum.setText("");
		    txtImmobRef.setText("");
		    txtMontant.setText("");
		    txtNomAcheteur.setText("");
		    dateValidite.setDate(new Date());
		    cbxEtatOffre.setSelectedIndex(0);
		} else {
		    List<Immobilier> correspondingImmobs = new ArrayList<Immobilier>();
		    for (int i = 0; i < jListOffre.getSelectedIndices().length; i++) {
			Offre offre = offerImpl.getOffreParID(Integer
				.parseInt(jListOffre
					.getModel()
					.getElementAt(
						jListOffre.getSelectedIndices()[i])
					.substring(6).trim()));
			if (i == 0) {
			    lblOffreNum.setText("OffreN" + offre.getId());
			    txtImmobRef.setText(offre.getImmobReference());
			    txtMontant.setText(offre.getMontant().toString());
			    txtNomAcheteur.setText(offre.getNomAcheteur());
			    dateValidite.setDate(offre.getValidite());
			    for (int j = 0; j < cbxEtatOffre.getItemCount(); j++) {
				if (cbxEtatOffre
					.getItemAt(j)
					.toString()
					.toLowerCase()
					.equals(offre.getEtat().toString()
						.toLowerCase())) {
				    cbxEtatOffre.setSelectedIndex(j);
				}
			    }
			}
			correspondingImmobs.add(immobImpl
				.getImmobilierParOffre(offre));
		    }
		    listImmobPopulator(correspondingImmobs, jListImmobs);
		}
	    }
	});
	jListOffre.setBounds(22, 23, 138, 269);
	PanelOffre.add(jListOffre);

	txtImmobRef = new JTextField();
	txtImmobRef.setBounds(170, 63, 152, 20);
	PanelOffre.add(txtImmobRef);
	txtImmobRef.setColumns(10);

	txtMontant = new JTextField();
	txtMontant.setBounds(170, 104, 152, 20);
	PanelOffre.add(txtMontant);
	txtMontant.setColumns(10);

	txtNomAcheteur = new JTextField();
	txtNomAcheteur.setBounds(170, 144, 152, 20);
	PanelOffre.add(txtNomAcheteur);
	txtNomAcheteur.setColumns(10);

	dateValidite = new JDateChooser();
	dateValidite.setBounds(170, 185, 152, 20);
	PanelOffre.add(dateValidite);

	cbxEtatOffre = new JComboBox<String>();
	cbxEtatOffre.setBounds(170, 225, 152, 20);
	PanelOffre.add(cbxEtatOffre);

	btnSaveOffre = new JButton("Enreg.");
	btnSaveOffre.setIcon(new ImageIcon(MainUI.class
		.getResource("/icons/save.png")));
	btnSaveOffre.setHorizontalAlignment(SwingConstants.LEFT);
	btnSaveOffre.setBounds(22, 303, 138, 23);
	PanelOffre.add(btnSaveOffre);

	btnDeleteOffre = new JButton("Supprimer");
	btnDeleteOffre.setIcon(new ImageIcon(MainUI.class
		.getResource("/icons/delete.png")));
	btnDeleteOffre.setHorizontalAlignment(SwingConstants.LEFT);
	btnDeleteOffre.setBounds(22, 337, 138, 23);
	PanelOffre.add(btnDeleteOffre);

	lblNumro = new JLabel("Num\u00E9ro:");
	lblNumro.setBounds(170, 24, 64, 14);
	PanelOffre.add(lblNumro);

	lblOffreNum = new JLabel("Num");
	lblOffreNum.setBounds(244, 24, 78, 14);
	PanelOffre.add(lblOffreNum);

	lblRfrence_1 = new JLabel("R\u00E9f\u00E9rence:");
	lblRfrence_1.setBounds(170, 49, 78, 14);
	PanelOffre.add(lblRfrence_1);

	lblNewLabel_2 = new JLabel("Montant");
	lblNewLabel_2.setBounds(170, 88, 78, 14);
	PanelOffre.add(lblNewLabel_2);

	lblNomDuClient = new JLabel("Nom du client:");
	lblNomDuClient.setBounds(170, 128, 110, 14);
	PanelOffre.add(lblNomDuClient);

	lblDateUltimeDe_1 = new JLabel("Date ultime de validit\u00E9:");
	lblDateUltimeDe_1.setBounds(170, 171, 138, 14);
	PanelOffre.add(lblDateUltimeDe_1);

	lblEtatDeLoffre = new JLabel("Etat de l'offre:");
	lblEtatDeLoffre.setBounds(170, 208, 110, 14);
	PanelOffre.add(lblEtatDeLoffre);

	panelClient = new JPanel();
	tabbedPane.addTab("Client", null, panelClient, null);
	panelClient.setLayout(null);

	panelImmobClient = new JPanel();
	panelImmobClient.setLayout(null);
	panelImmobClient.setBorder(new TitledBorder(UIManager
		.getBorder("TitledBorder.border"), "Immobiliers",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelImmobClient.setBounds(10, 11, 427, 325);
	panelClient.add(panelImmobClient);

	jListImmobsClient = new JList<String>();
	jListImmobsClient.setBounds(10, 22, 118, 246);
	panelImmobClient.add(jListImmobsClient);

	txtReferenceClient = new JTextField();
	txtReferenceClient.setColumns(10);
	txtReferenceClient.setBounds(138, 38, 132, 20);
	panelImmobClient.add(txtReferenceClient);

	txtPrixImmobClient = new JTextField();
	txtPrixImmobClient.setColumns(10);
	txtPrixImmobClient.setBounds(138, 159, 132, 20);
	panelImmobClient.add(txtPrixImmobClient);

	cbxEtatImmobClient = new JComboBox<String>();
	cbxEtatImmobClient.setBounds(138, 79, 132, 20);
	panelImmobClient.add(cbxEtatImmobClient);

	cbxTypeImmobClient = new JComboBox<String>();
	cbxTypeImmobClient.setBounds(138, 120, 132, 20);
	panelImmobClient.add(cbxTypeImmobClient);

	txtAreaDescClient = new JTextArea();
	txtAreaDescClient.setBounds(138, 200, 132, 68);
	panelImmobClient.add(txtAreaDescClient);

	btnPlacerOffre = new JButton("Placer Offre");
	btnPlacerOffre.setHorizontalAlignment(SwingConstants.LEFT);
	btnPlacerOffre.setIcon(new ImageIcon(MainUI.class
		.getResource("/icons/add.png")));
	btnPlacerOffre.setBounds(280, 259, 138, 51);
	panelImmobClient.add(btnPlacerOffre);

	panelSearch = new JPanel();
	panelSearch.setBorder(new TitledBorder(UIManager
		.getBorder("TitledBorder.border"), "Recherche",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelSearch.setBounds(280, 23, 138, 222);
	panelImmobClient.add(panelSearch);
	panelSearch.setLayout(null);

	lblNewLabel = new JLabel("Type:");
	lblNewLabel.setBounds(10, 23, 46, 14);
	panelSearch.add(lblNewLabel);

	cbxTypeImmobSearch = new JComboBox<String>();
	cbxTypeImmobSearch.setBounds(10, 48, 98, 20);
	panelSearch.add(cbxTypeImmobSearch);

	lblPrixMinimum = new JLabel("Prix minimum:");
	lblPrixMinimum.setBounds(10, 79, 98, 14);
	panelSearch.add(lblPrixMinimum);

	txtPrixMinSearch = new JTextField();
	txtPrixMinSearch.setBounds(10, 104, 98, 20);
	panelSearch.add(txtPrixMinSearch);
	txtPrixMinSearch.setColumns(10);

	lblPrixMaximum = new JLabel("Prix maximum:");
	lblPrixMaximum.setBounds(10, 135, 98, 14);
	panelSearch.add(lblPrixMaximum);

	txtPrixMaxSearch = new JTextField();
	txtPrixMaxSearch.setBounds(10, 160, 98, 20);
	panelSearch.add(txtPrixMaxSearch);
	txtPrixMaxSearch.setColumns(10);

	btnSearch = new JButton("");
	btnSearch.setBounds(10, 191, 33, 23);
	panelSearch.add(btnSearch);
	btnSearch.setIcon(new ImageIcon(MainUI.class
		.getResource("/icons/search.png")));

	txtReferenceSearch = new JTextField();
	txtReferenceSearch.setBounds(32, 274, 98, 20);
	panelImmobClient.add(txtReferenceSearch);
	txtReferenceSearch.setColumns(10);

	lblRf = new JLabel("R\u00E9f:");
	lblRf.setBounds(10, 277, 27, 14);
	panelImmobClient.add(lblRf);

	JLabel lblRfrence_2 = new JLabel("R\u00E9f\u00E9rence:");
	lblRfrence_2.setBounds(138, 23, 118, 14);
	panelImmobClient.add(lblRfrence_2);

	JLabel lblNewLabel_3 = new JLabel("Etat:");
	lblNewLabel_3.setBounds(138, 63, 80, 14);
	panelImmobClient.add(lblNewLabel_3);

	JLabel lblType_1 = new JLabel("Type:");
	lblType_1.setBounds(138, 104, 80, 14);
	panelImmobClient.add(lblType_1);

	JLabel lblPrix_1 = new JLabel("Prix:");
	lblPrix_1.setBounds(138, 144, 80, 14);
	panelImmobClient.add(lblPrix_1);

	JLabel lblDescription_1 = new JLabel("Description");
	lblDescription_1.setBounds(138, 184, 112, 14);
	panelImmobClient.add(lblDescription_1);

	panel = new JPanel();
	panel.setBorder(new TitledBorder(null, "D\u00E9tails Client",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel.setBounds(447, 11, 270, 405);
	panelClient.add(panel);
	panel.setLayout(null);

	lblRfrenceImmobilier = new JLabel("R\u00E9f\u00E9rence Immobilier:");
	lblRfrenceImmobilier.setBounds(10, 26, 126, 14);
	panel.add(lblRfrenceImmobilier);

	lblVotreNomEt = new JLabel("Votre nom et pr\u00E9nom:");
	lblVotreNomEt.setBounds(10, 65, 126, 14);
	panel.add(lblVotreNomEt);

	lblVotreMontant = new JLabel("Votre montant:");
	lblVotreMontant.setBounds(10, 105, 105, 14);
	panel.add(lblVotreMontant);

	lblDateUltimeDe = new JLabel("Date Ult. de Val.");
	lblDateUltimeDe.setBounds(10, 147, 126, 14);
	panel.add(lblDateUltimeDe);

	txtOffreImmobRef = new JTextField();
	txtOffreImmobRef.setBounds(10, 41, 132, 20);
	panel.add(txtOffreImmobRef);
	txtOffreImmobRef.setColumns(10);

	txtNomAcheteurClient = new JTextField();
	txtNomAcheteurClient.setBounds(10, 81, 132, 20);
	panel.add(txtNomAcheteurClient);
	txtNomAcheteurClient.setColumns(10);

	txtMontantClient = new JTextField();
	txtMontantClient.setBounds(10, 122, 132, 20);
	panel.add(txtMontantClient);
	txtMontantClient.setColumns(10);

	dateValiditeClient = new JDateChooser();
	dateValiditeClient.setBounds(10, 164, 132, 20);
	panel.add(dateValiditeClient);

	jListOffreClient = new JList<String>();
	jListOffreClient.setBounds(146, 25, 110, 194);
	panel.add(jListOffreClient);

	btnEnvoyerOffre = new JButton("Envoyer");
	btnEnvoyerOffre.setIcon(new ImageIcon(MainUI.class
		.getResource("/icons/yes.png")));
	btnEnvoyerOffre.setHorizontalAlignment(SwingConstants.LEFT);
	btnEnvoyerOffre.setBounds(10, 240, 111, 23);
	panel.add(btnEnvoyerOffre);

	btnAnnulerOffre = new JButton("Annuler");
	btnAnnulerOffre.setIcon(new ImageIcon(MainUI.class
		.getResource("/icons/no.png")));
	btnAnnulerOffre.setHorizontalAlignment(SwingConstants.LEFT);
	btnAnnulerOffre.setBounds(126, 240, 111, 23);
	panel.add(btnAnnulerOffre);

	lblEtatDeVotre = new JLabel("Etat de votre offre:");
	lblEtatDeVotre.setBounds(10, 190, 110, 14);
	panel.add(lblEtatDeVotre);

	lblEtat = new JLabel("New label");
	lblEtat.setBounds(10, 205, 73, 14);
	panel.add(lblEtat);

	panelRendezVous = new JPanel();
	panelRendezVous.setBorder(new TitledBorder(null, "Prennez rendez-vous",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelRendezVous.setBounds(4, 301, 252, 93);
	panel.add(panelRendezVous);
	panelRendezVous.setLayout(null);

	lblRfrenceImmobilier_1 = new JLabel("R\u00E9f\u00E9rence Immobilier:");
	lblRfrenceImmobilier_1.setBounds(10, 21, 135, 14);
	panelRendezVous.add(lblRfrenceImmobilier_1);

	lblImmobRefForContact = new JLabel("New label");
	lblImmobRefForContact.setBounds(155, 21, 111, 14);
	panelRendezVous.add(lblImmobRefForContact);

	lblTlphone = new JLabel("T\u00E9l\u00E9phone:");
	lblTlphone.setIcon(new ImageIcon(MainUI.class
		.getResource("/icons/phone.png")));
	lblTlphone.setBounds(10, 46, 110, 16);
	panelRendezVous.add(lblTlphone);

	lblEmail = new JLabel("Email:");
	lblEmail.setIcon(new ImageIcon(MainUI.class
		.getResource("/icons/at.png")));
	lblEmail.setBounds(10, 68, 67, 16);
	panelRendezVous.add(lblEmail);

	label = new JLabel("0123456");
	label.setBounds(155, 46, 111, 14);
	panelRendezVous.add(label);

	lblExampledomaincom = new JLabel("example@domain.com");
	lblExampledomaincom.setBounds(86, 69, 135, 14);
	panelRendezVous.add(lblExampledomaincom);
    }

    private void listImmobPopulator(List<Immobilier> immobs, JList<String> list) {
	immobListModel.clear();
	if (immobs != null && immobs.size() > 0) {
	    for (Immobilier immob : immobs) {
		immobListModel.addElement(immob.getReference());
	    }
	}
	list.setModel(immobListModel);
    }

    private void listOffrePopulator(List<Offre> offres, JList<String> list) {
	if (!list.getModel().equals(offreListModel)) {
	    offreListModel.clear();
	    if (offres != null && offres.size() > 0) {
		for (Offre offre : offres) {
		    offreListModel.addElement("OffreN" + offre.getId());
		}
	    }
	    list.setModel(offreListModel);
	}
    }

    private void textChanged() {
	if (txtReference.getText().equals("")) {
	    txtReference.setBackground(Color.red);
	} else {
	    txtReference.setBackground(Color.CYAN);
	}
    }

    private Boolean isImmobFormValidForUpload(Boolean newRecord) {

	Boolean isValid = false;
	if (!txtReference.getText().equals("")
		&& (newRecord ? immobImpl.getImmobilierParRef(txtReference
			.getText()) == null : immobImpl
			.getImmobilierParRef(txtReference.getText()) != null)
		&& cbxEtatImmob.getSelectedIndex() != 0
		&& cbxTypeImmob.getSelectedIndex() != 0
		&& currencyValidator(txtPrixImmob.getText())) {
	    isValid = true;
	}
	return isValid;
    }

    public static boolean currencyValidator(String currency) {
	BigDecimalValidator validator = CurrencyValidator.getInstance();

	BigDecimal amount = validator.validate(currency, Locale.US);
	if (amount == null) {
	    return false;
	}
	return true;
    }
}
