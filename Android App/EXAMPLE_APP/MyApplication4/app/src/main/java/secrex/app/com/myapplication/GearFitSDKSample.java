package secrex.app.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


import com.samsung.android.sdk.*;
import com.samsung.android.sdk.sensorextension.*;
import com.samsung.android.sdk.accessory.SA;
import com.samsung.android.sdk.accessory.SAAgent;
import com.samsung.android.sdk.accessory.SAPeerAgent;
import com.samsung.android.sdk.accessory.SASocket;
import com.samsung.android.sdk.cup.*;

import java.io.IOException;

public class GearFitSDKSample extends ScupDialog {
    MyActivity activity;
    private static final String TAG = "DialogSample";

    SsensorExtension mSsensorExtension;
    SsensorManager mSsensorManager = null;
    Ssensor mUVSensor = null;

    static final String SAP_ACTION_ATTACHED = "android.accessory.device.action.ATTACHED";
    static final String SAP_ACTION_DETACHED = "android.accessory.device.action.DETACHED";
    public static final int HELLOACCESSORY_CHANNEL_ID = 104;
    private SASocket mConnectionHandler;
    private boolean mIsBound = false;
    private ScupDevice device;
    public GearFitSDKSample(Context context) {
        super(context);
        activity = (MyActivity) context;
    }

    @Override
    protected void onCreate() {
        super.onCreate();

//        SA mAccessory = new SA();
//        try {
//            mAccessory.initialize(getContext());
//        } catch (SsdkUnsupportedException e) {
//            // Error Handling
//        } catch (Exception e1) {
//            Log.i(TAG, e1.getMessage());
//            GearFitSDKSample.this.showToast(e1.getMessage(), ScupDialog.TOAST_DURATION_SHORT);
//        }
//        boolean support = mAccessory.isFeatureEnabled(SA.DEVICE_ACCESSORY);
//        Log.i(TAG, String.valueOf(support));
     //   this.setWidgetGap(2F);
       // this.setWidgetAlignment(ScupDialog.WIDGET_ALIGN_HORIZONTAL_CENTER);
       // this.setBackEnabled(true);
        // Listening
 /*       this.setBackPressedListener(new BackPressedListener() {
            @Override
            public void onBackPressed(ScupDialog dialog) {
                GearFitSDKSample.this.showToast("Back button clicked !",
                        ScupDialog.TOAST_DURATION_SHORT);

                if (mBackButtonListener != null) {
                    mBackButtonListener.onBackButtonPressed(dialog);
                }

                GearFitSDKSample.this.finish();
            }
        });
//        */
//        this.setBackgroundColor(Color.BLACK);
//        this.setTitle("Hello Simple Dialog");
//        this.setTitleTextColor(Color.CYAN);
//        this.setTitleTextSize(6);
//// Border style of title
//        this.setTitleBackgroundColor(Color.RED);
//        this.setTitleBorderStyle(ScupDialog.TITLE_BORDER_UNDERLINE);
//        this.setTitleBorderColor(Color.YELLOW);
//        this.setTitleBorderWidth(0.5f);
//        this.setTitleButton(R.drawable.ic_launcher);
//        this.setTitleButtonClickListener(new TitleButtonClickListener() {
//            @Override
//            public void onClick(ScupDialog arg0) {
//                GearFitSDKSample.this.showToast("Title button clicked !",
//                        ScupDialog.TOAST_DURATION_SHORT);
//                GearFitSDKSample.this.finish();
//            }
//        });
//
//        this.setActionButtonClickListener(new ActionButtonClickListener() {
//            @Override
//            public void onClick(ScupDialog arg0) {
//                GearFitSDKSample.this.showToast("Submit button clicked !",
//                                            ScupDialog.TOAST_DURATION_SHORT);
//        }
//        });
//
//        this.setGestureListener(new GestureListener() {
//
//            @Override
//            public void onSingleTap(ScupDialog arg0, float x, float y) {
//                // TODO Auto-generated method stub
//                GearFitSDKSample.this.showToast(
//                        String.format("Tap at : (%f, %f)", x, y),
//                        ScupDialog.TOAST_DURATION_SHORT);
//            }
//
//            @Override
//            public void onDoubleTap(ScupDialog arg0, float arg1, float arg2) {
//                // TODO Auto-generated method stub
//
//            }
//        });

        // Enable the back button in the right side of companion screen
        // If false, the back button cannot display
        setBackEnabled(true);
        ScupLabel helloLabel = new ScupLabel(this);
        helloLabel.setText("Hello CUP");
        helloLabel.setAlignment(ScupLabel.ALIGN_CENTER);
        helloLabel.setWidth(ScupLabel.FILL_DIALOG);
        helloLabel.setHeight(ScupLabel.FILL_DIALOG);
        helloLabel.show();
        setBackPressedListener(new BackPressedListener() {
            @Override
            public void onBackPressed(ScupDialog arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
}

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume Called");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause Called");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // callback function if need
        if (mOnDestroyListener != null) {
            mOnDestroyListener.onDestroy();
        }

        super.onDestroy();
    }

    interface BackButtonListener {
        public void onBackButtonPressed(ScupDialog dialog);
       /* final ScupButton button = new ScupButton(this);
        button.setHeight(ScupButton.FILL_DIALOG);
        button.setWidth(ScupButton.FILL_DIALOG);
        button.setText("Nhan vao");
        button.setEnabled(true);
        button.show();*/
    }

    private OnDestroyListener mOnDestroyListener;
    private BackButtonListener mBackButtonListener;
    interface OnDestroyListener {
        public void onDestroy();
    }

    public Integer x = 50;
    public Integer signo = 1;
}
