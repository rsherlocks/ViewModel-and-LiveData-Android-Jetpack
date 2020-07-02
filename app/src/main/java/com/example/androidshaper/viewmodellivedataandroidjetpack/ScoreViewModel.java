package com.example.androidshaper.viewmodellivedataandroidjetpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {

//    Integer score;
    //ViewModel
//    public Integer getScore() {
//        if(score==null)
//        {
//            score=0;
//        }
//        return score;
//    }
    public MutableLiveData<Integer> score;

    public MutableLiveData<Integer> getScore() {
        if (score==null)
        {
            score=new MutableLiveData<>();
            score.setValue(0);
        }

        return score;
    }

    public void addScore()
    {
//        if(score==null)
//        {
//            score=0;
//        }
//        score+=1;
        if (score!=null)
        {
            score.setValue(score.getValue()+1);
        }
    }
    public void resetScore()
    {
//        score=0;
        score.setValue(0);
    }

}
