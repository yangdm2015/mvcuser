import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException; 
/**
 * HTTP协议基础测试
 * 本程序将Tomcat首页的页面源代码拿下来
 * 用此方法，我们可以将我们访问到的页面的内容都拿下来
 * @author ykn
 *
 */
public class HttpTest { 
    public static void main(String[] args) {
        
        Socket s = null;
        PrintWriter pw = null;
        BufferedReader br = null;
            
        try {
            // 建立连接端口，s指向本地机器tomcat服务器端口上
            s = new Socket("127.0.0.1",8080);
            // 对于本程序而言是输出，则相当于是准备向tomcat服务器端口写请求
            pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            // 请求访问页面（此处等同于访问http://localhost:8888/）    
            pw.println("GET / HTTP/1.1");
            pw.println("Host: www.bjsxt.com");
            pw.println("Content-Type:text/html");
            pw.println("");
            // 上一句表示请求内容结束
            pw.flush();
            // 上面这一段用于本程序向Tomcat服务器发出访问请求（get）
            
            
            // 服务器端作出响应，对于本程序而言是输入
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str = "";
            // 将服务器端的响应信息打印输出（即将http://localhost:8888/页面代码源文件中的内容输出）
            // 用此方法，我们可以将我们访问到的页面的内容都拿下来
            while((str = br.readLine()) != null) {
                System.out.println(str);
            }
            
        } catch (UnknownHostException e) {
            System.out.println("未知的主机异常。。。");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO异常。。。");
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
                System.out.println("IO异常。。。");
                e.printStackTrace();
            }            
        }
    } 
} 