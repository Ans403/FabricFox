package com.example.fabricfox.Seller;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.fabricfox.Buyer.MainActivity;
import com.example.fabricfox.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SellerHomeActivity extends AppCompatActivity {
    private TextView mTextMassage;


    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    mTextMassage.setText(R.string.title_home);
                    return true;

                case R.id.navigation_add:
                    Intent intentCate = new Intent(SellerHomeActivity.this, SellerCategoryActivity.class);
                     startActivity(intentCate);
                    return true;
                case R.id.navigation_logout:
                    final FirebaseAuth mAuth;
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.signOut();

                    Intent intentMain = new Intent(SellerHomeActivity.this, MainActivity.class);
                    intentMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intentMain);
                    finish();
                    return true;
            }
            return false;


        }
    };

}