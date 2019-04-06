package com.example.silver_tech.donatelife;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.silver_tech.donatelife.Activities.LoginActivity;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

import static com.google.firebase.auth.FirebaseAuth.getInstance;

public class ChatActivity extends AppCompatActivity {
    FirebaseAuth mAuth;

    FirebaseUser currentUser;


    private static final int SIGN_IN_REQUEST_CODE = 111;
    private ListView listView;
    private String loggedInUserName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mAuth = getInstance();
        currentUser = mAuth.getCurrentUser();

        //find views by Ids
        FloatingActionButton fab = findViewById(R.id.fab);
        final EditText input = findViewById(R.id.input);
        listView = findViewById(R.id.list);

        if (getInstance().getCurrentUser() != null) {
          showAllOldMessages();
        } else {
            // User is already signed in, show list of messages
            showAllOldMessages();
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().toString().trim().equals("")) {
                    Toast.makeText(ChatActivity.this, "Please enter some texts!", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseDatabase.getInstance()
                            .getReference()
                            .push()
                            .setValue(new ChatMessage(input.getText().toString(),
                                    getInstance().getCurrentUser().getDisplayName(),
                                    getInstance().getCurrentUser().getUid())
                            );
                    input.setText("");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_sign_out) {
            FirebaseAuth.getInstance().signOut();

            startActivity(new Intent(ChatActivity.this,LoginActivity.class));
            finish();

        }
        return true;
    }

    private void showAllOldMessages() {
        loggedInUserName = Objects.requireNonNull(getInstance().getCurrentUser()).getUid();
        Log.d("Main", "user id: " + loggedInUserName);

        FirebaseListAdapter<ChatMessage> adapter = new MessageAdapter(this, ChatMessage.class, R.layout.item_out_message,
                FirebaseDatabase.getInstance().getReference());
        listView.setAdapter(adapter);
    }

    public String getLoggedInUserName() {
        return loggedInUserName;
    }
}
