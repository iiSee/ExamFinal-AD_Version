package com.rowsen.examfinal;

import android.app.Activity;
import android.app.Application;

import com.miui.zeus.mimo.sdk.MimoSdk;

import java.util.ArrayList;


public class Myapp extends Application {
    private static Myapp instance;
    static ArrayList<JudgeBean> judgeList;
    static ArrayList<SelectionBean> selectionList;
    static ArrayList allList;
    public static ArrayList<Activity> activitys;
    static final String APP_ID = "2882303761517942601";
    static final String APP_KEY = "5121794213601";
    static final String APP_TOKEN = "Qa9OGvRbqTmDRy5aZENIEA==";
    //Mi测试参数
    /*static final String APP_ID = "2882303761517411490";
    static final String APP_TOKEN = "fake_app_token";
    static final String APP_KEY ="fake_app_key";*/

    //广点通APPID
    public static final String GDT_APPID = "1108173909";

    //广点通测试APPID
    //static final String GTD_APPID = "1101152570";

    //穿山甲
/*    static final String TT_APPID = "5035909";
    public TTAdManager ttAdManager;*/

    //穿山甲测试ID
    //static final String TT_APPID = "5001121";
    @Override
    public void onCreate() {
        super.onCreate();
        activitys = new ArrayList<>();
        judgeList = new ArrayList<>();
        selectionList = new ArrayList<>();
        allList = new ArrayList();
        instance = this;
        MimoSdk.setEnableUpdate(false);
        //MimoSdk.setDebugOn();
        // 正式上线时候务必关闭stage
        //MimoSdk.setStageOn();
        MimoSdk.init(this, APP_ID, APP_KEY, APP_TOKEN, null);
        //初始化腾讯移动应用分析平台
/*        StatService.setContext(this);
        initMTAConfig(true);
        String appkey = "Aqc1108173909";
        // 初始化并启动MTA
        // 第三方SDK必须按以下代码初始化MTA，其中appkey为规定的格式或MTA分配的代码。
        // 其它普通的app可自行选择是否调用
        try {
            // 第三个参数必须为：com.tencent.stat.common.StatConstants.VERSION
            StatService.startStatService(this, appkey,
                    com.tencent.stat.common.StatConstants.VERSION);
        } catch (MtaSDkException e) {
            // MTA初始化失败
            Log.e("错误", "MTA start failed.");
        }*/

        //穿山甲初始化
        /*ttAdManager = TTAdSdk.init(this,
                new TTAdConfig.Builder()
                        .appId(TT_APPID)
                        .useTextureView(false) //使用TextureView控件播放视频,默认为SurfaceView,当有SurfaceView冲突的场景，可以使用TextureView
                        .appName("电工复审考试")
                        .titleBarTheme(TTAdConstant.TITLE_BAR_THEME_DARK)
                        .allowShowNotify(true) //是否允许sdk展示通知栏提示
                        .allowShowPageWhenScreenLock(true) //是否在锁屏场景支持展示广告落地页
                        .debug(true) //测试阶段打开，可以通过日志排查问题，上线时去除该调用
                        .directDownloadNetworkType(TTAdConstant.NETWORK_STATE_WIFI, TTAdConstant.NETWORK_STATE_3G) //允许直接下载的网络状态集合
                        .supportMultiProcess(false) //是否支持多进程，true支持
                        //.httpStack(new MyOkStack3())//自定义网络库，demo中给出了okhttp3版本的样例，其余请自行开发或者咨询工作人员。
                        .build());*/

    }

    public static Myapp getInstance() {
        return instance;
    }

/*    private void initMTAConfig(boolean isDebugMode) {

        if (isDebugMode) { // ����ʱ�������õĿ���״̬
            // �鿴MTA��־���ϱ���������
            StatConfig.setDebugEnable(true);
            // StatConfig.setEnableSmartReporting(false);
            // Thread.setDefaultUncaughtExceptionHandler(new
            // UncaughtExceptionHandler() {
            //
            // @Override
            // public void uncaughtException(Thread thread, Throwable ex) {
            // logger.error("setDefaultUncaughtExceptionHandler");
            // }
            // });
            // ����ʱ��ʹ��ʵʱ����
            // StatConfig.setStatSendStrategy(StatReportStrategy.BATCH);
            // // �Ƿ�˳���ϱ�
            // StatConfig.setReportEventsByOrder(false);
            // // �������ڴ��buffer��־����,�ﵽ�������ʱ�ᱻд��db
            // StatConfig.setNumEventsCachedInMemory(30);
            // // �������ڴ��buffer����д�������
            // StatConfig.setFlushDBSpaceMS(10 * 1000);
            // // ����û��˳���̨���ǵõ������½ӿڣ���bufferд��db
            // StatService.flushDataToDB(getApplicationContext());

            // StatConfig.setEnableSmartReporting(false);
            // StatConfig.setSendPeriodMinutes(1);
            // StatConfig.setStatSendStrategy(StatReportStrategy.PERIOD);
        } else { // ����ʱ���������õĿ���״̬����ȷ�����¿����Ƿ����ú���
            // ��ֹMTA��ӡ��־
            StatConfig.setDebugEnable(false);
            // ��������������Ƿ���MTA��appδ�����쳣�Ĳ���
            StatConfig.setAutoExceptionCaught(true);
            // ѡ��Ĭ�ϵ��ϱ�����
            StatConfig.setStatSendStrategy(StatReportStrategy.PERIOD);
            // 10�����ϱ�һ�ε�����
            StatConfig.setSendPeriodMinutes(10);
        }

        // ��ʼ��java crash����
        StatCrashReporter.getStatCrashReporter(getApplicationContext()).setJavaCrashHandlerStatus(true);
        // ��ʼ��native crash���񣬼ǵø���so�ļ�
        StatCrashReporter.getStatCrashReporter(getApplicationContext()).setJniNativeCrashStatus(true);
        // crash�Ļص����������Ҫ���
        StatCrashReporter.getStatCrashReporter(getApplicationContext()).addCrashCallback(new StatCrashCallback() {

            @Override
            public void onJniNativeCrash(String tombstoneMsg) {
                Log.d("Test", "Native crash happened, tombstone message:" + tombstoneMsg);
            }

            @Override
            public void onJavaCrash(Thread thread, Throwable throwable) {
                Log.d("Test", "Java crash happened, thread: " + thread + ",Throwable:" + throwable.toString());
            }
        });

    }*/
}
