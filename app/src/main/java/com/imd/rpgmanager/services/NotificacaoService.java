package com.imd.rpgmanager.services;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.imd.rpgmanager.MainActivity;

public class NotificacaoService extends IntentService {

    public static final String MSG = "personagem_criado";

    public static final String CHANNEL_ID = "5463";
    public static final int NOTIFICATION_ID = 5463;

    public NotificacaoService(){
        super("NotificacaoService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String mensagem = intent.getExtras().getString(MSG);
        showNotification(mensagem);

    }

    public void showNotification(String mensagem){

        this.criarCanalNotificacao();

        NotificationCompat.Builder noteBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Novo personagem criado!")
                .setContentText(mensagem)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[] {0, 1000})
                .setAutoCancel(true)
                .setSmallIcon(android.R.drawable.sym_def_app_icon);

        Intent acaoAoClicarNaNotificacao = new Intent(this, MainActivity.class);

        PendingIntent acaoPendente = PendingIntent.getActivity(
                this,
                0,
                acaoAoClicarNaNotificacao,
                PendingIntent.FLAG_UPDATE_CURRENT);

        noteBuilder.setContentIntent(acaoPendente);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, noteBuilder.build());

    }

    private void criarCanalNotificacao(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            CharSequence name = "meu_canal";
            String description = "canalParaNotificacoes";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(this.CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }

}
