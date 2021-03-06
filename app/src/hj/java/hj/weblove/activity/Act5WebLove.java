package hj.weblove.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lwr.gift.R;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import roger.weblove.factory.ImageNameFactory;
import roger.weblove.util.ClickUtils;
import roger.weblove.util.DeviceInfo;
import roger.weblove.util.ImageUtils;
import roger.weblove.view.bluesnow.FlowerView;
import roger.weblove.view.heart.HeartLayout;
import roger.weblove.view.typewriter.TypeTextView;
import roger.weblove.view.whitesnow.SnowView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class Act5WebLove extends Activity {
    private static final String JPG = ".jpg";
    private static final String LOVE = "心动是等你的留言，渴望是常和你见面，甜蜜是和你小路流连，温馨是看着你清澈的双眼，爱你的感觉真的妙不可言！";
    private static final int SNOW_BLOCK = 1;
    public static final String URL = "file:///android_asset/index.html";
    private Canvas mCanvas;
    private int mCounter;
    private FlowerView mBlueSnowView;//蓝色的雪花
    private Handler mHandler = new Handler() {
        public void dispatchMessage(Message msg) {
            Act5WebLove.this.mBlueSnowView.inva();
        }
    };
    private HeartLayout mHeartLayout;//垂直方向的漂浮的红心
    private ImageView mImageView;//图片
    private Bitmap mManyBitmapSuperposition;
    private ProgressBar mProgressBar;
    private Random mRandom = new Random();
    private Random mRandom2 = new Random();
    private TimerTask mTask = null;
    private TypeTextView mTypeTextView;//打字机
    private WebSettings mWebSettings;
    private WebView mWebView;
    private SnowView mWhiteSnowView;//白色的雪花
    private Timer myTimer = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeviceInfo.getInstance().initializeScreenInfo(this);
        setContentView(R.layout.main);
        initView();
        initWebView();
        bindListener();
        delayShowAll(3000L);

    }


    private FrameLayout mWebViwFrameLayout = null;
    private FrameLayout root_fragment_layout = null;
    private TextView textview = null;

    private void initWebView() {

        this.mWebSettings = this.mWebView.getSettings();
        this.mWebSettings.setJavaScriptEnabled(true);
        this.mWebSettings.setBuiltInZoomControls(false);
        this.mWebSettings.setLightTouchEnabled(false);
        this.mWebSettings.setSupportZoom(false);
        this.mWebView.setHapticFeedbackEnabled(false);
    }

    private void initView() {
        mWebViwFrameLayout = (FrameLayout) findViewById(R.id.fl_webView_layout);
        root_fragment_layout = (FrameLayout) findViewById(R.id.root_fragment_layout);
        textview = (TextView) findViewById(R.id.textview);
        this.mWebView = new WebView(getApplicationContext());
        this.mWebView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        this.mWebView.setVisibility(View.GONE);
        //scrollbars

        FrameLayout.LayoutParams fp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        fp.gravity = Gravity.CENTER;

        mWebViwFrameLayout.addView(mWebView);

        this.mHeartLayout = (HeartLayout) findViewById(R.id.heart_o_red_layout);
        this.mTypeTextView = (TypeTextView) findViewById(R.id.typeTextView);
        this.mWhiteSnowView = (SnowView) findViewById(R.id.whiteSnowView);
        this.mImageView = (ImageView) findViewById(R.id.image);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        this.mBlueSnowView = (FlowerView) findViewById(R.id.flowerview);
        this.mBlueSnowView.setWH(DeviceInfo.mScreenWidthForPortrait, DeviceInfo.mScreenHeightForPortrait, DeviceInfo.mDensity);
        this.mBlueSnowView.loadFlower();
        this.mBlueSnowView.addRect();
        this.myTimer = new Timer();
        this.mTask = new TimerTask() {
            public void run() {
                Message msg = new Message();
                msg.what = Act5WebLove.SNOW_BLOCK;
                Act5WebLove.this.mHandler.sendMessage(msg);
            }
        };
        rxJavaSolveMiZhiSuoJinAndNestedLoopAndCallbackHell();
        this.myTimer.schedule(this.mTask, 3000, 10);
        clickEvent();
        this.mTypeTextView.setOnTypeViewListener(new TypeTextView.OnTypeViewListener() {
            public void onTypeStart() {
            }

            public void onTypeOver() {
                delayShowTheSnow();
            }
        });
        this.mTypeTextView.setText("");
    }

    private void bindListener() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelTimer();
        if (this.mWebView != null) {
            //            this.mWebView.clearCache(true);
            //            this.mWebView.clearHistory();
            //            this.mWebView.clearView();
            //            this.mWebView.clearFormData();
            //            this.mWebView.clearMatches();
            //            this.mWebView.clearSslPreferences();
            //            this.mWebView.clearAnimation();
            //            this.mWebView.clearFocus();
            //            this.mWebView.removeAllViewsInLayout();
            if (mWebViwFrameLayout != null) {
                this.mWebViwFrameLayout.removeAllViewsInLayout();
                this.mWebViwFrameLayout.removeAllViews();
            }
            this.mWebView.removeAllViews();
            this.mWebView.destroy();
            this.mWebView = null;
        }
        unBindDrawables(findViewById(R.id.root_fragment_layout));
        System.gc();
    }

    private void cancelTimer() {
        if (this.myTimer != null) {
            this.myTimer.cancel();
            this.myTimer = null;
        }
        if (this.mTask != null) {
            this.mTask.cancel();
            this.mTask = null;
        }
    }

    private void createSingleImageFromMultipleImages(Bitmap bitmap, int mCounter) {
        if (mCounter == 0) {
            //TODO:Caused by: java.lang.OutOfMemoryError
            try {
                this.mManyBitmapSuperposition = Bitmap.createBitmap(DeviceInfo.mScreenWidthForPortrait, DeviceInfo.mScreenHeightForPortrait, bitmap.getConfig());
                this.mCanvas = new Canvas(this.mManyBitmapSuperposition);
            } catch (OutOfMemoryError error) {
                error.printStackTrace();
                System.gc();
            } finally {

            }
        }
        if (this.mCanvas != null) {
            int number = DeviceInfo.mScreenHeightForPortrait / 64;
            if (mCounter >= (mCounter / number) * number && mCounter < ((mCounter / number) + SNOW_BLOCK) * number) {
                this.mCanvas.drawBitmap(bitmap, (float) ((mCounter / number) * 64), (float) ((mCounter % number) * 64), null);
            }
        }
    }

    private void rxJavaSolveMiZhiSuoJinAndNestedLoopAndCallbackHell() {
        Observable.from(ImageNameFactory.getAssetImageFolderName())
                .flatMap(new Func1<String, Observable<String>>() {
                    public Observable<String> call(String folderName) {
                        return Observable.from(ImageUtils.getAssetsImageNamePathList(Act5WebLove.this.getApplicationContext(), folderName));
                    }
                }).filter(new Func1<String, Boolean>() {
            public Boolean call(String imagePathNameAll) {
                return Boolean.valueOf(imagePathNameAll.endsWith(Act5WebLove.JPG));
            }
        }).map(new Func1<String, Bitmap>() {
            public Bitmap call(String imagePathName) {
                return ImageUtils.getImageBitmapFromAssetsFolderThroughImagePathName(Act5WebLove.this.getApplicationContext(), imagePathName, DeviceInfo.mScreenWidthForPortrait, DeviceInfo.mScreenHeightForPortrait);
            }
        }).map(new Func1<Bitmap, Void>() {
            public Void call(Bitmap bitmap) {
                Act5WebLove.this.createSingleImageFromMultipleImages(bitmap, Act5WebLove.this.mCounter);
                Act5WebLove.this.mCounter = Act5WebLove.this.mCounter++;
                return null;
            }
        }).subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    public void call() {
                        Act5WebLove.this.mProgressBar.setVisibility(View.VISIBLE);
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Void>() {
                    public void onCompleted() {
                        Act5WebLove.this.mImageView.setImageBitmap(Act5WebLove.this.mManyBitmapSuperposition);
                        Act5WebLove.this.mProgressBar.setVisibility(View.GONE);
                        Act5WebLove.this.showAllViews();
                    }

                    public void onError(Throwable e) {
                    }

                    public void onNext(Void aVoid) {
                    }
                });
    }

    private void showAllViews() {
        this.mImageView.setVisibility(View.VISIBLE);
        this.mWhiteSnowView.setVisibility(View.VISIBLE);
    }

    private void clickEvent() {

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ClickUtils.isFastDoubleClick()) {
                    delayShowAll(0L);
                }
            }
        });
    }

    private void gotoNext() {
        if (mWebView != null) {
            this.mWebView.loadUrl(URL);
        }

        delayDo();
    }

    private void delayShow(long time) {
        Observable.timer(time, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    public void onCompleted() {
                        Act5WebLove.this.mTypeTextView.start(Act5WebLove.LOVE);
                    }

                    public void onError(Throwable e) {
                    }

                    public void onNext(Long aLong) {
                    }
                });
    }


    private void delayShowTheSnow() {
        Observable.timer(200, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    public void onCompleted() {
                        mBlueSnowView.setVisibility(View.VISIBLE);
                        Act5WebLove.this.showRedHeartLayout();
                    }

                    public void onError(Throwable e) {
                    }

                    public void onNext(Long aLong) {
                    }
                });

    }

    private void delayDo() {
        Observable.timer(0, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    public void onCompleted() {
                        Act5WebLove.this.mWhiteSnowView.setVisibility(View.GONE);
                        Act5WebLove.this.mWebView.setVisibility(View.VISIBLE);
                        Act5WebLove.this.textview.setVisibility(View.VISIBLE);
                        Act5WebLove.this.delayShow(5100);//延时显示显示打印机
                        Act5WebLove.this.mWebView.loadUrl(Act5WebLove.URL);
                        Act5WebLove.this.textview.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //                                Act5WebLove.this.mWebView.loadUrl("file:///android_asset/love.html");
                                startActivity(new Intent(Act5WebLove.this, BrowserActivity.class));
                            }
                        });

                    }

                    public void onError(Throwable e) {
                    }

                    public void onNext(Long aLong) {
                    }
                });
    }

    private void delayShowAll(long time) {
        Observable.timer(time, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    public void onCompleted() {
                        Act5WebLove.this.gotoNext();
                    }

                    public void onError(Throwable e) {
                    }

                    public void onNext(Long aLong) {
                    }
                });
    }

    //    @Override
    //    public boolean onKeyDown(int keyCode, KeyEvent event) {
    //        if (keyCode == KeyEvent.KEYCODE_BACK) {
    //            if (this.mWebView != null) {
    //                this.mWebView.clearCache(true);
    //                this.mWebView.clearHistory();
    //                this.mWebView.clearView();
    //                this.mWebView.clearFormData();
    //                this.mWebView.clearMatches();
    //                this.mWebView.clearSslPreferences();
    //                this.mWebView.clearAnimation();
    //                this.mWebView.clearFocus();
    //                this.mWebView.removeAllViewsInLayout();
    //                this.mWebView = null;
    //            }
    //            System.gc();
    //            unBindDrawables(findViewById(R.id.root_fragment_layout));
    //            this.finish();
    //        }
    //        return false;
    //    }


    private int randomColor() {
        return Color.rgb(mRandom.nextInt(255), mRandom.nextInt(255), mRandom.nextInt(255));
    }

    private void showRedHeartLayout() {
        Observable.timer(400, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    public void onCompleted() {
                        mHeartLayout.setVisibility(View.VISIBLE);
                        Act5WebLove.this.delayDo2();
                    }

                    public void onError(Throwable e) {
                    }

                    public void onNext(Long aLong) {
                    }
                });
    }

    private void delayDo2() {
        Observable.timer((long) this.mRandom2.nextInt(200), TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    public void onCompleted() {
                        Act5WebLove.this.mHeartLayout.addHeart(Act5WebLove.this.randomColor());
                        Act5WebLove.this.delayDo2();
                    }

                    public void onError(Throwable e) {
                    }

                    public void onNext(Long aLong) {

                    }
                });
    }


    /**
     * remove View Drawables
     *
     * @param view
     */
    private void unBindDrawables(View view) {
        if (view != null) {
            try {
                Drawable drawable = view.getBackground();
                if (drawable != null) {
                    drawable.setCallback(null);
                } else {
                }
                if (view instanceof ViewGroup && !(view instanceof AdapterView)) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int viewGroupChildCount = viewGroup.getChildCount();
                    for (int j = 0; j < viewGroupChildCount; j++) {
                        unBindDrawables(viewGroup.getChildAt(j));
                    }
                    viewGroup.removeAllViews();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
