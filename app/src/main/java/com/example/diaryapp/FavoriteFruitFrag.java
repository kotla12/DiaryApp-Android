package com.example.diaryapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class FavoriteFruitFrag extends Fragment implements View.OnClickListener {
    Button fruitBtn;
    TextView fruitTxt;
    ImageView imageView;
    int clickcount=0;

    @Override // Set the title here:
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Favorite Fruit");
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favoritefruit, container, false);
        fruitBtn = (Button) view.findViewById(R.id.fruitBtn);
        fruitTxt = view.findViewById(R.id.fruitTxt);
        imageView =  view.findViewById(R.id.fruitImg);
        fruitBtn.setOnClickListener(this);



        return view;

        // return inflater.inflate(R.layout.fragment_favoritefruit,container,false);
    }
    @Override
    public void onClick(View v) { // this works when clicked

        clickcount=clickcount+1;

        if(clickcount==1)
        {
            fruitBtn.setBackgroundResource(R.color.Orange);
            fruitTxt.setText("Orange");
            imageView.setImageResource(R.drawable.orange);
        }
        if(clickcount==2)
        {
            fruitBtn.setBackgroundResource(R.color.Kiwi);
            fruitTxt.setText("Kiwi");
            imageView.setImageResource(R.drawable.kiwi);
        }
        if(clickcount==3)    {
            fruitBtn.setBackgroundResource(R.color.GreenApple);
            fruitTxt.setText("Apple");
            imageView.setImageResource(R.drawable.apple);
        }

    }
}
