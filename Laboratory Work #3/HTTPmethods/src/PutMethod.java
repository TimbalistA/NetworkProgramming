import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PutMethod {
    public void callPutMethod(String request){
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(request).openConnection();
            httpURLConnection.setRequestMethod("PUT");

            Map<String, String> parameters = new HashMap<>();
            parameters.put("name", "New New");

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
        }finally {
            if (httpURLConnection != null){
                httpURLConnection.disconnect();
            }
        }

    }
}
