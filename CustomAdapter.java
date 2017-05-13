package com.example.siddharth.divinity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by siddharth on 11/5/17.
 */

public class CustomAdapter extends BaseAdapter {

    ArrayList<String> Titles;
    ArrayList<String>  ImgUrls;
    ArrayList<Integer>  ViewCount;
    ArrayList<String>  VideoUrls;
    ArrayList<String>  Type;
    Context context;
//    LayoutInflater inflater;
    String [] arrnames;



    public CustomAdapter(Context applicationContext, ArrayList<String> titles, ArrayList<String> imgUrls, ArrayList<String> type, ArrayList<Integer> viewCount, ArrayList<String> videoUrls) {
//context=applicationContext;
        Toast.makeText(applicationContext,"consturctir",Toast.LENGTH_LONG).show();
        context=applicationContext;
        Titles=titles;
        ImgUrls=imgUrls;
        ViewCount=viewCount;
        Type=type;
        VideoUrls=videoUrls;
        //inflater=LayoutInflater.from(applicationContext);
///arrnames= new String[]{"DDASDASda", "adadadl,d", "dnjdnjbdh"};
        Toast.makeText(applicationContext,"consturctir  1",Toast.LENGTH_LONG).show();
    }


    @Override
    public int getCount() {
        return Titles.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class Holder
    {
        TextView TitleTextView;
        ImageView ImgView;
        Button SaveOffline;
        //TextView ViewCountView;
        String VideoURl;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        Toast.makeText(context,"consturctir    2",Toast.LENGTH_LONG).show();
//        convertView = inflater.inflate(R.layout.trialrowlist, null);
//        TextView countryf1 = (TextView)convertView.findViewById(R.id.f1);
//        TextView iconf2 = (TextView)convertView.findViewById(R.id.f2);
//        TextView iconf3 = (TextView)convertView.findViewById(R.id.f3);
//        countryf1.setText(arrnames[position]);
//        iconf2.setText(arrnames[position]);
//        iconf3.setText(arrnames[position]);
//        return convertView;

//
 //Toast.makeText(context,"Last  get  Step",Toast.LENGTH_LONG).show();
        Holder h=new Holder();
        View rowview=convertView;
        if(rowview==null){
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            rowview=vi.inflate(R.layout.video_row,null);


        }
        h.TitleTextView= (TextView) rowview.findViewById(R.id.Titletext);
        h.ImgView= (ImageView) rowview.findViewById(R.id.img);
        h.SaveOffline= (Button) rowview.findViewById(R.id.saveofflinebtn);
        if(Type.get(position).toString().toLowerCase().equals("yv"))
       // h.ViewCountView= (TextView) rowview.findViewById(R.id.viewcountTextView);
        {

            h.SaveOffline.setVisibility(View.GONE);

        }


        rowview.setTag(h);
        







        h.TitleTextView.setText(""+ Titles.get(position));
        //Glide.with(context).load("http://imgur.com/gallery/DdA2y").placeholder(R.drawable.women1).into(h.ImgView);
        //h.ViewCountView.setText(""+ViewCount.get(position));


        Glide
                .with(context)
                .load(ImgUrls.get(position))
                .centerCrop()
                .placeholder(R.drawable.women1)
                .crossFade()
                .into(h.ImgView);

        //  Toast.makeText(context,"Last Step",Toast.LENGTH_LONG).show();
        return rowview;
    }










       // view = vi.inflate(R.layout.movie_data_row, null);
        //rowview=vi.inflate(R.layout.video_row,null);

           // LayoutInflater lf=LayoutInflater.from(context);




}
