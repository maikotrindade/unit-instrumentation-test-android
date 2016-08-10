package maikotrindade.com.br.unitinstrumentationtests.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

import maikotrindade.com.br.unitinstrumentationtests.R;
import maikotrindade.com.br.unitinstrumentationtests.model.persistence.entity.User;
import maikotrindade.com.br.unitinstrumentationtests.presenter.MainPresenter;
import maikotrindade.com.br.unitinstrumentationtests.ui.fragment.FrontFragment;
import maikotrindade.com.br.unitinstrumentationtests.ui.view.MainView;

/**
 * @author maiko.trindade
 * @since 07/08/2016
 */
public class MainActivity extends AppCompatActivity implements MainView {

    private LinearLayout mBodyFragment;
    private MainPresenter mPresenter;
    private Button mBtnInsert;
    private Button mBtnFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //https://imguilherme.com/2015/01/25/testes-unitarios-no-android/
        //http://www.orogersilva.com/testes-automatizados-em-android/
        bindPresenter();
        prepareViews();
        setupButtons();


        changeFragment(new FrontFragment(), 0);
    }

    private void bindPresenter() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
    }

    private void setupButtons() {
        mBtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUserOnDb();
            }
        });

        mBtnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findAllUsersOnDb();
            }
        });
    }

    private void prepareViews() {
        mBodyFragment = (LinearLayout) findViewById(R.id.body_fragment);
        mBtnInsert = (Button) findViewById(R.id.main_button_insert);
        mBtnFind = (Button) findViewById(R.id.main_button_find);
    }


    @Override
    public void changeFragment(Fragment nextFragment, int titleResourceId) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.body_fragment, nextFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void insertUserOnDb() {
        //Test
        User user = new User();
        user.setId(1);
        user.setName("ricardo");
        user.setLogin("sgobbe");
        user.setEmail("email@email.com");
        user.setCompany("company");
        user.setLocation("location");
        user.setTimeCreated("12:25:00");
        user.setTimeUpdated("05:56:00");
        //-----------------------
        mPresenter.insertUser(user);
    }

    @Override
    public void findAllUsersOnDb() {
        mPresenter.findAll();
    }
}
