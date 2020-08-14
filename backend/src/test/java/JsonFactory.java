import com.example.demo.entities.Account;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonFactory{
    public enum JsonEnum {
        ACCOUNT,
        PRODUCT,
        ORDER;
    }

    public static String jsonFactory(JsonEnum aJsonEnum) throws JSONException {
        switch (aJsonEnum){
            case ACCOUNT:
                return new JSONObject()
                        .put("email", "mail@test.com")
                        .put("name", "Test")
                        .put("password", "psswd")
                        .toString();
            case ORDER:
                return new JSONObject()

        }
    }
}
