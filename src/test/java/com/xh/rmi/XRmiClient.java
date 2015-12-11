package com.xh.rmi;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by xionghao on 17/11/2015.
 */
public class XRmiClient {
    private static Logger log = Logger.getLogger(XRmiClient.class);

    @Test
    public void testRmi() {
        try {
            XService service = (XService) Naming.lookup("rmi://localhost:7890/service");
            log.info("service.getServerTime()-->" + service.getServerTime());
            log.info("service.getServerTime()-->" + service.echoServer("client msg"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
