package com.example.picasso_e;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        imageView = (ImageView)findViewById(R.id.image);

        fab.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Snackbar.make(view, "Вызван по нажатию FloatingActionButton", Snackbar.LENGTH_LONG)
                                               .setAction("Action", null).show();
                                       ShowImageUsingPicasso();
                                   }
                               }
        );
    }
    public void ShowImageUsingPicasso(){
        Picasso.with(MainActivity.this)
                .load("https://www.android-examples.com/wp-content/uploads/2016/03/demo_image.jpg")
                //.load("здесь ссылка на картинку")
                //  .load("https://androidjson.com/wp-content/uploads/2016/12/sample_image.png")
                //.placeholder(R.mipmap.ic_launcher)//показываем что-то, пока не загрузится указанная картинка
                .error(R.mipmap.ic_launcher)// показываем что-то, если не удалось скачать картинку
                .resize(300,300)// изменяем размер картинки
                .into(imageView); //imageview - будет отображать загруженную фотографию
    }
}
