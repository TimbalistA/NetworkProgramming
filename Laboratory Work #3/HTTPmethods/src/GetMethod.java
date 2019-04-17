import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetMethod {
    public void callGetMethod(String request){
        HttpURLConnection httpURLConnection = null;

        try{
            httpURLConnection = (HttpURLConnection) new URL(request).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

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
        } catch (Throwable cause){
            cause.printStackTrace();
        }
    }
}
