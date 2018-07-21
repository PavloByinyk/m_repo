package com.example.gottgried.rxdagger2_maps.modules.home;

import com.example.gottgried.rxdagger2_maps.base.mvp.IBasePresenter;
import com.example.gottgried.rxdagger2_maps.base.mvp.IBaseView;
import com.example.gottgried.rxdagger2_maps.pojo.Result;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Gottgried on 26.06.2018.
 */

public interface IMapContract {

    interface IView extends IBaseView{

        void onMapLoaded(List<Result> maps);

        void onShowDialog(String s);

        void onHideDialog();

        void onShowToast(String error);
    }

    interface IPresenter extends IBasePresenter{

    }

    interface IModel{}

}
