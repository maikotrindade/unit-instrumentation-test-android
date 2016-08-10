package maikotrindade.com.br.unitinstrumentationtests.ui.view;

import android.support.v4.app.Fragment;

/**
 * @author maiko.trindade
 * @since 07/08/2016
 */
public interface MainView {

    void changeFragment(Fragment nextFragment, int titleResourceId);
    void insertUserOnDb(/*User user*/);
    void findAllUsersOnDb();

}