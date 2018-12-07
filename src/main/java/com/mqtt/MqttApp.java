package com.mqtt;

import com.mqtt.simple.PublisherSSL;
import com.mqtt.simple.SubscriberSSL;

/**
 * Basic launcher for PublisherSSL and SubscriberSSL
 */
public class MqttApp {

  public static void main(String[] args) throws Exception {

    if (args.length < 1) {
      throw new IllegalArgumentException("Must have either 'publisher' or 'subscriber' as argument");
    }
    switch (args[0]) {
      case "publisher":
        PublisherSSL.main(args);
        break;
      case "subscriber":
        SubscriberSSL.main(args);
        break;
      default:
        throw new IllegalArgumentException("Don't know how to do " + args[0]);
    }
  }
}

