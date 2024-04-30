package com.bootcamp51.microservicios.commissionservicebatch.consumer;

import com.bootcamp51.microservicios.commissionservicebatch.producer.ProducerKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Service;

@Service
public class ConsumerKafka {

  @Autowired
  private ProducerKafka producerKafka;

  @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
  public void listen(String message) {

    System.out.printf(message);
    producerKafka.produce(message);


  }


}
