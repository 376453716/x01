package com.xh.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by xionghao on 17/11/2015.
 * implements {@link Remote}
 * throws {@link RemoteException}
 */
public interface XService extends Remote {

    Date getServerTime() throws RemoteException;

    String echoServer(String msg) throws RemoteException;
}
