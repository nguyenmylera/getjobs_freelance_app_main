package io.flutter.plugins;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        

        mAuth = FirebaseAuth.getInstance();

        final String TAG = "MainActivity";

        findViewById(R.id.btn_dangky).setOnClickListener(v -> {

            String email = ((EditText)findViewById(R.id.edt_email)).getText().toString();
            String password = ((EditText)findViewById(R.id.edt_password)).getText().toString();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
//                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(MainActivity.this, "Dang ky thanh cong",
                                        Toast.LENGTH_SHORT).show();

                                UserModel userModel = new UserModel(email, password);

                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                intent.putExtra("user", userModel);
                                startActivity(intent);

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(MainActivity.this, task.getException().toString(),
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            Toast.makeText(MainActivity.this, "Dang nhap tu dong voi user: " + user.getEmail(),
                    Toast.LENGTH_SHORT).show();

            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }
    }
}