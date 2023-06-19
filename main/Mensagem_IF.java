import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Mensagem_IF extends Remote {
    public String getMensagem() throws RemoteException;

    public void setMensagem(String mensagem) throws RemoteException;

    public void apagarMensagem() throws RemoteException;

    public String criptografar( String a) throws java.rmi.RemoteException;
    
    public String descriptografar ( String a) throws java.rmi.RemoteException;
}
