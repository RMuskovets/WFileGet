import java.io.*;
import java.util.*;

public class GetAllComputers {
	private GetAllComputers() {}
	private static String ga() throws Exception {
		Process proc = Runtime.getRuntime().exec("net view");
		String s = "";
		try {
			BufferedInputStream bis = new BufferedInputStream(proc.getInputStream());
			int c;
			while ((c = bis.read()) != -1) s += String.valueOf((char) c);
			} catch (IOException e) {
			System.err.println(e);
			}
		Thread.sleep(50);
		return s;
	}
	public static List<String> getAllPCs() throws Exception {
		Process proc = Runtime.getRuntime().exec("net view");
		String s = ga();
		List<String> all = new ArrayList(Arrays.asList(s.split("\n")));
		all.removeIf(t -> !t.startsWith("\\"));
		all.replaceAll(t -> t.substring(2));
		return all;
	}

	public static void main(String[] args) throws Exception {
		for (String comp : getAllPCs())
			System.out.println(comp);
	}
}