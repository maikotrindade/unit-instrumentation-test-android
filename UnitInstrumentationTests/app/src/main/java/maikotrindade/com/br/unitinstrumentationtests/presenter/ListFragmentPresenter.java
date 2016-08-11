package maikotrindade.com.br.unitinstrumentationtests.presenter;

import maikotrindade.com.br.unitinstrumentationtests.ui.view.ListFragmentView;

/**
 * Created by joao on 8/11/16.
 */
public class ListFragmentPresenter implements BasePresenter<ListFragmentView> {

    private ListFragmentView mView;


    @Override
    public void attachView(ListFragmentView view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
