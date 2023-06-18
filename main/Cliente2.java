import java.rmi.Naming;
import javax.swing.JOptionPane;

public class Cliente2 {
    public static void main(String[] args) {
        try {
            Mensagem_IF obj = (Mensagem_IF) Naming.lookup("rmi://127.0.0.1/servidormsg");

            while (true) {
                String mensagem = obj.getMensagem();
                if (!mensagem.equals("Não há nenhuma mensagem")) {
                    JOptionPane.showMessageDialog(null, mensagem, "Mensagem de Cliente1", JOptionPane.PLAIN_MESSAGE);
                    obj.apagarMensagem();
                    break;
                } else {
                    System.out.println("Aguardando mensagem do Cliente1...");
                    Thread.sleep(1000); // Aguarda 1 segundo antes de verificar novamente
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
