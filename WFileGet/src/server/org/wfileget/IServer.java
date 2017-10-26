package server.org.wfileget;



public interface IServer {

	Object readObject(String host, String file);

	default String readText(String host, String file) { return (String) readObject(host, file); }
}