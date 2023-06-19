import java.rmi.Naming;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
    public static void main(String[] args) {
        try {
            Mensagem_IF obj = (Mensagem_IF) Naming.lookup("rmi://127.0.0.1/servidormsg");

            String tema = JOptionPane.showInputDialog(null, "Digite o tema do ingresso:", "Mensagem para Cliente2", JOptionPane.PLAIN_MESSAGE);
            if (tema == null || tema.isEmpty()) {
                System.out.println("Operação cancelada. Encerrando o Cliente1.");
                return;
            }

            String dataStr = JOptionPane.showInputDialog(null, "Digite a data do ingresso (dd/MM/yyyy):", "Mensagem para Cliente2", JOptionPane.PLAIN_MESSAGE);
            if (dataStr == null || dataStr.isEmpty()) {
                System.out.println("Operação cancelada. Encerrando o Cliente1.");
                return;
            }

            String codigo = JOptionPane.showInputDialog(null, "Digite o código do ingresso:", "Mensagem para Cliente2", JOptionPane.PLAIN_MESSAGE);
            if (codigo == null || codigo.isEmpty()) {
                System.out.println("Operação cancelada. Encerrando o Cliente1.");
                return;
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);

            Date data = null;
            boolean dataValida = false;

            while (!dataValida) {
                try {
                    data = dateFormat.parse(dataStr);
                    dataValida = true;
                } catch (Exception e) {
                    dataStr = JOptionPane.showInputDialog(null, "Data inválida! Digite a data do ingresso novamente (dd/MM/yyyy):", "Mensagem para Cliente2", JOptionPane.PLAIN_MESSAGE);
                    if (dataStr == null || dataStr.isEmpty()) {
                        System.out.println("Operação cancelada. Encerrando o Cliente1.");
                        return;
                    }
                }
            }

            String mensagem = "Tema: " + obj.criptografar(tema) + "\nData: " + dateFormat.format(data) + "\nCódigo: " + obj.criptografar(codigo);
            obj.setMensagem(mensagem);

            JOptionPane.showMessageDialog(null, "Ingresso enviado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
