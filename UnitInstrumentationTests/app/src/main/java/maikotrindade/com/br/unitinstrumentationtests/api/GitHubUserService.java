package maikotrindade.com.br.unitinstrumentationtests.api;

import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by joao on 8/11/16.
 */
public interface GitHubUserService {
    @GET("users/{user}")
    Call<User> getSingleUser(@Path("user") String user);
}
