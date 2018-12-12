package com.liuhjhj.wechatscan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.service.quicksettings.TileService;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Tile extends TileService {
    public Tile(){
        super();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onTileAdded() {
        super.onTileAdded();
        android.service.quicksettings.Tile tile = getQsTile();
    }

    @Override
    public void onTileRemoved() {
        super.onTileRemoved();
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        android.service.quicksettings.Tile tile = getQsTile();
    }

    @Override
    public void onStopListening() {
        super.onStopListening();
    }

    @Override
    public void onClick() {
        sendBroadcast(new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
        openWeixinToQECode(getBaseContext());
    }

    public void openWeixinToQECode(Context context) {
        try {
            Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            context.startActivity(intent);

        } catch (Exception e) {
            Toast.makeText(this,"无法打开,可能是未安装微信",Toast.LENGTH_SHORT).show();
        }
    }
}


