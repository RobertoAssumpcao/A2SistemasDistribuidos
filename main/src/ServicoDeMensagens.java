import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServicoDeMensagens extends UnicastRemoteObject implements Mensagem_IF {
    private String mensagem = "Não há nenhuma mensagem";

    public ServicoDeMensagens() throws RemoteException {
    }

    public String getMensagem() throws RemoteException {
        System.out.println("Chamou o metodo GET: " + this.mensagem);
        return this.mensagem;
    }

    public void setMensagem(String mensagem) throws RemoteException {
        System.out.println("Chamou o metodo SET: " + mensagem);
        this.mensagem = mensagem;
    }
}
