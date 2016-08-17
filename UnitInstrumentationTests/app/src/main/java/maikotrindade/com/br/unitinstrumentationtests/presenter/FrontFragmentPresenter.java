package maikotrindade.com.br.unitinstrumentationtests.presenter;

import maikotrindade.com.br.unitinstrumentationtests.ui.view.FrontFragmentView;

/**
 * Created by joao on 8/11/16.
 */
public class FrontFragmentPresenter implements BasePresenter<FrontFragmentView> {

    private FrontFragmentView mView;


    @Override
    public void attachView(FrontFragmentView view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
