package com.xh.rmi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;

/**
 * Created by xionghao on 20/11/2015.
 */
public class XServerceSkeleton implements Runnable {

    private XService service;

    private XServerceSkeleton(XService service) {
        this.service = service;
    }

    public void run() {
        try (ServerSocket server = new ServerSocket(7777);
             Socket socket = server.accept();
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());) {
            //request
            String method = (String) inputStream.readObject();
            System.out.println("request...:" + method);
            if ("date".equals(method)) {
                //response
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(service.getServerTime());
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            XServerceSkeleton xServerceSkeleton = new XServerceSkeleton(new XServiceImpl());
            new Thread(xServerceSkeleton).start();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
