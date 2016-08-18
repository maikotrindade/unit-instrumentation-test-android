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
import maikotrindade.com.br.unitinstrumentationtests.utils.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by joao on 8/11/16.
 */
public class ListFragmentPresenter implements BasePresenter<ListFragmentView> {

    private ListFragmentView mView;
    private GitHubUserService gitHubUserService;


    public ListFragmentPresenter(GitHubUserService service){
        if( service == null ){
            gitHubUserService = ApiUtils.getGitHubUserService();
        } else {
            gitHubUserService = service;
        }
    }

    @Override
    public void attachView(ListFragmentView view) {
        mView = view;

        reloadListFromDatabase();
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public GitHubUserService getGitHubUserService() {
        return gitHubUserService;
    }

    public void setGitHubUserService(GitHubUserService gitHubUserService) {
        if( gitHubUserService != null ) {
            this.gitHubUserService = gitHubUserService;
        }
    }

    public void searchForUser(String searchText) {
        if (searchText != null && searchText.length() > 0) {

            if( gitHubUserService != null ) {
                Call<User> userCall = gitHubUserService.getSingleUser(searchText);
                userCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User downloadedUser = response.body();
                        if (downloadedUser == null) {
                            mView.downloadErrorUser();
                            return;
                        }

                        SQLiteDatabase database = (new DatabaseHelper(((Fragment) mView)
                                .getContext())).getWritableDatabase();
                        UserDAO userDAO = new UserDAO(database);
                        userDAO.insert(downloadedUser);

                        reloadListFromDatabase();
                        mView.clearSearchBox();

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        mView.downloadErrorUser();
                    }
                });
            }

        }
    }

    public void reloadListFromDatabase() {
        SQLiteDatabase database = (new DatabaseHelper(((Fragment) mView).getContext()))
                .getWritableDatabase();
        UserDAO userDAO = new UserDAO(database);
        List<User> users = userDAO.findAll();


         mView.showUserList(users);

    }
}
