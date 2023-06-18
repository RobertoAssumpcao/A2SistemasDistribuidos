import java.rmi.Remote;
import java.rmi.RemoteException;

interface Mensagem_IF extends Remote {
    public String getMensagem() throws RemoteException;

    public void setMensagem(String mensagem) throws RemoteException;
}
