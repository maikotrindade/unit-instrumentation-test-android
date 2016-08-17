package maikotrindade.com.br.unitinstrumentationtests.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.ui.activity.MainActivity;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.UserFragment;

/**
 * Created by joao on 8/11/16.
 */
public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ViewHolder> {

    private List<User> mDataset;
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;

        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }

    public UsersListAdapter(List<User> myDataset, Activity activity) {
        updateDataset(myDataset);
        mActivity = activity;
    }

    public void updateDataset(List<User> myDataset) {
        if (myDataset == null) {
            myDataset = new ArrayList<>();
        }
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = mDataset.get(position);

        TextView userNameTextView = (TextView) holder.mView.findViewById(R.id.user_name);
        userNameTextView.setText(user.getName());
        TextView userLoginTextView = (TextView) holder.mView.findViewById(R.id.user_login);
        userLoginTextView.setText("@" + user.getLogin());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final UserFragment userFragment = UserFragment.newInstance(user);
                ((MainActivity) mActivity).changeFragment(userFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
