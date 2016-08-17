package maikotrindade.com.br.unitinstrumentationtests.presenter;

import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.model.persistence.dao.UserDAO;
import maikotrindade.com.br.unitinstrumentationtests.model.persistence.entity.User;
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
        userDao = UserDAO.getInstance();
        userDao.insert(user);
    }

    public List<User> findAll(){
        userDao = UserDAO.getInstance();
        return userDao.findAll();
    }

    public User findUserById(int id){
        userDao = UserDAO.getInstance();
        return userDao.findUserById(id);
    }


}
