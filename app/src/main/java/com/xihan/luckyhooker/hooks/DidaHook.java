package com.xihan.luckyhooker.hooks;

import com.xihan.luckyhooker.Hook;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class DidaHook implements Hook {


    public static final String hookPackageName = "cn.ticktick.task";

    @Override
    public void startHook(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("start Hook 滴答清单:" + lpparam.packageName);

        XposedHelpers.findAndHookMethod(
                "com.ticktick.task.data.User"//要hook的应用类名
                , lpparam.classLoader,
                "wwwWWWwwWWWWWw"//要hook的方法
                //,String.class//函数名，可以注释掉,String就是String.class
                , new XC_MethodHook()//回调
                {@Override
                protected void afterHookedMethod(MethodHookParam 参数) throws Throwable {//拦截之后要做什么
                    super.afterHookedMethod(参数);
                    参数.setResult(true);////强制返回boolean为true
                }});}


    @Override
    public void startHook(XC_InitPackageResources.InitPackageResourcesParam resparam) throws Throwable {
    }

    @Override
    public boolean canHook(String packageName) {
        return hookPackageName.equals(packageName);
    }




}
