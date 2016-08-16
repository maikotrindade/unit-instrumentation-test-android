package maikotrindade.com.br.unitinstrumentationtests.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by joao on 8/16/16.
 */
public class AlwaysReturnsAUserOkHttpInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        String url = request.url().encodedPath();

        String username = url;
        Pattern pattern = Pattern.compile("/users/(.*)");
        Matcher matcher = pattern.matcher(url);
        if( matcher.find() ){
            username = matcher.group(1);
        }

        User user = new User();
        user.setName(username);
        user.setId( username.hashCode() );
        user.setLogin( username );

        String json = new Gson().toJson(user);

        Response response = new Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_0)
                .code(200)
                .body(ResponseBody.create(MediaType.parse("text/json"), json)).build();

        return response;
    }
}
