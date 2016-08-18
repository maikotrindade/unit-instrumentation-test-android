package maikotrindade.com.br.unitinstrumentationtests.presenter;

import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.model.dao.UserDAO;
import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.MainView;

/**
 * @author maiko.trindade
 * @since 07/08/2016
 */
public class MainPresenter implements BasePresenter<MainView> {

    private MainView mMainView;
    private UserDAO userDao;

    @Override
    public void attachView(MainView view) {
        mMainView = view;
    }

    @Override
    public void detachView() {
        mMainView = null;
    }



    public void insertUser(User user){
        userDao = new UserDAO();
        userDao.insert(user);
    }

    public List<User> findAll(){
        userDao = new UserDAO();
        return userDao.findAll();
    }

    public User findUserById(int id){
        userDao = new UserDAO();
        return userDao.findUserById(id);
    }


}
