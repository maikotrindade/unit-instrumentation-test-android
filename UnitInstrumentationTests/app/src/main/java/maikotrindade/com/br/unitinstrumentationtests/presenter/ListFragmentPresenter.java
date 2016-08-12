package maikotrindade.com.br.unitinstrumentationtests.presenter;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;

import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.api.GitHubUserService;
import maikotrindade.com.br.unitinstrumentationtests.model.dao.UserDAO;
import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.model.version.DatabaseHelper;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.ListFragment;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.ListFragmentView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joao on 8/11/16.
 */
public class ListFragmentPresenter implements BasePresenter<ListFragmentView> {

    private ListFragmentView mView;


    @Override
    public void attachView(ListFragmentView view) {
        mView = view;

        reloadListFromDatabase();
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public void searchForUser(String searchText){
        if( searchText != null && searchText.length() > 0 ) {

            Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

            GitHubUserService service = retrofit.create(GitHubUserService.class);
            if( service != null ) {
                Call<User> userCall = service.getSingleUser(searchText);
                userCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User downloadedUser = response.body();
                        if( downloadedUser != null ) {

                            SQLiteDatabase database = (new DatabaseHelper(((Fragment) mView).getContext())).getWritableDatabase();
                            UserDAO userDAO = new UserDAO(database);
                            userDAO.insert(response.body());

                            reloadListFromDatabase();
                            ((ListFragment) mView).cleanSearchBox();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }

        }
    }

    public void reloadListFromDatabase(){
        SQLiteDatabase database = (new DatabaseHelper(((Fragment) mView).getContext())).getWritableDatabase();
        UserDAO userDAO = new UserDAO(database);
        List<User> users = userDAO.findAll();


        ((ListFragment)mView).updateUsersList(users);
    }
}
