package com.example.android_project.utils.rx

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject

class RxJavaExample {


    fun observableJustOne(){
        val developers: Observable<String> = Observable.just(
            "IOS",
            "Androir",
            "Flutter"
        )
        developers.doAfterNext {
            Log.w("next", it)
        }.doOnError {

        }.doOnComplete{
            Log.w("completed", "finish")
        }.subscribe()
    }
    fun observableJustTwo(){
        val developersAnotherWay: Observable<String> = Observable.just(
            "IOS",
            "Androir",
            "Flutter",
        )
        developersAnotherWay.subscribe(
            { Log.w("next", it) },
            {  },
            {Log.w("completed", "finish") }
        )
    }
    fun observableJustThree() {
        val developerFlatMap = Observable.just("IOS", "Androir", "Flutter")
            .subscribeOn(Schedulers.io())
            .flatMap {
                Observable.just("$it 2")
                    .subscribeOn(Schedulers.io())
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.w("result", it.toString())
            }
    }
    fun observableJustFor(){
        Observable.zip(
            Observable.just("IOS", "Androir", "Flutter"),
            Observable.just("Swift","Kotlin","Java")
        ){dev, lang ->
            "$dev writes is $lang"
        }.subscribe({Log.w("result",it)})
    }
    fun observableJustFive(){
        val devs = Observable.just("IOS", "Androir", "Flutter")
        val langs =Observable.just("Swift","Kotlin","Dart")
        val comps = Observable.just("Apple", "Goole")

        Observable.concat(devs, langs, comps)
            .subscribe { Log.w("result concat", it.toString())}
    }
    fun observableJustSixe(){
        val devList = listOf<String>("IOS", "Androir", "Flutter")

        Observable.create<String> {emitter ->
            devList.forEach {developers->
                if (developers.isEmpty()){
                    emitter.onError(Exception("value is empty"))
                }
                emitter.onNext(developers)
            }
        }.doAfterNext {
            Log.w("next", it)
        }.doOnError {
        }.doOnComplete {
            Log.w("complete for create", "finished")
        }.subscribe({},{Log.w("error", it.message.toString())})
    }

    fun publishSubject(){
        val publishSubject = PublishSubject.create<Int>()
        publishSubject.onNext(1)
        publishSubject.onNext(2)
        publishSubject.onNext(3)
        publishSubject.subscribe({Log.w("pablich value", it.toString())})
        publishSubject.onNext(4)
        publishSubject.onNext(5)
        publishSubject.subscribe({Log.w("pablich value2", it.toString())})
    }

    fun replaySubject(){
        val replaySubject = ReplaySubject.create<Int>()
        replaySubject.onNext(1)
        replaySubject.onNext(2)
        replaySubject.onNext(3)
        replaySubject.subscribe({ Log.w("pablich value", it.toString()) })
        replaySubject.onNext(4)
        replaySubject.onNext(5)
        replaySubject.subscribe({ Log.w("pablich value2", it.toString()) })
    }

    fun behaviorSubject(){
        val behaviorSubject = BehaviorSubject.create<Int>()
        behaviorSubject.onNext(1)
        behaviorSubject.onNext(2)
        behaviorSubject.onNext(3)
        behaviorSubject.subscribe({ Log.w("pablich value", it.toString()) })
        behaviorSubject.onNext(4)
        behaviorSubject.subscribe({ Log.w("pablich value2", it.toString()) })
        behaviorSubject.onNext(5)
    }

    fun asyncSubject(){
        val asyncSubject = AsyncSubject.create<Int>()
        asyncSubject.onNext(1)
        asyncSubject.onNext(2)
        asyncSubject.onNext(3)
        asyncSubject.subscribe({ Log.w("pablich value", it.toString()) })
        asyncSubject.onNext(4)
        asyncSubject.subscribe({ Log.w("pablich value2", it.toString()) })
        asyncSubject.onNext(5)
        asyncSubject.onComplete()
    }

}