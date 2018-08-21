package com.standard.library.utils.socket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.standard.library.utils.basic.IOUtils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketUtils {

    // 线程池
    private ExecutorService mThreadPool;// 初始化线程池
    // Socket变量
    private Socket mSocket;

    // 输入流对象
    private InputStream mInStream;
    // 输出流对象
    private OutputStream mOutStream;

    // 输入流读取器对象
    private InputStreamReader mInStreamReader;
    private BufferedReader mBufferedReader;
    private DataInputStream mDataInputStream;

    // 接收服务器发送过来的消息
    private String mResult;
    private Timer mReceiverTimer = new Timer();

    private static SocketUtils sInstance;
    private Timer mPushDefaultTimer = new Timer();

    private Context mContext;

    public static SocketUtils getInstance() {
        if (sInstance == null) {
            sInstance = new SocketUtils();
        }
        return sInstance;
    }

    private SocketUtils() {
        mThreadPool = Executors.newCachedThreadPool();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public void initSocket(Context context) {
        mContext = context;

        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // 创建Socket对象 & 指定服务端的IP 及 端口号
                    mSocket = new Socket("192.168.8.186", 8080);

                    // 判断客户端和服务器是否连接成功
                    Log.e("socket", mSocket.isConnected() + "");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void startReceive() {
        // 利用线程池直接开启一个线程 & 执行该线程
        mReceiverTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (mSocket == null || mSocket.isClosed()) {
                                return;
                            }
                            mInStream = mSocket.getInputStream();

                            // 该对象作用：获取服务器返回的数据

                            mInStreamReader = new InputStreamReader(mInStream);
                            mBufferedReader = new BufferedReader(mInStreamReader);

                            mDataInputStream = new DataInputStream(mInStream);
                            //读取长度，也即是消息头，
                            int len = mDataInputStream.available();
                            //创建这个长度的字节数组
                            byte[] bytes = new byte[len];
                            //再读取这个长度的字节数，也就是真正的消息体
                            mDataInputStream.readFully(bytes);
                            //将字节数组转为String
                            mResult = new String(bytes);
                            System.out.println(mResult);

                            if (!TextUtils.isEmpty(mResult)) {

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }, 500, 1000);
    }

    public void pushDefaultMsg(final String msg) {
        // 利用线程池直接开启一个线程 & 执行该线程
        mPushDefaultTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (mSocket == null) {
                                return;
                            }
                            // 步骤1：从Socket 获得输出流对象OutputStream
                            // 该对象作用：发送数据
                            mOutStream = mSocket.getOutputStream();

                            // 步骤2：写入需要发送的数据到输出流对象中
                            mOutStream.write((msg + "\n").getBytes("GBK"));
                            // 特别注意：数据的结尾加上换行符才可让服务器端的readline()停止阻塞

                            // 步骤3：发送数据到服务端
                            mOutStream.flush();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }, 500, 15000);
    }

    public void pushMsg(final String json) {
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if (mSocket == null) {
                        return;
                    }
                    // 步骤1：从Socket 获得输出流对象OutputStream
                    // 该对象作用：发送数据
                    mOutStream = mSocket.getOutputStream();

                    // 步骤2：写入需要发送的数据到输出流对象中
                    mOutStream.write((json + "\n").getBytes("GBK"));
                    // 特别注意：数据的结尾加上换行符才可让服务器端的readline()停止阻塞

                    // 步骤3：发送数据到服务端
                    mOutStream.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public boolean isConnected() {
        return mSocket != null && mSocket.isConnected();
    }

    public boolean isClosed() {
        return mSocket != null && mSocket.isClosed();
    }

    public void cancelSocket() {
        try {
            if (mSocket != null && mSocket.isConnected()) {
                mSocket.close();
            }
            if (mReceiverTimer != null) {
                mReceiverTimer.cancel();
            }
            if (mPushDefaultTimer != null) {
                mPushDefaultTimer.cancel();
            }
            IOUtils.closeQuietly(mDataInputStream, mBufferedReader, mInStreamReader, mInStream, mOutStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
