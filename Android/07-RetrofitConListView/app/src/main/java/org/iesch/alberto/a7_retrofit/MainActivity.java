package org.iesch.alberto.a7_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.iesch.alberto.a7_retrofit.Interfaces.JsonPlaceHolderApi;
import org.iesch.alberto.a7_retrofit.Models.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView myJsonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myJsonTextView = (TextView) findViewById(R.id.jsonText);

        getPost();

    }

    private void getPost(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Posts>> call = jsonPlaceHolderApi.getPost();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (!response.isSuccessful()){
                    myJsonTextView.setText("Codigo: " + response);
                    return;
                }

                List<Posts> postsList = response.body();

                for (Posts posts: postsList) {
                    String contenido = "";
                    contenido += "UserId " + posts.getUserId() + "\n";
                    contenido += "Id " + posts.getId() + "\n";
                    contenido += "Title " + posts.getTitle() + "\n";
                    contenido += "Body " + posts.getBody() + "\n\n";

                    myJsonTextView.append(contenido);
                }


            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                myJsonTextView.setText(t.getMessage());
            }
        });
    }
}