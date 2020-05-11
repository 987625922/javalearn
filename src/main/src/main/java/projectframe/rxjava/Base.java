package projectframe.rxjava;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Base {

    public static void main(String[] args) {
        System.out.println("1");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                System.out.println("2");
                Thread.sleep(3000);
                observableEmitter.onNext(2);
                observableEmitter.onComplete();
            }
        }).observeOn(Schedulers.io())
                .subscribeOn(Schedulers.trampoline())
                .observeOn(Schedulers.trampoline()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("3");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        System.out.println("4");

    }

}
