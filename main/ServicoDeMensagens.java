import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServicoDeMensagens extends UnicastRemoteObject implements Mensagem_IF {
    private String mensagem = "Não há nenhuma mensagem";

    public ServicoDeMensagens() throws RemoteException {
    }

    public String getMensagem() throws RemoteException {
        System.out.println("Chamou o método GET: " + this.mensagem);
        return this.mensagem;
    }

    public void setMensagem(String mensagem) throws RemoteException {
        System.out.println("Chamou o método SET: " + mensagem);
        this.mensagem = mensagem;
    }

    public void apagarMensagem() throws RemoteException {
        System.out.println("Mensagem apagada.");
        this.mensagem = "Não há nenhuma mensagem";
    }
}
