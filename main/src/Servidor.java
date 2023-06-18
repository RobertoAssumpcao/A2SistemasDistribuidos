import java.rmi.Naming;

public class Servidor {
    public static void main(String[] args) {
        try {
            Mensagem_IF servidor = new ServicoDeMensagens();
            Naming.rebind("servidormsg", servidor);
            System.out.println("Servidor de mensagens no ar.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
