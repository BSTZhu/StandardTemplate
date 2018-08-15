package com.standard.library.utils;

import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;

public class IOUtils {

    public static void close(final URLConnection conn) {
        if (conn instanceof HttpURLConnection) {
            ((HttpURLConnection) conn).disconnect();
        }
    }

    public static void closeQuietly(final Closeable... closeables) {
        if (closeables == null) {
            return;
        }
        for (final Closeable closeable : closeables) {
            closeQuietly(closeable);
        }
    }

    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
