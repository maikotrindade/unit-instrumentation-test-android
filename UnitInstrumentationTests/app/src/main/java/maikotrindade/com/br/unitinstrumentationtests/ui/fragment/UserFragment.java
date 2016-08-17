package maikotrindade.com.br.unitinstrumentationtests.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.presenter.UserFragmentPresenter;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.UserFragmentView;

/**
 * @author maiko.trindade
 * @since 16/08/2016
 */
public class UserFragment extends Fragment implements UserFragmentView {

    private final static String TAG = UserFragment.class.getSimpleName();

    private UserFragmentPresenter mPresenter;
    private static UserFragment sInstance;
    private View mRootView;

    public static UserFragment newInstance(final User user) {
        sInstance = new UserFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("user", user);
        sInstance.setArguments(bundle);
        return sInstance;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_user, container, false);
        mPresenter = new UserFragmentPresenter();
        final User user = getArguments().getParcelable("user");
        configureElements(user);
        mPresenter.attachView(this);
        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.fragment_user_title);
    }

    private void configureElements(final User user) {
        getActivity().setTitle(user.getName());

        final ImageView avatarImgView = (ImageView) mRootView.findViewById(R.id.avatar_image_view);
        Picasso.with(getContext())
                .load(user.getAvatarUrl())
                .placeholder(R.drawable.githubuser)
                .into(avatarImgView);

        final TextView usernameTxtView = (TextView) mRootView.findViewById(R.id.user_name);
        usernameTxtView.setText(user.getName());

        final TextView userLoginTxtView = (TextView) mRootView.findViewById(R.id.user_login);
        userLoginTxtView.setText("@" + user.getLogin());

        final TextView userLocationTxtView = (TextView) mRootView.findViewById(R.id.user_location);
        userLocationTxtView.setText(user.getLocation());
    }

}
