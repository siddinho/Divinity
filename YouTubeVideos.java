package com.example.siddharth.divinity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class YouTubeVideos extends AppCompatActivity {
    ArrayList<String>  Titles;
    ArrayList<String>  ImgUrls;
    ArrayList<Integer>  ViewCount;
    ArrayList<String>  VideoUrls;
    ArrayList<String>  Type;
    DatabaseReference mDatabase;
    String title=null;
    String  imgurl=null;
    String vurl=null;
    String type=null;

    int vc;
    Context context;
    ListView YoutubeList;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_videos);
        //TextView    answer = (TextView) findViewById(R.id.tv);
        Firebase.setAndroidContext(this);
//        FirebaseDatabase database=FirebaseDatabase.getInstance();
//        DatabaseReference myref=database.getReference("Videos");
        //Firebase ref=new Firebase(config.FIREBASE_URL);

// ...
        context=this;
        mDatabase = FirebaseDatabase.getInstance().getReference();
         Titles=new ArrayList<String>();
        ImgUrls=new ArrayList<String>();
        ViewCount=new ArrayList<Integer>();
        VideoUrls=new ArrayList<String>();
        Type=new ArrayList<String>();
     //  User user=new User("Siddhartyh","baap@gmail.com");
      //mDatabase.child("users").child("1").setValue(user);
        //Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
        //mDatabase.addListenerForSingleValueEvent();
mDatabase.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
    @Override
    public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
        for (com.google.firebase.database.DataSnapshot child : dataSnapshot.getChildren()) {
           //for (com.google.firebase.database.DataSnapshot child1 : child.getChildren()) {
                //Toast.makeText(getApplicationContext(),"Done  wa Title :"+child.getValue(),Toast.LENGTH_LONG).show();
                Log.d("answer",""+child.getValue());
            title = child.child("title").getValue(String.class);
            imgurl = child.child("imgurl").getValue(String.class);
            type = child.child("type").getValue(String.class);
            vc= child.child("vc").getValue(Integer.class);
            vurl = child.child("vurl").getValue(String.class);


//            Titles.clear();
//            ImgUrls.clear();
//            Type.clear();
//            ViewCount.clear();
//            VideoUrls.clear();

            Titles.add(title);
            ImgUrls.add(imgurl);
            Type.add(type);
            ViewCount.add(vc);
            VideoUrls.add(vurl);
          //  Toast.makeText(getApplicationContext(),"Done"+Titles.get(i)+"\n"+ImgUrls.get(i)+"\n"+Type.get(i),Toast.LENGTH_LONG).show();
             //i++;
             // Log.d("Title  :", "" + v.gett());
                //Toast.makeText(getApplicationContext(),"DoneTitle:\n"+title+"\n"+imgurl+"\n"+type+"\n"+vc+"\n"+vurl,Toast.LENGTH_LONG).show();
            }


        //Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
     ///list view shifted


        ///YoutubeList.setAdapter(new CustomAdapter(getApplicationContext(),Titles,ImgUrls,Type,ViewCount,VideoUrls));

        Toast.makeText(getApplicationContext(),"Done Adapter Set",Toast.LENGTH_LONG).show();
        CustomAdapter c=new CustomAdapter(getApplicationContext(),Titles,ImgUrls,Type,ViewCount,VideoUrls);

         YoutubeList= (ListView) findViewById(R.id.list);
//YoutubeList.setAdapter(null);
        YoutubeList.setAdapter(c);

        YoutubeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              i=new Intent(YouTubeVideos.this,YoutubeVideoPlay.class);
                i.putExtra("VideoUrl",VideoUrls.get(position));
                i.putExtra("Title",Titles.get(position));
                startActivity(i);
                // Toast.makeText(getApplicationContext(),""+Titles.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});




//        myref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    //Getting the data from snapshot
//                    Videos v1= postSnapshot.getValue(Videos.class);
//                  ImgUrls.add(""+v1.getimgurl());
//                    Titles.add(""+v1.gett());
//                    Type.add(""+v1.getty());
//                    ViewCount.add(""+v1.getvc());
//                    VideoUrls.add(""+v1.getvurl());
//                    System.out.print(""+v1);
//
//                    //Adding it to a string
//   //answer.setText("Title"+v1.gett());
//
//                    //Displaying it on textview
//                    //textViewPersons.setText(string);
//                }
//            }
//
//
//
//
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//                Toast.makeText(getApplicationContext(),"FireBase error"+firebaseError.getMessage(),Toast.LENGTH_LONG).show();
//            }
//        });
//        for (int i=0;i<Titles.size();i++){
//            answer.setText("Title"+Titles.get(i));
//
//
//
//        }
    }
}
