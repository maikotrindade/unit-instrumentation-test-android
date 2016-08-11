package maikotrindade.com.br.unitinstrumentationtests.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.presenter.FrontFragmentPresenter;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.FrontFragmentView;

/**
 * Created by joao on 8/9/16.
 */
public class FrontFragment extends Fragment implements FrontFragmentView {

    private FrontFragmentPresenter mPresenter;
    private View mRootView;
    private Button mButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_front, container, false);
        mButton = (Button) mRootView.findViewById(R.id.about_button);

        mPresenter = new FrontFragmentPresenter();
        mPresenter.attachView(this);

        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        getActivity().setTitle(R.string.fragment_front_title);
    }

    @Override
    public void setButtonListener(View.OnClickListener onClickListener) {
        mButton.setOnClickListener(onClickListener);
    }
}
