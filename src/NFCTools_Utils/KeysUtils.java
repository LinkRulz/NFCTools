package NFCTools_Utils;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class KeysUtils {
	public static Set<String> getKeysFromFile(File file) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line = null;
		Set<String> keys = new HashSet<String>();
		while ((line = bufferedReader.readLine()) != null) {
			if (!(line.trim().startsWith("#")) && !line.isEmpty())
				if (HexUtils.isHexadecimalAndNBytes(line, 6))
					keys.add(line.toUpperCase());
		}
		bufferedReader.close();
		return keys;
	}

	public static void addStandardKeys(Set<String> keys) {
		keys.add("FFFFFFFFFFFF");
		keys.add("A0A1A2A3A4A5");
		keys.add("D3F7D3F7D3F7");
	}
}
