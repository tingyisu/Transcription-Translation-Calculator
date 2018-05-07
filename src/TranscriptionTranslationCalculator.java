import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TranscriptionTranslationCalculator {

	private JFrame frame;
	private JTextField dnaStrand;
	private JTextField mRNAStrand;
	private JTextField protein;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TranscriptionTranslationCalculator window = new TranscriptionTranslationCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TranscriptionTranslationCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 989, 767);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTransciptionTranslationCalculator = new JLabel("Transciption & Translation Calculator");
		lblTransciptionTranslationCalculator.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblTransciptionTranslationCalculator.setBounds(111, 11, 779, 70);
		frame.getContentPane().add(lblTransciptionTranslationCalculator);
		
		dnaStrand = new JTextField();
		dnaStrand.setFont(new Font("Tahoma", Font.PLAIN, 40));
		dnaStrand.setBounds(26, 142, 905, 70);
		frame.getContentPane().add(dnaStrand);
		dnaStrand.setColumns(10);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your template (transcribed) DNA strand:");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblPleaseEnterYour.setBounds(26, 95, 861, 39);
		frame.getContentPane().add(lblPleaseEnterYour);
		
		JButton transcribeButton = new JButton("Transcribe");
		transcribeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String mRNA = Transcription.transcribeDNA(dnaStrand.getText()); 
					mRNAStrand.setText(mRNA); 
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter a valid DNA strand (i.e. with A, T, C, G nucleotides only");
				}
			}
		});
		transcribeButton.setFont(new Font("Tahoma", Font.PLAIN, 40));
		transcribeButton.setBounds(26, 240, 439, 70);
		frame.getContentPane().add(transcribeButton);
		
		JButton translateButton = new JButton("Translate");
		translateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String proteinStrand = Translation.translateDNA(dnaStrand.getText());
					protein.setText(proteinStrand); 
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please make sure that you have a valid DNA strand that includes TAC (which will transcribe into AUG, the start codon)");
				}
			}
		});
		translateButton.setFont(new Font("Dialog", Font.PLAIN, 40));
		translateButton.setBounds(492, 240, 439, 70);
		frame.getContentPane().add(translateButton);
		
		JLabel mRNAField = new JLabel("mRNA");
		mRNAField.setFont(new Font("Tahoma", Font.PLAIN, 40));
		mRNAField.setBounds(26, 354, 115, 33);
		frame.getContentPane().add(mRNAField);
		
		mRNAStrand = new JTextField();
		mRNAStrand.setFont(new Font("Tahoma", Font.PLAIN, 40));
		mRNAStrand.setBounds(26, 403, 905, 70);
		frame.getContentPane().add(mRNAStrand);
		mRNAStrand.setColumns(10);
		
		JLabel proteinField = new JLabel("Protein");
		proteinField.setFont(new Font("Tahoma", Font.PLAIN, 40));
		proteinField.setBounds(26, 507, 219, 39);
		frame.getContentPane().add(proteinField);
		
		protein = new JTextField();
		protein.setFont(new Font("Tahoma", Font.PLAIN, 40));
		protein.setBounds(26, 559, 905, 70);
		frame.getContentPane().add(protein);
		protein.setColumns(10);
	}
}
