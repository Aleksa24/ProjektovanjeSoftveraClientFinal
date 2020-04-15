/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import Thread.NitZaPrimanjePoruka;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transfer.RequestObject;

/**
 * salje pozive serveru/dok nitZaPrimanjePoruka prima poruke od servera i radi sa njima sta treba
 * @author Aleksa
 */
public class CommunicationController {
    
    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public CommunicationController() {
        try {
            this.socket = new Socket("localhost", 9000);
            this.objectInputStream = new ObjectInputStream(socket.getInputStream()) ;
            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            NitZaPrimanjePoruka.getInstance().setSocket(objectInputStream, socket);
        } catch (IOException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no server connection!!!");
            System.exit(0);
        }
        System.out.println("napravljen je CommunicationController");
    }

    public void sendRequestObject(RequestObject requestObject) throws IOException {
        this.objectOutputStream.writeObject(requestObject);
        this.objectOutputStream.flush();
    }


    
    
    
    
}
