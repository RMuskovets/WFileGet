import javax.swing.JTable;

public class test {
	public static void main(String[] args) {
		System.out.println(new JTable().getModel().getClass().getName());
	}
}