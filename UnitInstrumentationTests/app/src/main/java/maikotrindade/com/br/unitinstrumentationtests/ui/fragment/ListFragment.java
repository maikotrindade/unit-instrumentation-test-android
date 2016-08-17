package maikotrindade.com.br.unitinstrumentationtests.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.presenter.ListFragmentPresenter;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.ListFragmentView;

/**
 * Created by joao on 8/9/16.
 */
public class ListFragment extends Fragment implements ListFragmentView{

    private ListFragmentPresenter mPresenter;
    private View mRootView;
    private Button mButton;
    private RecyclerView recyclerViewUsers;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_list, container, false);

        bindPresenter();
        bindButtonDownload();
        bindRecyclerViewUsers();


        return mRootView;
    }

    private void bindRecyclerViewUsers() {
        recyclerViewUsers = (RecyclerView) mRootView.findViewById(R.id.recycler_view_users);

    }

    private void bindPresenter() {
        mPresenter = new ListFragmentPresenter();
        mPresenter.attachView(this);
    }

    private void bindButtonDownload() {
        mButton = (Button) mRootView.findViewById(R.id.search_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.downloadUsers();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        getActivity().setTitle(R.string.fragment_list_title);
    }

    @Override
    public void showUserList(List<User> users) {

    }
}
