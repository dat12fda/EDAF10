package computer;

import operands.LongWord;
import operands.Word;

public class LongMemory implements Memory {
	private Word[] word;

	public LongMemory(int i) {
		word = new Word[i];
		for(int j = 0; j < i; j++) {
			word[j] = new LongWord(0);
		}
	}

	public Word getWord(int i) {
		return word[i];
	}


}
