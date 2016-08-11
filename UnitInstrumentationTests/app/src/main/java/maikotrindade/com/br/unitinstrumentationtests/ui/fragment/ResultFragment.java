package maikotrindade.com.br.unitinstrumentationtests.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.presenter.ResultFragmentPresenter;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.ResultFragmentView;

/**
 * Created by joao on 8/9/16.
 */
public class ResultFragment extends Fragment implements ResultFragmentView {

    private ResultFragmentPresenter mPresenter;
    private View mRootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_result, container, false);

        mPresenter = new ResultFragmentPresenter();
        mPresenter.attachView(this);

        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        getActivity().setTitle(R.string.fragment_result_title);
    }

}
