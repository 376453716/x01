package com.xh.rmi;

import org.apache.log4j.Logger;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 * Created by xionghao on 17/11/2015.
 * implements {@link XService}
 * extends {@link UnicastRemoteObject}
 */
public class XServiceImpl extends UnicastRemoteObject implements XService {
    private static Logger log = Logger.getLogger(XServiceImpl.class);

    public XServiceImpl() throws RemoteException {
    }

    public Date getServerTime() throws RemoteException {
        return new Date();
    }

    public String echoServer(String msg) throws RemoteException {
        log.info("Rmi test...");
        return "Server Echo recived msg:" + msg;
    }
}
