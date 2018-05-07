import java.util.Arrays;

public class Translation {

	public static void main(String[] args) {
		String s = "TACAGCTAGCTATA";
		System.out.println(translateDNA(s)); 
	}
	
	// assumes there is a start codon
	// if there is no start codon, throw an exception
	public static String translateDNA(String DNA) {
		// transcribe to get mRNA first
		String mRNA = Transcription.transcribeDNA(DNA);
		// find first AUG (i.e. the start codon)
		int index = -1; 
		for (int i = 0; i < mRNA.length() - 2; i++) {
			if (mRNA.charAt(i) == 'A' && mRNA.charAt(i + 1) == 'U' && mRNA.charAt(i + 2) == 'G') {
				index = i;
				break; 
			} 
		}
		System.out.println(index);
		// if there is no start codon, throw an exception
		if (index == -1) {
			throw new IllegalArgumentException();
		} 
		// store the codons in a String array
		// find length of String array needed
		int length = mRNA.length() - index; 
		int mod = length % 3;
		int lengthOfArray = length/3; 
		if (mod != 0) {
			lengthOfArray++;
		}
		String[] codons = new String[lengthOfArray];
		for (int i = 0; i < codons.length; i++) {
			codons[i] = ""; 
		}
		for (int i = 0; i < codons.length; i++) {
			for (int j = index; j < mRNA.length(); j++) {
				if (j == index) {
					codons[i] += "" + mRNA.charAt(j);
				} else if ((j - index) % 3 != 0) {
					codons[i] += "" + mRNA.charAt(j);
				} else {
					i++; 
					codons[i] += "" + mRNA.charAt(j);
				}
			}
		}
		System.out.println(Arrays.toString(codons));
		String protein = "start(Met) "; 
		for (int i = 0; i < codons.length; i++) {
			// if is an incomplete codon, do not store
			if (codons[i].length() < 3) {
				break; 
			}
			// not the start codon
			if (i != 0 && codons.equals("AUG")) {
				protein += "Met ";
			// phe
			} else if (codons[i].equals("UUU") || codons[i].equals("UUC")) {
				protein += "Phe ";
			// leu
			} else if (codons[i].equals("UUA") || codons[i].equals("UUG") || codons[i].equals("CUU") || codons[i].equals("CUC") || codons[i].equals("CUA") || codons[i].equals("CUG")) {
				protein += "Leu ";
			// ser
			} else if (codons[i].equals("UCU") || codons[i].equals("UCC") || codons[i].equals("UCA") || codons[i].equals("UCG") || codons[i].equals("AGU") || codons[i].equals("AGC")) {
				protein += "Ser "; 
			// tyr
			} else if (codons[i].equals("UAU") || codons[i].equals("UAC")) {
				protein += "Tyr ";
			// stop codon, need to break
			} else if (codons[i].equals("UAA") || codons[i].equals("UAG") || codons[i].equals("UGA")) {
				protein += "stop"; 
				break; 
			// Cys
			} else if (codons[i].equals("UGU") || codons[i].equals("UGC")) {
				protein += "Cys ";
			// Trp
			} else if (codons[i].equals("UGG")) {
				protein += "Trp ";
			// Pro
			} else if (codons[i].equals("CCU") || codons[i].equals("CCC") || codons[i].equals("CCA") || codons[i].equals("CCG")) {
				protein += "Pro ";
			// His
			} else if (codons[i].equals("CAU") || codons[i].equals("CAC")) {
				protein += "His ";
			// Gln
			} else if (codons[i].equals("CAA") || codons[i].equals("CAG")) {
				protein += "Gln ";
			// Arg
			} else if (codons[i].equals("CGU") || codons[i].equals("CGC") || codons[i].equals("CGA") || codons[i].equals("CGG") || codons[i].equals("AGA") || codons[i].equals("AGG")) {
				protein += "Arg ";
			// Ile
			} else if (codons[i].equals("AUU") || codons[i].equals("AUC") || codons[i].equals("AUA")) {
				protein += "Ile ";
			// Thr
			} else if (codons[i].equals("ACU") || codons[i].equals("ACC") || codons[i].equals("ACA") || codons[i].equals("ACG")) {
				protein += "Thr ";
			// Asn
			} else if (codons[i].equals("AAU") || codons[i].equals("AAC")) {
				protein += "Asn ";
			// Lys
			} else if (codons[i].equals("AAA") || codons[i].equals("AAG")) {
				protein += "Lys ";
			// Val
			} else if (codons[i].equals("GUU") || codons[i].equals("GUC") || codons[i].equals("GUA") || codons[i].equals("GUG")) {
				protein += "Val ";
			} else if (codons[i].equals("GCU") || codons[i].equals("GCC") || codons[i].equals("GCA") || codons[i].equals("GCG")) {
				protein += "Ala ";
			// Asp
			} else if (codons[i].equals("GAU") || codons[i].equals("GAC")) {
				protein += "Asp ";
			// Glu
			} else if (codons[i].equals("GAA") || codons[i].equals("GAG")) {
				protein += "Glu";
			// Gly
			} else if (codons[i].equals("GGU") || codons[i].equals("GGC") || codons[i].equals("GGA") || codons[i].equals("GGG")){
				protein += "Gly ";
			}
		}
		return protein;
	}
}
