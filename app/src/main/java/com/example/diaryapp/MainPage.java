package com.example.diaryapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainPage extends Fragment implements View.OnClickListener{

    Button aboutMeBtn;
    Button favoriteFruitBtn;
    Button exitBtn;
    Button favoriteBookBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Dairy");

        View view = inflater.inflate(R.layout.mainpage, container, false);
        aboutMeBtn =  view.findViewById(R.id.aboutMeBtn);
        favoriteFruitBtn =  view.findViewById(R.id.favoriteFruitBtn);
        favoriteBookBtn = view.findViewById(R.id.favoriteBooksBtn);
        exitBtn =  view.findViewById(R.id.exitBtn);
        aboutMeBtn.setOnClickListener(this);
        favoriteFruitBtn.setOnClickListener(this);
        favoriteBookBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
        return view;
       // return inflater.inflate(R.layout.mainpage,container,false); if not working dele every bu this
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aboutMeBtn:
                Fragment fragment1 = new AboutMeFrag();
                moveToFragment(fragment1);
                getActivity().setTitle("About Me");

                break;
            case R.id.favoriteFruitBtn:
                Fragment fragment2 = new FavoriteFruitFrag();
                moveToFragment(fragment2);
                getActivity().setTitle("Favorite Fruit");

                break;
            case R.id.favoriteBooksBtn:
                Fragment fragment3 = new FavoriteBooks();
                moveToFragment(fragment3);
                getActivity().setTitle("Favorite Books");

                break;
            case R.id.exitBtn:
                AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
                adb.setTitle("Confirm Exit");
                adb.setMessage("Do you want to exit this app?");
                adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        getActivity().finish();
                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = adb.create();
                dialog.show();

            break;
        }
    }

    private void moveToFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

    }


}
