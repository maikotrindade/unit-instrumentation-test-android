package maikotrindade.com.br.unitinstrumentationtests.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.presenter.AboutFragmentPresenter;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.AboutFragmentView;

/**
 * Created by joao on 8/9/16.
 */
public class AboutFragment extends Fragment implements AboutFragmentView {

    private AboutFragmentPresenter mPresenter;

    private View mRootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_about, container, false);

        mPresenter = new AboutFragmentPresenter();
        mPresenter.attachView(this);

        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        getActivity().setTitle(R.string.fragment_about_title);
    }

}
