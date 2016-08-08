package maikotrindade.com.br.unitinstrumentationtests.presenter;

import maikotrindade.com.br.unitinstrumentationtests.ui.view.MainView;

/**
 * @author maiko.trindade
 * @since 07/08/2016
 */
public class MainPresenter implements BasePresenter<MainView> {

    private MainView mMainView;

    @Override
    public void attachView(MainView view) {
        mMainView = view;
    }

    @Override
    public void detachView() {
        mMainView = null;
    }
}
