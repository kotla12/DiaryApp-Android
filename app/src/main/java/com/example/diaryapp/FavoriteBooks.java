package com.example.diaryapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FavoriteBooks extends Fragment {
    ListView bookList;
    int[] image = {R.drawable.dave,R.drawable.martian,R.drawable.energy};
    String[] titles = {"The Total Money Makeover: A Proven Plan for Financial Fitness","The Martian","The Science of Energy"};


    @Override // Set the title here:
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Favorite Books");
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favoritebooks, container, false);
        bookList = view.findViewById(R.id.listView);
       ListBooks listOfBooks = new ListBooks();
       bookList.setAdapter(listOfBooks);
       return view;//inflater.inflate(R.layout.fragment_favoritebooks,container,false)

    }
    class ListBooks extends BaseAdapter{
        @Override
        public int getCount() {
            return image.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.listofbooks,null);
            final ImageView mImageView = view.findViewById(R.id.imageView2);
            final TextView mTextView = view.findViewById(R.id.bookImage);
            //Button mButton = view.findViewById(R.id.bookButton);
            mImageView.setImageResource(image[position]);
            mTextView.setText(titles[position]);
            //mButton.setText(titles[position]);
            mTextView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if(mTextView.getText()== "The Martian") {
                        Intent google = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Martian-Andy-Weir/dp/0553418025"));
                        startActivity(google);
                    }
                    if(mTextView.getText()== "The Science of Energy") {
                        Intent google = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Science-Energy-Resources-Power-Explained/dp/B01BVPXLWQ"));
                        startActivity(google);
                    }
                    if(mTextView.getText()== "The Total Money Makeover: A Proven Plan for Financial Fitness") {
                        Intent google = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Total-Money-Makeover-Financial-Fitness/dp/159555078X"));
                        startActivity(google);
                    }
                }
            });
            return view;
        }
    }


}
