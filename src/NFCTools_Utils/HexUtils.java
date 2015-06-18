package NFCTools_Utils;



public class HexUtils {
	public static String convertASCIIToHex(String str) {
		char[] chars = str.toCharArray();
		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			hex.append(Integer.toHexString((int) chars[i]));
		}
		return hex.toString();
	}

	public static String convertHexToASCII(String hex) {

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		for (int i = 0; i < hex.length() - 1; i += 2) {

			String output = hex.substring(i, (i + 2));
			int decimal = Integer.parseInt(output, 16);
			sb.append((char) decimal);
			temp.append(decimal);
		}
		return sb.toString();
	}

	public static boolean isHexadecimal(String hexadecimal) {
		return hexadecimal.matches("^[0-9A-Fa-f]+$");
	}

	public static boolean isHexadecimalAndNBytes(String hexadecimal, int bytes) {
		if (!isHexadecimal(hexadecimal))
			return false;
		double bytesCalculated = (double) hexadecimal.length() / (double) 2;
		if (bytesCalculated != (double) bytes)
			return false;
		return true;
	}

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
					.digit(s.charAt(i + 1), 16));
		}
		return data;
	}
}
