package com.example.rudderstack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rudderstack.android.sdk.core.RudderProperty;
import com.rudderstack.android.sdk.core.RudderTraits;

import java.util.Date;

import static com.example.rudderstack.MainApplication.rudderClient;

public class MainActivity extends AppCompatActivity {
    private Button button_identify;
    private Button button_track, button_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_identify=findViewById(R.id.bidentify);
        button_track=findViewById(R.id.btrack);
        button_screen=findViewById(R.id.bscreen);



        //for identify call
        RudderTraits traits = new RudderTraits();
        traits.putBirthday(new Date());
        traits.putEmail("abc@123.com");
        traits.putFirstName("First");
        traits.putLastName("Last");
        traits.putGender("m");
        traits.putPhone("5555555555");

        RudderTraits.Address address = new RudderTraits.Address();
        address.putCity("City");
        address.putCountry("USA");
        traits.putAddress(address);

        traits.put("boolean", Boolean.TRUE);
        traits.put("integer", 50);
        traits.put("float", 120.4f);
        traits.put("long", 1234L);
        traits.put("string", "hello");
        traits.put("date", new Date(System.currentTimeMillis()));

        rudderClient.identify("test_user_id", traits, null);

        button_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="track";
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
                MainApplication.rudderClient.track(
                        "Product Added",
                        new RudderProperty()
                                .putValue("product_id", "product_001")
                );
            }
        });
        button_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="screen";
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
                rudderClient.screen(
                        "MainActivity",
                        "HomeScreen",
                        new RudderProperty().putValue("foo", "bar"),
                        null
                );
            }
        });
        button_identify.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="identify";
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
                MainApplication.rudderClient.identify("Ankit app",traits, null);
            }
        }));
    }

}