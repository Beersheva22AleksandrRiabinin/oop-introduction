package telran.cipher;

public class BaseCipher {
	
	public static final int ASCII_MIN = 33;
	public static final int ASCII_MAX = 126;
	
	private static int[] rdmMemory = new int[ASCII_MAX + 1];
	
	private int keyLength;
	private static String key;
	
	public BaseCipher(int keyLength) {
		this.keyLength = keyLength;
		key = new String(generateKey(keyLength));
		System.out.println("key: " + key);
	}
	
	static String generateKey (int keyLength) {
		if (keyLength < 2) {
			keyLength = 2;
		}
		if (keyLength > ASCII_MAX - ASCII_MIN + 1) {
			keyLength = ASCII_MAX - ASCII_MIN;
		}
		String[] res = new String[keyLength];
		for (int i = 0; i < keyLength; i++) {	
			res[i] = Character.toString(getUniqueRandomInt(ASCII_MIN, ASCII_MAX));
		}
		key = String.join("", res);		
		return key;
	}	
	private static int getUniqueRandomInt(int min,int max) {
		int res = 0;
		do {
			res = (int) (min + Math.random() * (max - min +1));
		} while (rdmMemory[res] != 0);
		rdmMemory[res] = 1;
		return res;
	}
	
	public String cipher(int number) {
		char symbol;
		String cipher = "";
		do {
			symbol = key.charAt(number % keyLength);
			number /= keyLength;
			cipher += Character.toString(symbol);			
		} while (number != 0);
		cipher = new StringBuffer(cipher).reverse().toString();	
		return cipher;
	}	
	public int decipher (String cipher) {		
		int num = 0;
		for (char ch: cipher.toCharArray()) {
			num = num * keyLength + key.indexOf(ch);			
		}
		return num;
	}	

}