import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TryWithResources {
	static final int BUFFER_SIZE = 16; 

	static String firstLineOfFile(String path) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}

	static String firstLineOfFile(String path, String defaultVal) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		} catch(IOException e) { // You can do catch on try-with-resource
			return defaultVal;
		}
	}

	static void copy(String src, String dst) throws IOException{
		try(InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst)) {
				byte[] buf = new byte[BUFFER_SIZE];
				inst n;
				while((n = in.read(buf)) >= 0) {
					out.write(buf, 0, n);
				}
			}
	}
}