package maikotrindade.com.br.unitinstrumentationtests.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.FrontFragment;

/**
 * @author maiko.trindade
 * @since 07/08/2016
 */
public class MainActivity extends AppCompatActivity {

    private LinearLayout mBodyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //https://imguilherme.com/2015/01/25/testes-unitarios-no-android/
        //http://www.orogersilva.com/testes-automatizados-em-android/

        mBodyFragment = (LinearLayout) findViewById(R.id.body_fragment);

        changeFragment(new FrontFragment());
    }

    public boolean changeFragment(Fragment nextFragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.body_fragment, nextFragment);
        fragmentTransaction.commit();
        return false;
    }
}
