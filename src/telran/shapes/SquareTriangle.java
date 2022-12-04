package telran.shapes;

public class SquareTriangle extends Square {
	
	private int size;
	private boolean isLeftDiagonal;

	public SquareTriangle(int size, boolean isLeftDiagonal) {
		super(size);
		this.size = size;
		this.isLeftDiagonal = isLeftDiagonal;
	}	
	public String[] presentation(int offset) {
		String[] res = new String[size];
		System.arraycopy(super.presentation(0), 0, res, 0, size);
		char[][] allLines = new char[size][size];
		for (int i = 0; i < size; i++) {
			char[] oneLine = res[i].toCharArray();
				for (int j = 0; j < oneLine.length; j++) {
					allLines[i][j] = oneLine[j];
					if (j == 0 || i == size - 1) {
						allLines[j][i] = ' ';
					}
					if (i == j) {
						allLines[j][i] = symbol.charAt(0);
					}
				}
		}
		if (isLeftDiagonal) {
			correctionForLeft(res, allLines, offset, size);
		} else {
			correctionForRight(res, allLines, offset, size);
		}
		return res;
	}
	private String[] correctionForLeft(String[] res, char[][] allLines, int offset, int size) {				
			for (int i = 0; i < size; i++) {				
				res[i] = " ".repeat(offset) + new String(allLines[i]);				
			}	
		return res;
	}	
	private String[] correctionForRight(String[] res, char[][] allLines, int offset, int size) {
		int help = size - 1;
		int i = 0;
		while (help > - 1) {
			res[i] = " ".repeat(offset + help) + new String(allLines[i]);	
			i++;
			help--;
		}			
		return res;
	}
}

/*
package telran.shapes;

public class SquareTriangle extends Square {
	
	private int size;
	private boolean isLeftDiagonal;

	public SquareTriangle(int size, boolean isLeftDiagonal) {
		super(size);
		this.size = size;
		this.isLeftDiagonal = isLeftDiagonal;
	}
	
	public String[] presentation(int offset) {
		String[] res = new String[size];
		System.arraycopy(super.presentation(offset), 0, res, 0, size);
		char[][] allLines = new char[size][offset + size];
		for (int i = 0; i < size; i++) {
			char[] oneLine = res[i].toCharArray();
				for (int j = 0; j < oneLine.length; j++) {
					allLines[i][j] = oneLine[j];
				}
		}	
		if (isLeftDiagonal) {
			correctionForLeft(res, allLines, offset, size);
		} else {
			correctionForRight(res, allLines, offset, size);
		}
		return res;
	}

	private String[] correctionForLeft(String[] res, char[][] allLines, int offset, int size) {
		for (int i = offset + size - 1; i > offset; i--) {		
			for (int j = 0; j < size - 1; j++) {
				allLines[j][i] = ' ';
				if (i == j + offset) {
					allLines[j][i] = symbol.charAt(0);
				}
				res[j] = new String(allLines[j]);				
			}
		}		
		return res;
	}
	private String[] correctionForRight(String[] res, char[][] allLines, int offset, int size) {
		for (int i = offset ; i < offset + size - 1; i++) {		
			for (int j = 0; j < size - 1; j++) {
				allLines[j][i] = ' ';
				if (i + j - offset == size - 1) {
					allLines[j][i] = symbol.charAt(0);
				}
				res[j] = new String(allLines[j]);
			}
		}
		return res;
	}

}
*/