import java.rmi.Naming;
import javax.swing.JOptionPane;

public class Cliente2 {
    public static void main(String[] args) {
        try {
            Mensagem_IF obj = (Mensagem_IF) Naming.lookup("rmi://127.0.0.1/servidormsg");
            
            String mensagem = obj.getMensagem();
            JOptionPane.showMessageDialog(null, mensagem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
