package com.nebclass12organicchemistrynotes.app.Admob;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;


public class Admob {

    OnDismiss onDismiss;

    public Admob(OnDismiss onDismiss) {
        this.onDismiss = onDismiss;
    }

    public static void loadBannerAd(LinearLayout banner,Context context){

        if (AdUnit.isAdss){

            MobileAds.initialize(context, initializationStatus -> {
            });

            AdView adView = new AdView(context);
            banner.addView(adView);
            adView.setAdUnitId(AdUnit.BANNER);
            adView.setAdSize(AdSize.BANNER);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);

        }


    }

    public static void loadAdmobInterstitial(Context context){

      if (AdUnit.isAdss){

         AdRequest adRequest = new AdRequest.Builder().build();

         InterstitialAd.load(context,AdUnit.ADMOB_INTERSTITIAL, adRequest,
                 new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                       AdUnit.mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                       AdUnit.mInterstitialAd = null;


                    }
                 });

      }

   }
   public static void showAdmobInterstitial(Activity activity,boolean isReload){

       if (AdUnit.mInterstitialAd != null) {
           AdUnit.mInterstitialAd.show(activity);

           AdUnit.mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
               @Override
               public void onAdDismissedFullScreenContent() {
                   super.onAdDismissedFullScreenContent();

                   if (isReload){

                       AdUnit.mInterstitialAd = null;
                       loadAdmobInterstitial(activity);
                   }

               }

               @Override
               public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                   super.onAdFailedToShowFullScreenContent(adError);
               }
           });



       } else {



       }

   }

    public static void loadVideoRewarded(Context context){

        if (AdUnit.isAdss){

            MobileAds.initialize(context, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

                }
            });

            AdRequest adRequest = new AdRequest.Builder().build();

            RewardedAd.load(context, AdUnit.REWARDED,
                    adRequest, new RewardedAdLoadCallback() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            // Handle the error.

                            AdUnit.mRewardedAd = null;

                        }

                        @Override
                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {

                            AdUnit.mRewardedAd = rewardedAd;


                        }
                    });


        }

    }

    public static void showAdmobRewarded(Activity activity,boolean isReload){

        if (AdUnit.mRewardedAd != null) {

            AdUnit.mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdClicked() {
                    // Called when a click is recorded for an ad.
                    Log.d(TAG, "Ad was clicked.");
                }

                @Override
                public void onAdDismissedFullScreenContent() {

                    if (isReload){

                        AdUnit.mRewardedAd = null;
                        loadVideoRewarded(activity);

                    }


                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    // Called when ad fails to show.
                    Log.e(TAG, "Ad failed to show fullscreen content.");
                    AdUnit.mRewardedAd = null;
                }

                @Override
                public void onAdImpression() {
                    // Called when an impression is recorded for an ad.
                    Log.d(TAG, "Ad recorded an impression.");
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    // Called when ad is shown.
                    Log.d(TAG, "Ad showed fullscreen content.");
                }
            });

            AdUnit.mRewardedAd.show(activity, new OnUserEarnedRewardListener() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                }

            });


        }

    }


}
