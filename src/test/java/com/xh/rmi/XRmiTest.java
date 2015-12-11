package com.xh.rmi;

import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by xionghao on 17/11/2015.
 */
public class XRmiTest {

    public static void main(String[] args) {
        try {
            XService service = new XServiceImpl();
            LocateRegistry.createRegistry(7890);
            Naming.bind("rmi://localhost:7890/service", service);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
