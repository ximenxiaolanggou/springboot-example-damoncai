package top.damoncai.remote.utils;

/**
 * @author zhishun.cai
 * @date 2021/1/12 11:34
 */

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;

/**
 * @author zhishun.cai
 * @date 2021/1/11 17:41
 */

public class SSHClient {
    private String ip;
    private String username;
    private String password;

    private String charset = Charset.defaultCharset().toString();
    private static final int TIME_OUT = 1000 * 5 * 60;

    private Connection conn;

    public SSHClient(String ip, String username, String password) {
        this.ip = ip;
        this.username = username;
        this.password = password;
    }

    /**
     * 登录指远程服务器
     * @return
     * @throws IOException
     */
    private boolean login() throws IOException {
        conn = new Connection(ip);
        conn.connect();
        return conn.authenticateWithPassword(username, password);
    }

    public int exec(String shell) throws Exception {
        int ret = -1;
        try {
            if (login()) {
                Session session = conn.openSession();
                session.execCommand(shell);
                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
                ret = session.getExitStatus();
            } else {
                throw new Exception("登录远程机器失败" + ip); // 自定义异常类 实现略
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        try {
            SSHClient sshClient = new SSHClient("192.168.111.8", "root", "Prinfo123!");
            sshClient.exec("/work/add.sh");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}