package com.mqtt.simple;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class PublisherTCP {
    public static void main(String[] args) throws Exception {
        System.out.println("== START PUBLISHER ==");

        String broker = "tcp://test.mosquitto.org";

        MqttClient client = new MqttClient(broker, MqttClient.generateClientId());
        client.connect();

        String content = "Hello!";
        if (args.length == 2 ) {
            content = args[1];
        }
        MqttMessage message = new MqttMessage();
        message.setPayload(content.getBytes());

        client.publish("test", message);

        client.disconnect();

        System.out.println("== STOP PUBLISHER ==");
    }
}
