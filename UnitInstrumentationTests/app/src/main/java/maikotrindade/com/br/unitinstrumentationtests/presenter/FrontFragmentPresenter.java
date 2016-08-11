package maikotrindade.com.br.unitinstrumentationtests.presenter;

import android.support.v4.app.Fragment;
import android.view.View;

import maikotrindade.com.br.unitinstrumentationtests.ui.MainActivity;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.ListFragment;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.FrontFragmentView;

/**
 * Created by joao on 8/11/16.
 */
public class FrontFragmentPresenter implements BasePresenter<FrontFragmentView> {

    private FrontFragmentView mView;


    @Override
    public void attachView(FrontFragmentView view) {
        mView = view;

        mView.setButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)((Fragment)mView).getActivity()).changeFragment(new ListFragment());
            }
        });
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
