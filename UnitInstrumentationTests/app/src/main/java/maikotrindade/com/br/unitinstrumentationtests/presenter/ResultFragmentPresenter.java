package maikotrindade.com.br.unitinstrumentationtests.presenter;

import maikotrindade.com.br.unitinstrumentationtests.ui.view.ResultFragmentView;

/**
 * Created by joao on 8/11/16.
 */
public class ResultFragmentPresenter implements BasePresenter<ResultFragmentView> {

    private ResultFragmentView mView;


    @Override
    public void attachView(ResultFragmentView view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
