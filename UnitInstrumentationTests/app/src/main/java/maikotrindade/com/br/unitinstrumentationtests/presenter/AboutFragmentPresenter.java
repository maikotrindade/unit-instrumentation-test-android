package maikotrindade.com.br.unitinstrumentationtests.presenter;

import maikotrindade.com.br.unitinstrumentationtests.ui.view.AboutFragmentView;

/**
 * Created by joao on 8/11/16.
 */
public class AboutFragmentPresenter implements BasePresenter<AboutFragmentView> {

    private AboutFragmentView mView;


    @Override
    public void attachView(AboutFragmentView view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
