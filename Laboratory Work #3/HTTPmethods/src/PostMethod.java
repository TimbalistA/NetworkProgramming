import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class PostMethod {
    public void callPostMethod(String request){
        HttpURLConnection httpURLConnection = null;
       try {
            httpURLConnection = (HttpURLConnection) new URL(request).openConnection();
            httpURLConnection.setRequestMethod("POST");

            Map<String, String> parameters = new HashMap<>();
            parameters.put("name", "Amily New");
            parameters.put("email", "amily.new@gmail.com");
            parameters.put("id", "01234");
            parameters.put("message", "Hi, it's Post Method");

            httpURLConnection.setDoOutput(true);

           DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
           dataOutputStream.writeBytes(ParameterStringBuilder.getParamsString(parameters));
           StringBuilder stringBuilder = new StringBuilder();
           if(HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String line;
                while((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                }
                System.out.println(stringBuilder.toString());
            }else{
                System.out.println("fail: " + httpURLConnection.getResponseCode() + ", " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception exception) {
           exception.printStackTrace();
        }

    }
}
