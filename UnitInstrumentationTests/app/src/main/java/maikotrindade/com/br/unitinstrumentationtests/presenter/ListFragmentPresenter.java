package maikotrindade.com.br.unitinstrumentationtests.presenter;

import java.util.Arrays;
import java.util.Date;

import maikotrindade.com.br.unitinstrumentationtests.model.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.ListFragmentView;

/**
 * Created by joao on 8/11/16.
 */
public class ListFragmentPresenter implements BasePresenter<ListFragmentView> {

    private ListFragmentView mView;


    @Override
    public void attachView(ListFragmentView view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public void downloadUsers() {
        mView.showUserList(Arrays.asList(new User("maiko", 0L, "none", "www.google.com", "Maiko " +
                "Trindade", 20L, new Date(), new Date()), new User("joao", 1L, "none", "www" +
                ".facebook.com", "Joao " + "Celso", 10L, new Date(), new Date())));

    }
}
