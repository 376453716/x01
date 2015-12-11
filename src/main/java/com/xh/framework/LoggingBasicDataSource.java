package com.xh.framework;

import net.sf.log4jdbc.ConnectionSpy;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Created by xionghao on 13/11/2015.
 */
public class LoggingBasicDataSource extends BasicDataSource{

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return Logger.getLogger(this.getClass().getName());
    }

    @Override
    public Connection getConnection() throws SQLException {
        return new ConnectionSpy(super.getConnection());
    }
}
