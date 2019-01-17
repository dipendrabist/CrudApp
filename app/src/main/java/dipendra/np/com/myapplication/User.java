package dipendra.np.com.myapplication;
//model class

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("response")
    private String Response;


    public String getResponse() {
        return Response;
    }

}
