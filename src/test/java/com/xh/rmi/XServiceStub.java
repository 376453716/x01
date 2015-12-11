package com.xh.rmi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by xionghao on 20/11/2015.
 */
public class XServiceStub implements XService {
    public Date getServerTime() throws RemoteException {
        try (Socket socket = new Socket("localhost", 7777);
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream())) {
            outputStream.writeObject("date");
            return (Date) inStream.readObject();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String echoServer(String msg) throws RemoteException {
        return null;
    }

    public static void main(String[] args) {
        XService serv = new XServiceStub();
        try {
            System.out.println("stub.getServerTime()===" + serv.getServerTime());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
