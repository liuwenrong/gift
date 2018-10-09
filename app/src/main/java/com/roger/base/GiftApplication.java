package com.roger.base;

import android.app.Application;

public class GiftApplication
  extends Application
{
  private static GiftApplication sInstance;
  public int random = 0;
  
  public static GiftApplication getInstance()
  {
    return sInstance;
  }
  
  public void onCreate()
  {
    super.onCreate();
    sInstance = this;
  }
}


/* Location:              E:\Android\0app\you_are_my_idol_girl\classes-dex2jar.jar!\com\roger\base\GiftApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */