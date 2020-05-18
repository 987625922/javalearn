import com.google.gson.Gson;
import lombok.Builder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {


        String orderInfoStr = (new Gson()).toJson(Bean.builder().i(1).name("11"));

        String urlString = URLEncoder.encode(orderInfoStr, "UTF-8");
        System.out.println(urlString);

    }

}

@Builder
class Bean {
    String name;
    int i;
}
