package maikotrindade.com.br.unitinstrumentationtests.utils;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by joao on 8/16/16.
 */
public class AlwaysReturnsInvalidUserOkHttpInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        class GitHubMessage {
            public String message;
            public String documentation_url;
        }

        GitHubMessage gitHubMessage = new GitHubMessage();
        gitHubMessage.message = "Not Found";
        gitHubMessage.documentation_url = "https://developer.github.com/v3";

        String json = new Gson().toJson(gitHubMessage);

        Response response = new Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_0)
                .code(200)
                .body(ResponseBody.create(MediaType.parse("text/json"), json)).build();

        return response;
    }
}
