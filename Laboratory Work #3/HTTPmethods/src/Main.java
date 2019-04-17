import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        GetMethod getMethod = new GetMethod();
        getMethod.callGetMethod("http://httpbin.org/base64/SGksIGl0J3MgR2V0IE1ldGhvZA==");
        PostMethod postMethod = new PostMethod();
        postMethod.callPostMethod("https://httpbin.org/post");
        PutMethod putMethod = new PutMethod();
        putMethod.callPutMethod("https://httpbin.org/put");
    }
}
