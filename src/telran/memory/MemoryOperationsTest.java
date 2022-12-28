package telran.memory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MemoryOperationsTest {
	private static final long MGB = 1024 * 1024;
	byte ar[];	

	@Test
	@Disabled
	void maxMemoryTest() {
		int maxMemory = MemoryOperations.getMaxAvailableMemory();
		ar = new byte[maxMemory];
		ar = null;
		boolean flException = false;
		try {
			ar = new byte[maxMemory + 1];
		} catch(Throwable e) {
			flException = true;
		}
		assertTrue(flException);
	}
//	-Xms50M -Xmx500M 
	@Test	
	void standartMemoryMethods() {
		Runtime runtime = Runtime.getRuntime();
		System.out.printf("Maximal memory JVM may require from OS: %d,"
				+ "current total JVM memory: %d, current free JVM memory: %d", 
				runtime.maxMemory() / MGB, runtime.totalMemory() / MGB, runtime.freeMemory() / MGB);
	}

}
