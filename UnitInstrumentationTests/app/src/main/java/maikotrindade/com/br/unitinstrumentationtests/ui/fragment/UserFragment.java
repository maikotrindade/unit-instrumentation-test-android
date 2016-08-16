package maikotrindade.com.br.unitinstrumentationtests.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.presenter.UserFragmentPresenter;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.UserFragmentView;

/**
 * @author maiko.trindade
 * @since 16/08/2016
 */
public class UserFragment extends Fragment implements UserFragmentView {

    private UserFragmentPresenter mPresenter;

    private View mRootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_user, container, false);

        mPresenter = new UserFragmentPresenter();
        mPresenter.attachView(this);

        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.fragment_user_title);
    }

}
