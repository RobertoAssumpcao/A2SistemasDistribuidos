import java.rmi.Naming;
import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        try {
            Mensagem_IF obj = (Mensagem_IF) Naming.lookup("rmi://127.0.0.1/servidormsg");

            String tema = JOptionPane.showInputDialog("Digite o tema do ingresso:");
            String data = JOptionPane.showInputDialog("Digite a data do ingresso:");
            String codigo = JOptionPane.showInputDialog("Digite o código do ingresso:");

            String mensagem = "Tema: " + tema + "\nData: " + data + "\nCódigo: " + codigo;
            obj.setMensagem(mensagem);

            JOptionPane.showMessageDialog(null, "Ingresso enviado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
