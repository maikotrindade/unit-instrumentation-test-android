package maikotrindade.com.br.unitinstrumentationtests.presenter;

/**
 * @author maiko.trindade
 * @since 07/08/2016
 */
public interface BasePresenter<V> {

    void attachView(V view);

    void detachView();

}