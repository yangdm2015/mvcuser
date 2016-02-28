import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException; 
/**
 * HTTPЭ���������
 * ������Tomcat��ҳ��ҳ��Դ����������
 * �ô˷��������ǿ��Խ����Ƿ��ʵ���ҳ������ݶ�������
 * @author ykn
 *
 */
public class HttpTest { 
    public static void main(String[] args) {
        
        Socket s = null;
        PrintWriter pw = null;
        BufferedReader br = null;
            
        try {
            // �������Ӷ˿ڣ�sָ�򱾵ػ���tomcat�������˿���
            s = new Socket("127.0.0.1",8080);
            // ���ڱ������������������൱����׼����tomcat�������˿�д����
            pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            // �������ҳ�棨�˴���ͬ�ڷ���http://localhost:8888/��    
            pw.println("GET / HTTP/1.1");
            pw.println("Host: www.bjsxt.com");
            pw.println("Content-Type:text/html");
            pw.println("");
            // ��һ���ʾ�������ݽ���
            pw.flush();
            // ������һ�����ڱ�������Tomcat������������������get��
            
            
            // ��������������Ӧ�����ڱ��������������
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str = "";
            // ���������˵���Ӧ��Ϣ��ӡ���������http://localhost:8888/ҳ�����Դ�ļ��е����������
            // �ô˷��������ǿ��Խ����Ƿ��ʵ���ҳ������ݶ�������
            while((str = br.readLine()) != null) {
                System.out.println(str);
            }
            
        } catch (UnknownHostException e) {
            System.out.println("δ֪�������쳣������");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO�쳣������");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                    br = null;
                }
                if (pw != null) {
                    pw.close();
                    pw = null;
                }
                if (s != null) {
                    s.close();
                    s = null;
                }
            } catch (IOException e) {
                System.out.println("IO�쳣������");
                e.printStackTrace();
            }            
        }
    } 
} 