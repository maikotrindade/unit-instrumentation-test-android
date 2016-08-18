package maikotrindade.com.br.unitinstrumentationtests.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.presenter.ListFragmentPresenter;
import maikotrindade.com.br.unitinstrumentationtests.ui.adapter.UsersListAdapter;
import maikotrindade.com.br.unitinstrumentationtests.ui.component.DividerItemDecoration;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.ListFragmentView;

/**
 * Created by joao on 8/9/16.
 */
public class ListFragment extends Fragment implements ListFragmentView {

    private ListFragmentPresenter mPresenter;
    private View mRootView;
    private Button mButton;
    private TextView mSearchTextView;
    private RecyclerView mRecyclerView;
    private UsersListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View mLightView;
    private ProgressBar mProgressDownload;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_list, container, false);

        mSearchTextView = (TextView) mRootView.findViewById(R.id.search_text);


        bindLightView(mRootView);
        bindProgressDownload(mRootView);

        mButton = (Button) mRootView.findViewById(R.id.search_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoadingList();
                final String searchText = mSearchTextView.getText().toString();
                mPresenter.searchForUser(searchText);
                mSearchTextView.setText("");
            }
        });

        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.list);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(getActivity(), R.drawable.divider));
        mAdapter = new UsersListAdapter(null, getActivity());
        mRecyclerView.setAdapter(mAdapter);

        if (mPresenter == null) {
            mPresenter = new ListFragmentPresenter(null);
        }
        mPresenter.attachView(this);

        return mRootView;
    }

    private void showLoadingList() {
        mProgressDownload.setVisibility(View.VISIBLE);
        mLightView.setVisibility(View.VISIBLE);
    }

    private void bindProgressDownload(View mRootView) {
        mProgressDownload = (ProgressBar) mRootView.findViewById(R.id.progress_user_download);
    }

    private void bindLightView(View mRootView) {
        mLightView = mRootView.findViewById(R.id.light_view);

    }

    @Override
    public void onResume() {
        super.onResume();

        getActivity().setTitle(R.string.fragment_list_title);
    }

    public ListFragmentPresenter getmPresenter() {
        return mPresenter;
    }

    public void setmPresenter(ListFragmentPresenter mPresenter) {
        if (mPresenter != null) {
            this.mPresenter = mPresenter;
        }
    }

    @Override
    public void showUserList(List<User> users) {
        mAdapter.updateDataset(users);
        mAdapter.notifyDataSetChanged();
        hideLoadingList();
    }

    @Override
    public void clearSearchBox() {
        mSearchTextView.setText("");    }

    @Override
    public void downloadErrorUser() {
        hideLoadingList();
    }

    private void hideLoadingList() {
        mLightView.setVisibility(View.GONE);
        mProgressDownload.setVisibility(View.GONE);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        //No call for super(). Bug on API Level > 11.
    }
}
