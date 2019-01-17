package dipendra.np.com.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("register.php")
    Call<User>  performRegistration(@Query("email") String email,
                                    @Query("user_name") String userName,
                                    @Query("user_password") String UserPassword);
    @GET("login.php")
    Call<User>  performUserLogin(@Query("user_name") String UserName, @Query("user_password") String UserPassword);
}
