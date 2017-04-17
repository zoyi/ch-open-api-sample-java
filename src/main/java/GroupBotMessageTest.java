import com.sun.org.apache.xml.internal.utils.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * Created by clsan on 04/10/2016.
 */
public class GroupBotMessageTest {
  public static void main(String args[]) throws Exception {
    String accessKey  = "YOUR_ACCESS_KEY";
    String accessSecret = "YOUR_ACCESS_SECRET";
    String groupName = "YOUR_GROUP_NAME";
    String botName = "YOUR_BOT_NAME";
    String message = "YOUR_MESSAGE";

    StringEntity param = new StringEntity("{" +
        "\"message\":" + "\"" + message + "\"" +
        "}");
    URI uri = new URI("http://api.channel.io/open/groups/@" +
        groupName +
        "/messages?botName=" +
        botName);
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost httpPost = new HttpPost(String.valueOf(uri));
    httpPost.addHeader("X-Access-Key", accessKey);
    httpPost.addHeader("X-Access-Secret", accessSecret);
    httpPost.addHeader("Accept", "application/json");
    httpPost.addHeader("Content-type", "application/json");
    httpPost.setEntity(param);
    HttpResponse response = httpClient.execute(httpPost);

    HttpEntity entity = response.getEntity();
    String content = EntityUtils.toString(entity);
    System.out.println(content);
  }
}
