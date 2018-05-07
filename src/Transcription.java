import java.util.Arrays;

// transcribes a DNA strand to an mRNA strand 
// translates an mRNA strand to a polypeptide
// assumes that all nucleotides are in CAPS 

public class Transcription {
	
	public static void main(String[] args) {
		// please enter the template (transcribed) strand
		String s = "TACAGCTAGCTATA";
		String transcribed = transcribeDNA(s);
		System.out.println(transcribed);
	}
	
	// transcribes
	public static String transcribeDNA(String DNA) {
		// assume is 5' to 3' 
		// A becomes U 
		// C becomes G
		// G becomes C
		// T becomes A 
		// throw an exception if any one nucleotide is not A, C, G or T
		for (int i = 0; i < DNA.length(); i++) {
			if (DNA.charAt(i) != 'A' && DNA.charAt(i) != 'C' && DNA.charAt(i) != 'G' && DNA.charAt(i) != 'T') {
				throw new IllegalArgumentException(); 
			}
		}
		String mRNA = "";
		for (int i = 0; i < DNA.length(); i++) {
			if (DNA.charAt(i) == 'A') {
				mRNA += "" + 'U';
			} else if (DNA.charAt(i) == 'C') {
				mRNA += "" + 'G';
			} else if (DNA.charAt(i) == 'G') {
				mRNA += "" + 'C';
			} else {
				mRNA += "" + 'A';
			}
		}
		return mRNA;
	}
}
