package telran.cipher;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CipherTest {	

	@Test
	void cipherTest() {
		BaseCipher basecipher = new BaseCipher(7);
		int num = 124;		
		System.out.println("cipher: " + basecipher.cipher(num));
		System.out.println("decipher num: " + basecipher.decipher((basecipher.cipher(num))));
		assertEquals(num, basecipher.decipher((basecipher.cipher(num))));
	}

}
