package twii;

import java.io.IOException;
import java.util.stream.Stream;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TWIIBean {

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        String url = "http://www.twse.com.tw/exchangeReport/BWIBBU_d?response=csv&date=20190415&selectType=ALL";
        TWIIBean twiib = new TWIIBean();
        String[] data = twiib.run(url).split("\n");
        System.out.println(data.length);
        Stream.of(data)
                .map(n -> n.replace("\"", ""))
                .map(n -> n.replace("-", "-1"))
                .map(n -> n.split(","))
                .filter(n -> n.length == 8 && !n[0].equals("證券代號"))
                .forEach(n -> System.out.println(n[0] + " " + n[1] + " " + n[2] + " " + n[3] + " " + n[4] + " " + n[5] + " " + n[7]));
    }
}
