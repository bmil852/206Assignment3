import java.io.InputStream;

public class FileHandler {
	
	public FileHandler() {
		
	}
	
	public InputStream getFileAsInputStream(String filename) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream(filename);
		return is;
	}
	
}
