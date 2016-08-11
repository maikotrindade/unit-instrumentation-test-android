package maikotrindade.com.br.unitinstrumentationtests.presenter;

import android.support.v4.app.Fragment;

import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.model.dao.UserDAO;
import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.ListFragment;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.ListFragmentView;

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

            User user = new User();
            user.setName(searchText);

            UserDAO userDAO = new UserDAO(((Fragment) mView).getContext());
            userDAO.insert(user);

            reloadListFromDatabase();
        }
    }

    public void reloadListFromDatabase(){
        UserDAO userDAO = new UserDAO(((Fragment)mView).getContext());
        List<User> users = userDAO.findAll();


        ((ListFragment)mView).updateUsersList(users);
    }
}
