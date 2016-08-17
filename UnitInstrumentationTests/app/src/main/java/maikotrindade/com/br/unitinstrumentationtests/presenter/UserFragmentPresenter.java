package maikotrindade.com.br.unitinstrumentationtests.presenter;

import maikotrindade.com.br.unitinstrumentationtests.ui.view.UserFragmentView;

/**
 * @author maiko.trindade
 * @since 16/08/2016
 */
public class UserFragmentPresenter implements BasePresenter<UserFragmentView> {

    private UserFragmentView mView;

    @Override
    public void attachView(UserFragmentView view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}