package com.example.projectboard.Firebase;

import com.example.projectboard.Model.PushNotificationRequest;
import com.google.firebase.messaging.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public
class FCMService {

    private final Logger logger = LoggerFactory.getLogger(FCMService.class);

    private static String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
        return FirebaseMessaging.getInstance().sendAsync(message).get();
    }

    private static ApnsConfig getApnsConfig(String topic) {
        return ApnsConfig.builder()
                .setAps(Aps.builder().setCategory(topic).setThreadId(topic).build()).build();
    }

    private static AndroidConfig getAndroidConfig(String topic) {
        return AndroidConfig.builder()
                .setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey(topic)
                .setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(AndroidNotification.builder().setSound("default")
                        .setColor("#FFFF00").setTag(topic).build()).build();
    }

    private static Message.Builder getPreconfiguredMessageBuilder(PushNotificationRequest request) {
        AndroidConfig androidConfig = FCMService.getAndroidConfig(request.getTopic());
        ApnsConfig apnsConfig = FCMService.getApnsConfig(request.getTopic());
        return Message.builder()
                .setApnsConfig(apnsConfig).setAndroidConfig(androidConfig).setNotification(
                        new Notification(request.getTitle(), request.getMessage()));
    }

    private static Message getPreconfiguredMessageToToken(PushNotificationRequest request) {
        return FCMService.getPreconfiguredMessageBuilder(request).setToken(request.getToken())
                .build();
    }

    private static Message getPreconfiguredMessageWithoutData(PushNotificationRequest request) {
        return FCMService.getPreconfiguredMessageBuilder(request).setTopic(request.getTopic())
                .build();
    }

    private static Message getPreconfiguredMessageWithData(Map<String, String> data, PushNotificationRequest request) {
        return FCMService.getPreconfiguredMessageBuilder(request).putAllData(data).setTopic(request.getTopic())
                .build();
    }

    public void sendMessage(Map<String, String> data, PushNotificationRequest request)
            throws InterruptedException, ExecutionException {
        Message message = FCMService.getPreconfiguredMessageWithData(data, request);
        String response = FCMService.sendAndGetResponse(message);
        logger.info("Sent message with data. Topic: " + request.getTopic() + ", " + response);
    }

    public void sendMessageWithoutData(PushNotificationRequest request)
            throws InterruptedException, ExecutionException {
        Message message = FCMService.getPreconfiguredMessageWithoutData(request);
        String response = FCMService.sendAndGetResponse(message);
        logger.info("Sent message without data. Topic: " + request.getTopic() + ", " + response);
    }

    public void sendMessageToToken(PushNotificationRequest request)
            throws InterruptedException, ExecutionException {
        Message message = FCMService.getPreconfiguredMessageToToken(request);
        String response = FCMService.sendAndGetResponse(message);
        logger.info("Sent message to token. Device token: " + request.getToken() + ", " + response);
    }

}
