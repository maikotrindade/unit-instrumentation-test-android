package maikotrindade.com.br.unitinstrumentationtests.utils;

import maikotrindade.com.br.unitinstrumentationtests.api.GitHubUserService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joao on 8/16/16.
 */
public class ApiUtils {

    public static GitHubUserService getGitHubUserService(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubUserService service = retrofit.create(GitHubUserService.class);

        return service;
    }

    public static GitHubUserService getGitHubUserAlwaysValidService(){
        //HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
            //.addInterceptor(logging);
            .addInterceptor(new AlwaysReturnsAUserOkHttpInterceptor())
            .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        GitHubUserService service = retrofit.create(GitHubUserService.class);

        return service;
    }

    public static GitHubUserService getGitHubUserAlwaysInvalidService(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                //.addInterceptor(logging)
                .addInterceptor(new AlwaysReturnsInvalidUserOkHttpInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        GitHubUserService service = retrofit.create(GitHubUserService.class);

        return service;
    }
}
