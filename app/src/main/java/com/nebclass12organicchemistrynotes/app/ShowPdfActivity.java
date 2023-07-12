package com.nebclass12organicchemistrynotes.app;

import static com.nebclass12organicchemistrynotes.app.Admob.Admob.showAdmobInterstitial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.nebclass12organicchemistrynotes.app.Admob.Admob;
import com.nebclass12organicchemistrynotes.app.databinding.ActivityShowPdfBinding;

public class ShowPdfActivity extends AppCompatActivity {

    ActivityShowPdfBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowPdfBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        Admob.loadBannerAd(findViewById(R.id.bannerAd),ShowPdfActivity.this);


        showAdmobInterstitial(ShowPdfActivity.this,true);

        int position = getIntent().getIntExtra("pos",0);
        String chapter = getIntent().getStringExtra("name");

        binding.toolBarName.setText(chapter);

        if (position==0){
            binding.pdfView.fromAsset("onehaloalkane.pdf").load();
        }
        else if (position==1){
            binding.pdfView.fromAsset("twochloroform.pdf").load();
        }
        else if (position==2){
            binding.pdfView.fromAsset("threealcohol.pdf").load();
        }
        else if (position==3){
            binding.pdfView.fromAsset("fourhaloarene.pdf").load();
        }
        else if (position==4){
            binding.pdfView.fromAsset("fivephenol.pdf").load();
        }
        else if (position==5){
            binding.pdfView.fromAsset("sixether.pdf").load();
        }
        else if (position==6){
            binding.pdfView.fromAsset("sevenaldehyde.pdf").load();
        }
        else if (position==7){
            binding.pdfView.fromAsset("eightaromatic.pdf").load();
        }
        else if (position==8){
            binding.pdfView.fromAsset("ninecarboxylic.pdf").load();
        }
        else if (position==9){
            binding.pdfView.fromAsset("tennitro.pdf").load();
        }
        else if (position==10){
            binding.pdfView.fromAsset("elevenamino.pdf").load();
        }

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {

        showAdmobInterstitial(ShowPdfActivity.this,true);
        super.onBackPressed();
    }

}